package com.wuzhou.pub.dao;

import com.wuzhou.pub.entity.HealthExamNoplanvacc;

public interface HealthExamNoplanvaccDao {
    int deleteByPrimaryKey(String healthExamNoplanVaccId);

    int insert(HealthExamNoplanvacc record);

    int insertSelective(HealthExamNoplanvacc record);

    HealthExamNoplanvacc selectByPrimaryKey(String healthExamNoplanVaccId);

    int updateByPrimaryKeySelective(HealthExamNoplanvacc record);

    int updateByPrimaryKey(HealthExamNoplanvacc record);
}