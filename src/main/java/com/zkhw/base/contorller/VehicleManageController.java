package com.zkhw.base.contorller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.util.StringUtil;
import com.zkhw.base.entity.VehicleManage;
import com.zkhw.base.mo.VehicleMo;
import com.zkhw.base.query.VehicleQuery;
import com.zkhw.base.service.VehicleManagerService;
import com.zkhw.base.util.BaiduUtile;
import com.zkhw.base.vo.NetworkVehicleVo;
import com.zkhw.base.vo.VehicleVo;
import com.zkhw.common.utils.CodeUtil;
import com.zkhw.common.utils.SystemParam;
import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.framework.utils.JsonConverter;
import com.zkhw.framework.utils.JsonWebPrintUtils;
import com.zkhw.ltd.entity.Organization;
import com.zkhw.ltd.entity.User;
import com.zkhw.ltd.service.OrganizationService;
import com.zkhw.ltd.service.UserService;

@Controller
@RequestMapping("/base/vehicle")
public class VehicleManageController {

	@Autowired
	private VehicleManagerService vehicleManagerService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrganizationService organizationService;
	
	
	/**
	 * 分页展示
	 */
	@ResponseBody
	@RequestMapping(value = "/vehicleByPage", method = RequestMethod.GET)
	public PageInfos<VehicleManage>  vehicleByPage(VehicleManage vehicleManage, PageInfos<VehicleManage> pageData){
		pageData = vehicleManagerService.vehicleByPage(vehicleManage, pageData);
		return pageData;
		
	}
	
	/**
	 * 修改车辆信息
	 */
	@RequestMapping(value = "/updateVehicle", method = RequestMethod.POST)
	public void updateVehicle(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,VehicleManage vehicleManage){
		try {
			vehicleManagerService.updateVehicle(vehicleManage);
			result.setData(null);
			result.setCode("0");
			result.setMsg("成功");
		} catch (Exception e) {
			result.setCode("1");
			result.setMsg("失败");
		}
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}
	
	
	
	/**
	 * 保存车辆信息
	 */
	@RequestMapping(value = "/saveVehicle", method = RequestMethod.POST)
	public void saveVehicle(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,VehicleManage vehicleManage){
		try {
			String loginName = SystemParam.getUserId();
			User user = userService.findUserByLoginName(loginName);
			vehicleManage.setId(CodeUtil.getUUID());
			if(user != null) {
				/*Organization org = organizationService.getOrganizationByCode(user.getOrganCode());
				if(org != null) {
					//vehicleManage.setProvinceCode(org.getProvinceCode());
					//vehicleManage.setProvinceName(org.getProvinceName());
					//vehicleManage.setCityCode(org.getCityCode());
					//vehicleManage.setCityName(org.getCityName());
					//vehicleManage.setCountyCode(org.getCountyCode());
					//vehicleManage.setCountyName(org.getCountyName());
					//vehicleManage.setTownsCode(org.getTownsCode());
					//vehicleManage.setTownsName(org.getTownsName());
					//vehicleManage.setVillageCode(villageCode);
					//vehicleManage.setVillageName(villageName);	
					//vehicleManage.setOrganCode(org.getOrganCode());
					//vehicleManage.setOrganName(org.getOrganName());
					
				}*/
				vehicleManage.setCreateName(user.getUserName());
				vehicleManage.setCreateTime(new Date());
				vehicleManage.setUpdateName(user.getUpdateUserCode());
				vehicleManage.setUpdateTime(new Date());
				
				
				
				
			}
			vehicleManagerService.saveVehicle(vehicleManage);
			result.setCode("0");
			result.setMsg("成功");
		} catch (Exception e) {
			result.setCode("1");
			result.setMsg("失败");
		}
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}
	
	
	/**
	 * 删除车辆信息
	 * 
	 */
	@RequestMapping(value = "/deleteVehicle", method = RequestMethod.GET)
	public void deleteVehicle(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,VehicleManage vehicleManage){
		try {
			String id = vehicleManage.getId();
			if(!StringUtil.isEmpty(id)) {
				vehicleManagerService.deleteVehicle(vehicleManage);
				result.setCode("0");
				result.setMsg("成功");
			}else {
				result.setCode("1");
				result.setMsg("失败");
			}
		} catch (Exception e) {
			result.setCode("1");
			result.setMsg("删除异常");
		}
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}
	
	
	/**
	 * 车辆详情信息
	 * 
	 */
	@RequestMapping(value = "/vehicleByCode", method = RequestMethod.GET)
	public void vehicleByCode(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,VehicleManage vehicleManage){
		try {
			VehicleManage VehicleManage = vehicleManagerService.vehicleByCode(vehicleManage);
			result.setData(VehicleManage);
			result.setCode("0");
			result.setMsg("查询成功");
		} catch (Exception e) {
			result.setCode("1");
			result.setMsg("查询异常");
		}
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}
	
	
	/**
	 * 判断是否为车联网车辆
	 */
	@RequestMapping(value = "/isNetworkVehicle", method = RequestMethod.GET)
	public void isNetworkVehicle(HttpServletRequest request, HttpServletResponse response,ApiJsonResult result,VehicleQuery query){
		try {

			
			String token = "1";
			String carId = query.getCarId();
			
			String url = "http://211.94.119.53:19007/openapi/iov/business/vehicle/isNetworkVehicle.json";
			String param = "token=" +  token + "&vin=" + carId;
			
			String s = sendGet(url,param);
			if(!StringUtil.isEmpty(s)) {
				ApiJsonResult aj = JsonConverter.json2Obj(s,ApiJsonResult.class);
				String data = aj.getData().toString();
				NetworkVehicleVo networkVehicleVo = JsonConverter.json2Obj(data,NetworkVehicleVo.class);
				
				//1：车联网车辆，0：非车联网车辆
				//String networkVehicle = networkVehicleVo.getNetworkVehicle();
				//String lastTime = networkVehicleVo.getLastTime();//最后上传数据时间
			
				
				result.setData(networkVehicleVo);
				result.setCode("0");
				result.setMsg("成功");
			}
			
		} catch (Exception e) {
			result.setCode("1");
			result.setMsg("失败");
		}
		JsonWebPrintUtils.printApiResult(request, response, result);
	}
	
	
	/**
	 *  添加(修改)转发车辆
	 */
	@RequestMapping(value = "/addVehicle", method = RequestMethod.GET)
	public void addVehicle(HttpServletRequest request, HttpServletResponse response,ApiJsonResult result,VehicleQuery query){
		try {

			String token = "dcc035eda0ff4606af8b38fd1eb33677";
			String carId = query.getCarId();//车架号
			String uid = "";//用户
			String expiryDate = "";//截止日期  格式：(yyyy-MM-dd HH:mm:ss)
			
			String url = "http://211.94.119.53:19007/openapi/iov/forward/vehicle/add.json";
			String param = "token=" +  token + "&uid=" + uid + "&vin=" + carId + "&expiryDate" + expiryDate;
			
			String s = sendGet(url,param);
			if(!StringUtil.isEmpty(s)) {
				ApiJsonResult aj = JsonConverter.json2Obj(s,ApiJsonResult.class);
				String data = aj.getData().toString();
				NetworkVehicleVo networkVehicleVo = JsonConverter.json2Obj(data,NetworkVehicleVo.class);
				
				//1：车联网车辆，0：非车联网车辆
				//String networkVehicle = networkVehicleVo.getNetworkVehicle();
				//String lastTime = networkVehicleVo.getLastTime();//最后上传数据时间
			
				
				result.setData(networkVehicleVo);
				result.setCode("0");
				result.setMsg("成功");
			}
			
		} catch (Exception e) {
			result.setCode("1");
			result.setMsg("失败");
		}
		JsonWebPrintUtils.printApiResult(request, response, result);
	}
	
	
	
	
	
	
	/**
	 * 车联网--当前位置信息 (小程序) 不用了
	 */
	@RequestMapping(value = "/appNowVehicle", method = RequestMethod.GET)
	public void appNowVehicle(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,VehicleQuery query){
		try {

			String token = "dcc035eda0ff4606af8b38fd1eb33677";
			String carId = query.getCarId();
			
			String url = "http://211.94.119.53:19007/api/location/getLocationByCarId.json";
			String param = "token=" +  token + "&carId=" + carId;
			
			String s = sendGet(url,param);
			VehicleMo vehicleMo = null;
			if(!StringUtil.isEmpty(s)) {
				ApiJsonResult aj = JsonConverter.json2Obj(s,ApiJsonResult.class);
				String data = aj.getData().toString();
				VehicleVo vehicleVo = JsonConverter.json2Obj(data,VehicleVo.class);
				
				String longitude = vehicleVo.getLongitude();
				String latitude = vehicleVo.getLatitude();
				String sendTime = vehicleVo.getSendTime();
				
				//根据经纬度获取地址
				String address = BaiduUtile.getLocationByBaiduMap(longitude, latitude);
				
				vehicleMo = new VehicleMo();
				vehicleMo.setAddress(address);
				vehicleMo.setSendTime(sendTime);
				
				result.setData(vehicleMo);
				result.setCode("0");
				result.setMsg("成功");
			}
			
		} catch (Exception e) {
			result.setCode("1");
			result.setMsg("失败");
		}
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}
	
	
	/**
	 * 历史位置信息  ---(小程序)  不用了
	 * token = "dd04ee9a70754cfaa8cd94bbec80507e";
	 * carId = "LVBV3JBB5KY017515";
	 */
	@RequestMapping(value = "/appShowVehicle", method = RequestMethod.GET)
	public void appShowVehicle(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,VehicleQuery query){
		try {

			String token = "dcc035eda0ff4606af8b38fd1eb33677";
			String carId = query.getCarId();
			String dayTime = query.getDayTime();
			
			
			String url = "http://211.94.119.53:19007/api/location/getHisLocationByCarId.json";
			String param = "token=" +  token + "&carId=" + carId + "&dayTime=" + dayTime;
			String s = sendGet(url,param);
			
			VehicleMo vehicleMo = null;
			if(!StringUtil.isEmpty(s)) {
				ApiJsonResult aj = JsonConverter.json2Obj(s,ApiJsonResult.class);
				String data = aj.getData().toString();
				ArrayList<VehicleMo> vehicleMoList = new ArrayList<VehicleMo>();
				
				List<VehicleVo> veList = JsonConverter.json2ObjList(data,VehicleVo.class);
				VehicleVo vehicleVo = null;
				for (int i = 0; i < veList.size(); i++) {
					vehicleVo = veList.get(i);
					vehicleMo = new VehicleMo();
					String latitude = vehicleVo.getLatitude();
					String longitude = vehicleVo.getLongitude();
					String address = BaiduUtile.getLocationByBaiduMap(longitude, latitude);
					if(!StringUtil.isEmpty(address)) {
						vehicleMo.setAddress(address);
					}
					String sendTime = vehicleVo.getSendTime();
					vehicleMo.setSendTime(sendTime);
					vehicleMoList.add(vehicleMo);
					
				}
				
				result.setData(vehicleMoList);
				result.setCode("0");
				result.setMsg("成功");
			}
			
			
			
			
			result.setData(s);
			result.setCode("0");
			result.setMsg("成功");
		} catch (Exception e) {
			result.setCode("1");
			result.setMsg("失败");
		}
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}
	
	
	
	
	
	
	/**
	 * 车联网--当前位置信息     不用了
	 * token = "dd04ee9a70754cfaa8cd94bbec80507e";
	 * carId = "LVBV3JBB5KY017515";
	 */
	@RequestMapping(value = "/nowVehicle", method = RequestMethod.GET)
	public void nowVehicle(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,VehicleQuery query){
		try {

			String token = "dcc035eda0ff4606af8b38fd1eb33677";
			String carId = query.getCarId();
			
			String url = "http://211.94.119.53:19007/api/location/getLocationByCarId.json";
			String param = "token=" +  token + "&carId=" + carId + "&maxOfflineTime=" + "999999999";
			//String param = "token=token&carId=carId&startTime=startTime&endTime=endTime";
			//sendGet(url,"token=您的token&carId=LRDS6PEB5JL604918&startTime=2018-10-01&endTime=2018-10-01");
			String s = sendGet(url,param);
			ApiJsonResult aj = JsonConverter.json2Obj(s,ApiJsonResult.class);
			
			String data = aj.getData().toString();
			VehicleVo ve = JsonConverter.json2Obj(data, VehicleVo.class);
		
			result.setData(ve);
			result.setCode("0");
			result.setMsg("成功");
		} catch (Exception e) {
			result.setCode("1");
			result.setMsg("失败");
		}
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}
	
	
	
	
	/**
	 * 车联网--车辆网历史位置信息     不用了
	 * token = "dd04ee9a70754cfaa8cd94bbec80507e";
	 * carId = "LVBV3JBB5KY017515";
	 */
	@RequestMapping(value = "/showVehicle", method = RequestMethod.GET)
	public void saveResident(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,VehicleQuery query){
		try {

			String token = "dcc035eda0ff4606af8b38fd1eb33677";
			String carId = query.getCarId();
			String dayTime = query.getDayTime();
			
			
			String url = "http://211.94.119.53:19007/api/location/getHisLocationByCarId.json";
			String param = "token=" +  token + "&carId=" + carId + "&dayTime=" + dayTime;
			//String param = "token=token&carId=carId&startTime=startTime&endTime=endTime";
			//sendGet(url,"token=您的token&carId=LRDS6PEB5JL604918&startTime=2018-10-01&endTime=2018-10-01");
			String s = sendGet(url,param);
			
			ApiJsonResult aj = JsonConverter.json2Obj(s,ApiJsonResult.class);
			
			String data = aj.getData().toString();
			List<VehicleVo> veList = JsonConverter.json2ObjList(data,VehicleVo.class);
			
			result.setData(veList);
			result.setCode("0");
			result.setMsg("成功");
		} catch (Exception e) {
			result.setCode("1");
			result.setMsg("失败");
		}
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}
	
	
	
	/**
	 * 调用车辆网接口
	 * @param map
	 * @return
	 */
	public static String sendGet(String url, String param) {
        String result = "";
        String urlName = url + "?" + param;
        try {
            URL realURL = new URL(urlName);
            URLConnection conn = realURL.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36");
            conn.connect();
            Map<String, List<String>> map = conn.getHeaderFields();
            for (String s : map.keySet()) {
                System.out.println(s + "-->" + map.get(s));
            }
           // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += "\n" + line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

	 

}
