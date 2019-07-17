package com.zkhw.sign.dao;

import java.util.List;

import com.zkhw.sign.entity.TeamInfo;

public interface TeamInfoDao {
    int deleteByPrimaryKey(String id);

    int insert(TeamInfo record);

    int insertSelective(TeamInfo record);

    TeamInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TeamInfo record);

    int updateByPrimaryKey(TeamInfo record);
    
    List<TeamInfo> findTeamList(TeamInfo record);
    
    TeamInfo getTeamByTeamNo(String teamNo);
    
}