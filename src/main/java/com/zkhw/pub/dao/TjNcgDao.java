package com.zkhw.pub.dao;

import java.util.List;

import com.zkhw.pub.entity.TjNcg;

public interface TjNcgDao {
    int deleteByPrimaryKey(String id);

    int insert(TjNcg record);

    int insertSelective(TjNcg record);

    TjNcg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TjNcg record);

    int updateByPrimaryKey(TjNcg record);
    
    List<TjNcg> findListByAichiveNo(String aichiveNo);
}