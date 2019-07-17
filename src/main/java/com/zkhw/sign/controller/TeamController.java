package com.zkhw.sign.controller;

import java.util.Date;
import java.util.List;

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
import com.zkhw.sign.bo.TeamDoctorBo;
import com.zkhw.sign.entity.DoctorInfo;
import com.zkhw.sign.entity.TeamDoctor;
import com.zkhw.sign.entity.TeamInfo;
import com.zkhw.sign.service.TeamService;

@Controller
@RequestMapping("/sign/team")
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrganizationService organizationService;
	
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public PageInfos<TeamInfo>  findTeamList(TeamInfo team, PageInfos<TeamInfo> pageData){
		String loginName = SystemParam.getUserId();
		User user = userService.findUserByLoginName(loginName);
		if(user != null){
			if("1".equals(user.getUserTypeCode())){
				String teamNo = teamService.findTeamByUser(user.getUserCode());
				team.setTeamNo(teamNo);
			}else{
				team.setOrgCode(user.getOrganCode());
			}
		}
		pageData = teamService.findTeamByPage(team, pageData);
		return pageData;		
	}
	
	@ResponseBody
	@RequestMapping(value = "/doctorList", method = RequestMethod.GET)
	public List<DoctorInfo> findDoctorList(){
		String loginName = SystemParam.getUserId();
		User user = userService.findUserByLoginName(loginName);
		return teamService.findDoctorListByOrg(user.getOrganCode());
	}
	
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ApiJsonResult saveTeamInfo(TeamInfo team){
		ApiJsonResult result = new ApiJsonResult();
		try{
			String loginName = SystemParam.getUserId();
			User user = userService.findUserByLoginName(loginName);
			
			team.setId(CodeUtil.getUUID());			
			team.setTeamNo("t" + System.currentTimeMillis());
			
			team.setStatus("1");
			team.setMemberNum(0);
			if(user != null){
				Organization org = organizationService.getOrganizationByCode(user.getOrganCode());
				
				if(org != null){
					team.setProvinceCode(org.getProvinceCode());
					team.setProvinceName(org.getProvinceName());
					team.setCityCode(org.getCityCode());
					team.setCityName(org.getCityName());
					team.setCountyCode(org.getCountyCode());
					team.setCountyName(org.getCountyName());
					team.setTownsCode(org.getTownsCode());
					team.setTownsName(org.getTownsName());
					team.setVillageCode(org.getVillageCode());
					team.setVillageName(org.getVillageName());	
					team.setOrgCode(org.getOrganCode());;
				}				
				
				team.setCreateUser(user.getUserCode());
				team.setCreateName(user.getUserName());		
				
				team.setUpdateUser(user.getUserCode());
				team.setUpdateName(user.getUserName());
			}
			
			Date now = new Date();
			team.setCreateTime(now);
			team.setUpdateTime(now);
			teamService.saveTeam(team);
			result.setCode("0");
			
		}catch(Exception e){
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("保存异常");
		}
		
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/addDoctor", method = RequestMethod.POST)
	public ApiJsonResult saveTeamDoctor(TeamDoctorBo team){
		ApiJsonResult result = new ApiJsonResult();
		try{
			String loginName = SystemParam.getUserId();
			User user = userService.findUserByLoginName(loginName);
			
			team.setId(CodeUtil.getUUID());			
			
			if(user != null){				
				
				team.setCreateUser(user.getUserCode());
				team.setCreateName(user.getUserName());		
				
				team.setUpdateUser(user.getUserCode());
				team.setUpdateName(user.getUserName());
			}
			
			Date now = new Date();
			team.setCreateTime(now);
			team.setUpdateTime(now);
			teamService.saveTeamDoctor(team);;
			result.setCode("0");
			
		}catch(Exception e){
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("保存异常");
		}
		
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/teamDoctors", method = RequestMethod.GET)
	public PageInfos<TeamDoctor>  findTeamList(String teamno,  PageInfos<TeamDoctor> pageData){
		pageData = teamService.findTeamDoctorByPage(teamno, pageData);
		return pageData;		
	}
	
	@ResponseBody
	@RequestMapping(value = "/removeDoctor", method = RequestMethod.POST)
	public ApiJsonResult removeTeamDoctor(String doctorNo){
		ApiJsonResult result = new ApiJsonResult();
		try{
			teamService.removeDoctor(doctorNo);
			result.setCode("0");
			result.setMsg("医生删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("保存异常");
		}		
		return result;
	}	
}
