package com.zkhw.pub.dao;

import java.util.List;

import com.zkhw.pub.entity.FamilyArchive;

public interface FamilyArchiveDao {
    int deleteByPrimaryKey(String id);

    int insert(FamilyArchive record);

    int insertSelective(FamilyArchive record);

    FamilyArchive selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FamilyArchive record);

    int updateByPrimaryKey(FamilyArchive record);
    
    List<FamilyArchive> findFamilyArchiveList(FamilyArchive record);
}