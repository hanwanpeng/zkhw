package com.zkhw.flup.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.entity.ChildrenHealthRecord;
import com.zkhw.flup.entity.NeonatusInfo;

public interface ChildrenService {

	PageInfos<NeonatusInfo> findNeonatusByPage(NeonatusInfo neonatus,PageInfos<NeonatusInfo> pageData);
	
	NeonatusInfo getNeonatusById(String id);
	
	ChildrenHealthRecord findFollowRecordByAge(ChildrenHealthRecord record);

	void childrenForExcel(HttpServletRequest request, HttpServletResponse response,ApiJsonResult result,NeonatusInfo neonatus);
}
