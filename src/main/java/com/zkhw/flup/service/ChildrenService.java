package com.zkhw.flup.service;

import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.entity.ChildrenHealthRecord;
import com.zkhw.flup.entity.NeonatusInfo;

public interface ChildrenService {

	PageInfos<NeonatusInfo> findNeonatusByPage(NeonatusInfo neonatus,PageInfos<NeonatusInfo> pageData);
	
	NeonatusInfo getNeonatusById(String id);
	
	ChildrenHealthRecord findFollowRecordByAge(ChildrenHealthRecord record);

	void childrenForExcel(NeonatusInfo neonatus);
}
