package com.zkhw.pub.dao;

import java.util.List;

import com.zkhw.pub.entity.ResidentInfoTemp;

public interface ResidentInfoTempDao {
    int deleteByPrimaryKey(String id);

    int insert(ResidentInfoTemp record);

    int insertSelective(ResidentInfoTemp record);

    ResidentInfoTemp selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ResidentInfoTemp record);

    int updateByPrimaryKey(ResidentInfoTemp record);
    
    List<ResidentInfoTemp> findAll();
}