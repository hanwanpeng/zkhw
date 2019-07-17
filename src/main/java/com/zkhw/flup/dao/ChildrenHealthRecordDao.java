package com.zkhw.flup.dao;

import java.util.List;

import com.zkhw.flup.entity.ChildrenHealthRecord;

public interface ChildrenHealthRecordDao {
    int deleteByPrimaryKey(String id);

    int insert(ChildrenHealthRecord record);

    int insertSelective(ChildrenHealthRecord record);

    ChildrenHealthRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ChildrenHealthRecord record);

    int updateByPrimaryKey(ChildrenHealthRecord record);
    
    List<ChildrenHealthRecord> findFollowRecordByAge(ChildrenHealthRecord record);
}