package com.zkhw.sign.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.util.StringUtil;
import com.zkhw.common.utils.SystemParam;
import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.framework.utils.JsonWebPrintUtils;
import com.zkhw.ltd.entity.Organization;
import com.zkhw.ltd.entity.User;
import com.zkhw.ltd.service.OrganizationService;
import com.zkhw.ltd.service.UserService;
import com.zkhw.sign.entity.ServiceItem;
import com.zkhw.sign.entity.SignServiceInfo;
import com.zkhw.sign.service.FamilySignService;

@Controller
@RequestMapping("/sign/service")
public class FamilySignController {

	@Autowired
	private FamilySignService familySignService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrganizationService organizationService;
	
	@ResponseBody
	@RequestMapping(value = "/findServiceItems", method = RequestMethod.GET)
	public List<ServiceItem> findServiceItems(){
		return familySignService.findServiceItems();
	}

	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void findSignServiceList(HttpServletRequest req, HttpServletResponse resp, SignServiceInfo sign, PageInfos<SignServiceInfo> pageData){
		pageData = familySignService.findSignServiceByPage(sign, pageData);
		JsonWebPrintUtils.printApiResult(req, resp, pageData);	
	}
	
	@ResponseBody
	@RequestMapping(value = "/checkArchiveNo", method = RequestMethod.GET)
	public ApiJsonResult checkArchiveNo(String archiveNo){
		ApiJsonResult result = new ApiJsonResult();
		try{
			String loginName = SystemParam.getUserId();
			User user = userService.findUserByLoginName(loginName);
			if(StringUtil.isNotEmpty(archiveNo)){
				if(archiveNo.length() < 8){
					result.setCode("1");
					result.setMsg("电子档案编号不能小于8位");
					return result;
				}else{
					Organization org = organizationService.getOrganizationByCode(user.getOrganCode());
					String no = org.getTownsCode().substring(0, org.getTownsCode().length() - 3) + archiveNo.substring(archiveNo.length() - 8, archiveNo.length());
					int exist = familySignService.checkArchiveNo(no);
					if(exist > 0){
						result.setCode("0");
					}else{
						result.setCode("1");
						result.setMsg("居民不存在");
					}
					
					return result;
				}
			}else{
				result.setCode("1");
				result.setMsg("电子档案号不能为空");
				return result;
			}			
			
		}catch(Exception e){
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("查询异常");
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ApiJsonResult saveSignService(SignServiceInfo info, String items){
		ApiJsonResult result = new ApiJsonResult();
		try{
			String loginName = SystemParam.getUserId();
			User user = userService.findUserByLoginName(loginName);
			
			int r = familySignService.saveSignService(info, user, items);
			if(r == 0){
				result.setCode("0");
				result.setMsg("保存成功");
			}else if(r == 1){
				result.setCode("1");
				result.setMsg("居民电子档案不存在");
			}else if(r == 2){
				result.setCode("1");
				result.setMsg("当前登录用户不是医护人员，不能签约");
			}else if(r == 3){
				result.setCode("1");
				result.setMsg("当前登录用户没有团队，不能签约");
			}
		}catch(Exception e){
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("保存异常");
		}
		
		return result;
	}
}
