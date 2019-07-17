package com.wuzhou.pub.dao;

import com.wuzhou.pub.entity.Pos;

public interface PosDao {
    int deleteByPrimaryKey(String posId);

    int insert(Pos record);

    int insertSelective(Pos record);

    Pos selectByPrimaryKey(String posId);

    int updateByPrimaryKeySelective(Pos record);

    int updateByPrimaryKey(Pos record);
}