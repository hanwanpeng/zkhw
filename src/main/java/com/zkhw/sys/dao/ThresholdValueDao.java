package com.zkhw.sys.dao;

import java.util.List;

import com.zkhw.sys.entity.ThresholdValue;

public interface ThresholdValueDao {
    int deleteByPrimaryKey(String id);

    int insert(ThresholdValue record);

    int insertSelective(ThresholdValue record);

    ThresholdValue selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ThresholdValue record);

    int updateByPrimaryKey(ThresholdValue record);
    
    List<ThresholdValue> findThresholdList(ThresholdValue record);
    
    int updateByType(ThresholdValue record);
}