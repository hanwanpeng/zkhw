package com.zkhw.api.controller;

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
import com.zkhw.ltd.entity.Organization;
import com.zkhw.ltd.entity.User;
import com.zkhw.ltd.service.OrganizationService;
import com.zkhw.ltd.service.UserService;

@Controller
public class AppController {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrganizationService organizationService;
	
	@ResponseBody
	@RequestMapping(value = "/app")
	public void login(HttpServletRequest request, HttpServletResponse response,String verifyCode,String loginName,
			String from) {
		
		Result r = new Result();
		try{
			if(StringUtil.isEmpty(verifyCode)){
				r.setCode(1003);
				r.setMessage("校验码不能为空");
			}else if(!"A5X6VPDC99IVTOBFD4UKG2QUQFCA93CE".equals(verifyCode)){
				r.setCode(1004);
				r.setMessage("校验码不正确");
			}else if(StringUtil.isEmpty(loginName)){
				r.setCode(-1);
				r.setMessage("登录帐号不能为空");
			}else{
				
				Boolean exist = userService.existLoginName(loginName);
				if(exist){
					r.setCode(2008);
					r.setMessage("帐号不存在");
				}else{
					User user = userService.findUserByLoginName(loginName);

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

		}catch(Exception e){
			e.printStackTrace();
			r.setCode(1);			
		}
		JsonWebPrintUtils.printApiResult(request, response, r);
	}
}
