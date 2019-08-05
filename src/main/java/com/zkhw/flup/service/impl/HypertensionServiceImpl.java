package com.zkhw.flup.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.zkhw.common.utils.ExcelUtil;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.bo.HypertensionInfoBo;
import com.zkhw.flup.bo.HypertensionListBo;
import com.zkhw.flup.dao.FollowMedicineRecordDao;
import com.zkhw.flup.dao.HypertensionDao;
import com.zkhw.flup.entity.FollowMedicineRecord;
import com.zkhw.flup.entity.Hypertension;
import com.zkhw.flup.service.HypertensionService;
import com.zkhw.pub.dao.ResidentBaseInfoDao;
import com.zkhw.pub.entity.ResidentBaseInfo;
import com.zkhw.pub.query.ResidentBaseInfoQuery;

@Service
public class HypertensionServiceImpl implements HypertensionService {

	@Autowired
	private ResidentBaseInfoDao residentBaseInfoDao;
	
	@Autowired
	private HypertensionDao hypertensionDao;
	
	@Autowired
	private FollowMedicineRecordDao followMedicineRecordDao;
	
	/**
	 * 高血压花名册
	 */
	@Override
	public void hypertensionForExcel(ResidentBaseInfoQuery redident) {
		ExcelUtil excelutil = new ExcelUtil();
		//表头
		ArrayList<String> headerList = new ArrayList<String>();
		String[] header = {"村名","姓名","性别","年龄","身份证号码","现住址","电话"};
		for (int i = 0; i < header.length; i++) {
			headerList.add(header[i]);
		}
		//行内容
		ArrayList<List<String>> rowList = new ArrayList<List<String>>();
		redident.setIsHypertension(1);
		List<ResidentBaseInfo> residentBaseInfoList = residentBaseInfoDao.findResidentList(redident);
		ArrayList<String> StrList = null;
		ResidentBaseInfo residentBaseInfo = null;
		for (int i = 0; i < residentBaseInfoList.size(); i++) {
			residentBaseInfo = residentBaseInfoList.get(i);
			StrList = new ArrayList<String>();
			String place = residentBaseInfo.getCityName() + residentBaseInfo.getCountyName() + residentBaseInfo.getTownsName() + residentBaseInfo.getVillageName();
			StrList.add(place.replace("null", ""));
			StrList.add(residentBaseInfo.getName());
			String sex = residentBaseInfo.getSex();
			if(!StringUtil.isEmpty(sex) && sex.equals("1")) {
				StrList.add("男");
			}else {
				StrList.add("女");
			}
			StrList.add(residentBaseInfo.getAge().toString());
			StrList.add(residentBaseInfo.getIdNumber());
			StrList.add(residentBaseInfo.getResidenceAddress());
			StrList.add(residentBaseInfo.getPhone());
			rowList.add(StrList);
		}
		//地址
		String xlsPath = "C:\\Users\\Administrator\\Desktop\\高血压花名册.xls";
		//工作表名称
		String sheetName = "高血压花名册";
		
		try {
			excelutil.writeExcel(headerList, rowList, xlsPath, sheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	@Override
	public PageInfos<HypertensionListBo> findHypertensionByPage(ResidentBaseInfoQuery redident,
			PageInfos<HypertensionListBo> pageData) {
		PageHelper.startPage( (int)pageData.getPage(), (int)pageData.getPageSize());//pageNum, pageSize
		List<ResidentBaseInfo> list = residentBaseInfoDao.findResidentList(redident);
		PageInfo<ResidentBaseInfo> page = new PageInfo<ResidentBaseInfo>(list);
		List<HypertensionListBo> hypertensionList = new ArrayList<HypertensionListBo>();
		for(int i = 0; i < list.size(); i++){
			HypertensionListBo bo = new HypertensionListBo();
			BeanUtils.copyProperties(list.get(i), bo);
			Hypertension  r = hypertensionDao.findLastFollowRecord(list.get(i).getArchiveNo());
			if(r != null){
				bo.setFollowId(r.getId());
				bo.setVisitDate(r.getVisitDate());
				bo.setNextVisitDate(r.getNextVisitDate());
			}
			hypertensionList.add(bo);			
		}
		pageData.setPage(page.getPageNum());      //当前页码
		pageData.setPageCount(page.getPages());   //总页数
		pageData.setPageSize(page.getPageSize()); //每页记录数
		pageData.setTotal(page.getTotal()); 
		pageData.setRows(hypertensionList);
		return pageData;
	}

	@Override
	public HypertensionInfoBo getHypertensionFollowRecordById(String id) {
		
		HypertensionInfoBo bo = new HypertensionInfoBo();
		
		Hypertension hypertension = hypertensionDao.selectByPrimaryKey(id);
		
		List<FollowMedicineRecord> list = followMedicineRecordDao.findMedicineListByFollowId(id);
		
		bo.setHypertension(hypertension);
		bo.setMedicineList(list);
		return bo;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Map<String, String> exportPdf(String archiveNo, String year) {
		// TODO Auto-generated method stub
		Hypertension record = new Hypertension();
		record.setArchiveNo(archiveNo);
		if(StringUtil.isEmpty(year)){
			Date now = new Date();
			int y = 1900 + now.getYear();
			record.setVisitDate(String.valueOf(y));
		}else{
			record.setVisitDate(year);
		}
		Map<String, String> map = new HashMap<String,String>();
		List<Hypertension> list = hypertensionDao.findFollowByYear(record);
		if(list != null && list.size() > 0){
			
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
			
			for(int i = 0; i < list.size(); i++){
				Hypertension hyp = list.get(i);
				int index = i + 1;
				//姓名
				map.put("name", hyp.getName());
				//随访日期
				String visitDate = hyp.getVisitDate();
				
				if(!"".equals(visitDate)){
					String[] b = visitDate.split("-");
					map.put("year" + index, b[0]);					
					map.put("month" + index, b[1]);
					map.put("day" + index, b[2]);
				}
				//随访方式
				map.put("visitType" + index, hyp.getVisitType());
				//症状
				String symptoms = hyp.getSymptom();
				if(StringUtil.isNotEmpty(symptoms)){
					String[] s = symptoms.split(",");
					for(int j = 1; j <= s.length; j++){
						String sym = "sym" + index;
						sym = sym + j;
						map.put(sym , s[j -1]);
					}
				}
				
				//其他症状
				map.put("otherSymptom" + index, hyp.getOtherSymptom());
				
				//血压
				map.put("dbp" + index, hyp.getDbp() == null?"":hyp.getDbp().toString());
				map.put("sbp" + index, hyp.getSbp() == null?"":hyp.getSbp().toString());
				

				//体重
				map.put("weight" + index, hyp.getWeight());
				map.put("tweight" + index, hyp.getTargetWeight());
				
				//bmi
				map.put("bmi" + index, hyp.getBmi());
				map.put("tbmi" + index, hyp.getTargetBmi());				
				 
				//心率
				map.put("heartRate" + index, hyp.getHeartRate()==null ?"":hyp.getHeartRate().toString());
				
				//其他
				map.put("other" + index, hyp.getOtherSign());
				
				//吸烟
				map.put("smoken" + index, hyp.getSmoken() == null?"":hyp.getSmoken().toString());
				map.put("tsmoken" + index, hyp.getTargetSomken() == null?"":hyp.getTargetSomken().toString());
			
				//饮酒
				map.put("wine" + index, hyp.getWine() == null?"":hyp.getWine().toString());
				map.put("twine" + index, hyp.getTargetWine() == null?"":hyp.getTargetWine().toString());
				
				//运动
				map.put("sportWeek" + index, hyp.getSportWeek() == null?"":hyp.getSportWeek().toString());
				map.put("sportOnce" + index, hyp.getSportOnce() == null?"":hyp.getSportOnce().toString());
				
				map.put("tsportWeek" + index, hyp.getTargetSportWeek() == null?"":hyp.getTargetSportWeek().toString());
				map.put("tsportOnce" + index, hyp.getTargetSportOnce() == null?"":hyp.getTargetSportOnce().toString());
				
				//摄盐情况
				map.put("salt" + index + hyp.getSaltIntake(), "√");
				map.put("tsalt" + index + hyp.getTargetSaltIntake(), "√");
				
				//心里调节
				map.put("mind" + index, hyp.getMindAdjust());
				
				//遵医行为
				map.put("obey" + index, hyp.getDoctorObey());
				
				//辅助检查
				map.put("examine" + index, hyp.getAssistExamine());
			
				//服药依从性
				map.put("drugObey" + index, hyp.getDrugObey());
				
				//药物不良反应
				map.put("effect" + index, hyp.getUntowardEffect());
				map.put("effectInfo" + index, hyp.getUntowardEffectDrug());
				
				//随访分类
				map.put("visitClass" + index, hyp.getVisitClass());
				
				List<FollowMedicineRecord> meds = followMedicineRecordDao.findMedicineListByFollowId(hyp.getId());
				if(meds != null && meds.size() > 0){
					for(int j = 1; j <= meds.size(); j++){
						FollowMedicineRecord med = meds.get(j-1);
						String drugName = "drugName" + index;
						drugName = drugName + j;
						String num = "num" + index;
						num = num + j;
						String dosage = "dosage" + index;
						dosage = dosage + j;
						map.put(drugName, med.getDrugName());
						map.put(num, med.getNum());
						map.put(dosage, med.getDosage());
					}
				}
				//转诊
				map.put("reason" + index, hyp.getTransferReason());
				map.put("torgan" + index, hyp.getTransferOrgan());
				
				//下次随访日期
				map.put("nvisitDate" + index, hyp.getNextVisitDate());
				
				//随访医生
				map.put("visitDoctor" + index, hyp.getVisitDoctor());
			}								
			
		}
		return map;		
	}


}
