package com.zkhw.sign.service;

import java.util.List;

import com.zkhw.common.vo.PageInfos;
import com.zkhw.sign.bo.TeamDoctorBo;
import com.zkhw.sign.entity.DoctorInfo;
import com.zkhw.sign.entity.TeamDoctor;
import com.zkhw.sign.entity.TeamInfo;

public interface TeamService {
	
	int saveTeam(TeamInfo team);
	
	PageInfos<TeamInfo> findTeamByPage(TeamInfo team, PageInfos<TeamInfo> pageData);
	
	PageInfos<TeamDoctor> findTeamDoctorByPage(String teamno, PageInfos<TeamDoctor> pageData);
	
	void saveTeamDoctor(TeamDoctorBo doctor);
	
	List<DoctorInfo> findDoctorListByOrg(String orgCode);
	
	String findTeamByUser(String userCode);
	
	void removeDoctor(String doctorNo);

}
