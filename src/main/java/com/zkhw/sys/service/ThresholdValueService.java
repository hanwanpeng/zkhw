package com.zkhw.sys.service;

import java.util.List;

import com.zkhw.common.vo.PageInfos;
import com.zkhw.sys.entity.ThresholdValue;

public interface ThresholdValueService {

	PageInfos<ThresholdValue> findThresholdByPage(ThresholdValue record, PageInfos<ThresholdValue> pageData);
	
	int saveThreshold(ThresholdValue record);
	
	int updateThreshold(ThresholdValue record);
	
	ThresholdValue getThresholdById(String id);
	
	List<ThresholdValue> findThresholdList(ThresholdValue record);
	
	int updateByType(ThresholdValue record);
}
