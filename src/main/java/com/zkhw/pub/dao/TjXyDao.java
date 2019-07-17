package com.zkhw.pub.dao;

import java.util.List;

import com.zkhw.pub.entity.TjXy;

public interface TjXyDao {
    int deleteByPrimaryKey(String id);

    int insert(TjXy record);

    int insertSelective(TjXy record);

    TjXy selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TjXy record);

    int updateByPrimaryKey(TjXy record);
    
    List<TjXy> findListByAichiveNo(String aichiveNo);
}