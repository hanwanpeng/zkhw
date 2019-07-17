package com.zkhw.pub.dao;

import java.util.List;

import com.zkhw.pub.entity.FamilyRecord;

public interface FamilyRecordDao {
    int deleteByPrimaryKey(String id);

    int insert(FamilyRecord record);

    int insertSelective(FamilyRecord record);

    List<FamilyRecord> selectByArchiveNo(FamilyRecord record);

    int updateByPrimaryKeySelective(FamilyRecord record);

    int updateByPrimaryKey(FamilyRecord record);
    
    int deleteByArchiveNo(String archiveNo);
}