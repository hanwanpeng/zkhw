package com.zkhw.pub.dao;

import java.util.List;

import com.zkhw.pub.entity.OperationRecord;

public interface OperationRecordDao {
    int deleteByPrimaryKey(String id);

    int insert(OperationRecord record);

    int insertSelective(OperationRecord record);

    List<OperationRecord> selectByArchiveNo(OperationRecord record);

    int updateByPrimaryKeySelective(OperationRecord record);

    int updateByPrimaryKey(OperationRecord record);
    
    int deleteByArchiveNo(String archiveNo);
}