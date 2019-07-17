package com.wuzhou.pub.dao;

import com.wuzhou.pub.entity.HealthExamDrug;

public interface HealthExamDrugDao {
    int deleteByPrimaryKey(String healthExamDrugId);

    int insert(HealthExamDrug record);

    int insertSelective(HealthExamDrug record);

    HealthExamDrug selectByPrimaryKey(String healthExamDrugId);

    int updateByPrimaryKeySelective(HealthExamDrug record);

    int updateByPrimaryKey(HealthExamDrug record);
}