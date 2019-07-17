package com.zkhw.sign.service;

import java.util.List;

import com.zkhw.common.vo.PageInfos;
import com.zkhw.ltd.entity.User;
import com.zkhw.sign.entity.ServiceItem;
import com.zkhw.sign.entity.SignServiceInfo;

public interface FamilySignService {
	
	List<ServiceItem> findServiceItems();
	
	int checkArchiveNo(String archiveNo);
	
	int saveSignService(SignServiceInfo info, User user, String items);
	
	PageInfos<SignServiceInfo> findSignServiceByPage(SignServiceInfo sign, PageInfos<SignServiceInfo> pageData);

}
