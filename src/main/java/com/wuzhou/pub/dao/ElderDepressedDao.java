package com.wuzhou.pub.dao;

import com.wuzhou.pub.entity.ElderDepressed;

public interface ElderDepressedDao {
    int deleteByPrimaryKey(String elderDepressedId);

    int insert(ElderDepressed record);

    int insertSelective(ElderDepressed record);

    ElderDepressed selectByPrimaryKey(String elderDepressedId);

    int updateByPrimaryKeySelective(ElderDepressed record);

    int updateByPrimaryKey(ElderDepressed record);
}