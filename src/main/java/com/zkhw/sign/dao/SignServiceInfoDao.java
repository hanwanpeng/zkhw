package com.zkhw.sign.dao;

import java.util.List;

import com.zkhw.sign.entity.SignServiceInfo;

public interface SignServiceInfoDao {
    int deleteByPrimaryKey(String id);

    int insert(SignServiceInfo record);

    int insertSelective(SignServiceInfo record);

    SignServiceInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SignServiceInfo record);

    int updateByPrimaryKey(SignServiceInfo record);
    
    List<SignServiceInfo> findSignServiceList(SignServiceInfo record);
}