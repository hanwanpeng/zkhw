package com.zkhw.flup.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import com.zkhw.flup.bo.DiabetesFollowBo;
import com.zkhw.flup.bo.DiabetesListBo;
import com.zkhw.flup.dao.DiabetesFollowRecordDao;
import com.zkhw.flup.dao.FollowMedicineRecordDao;
import com.zkhw.flup.entity.DiabetesFollowRecord;
import com.zkhw.flup.entity.FollowMedicineRecord;
import com.zkhw.flup.service.DiabetesService;
import com.zkhw.framework.utils.StringUtils;
import com.zkhw.pub.dao.ResidentBaseInfoDao;
import com.zkhw.pub.entity.ResidentBaseInfo;
import com.zkhw.pub.query.ResidentBaseInfoQuery;

@Service
public class DiabetesServiceImpl implements DiabetesService {
	
	@Autowired
	private ResidentBaseInfoDao residentBaseInfoDao;
	
	@Autowired
	private DiabetesFollowRecordDao diabetesFollowRecordDao;
	
	@Autowired
	private FollowMedicineRecordDao followMedicineRecordDao;
	
	
	/**
	 * 糖尿病花名册
	 * @throws UnsupportedEncodingException 
	 */
	@Override
	public void diabetesForExcel(ResidentBaseInfoQuery redident) throws UnsupportedEncodingException {
		ExcelUtil excelutil = new ExcelUtil();
		//表头
		ArrayList<String> headerList = new ArrayList<String>();
		String[] header = {"村名","姓名","性别","年龄","身份证号码","现住址","电话"};
		for (int i = 0; i < header.length; i++) {
			headerList.add(header[i]);
		}
		//行内容
		ArrayList<List<String>> rowList = new ArrayList<List<String>>();
		redident.setIsDiabetes(1);
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
		String xlsPath = "C:\\Users\\Administrator\\Desktop\\糖尿病花名册.xls";
		//工作表名称
		String sheetName = "糖尿病花名册";
		
		try {
			excelutil.writeExcel(headerList, rowList, xlsPath, sheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public PageInfos<DiabetesListBo> findDiabetesByPage(ResidentBaseInfoQuery redident,
			PageInfos<DiabetesListBo> pageData) {
		PageHelper.startPage( (int)pageData.getPage(), (int)pageData.getPageSize());//pageNum, pageSize
		List<ResidentBaseInfo> list = residentBaseInfoDao.findResidentList(redident);
		PageInfo<ResidentBaseInfo> page = new PageInfo<ResidentBaseInfo>(list);
		List<DiabetesListBo> diabetesList = new ArrayList<DiabetesListBo>();
		for(int i = 0; i < list.size(); i++){
			DiabetesListBo bo = new DiabetesListBo();
			BeanUtils.copyProperties(list.get(i), bo);
			DiabetesFollowRecord  r = diabetesFollowRecordDao.findLastFollowRecord(list.get(i).getArchiveNo());
			if(r != null){
				bo.setFollowId(r.getId());
				bo.setVisitDate(r.getVisitDate());
				bo.setNextVisitDate(r.getNextVisitDate());
			}
			diabetesList.add(bo);			
		}
		pageData.setPage(page.getPageNum());      //当前页码
		pageData.setPageCount(page.getPages());   //总页数
		pageData.setPageSize(page.getPageSize()); //每页记录数
		pageData.setTotal(page.getTotal()); 
		pageData.setRows(diabetesList);
		return pageData;
	}

	@Override
	public DiabetesFollowBo getDiabetesFollowRecordById(String id) {
		DiabetesFollowBo bo = new DiabetesFollowBo();
		DiabetesFollowRecord diabetes = diabetesFollowRecordDao.selectByPrimaryKey(id);
		List<FollowMedicineRecord> list = followMedicineRecordDao.findMedicineListByFollowId(id);
		bo.setDiabetes(diabetes);
		bo.setMedicineList(list);
		return bo;
	}

	@Override
	public PageInfos<DiabetesFollowRecord> findFollowRecordByPage(DiabetesFollowRecord record,
			PageInfos<DiabetesFollowRecord> pageData) {
		PageHelper.startPage( (int)pageData.getPage(), (int)pageData.getPageSize());//pageNum, pageSize
		List<DiabetesFollowRecord> list = diabetesFollowRecordDao.findFollowRecordList(record);
		PageInfo<DiabetesFollowRecord> page = new PageInfo<DiabetesFollowRecord>(list);
		pageData.setPage(page.getPageNum());      //当前页码
		pageData.setPageCount(page.getPages());   //总页数
		pageData.setPageSize(page.getPageSize()); //每页记录数
		pageData.setTotal(page.getTotal()); 
		pageData.setRows(page.getList());
		return pageData;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Map<String, String> exportPdf(String archiveNo, String year) {
		DiabetesFollowRecord record = new DiabetesFollowRecord();
		record.setArchiveNo(archiveNo);
		if(StringUtil.isEmpty(year)){
			Date now = new Date();
			int y = 1900 + now.getYear();
			record.setVisitDate(String.valueOf(y));
		}else{
			record.setVisitDate(year);
		}
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
		
		List<DiabetesFollowRecord> list = diabetesFollowRecordDao.findFollowByYear(record);
		if(list != null && list.size() > 0){			
			for(int i = 0; i < list.size(); i++){
				DiabetesFollowRecord diabete = list.get(i);
				int index = i + 1;
				//姓名
				map.put("name", diabete.getName());
				//随访日期
				map.put("visitDate" + index, diabete.getVisitDate());		

				//随访方式
				map.put("visitType" + index, diabete.getVisitType());
				//症状
				String symptoms = diabete.getSymptom();
				if(StringUtil.isNotEmpty(symptoms)){
					String[] s = symptoms.split(",");
					for(int j = 1; j <= s.length; j++){
						String sym = "sym" + index;
						sym = sym + j;
						map.put(sym , s[j -1]);
					}
				}
				
				//其他症状
				map.put("otherSymptom" + index, diabete.getSymptomOther());
				
				//血压
				map.put("dbp" + index, diabete.getBloodPressureLow() == null?"":diabete.getBloodPressureLow().toString());
				map.put("sbp" + index, diabete.getBloodPressureHigh()== null?"":diabete.getBloodPressureHigh().toString());
				

				//体重
				map.put("weight" + index, diabete.getWeightNow());
				map.put("tweight" + index, diabete.getWeightNext());
				
				//bmi
				map.put("bmi" + index, diabete.getBmiNow());
				map.put("tbmi" + index, diabete.getBmiNext());	
				
				map.put("dorsal" + index, diabete.getDorsalArtery());	
				if("2".equals(diabete.getDorsalArtery())){
					map.put("attenuate" + index + diabete.getPulsationPosition(), "√");
				}else if("3".equals(diabete.getDorsalArtery())){
					map.put("disappear" + index + diabete.getPulsationPosition(), "√");
				}
				
				
				//其他
				map.put("other" + index, diabete.getOther());
				
				//吸烟
				map.put("smoken" + index, diabete.getSmokeNow() == null?"":diabete.getSmokeNow() .toString());
				map.put("tsmoken" + index, diabete.getSmokeNext() == null?"":diabete.getSmokeNext().toString());
			
				//饮酒
				map.put("wine" + index, diabete.getDrinkNow() == null?"":diabete.getDrinkNow().toString());
				map.put("twine" + index, diabete.getDrinkNext() == null?"":diabete.getDrinkNext().toString());
				
				//运动
				map.put("sportWeek" + index, diabete.getSportsNumNow() == null?"":diabete.getSportsNumNow().toString());
				map.put("sportOnce" + index, diabete.getSportsTimeNow() == null?"":diabete.getSportsTimeNow().toString());
				
				map.put("tsportWeek" + index, diabete.getSportsNumNext() == null?"":diabete.getSportsNumNext().toString());
				map.put("tsportOnce" + index, diabete.getSportsTimeNext() == null?"":diabete.getSportsTimeNext().toString());
				
				//主食
				map.put("staple" + index, diabete.getStapleFoodNow());
				map.put("tstaple" + index, diabete.getStapleFoodNext());
				
				//心里调节
				map.put("mind" + index, diabete.getPsychologicalRecovery());
				
				//遵医行为
				map.put("obey" + index, diabete.getMedicalCompliance());
				
				//空腹血糖
				map.put("glucose" + index, diabete.getBloodGlucose());
				
				//辅助检查
				map.put("examine" + index, diabete.getGlycosylatedHemoglobin());
				map.put("checkDate" + index, diabete.getCheckDate());		
				String checkDate = diabete.getCheckDate();
				
				if(!"".equals(checkDate)){
					String[] b = checkDate.split("-");
					map.put("checkYear" + index, b[0]);					
					map.put("checkMonth" + index, b[1]);
					map.put("checkDay" + index, b[2]);
				}
				
				//服药依从性
				map.put("drugObey" + index, diabete.getCompliance());
				
				//药物不良反应
				map.put("effect" + index, diabete.getUntowardEffect());
				map.put("effectInfo" + index, diabete.getUntowardEffectDrug());
				
				//低血糖反应
				map.put("reactive" + index, diabete.getReactiveHypoglycemia());
				
				//随访分类
				map.put("visitClass" + index, diabete.getFollowType());
				
				List<FollowMedicineRecord> meds = followMedicineRecordDao.findMedicineListByFollowId(diabete.getId());
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
				
				//胰岛素
				map.put("insulinName" + index, diabete.getInsulinName());
				map.put("insulinUsage" + index, diabete.getInsulinUsage());
				
				//转诊
				map.put("reason" + index, diabete.getTransferTreatmentReason());
				map.put("torgan" + index, diabete.getTransferTreatmentDepartment());
				
				//下次随访日期
				map.put("nvisitDate" + index, diabete.getNextVisitDate());
				
				//随访医生
				map.put("visitDoctor" + index, diabete.getVisitDoctor());
			}								
			
		}
		return map;	
	}

	

}
