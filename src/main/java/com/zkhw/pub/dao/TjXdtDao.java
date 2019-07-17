package com.zkhw.pub.dao;

import java.util.List;

import com.zkhw.pub.entity.TjXdt;

public interface TjXdtDao {
    int deleteByPrimaryKey(String id);

    int insert(TjXdt record);

    int insertSelective(TjXdt record);

    TjXdt selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TjXdt record);

    int updateByPrimaryKey(TjXdt record);
    
    List<TjXdt> findListByAichiveNo(String aichiveNo);
}