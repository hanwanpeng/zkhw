package com.zkhw.pub.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkhw.code.entity.AreaConfig;
import com.zkhw.common.utils.CodeUtil;
import com.zkhw.common.utils.CommonUtil;
import com.zkhw.common.utils.SystemParam;
import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.framework.utils.DateUtil;
import com.zkhw.framework.utils.JsonWebPrintUtils;
import com.zkhw.ltd.entity.Organization;
import com.zkhw.ltd.entity.User;
import com.zkhw.ltd.service.OrganizationService;
import com.zkhw.ltd.service.UserService;
import com.zkhw.pub.entity.ResidentBaseInfo;
import com.zkhw.pub.mo.ResidentMo;
import com.zkhw.pub.query.ResidentBaseInfoQuery;
import com.zkhw.pub.service.ResidentBaseInfoService;
import com.zkhw.pub.vo.ResidentVo;;

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
