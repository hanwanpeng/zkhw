package com.zkhw.flup.service;

import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.entity.ChildrenTcmRecord;
import com.zkhw.flup.entity.NeonatusInfo;

public interface ChildrenTcmService {

	PageInfos<NeonatusInfo> findNeonatusByPage(NeonatusInfo neonatus,PageInfos<NeonatusInfo> pageData);
	
	NeonatusInfo getNeonatusById(String id);
	
	ChildrenTcmRecord findFollowRecordByAge(ChildrenTcmRecord child);
}
