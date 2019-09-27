package com.zkhw.pub.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkhw.code.entity.AreaConfig;
import com.zkhw.common.utils.CodeUtil;
import com.zkhw.common.utils.CommonUtil;
import com.zkhw.common.utils.ExcelUtil;
import com.zkhw.common.utils.SystemParam;
import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.framework.utils.DateUtil;
import com.zkhw.framework.utils.JsonWebPrintUtils;
import com.zkhw.ltd.entity.Organization;
import com.zkhw.ltd.entity.User;
import com.zkhw.ltd.service.OrganizationService;
import com.zkhw.ltd.service.UserService;
import com.zkhw.pub.dao.ResidentBaseInfoDao;
import com.zkhw.pub.entity.ResidentBaseInfo;
import com.zkhw.pub.mo.ResidentMo;
import com.zkhw.pub.query.ResidentBaseInfoQuery;
import com.zkhw.pub.service.ResidentBaseInfoService;
import com.zkhw.pub.vo.ResidentVo;
import com.zkhw.stat.query.ResidentQuery;
import com.zkhw.stat.service.StatisticsService;
import com.zkhw.stat.vo.ExaminationVo;
import com.zkhw.stat.vo.GravidaVo;
import com.zkhw.stat.vo.ResidentAgeVo;
import com.zkhw.stat.vo.StatResidentVo;

import ch.qos.logback.core.joran.util.beans.BeanUtil;;

@Controller
@RequestMapping("/pub/resident")
public class ResidentBaseInfoController {

	@Autowired
	private ResidentBaseInfoService residentBaseInfoService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private CommonUtil commonUtil;
	
	@Autowired
	private ResidentBaseInfoDao residentBaseInfoDao;
	
	@Autowired
	private StatisticsService statisticsService;
	/**
	 * 汇总表花名册
	 * @param redident
	 * @param pageData
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/allForExcel", method = RequestMethod.GET)
	public void allForExcel(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result,ResidentBaseInfoQuery resident) {
		
		
			// 表头
			ArrayList<String> headerList = new ArrayList<String>();
			/*String[] header = { "人口总数", "贫困户总人数", "家庭签约人数", "贫困户签约人数", "高血压人数", "糖尿病人数", "肺结核人数", "精神病人数", "2019年体检人数",
					"26岁—64岁体检人数", "65岁以上老年人体检人数", "贫困户体检人数", "贫困户患慢病人员人数", "重点人群总人数", "残疾人数", "0—6岁儿童人数", "7岁--25岁总人数",
					"26岁--64岁总人数", "65岁以上老年人总数", "孕产妇总数" };*/
			String[] header = { "人口总数", "0-6岁总人数", "7-25岁总人数", "26-64岁总人数", "65岁及以上总人数","2019年体检","65岁以上老年人体检","26岁—64岁体检","贫困户体检","贫困户患慢病人员", "贫困户总人数", "高血压人数", "糖尿病人数", "结核病人数",
					"精神病人数", "残疾人数","孕产妇人数"};
			for (int i = 0; i < header.length; i++) {
				headerList.add(header[i]);
			}
			// 行内容
			ArrayList<List<String>> rowList = new ArrayList<List<String>>();
			String title = "汇总表查询列表";
			String sheetName = "汇总表花名册";

			ArrayList<String> row = new ArrayList<String>();
			
			ResidentQuery query = new ResidentQuery();
			BeanUtils.copyProperties(resident, query);
			ResidentAgeVo residentAgeVo = statisticsService.statForAge(query);
			if(residentAgeVo != null) {
				List<ResidentBaseInfo> total = residentBaseInfoDao.statForAge(query);
				row.add(String.valueOf(total.size()).toString());//总人数
				//0-6岁总人数
				Integer totalSixAgeNum = residentAgeVo.getTotalSixAgeNum();
				if(totalSixAgeNum != null) {
					row.add(totalSixAgeNum.toString());
				}else {
					row.add("0");
				}
				//7-25岁总人数
				Integer totalTwentyFiveAgeNum = residentAgeVo.getTotalTwentyFiveAgeNum();
				if(totalTwentyFiveAgeNum != null) {
					row.add(totalTwentyFiveAgeNum.toString());
				}else {
					row.add("0");
				}
				//26-64岁总人数
				Integer totalSixtyFourAgeNum = residentAgeVo.getTotalSixtyFourAgeNum();
				if(totalSixtyFourAgeNum != null) {
					row.add(totalSixtyFourAgeNum.toString());
				}else {
					row.add("0");
				}
				//65岁及以上总人数
				Integer totalSixtyFiveAgeNum = residentAgeVo.getTotalSixtyFiveAgeNum();
				if(totalSixtyFiveAgeNum != null) {
					row.add(totalSixtyFiveAgeNum.toString());
				}else {
					row.add("0");
				}
			}
			
			ExaminationVo examination = residentBaseInfoDao.statForExamination(query);
			if(examination != null) {
				Integer examinationNum = examination.getExaminationNum();//2019年体检	
				if(examinationNum != null) {
					row.add(examinationNum.toString());
				}else {
					row.add("0");
				}
				Integer elderlyYet = examination.getElderlyYet();//65岁以上老年人体检
				if(examinationNum != null) {
					row.add(elderlyYet.toString());
				}else {
					row.add("0");
				}
				Integer twentySixNum = examination.getTwentySixNum();//26岁—64岁体检
				if(examinationNum != null) {
					row.add(twentySixNum.toString());
				}else {
					row.add("0");
				}
				Integer poorExamNum = examination.getPoorExamNum();//贫困户体检
				if(examinationNum != null) {
					row.add(poorExamNum.toString());
				}else {
					row.add("0");
				}
				Integer poorAndDiseaseNum = examination.getPoorAndDiseaseNum();//贫困户患慢病人员
				if(examinationNum != null) {
					row.add(poorAndDiseaseNum.toString());
				}else {
					row.add("0");
				}
				
			}
			
			StatResidentVo statResidentVo = statisticsService.statForSpecialMan(query);
			if(statResidentVo != null) {
				//贫困人数
				Integer poorNum = statResidentVo.getPoorNum();
				if(poorNum != null) {
					row.add(poorNum.toString());
				}else {
					row.add("0");
				}
				//高血压人数
				Integer hypertensionNum = statResidentVo.getHypertensionNum();
				if(hypertensionNum != null) {
					row.add(hypertensionNum.toString());
				}else {
					row.add("0");
				}
				//糖尿病
				Integer diabetesNum = statResidentVo.getDiabetesNum();
				if(diabetesNum != null) {
					row.add(diabetesNum.toString());
				}else {
					row.add("0");
				}
				//结核病人数
				Integer tuberculosisNum = statResidentVo.getTuberculosisNum();
				if(tuberculosisNum != null) {
					row.add(tuberculosisNum.toString());
				}else {
					row.add("0");
				}
				//精神病人数
				Integer psychosisNum = statResidentVo.getPsychosisNum();
				if(psychosisNum != null) {
					row.add(psychosisNum.toString());
				}else {
					row.add("0");
				}
				//残疾人数
				Integer deformityNum = statResidentVo.getDeformityNum();
				if(deformityNum != null) {
					row.add(statResidentVo.getDeformityNum().toString());//残疾人数
				}else {
					row.add("0");//残疾人数
				}
				
			}
			
			GravidaVo gravidaVo = statisticsService.statForGravida(query);
			if(gravidaVo != null) {
				//孕产妇人数
				Integer gravidaInfoNum = gravidaVo.getGravidaInfoNum();
				if(gravidaInfoNum != null) {
					row.add(gravidaInfoNum.toString());
				}else {
					row.add("0");
				}
			}
		
			
			

			rowList.add(row);
			// 输出excel到浏览器
			response.setContentType("application/msexcel");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE");
			response.setHeader("Access-Control-Allow-Headers",
					"Access-Control-Allow-Origin, Access-Control-Allow-Methods, Access-Control-Max-Age, X-Auth-Token, Content-Type, Accept");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			OutputStream out = null;

			try {
				out = response.getOutputStream();// 取得输出流
				response.reset();// 清空输出流
				String filename = title + ".xls";
				filename = new String(filename.getBytes("gb2312"), "ISO8859-1");
				response.setHeader("Content-disposition", "attachment; filename=" + filename);// 设定输出文件头
				ExcelUtil excelUtil = new ExcelUtil();
				excelUtil.writeExcelWithMultiSheet(headerList, rowList, out, sheetName);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (out != null) {
					try {
						out.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}

	}
	
	/**
	 * 健康体检花名册
	 * @param redident
	 * @param pageData
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/physicalForExcel", method = RequestMethod.GET)
	public void physicalForExcel(HttpServletRequest request, HttpServletResponse response,ApiJsonResult result,ResidentBaseInfoQuery resident){
			residentBaseInfoService.physicalForExcel(request, response, result, resident);
	}
	
	/**
	 * 26-64岁花名册
	 * @param redident
	 * @param pageData
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/minElderlyForExcel", method = RequestMethod.GET)
	public void minElderlyForExcel(HttpServletRequest request, HttpServletResponse response,ApiJsonResult result,ResidentBaseInfoQuery resident){
			residentBaseInfoService.minElderlyForExcel(request, response, result, resident);
	}
	
	/**
	 * 65岁老年人花名册
	 * @param redident
	 * @param pageData
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/elderlyForExcel", method = RequestMethod.GET)
	public void elderlyForExcel(HttpServletRequest request, HttpServletResponse response,ApiJsonResult result,ResidentBaseInfoQuery resident){
			residentBaseInfoService.elderlyForExcel(request, response, result, resident);
	}
	
	
	/**
	 * 人口花名册
	 * @param redident
	 * @param pageData
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/residentBaseInfoForExcel", method = RequestMethod.GET)
	public void residentBaseInfoForExcel(HttpServletRequest request, HttpServletResponse response,ApiJsonResult result,ResidentBaseInfoQuery resident){
			residentBaseInfoService.residentBaseInfoForExcel(request, response, result, resident);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void  findResidentList(HttpServletRequest req, HttpServletResponse resp, ResidentBaseInfoQuery info, PageInfos<ResidentBaseInfo> pageData){
		pageData = residentBaseInfoService.findResidentByPage(info, pageData);
		JsonWebPrintUtils.printApiResult(req, resp, pageData);
		
	}
	
	/**
	 * 展示居民健康档案
	 */
	@RequestMapping(value = "/showResident", method = RequestMethod.GET)
	public void showResident(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,ResidentBaseInfoQuery query){
		try {
			ResidentMo ResidentMo = residentBaseInfoService.showResident(query);
			result.setData(ResidentMo);
			result.setCode("0");
			result.setMsg("成功");
		} catch (Exception e) {
			result.setCode("1");
			result.setMsg("失败");
		}
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}
	
	
	/**
	 * 添加居民健康档案
	 * @param info
	 * @param pageData
	 * @return
	 */
	@RequestMapping(value = "/saveResident", method = RequestMethod.POST)
	public void saveResident(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,ResidentVo vo){
		try {
			String uuid = CodeUtil.getUUID();
			vo.setId(uuid);
			String loginName = SystemParam.getUserId();
			User user = userService.findUserByLoginName(loginName);
			if(user != null){
				vo.setCreateUser(user.getUserCode());
				vo.setCreateName(user.getUserName());

				vo.setCreateOrg(user.getOrganCode());
				//vo.setCreateOrgName(user.geto);
				
				vo.setUpdateUser(user.getUserCode());
				vo.setUpdateName(user.getUserName());	
				
				Organization org = organizationService.getOrganizationByCode(user.getOrganCode());
				if(org != null){
					vo.setCreateOrgName(org.getOrganName());
					vo.setAichiveOrg(org.getOrganName());
				}
			}
			
			if(vo.getTownsCode() != null){
				AreaConfig  towns = commonUtil.getAreaByCode(vo.getTownsCode());
				vo.setTownsName(towns.getName());
			}
			
			if(vo.getVillageCode() != null){
				AreaConfig  village = commonUtil.getAreaByCode(vo.getVillageCode());
				vo.setVillageName(village.getName());
			}			
			vo.setIsSynchro(0);
			vo.setAge(DateUtil.getAge(vo.getBirthday()));
			residentBaseInfoService.saveResident(vo);
			result.setCode("0");
			result.setMsg("成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("失败");
		}
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}	
	
	@RequestMapping(value = "/updateResident", method = RequestMethod.POST)
	public void updateResident(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,ResidentVo vo){
		try {
			String loginName = SystemParam.getUserId();
			User user = userService.findUserByLoginName(loginName);
			if(user != null){				
				vo.setUpdateUser(user.getUserCode());
				vo.setUpdateName(user.getUserName());	
				vo.setUpdateTime(new Date());
			}			
			vo.setAge(DateUtil.getAge(vo.getBirthday()));
			residentBaseInfoService.updateResident(vo);
			result.setCode("0");
			result.setMsg("成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("失败");
		}
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}
	
}
