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
import com.zkhw.flup.dao.ChildrenHealthRecordDao;
import com.zkhw.flup.dao.NeonatusInfoDao;
import com.zkhw.flup.entity.ChildrenHealthRecord;
import com.zkhw.flup.entity.NeonatusInfo;
import com.zkhw.flup.service.ChildrenService;
import com.zkhw.framework.utils.JsonWebPrintUtils;

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

	@Override
	public Map<String, String> exportInfoPdf(String archiveNo) {
		Map<String, String> map = new HashMap<String,String>();
		NeonatusInfo info = neonatusInfoDao.getNeonatusByArchiveNo(archiveNo);
		
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
			//性别
			map.put("sex", info.getSex());
			String birthday = info.getBirthday();
			
			if(StringUtil.isNotEmpty(birthday)){
				String[] b = birthday.split("-");
				map.put("b1", b[0].substring(0, 1));
				map.put("b2", b[0].substring(1, 2));
				map.put("b3", b[0].substring(2, 3));
				map.put("b4", b[0].substring(3, 4));
				
				map.put("b5", b[1].substring(0, 1));
				map.put("b6", b[1].substring(1, 2));
				
				map.put("b7", b[2].substring(0, 1));
				map.put("b8", b[2].substring(1, 2));
			}
			
			//身份证号
			map.put("idNumber", info.getIdNumber());
			//家庭住址
			map.put("address", info.getHomeAddress());
			//父亲姓名
			map.put("fname", info.getFatherName());
			//父亲职业
			map.put("fprofession", info.getFatherProfession());
			//父亲电话
			map.put("fphone", info.getFatherPhone());
			//父亲出生日期
			map.put("fbirthday", info.getFatherBirthday());
			//母亲名字
			map.put("mname", info.getMotherName());
			//母亲职业
			map.put("mprofession", info.getMotherProfession());
			//母亲电话
			map.put("mphone", info.getMotherPhone());
			//母亲出生日期
			map.put("mbirthday", info.getMotherBirthday());
			//孕周
			map.put("week", info.getGestationalWeeks() == null?"":info.getGestationalWeeks().toString());
			
			//患病情况
			map.put("sicken", info.getSickenStasus());
			map.put("sickenOther", info.getSickenOther());
			
			//助产结构名称
			map.put("wifeOrg", info.getMidwifeOrg());
			
			//出生情况
			String situation = info.getBirthSituation();
			if(StringUtil.isNotEmpty(situation)){
				String[] sit = situation.split(",");
				for(int i = 1; i <= sit.length; i++){
					map.put("birth" + i , sit[i -1]);
				}
			}			
			map.put("birthOther", info.getBirthOther());
			
			//新生儿窒息
			map.put("asphyxia", info.getAsphyxiaNeonatorum());
						
			String time = info.getAsphyxiaTime();
			map.put("time" + time , "√");
			
			//畸形
			map.put("deformity", info.getDeformity());
			map.put("deformityOther", info.getDeformityOther());
			
			//新生儿听力
			map.put("hearing", info.getHearing());
			
			//新生儿疾病
			String disease = info.getDisease();
			if(StringUtil.isNotEmpty(situation)){
				String[] dis = disease.split(",");
				for(int i = 1; i <= dis.length; i++){
					map.put("disease" + i , dis[i -1]);
				}
			}	
			map.put("diseaseOther", info.getDiseaseOther());
			
			//出生体重
			map.put("bweight", info.getBirthWeight());
			//目前体重
			map.put("weight", info.getWeight());
			//出生身高
			map.put("height", info.getBirthHeight());
			//喂养方式
			map.put("feeding", info.getFeedingPatterns());
			
			//吃奶次数
			map.put("milknum", info.getMilkNum()==null?"":info.getMilkNum().toString());
			//吃奶量
			map.put("milkintake", info.getMilkIntake()==null?"":info.getMilkIntake().toString());
			//呕吐
			map.put("vomit", info.getVomit());
			//大便
			map.put("shit", info.getShit());
			//大便次数
			map.put("defecationNum", info.getDefecationNum()==null?"":info.getDefecationNum().toString());
			//体温
			map.put("temperature", info.getTemperature());
			//心率
			map.put("heartRate", info.getHeartRate()==null?"":info.getHeartRate().toString());
			//呼吸评率
			map.put("breathingRate", info.getBreathingRate()==null?"":info.getBreathingRate().toString());
			//面色
			map.put("complexion", info.getComplexion());
			map.put("complexionOther", info.getComplexionOther());
			
			//黄疸部位
			String aurigo = info.getAurigo();
			if(StringUtil.isNotEmpty(aurigo)){
				String[] aur = aurigo.split(",");
				for(int i = 1; i <= aur.length; i++){
					map.put("aurigo" + i , aur[i -1]);
				}
			}
			map.put("aurigoOther", info.getAurigoOther());
			//前囱
			map.put("wide", info.getAnteriorFontanelleWide());
			map.put("high", info.getAnteriorFontanelleHigh());
			map.put("anterior", info.getAnteriorFontanelle());
			map.put("anteriorOther", info.getAnteriorFontanelleOther());
			
			//眼睛
			map.put("eye", info.getEye());
			//四肢活动度
			map.put("extremity", info.getExtremityMobility());
			//耳外观
			map.put("ear", info.getEar());
			//颈部包块
			map.put("mass", info.getNeckMass());
			//鼻子
			map.put("nose", info.getNose());
			//皮肤
			map.put("skin", info.getSkin());
			map.put("skinOther", info.getSkinOther());
			//口腔
			map.put("cavity", info.getOralCavity());
			//肛门
			map.put("anus", info.getAnus());
			//心肺听诊
			map.put("lung", info.getHeartLung());
			//胸部
			map.put("breast", info.getBreast());
			//腹部触诊
			map.put("abdominal", info.getAbdominalTouch());
			//脊柱
			map.put("spine", info.getSpine());
			//外生殖器
			map.put("aedea", info.getAedea());
			//脐带
			map.put("umbilical", info.getUmbilicalCord());
			map.put("umbilicalOther", info.getUmbilicalCordOther());

			//转诊
			map.put("transfer", info.getTransferTreatment());
			map.put("transferReason", info.getTransferTreatmentReason());
			map.put("transferOrg", info.getTransferTreatmentDepartment());
			
			//健康指导
			String guidance = info.getGuidance();
			if(StringUtil.isNotEmpty(guidance)){
				String[] gui = guidance.split(",");
				for(int i = 1; i <= gui.length; i++){
					map.put("gui" + i , gui[i-1]);
				}
			}
			map.put("guidanceOther", info.getGuidanceOther());
						
			//随访时间
			//随访日期
			String visitDate = info.getVisitDate();
			
			if(StringUtil.isNotEmpty(visitDate)){
				String[] b = visitDate.split("-");
				map.put("year", b[0]);					
				map.put("month", b[1]);
				map.put("day", b[2]);
			}
			
			map.put("nextaddress", info.getNextVisitAddress());
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

	@Override
	public Map<String, String> exportFollowPdf(String archiveNo, String type) {
		Map<String, String> map = new HashMap<String,String>();
		ChildrenHealthRecord record = new ChildrenHealthRecord();
		record.setArchiveNo(archiveNo);
		if("1".equals(type)){
			record.setAge(8);
		}else if("2".equals(type)){
			record.setAge(30);
		}else if("3".equals(type)){
			record.setAge(72);
		}else{
			record.setAge(8);
		}
		List<ChildrenHealthRecord> list = childrenHealthRecordDao.findFollowRecordBetweenAge(record);
		
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
		
		if(list != null && list.size() > 0){
			for(int i = 0; i < list.size(); i++){
				ChildrenHealthRecord info = list.get(i);
				
				int age = info.getAge();
				
				//姓名
				map.put("name", info.getName());
				//随访日期
				map.put("visitDate" + age, info.getVisitDate());				
				//体重
				map.put("weight" + age, info.getWeight());
				
				String wevaluate = info.getWeightEvaluate();
				map.put("wevaluate" + age + wevaluate , "√");				
				//身高
				map.put("height" + age, info.getHeight());
				String hevaluate = info.getHeightEvaluate();
				map.put("hevaluate" + age + hevaluate , "√");	
				
				if(age >= 36 ){
					
					map.put("wh" + age, "");
					String wh = info.getWeightHeight();
					map.put("whevaluate" + age + wh , "√");	
					
					//体格发育评价
					String assessment = info.getPhysicalAssessment();
					map.put("assessment" + age + assessment, "√");	
				}
				
				if(age <= 8){
					//头围
					map.put("head" + age, info.getHeadCircumference());	
				}
				
				if(age <= 30){
					//面色
					map.put("complexion" + age + info.getComplexion(), "√");	
					map.put("complexionOther" + age, info.getComplexionOther());
					
					//皮肤
					map.put("skin" + age + info.getSkin(), "√");	
					map.put("skinOther" + age, info.getSkinOther());	
					
					if(age != 30){
						//前囱
						map.put("wide" + age, info.getAnteriorFontanelleWide());
						map.put("high" + age, info.getAnteriorFontanelleHigh());
						map.put("anterior" + age + info.getAnteriorFontanelle(), "√");
					}
					
					if(age < 8){
						//颈部包块
						map.put("mass" + age + info.getNeckMass(), "√");
					}				
					
					//眼睛
					map.put("eye" + age + info.getEye(), "√");
					map.put("eyeOther" + age, info.getEyeOther());
					
					//耳外观
					map.put("ear" + age + info.getEar(), "√");
					map.put("earOther" + age, info.getEarOther());
					
					//四肢活动度
					map.put("extremity" + age + info.getExtremity(), "√");
					map.put("extremityOther" + age, info.getExtremityOther());
					
					//步态
					if(age >= 18){
						map.put("gait" + age + info.getGait(), "√");
					}
					
					//可疑佝偻病症状
					if(age == 3 || age == 6 || age == 8){
						map.put("rickets" + age + info.getRicketsSymptom(), "√");
					}
					
					//可疑佝偻病体征
					map.put("ricketsSign" + age + info.getRicketsSign(), "√");
				}

				//口腔
				if(age == 1 || age == 3){
					map.put("cavity" + age + info.getOralCavity(), "√");
					map.put("cavityOther" + age, info.getCavityOther());
				}else{
					map.put("teething" + age, info.getTeethingNum() == null?"":info.getTeethingNum().toString());
					map.put("caries" + age, info.getCariesNum() == null?"":info.getCariesNum().toString());
				}
				
				if(age == 6 || age == 12 || age == 24 || age == 36){
					map.put("hearing" + age + info.getHearing(), "√");
				}
				if(age > 36){
					map.put("vision" + age, info.getVision());
				}
				//胸部
				map.put("breast" + age + info.getBreast(), "√");
				map.put("breastOther" + age, info.getBreastOther());
				
				//腹部
				map.put("abdominal" + age + info.getAbdominal(), "√");	
				map.put("abdominalOther" + age, info.getAbdominalOther());
				
				if(age == 1 || age == 3){
					//脐带
					map.put("umbilical" + age + info.getUmbilicalCord(), "√");
					map.put("umbilicalOther" + age, info.getUmbilicalOther());
				}

				//肛门
				if(age <= 8){
					map.put("anus" + age + info.getAnus(), "√");
					map.put("anusOther" + age, info.getAnusOther());
				}
				
				//血红蛋白值
				map.put("hemoglobin" + age, info.getHemoglobin());
				
				//其他检查
				if(age >= 36){
					map.put("other" + age, info.getOther());
				}
				
				if(age <= 30){
					//户外活动时间
					map.put("outdoor" + age, info.getOutdoorTime());
					//维生素D数量
					map.put("vd" + age, info.getVitamindNum());
				}

				//发育评估
				String growth = info.getGrowth();
				if(StringUtil.isNotEmpty(growth)){
					String[] gro = growth.split(",");
					for(int j = 1; j <= gro.length; j++){
						map.put("growth" + age + gro[j -1], "√");
					}
				}
				
				map.put("sicken" + age + info.getSickenStasus(), "√");
				//肺炎次数
				map.put("pneumonia" + age, info.getPneumoniaNum() == null?"":info.getPneumoniaNum().toString());
				
				//腹泻次数
				map.put("diarrhea" + age, info.getDiarrheaNum() == null?"":info.getDiarrheaNum().toString());
				
				//外伤次数
				map.put("trauma" + age, info.getTraumaNum() == null?"":info.getTraumaNum().toString());
				
				//患病其他
				map.put("sickenOther" + age, info.getSickenOther());				

				//转诊
				map.put("transfer" + age + info.getTransferTreatment(), "√");
				map.put("transferReason" + age, info.getTransferTreatmentReason());
				map.put("transferOrg" + age, info.getTransferTreatmentDepartment());
										
				//健康指导
				String guidance = info.getGuidance();
				if(StringUtil.isNotEmpty(guidance)){
					String[] gui = guidance.split(",");
					for(int j = 1; j <= gui.length; j++){
						map.put("gui" + age + gui[j-1] , "√");
					}
				}
				map.put("guidanceOther" + age, info.getGuidanceOther());
											
				map.put("nextVisit" + age, info.getNextVisitDate());

				map.put("doctor" + age, info.getVisitDoctor());
			}
		}
		return map;
	}

}
