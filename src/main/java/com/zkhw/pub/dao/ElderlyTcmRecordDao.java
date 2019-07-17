package com.zkhw.pub.dao;

import java.util.List;

import com.zkhw.pub.entity.ElderlyTcmRecord;
import com.zkhw.pub.vo.ArchiveId;
import com.zkhw.stat.query.ResidentQuery;
import com.zkhw.stat.vo.ElderlyRecordVo;

public interface ElderlyTcmRecordDao {
    int deleteByPrimaryKey(String id);

    int insert(ElderlyTcmRecord record);

    int insertSelective(ElderlyTcmRecord record);

    ElderlyTcmRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ElderlyTcmRecord record);

    int updateByPrimaryKey(ElderlyTcmRecord record);
    
    List<ElderlyTcmRecord> getRecordByArchiveNo(String archiveNo);
    
    List<ElderlyTcmRecord> findTcmListByExamId(String examId);
    
    int updateArchiveNo(ArchiveId archive);
    
    List<ElderlyTcmRecord> shanxiSyncList();
    
    List<ElderlyRecordVo> statForRecord(ResidentQuery query);
}