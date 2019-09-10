package com.zkhw.pub.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.pub.entity.ResidentBaseInfo;
import com.zkhw.pub.mo.ResidentMo;
import com.zkhw.pub.query.ResidentBaseInfoQuery;
import com.zkhw.pub.vo.ResidentVo;

public interface ResidentBaseInfoService {

	int saveResidentBaseInfo(ResidentBaseInfo info);
	
	PageInfos<ResidentBaseInfo> findResidentByPage(ResidentBaseInfoQuery record,PageInfos<ResidentBaseInfo> pageData);

	/**
	 * 添加居民健康档案
	 */
	void saveResident(ResidentVo vo);

	

	/**
	 * 展示居民健康档案
	 * @return 
	 */
	ResidentMo showResident(ResidentBaseInfoQuery query);
	
	
	Map<String, String> exportPdf(String archiveNo);
	
	int updateResident(ResidentVo vo);

	public void residentBaseInfoForExcel(HttpServletRequest request, HttpServletResponse response,ApiJsonResult result,ResidentBaseInfoQuery resident);

	public void elderlyForExcel(HttpServletRequest request, HttpServletResponse response,ApiJsonResult result,ResidentBaseInfoQuery resident);

	public void minElderlyForExcel(HttpServletRequest request, HttpServletResponse response,ApiJsonResult result,ResidentBaseInfoQuery resident);

}
 