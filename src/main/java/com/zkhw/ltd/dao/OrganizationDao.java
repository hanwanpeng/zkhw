package com.zkhw.ltd.dao;

import java.util.List;

import com.zkhw.ltd.entity.Organization;

public interface OrganizationDao {
    int deleteByPrimaryKey(String id);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);
    
    Organization getOrganizationByCode(String orgCode);
    
    List<Organization> findChildren(String orgCode);
    
    int deleteOrganization(String orgCode);
    
    List<Organization> findOrganizationList(Organization record);
    
    List<Organization> selectByAreaCode(Organization organization);
}