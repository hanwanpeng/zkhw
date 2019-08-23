package com.zkhw.flup.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.zkhw.common.utils.ExcelUtil;
import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.dao.ChildrenHealthRecordDao;
import com.zkhw.flup.dao.NeonatusInfoDao;
import com.zkhw.flup.entity.ChildrenHealthRecord;
import com.zkhw.flup.entity.NeonatusInfo;
import com.zkhw.flup.service.ChildrenService;
import com.zkhw.framework.utils.JsonWebPrintUtils;
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
	public void childrenForExcel(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result,
			NeonatusInfo neonatus) {
		List<NeonatusInfo> neonatusInfoList = neonatusInfoDao.findNeonatusList(neonatus);
		if (neonatusInfoList.size() > 0) {
			// 表头
			ArrayList<String> headerList = new ArrayList<String>();
			String[] header = { "姓名", "性别", "出生日期", "身份证号码", "住址", "家长姓名", "家长电话" };
			for (int i = 0; i < header.length; i++) {
				headerList.add(header[i]);
			}
			// 行内容
			ArrayList<List<String>> rowList = new ArrayList<List<String>>();
			String title = "0-6岁儿童查询列表";
			String sheetName = "0-6岁儿童花名册";
			for (NeonatusInfo neonatusInfo : neonatusInfoList) {
				ArrayList<String> row = new ArrayList<String>();
				row.add(neonatusInfo.getName());
				String sex = neonatusInfo.getSex();
				if (!StringUtil.isEmpty(sex) && sex.equals("1")) {
					row.add("男");
				} else {
					row.add("女");
				}
				row.add(neonatusInfo.getBirthday());
				row.add(neonatusInfo.getIdNumber());
				row.add(neonatusInfo.getHomeAddress());
				row.add("父亲：" + neonatusInfo.getFatherName() + "母亲：" + neonatusInfo.getMotherName());
				row.add(neonatusInfo.getFatherPhone());
				rowList.add(row);
			}
			// 输出excel到浏览器
			response.setContentType("application/msexcel");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE");
			response.setHeader("Access-Control-Allow-Headers",
					"Access-Control-Allow-Origin, Access-Control-Allow-Methods, Access-Control-Max-Age, X-Auth-Token, Content-Type, Accept");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			OutputStream out = null;

			try {
				out = response.getOutputStream();// 取得输出流
				response.reset();// 清空输出流
				String filename = title + ".xls";
				filename = new String(filename.getBytes("gb2312"), "ISO8859-1");
				response.setHeader("Content-disposition", "attachment; filename=" + filename);// 设定输出文件头
				ExcelUtil excelUtil = new ExcelUtil();
				excelUtil.writeExcelWithMultiSheet(headerList, rowList, out, sheetName);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (out != null) {
					try {
						out.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}

		} else {
			result.setCode("1");
			result.setMsg("没有查询到数据");
			JsonWebPrintUtils.printOutNullApiResult(request, response, result);

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
