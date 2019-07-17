package com.wuzhou.pub.dao;

import com.wuzhou.pub.entity.ElderCognition;

public interface ElderCognitionDao {
    int deleteByPrimaryKey(String elderCognitionId);

    int insert(ElderCognition record);

    int insertSelective(ElderCognition record);

    ElderCognition selectByPrimaryKey(String elderCognitionId);

    int updateByPrimaryKeySelective(ElderCognition record);

    int updateByPrimaryKey(ElderCognition record);
}