package com.wuzhou.pub.dao;

import com.wuzhou.pub.entity.HealthExamInhos;

public interface HealthExamInhosDao {
    int deleteByPrimaryKey(String healthExamInhosId);

    int insert(HealthExamInhos record);

    int insertSelective(HealthExamInhos record);

    HealthExamInhos selectByPrimaryKey(String healthExamInhosId);

    int updateByPrimaryKeySelective(HealthExamInhos record);

    int updateByPrimaryKey(HealthExamInhos record);
}