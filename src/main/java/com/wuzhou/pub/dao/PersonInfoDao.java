package com.wuzhou.pub.dao;

import com.wuzhou.pub.entity.PersonInfo;

public interface PersonInfoDao {
    int deleteByPrimaryKey(String personInfoId);

    int insert(PersonInfo record);

    int insertSelective(PersonInfo record);

    PersonInfo selectByPrimaryKey(String personInfoId);

    int updateByPrimaryKeySelective(PersonInfo record);

    int updateByPrimaryKey(PersonInfo record);
}