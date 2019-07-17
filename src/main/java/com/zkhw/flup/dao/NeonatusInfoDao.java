package com.zkhw.flup.dao;

import java.util.List;

import com.zkhw.flup.entity.NeonatusInfo;
import com.zkhw.stat.query.ResidentQuery;
import com.zkhw.stat.vo.ChildVo;

public interface NeonatusInfoDao {
    int deleteByPrimaryKey(String id);

    int insert(NeonatusInfo record);

    int insertSelective(NeonatusInfo record);

    NeonatusInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(NeonatusInfo record);

    int updateByPrimaryKey(NeonatusInfo record);
    
    List<NeonatusInfo> findNeonatusList(NeonatusInfo record);
    
    NeonatusInfo getNeonatusByArchiveNo(String archiveNo);

	ChildVo statForChild(ResidentQuery query);
       
}