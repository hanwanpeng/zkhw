package com.zkhw.ltd.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.util.StringUtil;
import com.zkhw.common.utils.CommonUtil;
import com.zkhw.common.utils.SystemParam;
import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.framework.utils.JsonWebPrintUtils;
import com.zkhw.ltd.entity.Organization;
import com.zkhw.ltd.entity.User;
import com.zkhw.ltd.service.OrganizationService;
import com.zkhw.ltd.service.UserService;
import com.zkhw.code.entity.AreaConfig;
import com.zkhw.common.utils.CodeUtil;

/**
 * 
 * @description 机构管理
 * @author zhangguanglong zhanggl@zksiot
 * @date 2018年6月1日 下午1:54:28
 * @version 1.0
 */
@Controller
@RequestMapping("/ltd/organization")
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService; 
	
	@Autowired
	private UserService userService;
	
	@Resource
	private CommonUtil commonUtil;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public void saveOrganization(HttpServletRequest request,HttpServletResponse response,ApiJsonResult result ,Organization organization, String type) throws Exception{
		
		try{
			String loginName = SystemParam.getUserId();
			User user = userService.findUserByLoginName(loginName);
			String villageCode = organization.getVillageCode();
			String townsCode  = organization.getTownsCode();
			String countyCode = organization.getCountyCode();
			String cityCode = organization.getCityCode();
			String provinceCode = organization.getProvinceCode();
			String orgCode = "";
			int i = (int)(Math.random()*999);
			String code = "";
			if( i > 99){
				code = "" + i;
			}else if(i > 9){
				code = "0" + i;
			}else{
				code = "00" + i;
			}

			if(StringUtil.isNotEmpty(villageCode)){
				orgCode = villageCode + code;
				organization.setVillageCode(villageCode);
				AreaConfig area = commonUtil.getAreaByCode(villageCode);
				if(area != null){
					organization.setVillageName(area.getName());
				}
			}else if(StringUtil.isNotEmpty(townsCode)){
				orgCode = townsCode + code;
				organization.setTownsCode(townsCode);
				AreaConfig area = commonUtil.getAreaByCode(townsCode);
				if(area != null){
					organization.setTownsName(area.getName());
				}
			}else if(StringUtil.isNotEmpty(countyCode)){
				orgCode = countyCode + "000000" + code;
				organization.setCountyCode(countyCode);
				AreaConfig area = commonUtil.getAreaByCode(countyCode);
				if(area != null){
					organization.setCountyName(area.getName());
				}
			}else if(StringUtil.isNotEmpty(cityCode)){
				orgCode = cityCode + "000000" + code;
				organization.setCityCode(cityCode);
				AreaConfig area = commonUtil.getAreaByCode(cityCode);
				if(area != null){
					organization.setCityName(area.getName());
				}
			}else if(StringUtil.isNotEmpty(provinceCode)){
				orgCode = provinceCode + "0000000000" + code;
				organization.setProvinceCode(provinceCode);
				AreaConfig area = commonUtil.getAreaByCode(provinceCode);
				if(area != null){
					organization.setProvinceName(area.getName());
				}
			}
			
			organization.setId(CodeUtil.getUUID());
			if(StringUtil.isNotEmpty(organization.getOrganParentCode())){
				Organization org = organizationService.getOrganizationByCode(organization.getOrganParentCode());				
				if(org != null){					
					organization.setProvinceCode(org.getProvinceCode());
					organization.setProvinceName(org.getProvinceName());
					organization.setCityCode(org.getCityCode());
					organization.setCityName(org.getCityName());
					organization.setCountyCode(org.getCountyCode());
					organization.setCountyName(org.getCountyName());
					organization.setTownsCode(org.getTownsCode());
					organization.setTownsName(org.getTownsName());
					organization.setVillageCode(org.getVillageCode());
					organization.setVillageName(org.getVillageName());
					
					String level = org.getOrganLevel();
					int lev = Integer.parseInt(level);
					if("1".equals(type)){
						lev = lev + 1;
					}else{
						if(StringUtil.isNotEmpty(villageCode)){
							lev = 5;
						}
					}
					organization.setOrganLevel(String.valueOf(lev));
					
					if(StringUtil.isEmpty(orgCode)){
						if(lev == 1){
							orgCode = org.getProvinceCode() + "0000000000" + code;
						}else if(lev == 2){
							orgCode = org.getCityCode() + "000000" + code;
						}else if(lev == 3){
							orgCode = org.getCountyCode() + "000000" + code;
						}else if(lev == 4){
							orgCode = org.getTownsCode() + code;
						}else{
							orgCode = org.getVillageCode() + code;
						}
					}
					
				}else{
					result.setCode("1");
					result.setMsg("上级机构不存在");
				}
			}else{
				organization.setOrganLevel("1");
			}
			
			organization.setOrganCode(orgCode);
			Date now = new Date();
			
			organization.setCreateTime(now);
			organization.setUpdateTime(now);
			if(user != null){
				organization.setCreateUserCode(user.getUserCode());
				organization.setUpdateUserCode(user.getUserCode());
			}	
			organization.setIsDelete(0);
			
			organizationService.saveOrganization(organization);	
			
			result.setCode("0");
			result.setMsg("机构保存成功");
			
		}catch(Exception e){
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("机构保存异常");
		}
		JsonWebPrintUtils.printApiResult(request, response, result);		
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public void updateOrganization(HttpServletRequest request,HttpServletResponse response,ApiJsonResult result ,Organization organization) throws Exception{
		
		try{
			String loginName = SystemParam.getUserId();
			User  user = userService.findUserByLoginName(loginName);
			
			Date now = new Date();
			
			organization.setUpdateTime(now);
			if(user != null){
				organization.setUpdateUserCode(user.getUserCode());
			}
	
			organization.setIsDelete(0);
			
			
			organizationService.updateOrganization(organization);	
			
			result.setCode("0");
			result.setMsg("机构修改成功");
			
		}catch(Exception e){
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("机构修改异常");
		}
		JsonWebPrintUtils.printApiResult(request, response, result);		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public void deleteOrganization(HttpServletRequest request,HttpServletResponse response,ApiJsonResult result ,String orgCode) throws Exception{
		
		try{
			//String loginName = SystemParam.getUserId();
			//User  user = userService.findUserByLoginName(loginName);
			List<Organization> childrens = organizationService.findChildren(orgCode);
			if(childrens != null && childrens.size() > 0){
				result.setCode("1");
				result.setMsg("机构下有子机构，请先删除子机构");
			}else{
				List<User> users = userService.findUserByOrgan(orgCode);
				if(users != null && users.size() > 0){
					result.setCode("1");
					result.setMsg("机构下有用户，请先删除用户");
				}else{
					organizationService.deleteOrganization(orgCode);
					result.setCode("0");
					result.setMsg("机构删除成功");
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("机构删除异常");
		}
		JsonWebPrintUtils.printApiResult(request, response, result);		
	}
	
	
	
	@RequestMapping(value = "/findOrganizations", method = RequestMethod.POST)
	@ResponseBody
	public void findOrganizations(HttpServletRequest request,HttpServletResponse response,ApiJsonResult result) throws Exception{
		
		try{
			String loginName = SystemParam.getUserId();
			User  user = userService.findUserByLoginName(loginName);
			String orgCode = user.getOrganCode();
			List<Organization> list = new ArrayList<Organization>();
			Organization org = organizationService.getOrganizationByCode(orgCode);
			if(org != null){
				list.add(org);
				List<Organization> orgs = organizationService.findChildren(orgCode);
				this.findOrganization(orgs, list);
			}
							
			result.setCode("0");
			result.setData(list);
			
		}catch(Exception e){
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("机构查询异常");
		}
		JsonWebPrintUtils.printApiResult(request, response, result);		
	}
	
	@RequestMapping(value = "/getOrganization", method = RequestMethod.POST)
	@ResponseBody
	public void getOrganization(HttpServletRequest request,HttpServletResponse response,ApiJsonResult result ,String orgCode) throws Exception{
		Organization org = organizationService.getOrganizationByCode(orgCode);
		result.setCode("0");
		result.setData(org);
		JsonWebPrintUtils.printApiResult(request, response, result);
	}

	@ResponseBody
	@RequestMapping(value = "/findOrganizationPage",method = RequestMethod.GET)
	public void findOrganizationPage(HttpServletRequest request, HttpServletResponse response,
			PageInfos<Organization> pageData,Organization organization, ApiJsonResult result) throws Exception {
		pageData = organizationService.findOrganizationByPage(organization, pageData);
		JsonWebPrintUtils.printApiResult(request, response, pageData);
	}
	
	
	private void findOrganization(List<Organization> orgs,List<Organization> list){
		if(orgs != null && orgs.size() > 0 ){
			list.addAll(orgs);
			for(int i = 0; i < orgs.size(); i++){
				List<Organization> child = organizationService.findChildren(orgs.get(i).getOrganCode());
				this.findOrganization(child, list);
			}			
		}

	}
	
	@RequestMapping(value = "/findOrgList", method = RequestMethod.POST)
	@ResponseBody
	public void findOrgList(HttpServletRequest request,HttpServletResponse response,ApiJsonResult result) throws Exception{
		
		try{
			String loginName = SystemParam.getUserId();
			User  user = userService.findUserByLoginName(loginName);
			String orgCode = user.getOrganCode();
			List<Organization> list = new ArrayList<Organization>();
			Organization org = organizationService.getOrganizationByCode(orgCode);
			if(org != null){
				List<Organization> orgs = organizationService.findChildren(orgCode);
				list.addAll(orgs);
			}
				
			result.setCode("0");
			result.setData(list);
			
		}catch(Exception e){
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("查询异常");
		}
		JsonWebPrintUtils.printApiResult(request, response, result);		
	}	
	
}
