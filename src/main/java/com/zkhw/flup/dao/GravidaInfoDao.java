package com.zkhw.flup.dao;

import java.util.List;

import com.zkhw.flup.entity.GravidaInfo;
import com.zkhw.flup.query.GravidaInfoQuery;
import com.zkhw.stat.query.ResidentQuery;
import com.zkhw.stat.vo.GravidaVo;

public interface GravidaInfoDao {
    int deleteByPrimaryKey(String id);

    int insert(GravidaInfo record);

    int insertSelective(GravidaInfo record);

    GravidaInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GravidaInfo record);

    int updateByPrimaryKey(GravidaInfo record);
    
    List<GravidaInfo> findGravidaList(GravidaInfoQuery gravida);

	GravidaVo statForGravida(ResidentQuery query);
	
	GravidaInfo getGravidaByArchiveNo(String archiveNo);
}