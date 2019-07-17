package com.zkhw.flup.dao;

import com.zkhw.flup.entity.TuberculosisInfo;

public interface TuberculosisInfoDao {
    int deleteByPrimaryKey(String id);

    int insert(TuberculosisInfo record);

    int insertSelective(TuberculosisInfo record);

    TuberculosisInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TuberculosisInfo record);

    int updateByPrimaryKey(TuberculosisInfo record);
    
    TuberculosisInfo getTuberculosisByArchiveNo(String archiveNo);
}