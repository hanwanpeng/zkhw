package com.zkhw.pub.dao;

import java.util.List;

import com.zkhw.pub.entity.ResidentDiseases;

public interface ResidentDiseasesDao {
    int deleteByPrimaryKey(String id);

    int insert(ResidentDiseases record);

    int insertSelective(ResidentDiseases record);

    List<ResidentDiseases> selectByArchiveNo(ResidentDiseases record);

    int updateByPrimaryKeySelective(ResidentDiseases record);

    int updateByPrimaryKey(ResidentDiseases record);
    
    int deleteByArchiveNo(String archiveNo);
}