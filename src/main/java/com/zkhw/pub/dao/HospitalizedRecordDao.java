package com.zkhw.pub.dao;

import java.util.List;

import com.zkhw.pub.entity.HospitalizedRecord;
import com.zkhw.pub.vo.ArchiveId;

public interface HospitalizedRecordDao {
    int deleteByPrimaryKey(String id);

    int insert(HospitalizedRecord record);

    int insertSelective(HospitalizedRecord record);

    HospitalizedRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(HospitalizedRecord record);

    int updateByPrimaryKey(HospitalizedRecord record);
    
    List<HospitalizedRecord> findRecordByExamId(String examId);
    
    int updateArchiveNo(ArchiveId archive);
}