package com.zkhw.sign.dao;

import com.zkhw.sign.entity.SignServiceItem;

public interface SignServiceItemDao {
    int deleteByPrimaryKey(String id);

    int insert(SignServiceItem record);

    int insertSelective(SignServiceItem record);

    SignServiceItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SignServiceItem record);

    int updateByPrimaryKey(SignServiceItem record);
}