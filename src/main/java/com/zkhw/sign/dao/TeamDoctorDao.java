package com.zkhw.sign.dao;

import java.util.List;

import com.zkhw.sign.entity.TeamDoctor;

public interface TeamDoctorDao {
    int deleteByPrimaryKey(String id);

    int insert(TeamDoctor record);

    int insertSelective(TeamDoctor record);

    TeamDoctor selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TeamDoctor record);

    int updateByPrimaryKey(TeamDoctor record);
    
    List<TeamDoctor> findTeamDoctorList(String teamno);
    
    List<TeamDoctor> findTeamByDoctorNo(String doctorNo);
    
    void deleteByDoctorNo(String doctorNo);
}