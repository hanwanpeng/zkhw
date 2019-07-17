package com.zkhw.flup.service;

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
}
