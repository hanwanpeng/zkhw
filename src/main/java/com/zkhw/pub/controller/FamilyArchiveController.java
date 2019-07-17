package com.zkhw.pub.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkhw.common.utils.CodeUtil;
import com.zkhw.common.utils.SystemParam;
import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.ltd.entity.Organization;
import com.zkhw.ltd.entity.User;
import com.zkhw.ltd.service.OrganizationService;
import com.zkhw.ltd.service.UserService;
import com.zkhw.pub.entity.FamilyArchive;
import com.zkhw.pub.entity.FamilyMember;
import com.zkhw.pub.service.FamilyArchiveService;

@Controller
@RequestMapping("/pub/familyArchive")
public class FamilyArchiveController {

	@Autowired
	private FamilyArchiveService familyArchiveService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrganizationService organizationService;
	
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public PageInfos<FamilyArchive>  findFamilyArchiveList(FamilyArchive archive, PageInfos<FamilyArchive> pageData){
		pageData = familyArchiveService.findFamilyArchiveByPage(archive, pageData);
		return pageData;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ApiJsonResult saveFamilyArchive(FamilyArchive archive){
		ApiJsonResult result = new ApiJsonResult();
		try{
			String loginName = SystemParam.getUserId();
			User user = userService.findUserByLoginName(loginName);
			
			archive.setId(CodeUtil.getUUID());			
			archive.setFamilyArchiveNo("fa" + archive.getIdNumber());
			
			archive.setStatus("1");
			if(user != null){
				Organization org = organizationService.getOrganizationByCode(user.getOrganCode());
				if(org != null){
					archive.setProvinceCode(org.getProvinceCode());
					archive.setProvinceName(org.getProvinceName());
					archive.setCityCode(org.getCityCode());
					archive.setCityName(org.getCityName());
					archive.setCountyCode(org.getCountyCode());
					archive.setCountyName(org.getCountyName());
					archive.setTownsCode(org.getTownsCode());
					archive.setTownsName(org.getTownsName());
					//archive.setVillageCode(villageCode);
					//archive.setVillageName(villageName);	
					archive.setCreateOrgName(org.getOrganName());
				}
				
				archive.setAichiveOrg(user.getOrganCode());
				archive.setCreateOrg(user.getOrganCode());
				
				archive.setCreateUser(user.getUserCode());
				archive.setCreatName(user.getUserName());		
				
				archive.setUpdateUser(user.getUserCode());
				archive.setUpdateName(user.getUserName());
			}

			Date now = new Date();
			archive.setCreatTime(now);
			archive.setUpdateTime(now);

			archive.setUploadStatus(0);
			familyArchiveService.saveFamilyArchive(archive);
			result.setCode("0");
		}catch(Exception e){
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("保存异常");
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveMember", method = RequestMethod.POST)
	public ApiJsonResult saveFamilyMember(FamilyMember member){
		ApiJsonResult result = new ApiJsonResult();
		try{
			member.setId(CodeUtil.getUUID());		
			
			String loginName = SystemParam.getUserId();
			User user = userService.findUserByLoginName(loginName);
			if(user != null){
				member.setCreateUser(user.getUserCode());
				member.setCreatName(user.getUserName());		
				
				member.setUpdateUser(user.getUserCode());
				member.setUpdateName(user.getUserName());
			}
			
			Date now = new Date();
			member.setCreatTime(now);
			member.setUpdateTime(now);
			member.setSattus("1");
			familyArchiveService.saveFamilyMember(member);
			result.setCode("0");
		}catch(Exception e){
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("保存异常");			
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/memberlist", method = RequestMethod.GET)
	public PageInfos<FamilyMember>  findFamilyMemberList(String familyArchiveNo){
		return familyArchiveService.findMemberByPage(familyArchiveNo);
		
	}
}
