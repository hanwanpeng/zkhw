package com.zkhw.flup.dao;

import java.util.List;

import com.zkhw.flup.entity.TuberculosisFollowRecord;

public interface TuberculosisFollowRecordDao {
    int deleteByPrimaryKey(String id);

    int insert(TuberculosisFollowRecord record);

    int insertSelective(TuberculosisFollowRecord record);

    TuberculosisFollowRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TuberculosisFollowRecord record);

    int updateByPrimaryKey(TuberculosisFollowRecord record);
    
    List<TuberculosisFollowRecord> findFollowRecordList(TuberculosisFollowRecord record);
    
    TuberculosisFollowRecord findLastFollowRecord(String archiveNo);
    
    List<TuberculosisFollowRecord> findFollowByYear(TuberculosisFollowRecord record);
}