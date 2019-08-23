package com.zkhw.flup.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.zkhw.common.utils.ExcelUtil;
import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.bo.TuberculosisListBo;
import com.zkhw.flup.dao.TuberculosisFollowRecordDao;
import com.zkhw.flup.dao.TuberculosisInfoDao;
import com.zkhw.flup.entity.TuberculosisFollowRecord;
import com.zkhw.flup.entity.TuberculosisInfo;
import com.zkhw.flup.service.TuberculosisService;
import com.zkhw.framework.utils.JsonWebPrintUtils;
import com.zkhw.pub.dao.ResidentBaseInfoDao;
import com.zkhw.pub.entity.ResidentBaseInfo;
import com.zkhw.pub.query.ResidentBaseInfoQuery;

@Service
public class TuberculosisServiceImpl implements TuberculosisService {

	@Autowired
	private ResidentBaseInfoDao residentBaseInfoDao;
	
	@Autowired
	private TuberculosisInfoDao tuberculosisInfoDao;
	
	@Autowired
	private TuberculosisFollowRecordDao tuberculosisFollowRecordDao;
	
	
	/**
	 * 肺结核花名册
	 */
	@Override
	public void tuberculosisForExcel(ApiJsonResult result, HttpServletRequest request, HttpServletResponse response,
			ResidentBaseInfoQuery resident) {
		resident.setIsTuberculosis(1);
		List<ResidentBaseInfo> residentBaseInfoList = residentBaseInfoDao.findResidentList(resident);
		if (residentBaseInfoList.size() > 0) {
			// 表头
			ArrayList<String> headerList = new ArrayList<String>();
			String[] header = { "村名", "姓名", "性别", "年龄", "身份证号码", "现住址", "电话" };
			for (int i = 0; i < header.length; i++) {
				headerList.add(header[i]);
			}
			// 行内容
			ArrayList<List<String>> rowList = new ArrayList<List<String>>();
			String title = "肺结核查询列表";
			String sheetName = "肺结核花名册";
			for (ResidentBaseInfo residentBaseInfo : residentBaseInfoList) {
				ArrayList<String> row = new ArrayList<String>();
				String place = residentBaseInfo.getCityName() + residentBaseInfo.getCountyName()
						+ residentBaseInfo.getTownsName() + residentBaseInfo.getVillageName();
				row.add(place.replace("null", ""));
				row.add(residentBaseInfo.getName());
				String sex = residentBaseInfo.getSex();
				if (!StringUtil.isEmpty(sex) && sex.equals("1")) {
					row.add("男");
				} else {
					row.add("女");
				}
				row.add(residentBaseInfo.getAge().toString());
				row.add(residentBaseInfo.getIdNumber());
				row.add(residentBaseInfo.getResidenceAddress());
				row.add(residentBaseInfo.getPhone());
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
	public PageInfos<TuberculosisListBo> findTuberculosisByPage(ResidentBaseInfoQuery redident,
			PageInfos<TuberculosisListBo> pageData) {
		PageHelper.startPage( (int)pageData.getPage(), (int)pageData.getPageSize());//pageNum, pageSize
		List<ResidentBaseInfo> list = residentBaseInfoDao.findResidentList(redident);
		PageInfo<ResidentBaseInfo> page = new PageInfo<ResidentBaseInfo>(list);
		List<TuberculosisListBo> tuberculosisList = new ArrayList<TuberculosisListBo>();
		for(int i = 0; i < list.size(); i++){
			TuberculosisListBo bo = new TuberculosisListBo();
			BeanUtils.copyProperties(list.get(i), bo);
			TuberculosisFollowRecord  r = tuberculosisFollowRecordDao.findLastFollowRecord(list.get(i).getArchiveNo());
			if(r != null){
				bo.setVisitDate(r.getVisitDate());
				bo.setNextVisitDate(r.getNextVisitDate());
			}
			tuberculosisList.add(bo);			
		}
		pageData.setPage(page.getPageNum());      //当前页码
		pageData.setPageCount(page.getPages());   //总页数
		pageData.setPageSize(page.getPageSize()); //每页记录数
		pageData.setTotal(page.getTotal()); 
		pageData.setRows(tuberculosisList);
		return pageData;
	}

	@Override
	public TuberculosisFollowRecord getTuberculosisFollowRecordById(String id) {
		return tuberculosisFollowRecordDao.selectByPrimaryKey(id);
	}

	@Override
	public PageInfos<TuberculosisFollowRecord> findFollowRecordByPage(TuberculosisFollowRecord record,
			PageInfos<TuberculosisFollowRecord> pageData) {
		PageHelper.startPage( (int)pageData.getPage(), (int)pageData.getPageSize());//pageNum, pageSize
		List<TuberculosisFollowRecord> list = tuberculosisFollowRecordDao.findFollowRecordList(record);
		PageInfo<TuberculosisFollowRecord> page = new PageInfo<TuberculosisFollowRecord>(list);
		pageData.setPage(page.getPageNum());      //当前页码
		pageData.setPageCount(page.getPages());   //总页数
		pageData.setPageSize(page.getPageSize()); //每页记录数
		pageData.setTotal(page.getTotal()); 
		pageData.setRows(page.getList());
		return pageData;
	}

	@Override
	public TuberculosisInfo getTuberculosisInfoByArchiveNo(String archiveNo) {
		return tuberculosisInfoDao.getTuberculosisByArchiveNo(archiveNo);
	}

	@Override
	public Map<String, String> exportInfoPdf(String archiveNo) {
		Map<String, String> map = new HashMap<String,String>();
		TuberculosisInfo info = tuberculosisInfoDao.getTuberculosisByArchiveNo(archiveNo);
		
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
			//随访方式
			map.put("visitType", info.getVisitType());
			//患者类型
			map.put("patientType", info.getPatientType());
			//痰菌
			map.put("bacteriumType", info.getSputumBacteriumType());
			//耐药情况
			map.put("fastType", info.getDrugFastType());
			
			//既往主要症状
			String symptom = info.getSymptom();
			if(StringUtil.isNotEmpty(symptom)){
				String[] sym = symptom.split(",");
				for(int i = 1; i <= sym.length; i++){
					map.put("sym" + i , sym[i -1]);
				}
			}			
			map.put("symptomOther", info.getSymptomOther());
			
			map.put("plan", info.getChemotherapyPlan());
			
			map.put("usage", info.getDrugsUsage());
			
			String drugs = info.getDrugsType();
			map.put("drug" + drugs , "√");
			
			//督导人员
			map.put("supervisor", info.getSupervisorType());
			map.put("supervisorOther", info.getSupervisorOther());
			
			//家庭居住环境
			map.put("room", info.getSingleRoom());
			map.put("ventilation", info.getVentilation());
			
			//生活方式
			map.put("smoke", info.getSmokeNow()==null?"":info.getSmokeNow().toString());
			map.put("tsmoke", info.getSmokeNext()==null?"":info.getSmokeNext().toString());
			
			map.put("drink", info.getDrinkNow()==null?"":info.getDrinkNow().toString());
			map.put("tdrink", info.getDrinkNext()==null?"":info.getDrinkNext().toString());
			
			//取药
			map.put("address", info.getGetMedicineAddress());
			if(StringUtil.isNotEmpty(info.getGetMedicineDate())){
				String[] d = info.getGetMedicineDate().split("-");
				map.put("takeYear", d[0]);
				if(d.length > 1){
					map.put("takeMonth", d[1]);
				}
				
				if(d.length > 2){
					map.put("takeDay", d[2]);
				}
			} 
			
			//服药记录卡
			map.put("record", info.getMedicineRecord());			
			//药品存放
			map.put("leave", info.getMedicineLeave());
			//肺结核治疗疗程
			map.put("course", info.getTreatmentCourse());
			//不规律服药危害
			map.put("erratically", info.getErratically());
			//服药后的不良反应及处理
			map.put("effect", info.getUntowardEffect());
			//治疗期间复诊查痰
			map.put("further", info.getFurtherConsultation());
			//外出期间如何坚持服药
			map.put("insist", info.getInsist());
			//生活习惯及注意事项
			map.put("habits", info.getHabitsCustoms());
			//密切接触者检查
			map.put("contact", info.getIntimateContact());
			
			//map.put("nvisit", info.getNextVisitDate());
			String nvisitDate = info.getNextVisitDate();
			
			if(StringUtil.isNotEmpty(nvisitDate)){
				String[] b = nvisitDate.split("-");
				map.put("nextYear", b[0]);					
				map.put("nextMonth", b[1]);
				map.put("nextDay", b[2]);
			}
			map.put("doctor", info.getEstimateDoctor());
		}
		return map;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Map<String, String> exportFollowPdf(String archiveNo, String year) {
		Map<String, String> map = new HashMap<String,String>();
		
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
		TuberculosisFollowRecord record = new TuberculosisFollowRecord();
		record.setArchiveNo(archiveNo);
		if(StringUtil.isEmpty(year)){
			Date now = new Date();
			int y = 1900 + now.getYear();
			record.setVisitDate(String.valueOf(y));
		}else{
			record.setVisitDate(year);
		}
		List<TuberculosisFollowRecord> list = tuberculosisFollowRecordDao.findFollowByYear(record);
		if(list != null && list.size() > 0){
			for(int i = 0; i < list.size(); i++){
				TuberculosisFollowRecord tub = list.get(i);
				int index = i + 1;
				//姓名
				map.put("name", tub.getName());
				//随访日期
				String visitDate = tub.getVisitDate();
				
				if(StringUtil.isNotEmpty(visitDate)){
					String[] b = visitDate.split("-");
					map.put("year" + index, b[0]);					
					map.put("month" + index, b[1]);
					map.put("day" + index, b[2]);
				}
				//治疗月序
				map.put("order" + index, tub.getMonthOrder() == null?"":tub.getMonthOrder().toString());
				//督导人员选择
				map.put("supervisor" + index, tub.getSupervisorType());
				//随访方式
				map.put("visitType" + index, tub.getVisitType());

				//症状
				String symptoms = tub.getSymptom();
				if(StringUtil.isNotEmpty(symptoms)){
					String[] s = symptoms.split(",");
					for(int j = 1; j <= s.length; j++){
						String sym = "sym" + index;
						sym = sym + j;
						map.put(sym , s[j -1]);
					}
				}			
				map.put("symptomOther" + index, tub.getSymptomOther());
				
				//生活方式
				map.put("smoke" + index, tub.getSmokeNow()==null?"":tub.getSmokeNow().toString());
				map.put("tsmoke" + index, tub.getSmokeNext()==null?"":tub.getSmokeNext().toString());
				
				map.put("drink" + index, tub.getDrinkNow()==null?"":tub.getDrinkNow().toString());
				map.put("tdrink" + index, tub.getDrinkNext()==null?"":tub.getDrinkNext().toString());
				
				//化疗方案
				map.put("plan" + index, tub.getChemotherapyPlan());
				
				//用法
				map.put("usage" + index, tub.getDrugsUsage());
				
				String drugs = tub.getDrugsType();
				map.put("drug"+ index + drugs , "√");

				//漏服药次数
				map.put("miss" + index, tub.getMiss() == null?"":tub.getMiss().toString());
				
				//药物不良反应
				map.put("effect" + index, tub.getUntowardEffect());
				map.put("effectInfo" + index, tub.getUntowardEffectInfo());
				
				//并发症或合并症
				map.put("complication" + index, tub.getComplication());
				map.put("complicationInfo" + index, tub.getComplicationInfo());
				
				//转诊
				map.put("transferReason" + index, tub.getTransferTreatmentReason());
				map.put("transferOrg" + index, tub.getTransferTreatmentDepartment());
				map.put("twoweek" + index, tub.getTwoweekVisitResult());
				
				//处理意见
				map.put("suggestion" + index, tub.getHandlingSuggestion());
				
				//下次随访日期
				map.put("nvisitDate" + index, tub.getNextVisitDate());
				
				//随访医生
				map.put("visitDoctor" + index, tub.getVisitDoctor());
				
				//停止治疗日期
				//map.put("stopDate", tub.getStopDate());
				String stopDate = tub.getStopDate();			
				if(StringUtil.isNotEmpty(stopDate)){
					String[] b = stopDate.split("-");
					map.put("stopyear" + index, b[0]);					
					map.put("stopmonth" + index, b[1]);
					map.put("stopday" + index, b[2]);
				}
				map.put("stopReason" + tub.getStopReason(), "√");
				
				map.put("mustv", tub.getMustVisitNum() == null?"":tub.getMustVisitNum().toString());
				map.put("actualv", tub.getActualVisitNum() == null?"":tub.getActualVisitNum().toString());
				map.put("mustm", tub.getMustMedicineNum() == null?"":tub.getMustMedicineNum().toString());
				map.put("actualm", tub.getActualMedicineNum() == null?"":tub.getActualMedicineNum().toString());
				
				map.put("rate", tub.getMedicineRate());
				map.put("estimateDoctor", tub.getEstimateDoctor());
			}
			
		}
		return map;
	}


}
