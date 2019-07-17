package com.zkhw.pub.dao;

import java.util.List;

import com.zkhw.pub.entity.TjBc;

public interface TjBcDao {
    int deleteByPrimaryKey(String id);

    int insert(TjBc record);

    int insertSelective(TjBc record);

    TjBc selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TjBc record);

    int updateByPrimaryKey(TjBc record);
    
    List<TjBc> findListByAichiveNo(String aichiveNo);
}