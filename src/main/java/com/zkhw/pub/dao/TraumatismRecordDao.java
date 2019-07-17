package com.zkhw.pub.dao;

import java.util.List;

import com.zkhw.pub.entity.TraumatismRecord;

public interface TraumatismRecordDao {
    int deleteByPrimaryKey(String id);

    int insert(TraumatismRecord record);

    int insertSelective(TraumatismRecord record);

    List<TraumatismRecord> selectByArchiveNo(TraumatismRecord record);

    int updateByPrimaryKeySelective(TraumatismRecord record);

    int updateByPrimaryKey(TraumatismRecord record);
    
    int deleteByArchiveNo(String archiveNo);
}