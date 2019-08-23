package com.zkhw.flup.service;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zkhw.common.vo.ApiJsonResult;
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

	void diabetesForExcel(ApiJsonResult result, HttpServletRequest request, HttpServletResponse response, ResidentBaseInfoQuery redident) throws UnsupportedEncodingException;
}
