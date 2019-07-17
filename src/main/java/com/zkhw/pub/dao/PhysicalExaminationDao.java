package com.zkhw.pub.dao;

import java.util.List;

import com.zkhw.pub.entity.PhysicalExamination;
import com.zkhw.pub.vo.ArchiveId;
import com.zkhw.stat.query.ResidentQuery;
import com.zkhw.stat.vo.StatisticsVo;

public interface PhysicalExaminationDao {
    int deleteByPrimaryKey(String id);

    int insert(PhysicalExamination record);

    int insertSelective(PhysicalExamination record);

    PhysicalExamination selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhysicalExamination record);

    int updateByPrimaryKey(PhysicalExamination record);
    
    PhysicalExamination getLastByArchiveNo(String archiveNo);

    /**
     * 身份证号查询
     */
	PhysicalExamination physicalByIdNumber(String idNumber);
	
	/**
	 * 梧州同步列表
	 * @return
	 */
	List<PhysicalExamination> findWuzhouSyncList();
	
	List<PhysicalExamination> findShanxiSyncList();
	
	int updateArchiveNo(ArchiveId archive);
	
	/**
	 * 体检数量
	 */
	StatisticsVo allExamNum(ResidentQuery query);
	
	/**
	 * 根据组织机构查询体检信息
	 */
	List<PhysicalExamination> selectByOrg(String createOrg);
}