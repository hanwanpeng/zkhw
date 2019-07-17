package com.zkhw.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.zkhw.api.bo.OrgInfo;
import com.zkhw.api.service.OrgService;
import com.zkhw.ltd.dao.OrganizationDao;
import com.zkhw.ltd.entity.Organization;

@Service
public class OrgServiceImpl implements OrgService{

	@Autowired
	private OrganizationDao organizationDao;
	
	@Override
	public List<OrgInfo> getOrgList(String startIndex, String returnSize, String duns) {
		
		int start = 0;		
		int total = 0;
		List<OrgInfo> orgList = new ArrayList<OrgInfo>();
		List<Organization> list = new ArrayList<Organization>();
		if(StringUtil.isEmpty(startIndex)){
			start = 1;
		}else{
			start = Integer.parseInt(startIndex);
		}
		
		if(StringUtil.isNotEmpty(returnSize)){
			total = Integer.parseInt(returnSize);
		}
		
		if(total != 0){
			PageHelper.startPage(start, total);//pageNum, pageSize	
		}	
		if(StringUtil.isNotEmpty(duns)){
			List<Organization> childList = organizationDao.findChildren(duns);
			Organization o = organizationDao.getOrganizationByCode(duns);
			list.add(o);
			list.addAll(childList);
		}else{
			list = organizationDao.findOrganizationList(new Organization());
		}
		for(int i = 0; i < list.size(); i++){
			Organization org = list.get(i);
			OrgInfo info = new OrgInfo();
			info.setADDRESS(org.getAddress());
			info.setDUNS(org.getOrganCode());
			info.setLEVELX(org.getOrganLevel());
			info.setNAME(org.getOrganName());
			info.setPARENTSID(org.getOrganParentCode());
			info.setUSESTATUS("1");
			info.setZZJGLM(org.getOrganCode().substring(org.getOrganCode().length() -3, org.getOrganCode().length()));
			orgList.add(info);
		}
		return orgList;
	}

}
