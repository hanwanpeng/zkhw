package com.zkhw.ltd.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.util.StringUtil;
import com.zkhw.common.enums.StatusCodeEnum;
import com.zkhw.common.utils.ApiConstants;
import com.zkhw.common.utils.SystemParam;
import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.LoginVo;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.framework.redis.RedisClient;
import com.zkhw.framework.utils.JsonConverter;
import com.zkhw.framework.utils.JsonWebPrintUtils;
import com.zkhw.framework.utils.Md5Encrypt;
import com.zkhw.framework.utils.StringUtils;
import com.zkhw.ltd.bo.AppUserBo;
import com.zkhw.ltd.bo.UserBo;
import com.zkhw.ltd.entity.Organization;
import com.zkhw.ltd.entity.User;
import com.zkhw.ltd.service.OrganizationService;
import com.zkhw.ltd.service.UserRoleService;
import com.zkhw.ltd.service.UserService;
import com.zkhw.ltd.vo.UserVo;


@Controller
@RequestMapping("/ltd/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@Resource
	private RedisClient redisClient;
	
	@Resource
	private UserRoleService  userRoleService;
	
	@Autowired
	private OrganizationService organizationService;
	
	
	/**
	 * App登录
	 */
	@ResponseBody
	@RequestMapping(value = "/Applogin", method = RequestMethod.GET)
	public void Applogin(HttpServletRequest request,HttpServletResponse response,String loginName,String passWord,ApiJsonResult result ) throws Exception {
		try {
			String md5 = Md5Encrypt.md5(passWord);
			User user = userService.findLoginUser(loginName, md5);
			
			AppUserBo appUser = new AppUserBo();
			BeanUtils.copyProperties(user, appUser);
			String organCode = user.getOrganCode();
			if(!StringUtil.isEmpty(organCode)) {
				Organization org = organizationService.getOrganizationByCode(organCode);
				appUser.setProvinceCode(org.getProvinceCode());
				appUser.setCityCode(org.getCityCode());
				appUser.setCountyCode(org.getCountyCode());
				appUser.setTownsCode(org.getTownsCode());
				appUser.setVillageCode(org.getVillageCode());
			}
			
			result.setData(appUser);
			result.setCode("0");
			result.setMsg("成功");
		} catch (Exception e) {
			result.setCode("1");
			result.setMsg("失败");
		}
		JsonWebPrintUtils.printApiResult(request, response, result);
		
	}
	
	
	
	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @param loginName
	 * @param passWord
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login(HttpServletRequest request,HttpServletResponse response,String loginName,String passWord,ApiJsonResult result ) throws Exception {
		userService.webLogin(request, response, result, loginName, passWord);
		JsonWebPrintUtils.printApiResult(request, response, result);
	}
	
	
	/**
	 * 根据组织机构查询组织机构下的所有的人
	 * @param request
	 * @param response
	 * @param pageData
	 * @param result
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/userlistByOrganCode",method = RequestMethod.GET)
	public void userlistByOrganCode(HttpServletRequest request, HttpServletResponse response,
			PageInfos<UserBo> pageData,User user, ApiJsonResult result) throws Exception {
		String loginName = SystemParam.getUserId();
		
		if("admin".equals(loginName)){
			user.setOrganCode(null);
		}else{
			User  u = userService.findUserByLoginName(loginName);
			if(u != null){
				if(StringUtil.isNotEmpty(u.getParentOrgan())){
					if(u.getOrganCode().equals(u.getParentOrgan())){
						user.setOrganCode(null);
						user.setParentOrgan(u.getOrganCode());
					}else{
						user.setOrganCode(u.getOrganCode());
					}
				}else{
					user.setOrganCode(u.getOrganCode());
				}
			}
		}

		pageData = userService.findUserByPage(user, pageData);
		JsonWebPrintUtils.printApiResult(request, response, pageData);
	}
	
	
	/**
	 * 分页查询用户
	 * @param request
	 * @param response
	 * @param pageData
	 * @param result
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/userlist",method = RequestMethod.GET)
	public void userlist(HttpServletRequest request, HttpServletResponse response,
			PageInfos<UserBo> pageData,User user, ApiJsonResult result) throws Exception {
		String loginName = SystemParam.getUserId();
		
		if("admin".equals(loginName)){
			user.setOrganCode(null);
		}else{
			User  u = userService.findUserByLoginName(loginName);
			if(u != null){
				user.setOrganCode(u.getOrganCode());
				if(StringUtil.isNotEmpty(u.getParentOrgan())){
					if(u.getOrganCode().equals(u.getParentOrgan())){
						user.setOrganCode(null);
						user.setParentOrgan(u.getOrganCode());
					}				
				}
			}
		}

		pageData = userService.findUserByPage(user, pageData);
		JsonWebPrintUtils.printApiResult(request, response, pageData);
	}
	
	
	
	
	/**
	 * 根据用户编码查询用户
	 * @param request
	 * @param response
	 * @param result
	 * @param User
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/findUserByCode", method = RequestMethod.GET)
	public void findUserByCode(HttpServletRequest request,HttpServletResponse response,ApiJsonResult result ,String userCode) throws Exception {
		try {
			User user = userService.findUserByCode(userCode);
			UserVo userVo = null;
			if( user != null ) {
				userVo = new UserVo();
				BeanUtils.copyProperties(user, userVo);
				List<String> roleCodeList = userRoleService.findRoleByUser(userCode);
				if( roleCodeList != null && roleCodeList.size() != 0 ) {
					userVo.setRoleCode(roleCodeList.get(0));
				}
				//前端处理了
				/*String [] departCodes = null;
				if( !StringUtils.isEmpty(user.getDepartCode())) {
					departCodes = user.getDepartCode().split(",");
				}
				List<TreeVo> departList = userService.findDepartmentByOrgan(user.getOrganCode(),departCodes);
				userVo.setDepartTree(departList);*/
				result.setData(userVo);
				result.setCode(StatusCodeEnum.SUCCESS.getCode());
				result.setMsg(StatusCodeEnum.SUCCESS.getDesc());
			}else {
				result.setCode(StatusCodeEnum.FAIL.getCode());
				result.setMsg("用户不存在");
				result.setData(userVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(StatusCodeEnum.FAIL.getCode());
			result.setMsg(StatusCodeEnum.FAIL.getDesc());
		}
		JsonWebPrintUtils.printApiResult(request, response, result);
	}
	
	
	
	/**
	 * 保存用户
	 * @param request
	 * @param response
	 * @param result
	 * @param User
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/saveUser",method = RequestMethod.POST)
	public void saveUser(HttpServletRequest request,HttpServletResponse response,ApiJsonResult result ,User user,String roleCodes) throws Exception {
		String loginName = SystemParam.getUserId();
		User u = userService.findUserByLoginName(loginName);
		if(u != null){
			user.setCreateUserCode(u.getUserCode());
			user.setCreateTime(new Date());
			user.setUpdateUserCode(u.getUserCode());
		}
		String orgCode = user.getOrganCode();
		Organization org = organizationService.getOrganizationByCode(orgCode);
		if(org != null){
			if(StringUtil.isNotEmpty(org.getOrganParentCode())){
				user.setParentOrgan(org.getOrganParentCode());
			}else{
				user.setParentOrgan(orgCode);
			}			
		}
		user.setIsDelete(0);
		result = userService.saveUser(user,roleCodes);
		JsonWebPrintUtils.printApiResult(request, response, result);
	}
	

	
	/**
	 * 修改用户
	 * @param request
	 * @param response
	 * @param pageData
	 * @param user
	 * @param result
	 * @throws Exception
	 */
	@ResponseBody
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
	public void updateUser(HttpServletRequest request, HttpServletResponse response,User user,String roleCodes, ApiJsonResult result) throws Exception {
		result = userService.updateUserByCode(user, roleCodes);
		JsonWebPrintUtils.printApiResult(request, response, result);
	}
	
	/**
	 * 删除用户（逻辑删除）
	 * @param request
	 * @param response
	 * @param userCode
	 * @param result
	 * @throws Exception
	 */
	@ResponseBody
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
	public void deleteUser(HttpServletRequest request, HttpServletResponse response,String userCode, ApiJsonResult result) throws Exception {
		try {
			if(!"123456".equals(userCode)){
				userService.deleteUser(userCode);
				userRoleService.deleteByUserCode(userCode);
				result.setCode(StatusCodeEnum.SUCCESS.getCode());
				result.setMsg(StatusCodeEnum.SUCCESS.getDesc());
			}else{
				result.setCode("1");
				result.setMsg("系统管理员不能删除");
			}

		} catch (Exception e) {
			result.setCode(StatusCodeEnum.USER_UPDATE_FAIL.getCode());
			result.setMsg(StatusCodeEnum.USER_UPDATE_FAIL.getDesc());
		}

		JsonWebPrintUtils.printApiResult(request, response, result);
	}
    
    /**
     * 获取登录用户信息
     * @param request
     * @param response
     * @param result
     * @throws Exception
     */
	@ResponseBody
    @RequestMapping(value = "/loginVo",method = RequestMethod.GET)
	public void findLoginVo(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
    	String loginName = SystemParam.getUserId();
    	String loginVoJson = redisClient.get(ApiConstants.REDIS_KEY_PREFIX_SESSION+loginName);
    	LoginVo loginVo = null;
    	if( !StringUtils.isEmpty(loginVoJson)) {
    		loginVo = JsonConverter.json2Obj(loginVoJson,LoginVo.class);
    	}
		result.setData(loginVo);
		result.setCode(StatusCodeEnum.SUCCESS.getCode());
		result.setMsg(StatusCodeEnum.SUCCESS.getDesc());
		JsonWebPrintUtils.printApiResult(request, response, result);
	}
	
	/**
	 * 登录退出
	 * @param request
	 * @param response
	 */
	@ResponseBody
    @RequestMapping(value = "/signOut",method = RequestMethod.GET)
	public void signOut(HttpServletRequest request, HttpServletResponse response,ApiJsonResult result) throws Exception {
		
    	String loginName = SystemParam.getUserId();
    	String loginVoJson = redisClient.get(ApiConstants.REDIS_KEY_PREFIX_SESSION+loginName);
    	LoginVo loginVo = null;
    	if( !StringUtils.isEmpty(loginVoJson)) {
    		loginVo = JsonConverter.json2Obj(loginVoJson,LoginVo.class);
    	}
		if ( loginVo != null ) {
			redisClient.del(ApiConstants.REDIS_KEY_PREFIX_SESSION+loginName);
			result.setCode(StatusCodeEnum.SUCCESS.getCode());
			result.setMsg(StatusCodeEnum.SUCCESS.getDesc());
		}
		JsonWebPrintUtils.printApiResult(request, response, result);
	}
    	
	
	@ResponseBody
    @RequestMapping(value = "/updatePwd",method = RequestMethod.POST)
	public void updatePwd(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		try {
			String loginName = SystemParam.getUserId();
			String oldPwd = request.getParameter("oldPwd");
			String newPwd = request.getParameter("newPwd");
			String pass = Md5Encrypt.md5(oldPwd);
			User user = this.userService.findLoginUser(loginName, pass);
			if(user == null){
				result.setCode(StatusCodeEnum.USER_UPDATE_FAIL.getCode());
				result.setMsg("密码不正确");
			}else{
				String pwd = Md5Encrypt.md5(newPwd);
				user.setLoginPass(pwd);
				user.setUpdateTime(new Date());
				user.setUpdateUserCode(user.getUserCode());
				user.setUserName(user.getUserName());
				this.userService.updateUserByCode(user);
				result.setCode(StatusCodeEnum.SUCCESS.getCode());
				result.setMsg(StatusCodeEnum.SUCCESS.getDesc());
			}

		} catch (Exception e) {
			result.setCode(StatusCodeEnum.USER_UPDATE_FAIL.getCode());
			result.setMsg(StatusCodeEnum.USER_UPDATE_FAIL.getDesc());
		}
		JsonWebPrintUtils.printApiResult(request, response, result);
	}
}
