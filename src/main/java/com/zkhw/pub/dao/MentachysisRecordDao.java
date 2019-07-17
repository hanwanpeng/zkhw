package com.zkhw.pub.dao;

import java.util.List;

import com.zkhw.pub.entity.MetachysisRecord;

public interface MentachysisRecordDao {
    int deleteByPrimaryKey(String id);

    int insert(MetachysisRecord record);

    int insertSelective(MetachysisRecord record);

    List<MetachysisRecord> selectByArchiveNo(MetachysisRecord record);

    int updateByPrimaryKeySelective(MetachysisRecord record);

    int updateByPrimaryKey(MetachysisRecord record);
    
    int deleteByArchiveNo(String archiveNo);
}