package com.zkhw.flup.service;

import java.util.Map;

import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.bo.PsychosisFollowBo;
import com.zkhw.flup.bo.PsychosisListBo;
import com.zkhw.flup.entity.PsychosisFollowRecord;
import com.zkhw.flup.entity.PsychosisInfo;
import com.zkhw.pub.query.ResidentBaseInfoQuery;

public interface PsychosisService {

	PageInfos<PsychosisListBo> findPsychosisByPage(ResidentBaseInfoQuery redident,PageInfos<PsychosisListBo> pageData);
	
	PsychosisFollowBo getPsychosisFollowRecordById(String id);
	
	PageInfos<PsychosisFollowRecord> findFollowRecordByPage(PsychosisFollowRecord record, PageInfos<PsychosisFollowRecord> pageData);
	
	PsychosisInfo getPsychosisInfoByArchiveNo(String archiveNo);
	
	Map<String, String> exportInfoPdf(String archiveNo);
	
	Map<String, String> exportFollowPdf(String id);

	void psychosisForExcel(ResidentBaseInfoQuery redident);
}
