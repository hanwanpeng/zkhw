package com.zkhw.flup.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.entity.GravidaAfterRecord;
import com.zkhw.flup.entity.GravidaFollowRecord;
import com.zkhw.flup.entity.GravidaInfo;
import com.zkhw.flup.query.GravidaInfoQuery;

public interface GravidaService {

	PageInfos<GravidaInfo> findGravidaByPage(GravidaInfoQuery gravida, PageInfos<GravidaInfo> pageData);

	GravidaInfo getGravidaInfoById(String id);

	GravidaFollowRecord findFollowRecordByOtherNum(GravidaFollowRecord gravida);

	
	GravidaAfterRecord selectByPrimaryKey(String id);

	PageInfos<GravidaAfterRecord> findGravidaAfterByPage(GravidaAfterRecord gravida, PageInfos<GravidaAfterRecord> pageData);

	void gravidaForExcel(HttpServletRequest request, HttpServletResponse response,ApiJsonResult result,GravidaInfoQuery gravida);
	
	
	Map<String, String> exportInfoPdf(String archiveNo);
	
	Map<String, String> exportFollowPdf(String gravidaId);
	
	Map<String, String> exportAfterPdf(String gravidaId,String type);
	
}
