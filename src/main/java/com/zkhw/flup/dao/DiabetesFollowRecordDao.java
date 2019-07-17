package com.zkhw.flup.dao;

import java.util.List;

import com.zkhw.flup.entity.DiabetesFollowRecord;

public interface DiabetesFollowRecordDao {
    int deleteByPrimaryKey(String id);

    int insert(DiabetesFollowRecord record);

    int insertSelective(DiabetesFollowRecord record);

    DiabetesFollowRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DiabetesFollowRecord record);

    int updateByPrimaryKey(DiabetesFollowRecord record);
    
    DiabetesFollowRecord findLastFollowRecord(String archiveNo);
    
    List<DiabetesFollowRecord> findFollowRecordList(DiabetesFollowRecord record);
    
    List<DiabetesFollowRecord> shanxiSyncList();
    
    List<DiabetesFollowRecord> findFollowByYear(DiabetesFollowRecord record);
}