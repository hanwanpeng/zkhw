package com.zkhw.sign.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zkhw.common.utils.CodeUtil;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.sign.bo.TeamDoctorBo;
import com.zkhw.sign.dao.DoctorInfoDao;
import com.zkhw.sign.dao.TeamDoctorDao;
import com.zkhw.sign.dao.TeamInfoDao;
import com.zkhw.sign.entity.DoctorInfo;
import com.zkhw.sign.entity.TeamDoctor;
import com.zkhw.sign.entity.TeamInfo;
import com.zkhw.sign.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamInfoDao teamInfoDao;
	
	@Autowired
	private TeamDoctorDao teamDoctorDao;
	
	@Autowired
	private DoctorInfoDao doctorInfoDao;
	
	@Override
	public int saveTeam(TeamInfo team) {
		return teamInfoDao.insertSelective(team);
	}

	@Override
	public PageInfos<TeamInfo> findTeamByPage(TeamInfo team, PageInfos<TeamInfo> pageData) {
		PageHelper.startPage( (int)pageData.getPage(), (int)pageData.getPageSize());//pageNum, pageSize
		List<TeamInfo> list = teamInfoDao.findTeamList(team);
		PageInfo<TeamInfo> page = new PageInfo<TeamInfo>(list);
		pageData.setPage(page.getPageNum());      //当前页码
		pageData.setPageCount(page.getPages());   //总页数
		pageData.setPageSize(page.getPageSize()); //每页记录数
		pageData.setTotal(page.getTotal()); 
		pageData.setRows(page.getList());
		return pageData;
	}

	@Override
	public PageInfos<TeamDoctor> findTeamDoctorByPage(String teamno, PageInfos<TeamDoctor> pageData) {
		PageHelper.startPage( (int)pageData.getPage(), (int)pageData.getPageSize());//pageNum, pageSize
		List<TeamDoctor> list = teamDoctorDao.findTeamDoctorList(teamno);
		PageInfo<TeamDoctor> page = new PageInfo<TeamDoctor>(list);
		pageData.setPage(page.getPageNum());      //当前页码
		pageData.setPageCount(page.getPages());   //总页数
		pageData.setPageSize(page.getPageSize()); //每页记录数
		pageData.setTotal(page.getTotal()); 
		pageData.setRows(page.getList());
		return pageData;
	}

	@Override
	public void saveTeamDoctor(TeamDoctorBo doctor) {
		
		TeamDoctor td = new TeamDoctor();
		BeanUtils.copyProperties(doctor,td);
		TeamInfo team = teamInfoDao.getTeamByTeamNo(doctor.getTeamNo());
		DoctorInfo dinfo = new DoctorInfo();
		dinfo.setId(CodeUtil.getUUID());
		dinfo.setDoctorNo(doctor.getDoctorNo());
						
		dinfo.setStatus("2");

		doctorInfoDao.updateByDoctorNo(dinfo);
		
		td.setTeamName(team.getTeamName());
		teamDoctorDao.insertSelective(td);
		
		team.setMemberNum(team.getMemberNum() + 1);
		teamInfoDao.updateByPrimaryKeySelective(team);
	}

	@Override
	public List<DoctorInfo> findDoctorListByOrg(String orgCode) {
		return doctorInfoDao.findDoctorListByOrg(orgCode);
	}

	@Override
	public String findTeamByUser(String userCode) {
		String teamNo = "";
		DoctorInfo doctor = doctorInfoDao.getDoctorByUser(userCode);
		if(doctor != null){
			List<TeamDoctor> teams = teamDoctorDao.findTeamByDoctorNo(doctor.getDoctorNo());
			if(teams != null && teams.size() > 0){
				teamNo = teams.get(0).getTeamNo();
			}
		}
		return teamNo;
	}

	@Override
	public void removeDoctor(String doctorNo) {
		teamDoctorDao.deleteByDoctorNo(doctorNo);
		DoctorInfo dinfo = new DoctorInfo();
		dinfo.setStatus("1");
		dinfo.setDoctorNo(doctorNo);
		doctorInfoDao.updateByDoctorNo(dinfo);
	}
}
