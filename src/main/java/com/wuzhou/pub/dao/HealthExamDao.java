package com.wuzhou.pub.dao;

import com.wuzhou.pub.entity.HealthExam;

public interface HealthExamDao {
    int deleteByPrimaryKey(String healthExamId);

    int insert(HealthExam record);

    int insertSelective(HealthExam record);

    HealthExam selectByPrimaryKey(String healthExamId);

    int updateByPrimaryKeySelective(HealthExam record);

    int updateByPrimaryKey(HealthExam record);
}