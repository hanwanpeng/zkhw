package com.zkhw.api.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.util.StringUtil;
import com.zkhw.api.bo.LoginBo;
import com.zkhw.api.bo.OrgModel;
import com.zkhw.api.bo.Result;
import com.zkhw.api.bo.UserModel;
import com.zkhw.framework.utils.JsonWebPrintUtils;
import com.zkhw.framework.utils.Md5Encrypt;
import com.zkhw.ltd.entity.Organization;
import com.zkhw.ltd.entity.User;
import com.zkhw.ltd.service.OrganizationService;
import com.zkhw.ltd.service.UserService;

@Controller
@RequestMapping("/Api/Account")
public class AccountController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrganizationService organizationService;
	
	@ResponseBody
	@RequestMapping(value = "/Login")
	public void login(HttpServletRequest request, HttpServletResponse response,String accessTokenKey,String UserId,
			String Pwd) {
		
		Result r = new Result();
		try{
			if(StringUtil.isEmpty(UserId)){
				r.setCode(-1);
				r.setMessage("登录帐号不能为空");
			}else if(StringUtil.isEmpty(Pwd)){
				r.setCode(-1);
				r.setMessage("登录密码不能为空");
			}else{
				
				Boolean exist = userService.existLoginName(UserId);
				if(exist){
					r.setCode(2008);
					r.setMessage("帐号不存在");
				}else{
					String md5 = Md5Encrypt.md5(Pwd);
					User user = userService.findLoginUser(UserId, md5);
					if(user == null){
						r.setCode(2003);
						r.setMessage("用户名或者密码错误");
					}else{
						LoginBo bo = new LoginBo();
						UserModel u = new UserModel();
						u.setId(user.getUserCode());
						u.setUserId(user.getLoginName());
						u.setFirstName(user.getUserName());
						u.setDeptNo(user.getOrganCode());
						bo.setUserModel(u);
						
						OrgModel o = new OrgModel();
						Organization org = organizationService.getOrganizationByCode(user.getOrganCode());
						if(org != null){
							o.setDuns(org.getOrganCode());
							o.setName(org.getOrganName());
							o.setUsestatus("1");
							o.setParentsId(org.getOrganParentCode());
							o.setAddresss(org.getAddress());
							o.setLevelx(org.getOrganLevel());
							
						}
						bo.setOrgModel(o);
						r.setCode(0);
						r.setMessage("Success");
						r.setData(bo);
					}
				}
			}

		}catch(Exception e){
			e.printStackTrace();
			r.setCode(1);			
		}
		JsonWebPrintUtils.printApiResult(request, response, r);
	}
	
	@ResponseBody
	@RequestMapping(value = "/UpdatePwd")
	public void updatePwd(HttpServletRequest request, HttpServletResponse response,String accessTokenKey,String UserId,
			String OldPwd, String NewPwd) {
		
		Result r = new Result();
		try{
			if(StringUtil.isEmpty(UserId)){
				r.setCode(-1);
				r.setMessage("登录帐号不能为空");
			}else if(StringUtil.isEmpty(OldPwd)){
				r.setCode(-1);
				r.setMessage("旧密码不能为空");
			}else if(StringUtil.isEmpty(NewPwd)){
				r.setCode(-1);
				r.setMessage("新密码不能为空");
			}else {
				
				Boolean exist = userService.existLoginName(UserId);
				if(exist){
					r.setCode(2008);
					r.setMessage("帐号不存在");
				}else{
					String md5 = Md5Encrypt.md5(OldPwd);
					User user = userService.findLoginUser(UserId, md5);
					if(user == null){
						r.setCode(2003);
						r.setMessage("用户名或者密码错误");
					}else{						
						String pwd = Md5Encrypt.md5(NewPwd);
						user.setLoginPass(pwd);
						user.setUpdateTime(new Date());
						user.setUpdateUserCode(user.getUserCode());
						user.setUserName(user.getUserName());
						this.userService.updateUserByCode(user);
						r.setCode(0);
						r.setMessage("修改密码成功");
					}
				}
			}

		}catch(Exception e){
			e.printStackTrace();
			r.setCode(1);			
		}
		
		JsonWebPrintUtils.printApiResult(request, response, r);
	}	
}
