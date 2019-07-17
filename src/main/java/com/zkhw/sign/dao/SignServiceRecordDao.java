package com.zkhw.sign.dao;

import com.zkhw.sign.entity.SignServiceRecord;

public interface SignServiceRecordDao {
    int deleteByPrimaryKey(String id);

    int insert(SignServiceRecord record);

    int insertSelective(SignServiceRecord record);

    SignServiceRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SignServiceRecord record);

    int updateByPrimaryKey(SignServiceRecord record);
}