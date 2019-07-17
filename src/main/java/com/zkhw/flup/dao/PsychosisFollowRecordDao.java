package com.zkhw.flup.dao;

import java.util.List;

import com.zkhw.flup.entity.PsychosisFollowRecord;

public interface PsychosisFollowRecordDao {
    int deleteByPrimaryKey(String id);

    int insert(PsychosisFollowRecord record);

    int insertSelective(PsychosisFollowRecord record);

    PsychosisFollowRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PsychosisFollowRecord record);

    int updateByPrimaryKey(PsychosisFollowRecord record);
    
    PsychosisFollowRecord findLastFollowRecord(String archiveNo);
    
    
    List<PsychosisFollowRecord> findFollowRecordList(PsychosisFollowRecord record);
}