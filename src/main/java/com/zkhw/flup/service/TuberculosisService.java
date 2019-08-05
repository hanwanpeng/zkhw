package com.zkhw.flup.service;

import java.util.Map;

import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.bo.TuberculosisListBo;
import com.zkhw.flup.entity.TuberculosisFollowRecord;
import com.zkhw.flup.entity.TuberculosisInfo;
import com.zkhw.pub.query.ResidentBaseInfoQuery;

public interface TuberculosisService {

	PageInfos<TuberculosisListBo> findTuberculosisByPage(ResidentBaseInfoQuery redident,PageInfos<TuberculosisListBo> pageData);
	
	TuberculosisFollowRecord getTuberculosisFollowRecordById(String id);
	
	PageInfos<TuberculosisFollowRecord> findFollowRecordByPage(TuberculosisFollowRecord record, PageInfos<TuberculosisFollowRecord> pageData);
	
	TuberculosisInfo getTuberculosisInfoByArchiveNo(String archiveNo);
	
	Map<String, String> exportInfoPdf(String archiveNo);
	
	Map<String, String> exportFollowPdf(String archiveNo, String year);

	void tuberculosisForExcel(ResidentBaseInfoQuery redident);
}
