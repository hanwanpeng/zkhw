package com.zkhw.flup.service;

import java.util.List;

import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.bo.ElderlyListBo;
import com.zkhw.pub.entity.ElderlySelfcareEstimate;
import com.zkhw.pub.entity.ElderlyTcmRecord;
import com.zkhw.pub.query.ResidentBaseInfoQuery;

public interface ElderlyService {

	PageInfos<ElderlyListBo> findElderlyByPage(ResidentBaseInfoQuery redident,PageInfos<ElderlyListBo> pageData);
	
	List<ElderlyTcmRecord> getElderlyTcm(String archiveNo);
	
	ElderlyTcmRecord findTcmListByExamId(String examId);
	
	ElderlySelfcareEstimate getSelfcareListByExamid(String examid);
	
	ElderlyTcmRecord getTcmById(String id);
}
