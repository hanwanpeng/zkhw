package com.zkhw.flup.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.bo.HypertensionInfoBo;
import com.zkhw.flup.bo.HypertensionListBo;
import com.zkhw.pub.query.ResidentBaseInfoQuery;

public interface HypertensionService {

	PageInfos<HypertensionListBo> findHypertensionByPage(ResidentBaseInfoQuery redident,PageInfos<HypertensionListBo> pageData);
	HypertensionInfoBo getHypertensionFollowRecordById(String id);
	
	Map<String, String> exportPdf(String archiveNo,String year);
	void hypertensionForExcel(ApiJsonResult result,HttpServletRequest request,HttpServletResponse response,ResidentBaseInfoQuery resident);
}
