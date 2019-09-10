package com.zkhw.flup.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public Map<String, String> exportInfoPdf(String archiveNo) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String,String>();
		GravidaInfo info = gravidaInfoDao.getGravidaByArchiveNo(archiveNo);
		
		map.put("a1", archiveNo.substring(0,1));
		map.put("a2", archiveNo.substring(1,2));
		map.put("a3", archiveNo.substring(2,3));
		map.put("a4", archiveNo.substring(3,4));
		map.put("a5", archiveNo.substring(4,5));
		map.put("a6", archiveNo.substring(5,6));
		map.put("a7", archiveNo.substring(6,7));
		map.put("a8", archiveNo.substring(7,8));
		map.put("a9", archiveNo.substring(8,9));
		map.put("a10", archiveNo.substring(9,10));
		map.put("a11", archiveNo.substring(10,11));
		map.put("a12", archiveNo.substring(11,12));
		map.put("a13", archiveNo.substring(12,13));
		map.put("a14", archiveNo.substring(13,14));
		map.put("a15", archiveNo.substring(14,15));
		map.put("a16", archiveNo.substring(15,16));
		map.put("a17", archiveNo.substring(16,17));
		
		if(info != null){
			//姓名
			map.put("name", info.getName());
			
			//随访时间
			//随访日期
			String visitDate = info.getVisitDate();
			
			if(StringUtil.isNotEmpty(visitDate)){
				String[] b = visitDate.split("-");
				map.put("year", b[0]);					
				map.put("month", b[1]);
				map.put("day", b[2]);
			}

			//孕周
			map.put("week", info.getGestationalWeeks() == null?"":info.getGestationalWeeks().toString());
			//孕妇年龄
			map.put("age", info.getGravidaAge() == null?"":info.getGravidaAge().toString());
			//丈夫姓名
			map.put("husbandName", info.getHusbandName());
			//丈夫年龄
			map.put("husbandAge", info.getHusbandAge() == null?"":info.getHusbandAge().toString());
			//丈夫电话
			map.put("husbandPhone", info.getHusbandPhone());
			//孕次
			map.put("pregnantNum", info.getPregnantNum() == null?"":info.getPregnantNum().toString());
			//阴道分娩次数
			map.put("labourNum", info.getNaturalLabourNum() == null?"":info.getNaturalLabourNum().toString());
			//剖腹产次数
			map.put("cesareanNum", info.getCesareanNum() == null?"":info.getCesareanNum().toString());
			//末次月经日期
			String lastDate = info.getLastMenstruationDate();
			if(StringUtil.isNotEmpty(lastDate)){
				String[] b = lastDate.split("-");
				map.put("lastyear", b[0]);					
				map.put("lastmonth", b[1]);
				map.put("lastday", b[2]);
			}

			//预产期
			String dueDate = info.getDueDate();
			if(StringUtil.isNotEmpty(dueDate)){
				String[] b = dueDate.split("-");
				map.put("dueyear", b[0]);					
				map.put("duemonth", b[1]);
				map.put("dueday", b[2]);
			}
			
			//既往主要症状
			String symptom = info.getPastIllness();
			if(StringUtil.isNotEmpty(symptom)){
				String[] sym = symptom.split(",");
				for(int i = 1; i <= sym.length; i++){
					map.put("sym" + i , sym[i -1]);
				}
			}			
			map.put("symptomOther", info.getPastIllnessOther());
			
			//家族史
			String family = info.getFamilyHistory();
			if(StringUtil.isNotEmpty(family)){
				String[] fam = family.split(",");
				for(int i = 1; i <= fam.length; i++){
					map.put("fam" + i , fam[i -1]);
				}
			}			
			map.put("familyOther", info.getFamilyHistoryOther());

			//个人史
			String customs = info.getHabitsCustoms();
			if(StringUtil.isNotEmpty(customs)){
				String[] cus = customs.split(",");
				for(int i = 1; i <= cus.length; i++){
					map.put("cus" + i , cus[i -1]);
				}
			}			
			map.put("customsOther", info.getHabitsCustomsOther());
			//妇产科手术史
			map.put("operation", info.getIsoperation());
			map.put("oName", info.getOperationName());
			
			

				
			//map.put("nvisit", info.getNextVisitDate());
			String nvisitDate = info.getNextVisitDate();
			
			if(StringUtil.isNotEmpty(nvisitDate)){
				String[] b = nvisitDate.split("-");
				map.put("nextYear", b[0]);					
				map.put("nextMonth", b[1]);
				map.put("nextDay", b[2]);
			}
			map.put("doctor", info.getVisitDoctor());
		}
		return map;
	}

	

	
}
