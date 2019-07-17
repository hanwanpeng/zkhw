package com.zkhw.pub.dao;

import java.util.List;

import com.zkhw.pub.entity.FamilyMember;

public interface FamilyMemberDao {
    int deleteByPrimaryKey(String id);

    int insert(FamilyMember record);

    int insertSelective(FamilyMember record);

    FamilyMember selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FamilyMember record);

    int updateByPrimaryKey(FamilyMember record);
    
    List<FamilyMember> findMemberList(String familyArchiveNo);
}