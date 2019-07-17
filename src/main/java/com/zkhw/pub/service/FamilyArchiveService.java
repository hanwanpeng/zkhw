package com.zkhw.pub.service;

import java.util.List;

import com.zkhw.common.vo.PageInfos;
import com.zkhw.pub.entity.FamilyArchive;
import com.zkhw.pub.entity.FamilyMember;

public interface FamilyArchiveService {

	PageInfos<FamilyArchive> findFamilyArchiveByPage(FamilyArchive archive,PageInfos<FamilyArchive> pageData);
	
	int saveFamilyArchive(FamilyArchive archive);
	
	int saveFamilyMember(FamilyMember member);
	
	 List<FamilyMember> findMemberList(String familyArchiveNo);
	 
	 PageInfos<FamilyMember> findMemberByPage(String familyArchiveNo);
}
