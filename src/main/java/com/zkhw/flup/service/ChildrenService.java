package com.zkhw.flup.service;

import java.util.Map;

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
	
	Map<String, String> exportInfoPdf(String archiveNo);
	
	Map<String, String> exportFollowPdf(String archiveNo,String type);
}
