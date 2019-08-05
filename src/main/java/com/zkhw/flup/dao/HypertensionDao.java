package com.zkhw.flup.dao;

import java.util.List;

import com.zkhw.flup.entity.Hypertension;
import com.zkhw.stat.query.ResidentQuery;

public interface HypertensionDao {
    int deleteByPrimaryKey(String id);

    int insert(Hypertension record);

    int insertSelective(Hypertension record);

    Hypertension selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Hypertension record);

    int updateByPrimaryKey(Hypertension record);
    
    Hypertension findLastFollowRecord(String archiveNo);
    
    List<Hypertension> shanxiSyncList();
    
    List<Hypertension> findFollowByYear(Hypertension record);

	List<Hypertension> statForIdNumber(ResidentQuery query);
}