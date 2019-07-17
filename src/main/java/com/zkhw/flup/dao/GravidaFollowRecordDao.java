package com.zkhw.flup.dao;

import java.util.List;

import com.zkhw.flup.entity.GravidaFollowRecord;

public interface GravidaFollowRecordDao {
    int deleteByPrimaryKey(String id);

    int insert(GravidaFollowRecord record);

    int insertSelective(GravidaFollowRecord record);

    GravidaFollowRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GravidaFollowRecord record);

    int updateByPrimaryKey(GravidaFollowRecord record);
    
    List<GravidaFollowRecord> findFollowByGravidaId(String gravidaId);

	List<GravidaFollowRecord> findFollowRecordByOtherNum(GravidaFollowRecord gravida);

}