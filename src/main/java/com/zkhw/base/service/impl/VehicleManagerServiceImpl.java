package com.zkhw.base.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.zkhw.base.dao.VehicleManageDao;
import com.zkhw.base.entity.VehicleManage;
import com.zkhw.base.query.VehicleQuery;
import com.zkhw.base.service.VehicleManagerService;
import com.zkhw.base.vo.NetworkVehicleVo;
import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.framework.utils.JsonConverter;

@Service
public class VehicleManagerServiceImpl implements VehicleManagerService {

	@Autowired
	private VehicleManageDao vehicleManageDao;
	
	/**
	 * 保存车辆信息
	 */
	@Override
	public void saveVehicle(VehicleManage vehicleManage) {
		vehicleManageDao.insertSelective(vehicleManage);
	}

	/**
	 * 修改车辆信息
	 */
	@Override
	public void updateVehicle(VehicleManage vehicleManage) {
		vehicleManageDao.updateByPrimaryKeySelective(vehicleManage);
		
	}

	/**
	 * 分页展示
	 */
	@Override
	public PageInfos<VehicleManage> vehicleByPage(VehicleManage vehicleManage, PageInfos<VehicleManage> pageData) {
		PageHelper.startPage( (int)pageData.getPage(), (int)pageData.getPageSize());//page, pageSize
		List<VehicleManage> list = vehicleManageDao.vehicleByPage(vehicleManage);
		PageInfo<VehicleManage> page = new PageInfo<VehicleManage>(list);
		pageData.setPage(page.getPageNum());      //当前页码
		pageData.setPageCount(page.getPages());   //总页数
		pageData.setPageSize(page.getPageSize()); //每页记录数
		pageData.setTotal(page.getTotal());       //总记录数
		pageData.setRows(page.getList());
		return pageData;
		
	}

	/**
	 * 删除车辆信息
	 */
	@Override
	public void deleteVehicle(VehicleManage vehicleManage) {
		String id = vehicleManage.getId();
		vehicleManageDao.deleteByPrimaryKey(id);
		
	}

	
	@Override
	public VehicleManage vehicleByCode(VehicleManage vehicleManage) {
		String id = vehicleManage.getId();
		VehicleManage vehicle = vehicleManageDao.selectByPrimaryKey(id);
		return vehicle;
	}

	
	/**
	 * 判断是否为车联网车辆
	 */
	@Override
	public NetworkVehicleVo isNetworkVehicle(VehicleQuery query) {
		String token = "1";
		String carId = query.getCarId();
		
		String url = "http://211.94.119.53:19007/openapi/iov/business/vehicle/isNetworkVehicle.json";
		String param = "token=" +  token + "&vin=" + carId;
		
		String s = sendGet(url,param);
		NetworkVehicleVo networkVehicleVo = null;
		if(!StringUtil.isEmpty(s)) {
			ApiJsonResult aj = JsonConverter.json2Obj(s,ApiJsonResult.class);
			String data = aj.getData().toString();
			networkVehicleVo = JsonConverter.json2Obj(data,NetworkVehicleVo.class);
			
			//1：车联网车辆，0：非车联网车辆
			//String networkVehicle = networkVehicleVo.getNetworkVehicle();
			//String lastTime = networkVehicleVo.getLastTime();//最后上传数据时间
		
		}
		return networkVehicleVo;
		
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
