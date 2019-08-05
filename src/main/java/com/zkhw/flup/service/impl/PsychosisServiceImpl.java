package com.zkhw.flup.service.impl;

import java.io.IOException;
import java.util.ArrayList;
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
import com.zkhw.flup.bo.PsychosisFollowBo;
import com.zkhw.flup.bo.PsychosisListBo;
import com.zkhw.flup.dao.FollowMedicineRecordDao;
import com.zkhw.flup.dao.PsychosisFollowRecordDao;
import com.zkhw.flup.dao.PsychosisInfoDao;
import com.zkhw.flup.entity.FollowMedicineRecord;
import com.zkhw.flup.entity.PsychosisFollowRecord;
import com.zkhw.flup.entity.PsychosisInfo;
import com.zkhw.flup.service.PsychosisService;
import com.zkhw.pub.dao.ResidentBaseInfoDao;
import com.zkhw.pub.entity.ResidentBaseInfo;
import com.zkhw.pub.query.ResidentBaseInfoQuery;

@Service
public class PsychosisServiceImpl implements PsychosisService {

	@Autowired
	private ResidentBaseInfoDao residentBaseInfoDao;
	
	@Autowired
	private PsychosisFollowRecordDao psychosisFollowRecordDao;
	
	@Autowired
	private PsychosisInfoDao psychosisInfoDao;
	
	@Autowired
	private FollowMedicineRecordDao followMedicineRecordDao;
	
	/**
	 * 精神病花名册
	 */
	@Override
	public void psychosisForExcel(ResidentBaseInfoQuery redident) {
		ExcelUtil excelutil = new ExcelUtil();
		//表头
		ArrayList<String> headerList = new ArrayList<String>();
		String[] header = {"村名","姓名","性别","年龄","身份证号码","现住址","电话"};
		for (int i = 0; i < header.length; i++) {
			headerList.add(header[i]);
		}
		//行内容
		ArrayList<List<String>> rowList = new ArrayList<List<String>>();
		redident.setIsPsychosis(1);
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
		String xlsPath = "C:\\Users\\Administrator\\Desktop\\精神病花名册.xls";
		//工作表名称
		String sheetName = "精神病花名册";
		
		try {
			excelutil.writeExcel(headerList, rowList, xlsPath, sheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public PageInfos<PsychosisListBo> findPsychosisByPage(ResidentBaseInfoQuery redident,
			PageInfos<PsychosisListBo> pageData) {
		PageHelper.startPage( (int)pageData.getPage(), (int)pageData.getPageSize());//pageNum, pageSize
		List<ResidentBaseInfo> list = residentBaseInfoDao.findResidentList(redident);
		PageInfo<ResidentBaseInfo> page = new PageInfo<ResidentBaseInfo>(list);
		List<PsychosisListBo> psychosisList = new ArrayList<PsychosisListBo>();
		for(int i = 0; i < list.size(); i++){
			PsychosisListBo bo = new PsychosisListBo();
			BeanUtils.copyProperties(list.get(i), bo);
			PsychosisFollowRecord  r = psychosisFollowRecordDao.findLastFollowRecord(list.get(i).getArchiveNo());
			if(r != null){
				bo.setVisitDate(r.getVisitDate());
				bo.setNextVisitDate(r.getNextVisitDate());
			}
			psychosisList.add(bo);			
		}
		pageData.setPage(page.getPageNum());      //当前页码
		pageData.setPageCount(page.getPages());   //总页数
		pageData.setPageSize(page.getPageSize()); //每页记录数
		pageData.setTotal(page.getTotal()); 
		pageData.setRows(psychosisList);
		return pageData;
	}

	@Override
	public PsychosisFollowBo getPsychosisFollowRecordById(String id) {
		PsychosisFollowBo bo = new PsychosisFollowBo();
		PsychosisFollowRecord psychosisFollowRecord = psychosisFollowRecordDao.selectByPrimaryKey(id);
		List<FollowMedicineRecord> medicineList = followMedicineRecordDao.findMedicineListByFollowId(id);
		bo.setPsychosis(psychosisFollowRecord);
		bo.setMedicineList(medicineList);
		return bo;
			
	}

	@Override
	public PageInfos<PsychosisFollowRecord> findFollowRecordByPage(PsychosisFollowRecord record,
			PageInfos<PsychosisFollowRecord> pageData) {
		PageHelper.startPage( (int)pageData.getPage(), (int)pageData.getPageSize());//pageNum, pageSize
		List<PsychosisFollowRecord> list = psychosisFollowRecordDao.findFollowRecordList(record);
		PageInfo<PsychosisFollowRecord> page = new PageInfo<PsychosisFollowRecord>(list);
		pageData.setPage(page.getPageNum());      //当前页码
		pageData.setPageCount(page.getPages());   //总页数
		pageData.setPageSize(page.getPageSize()); //每页记录数
		pageData.setTotal(page.getTotal()); 
		pageData.setRows(page.getList());
		return pageData;
	}

	@Override
	public PsychosisInfo getPsychosisInfoByArchiveNo(String archiveNo) {
		return psychosisInfoDao.getPsychosisByArchiveNo(archiveNo);
	}

	@Override
	public Map<String, String> exportInfoPdf(String archiveNo) {
		Map<String, String> map = new HashMap<String,String>();
		PsychosisInfo info = psychosisInfoDao.getPsychosisByArchiveNo(archiveNo);
		
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
			
			//监护人
			map.put("guardianName", info.getGuardianName());			
			map.put("guardianRelation", info.getGuardianRelation());
			map.put("guardianAddress", info.getGuardianAddress());
			map.put("guardianPhone", info.getGuardianPhone());
			
			//联系人
			map.put("linkman", info.getNeighborhoodCommitteeLinkman());
			map.put("linktel", info.getNeighborhoodCommitteeLinktel());
			
			//户别
			map.put("residentType", info.getResidentType());
			
			//就业情况
			map.put("job", info.getEmploymentStatus());
			
			//知情同意
			map.put("manage", info.getAgreeManage());
			map.put("agreeName", info.getAgreeName());
			if(StringUtil.isNotEmpty(info.getAgreeDate())){
				String[] d = info.getAgreeDate().split("-");
				map.put("agreeYear", d[0]);
				if(d.length > 1){
					map.put("agreeMonth", d[1]);
				}
				
				if(d.length > 2){
					map.put("agreeDay", d[2]);
				}
			} 
			
			//初次发病时间
			if(StringUtil.isNotEmpty(info.getFirstMorbidityDate())){
				String[] d = info.getAgreeDate().split("-");
				map.put("morbidityYear", d[0]);
				if(d.length > 1){
					map.put("morbidityMonth", d[1]);
				}
				
				if(d.length > 2){
					map.put("morbidityDay", d[2]);
				}
			}
			
			//既往主要症状
			String symptom = info.getSymptom();
			if(StringUtil.isNotEmpty(symptom)){
				String[] sym = symptom.split(",");
				for(int i = 1; i <= sym.length; i++){
					map.put("sym" + i , sym[i -1]);
				}
			}			
			map.put("symptomOther", info.getSymptomOther());
			
			//既往关锁情况
			map.put("isolation", info.getIsolation());
			
			//门诊
			map.put("outpatient", info.getOutpatient());
			
			//首次药物
			if(StringUtil.isNotEmpty(info.getFirstMedicineDate())){
				String[] d = info.getAgreeDate().split("-");
				map.put("medicineYear", d[0]);
				if(d.length > 1){
					map.put("medicineMonth", d[1]);
				}
				
				if(d.length > 2){
					map.put("medicineDay", d[2]);
				}
			} 
			
			//住院次数
			map.put("hnum", info.getHospitalizedNum() == null?"":info.getHospitalizedNum().toString());
			
			//诊断
			map.put("diagnosis", info.getDiagnosis());
			map.put("diagnosish", info.getDiagnosisHospital());
			map.put("diagnosisd", info.getDiagnosisDate());
			
			//最近治疗效果
			map.put("effect", info.getRecentlyTreatmentEffect());
			
			//危险行为
			String acts = info.getDangerousAct();
			if(StringUtil.isNotEmpty(acts)){
				String[] act = acts.split(",");
				for(int i = 1; i <= act.length; i++){
					map.put("act" + i , act[i -1]);
				}
			}
			
			//轻度滋事
			map.put("trouble", info.getSlightTroubleNum() == null?"":info.getSlightTroubleNum().toString());
			//肇事
			map.put("cause", info.getCauseTroubleNum() == null?"":info.getCauseTroubleNum().toString());
			//肇祸
			map.put("accident", info.getCauseAccidentNum() == null?"":info.getCauseAccidentNum().toString());
			//其他危害行为
			map.put("harm", info.getHarmOtherNum() == null?"":info.getHarmOtherNum().toString());
			//自伤
			map.put("autolesion", info.getAutolesionNum() == null?"":info.getAutolesionNum().toString());
			//自杀未遂
			map.put("suicide", info.getAttemptedSuicideNum() == null?"":info.getAttemptedSuicideNum().toString());
			
			//经济状况
			map.put("economics", info.getEconomics());
			
			//医生意见
			map.put("suggestion", info.getSpecialistSuggestion());
			
			if(StringUtil.isNotEmpty(info.getRecordDate())){
				String[] d = info.getRecordDate().split("-");
				map.put("recordYear", d[0]);
				if(d.length > 1){
					map.put("recordMonth", d[1]);
				}
				
				if(d.length > 2){
					map.put("recordDay", d[2]);
				}
			} 
			map.put("doctor", info.getRecordDoctor());			
		}
		return map;
	}

	@Override
	public Map<String, String> exportFollowPdf(String id) {
		Map<String, String> map = new HashMap<String,String>();
		PsychosisFollowRecord record = psychosisFollowRecordDao.selectByPrimaryKey(id);
		if(record != null){
			
			String archiveNo = record.getArchiveNo();
			
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
			
			//姓名
			map.put("name", record.getName());
			
			String visitDate = record.getVisitDate();
			
			if(StringUtil.isNotEmpty(visitDate)){
				String[] b = visitDate.split("-");
				map.put("year" , b[0]);					
				map.put("month", b[1]);
				map.put("day", b[2]);
			}
			
			//随访方式
			map.put("visitType", record.getVisitType());
			
			//失访
			map.put("miss", record.getMissReason());
			map.put("missOther", record.getMissReasonOther());

			//死亡
			if(StringUtil.isNotEmpty(record.getDieDate())){
				String[] d = record.getDieDate().split("-");
				map.put("dieYear", d[0]);
				if(d.length > 1){
					map.put("dieMonth", d[1]);
				}
				
				if(d.length > 2){
					map.put("dieDay", d[2]);
				}
			} 			
			map.put("die", record.getDieReason());
			map.put("disease", record.getPhysicalDisease());
			map.put("dieOther", record.getDieReasonOther());
			
			//危险性评估
			map.put("fatalness", record.getFatalness());
			
			//症状
			String symptom = record.getSymptom();
			if(StringUtil.isNotEmpty(symptom)){
				String[] sym = symptom.split(",");
				for(int i = 1; i <= sym.length; i++){
					map.put("sym" + i , sym[i -1]);
				}
			}			
			map.put("symptomOther", record.getSymptomOther());
			
			//自知力
			map.put("insight", record.getInsight());			
			//睡眠状况
			map.put("sleep", record.getSleepStatus());
			//饮食状况
			map.put("dietary", record.getDietaryStatus());
			
			//个人生活自理
			map.put("selfHelp", record.getSelfHelp());
			//家务劳动
			map.put("housework", record.getHousework());
			//生产劳动及工作
			map.put("work", record.getWork());
			//学习能力
			map.put("learn", record.getLearningAbility());
			//社会人际交往
			map.put("personal", record.getInterpersonal());
			
			map.put("act", record.getDangerousAct());
			//轻度滋事
			map.put("trouble", record.getSlightTroubleNum() == null?"":record.getSlightTroubleNum().toString());
			//肇事
			map.put("cause", record.getCauseTroubleNum() == null?"":record.getCauseTroubleNum().toString());
			//肇祸
			map.put("accident", record.getCauseAccidentNum() == null?"":record.getCauseAccidentNum().toString());
			//其他危害行为
			map.put("harm", record.getHarmOtherNum() == null?"":record.getHarmOtherNum().toString());
			//自伤
			map.put("autolesion", record.getAutolesionNum() == null?"":record.getAutolesionNum().toString());
			//自杀未遂
			map.put("suicide", record.getAttemptedSuicideNum() == null?"":record.getAttemptedSuicideNum().toString());
			
			//两次随访期间关锁情况
			map.put("isolation", record.getIsolation());
			//两次随访期间住院情况
			map.put("hospital", record.getHospitalizedStatus());
			
			if(StringUtil.isNotEmpty(record.getOutHospitalDate())){
				String[] d = record.getOutHospitalDate().split("-");
				map.put("hosYear", d[0]);
				if(d.length > 1){
					map.put("hosMonth", d[1]);
				}
				
				if(d.length > 2){
					map.put("hosDay", d[2]);
				}
			} 
			//实验室检查
			map.put("exam", record.getLaboratoryExamination());
			//用药依从性
			map.put("compliance", record.getCompliance());
			//用药不良反应
			map.put("effect", record.getUntowardEffect());
			map.put("effectInfo", record.getUntowardEffectInfo());
			//治疗效果
			map.put("treatment", record.getTreatmentEffect());
			
			//转诊
			map.put("transfer", record.getTransferTreatment());
			map.put("transferReason", record.getTransferTreatmentReason());
			map.put("transferOrg", record.getTransferTreatmentDepartment());

			List<FollowMedicineRecord> meds = followMedicineRecordDao.findMedicineListByFollowId(record.getId());
			if(meds != null && meds.size() > 0){
				int f = 0;
				int g = 3;
				for(int j = 1; j <= meds.size(); j++){
					FollowMedicineRecord med = meds.get(j-1);
					if("SX0069_50".equals(med.getServiceName())){
						g = g + 1;
						String drugName = "drugName" + g;
						String num = "num" + g;
						String dosage = "dosage" + g;
						map.put(drugName, med.getDrugName());
						map.put(num, med.getNum());
						map.put(dosage, med.getDosage());
					}else{
						f = f + 1;
						String drugName = "drugName" + f;
						String num = "num" + f;
						String dosage = "dosage" + f;
						map.put(drugName, med.getDrugName());
						map.put(num, med.getNum());
						map.put(dosage, med.getDosage());
					}

				}
			}
			
			//康复措施
			String rebs = record.getRehabilitationMeasure();
			if(StringUtil.isNotEmpty(rebs)){
				String[] reb = rebs.split(",");
				for(int i = 1; i <= reb.length; i++){
					map.put("reb" + i , reb[i -1]);
				}
			}
			map.put("rehabOther", record.getRehabilitationMeasureOther());
			
			//随访分类
			map.put("visitClass", record.getNextVisitClassify());
			if(StringUtil.isNotEmpty(record.getNextVisitDate())){
				String[] d = record.getNextVisitDate().split("-");
				map.put("nextYear", d[0]);
				if(d.length > 1){
					map.put("nextMonth", d[1]);
				}
				
				if(d.length > 2){
					map.put("nextDay", d[2]);
				}
			}
			map.put("doctor", record.getVisitDoctor());		
			
		}
		return map;
	}


}
