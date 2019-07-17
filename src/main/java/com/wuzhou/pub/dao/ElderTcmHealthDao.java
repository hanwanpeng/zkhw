package com.wuzhou.pub.dao;

import com.wuzhou.pub.entity.ElderTcmHealth;

public interface ElderTcmHealthDao {
    int deleteByPrimaryKey(String elderTcmHealthId);

    int insert(ElderTcmHealth record);

    int insertSelective(ElderTcmHealth record);

    ElderTcmHealth selectByPrimaryKey(String elderTcmHealthId);

    int updateByPrimaryKeySelective(ElderTcmHealth record);

    int updateByPrimaryKey(ElderTcmHealth record);
}