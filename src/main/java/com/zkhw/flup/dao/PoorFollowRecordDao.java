package com.zkhw.flup.dao;

import java.util.List;

import com.zkhw.flup.entity.PoorFollowRecord;

public interface PoorFollowRecordDao {
    int deleteByPrimaryKey(String id);

    int insert(PoorFollowRecord record);

    int insertSelective(PoorFollowRecord record);

    PoorFollowRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PoorFollowRecord record);

    int updateByPrimaryKey(PoorFollowRecord record);
    
    List<PoorFollowRecord> shanxiSyncList();

	PoorFollowRecord findLastFollowRecord(String archiveNo);
}