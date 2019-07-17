package com.zkhw.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.sys.dao.ThresholdValueDao;
import com.zkhw.sys.entity.ThresholdValue;
import com.zkhw.sys.service.ThresholdValueService;

@Service
public class ThresholdValueServiceImpl implements ThresholdValueService {

	@Autowired
	private ThresholdValueDao thresholdValueDao;

	@Override
	public PageInfos<ThresholdValue> findThresholdByPage(ThresholdValue record, PageInfos<ThresholdValue> pageData) {
		PageHelper.startPage( (int)pageData.getPage(), (int)pageData.getPageSize());//pageNum, pageSize
		List<ThresholdValue> list = thresholdValueDao.findThresholdList(record);
		PageInfo<ThresholdValue> page = new PageInfo<ThresholdValue>(list);
		pageData.setPage(page.getPageNum());      //当前页码
		pageData.setPageCount(page.getPages());   //总页数
		pageData.setPageSize(page.getPageSize()); //每页记录数
		pageData.setTotal(page.getTotal()); 
		pageData.setRows(page.getList());
		return pageData;
	}

	@Override
	public int saveThreshold(ThresholdValue record) {
		return thresholdValueDao.insertSelective(record);
	}

	@Override
	public int updateThreshold(ThresholdValue record) {
		return thresholdValueDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public ThresholdValue getThresholdById(String id) {
		return thresholdValueDao.selectByPrimaryKey(id);
	}

	@Override
	public List<ThresholdValue> findThresholdList(ThresholdValue record) {
		return thresholdValueDao.findThresholdList(record);
	}

	@Override
	public int updateByType(ThresholdValue record) {
		return thresholdValueDao.updateByType(record);
	}
}
