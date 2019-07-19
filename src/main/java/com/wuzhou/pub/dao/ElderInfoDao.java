package com.wuzhou.pub.dao;

import java.util.List;

import com.wuzhou.pub.entity.ElderInfo;

public interface ElderInfoDao {
    int deleteByPrimaryKey(String elderInfoId);

    int insert(ElderInfo record);

    int insertSelective(ElderInfo record);

    ElderInfo selectByPrimaryKey(String elderInfoId);

    int updateByPrimaryKeySelective(ElderInfo record);

    int updateByPrimaryKey(ElderInfo record);
    
    List<ElderInfo> findByPersonInfoId(String personInfoId);
}