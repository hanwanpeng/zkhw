package com.zkhw.pub.dao;

import java.util.List;

import com.zkhw.pub.entity.TjSh;

public interface TjShDao {
    int deleteByPrimaryKey(String id);

    int insert(TjSh record);

    int insertSelective(TjSh record);

    TjSh selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TjSh record);

    int updateByPrimaryKey(TjSh record);
    
    List<TjSh> findListByAichiveNo(String aichiveNo);
}