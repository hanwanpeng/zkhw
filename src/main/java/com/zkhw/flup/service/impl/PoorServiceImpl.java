package com.zkhw.flup.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.bo.PoorListBo;
import com.zkhw.flup.dao.PoorFollowRecordDao;
import com.zkhw.flup.entity.PoorFollowRecord;
import com.zkhw.flup.service.PoorService;
import com.zkhw.pub.dao.ResidentBaseInfoDao;
import com.zkhw.pub.entity.ResidentBaseInfo;
import com.zkhw.pub.query.ResidentBaseInfoQuery;

@Service
public class PoorServiceImpl implements PoorService {

	@Autowired
	private ResidentBaseInfoDao residentBaseInfoDao;

	@Autowired
	private PoorFollowRecordDao poorFollowRecordDao;

	@Override
	public PageInfos<PoorListBo> findPoorByPage(ResidentBaseInfoQuery redident, PageInfos<PoorListBo> pageData) {
		PageHelper.startPage((int) pageData.getPage(), (int) pageData.getPageSize());// pageNum, pageSize
		List<ResidentBaseInfo> list = residentBaseInfoDao.findResidentList(redident);
		PageInfo<ResidentBaseInfo> page = new PageInfo<ResidentBaseInfo>(list);
		List<PoorListBo> poorListBo = new ArrayList<PoorListBo>();
		for (int i = 0; i < list.size(); i++) {
			PoorListBo bo = new PoorListBo();
			BeanUtils.copyProperties(list.get(i), bo);
			PoorFollowRecord poor = poorFollowRecordDao.findLastFollowRecord(list.get(i).getArchiveNo());
			if (poor != null) {
				bo.setFollwoId(poor.getId());
			}
			poorListBo.add(bo);

		}
		pageData.setPage(page.getPageNum()); // 当前页码
		pageData.setPageCount(page.getPages()); // 总页数
		pageData.setPageSize(page.getPageSize()); // 每页记录数
		pageData.setTotal(page.getTotal());
		pageData.setRows(poorListBo);
		return pageData;
	}

	@Override
	public PoorListBo getPoorFollowRecordById(String id) {

		PoorListBo poorListBo = new PoorListBo();
		PoorFollowRecord poor = poorFollowRecordDao.selectByPrimaryKey(id);
		BeanUtils.copyProperties(poor, poorListBo);
		return poorListBo;
	}

}
