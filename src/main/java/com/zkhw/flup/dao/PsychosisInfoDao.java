package com.zkhw.flup.dao;

import com.zkhw.flup.entity.PsychosisInfo;

public interface PsychosisInfoDao {
    int deleteByPrimaryKey(String id);

    int insert(PsychosisInfo record);

    int insertSelective(PsychosisInfo record);

    PsychosisInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PsychosisInfo record);

    int updateByPrimaryKey(PsychosisInfo record);
    
    PsychosisInfo getPsychosisByArchiveNo(String archiveNo);
}