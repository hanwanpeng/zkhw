package com.zkhw.pub.dao;

import java.util.List;

import com.zkhw.pub.entity.TakeMedicineRecord;
import com.zkhw.pub.vo.ArchiveId;

public interface TakeMedicineRecordDao {
    int deleteByPrimaryKey(String id);

    int insert(TakeMedicineRecord record);

    int insertSelective(TakeMedicineRecord record);

    TakeMedicineRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TakeMedicineRecord record);

    int updateByPrimaryKey(TakeMedicineRecord record);
    
    List<TakeMedicineRecord> findRecordByExamId(String examId);
    
    int updateArchiveNo(ArchiveId archive);
}