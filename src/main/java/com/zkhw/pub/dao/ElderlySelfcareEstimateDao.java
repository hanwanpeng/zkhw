package com.zkhw.pub.dao;

import java.util.List;

import com.zkhw.pub.entity.ElderlySelfcareEstimate;
import com.zkhw.pub.vo.ArchiveId;
import com.zkhw.stat.query.ResidentQuery;
import com.zkhw.stat.vo.ElderlyEstimateVo;

public interface ElderlySelfcareEstimateDao {
    int deleteByPrimaryKey(String id);

    int insert(ElderlySelfcareEstimate record);

    int insertSelective(ElderlySelfcareEstimate record);

    ElderlySelfcareEstimate selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ElderlySelfcareEstimate record);

    int updateByPrimaryKey(ElderlySelfcareEstimate record);
    
    List<ElderlySelfcareEstimate> findSelfcareListByExamid(String examid);
    
    int updateArchiveNo(ArchiveId archive);
    
    ElderlyEstimateVo statForEstimate(ResidentQuery query);
}