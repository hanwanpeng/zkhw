package com.zkhw.ltd.controller;

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
import com.zkhw.common.enums.StatusCodeEnum;
import com.zkhw.common.utils.SystemParam;
import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageData;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.framework.utils.JsonWebPrintUtils;
import com.zkhw.ltd.bo.RoleBo;
import com.zkhw.ltd.entity.Organization;
import com.zkhw.ltd.entity.Role;
import com.zkhw.ltd.entity.User;
import com.zkhw.ltd.service.OrganizationService;
import com.zkhw.ltd.service.RoleService;
import com.zkhw.ltd.service.UserRoleService;
import com.zkhw.ltd.service.UserService;
import com.zkhw.ltd.vo.RoleVo;

@Controller
@RequestMapping("/ltd/role")
public class RoleController {

	@Resource
	private RoleService roleService;
	
	@Autowired
	private OrganizationService organizationService; 
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRoleService userRoleService;
		
	/**
	 * 根据组织机构获取所有角色-分页
	 * @param request
	 * @param response
	 * @param role
	 * @throws Exception
	 */
	@RequestMapping(value="/findRoleByPage",method = RequestMethod.GET)
	public void findRoleByCompanyPage(HttpServletRequest request , HttpServletResponse response, String organCode,PageInfos<Role> pageData,ApiJsonResult result) {
		String loginName = SystemParam.getUserId();
		User user = userService.findUserByLoginName(loginName);
		Role role = new Role();
		String roleCode = "";
		if(user != null){
			List<String> roleList = userRoleService.findRoleByUser(user.getUserCode());
			if(roleList.size() > 0){
				roleCode = roleList.get(0);
			}
		}
		if(!"".equals(organCode)){
			Organization org = organizationService.getOrganizationByCode(organCode);
			if(org != null){
				if(StringUtil.isNotEmpty(user.getParentOrgan())){
					if(user.getOrganCode().equals(user.getParentOrgan())){
						role.setParentOrgan(user.getParentOrgan());
					}else{
						role.setOrganCode(user.getOrganCode());
					}
				}else{
					role.setOrganCode(user.getOrganCode());
				}
			}
		}
		
		role.setRoleCode(roleCode);
		pageData = roleService.findRoleByPage(role, pageData);
		JsonWebPrintUtils.printApiResult(request, response, pageData);
	}
	
	/**
	 * 根据组织机构获取所有角色
	 * @param request
	 * @param response
	 * @param companyCode
	 * @param pageData
	 * @param result
	 */
	@RequestMapping(value="/findRoleByOrgan",method = RequestMethod.POST)
	public void findRoleByOrgan(HttpServletRequest request , HttpServletResponse response, String organCode,PageData<Role> pageData,ApiJsonResult result) {		
		//List<Role> roles = roleService.findRoleByOrgan(organCode);
		List<Role> roles = roleService.findAllRole();
		result.setData(roles);
		result.setCode(StatusCodeEnum.SUCCESS.getCode());
		result.setMsg(StatusCodeEnum.SUCCESS.getDesc());
		JsonWebPrintUtils.printApiResult(request, response, result);
	}
	
	
	/**
	 * 保存角色
	 * @param request
	 * @param response
	 * @param agencyCode
	 * @param pageData
	 * @param result
	 */
	@RequestMapping(value="/saveRole",method = RequestMethod.POST)
	public void saveRole(HttpServletRequest request , HttpServletResponse response, RoleBo roleBo,ApiJsonResult result) {
		
		String orgCode = roleBo.getOrganCode();
		Organization org = organizationService.getOrganizationByCode(orgCode);
		if(org != null){
			if(StringUtil.isNotEmpty(org.getOrganParentCode())){
				roleBo.setParentOrgan(org.getOrganParentCode());
			}else{
				roleBo.setParentOrgan(orgCode);
			}			
		}
		roleService.saveRole(roleBo);
		result.setCode(StatusCodeEnum.SUCCESS.getCode());
		result.setMsg(StatusCodeEnum.SUCCESS.getDesc());
		JsonWebPrintUtils.printApiResult(request, response, result);
	}
	
	
	/**
	 * 根据角色编号查询角色
	 * @param request
	 * @param response
	 * @param httpRequestParamVo
	 * @param result
	 * @throws Exception
	 */
	@RequestMapping(value="/findRoleByCode",method = RequestMethod.POST)
	public void findRoleByCode(HttpServletRequest request,HttpServletResponse response,String roleCode,ApiJsonResult result)throws Exception {
		RoleVo roleVo = roleService.findRoleByCode(roleCode);
		result.setData(roleVo);
		result.setCode(StatusCodeEnum.SUCCESS.getCode());
		result.setMsg(StatusCodeEnum.SUCCESS.getDesc());
		JsonWebPrintUtils.printApiResult(request, response, result);
	}
	
	
	
	 /**
	  * 修改角色
	  * @param request
	  * @param response
	  * @param role
	  * @param result
	  * @throws Exception
	  */
	@RequestMapping(value = "/updateRole", method = RequestMethod.POST)
	public void updateRole(HttpServletRequest request,HttpServletResponse response,RoleBo roleBo, ApiJsonResult result) throws Exception {
		roleService.updateRoleByCode(roleBo);
		result.setCode(StatusCodeEnum.SUCCESS.getCode());
		result.setMsg(StatusCodeEnum.SUCCESS.getDesc());
		JsonWebPrintUtils.printApiResult(request, response, result);
	}
	
	
	/**
	 * 删除角色
	 */
	@RequestMapping(value="/deleteRole",method = RequestMethod.POST)
	public void deleteRole(HttpServletRequest request,HttpServletResponse response,String roleCode, ApiJsonResult result) throws Exception {
		result = roleService.deleteRoleByCode(result, roleCode);
		JsonWebPrintUtils.printApiResult(request, response, result);
	}
	
	@RequestMapping(value = "/findOrganizations", method = RequestMethod.POST)
	@ResponseBody
	public void findOrganizations(HttpServletRequest request,HttpServletResponse response,ApiJsonResult result) throws Exception{
		try{
			String loginName = SystemParam.getUserId();
			User user = userService.findUserByLoginName(loginName);
			List<Organization> list  = null;
			if(user != null){
				if(user.getLoginName().equals("admin")){
					list = organizationService.findOrganizationList(new Organization());
				}else{
					if( ! StringUtil.isEmpty(user.getOrganCode())) {
						list = organizationService.findChildren(user.getOrganCode());
						Organization org = organizationService.getOrganizationByCode(user.getOrganCode());
						list.add(0, org);;
					}
				}
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
	
		
}
