package com.zkhw.shanxi.utils;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.util.StringUtil;
import com.zkhw.common.config.Config;
import com.zkhw.shanxi.bo.Businessdata;
import com.zkhw.shanxi.bo.DangerDisease;
import com.zkhw.shanxi.bo.Examination;
import com.zkhw.shanxi.bo.FamilyPractice;
import com.zkhw.shanxi.bo.Header;
import com.zkhw.shanxi.bo.Hospitalized;
import com.zkhw.shanxi.bo.ResponseError;
import com.zkhw.shanxi.bo.ResponseXml;
import com.zkhw.shanxi.bo.TakeMedicineCondition;
import com.zkhw.shanxi.bo.Vaccination;
import com.zkhw.shanxi.vo.DangerDiseaseVo;
import com.zkhw.shanxi.vo.ExaminationVo;
import com.zkhw.shanxi.vo.HospitalizedVo;
import com.zkhw.shanxi.vo.TakeMedicineVo;
import com.zkhw.shanxi.vo.VaccinationVo;

public class ShanxiTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Businessdata data = new Businessdata();
		
		Header header = new Header();
		header.setFunctioncode("CHECK_1001");
		header.setErrCode("0");
		header.setErrMsg("");
		header.setCmd("insert");
		data.setHeader(header);
		
		List<Object> list = new ArrayList<Object>();
		
		ExaminationVo examVo = new ExaminationVo();
		//获取Id
		String healthCheckName = "EHR_Arch_HealthCheck";
		IdTest idTest = new IdTest();
		String areaCode = "6104";//6199
		String duns = "61990011X1009";
		String token = "123456";
		String userId = "610404197712260672";
		String compId = "123";//企业的统一信用代码
		String healthCheckId = idTest.getId(healthCheckName, areaCode, duns, token, userId, compId);
		if(!StringUtil.isEmpty(healthCheckId)) {
			examVo.setId(healthCheckId);
		}
		
		//检查分类 SX0356 
		examVo.setCheckFlag("SX0356_2");
		//健康档案ID
		//examVo.setArchiveNo("131182199104265015");
		examVo.setIdNumber("131182199104265011");
		
		//检查日期
		examVo.setCheckDate("2019-04-11");
		//责任医生
		examVo.setDutydoctor("131182189005021635");
		//症状 CV5101.27
		examVo.setSymptom("CV5101.27_12");
		//其他症状
		examVo.setSymptomOther("心惊");
		//体温(℃)
		examVo.setBaseTemperature("36");
		//脉率（次/分钟）
		examVo.setBaseHeartbeat("56");
		//呼吸频率（次/分钟）
		examVo.setBaseRespiratory("16");
		//血压(左侧舒张压)
		examVo.setBaseBloodPressureLeftLow(79);
		//血压(左侧收缩压)
		examVo.setBaseBloodPressureLeftHigh(148);
		//血压(右侧舒张压)
		examVo.setBaseBloodPressureRightLow(83);
		 //血压(右侧收缩压)
		examVo.setBaseBloodPressureRightHigh(146);
		// 身高（cm）
		examVo.setBaseHeight("158");
		//体重（kg）
		examVo.setBaseWeight("53.6");
		// 腰围(cm)
		examVo.setBaseWaist("91");
		//体质指数(kg/㎡)
		examVo.setBaseBmi("22.78");
		//老年人健康状态自我评估 SX0009
		examVo.setBaseHealthEstimate("SX0009_2");
		//老年人生活自理能力自我评估 SX0010
		examVo.setBaseSelfcareEstimate("SX0010_1");
		//自理能力评估id
		examVo.setAssessId("");
		//老年人认知功能 SX0078
		examVo.setBaseCognitionEstimate("SX0078_1");
		//智检总分
		examVo.setBaseCognitionScore("");
		 //老年人情感状态 SX0078
		examVo.setBaseFeelingEstimate("SX0078_1");
		//抑郁评分
		examVo.setBaseFeelingScore("");
		//锻炼频率 CV5101.28
		examVo.setLifewayExerciseFrequency("CV5101.28_1");
		//每次锻炼时间（分钟）
		examVo.setLifewayExerciseTime("50");
		//坚持锻炼时间（年）
		examVo.setLifewayExerciseYear("5");
		//锻炼方式
		examVo.setLifewayExerciseType("跑步");
		//饮食习惯 CV5101.29
		examVo.setLifewayDiet("CV5101.29_2");
		//吸烟状况 SX0079
		examVo.setLifewaySmokeStatus("SX0079_3");
		//日吸烟量（支）
		examVo.setLifewaySmokeNumber("10");
		//开始吸烟年龄（岁）
		examVo.setLifewaySmokeStartage("35");
		//戒烟年龄（岁）
		examVo.setLifewaySmokeEndage("");
		//饮酒频率 SX0080
		examVo.setLifewayDrinkStatus("SX0080_3");
		//日饮酒量（两）
		examVo.setLifewayDrinkNumber("2");
		//是否戒酒 SX0081
		examVo.setLifewayDrinkStop("SX0081_1");
		//戒酒年龄（岁）
		examVo.setLifewayDrinkStopage("");
		//开始饮酒年龄（岁）
		examVo.setLifewayDrinkStartage("21");
		//近一年是否曾醉酒 SX0083
		examVo.setLifewayDrinkOneyear("SX0083_1");
		//饮酒种类 CV5305.02
		examVo.setLifewayDrinkType("CV5305.02_2");
		//其它饮酒种类
		examVo.setLifewayDrinkOther("伏特加");
		//有无职业暴露 SX0087
		examVo.setLifewayOccupationalDisease("SX0087_1");
		//职业
		examVo.setLifewayJob("挖煤工");
		//从业时间（年）
		examVo.setLifewayJobPeriod("10");
		//口唇 CV5102.12
		examVo.setOrganLips("CV5102.12_1");
		//齿列 CV5102.13
		examVo.setOrganTooth("CV5102.13_2");
		// 缺齿-左上
		examVo.setOrganHypodontiaTopleft("1");
		// 缺齿-右下
		examVo.setOrganHypodontiaBottomright("2");
		//缺齿-左下
		examVo.setOrganHypodontiaBottomleft("3");
		//缺齿-右上
		examVo.setOrganHypodontiaTopright("4");
		//龋齿-左上
		examVo.setOrganCariesTopleft("3");
		//龋齿-右下
		examVo.setOrganCariesBottomright("1");
		//龋齿-左下
		examVo.setOrganCariesBottomleft("4");
		//龋齿-右上
		examVo.setOrganCariesTopright("2");
		//义齿（假牙）-左上
		examVo.setOrganDentureTopleft("");
		//义齿（假牙）-右下
		examVo.setOrganDentureBottomright("3");
		//义齿（假牙）-左下
		examVo.setOrganDentureBottomleft("1");
		//义齿（假牙）-右上
		examVo.setOrganDentureTopright("5");
		//咽部 SX0015
		examVo.setOrganGuttur("SX0015_1");
		//祼眼视力（左）
		examVo.setOrganVisionLeft("0.7");
		//祼眼视力（右）
		examVo.setOrganVisionRight("0.8");
		//矫正视力（左）
		examVo.setOrganCorrectedvisionLeft("1.1");
		//矫正视力（右）
		examVo.setOrganCorrectedvisionRight("1.2");
		//听力 SX0016
		examVo.setOrganHearing("SX0016_1");
		//运动功能 SX0017
		examVo.setOrganMovement("SX0017_1");
		//眼底 SX0084
		examVo.setExaminationEye("SX0084_2");
		//眼底异常说明
		examVo.setExaminationEyeOther("有血丝");
		//皮肤 CV5102.11
		examVo.setExaminationSkin("CV5102.11_9");
		//皮肤_其它
		examVo.setExaminationSkinOther("发暗");
		//巩膜 SX0089
		examVo.setExaminationSclera("SX0089_3");
		//巩膜_其它
		examVo.setExaminationScleraOther("SX0089_1");
		//淋巴结 CV5102.17
		examVo.setExaminationLymph("CV5102.17_1");
		//淋巴结_其它
		examVo.setExaminationLymphOther("CV5102.17_1");
		//桶状胸 SX0083
		examVo.setExaminationBarrelChest("SX0083_2");
		//呼吸音 SX0084
		examVo.setExaminationBreathSounds("SX0084_2");
		//呼吸音异常说明
		examVo.setExaminationBreastOther("急促");
		//罗音 SX0018
		examVo.setExaminationRale("SX0018_2");
		//罗音_其它
		examVo.setExaminationRaleOther("SX0018_1");
		//心率(次/分钟)
		examVo.setExaminationHeartRate("56");
		//心律 SX0019
		examVo.setExaminationHeartRhythm("SX0019_1");
		//杂音 SX0087
		examVo.setExaminationHeartNoise("SX0087_1");
		//杂音说明
		examVo.setExaminationNoiseOther("有杂音");
		//压痛 SX0087
		examVo.setExaminationAbdomenTenderness("SX0087_1");
		//压痛说明
		examVo.setExaminationTendernessMemo("有压痛");
		//包块 SX0087
		examVo.setExaminationAbdomenMass("SX0087_1");
		//包块说明
		examVo.setExaminationMassMemo("有包块");
		//肝大SX0087
		examVo.setExaminationAbdomenHepatomegaly("SX0087_1");
		//肝大说明
		examVo.setExaminationHepatomegalyMemo("有肝大");
		//脾大SX0087
		examVo.setExaminationAbdomenSplenomegaly("SX0087_1");
		//脾大说明
		examVo.setExaminationSplenomegalyMemo("有脾大");
		//移动性浊音SX0087
		examVo.setExaminationAbdomenShiftingdullness("SX0087_2");
		//移动性浊音说明
		examVo.setExaminationShiftingdullnessMemo("SX0087_1");
		//下肢水肿CV5102.18
		examVo.setExaminationLowerextremityEdema("CV5102.18_1");
		//足背动脉搏动SX0020
		examVo.setExaminationDorsalArtery("SX0020_1");
		//肛门指诊SX0021
		examVo.setExaminationAnus("SX0021_5");
		//肛门指诊_其它
		examVo.setExaminationAnusOther("肛门其他");
		//乳腺 CV5102.03
		examVo.setExaminationBreast("CV5102.03_1");
		//乳腺_其它
		examVo.setExaminationBreastOther("CV5102.03_1");
		//外阴SX0086
		examVo.setExaminationWomanVulva("SX0086_1");
		//外阴异常说明
		examVo.setExaminationVulvaMemo("");
		//阴道SX0086
		examVo.setExaminationWomanVagina("SX0086_1");
		//阴道异常说明
		examVo.setExaminationVaginaMemo("");
		//宫颈 SX0086
		examVo.setExaminationWomanCervix("SX0086_1");
		//宫颈异常说明
		examVo.setExaminationCervixMemo("");
		//宫体 SX0086
		examVo.setExaminationWomanCorpus("SX0086_1");
		//宫体异常说明
		examVo.setExaminationCorpusMemo("");
		//附件 SX0086
		examVo.setExaminationWomanAccessories("SX0086_1");
		//附件异常说明
		examVo.setExaminationAccessoriesMemo("");
		//其它查体
		examVo.setExaminationOther("其他查体");
		//血红蛋白（g/l）
		examVo.setBloodHemoglobin("144");
		//白细胞（×10<sup>9</sup> /l）
		examVo.setBloodLeukocyte("6.7");
		//血小板（×10<sup>9</sup>/l）
		examVo.setBloodPlatelet("273");
		//血常规其它
		examVo.setBloodOther("血常规其他");
		//尿蛋白 SX0186
		examVo.setUrineProtein("SX0186_2");
		// 尿糖 SX0186
		examVo.setGlycosuria("SX0186_1");
		//尿酮体 SX0186
		examVo.setUrineAcetoneBodies("SX0186_3");
		//尿潜血 SX0186
		examVo.setBld("SX0186_4");
		//尿常规其它
		examVo.setUrineOther("尿常规其他");
		//空腹血糖（mmol/l）
		examVo.setBloodGlucoseMmol("4.52");
		//空腹血糖（mg/dl）
		examVo.setBloodGlucoseMg("");
		//心电图 SX0084
		examVo.setCardiogram("SX0084_2");
		//心电图异常说明
		examVo.setCardiogramMemo("窦性心动过缓");
		//尿微量白蛋白（mg/dl）
		examVo.setMicroalbuminuria("2.45");
		//大便潜血 SX0085
		examVo.setFob("SX0085_1");
		//糖化血红蛋白(%)
		examVo.setGlycosylatedHemoglobin("4.8");
		//乙型肝炎表面抗原 SX0085
		examVo.setHb("SX0085_1");
		//血清谷丙转氨酶(u/l)
		examVo.setSgft("16.9");
		//血清谷草转氨酶(u/l)
		examVo.setAst("26.4");
		//白蛋白(g/l)
		examVo.setAlbumin("42");
		//总胆红素(μmol/l)
		examVo.setTotalBilirubin("8.73");
		//结合胆红素(μmol/l)
		examVo.setConjugatedBilirubin("4.6");
		//血清肌酐(μmol/l)
		examVo.setScr("95.1");
		//血尿素氮(mmol/l)
		examVo.setBloodUrea("7.15");
		//血钾浓度(mmol/l)
		examVo.setBloodK("4.1");
		//血钾浓度
		examVo.setBloodNa("138");
		//总胆固醇(mmol/l)
		examVo.setTc("5.65");
		//甘油三酯(mmol/l)
		examVo.setTg("5.04");
		//血清低密度脂蛋白胆固醇(mmol/l)
		examVo.setLdl("3.26");
		//血清高密度脂蛋白胆固醇(mmol/l)
		examVo.setHdl("2.59");
		//胸部x线片 SX0084
		examVo.setChestX("SX0084_1");
		//胸部x线片异常说明
		examVo.setXMemo("");		
		//B超 SX0084
		examVo.setUltrasoundAbdomen("SX0084_2");
		//B超异常说明
		examVo.setUltrasoundMemo("慢性胆囊炎");
		//其他B超 SX0084
		examVo.setOtherB("SX0084_1");
		examVo.setOtherbMemo("");
		//宫颈涂片 SX0084
		examVo.setCervicalSmear("SX0084_1");
		//宫颈涂片异常说明
		examVo.setCervicalSmearMemo("");
		//其它辅助检查
		examVo.setOther("其它辅助检查");
		//平和质 SX0088
		examVo.setTcmPhz("SX0088_2");
		//气虚质 SX0088
		examVo.setTcmQxz("SX0088_3");
		//阳虚质 SX0088
		examVo.setTcmYangxz("SX0088_2");
		//阴虚质 SX0088
		examVo.setTcmYinxz("SX0088_2");
		//痰湿质 SX0088
		examVo.setTcmTsz("SX0088_2");
		//湿热质 SX0088
		examVo.setTcmSrz("SX0088_2");
		//血瘀质 SX0088
		examVo.setTcmXyz("SX0088_2");
		//气郁质 SX0088
		examVo.setTcmQyz("SX0088_1");
		//特秉质 SX0088
		examVo.setTcmTbz("SX0088_2");
		//脑血管疾病 SX0023
		examVo.setCerebrovascularDisease("SX0023_1");
		//其它脑血管疾病
		examVo.setCerebrovascularDiseaseOther("");
		//肾脏疾病 SX0024
		examVo.setKidneyDisease("SX0024_5");
		//其它肾脏疾病
		examVo.setKidneyDiseaseOther("尿毒症");
		//心脏疾病 SX0025
		examVo.setHeartDisease("SX0025_6");
		//其它心脏疾病
		examVo.setHeartDiseaseOther("");
		//血管疾病 SX0026
		examVo.setVascularDisease("SX0026_1");
		//其它血管疾病
		examVo.setVascularDiseaseOther("");
		//眼部疾病 SX0027
		examVo.setOcularDiseases("SX0027_4");
		//其它眼部疾病
		examVo.setOcularDiseasesOther("");
		//神经系统疾病 SX0090
		examVo.setNervousSystemDisease("SX0090_1");
		//神经系统疾病说明
		examVo.setNervousDiseaseMemo("");
		//有无其他系统疾病 SX0090
		examVo.setOtherDisease("SX0090_1");
		examVo.setOtherDiseaseMemo("");
		//体检有无异常 SX0087
		examVo.setHealthEvaluation("SX0087_1");
		examVo.setAbnormal1("血压偏高"); 
		examVo.setAbnormal2("心电异常"); 
		examVo.setAbnormal3("血常规异常");
		examVo.setAbnormal4("");
		// 健康指导 SX0029
		examVo.setHealthGuidance("SX0029_1");
		//危险因素控制 SX0030
		examVo.setDangerControlling("SX0030_3");
		//减体重目标
		examVo.setTargetWeight("48");
		//建议接种疫苗
		examVo.setAdviseBacterin("");
		//其它危险因素控制
		examVo.setDangerControllingOther("清淡饮食，低脂低糖低盐");
		//健康建议
		examVo.setHealthAdvice("注意饮食调节,保持足够睡眠");
		// 录入机构
		examVo.setCreateOrg("61990011X1009");
		
		Examination exam = ConvertObject.convertExam(examVo);
		list.add(exam);
		
		
		HospitalizedVo hospVo = new HospitalizedVo();
		//设置Id
		String inprecordName = "EHR_Arch_Inprecord";
		IdTest idTest2 = new IdTest();
		String inprecordId = idTest2.getId(inprecordName, areaCode, duns, token, userId, compId);
		if(!StringUtil.isEmpty(inprecordId)) {
			hospVo.setId(inprecordId);
		}
		
		hospVo.setArchiveNo("");
		hospVo.setIdNumber("131182199104265014");
		hospVo.setServiceName("SX0069_3");
		hospVo.setExamId(healthCheckId);
		hospVo.setInHospitalTime("2019-04-24");
		hospVo.setLeaveHospitalTime("2019-02-22");
		hospVo.setReason("腹痛");
		hospVo.setHospitalOrgan("陕西人民医院");
		hospVo.setCaseCode("001");
		hospVo.setRemark("注意饮食");
		hospVo.setCreateOrg("610000000000466");
		
		Hospitalized h = ConvertObject.convertToHospitalized(hospVo);
		//list.add(h);
		
		
		
		HospitalizedVo famVo = new HospitalizedVo();
		//设置Id
		String homebedName = "EHR_Arch_Homebed";
		IdTest idTest3 = new IdTest();
		String homebedId = idTest3.getId(homebedName, areaCode, duns, token, userId, compId);
		if(!StringUtil.isEmpty(homebedId)) {
			famVo.setId(homebedId);
		}
		
		famVo.setArchiveNo("");
		famVo.setIdNumber("131182199104265014");
		famVo.setServiceName("SX0069_3");
		famVo.setExamId(healthCheckId);
		famVo.setInHospitalTime("2019-04-24");
		famVo.setLeaveHospitalTime("2019-02-22");
		famVo.setReason("头痛");
		famVo.setHospitalOrgan("西安第一医院");
		famVo.setCaseCode("023");
		famVo.setRemark("注意睡眠");
		famVo.setCreateOrg("610000000000466");
		
		FamilyPractice fam = ConvertObject.convertToFamilyPractice(famVo);		
		//list.add(fam);
		
		
		
		TakeMedicineVo takeVo = new TakeMedicineVo();
		//设置Id
		String druguseName = "EHR_Arch_Druguse";
		IdTest idTest4 = new IdTest();
		String druguseId = idTest4.getId(druguseName, areaCode, duns, token, userId, compId);
		if(!StringUtil.isEmpty(druguseId)) {
			takeVo.setId(druguseId);
		}
	
		
		takeVo.setArchiveNo("");
		takeVo.setIdNumber("131182199104265014");
		takeVo.setServiceName("SX0069_3");
		takeVo.setExamId(healthCheckId);
		takeVo.setMedicineType("CV5301.06_100");
		takeVo.setMedicineName("阿莫西林");
		takeVo.setMedicineUsage("一日一次");
		takeVo.setFrequency("SX0153_10");
		takeVo.setMedicineDosage("");
		takeVo.setUnit("SX0154_5");
		takeVo.setMedicineTime("2");
		takeVo.setMedicineTimeUnit("CV4202.05_2");
		takeVo.setMedicineCompliance("SX0028_1");
		takeVo.setOther("");
		takeVo.setCreateOrg("610000000000466");
		
		TakeMedicineCondition take = ConvertObject.convertToTakeMedicine(takeVo);
		//list.add(take);
		
		VaccinationVo vaccVo = new VaccinationVo();
		//设置Id
		String inocNoteName = "EHR_Immu_InocNote";
		IdTest idTest5 = new IdTest();
		String inocNoteId = idTest5.getId(inocNoteName, areaCode, duns, token, userId, compId);
		if(!StringUtil.isEmpty(inocNoteId)) {
			vaccVo.setId(inocNoteId);
		}
		
		vaccVo.setArchiveNo("");
		vaccVo.setIdNumber("131182199104265014");
		vaccVo.setServiceName("SX0030_6");
		vaccVo.setExamId(healthCheckId);
		vaccVo.setCardId("131182199104265014");
		vaccVo.setVaccinationType("SX0190_1");
		vaccVo.setVaccinationId("CV08.50.001_02");
		vaccVo.setVaccinationName("结合疫苗");
		vaccVo.setAcuscount("1");
		vaccVo.setDose("2");
		vaccVo.setDescnption("一次两支");
		vaccVo.setInocuState("SX0313_2");//未接种
		vaccVo.setSinocuDate("2019-04-24");
		vaccVo.setInocuDoctor("131182189005021635");
		vaccVo.setRegisterPerson("131182189005021635");
		vaccVo.setVaccinationTime("2019-02-01");
		vaccVo.setDzjgm("123");
		vaccVo.setBatchNumber("01020326541");
		vaccVo.setCounty("SX0131_3");
		vaccVo.setInoculationSite("SX0504_1");
		vaccVo.setInoculationWay("SX0507_1");
		vaccVo.setVaccinationOrgan("61990011X1009");
		vaccVo.setVaccinationOrganName("接种医院");
		vaccVo.setRemark("正常");
		vaccVo.setValiddate("2019-02-25");
		vaccVo.setManufacturer("重庆药厂");
		vaccVo.setManufactCode("610000000000466");
		vaccVo.setInputDate("2019-02-25");
		vaccVo.setVaccinationOrganName("61990011X1009");
		
		Vaccination vacc = ConvertObject.convertToVaccination(vaccVo);
		//list.add(vacc);
		
		
		DangerDiseaseVo dangerVo = new DangerDiseaseVo();
		//设置Id
		String dangerName = "EHR_Arch_Danger";
		IdTest idTest6 = new IdTest();
		String dangerId = idTest6.getId(dangerName, areaCode, duns, token, userId, compId);
		if(!StringUtil.isEmpty(dangerId)) {
			dangerVo.setId(dangerId);
		}
		
		dangerVo.setArchiveId("131182199104265011");
		dangerVo.setServiceName("SX0069_3");//
		dangerVo.setServiceId(healthCheckId);
		dangerVo.setPoisonType("SX0013_1");
		dangerVo.setFenseContent("颗粒状");
		dangerVo.setHasfense("SX0014_0");
		dangerVo.setPoisonContent("访粉尘面具");
		dangerVo.setRemark("备注说明");
		dangerVo.setDuns("61990011X1009");
		
		DangerDisease dangerDisease = ConvertObject.convertToDangerDisease(dangerVo);
		list.add(dangerDisease);
		
		
		data.setBody(list);
		
		
		//String reqXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><businessdata><header><functioncode>CHECK_1001</functioncode><errCode>0</errCode><errMsg></errMsg><cmd>insert</cmd></header><body><![CDATA[<ObjectInstance name=\"EHR_Arch_HealthCheck\" id=\"201905076101020000023_U\"><Attribute name=\"checkFlag\">SX0356_2</Attribute><Attribute name=\"archiveId\">131182199104265014</Attribute><Attribute name=\"checkdate\">2019-04-11</Attribute><Attribute name=\"dutydoctor\">李淑芬</Attribute><Attribute name=\"symptom\">CV5101.27_12</Attribute><Attribute name=\"symptom_other\">心惊</Attribute><Attribute name=\"heat\">36</Attribute><Attribute name=\"cardiotach_ometer\">56</Attribute><Attribute name=\"breath_count\">16</Attribute><Attribute name=\"leftdbp\">79</Attribute><Attribute name=\"leftsbp\">148</Attribute><Attribute name=\"rightdbp\">83</Attribute><Attribute name=\"rightsbp\">146</Attribute><Attribute name=\"height\">158</Attribute><Attribute name=\"weight\">53.6</Attribute><Attribute name=\"waistline\">91</Attribute><Attribute name=\"bmi\">22.78</Attribute><Attribute name=\"healthstate\">SX0009_2</Attribute><Attribute name=\"livingstate\">SX0010_1</Attribute><Attribute name=\"assessId\"></Attribute><Attribute name=\"oldkown\">SX0078_1</Attribute><Attribute name=\"oldkown_fee\"></Attribute><Attribute name=\"oldfeeling\">SX0078_1</Attribute><Attribute name=\"oldfeeling_fee\"></Attribute><Attribute name=\"exercise_frequency\">CV5101.28_1</Attribute><Attribute name=\"exercise_timeslice\">50</Attribute><Attribute name=\"persisttime\">5</Attribute><Attribute name=\"exercise_method\">跑步</Attribute><Attribute name=\"eat_habit\">CV5101.29_2</Attribute><Attribute name=\"smoke_frequency\">SX0079_3</Attribute><Attribute name=\"smoke_count_day\">10</Attribute><Attribute name=\"smoke_start_age\">35</Attribute><Attribute name=\"smoke_end_age\"></Attribute><Attribute name=\"wine_frequency\">SX0080_3</Attribute><Attribute name=\"wine_count\">2</Attribute><Attribute name=\"wine_refrain\">SX0081_1</Attribute><Attribute name=\"wine_refrain_age\"></Attribute><Attribute name=\"wine_start_age\">21</Attribute><Attribute name=\"isstoned\">SX0083_1</Attribute><Attribute name=\"wine_type\">CV5305.02_2</Attribute><Attribute name=\"wine_other\">伏特加</Attribute><Attribute name=\"undress\">SX0087_1</Attribute><Attribute name=\"undress_work\">挖煤工</Attribute><Attribute name=\"undress_worktime\">10</Attribute><Attribute name=\"lip\">CV5102.12_1</Attribute><Attribute name=\"tooth\">CV5102.13_2</Attribute><Attribute name=\"toothless_top\">1</Attribute><Attribute name=\"toothless_down\">2</Attribute><Attribute name=\"toothless_left\">3</Attribute><Attribute name=\"toothless_right\">4</Attribute><Attribute name=\"decayedtooth_top\">3</Attribute><Attribute name=\"decayedtooth_down\">1</Attribute><Attribute name=\"decayedtooth_left\">4</Attribute><Attribute name=\"decayedtooth_right\">2</Attribute><Attribute name=\"falsetooth_top\"></Attribute><Attribute name=\"falsetooth_down\">3</Attribute><Attribute name=\"falsetooth_left\">1</Attribute><Attribute name=\"falsetooth_right\">5</Attribute><Attribute name=\"yanbu\">SX0015_1</Attribute><Attribute name=\"eye_nakedness_left\">0.7</Attribute><Attribute name=\"eye_nakedness_right\">0.8</Attribute><Attribute name=\"eye_remedy_left\">1.1</Attribute><Attribute name=\"eye_remedy_right\">1.2</Attribute><Attribute name=\"audition\">SX0016_1</Attribute><Attribute name=\"sport_fun\">SX0017_1</Attribute><Attribute name=\"fundus\">SX0084_2</Attribute><Attribute name=\"fundus_other\">有血丝</Attribute><Attribute name=\"skin\">CV5102.11_9</Attribute><Attribute name=\"skin_other\">发暗</Attribute><Attribute name=\"sclera\">SX0089_3</Attribute><Attribute name=\"sclera_other\">SX0089_1</Attribute><Attribute name=\"lymph\">CV5102.17_1</Attribute><Attribute name=\"lymph_other\">CV5102.17_1</Attribute><Attribute name=\"barrel_chest\">SX0083_2</Attribute><Attribute name=\"breathing\">SX0084_2</Attribute><Attribute name=\"breathing_other\">CV5102.03_1</Attribute><Attribute name=\"rales\">SX0018_2</Attribute><Attribute name=\"rales_other\">SX0018_1</Attribute><Attribute name=\"heart_rate\">56</Attribute><Attribute name=\"rhythm\">SX0019_1</Attribute><Attribute name=\"noise\">SX0087_1</Attribute><Attribute name=\"noise_memo\">有杂音</Attribute><Attribute name=\"tenderness\">SX0087_1</Attribute><Attribute name=\"tenderness_memo\">有压痛</Attribute><Attribute name=\"mass\">SX0087_1</Attribute><Attribute name=\"mass_memo\">有包块</Attribute><Attribute name=\"liver\">SX0087_1</Attribute><Attribute name=\"liver_memo\">有肝大</Attribute><Attribute name=\"spleen\">SX0087_1</Attribute><Attribute name=\"spleen_memo\">有脾大</Attribute><Attribute name=\"dullness\">SX0087_2</Attribute><Attribute name=\"dullness_memo\">SX0087_1</Attribute><Attribute name=\"edema\">CV5102.18_1</Attribute><Attribute name=\"dorsal\">SX0020_1</Attribute><Attribute name=\"dre\">SX0021_5</Attribute><Attribute name=\"dre_memo\">肛门其他</Attribute><Attribute name=\"breast\">CV5102.03_1</Attribute><Attribute name=\"breast_memo\">CV5102.03_1</Attribute><Attribute name=\"vulva\">SX0086_1</Attribute><Attribute name=\"vulva_memo\"></Attribute><Attribute name=\"vaginal\">SX0086_1</Attribute><Attribute name=\"vaginal_memo\"></Attribute><Attribute name=\"cervixed\">SX0086_1</Attribute><Attribute name=\"cervix_memo\"></Attribute><Attribute name=\"palace\">SX0086_1</Attribute><Attribute name=\"palace_memo\"></Attribute><Attribute name=\"attachment\">SX0086_1</Attribute><Attribute name=\"attachment_memo\"></Attribute><Attribute name=\"examination_memo\">其他查体</Attribute><Attribute name=\"hemoglobined\">144</Attribute><Attribute name=\"leukocyte\">6.7</Attribute><Attribute name=\"platelet\">273</Attribute><Attribute name=\"blood_memo\">血常规其他</Attribute><Attribute name=\"urinary_protein\">SX0186_2</Attribute><Attribute name=\"urine\">SX0186_1</Attribute><Attribute name=\"ketone\">SX0186_3</Attribute><Attribute name=\"occult_blood\">SX0186_4</Attribute><Attribute name=\"urine_memo\">尿常规其他</Attribute><Attribute name=\"bsugar_mmo\">4.52</Attribute><Attribute name=\"bsugar_mg\"></Attribute><Attribute name=\"ecg\">SX0084_2</Attribute><Attribute name=\"ecg_memo\">窦性心动过缓</Attribute><Attribute name=\"urinary_albumin\">2.45</Attribute><Attribute name=\"occult_blooded\">SX0085_1</Attribute><Attribute name=\"hemoglobin\">4.8</Attribute><Attribute name=\"hbeag\">SX0085_1</Attribute><Attribute name=\"alt\">16.9</Attribute><Attribute name=\"ast\">26.4</Attribute><Attribute name=\"albumin\">42</Attribute><Attribute name=\"bilirubin_total\">8.73</Attribute><Attribute name=\"bilirubin_combine\">4.6</Attribute><Attribute name=\"scr\">95.1</Attribute><Attribute name=\"bun\">7.15</Attribute><Attribute name=\"potassium\">4.1</Attribute><Attribute name=\"serum_sodium\">138</Attribute><Attribute name=\"cholesterol\">5.65</Attribute><Attribute name=\"triglycerides\">5.04</Attribute><Attribute name=\"h_cholesterol\">3.26</Attribute><Attribute name=\"l_cholesterol\">2.59</Attribute><Attribute name=\"xray\">SX0084_1</Attribute><Attribute name=\"xray_memo\"></Attribute><Attribute name=\"bultrasound\">SX0084_2</Attribute><Attribute name=\"bultrasound_memo\">慢性胆囊炎</Attribute><Attribute name=\"bsound\">SX0084_1</Attribute><Attribute name=\"bsound_memo\"></Attribute><Attribute name=\"cervix\">SX0084_1</Attribute><Attribute name=\"cervix_Explain\"></Attribute><Attribute name=\"check_other\">其它辅助检查</Attribute><Attribute name=\"physique_phz\">SX0088_2</Attribute><Attribute name=\"physique_qxz\">SX0088_3</Attribute><Attribute name=\"physique_yangxz\">SX0088_2</Attribute><Attribute name=\"physique_yinxz\">SX0088_2</Attribute><Attribute name=\"physique_tsz\">SX0088_2</Attribute><Attribute name=\"physique_srz\">SX0088_2</Attribute><Attribute name=\"physique_xyz\">SX0088_2</Attribute><Attribute name=\"physique_qyz\">SX0088_1</Attribute><Attribute name=\"physique_tbz\">SX0088_2</Attribute><Attribute name=\"cerebrovascular\">SX0023_1</Attribute><Attribute name=\"cerebrovascular_memo\"></Attribute><Attribute name=\"kidney\">SX0024_5</Attribute><Attribute name=\"kidney_other\">尿毒症</Attribute><Attribute name=\"heartdis\">SX0025_6</Attribute><Attribute name=\"heartdis_other\"></Attribute><Attribute name=\"blooddis\">SX0026_1</Attribute><Attribute name=\"blooddis_other\"></Attribute><Attribute name=\"eysdis\">SX0027_4</Attribute><Attribute name=\"eysdis_other\"></Attribute><Attribute name=\"nervousdis\">SX0090_1</Attribute><Attribute name=\"nervousdis_memo\"></Attribute><Attribute name=\"hasotherdis\">SX0090_1</Attribute><Attribute name=\"otherdismemo\"></Attribute><Attribute name=\"checkresult\">SX0087_1</Attribute><Attribute name=\"healthesti\">血压偏高心电异常血常规异常</Attribute><Attribute name=\"healthguide\">SX0029_1</Attribute><Attribute name=\"dangercontrol\">SX0030_3</Attribute><Attribute name=\"weighttarget\">48</Attribute><Attribute name=\"advisebacterin\"></Attribute><Attribute name=\"otherdanger\">清淡饮食，低脂低糖低盐</Attribute><Attribute name=\"healthadvice\">注意饮食调节,保持足够睡眠</Attribute><Attribute name=\"duns\">61990011X1009</Attribute></ObjectInstance>]]></body></businessdata>";
		String reqXml = XmlUtils.modelToStringXML(data);
		reqXml = reqXml.replace("<body>", "<body><![CDATA[");
		reqXml = reqXml.replace("</body>", "]]></body>");
		System.out.println(reqXml);
		
		String verifyCode = "123456";	
		
		/*String result = "";
		result = HttpUtils.send(areaCode, duns, token, userId, "CHECK_1001",verifyCode, reqXml);
		System.out.println("result=" + result);*/
		
		
		String url = Config.shanxiUrl; 
		String param = "areaCode="+areaCode+"&duns="+duns+"&token="+token+"&userId="+userId +
		"&functionCode=" + "CHECK_1001" + "&verifyCode=" + verifyCode +"&userType=1&compId=" + compId + "&reqXml=" + reqXml;
		
		//String param="areaCode=123&userId=123&functionCode="+"CHECK_1001"+"&duns="+duns+"&token="+token+"&reqXml="+reqXml;
		//String param="areaCode="+areaCode+"&userId="+userId+"&functionCode="+"CHECK_1001"+"&duns="+duns+"&token="+token+"&verifyCode=" + verifyCode+"&reqXml="+reqXml;
		System.out.println(url);
		System.out.println(param);
		
		String result = TestPost.sendPost(url, param, 300, 300);
		System.out.println(result);
		
		
		if(!"".equals(result)){
			Object r = XmlUtils.xmlToBean(result, ResponseXml.class);
			if(r != null){
				ResponseXml x = (ResponseXml)r;
				System.out.println("functionCode =" + x.getHeader().getFunctionCode());
				System.out.println("errcode =" + x.getHeader().getErrCode());
				System.out.println("msg =" + x.getHeader().getErrMsg());
				System.out.println("total =" + x.getBody().getRows_total());
				System.out.println("suc =" + x.getBody().getRows_suc());
				System.out.println("fail =" + x.getBody().getRows_faild());
				System.out.println("memo =" + x.getBody().getMemo());
				List<ResponseError> ll = x.getBody().getError();
				if(ll != null){
					for(int i = 0; i < ll.size(); i++){
						System.out.println(ll.get(i).getTypeId());
						System.out.println(ll.get(i).getInstanceId());
						System.out.println(ll.get(i).getErrorDesc());
					}
				}
			}
		}
		
	}
}
