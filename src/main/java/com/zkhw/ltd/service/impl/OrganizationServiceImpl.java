package com.zkhw.ltd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.ltd.dao.OrganizationDao;
import com.zkhw.ltd.entity.Organization;
import com.zkhw.ltd.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationDao organizationDao;
	@Override
	public Organization getOrganizationByCode(String orgCode) {
		return organizationDao.getOrganizationByCode(orgCode);
	}
	
	@Override
	public List<Organization> findChildren(String orgCode) {
		return organizationDao.findChildren(orgCode);
	}

	@Override
	public int deleteOrganization(String orgCode) {
		return organizationDao.deleteOrganization(orgCode);
	}

	@Override
	public int saveOrganization(Organization organization) {
		return organizationDao.insertSelective(organization);
	}

	@Override
	public int updateOrganization(Organization organization) {
		return organizationDao.updateByPrimaryKeySelective(organization);
	}

	@Override
	public PageInfos<Organization> findOrganizationByPage(Organization organization, PageInfos<Organization> pageData) {
		PageHelper.startPage( (int)pageData.getPage(), (int)pageData.getPageSize());//pageNum, pageSize
		List<Organization> list = organizationDao.findOrganizationList(organization);
		//用PageInfo对结果进行包装
		PageInfo<Organization> page = new PageInfo<Organization>(list);
		//返回分页数据
		pageData.setPage(page.getPageNum());      //当前页码
		pageData.setPageCount(page.getPages());   //总页数
		pageData.setPageSize(page.getPageSize()); //每页记录数
		pageData.setTotal(page.getTotal());       //总记录数
		pageData.setRows(list);
		return pageData;
	}

	@Override
	public List<Organization> findOrganizationList(Organization record) {
		return organizationDao.findOrganizationList(record);
	}
}
