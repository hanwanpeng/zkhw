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
import com.zkhw.flup.dao.ChildrenHealthRecordDao;
import com.zkhw.flup.dao.NeonatusInfoDao;
import com.zkhw.flup.entity.ChildrenHealthRecord;
import com.zkhw.flup.entity.NeonatusInfo;
import com.zkhw.flup.service.ChildrenService;
import com.zkhw.pub.entity.ResidentBaseInfo;

@Service
public class ChildrenServiceImpl implements ChildrenService {

	@Autowired
	private NeonatusInfoDao neonatusInfoDao;
	
	@Autowired
	private ChildrenHealthRecordDao childrenHealthRecordDao;
	
	/**
	 * 0-6岁儿童花名册
	 */
	@Override
	public void childrenForExcel(NeonatusInfo neonatus) {
		ExcelUtil excelutil = new ExcelUtil();
		//表头
		ArrayList<String> headerList = new ArrayList<String>();
		String[] header = {"姓名","性别","出生日期","身份证号码","住址","家长姓名","家长电话"};
		for (int i = 0; i < header.length; i++) {
			headerList.add(header[i]);
		}
		//行内容
		ArrayList<List<String>> rowList = new ArrayList<List<String>>();
		List<NeonatusInfo> neonatusInfoList = neonatusInfoDao.findNeonatusList(neonatus);
		
		ArrayList<String> StrList = null;
		NeonatusInfo neonatusInfo = null;
		for (int i = 0; i < neonatusInfoList.size(); i++) {
			neonatusInfo = neonatusInfoList.get(i);
			StrList = new ArrayList<String>();
			
			StrList.add(neonatusInfo.getName());
			String sex = neonatusInfo.getSex();
			if(!StringUtil.isEmpty(sex) && sex.equals("1")) {
				StrList.add("男");
			}else {
				StrList.add("女");
			}
			StrList.add(neonatusInfo.getBirthday());
			StrList.add(neonatusInfo.getIdNumber());
			StrList.add(neonatusInfo.getHomeAddress());
			StrList.add("父亲："+ neonatusInfo.getFatherName() +  "母亲：" + neonatusInfo.getMotherName());
			StrList.add(neonatusInfo.getFatherPhone());
			
			rowList.add(StrList);
		}
		//地址
		String xlsPath = "C:\\Users\\Administrator\\Desktop\\0-6岁儿童花名册.xls";
		//工作表名称
		String sheetName = "0-6岁儿童花名册";
		
		try {
			excelutil.writeExcel(headerList, rowList, xlsPath, sheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
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
