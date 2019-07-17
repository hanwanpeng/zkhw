package com.zkhw.pub.dao;

import java.util.List;

import com.zkhw.pub.entity.TjSgtz;

public interface TjSgtzDao {
    int deleteByPrimaryKey(String id);

    int insert(TjSgtz record);

    int insertSelective(TjSgtz record);

    TjSgtz selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TjSgtz record);

    int updateByPrimaryKey(TjSgtz record);
    
    List<TjSgtz> findListByAichiveNo(String aichiveNo);
}