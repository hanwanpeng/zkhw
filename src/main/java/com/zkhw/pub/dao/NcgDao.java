package com.zkhw.pub.dao;

import com.zkhw.pub.entity.Ncg;

public interface NcgDao {
    int deleteByPrimaryKey(String id);

    int insert(Ncg record);

    int insertSelective(Ncg record);

    Ncg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Ncg record);

    int updateByPrimaryKey(Ncg record);
}