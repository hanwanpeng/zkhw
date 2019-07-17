package com.zkhw.sys.dao;

import com.zkhw.sys.entity.AppVersions;

public interface AppVersionsDao {
    int deleteByPrimaryKey(String id);

    int insert(AppVersions record);

    int insertSelective(AppVersions record);

    AppVersions selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AppVersions record);

    int updateByPrimaryKey(AppVersions record);
    
    AppVersions getHeadVersion();
}