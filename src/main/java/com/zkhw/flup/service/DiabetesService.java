package com.zkhw.flup.service;

import java.util.Map;

import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.bo.DiabetesFollowBo;
import com.zkhw.flup.bo.DiabetesListBo;
import com.zkhw.flup.entity.DiabetesFollowRecord;
import com.zkhw.pub.query.ResidentBaseInfoQuery;

public interface DiabetesService {

	PageInfos<DiabetesListBo> findDiabetesByPage(ResidentBaseInfoQuery redident,PageInfos<DiabetesListBo> pageData);
	
	DiabetesFollowBo getDiabetesFollowRecordById(String id);
	
	PageInfos<DiabetesFollowRecord> findFollowRecordByPage(DiabetesFollowRecord record, PageInfos<DiabetesFollowRecord> pageData);
	
	Map<String, String> exportPdf(String archiveNo,String year);
}
