package com.zkhw.ltd.service;

import java.util.List;

import com.zkhw.common.vo.PageInfos;
import com.zkhw.ltd.entity.Organization;

public interface OrganizationService {

	Organization getOrganizationByCode(String orgCode);
	
	List<Organization> findChildren(String orgCode);
	
	int deleteOrganization(String orgCode);
	
	int saveOrganization(Organization organization);
	
	int updateOrganization(Organization organization);
	
	PageInfos<Organization> findOrganizationByPage(Organization organization,PageInfos<Organization> pageData);
	
	
	List<Organization> findOrganizationList(Organization record);
	
	
}
