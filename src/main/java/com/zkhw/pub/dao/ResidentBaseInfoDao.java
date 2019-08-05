package com.zkhw.pub.dao;

import java.util.List;

import com.zkhw.pub.entity.ResidentBaseInfo;
import com.zkhw.pub.query.ResidentBaseInfoQuery;
import com.zkhw.stat.query.ResidentQuery;
import com.zkhw.stat.vo.ElderlyEstimateVo;
import com.zkhw.stat.vo.ElderlyRecordVo;
import com.zkhw.stat.vo.ElderlyVo;
import com.zkhw.stat.vo.FlupVo;
import com.zkhw.stat.vo.PersonVo;
import com.zkhw.stat.vo.ResidentAgeVo;
import com.zkhw.stat.vo.StatResidentVo;

public interface ResidentBaseInfoDao {
    int deleteByPrimaryKey(String id);

    int insert(ResidentBaseInfo record);
    /**
     * 添加居民健康档案
     */
    int insertSelective(ResidentBaseInfo info);

    ResidentBaseInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ResidentBaseInfo record);

    int updateByPrimaryKey(ResidentBaseInfo record);
    
    List<ResidentBaseInfo> findResidentList(ResidentBaseInfoQuery record);

    List<ResidentBaseInfo> findResidentByArchiveNo(String archiveNo);
    
    int updateByArchiveNo(ResidentBaseInfo record);
    
    ResidentBaseInfo findResidentByIdNumber(String idNumber);
    
    StatResidentVo statResidentForMan(ResidentQuery query);

    List<ResidentBaseInfo> statForAge(ResidentQuery query);

	ElderlyVo statForElderly(ResidentQuery query);

	List<ElderlyVo> statForElderlyNnm(ResidentQuery query);

	List<FlupVo> statForFlup(ResidentQuery query);

	PersonVo statForIdNumber(ResidentQuery query);
	
}