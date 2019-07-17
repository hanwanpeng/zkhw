package com.zkhw.pub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.pub.dao.FamilyArchiveDao;
import com.zkhw.pub.dao.FamilyMemberDao;
import com.zkhw.pub.entity.FamilyArchive;
import com.zkhw.pub.entity.FamilyMember;
import com.zkhw.pub.service.FamilyArchiveService;

@Service
public class FamilyArchiveServiceImpl implements FamilyArchiveService{

	@Autowired
	private FamilyArchiveDao familyArchiveDao;
	
	@Autowired
	private FamilyMemberDao familyMemberDao;
	
	@Override
	public PageInfos<FamilyArchive> findFamilyArchiveByPage(FamilyArchive archive, PageInfos<FamilyArchive> pageData) {
		PageHelper.startPage( (int)pageData.getPage(), (int)pageData.getPageSize());//pageNum, pageSize
		List<FamilyArchive> list = familyArchiveDao.findFamilyArchiveList(archive);
		PageInfo<FamilyArchive> page = new PageInfo<FamilyArchive>(list);
		pageData.setPage(page.getPageNum());      //当前页码
		pageData.setPageCount(page.getPages());   //总页数
		pageData.setPageSize(page.getPageSize()); //每页记录数
		pageData.setTotal(page.getTotal());       //总记录数
		pageData.setRows(page.getList());
		return pageData;
	}

	@Override
	public int saveFamilyArchive(FamilyArchive archive) {
		return familyArchiveDao.insertSelective(archive);
	}

	@Override
	public int saveFamilyMember(FamilyMember member) {
		return familyMemberDao.insertSelective(member);
	}

	@Override
	public List<FamilyMember> findMemberList(String familyArchiveNo) {
		return familyMemberDao.findMemberList(familyArchiveNo);
	}

	@Override
	public PageInfos<FamilyMember> findMemberByPage(String familyArchiveNo) {
		List<FamilyMember> list= familyMemberDao.findMemberList(familyArchiveNo);
		PageInfos<FamilyMember> pageData = new PageInfos<FamilyMember>();
		pageData.setRows(list);
		return pageData;
	}

}
