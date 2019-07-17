package com.zkhw.flup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.dao.GravidaAfterRecordDao;
import com.zkhw.flup.dao.GravidaFollowRecordDao;
import com.zkhw.flup.dao.GravidaInfoDao;
import com.zkhw.flup.entity.GravidaAfterRecord;
import com.zkhw.flup.entity.GravidaFollowRecord;
import com.zkhw.flup.entity.GravidaInfo;
import com.zkhw.flup.query.GravidaInfoQuery;
import com.zkhw.flup.service.GravidaService;

@Service
public class GravidaServiceImpl implements GravidaService {

	@Autowired
	private GravidaInfoDao gravidaInfoDao;
	
	@Autowired
	private GravidaFollowRecordDao gravidaFollowRecordDao;
	
	@Autowired
	private GravidaAfterRecordDao gravidaAfterRecordDao;
	
	@Override
	public PageInfos<GravidaInfo> findGravidaByPage(GravidaInfoQuery gravida, PageInfos<GravidaInfo> pageData) {
		PageHelper.startPage( (int)pageData.getPage(), (int)pageData.getPageSize());//pageNum, pageSize
		List<GravidaInfo> list = gravidaInfoDao.findGravidaList(gravida);
		PageInfo<GravidaInfo> page = new PageInfo<GravidaInfo>(list);
		pageData.setPage(page.getPageNum());      //当前页码
		pageData.setPageCount(page.getPages());   //总页数
		pageData.setPageSize(page.getPageSize()); //每页记录数
		pageData.setTotal(page.getTotal());       //总记录数
		pageData.setRows(page.getList());
		return pageData;
	}

	@Override
	public GravidaInfo getGravidaInfoById(String id) {
		return gravidaInfoDao.selectByPrimaryKey(id);
	}

	@Override
	public GravidaFollowRecord findFollowRecordByOtherNum(GravidaFollowRecord gravida) {
		List<GravidaFollowRecord> list = gravidaFollowRecordDao.findFollowRecordByOtherNum(gravida);
		if(list != null && list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}	
	}

	
	
	@Override
	public GravidaAfterRecord selectByPrimaryKey(String id) {
		GravidaAfterRecord selectByPrimaryKey = gravidaAfterRecordDao.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}

	
	@Override
	public PageInfos<GravidaAfterRecord> findGravidaAfterByPage(GravidaAfterRecord gravida, PageInfos<GravidaAfterRecord> pageData) {
		PageHelper.startPage( (int)pageData.getPage(), (int)pageData.getPageSize());//pageNum, pageSize
		String gravidaId = gravida.getGravidaId();
		if(!StringUtil.isEmpty(gravidaId)) {
			List<GravidaAfterRecord> list = gravidaAfterRecordDao.findAfterByGravidaId(gravidaId);
			PageInfo<GravidaAfterRecord> page = new PageInfo<GravidaAfterRecord>(list);
			pageData.setPage(page.getPageNum());      //当前页码
			pageData.setPageCount(page.getPages());   //总页数
			pageData.setPageSize(page.getPageSize()); //每页记录数
			pageData.setTotal(page.getTotal());       //总记录数
			pageData.setRows(page.getList());
		}
		return pageData;
	}
	
	

	
}
