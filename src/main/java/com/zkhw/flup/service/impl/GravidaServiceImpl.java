package com.zkhw.flup.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.zkhw.common.utils.ExcelUtil;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.dao.GravidaAfterRecordDao;
import com.zkhw.flup.dao.GravidaFollowRecordDao;
import com.zkhw.flup.dao.GravidaInfoDao;
import com.zkhw.flup.entity.GravidaAfterRecord;
import com.zkhw.flup.entity.GravidaFollowRecord;
import com.zkhw.flup.entity.GravidaInfo;
import com.zkhw.flup.query.GravidaInfoQuery;
import com.zkhw.flup.service.GravidaService;
import com.zkhw.pub.dao.ResidentBaseInfoDao;
import com.zkhw.pub.entity.ResidentBaseInfo;

@Service
public class GravidaServiceImpl implements GravidaService {

	@Autowired
	private GravidaInfoDao gravidaInfoDao;
	
	@Autowired
	private GravidaFollowRecordDao gravidaFollowRecordDao;
	
	@Autowired
	private GravidaAfterRecordDao gravidaAfterRecordDao;
	
	@Autowired
	private ResidentBaseInfoDao residentBaseInfoDao;
	
	/**
	 * 孕产妇花名册
	 */
	@Override
	public void gravidaForExcel(GravidaInfoQuery gravida) {
		ExcelUtil excelutil = new ExcelUtil();
		//表头
		ArrayList<String> headerList = new ArrayList<String>();
		String[] header = {"姓名","年龄","身份证号码","住址","丈夫电话","预产期"};
		for (int i = 0; i < header.length; i++) {
			headerList.add(header[i]);
		}
		//行内容
		ArrayList<List<String>> rowList = new ArrayList<List<String>>();
		List<GravidaInfo> gravidaInfoList = gravidaInfoDao.findGravidaList(gravida);
		ArrayList<String> StrList = null;
		GravidaInfo gravidaInfo = null;
		for (int i = 0; i < gravidaInfoList.size(); i++) {
			gravidaInfo = gravidaInfoList.get(i);
			StrList = new ArrayList<String>();
			StrList.add(gravidaInfo.getName());
			StrList.add(gravidaInfo.getGravidaAge().toString());
			StrList.add(gravidaInfo.getIdNumber());
			//住址
			String idNumber = gravidaInfo.getIdNumber();
			ResidentBaseInfo resident = residentBaseInfoDao.findResidentByIdNumber(idNumber);
			if(resident != null) {
				StrList.add(resident.getResidenceAddress());
			}
			StrList.add(gravidaInfo.getHusbandPhone());
			StrList.add(gravidaInfo.getDueDate());
			rowList.add(StrList);
		}
		//地址
		String xlsPath = "C:\\Users\\Administrator\\Desktop\\孕产妇花名册.xls";
		//工作表名称
		String sheetName = "孕产妇花名册";
		
		try {
			excelutil.writeExcel(headerList, rowList, xlsPath, sheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
