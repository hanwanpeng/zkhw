package com.zkhw.flup.dao;

import java.util.List;

import com.zkhw.flup.entity.GravidaAfterRecord;

public interface GravidaAfterRecordDao {
    int deleteByPrimaryKey(String id);

    int insert(GravidaAfterRecord record);

    int insertSelective(GravidaAfterRecord record);

    GravidaAfterRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GravidaAfterRecord record);

    int updateByPrimaryKey(GravidaAfterRecord record);
    
    List<GravidaAfterRecord> findAfterByGravidaId(String gravidaId);
}