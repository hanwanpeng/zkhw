package com.zkhw.flup.dao;

import java.util.List;

import com.zkhw.flup.entity.ChildrenTcmRecord;

public interface ChildrenTcmRecordDao {
    int deleteByPrimaryKey(String id);

    int insert(ChildrenTcmRecord record);

    int insertSelective(ChildrenTcmRecord record);

    ChildrenTcmRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ChildrenTcmRecord record);

    int updateByPrimaryKey(ChildrenTcmRecord record);
    
    List<ChildrenTcmRecord> findFollowRecordByAge(ChildrenTcmRecord record);
}