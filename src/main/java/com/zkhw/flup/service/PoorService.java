package com.zkhw.flup.service;

import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.bo.PoorListBo;
import com.zkhw.pub.query.ResidentBaseInfoQuery;

public interface PoorService {

	PageInfos<PoorListBo> findPoorByPage(ResidentBaseInfoQuery redident, PageInfos<PoorListBo> pageData);
	PoorListBo getPoorFollowRecordById(String id);
}
