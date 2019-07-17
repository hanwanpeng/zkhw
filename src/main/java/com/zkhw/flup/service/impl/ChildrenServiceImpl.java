package com.zkhw.flup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.dao.ChildrenHealthRecordDao;
import com.zkhw.flup.dao.NeonatusInfoDao;
import com.zkhw.flup.entity.ChildrenHealthRecord;
import com.zkhw.flup.entity.NeonatusInfo;
import com.zkhw.flup.service.ChildrenService;

@Service
public class ChildrenServiceImpl implements ChildrenService {

	@Autowired
	private NeonatusInfoDao neonatusInfoDao;
	
	@Autowired
	private ChildrenHealthRecordDao childrenHealthRecordDao;
	
	@Override
	public PageInfos<NeonatusInfo> findNeonatusByPage(NeonatusInfo neonatus, PageInfos<NeonatusInfo> pageData) {
		PageHelper.startPage( (int)pageData.getPage(), (int)pageData.getPageSize());//pageNum, pageSize
		List<NeonatusInfo> list = neonatusInfoDao.findNeonatusList(neonatus);
		PageInfo<NeonatusInfo> page = new PageInfo<NeonatusInfo>(list);
		pageData.setPage(page.getPageNum());      //当前页码
		pageData.setPageCount(page.getPages());   //总页数
		pageData.setPageSize(page.getPageSize()); //每页记录数
		pageData.setTotal(page.getTotal()); 
		pageData.setRows(page.getList());
		return pageData;
	}

	@Override
	public NeonatusInfo getNeonatusById(String id) {
		return neonatusInfoDao.selectByPrimaryKey(id);
	}

	@Override
	public ChildrenHealthRecord findFollowRecordByAge(ChildrenHealthRecord record) {
		List<ChildrenHealthRecord> list = childrenHealthRecordDao.findFollowRecordByAge(record);
		if(list != null && list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}		
	}
}
