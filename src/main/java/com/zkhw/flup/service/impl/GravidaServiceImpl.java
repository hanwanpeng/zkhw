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
import com.zkhw.flup.dao.GravidaAfterRecordDao;
import com.zkhw.flup.dao.GravidaFollowRecordDao;
import com.zkhw.flup.dao.GravidaInfoDao;
import com.zkhw.flup.entity.GravidaAfterRecord;
import com.zkhw.flup.entity.GravidaFollowRecord;
import com.zkhw.flup.entity.GravidaInfo;
import com.zkhw.flup.query.GravidaInfoQuery;
import com.zkhw.flup.service.GravidaService;
import com.zkhw.framework.utils.JsonWebPrintUtils;
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
	public void gravidaForExcel(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result,
			GravidaInfoQuery gravida) {
		List<GravidaInfo> gravidaInfoList = gravidaInfoDao.findGravidaList(gravida);
		if (gravidaInfoList.size() > 0) {
			// 表头
			ArrayList<String> headerList = new ArrayList<String>();
			String[] header = { "姓名", "年龄", "身份证号码", "住址", "丈夫电话", "预产期" };
			for (int i = 0; i < header.length; i++) {
				headerList.add(header[i]);
			}
			// 行内容
			ArrayList<List<String>> rowList = new ArrayList<List<String>>();
			String title = "孕产妇查询列表";
			String sheetName = "孕产妇花名册";
			for (GravidaInfo gravidaInfo : gravidaInfoList) {
				ArrayList<String> row = new ArrayList<String>();
				row.add(gravidaInfo.getName());
				row.add(gravidaInfo.getGravidaAge().toString());
				row.add(gravidaInfo.getIdNumber());
				// 住址
				String idNumber = gravidaInfo.getIdNumber();
				ResidentBaseInfo resident = residentBaseInfoDao.findResidentByIdNumber(idNumber);
				if (resident != null) {
					row.add(resident.getResidenceAddress());
				}
				row.add(gravidaInfo.getHusbandPhone());
				row.add(gravidaInfo.getDueDate());
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
