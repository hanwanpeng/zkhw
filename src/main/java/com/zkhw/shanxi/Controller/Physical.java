package com.zkhw.shanxi.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.util.StringUtil;
import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.framework.utils.JsonWebPrintUtils;
import com.zkhw.pub.entity.HospitalizedRecord;
import com.zkhw.pub.entity.TakeMedicineRecord;
import com.zkhw.pub.entity.VaccinationRecord;
import com.zkhw.pub.service.PhysicalExaminationService;
import com.zkhw.pub.vo.PhysicalExaminationVo;
import com.zkhw.shanxi.bo.Businessdata;
import com.zkhw.shanxi.bo.Examination;
import com.zkhw.shanxi.bo.FamilyPractice;
import com.zkhw.shanxi.bo.Header;
import com.zkhw.shanxi.bo.Hospitalized;
import com.zkhw.shanxi.bo.TakeMedicineCondition;
import com.zkhw.shanxi.bo.Vaccination;
import com.zkhw.shanxi.utils.ConvertObject;
import com.zkhw.shanxi.utils.IdTest;
import com.zkhw.shanxi.utils.XmlUtils;
import com.zkhw.shanxi.vo.ExaminationVo;
import com.zkhw.shanxi.vo.HospitalizedVo;
import com.zkhw.shanxi.vo.TakeMedicineVo;
import com.zkhw.shanxi.vo.VaccinationVo;

@Controller
@RequestMapping("/shanxi/push")
public class Physical {

	@Autowired
	private PhysicalExaminationService physicalExaminationService;

	@ResponseBody
	@RequestMapping(value = "/physicalPush", method = RequestMethod.GET)
	public void physicalPush(HttpServletRequest req, HttpServletResponse resp, ApiJsonResult result, String archiveNo) {
		try {

			Businessdata data = new Businessdata();

			Header header = new Header();
			header.setFunctioncode("CHECK_1001");
			header.setErrCode("0");
			header.setErrMsg("");
			header.setCmd("insert");
			data.setHeader(header);

			List<Object> list = new ArrayList<Object>();

			ExaminationVo examVo = new ExaminationVo();

			// 获取Id
			String healthCheckName = "EHR_Arch_HealthCheck";
			IdTest idTest = new IdTest();
			String areaCode = "6104";//6199
			String duns = "61990011X1009";
			String token = "123456";
			String userId = "610404197712260672";
			String compId = "123";//企业的统一信用代码
			String healthCheckId = idTest.getId(healthCheckName, areaCode, duns, token, userId, compId);
			if (!StringUtil.isEmpty(healthCheckId)) {
				examVo.setId(healthCheckId);
			}

			// 体检
			PhysicalExaminationVo vo = physicalExaminationService.getPhysicalExaminationByArchiveNo(archiveNo);
			
			// 数据交换
			// 检查分类 SX0356
			examVo.setCheckFlag("SX0356_3");
			//健康档案ID
			examVo.setIdNumber(vo.getIdNumber());
			//检查日期
			examVo.setCheckDate(vo.getCheckDate());
			//责任医生
			examVo.setDutydoctor("");
			//症状 CV5101.27
			String symptom = vo.getSymptom();
			String[] symptomArrs = symptom.split(",");
			String symptomArr = null;
			//String subSymptom = "";
			for (int i = 0; i < symptomArrs.length; i++) {
				symptomArr = symptomArrs[i];
				if("1".equals(symptomArr)) {//无症状
					symptom += "|CV5101.27_28";
				}
				if("2".equals(symptomArr)) {//头痛
					symptom += "|CV5101.27_1";
				}
				if("3".equals(symptomArr)) {//头晕
					symptom += "|CV5101.27_2";
				}
				if("4".equals(symptomArr)) {//心悸
					symptom += "|CV5101.27_3";
				}
				if("5".equals(symptomArr)) {//胸闷
					symptom += "|CV5101.27_4";
				}
				if("6".equals(symptomArr)) {//胸痛
					symptom += "|CV5101.27_5";
				}
				if("7".equals(symptomArr)) {//慢性咳嗽
					symptom += "|CV5101.27_6";
				}
				if("8".equals(symptomArr)) {//咳痰
					symptom += "|CV5101.27_7";
				}
				if("9".equals(symptomArr)) {//呼吸困难
					symptom += "|CV5101.27_8";
				}
				if("10".equals(symptomArr)) {//多饮
					symptom += "|CV5101.27_9";
				}
				if("11".equals(symptomArr)) {//多尿
					symptom += "|CV5101.27_10";
				}
				if("12".equals(symptomArr)) {//体重下降
					symptom += "|CV5101.27_11";
				}
				if("13".equals(symptomArr)) {//乏力
					symptom += "|CV5101.27_12";
				}
				if("14".equals(symptomArr)) {//关节肿痛
					symptom += "|CV5101.27_13";
				}
				if("15".equals(symptomArr)) {//视力模糊
					symptom += "|CV5101.27_14";
				}
				if("16".equals(symptomArr)) {//手脚麻木
					symptom += "|CV5101.27_15";
				}
				if("17".equals(symptomArr)) {//尿急
					symptom += "|CV5101.27_29";
				}
				if("18".equals(symptomArr)) {//尿痛
					symptom += "|CV5101.27_17";
				}
				if("19".equals(symptomArr)) {//便秘
					symptom += "|CV5101.27_18";
				}
				if("20".equals(symptomArr)) {//腹泻
					symptom += "|CV5101.27_19";
				}
				if("21".equals(symptomArr)) {//恶心呕吐
					symptom += "|CV5101.27_20";
				}
				if("22".equals(symptomArr)) {//眼花
					symptom += "|CV5101.27_21";
				}
				if("23".equals(symptomArr)) {//耳鸣
					symptom += "|CV5101.27_22";
				}
				if("24".equals(symptomArr)) {//乳房胀痛
					symptom += "|CV5101.27_30";
				}
				if("25".equals(symptomArr)) {//其他
					symptom += "|CV5101.27_99";
				}
			}
			symptom.substring(1, symptom.length());
			examVo.setSymptom(symptom);
			//其他症状
			examVo.setSymptomOther(vo.getSymptomOther());
			//体温(℃)
			examVo.setBaseTemperature(vo.getBaseTemperature());
			//脉率（次/分钟）
			examVo.setBaseHeartbeat(vo.getBaseHeartbeat());
			//呼吸频率（次/分钟）
			examVo.setBaseRespiratory(vo.getBaseRespiratory());
			//血压(左侧舒张压)
			examVo.setBaseBloodPressureLeftLow(vo.getBaseBloodPressureLeftHigh());
			//血压(左侧收缩压)
			examVo.setBaseBloodPressureLeftHigh(vo.getBaseBloodPressureLeftLow());
			//血压(右侧舒张压)
			examVo.setBaseBloodPressureRightLow(vo.getBaseBloodPressureRightHigh());
			 //血压(右侧收缩压)
			examVo.setBaseBloodPressureRightHigh(vo.getBaseBloodPressureRightLow());
			// 身高（cm）
			examVo.setBaseHeight(vo.getBaseHeight());
			//体重（kg）
			examVo.setBaseWeight(vo.getBaseWeight());
			// 腰围(cm)
			examVo.setBaseWaist(vo.getBaseWaist());
			//体质指数(kg/㎡)
			examVo.setBaseBmi(vo.getBaseBmi());
			//老年人健康状态自我评估 SX0009
			String he = vo.getBaseHealthEstimate();
			if(!StringUtil.isEmpty(he)) {
				if("1".equals(he)) {//满意
					examVo.setBaseHealthEstimate("SX0009_1");
				}
				if("2".equals(he)) {//基本满意
					examVo.setBaseHealthEstimate("SX0009_2");
				}
				if("3".equals(he)) {//说不清楚
					examVo.setBaseHealthEstimate("SX0009_3");
				}
				if("4".equals(he)) {//不太满意
					examVo.setBaseHealthEstimate("SX0009_4");
				}
				if("5".equals(he)) {//不满意
					examVo.setBaseHealthEstimate("SX0009_5");
				}
			}
			//老年人生活自理能力自我评估 SX0010
			//vo.get
			//examVo.setBaseSelfcareEstimate("SX0010_1");
			
			
			

			
			
			
			
			
			
			Examination exam = ConvertObject.convertExam(examVo);
			list.add(exam);

			// 住院史
			HospitalizedVo hospVo = new HospitalizedVo();
			// 设置Id
			String inprecordName = "EHR_Arch_Inprecord";
			IdTest idTest2 = new IdTest();
			String inprecordId = idTest2.getId(inprecordName, areaCode, duns, token, userId, compId);
			if (!StringUtil.isEmpty(inprecordId)) {
				hospVo.setId(inprecordId);
			}

			// 数据库获取
			List<HospitalizedRecord> hosList = vo.getHospitals();
			if (hosList != null) {
				HospitalizedRecord hospitalized = null;
				for (int i = 0; i < hosList.size(); i++) {
					hospitalized = hosList.get(i);
					Integer hosType = hospitalized.getHospitalizedType();
					if (1 == hosType) {// 住院史

						hospVo.setIdNumber(hospitalized.getIdNumber());
						hospVo.setServiceName("SX0069_3");
						hospVo.setExamId(healthCheckId);
						hospVo.setInHospitalTime(hospitalized.getInHospitalTime());
						hospVo.setLeaveHospitalTime(hospitalized.getLeaveHospitalTime());
						hospVo.setReason(hospitalized.getReason());
						hospVo.setHospitalOrgan(hospitalized.getHospitalOrgan());
						hospVo.setCaseCode(hospitalized.getCaseCode());
						hospVo.setRemark(hospitalized.getRemark());
						hospVo.setCreateOrg(hospitalized.getCreateOrg());

						Hospitalized h = ConvertObject.convertToHospitalized(hospVo);
						list.add(h);

					}
				}
			}

			// 家庭病床史
			HospitalizedVo famVo = new HospitalizedVo();
			// 设置Id
			String homebedName = "EHR_Arch_Homebed";
			IdTest idTest3 = new IdTest();
			String homebedId = idTest3.getId(homebedName, areaCode, duns, token, userId, compId);
			if (!StringUtil.isEmpty(homebedId)) {
				famVo.setId(homebedId);
			}

			// 数据库获取
			List<HospitalizedRecord> famList = vo.getHospitals();
			if (famList != null) {
				HospitalizedRecord familyRecord = null;
				for (int i = 0; i < famList.size(); i++) {
					familyRecord = famList.get(i);
					Integer hosType = familyRecord.getHospitalizedType();
					if (2 == hosType) {//家庭病床史

						famVo.setIdNumber(familyRecord.getIdNumber());
						famVo.setServiceName("SX0069_3");
						famVo.setExamId(healthCheckId);
						famVo.setInHospitalTime(familyRecord.getInHospitalTime());
						famVo.setLeaveHospitalTime(familyRecord.getLeaveHospitalTime());
						famVo.setReason(familyRecord.getReason());
						famVo.setHospitalOrgan(familyRecord.getHospitalOrgan());
						famVo.setCaseCode(familyRecord.getCaseCode());
						famVo.setRemark(familyRecord.getRemark());
						famVo.setCreateOrg(familyRecord.getCreateOrg());
						
						FamilyPractice fam = ConvertObject.convertToFamilyPractice(famVo);		
						list.add(fam);
					}
				}
			}

			
			// 用药
			TakeMedicineVo takeVo = new TakeMedicineVo();
			// 设置Id
			String druguseName = "EHR_Arch_Druguse";
			IdTest idTest4 = new IdTest();
			String druguseId = idTest4.getId(druguseName, areaCode, duns, token, userId, compId);
			if (!StringUtil.isEmpty(druguseId)) {
				takeVo.setId(druguseId);
			}

			// 获取数据库
			List<TakeMedicineRecord> medicinesList = vo.getMedicines();
			if (medicinesList != null) {
				TakeMedicineRecord medicine = null;
				for (int i = 0; i < medicinesList.size(); i++) {
					medicine = medicinesList.get(i);

					takeVo.setIdNumber(medicine.getIdNumber());
					takeVo.setServiceName("SX0069_3");
					takeVo.setExamId(healthCheckId);
					takeVo.setMedicineType("CV5301.06_100");//用药类型
					takeVo.setMedicineName(medicine.getMedicineName());//用药名称
					takeVo.setMedicineUsage(medicine.getMedicineUsage());//用法
					takeVo.setFrequency(medicine.getFrequency());//频次SX0153_10
					takeVo.setMedicineDosage(medicine.getMedicineDosage());//用量
					takeVo.setUnit(medicine.getUnit());//用量单位SX0154_5
					takeVo.setMedicineTime(medicine.getMedicineTime());//用药时间
					takeVo.setMedicineTimeUnit(medicine.getMedicineTimeUnit());//用药年限单位CV4202.05_2
					
					//服药依从性(1规律2间断3不服药)
					String mc = medicine.getMedicineCompliance();
					if(!StringUtil.isEmpty(mc)) {
						if(mc.equals("1")) {
							takeVo.setMedicineCompliance("SX0028_1");
						}
						if(mc.equals("2")) {
							takeVo.setMedicineCompliance("SX0028_2");
						}
						if(mc.equals("3")) {
							takeVo.setMedicineCompliance("SX0028_3");
						}
					}
					
					takeVo.setOther(medicine.getOther());//其他说明
					takeVo.setCreateOrg(medicine.getCreateOrg());//机构

					TakeMedicineCondition take = ConvertObject.convertToTakeMedicine(takeVo);
					list.add(take);

				}
			}

			// 接种
			VaccinationVo vaccVo = new VaccinationVo();
			// 设置Id
			String inocNoteName = "EHR_Immu_InocNote";
			IdTest idTest5 = new IdTest();
			String inocNoteId = idTest5.getId(inocNoteName, areaCode, duns, token, userId, compId);
			if (!StringUtil.isEmpty(inocNoteId)) {
				vaccVo.setId(inocNoteId);
			}

			// 调用数据库
			List<VaccinationRecord> vaccinationsList = vo.getVaccinations();
			if (vaccinationsList != null) {
				VaccinationRecord vaccination = null;
				for (int i = 0; i < vaccinationsList.size(); i++) {
					vaccination = vaccinationsList.get(i);

					vaccVo.setIdNumber(vaccination.getIdNumber());
					vaccVo.setServiceName("SX0030_6");
					vaccVo.setExamId(healthCheckId);
					vaccVo.setCardId("");//接种证编码
					vaccVo.setVaccinationType("SX0190_1");//接种类型
					vaccVo.setVaccinationId("CV08.50.001_02");//疫苗编码
					vaccVo.setVaccinationName("结合疫苗");//接种名称
					vaccVo.setAcuscount("1");//疫苗编码
					vaccVo.setDose("2");//剂量
					vaccVo.setDescnption("一次两支");//剂次描述
					vaccVo.setInocuState("SX0313_2");//接种状态,未接种 已接种
					vaccVo.setSinocuDate("2019-04-24");//应接种日期
					vaccVo.setInocuDoctor("131182189005021635");//接种医生
					vaccVo.setRegisterPerson("131182189005021635");//登记人
					vaccVo.setVaccinationTime("2019-02-01");//接种日期
					vaccVo.setDzjgm("123");//电子监管码
					vaccVo.setBatchNumber("01020326541");//疫苗批号
					vaccVo.setCounty("SX0131_3");//接种县国标
					vaccVo.setInoculationSite("SX0504_1");//接种部位
					vaccVo.setInoculationWay("SX0507_1");//接种途径 
					vaccVo.setVaccinationOrgan("61990011X1009");//接种机构
					vaccVo.setVaccinationOrganName("接种医院");//接种机构名称
					vaccVo.setRemark("正常");//备注
					vaccVo.setValiddate("2019-02-25");//有效日期
					vaccVo.setManufacturer("重庆药厂");//生产企业名称
					vaccVo.setManufactCode("610000000000466");//生产企业编码
					vaccVo.setInputDate("2019-02-25");//录入时间
					vaccVo.setVaccinationOrganName("61990011X1009");//录入机构（数据库没有，需要新建）

					Vaccination vacc = ConvertObject.convertToVaccination(vaccVo);
					list.add(vacc);
				}
			}

			data.setBody(list);

			String reqXml = XmlUtils.modelToStringXML(data);
			reqXml = reqXml.replace("<body>", "<body><![CDATA[");
			reqXml = reqXml.replace("</body>", "]]></body>");

			System.out.println(reqXml);

			result.setCode("0");
			result.setMsg("推送成功");
		} catch (Exception e) {
			result.setCode("1");
			result.setMsg("推送失败");
		}
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}

}
