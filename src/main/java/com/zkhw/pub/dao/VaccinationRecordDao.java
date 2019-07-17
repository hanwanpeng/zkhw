package com.zkhw.pub.dao;

import java.util.List;

import com.zkhw.pub.entity.VaccinationRecord;
import com.zkhw.pub.vo.ArchiveId;

public interface VaccinationRecordDao {
    int deleteByPrimaryKey(String id);

    int insert(VaccinationRecord record);

    int insertSelective(VaccinationRecord record);

    VaccinationRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(VaccinationRecord record);

    int updateByPrimaryKey(VaccinationRecord record);
    
    List<VaccinationRecord> findRecordByExamId(String examId);
    
    int updateArchiveNo(ArchiveId archive);
}