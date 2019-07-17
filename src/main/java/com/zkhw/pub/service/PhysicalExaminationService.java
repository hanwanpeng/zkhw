package com.zkhw.pub.service;

import java.util.Map;

import com.zkhw.common.vo.PageInfos;
import com.zkhw.pub.entity.ResidentBaseInfo;
import com.zkhw.pub.query.ResidentBaseInfoQuery;
import com.zkhw.pub.vo.ExaminationListVo;
import com.zkhw.pub.vo.PhysicalExaminationVo;
import com.zkhw.pub.vo.TjDataVo;

public interface PhysicalExaminationService {

	PhysicalExaminationVo getPhysicalExaminationByArchiveNo(String archiveNo);

	PhysicalExaminationVo physicalByIdNumber(String idNumber);

	void updatePhysical(PhysicalExaminationVo vo);
	
	Map<String, String> exportPdf(String archiveNo);
	
	PageInfos<ExaminationListVo> findPhysicalExaminationByPage(ResidentBaseInfoQuery record,PageInfos<ResidentBaseInfo> pageData);
	
	TjDataVo findTjData(String archiveNo);
}
