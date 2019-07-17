package com.zkhw.flup.dao;

import java.util.List;

import com.zkhw.flup.entity.FollowMedicineRecord;

public interface FollowMedicineRecordDao {
    int deleteByPrimaryKey(String id);

    int insert(FollowMedicineRecord record);

    int insertSelective(FollowMedicineRecord record);

    FollowMedicineRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FollowMedicineRecord record);

    int updateByPrimaryKey(FollowMedicineRecord record);
    
    List<FollowMedicineRecord> findMedicineListByFollowId(String followId);
}