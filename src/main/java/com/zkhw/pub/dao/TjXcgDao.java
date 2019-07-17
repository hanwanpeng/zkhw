package com.zkhw.pub.dao;

import java.util.List;

import com.zkhw.pub.entity.TjXcg;

public interface TjXcgDao {
    int deleteByPrimaryKey(String id);

    int insert(TjXcg record);

    int insertSelective(TjXcg record);

    TjXcg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TjXcg record);

    int updateByPrimaryKey(TjXcg record);
    
    List<TjXcg> findListByAichiveNo(String aichiveNo);
}