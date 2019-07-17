package com.zkhw.flup.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.bo.ElderlyListBo;
import com.zkhw.flup.service.ElderlyService;
import com.zkhw.pub.dao.ElderlySelfcareEstimateDao;
import com.zkhw.pub.dao.ElderlyTcmRecordDao;
import com.zkhw.pub.dao.PhysicalExaminationDao;
import com.zkhw.pub.dao.ResidentBaseInfoDao;
import com.zkhw.pub.entity.ElderlySelfcareEstimate;
import com.zkhw.pub.entity.ElderlyTcmRecord;
import com.zkhw.pub.entity.PhysicalExamination;
import com.zkhw.pub.entity.ResidentBaseInfo;
import com.zkhw.pub.query.ResidentBaseInfoQuery;

@Service
public class ElderlyServiceImpl implements ElderlyService {

	@Autowired
	private ResidentBaseInfoDao residentBaseInfoDao;
	
	@Autowired
	private ElderlyTcmRecordDao elderlyTcmRecordDao;
	
	@Autowired
	private ElderlySelfcareEstimateDao elderlySelfcareEstimateDao;
	
	@Autowired
	private PhysicalExaminationDao physicalExaminationDao;
	
	@Override
	public PageInfos<ElderlyListBo> findElderlyByPage(ResidentBaseInfoQuery redident,
			PageInfos<ElderlyListBo> pageData) {
		PageHelper.startPage( (int)pageData.getPage(), (int)pageData.getPageSize());//pageNum, pageSize
		List<ResidentBaseInfo> list = residentBaseInfoDao.findResidentList(redident);
		PageInfo<ResidentBaseInfo> page = new PageInfo<ResidentBaseInfo>(list);
		List<ElderlyListBo> elderlyList = new ArrayList<ElderlyListBo>();
		for(int i = 0; i < list.size(); i++){
			ElderlyListBo bo = new ElderlyListBo();
			BeanUtils.copyProperties(list.get(i), bo);
			PhysicalExamination exam = physicalExaminationDao.getLastByArchiveNo(list.get(i).getArchiveNo());
			if(exam != null){
				bo.setExamId(exam.getId());
				bo.setCheckDate(exam.getCheckDate());
				bo.setBaseDoctor(exam.getBaseDoctor());
				bo.setHealthEvaluation(exam.getHealthEvaluation());
				bo.setHealthGuidance(exam.getHealthGuidance());
			}
			elderlyList.add(bo);
		}
		pageData.setPage(page.getPageNum());      //当前页码
		pageData.setPageCount(page.getPages());   //总页数
		pageData.setPageSize(page.getPageSize()); //每页记录数
		pageData.setTotal(page.getTotal());       //总记录数
		pageData.setRows(elderlyList);
		return pageData;
	}

	@Override
	public List<ElderlyTcmRecord> getElderlyTcm(String archiveNo) {
		return elderlyTcmRecordDao.getRecordByArchiveNo(archiveNo);
	}

	@Override
	public ElderlyTcmRecord findTcmListByExamId(String examId) {
		List<ElderlyTcmRecord> list = elderlyTcmRecordDao.findTcmListByExamId(examId);
		if(list != null && list.size() > 0 ){
			return list.get(0);
		}else{
			return null;
		}

	}

	@Override
	public ElderlySelfcareEstimate getSelfcareListByExamid(String examid) {
		// TODO Auto-generated method stub
		List<ElderlySelfcareEstimate> list = elderlySelfcareEstimateDao.findSelfcareListByExamid(examid);
		if(list != null && list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
		
	}

	@Override
	public ElderlyTcmRecord getTcmById(String id) {
		return elderlyTcmRecordDao.selectByPrimaryKey(id);
	}

}
