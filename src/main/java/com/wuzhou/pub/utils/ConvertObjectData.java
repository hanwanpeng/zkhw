package com.wuzhou.pub.utils;

import java.math.BigDecimal;

import com.github.pagehelper.util.StringUtil;
import com.wuzhou.pub.entity.ElderSelfcareAbility;
import com.wuzhou.pub.entity.ElderTcmHealth;
import com.wuzhou.pub.entity.HealthExam;
import com.wuzhou.pub.entity.HealthExamDrug;
import com.wuzhou.pub.entity.HealthExamInhos;
import com.wuzhou.pub.entity.HealthExamNoplanvacc;
import com.zkhw.framework.utils.DateUtil;
import com.zkhw.framework.utils.NumberUtils;
import com.zkhw.pub.entity.ElderlySelfcareEstimate;
import com.zkhw.pub.entity.ElderlyTcmRecord;
import com.zkhw.pub.entity.HospitalizedRecord;
import com.zkhw.pub.entity.PhysicalExamination;
import com.zkhw.pub.entity.ResidentBaseInfo;
import com.zkhw.pub.entity.TakeMedicineRecord;
import com.zkhw.pub.entity.VaccinationRecord;

public class ConvertObjectData {

	public static HealthExam convertToHealthExam(PhysicalExamination exam,ResidentBaseInfo base){
		
		HealthExam health = new HealthExam();
		
		//个人健康体检ID
		health.setHealthExamId(exam.getId());
		//个人档案ID
		health.setPersonInfoId(base.getId());
		//录入机构ID
		health.setCreateOrgId(exam.getCreateOrg());
		//录入机构名称
		health.setOrgName(exam.getCreateOrgName());
		//录入人ID
		health.setCreatorId(exam.getCreateUser());
		//录入人姓名
		health.setCreator(exam.getCreateName());
		//录入时间
		health.setCreateTime(exam.getCreateTime());
		//最后更新机构ID
		health.setModifiedOrgId(null);
		//最后更新机构名称
		health.setModifiedOrgName(null);
		//最后更新人ID
		health.setModifierId(exam.getUpdateUser());
		//最后更新人姓名
		health.setModifier(exam.getUpdateName());
		//最后更新时间
		health.setModifiedTime(exam.getUpdateTime());
		//姓名
		health.setName(exam.getName());
		//体检日期
		health.setHealthExamDate(DateUtil.getDate(exam.getCheckDate(), "yyyy-MM-dd"));
		//卫生服务机构ID
		health.setOrgId(exam.getCreateOrg());
		//居民分组
		health.setPersonGroup(null);
		//癌胚抗原浓度值(μg/L)
		health.setCea(null);
		//白蛋白浓度(g/L)
		BigDecimal alb = new BigDecimal(exam.getAlbumin());
		health.setAlb(alb);
		//白细胞计数值（G/L)
		BigDecimal wbc = new BigDecimal(exam.getBloodLeukocyte());
		health.setWbc(wbc);
		//餐后2小时血糖值（mg/dL)
		//BigDecimal pbgMg = new BigDecimal(exam.getBloodGlucoseMg());
		health.setPbgMg(null);
		//餐后2小时血糖值（mmol/L)
		//BigDecimal pbgMmol = new BigDecimal(exam.getBloodGlucoseMmol());
		health.setPbgMmol(null);	
		//齿列类别代码
		String tooth = exam.getOrganTooth();
		if(StringUtil.isNotEmpty(tooth)){
			if("1".equals(tooth)){
				health.setDentitionTypeCode("1");
			}else{
				health.setDentitionTypeCode("0");
			}
		}
		
		//传入数字标识“0”
		health.setIsApply(Short.parseShort("0"));
		//传入数字标识“5”
		health.setSourceType(Short.parseShort("5"));
		//传入数字标识“8”
		health.setIsAppCreate(Short.parseShort("8"));
		//大便潜血标志
		health.setFobCode(exam.getFob());
		//毒物（放射物质）
		health.setPoisonRadiogen(null);
		//毒物（放射物质）防护措施标志
		health.setPoisonRadiogenProtectCode(exam.getLifewayHazardousRadiation());
		//毒物（放射物质）防护措施中文
		health.setPoisonRadiogenProtectValue(exam.getLifewayRadiationPreventive());
		//毒物（粉尘）
		health.setPoisonDust(null);
		//毒物（粉尘）防护措施标志
		health.setPoisonDustProtectCode(exam.getLifewayHazardousDust());
		//毒物（粉尘）防护措施中文
		health.setPoisonDustProtectValue(exam.getLifewayDustPreventive());
		//毒物（化学物质）
		health.setPoisonChemical(null);
		//毒物（化学物质）防护措施标志
		health.setPoisonChemicalProtectCode(exam.getLifewayHazardousChemical());
		//毒物（化学物质）防护措施中文
		health.setPoisonChemicalProtectValue(exam.getLifewayChemicalPreventive());
		//毒物（其他）
		health.setPoisonOthers(null);
		//毒物（其他）防护措施标志
		health.setPoisonOthersProtectCode(exam.getLifewayHazardousOther());
		//毒物（其他）防护措施中文
		health.setPoisonOthersProtectValue(exam.getLifewayOtherPreventive());
		//毒物（物理因素）
		health.setPoisonPhysical(null);
		//毒物（物理因素）防护措施标志
		health.setPoisonPhysicalProtectCode(exam.getLifewayHazardousPhysical());
		//毒物（物理因素）防护措施中文
		health.setPoisonPhysicalProtectValue(exam.getLifewayPhysicalPreventive());
		//锻炼方式
		health.setExerciseWay(exam.getLifewayExerciseType());
		//锻炼频率代码
		health.setExerciseFreqCode(exam.getLifewayExerciseFrequency());
		//肺部呼吸音代码
		health.setLungSoundCode(exam.getExaminationBreathSounds());
		//肺部呼吸音异常描述
		health.setLungSoundAbnormDesc(exam.getExaminationBreathOther());
		//肺部罗音标志
		health.setLungRaleCode(exam.getExaminationRale());
		//肺部罗音其他描述
		health.setLungRaleOthersDesc(exam.getExaminationRaleOther());
		//肺结核患者体检标识1是0否
		health.setIsTuberculosis(base.getIsTuberculosis() == null? null:base.getIsTuberculosis().shortValue());
		//附件异常标志
		health.setAdnexaCode(exam.getExaminationWomanAccessories());
		//附件异常描述
		health.setAdnexaAbnormDesc(exam.getExaminationAccessoriesMemo());
		//腹部B超检查异常描述
		health.setBscanAbdomenAbnormDesc(exam.getUltrasoundMemo());
		//腹部B超检査异常标志
		health.setBscanAbdomenCode(exam.getUltrasoundAbdomen());
		//腹部包块代码
		health.setAbdominalMassCode(exam.getExaminationAbdomenMass());
		//腹部包块描述
		health.setHasAbdominalMassDesc(exam.getExaminationMassMemo());
		//腹部压痛代码
		health.setAbdominalTendCode(exam.getExaminationAbdomenTenderness());
		//腹部压痛描述
		health.setHasAbdominalTendDesc(exam.getExaminationTendernessMemo());
		//腹部移动性浊音代码
		health.setAbdominalDullnessCode(exam.getExaminationAbdomenShiftingdullness());
		//腹部移动性浊音描述
		health.setHasAbdominalDullnessDesc(exam.getExaminationShiftingdullnessMemo());
		//甘油三酯值（mmol/L)
		BigDecimal tg = new BigDecimal(exam.getTg());
		health.setTg(tg);
		//肝大代码
		health.setHepatauxeCode(exam.getExaminationAbdomenHepatomegaly());
		//肝大描述
		health.setHasHepatauxeDesc(exam.getExaminationHepatomegalyMemo());
		//肛门指诊检查结果类别代码
		health.setDreCode(exam.getExaminationAnus());
		//肛门指诊其他描述
		health.setDreOthersDesc(exam.getExaminationAnusOther());
		//高血压体检标识1是0否
		health.setIsHyper(base.getIsHypertension() == null?null:base.getIsHypertension().shortValue());
		//宫颈涂片异常标志
		health.setCpsCode(exam.getCervicalSmear());
		//宫颈涂片异常描述
		health.setCpsAbnormDesc(exam.getCervicalSmearMemo());
		//宫颈异常标志
		health.setCervixCode(exam.getExaminationWomanCervix());
		//宫颈异常描述
		health.setCervixAbnormDesc(exam.getExaminationCervixMemo());
		//宫体异常标志
		health.setCorpusuteriCode(exam.getExaminationWomanCorpus());
		//宫体异常描述
		health.setCorpusuteriAbnormDesc(exam.getExaminationCorpusMemo());
		//巩膜检査结果代码
		health.setScleralCode(exam.getExaminationSclera());
		//巩膜检査结果其他描述
		health.setScleralOthersDesc(exam.getExaminationScleraOther());
		//冠心病体检标识1是0否
		health.setIsChd(null);
		//国家规范版本号，传入字符“2017”
		health.setStandard("2017");
		//呼吸频率（次/min)
		health.setBreathingRate(exam.getBaseRespiratory()==null?null:Short.parseShort(exam.getBaseRespiratory()));
		//坚持锻炼时间（年）
		BigDecimal exerciseYear = new BigDecimal(exam.getLifewayExerciseYear());
		health.setExerciseYear(exerciseYear);
		//健康评价异常标志
		health.setHealthAbnormCode(exam.getHealthEvaluation());
		//健康评价异常描述1
		health.setHealthAbnormDesc1(exam.getAbnormal1());		
		health.setHealthAbnormDesc2(exam.getAbnormal2());
		health.setHealthAbnormDesc3(exam.getAbnormal3());
		health.setHealthAbnormDesc4(exam.getAbnormal4());
		health.setHealthAbnormDesc5(null);
		health.setHealthAbnormDesc6(null);
		//健康体检表编号
		health.setHealthExamNo(null);
		//健康指导代码
		String guidance = exam.getHealthGuidance();
		if(StringUtil.isNotEmpty(guidance)){
			health.setHealthGuidanceCode(exam.getHealthGuidance().replaceAll(",", "#"));
			String[] s = guidance.split(",");
			String healthGuidanceValue = "";
			for(int i = 0; i < s.length; i++){
				if(StringUtil.isNotEmpty(s[i])){
					healthGuidanceValue = healthGuidanceValue + CodeToValue.guidanceConvert(s[i]) + "#";		
				}
			}
			healthGuidanceValue.substring(0, healthGuidanceValue.length() - 1);
			//健康指导中文
			health.setHealthGuidanceValue(healthGuidanceValue);
		}
		//结合胆红素值(μmol/L)
		BigDecimal dbil = new BigDecimal(exam.getConjugatedBilirubin());
		health.setDbil(dbil);
		//戒酒标志
		health.setStopDrinkingCode(exam.getLifewayDrinkStop());
		//戒酒年龄（岁）
		health.setStopDrinkingAge(NumberUtils.convertToShort(exam.getLifewayDrinkStopage()));
		//戒烟年龄（岁）
		health.setStopSmokingAge(NumberUtils.convertToShort(exam.getLifewaySmokeEndage()));
		//精神病体检标识1是0否
		health.setIsSmi(base.getIsPsychosis() == null?null:base.getIsPsychosis().shortValue());
		//精神系统疾病代码
		health.setDiseNervousCode(exam.getNervousSystemDisease());
		//精神系统疾病描述
		health.setDiseNervousAbnormDesc(exam.getNervousDiseaseMemo());
		//开始吸烟年龄（岁）
		health.setStartSmokingAge(NumberUtils.convertToShort(exam.getLifewaySmokeStartage()));
		//开始饮酒年龄（岁）
		health.setStartDrinkingAge(NumberUtils.convertToShort(exam.getLifewayDrinkStartage()));
		//空腹血糖值（mg/dL)
		BigDecimal fbgMg = new BigDecimal(exam.getBloodGlucoseMg());
		health.setFbgMg(fbgMg);
		//空腹血糖值（mmol/L)
		BigDecimal fbgMmol = new BigDecimal(exam.getBloodGlucoseMmol());
		health.setFbgMmol(fbgMmol);
		//口唇外观检査结果代码
		health.setLipExamResultCode(exam.getOrganLips());
		//老年人健康状态自我评估代码
		health.setElderHealthAssessCode(exam.getBaseHealthEstimate());
		//老年人情感状态粗筛结果代码
		health.setElderEmotionalResultCode(exam.getBaseFeelingEstimate());		
		//老年人认知功能粗筛结果代码
		health.setElderCognitionResultCode(exam.getBaseCognitionEstimate());
		//老年人认知功能量表ID，有老年人认知功能量表的填此标识。
		//health.setElderCognitionId(elderCognitionId);
		//老年人认知功能评分
		health.setElderBrainScore(NumberUtils.convertToShort(exam.getBaseCognitionScore()));
		//老年人生活自理能力自我评估代码
		health.setElderSelfCareAssessCode(exam.getBaseSelfcareEstimate());
		//老年人体检标识1是0否
		if(base.getAge() >=65){
			health.setIsElder(Short.valueOf("1"));
		}else{
			health.setIsElder(Short.valueOf("0"));
		}		
		//老年人抑郁评分
		health.setElderDepressionScore(NumberUtils.convertToShort(exam.getBaseFeelingScore()));
		//老年人中医药健康表ID
		health.setElderTcmHealthId(null);
		//老年人自理能力评估表ID
		health.setElderSelfcareAbilityId(null);
		//老年抑郁量表ID，有老年人抑郁量表的填此标识。
		//health.setElderDepressedId(elderDepressedId);
		//淋巴结检查结果代码
		health.setLymphCode(exam.getExaminationLymph());
		//淋巴结检查结果其他描述
		health.setLymphOthersDesc(exam.getExaminationLymphOther());
		//脉率(次/min)
		health.setPulseRate(NumberUtils.convertToShort(exam.getBaseHeartbeat()));
		//每次锻炼时长（分钟)
		health.setExerciseDurationMins(NumberUtils.convertToShort(exam.getLifewayExerciseTime()));
		//脑血管疾病代码
		health.setDiseBrainVesselCode(exam.getCerebrovascularDisease());
		//脑血管疾病中文
		health.setDiseBrainVesselValue(exam.getCerebrovascularDiseaseOther());
		//脑卒中体检标识1是0否
		health.setIsCa(null);
		//尿比重
		health.setUrineSg(null);
		//尿蛋白定性检测结果代码
		health.setProQualResultCode(exam.getUrineProtein());
		//尿蛋白定量检测值(mg/24h)
		health.setProQuanTestValue(null);
		//尿潜血定性检测结果代码
		health.setUobTestResultCode(exam.getBld());
		//尿潜血定量检测值（mmol/L）
		health.setUobTestResultValue(null);
		//尿糖定性检测结果代码
		health.setGluQualResultCode(exam.getGlycosuria());
		//尿糖定量检测值（mmol/L）
		health.setGluQuanTestValue(null);
		//尿酮体定性检测结果代码
		health.setKetQualResultCode(exam.getUrineAcetoneBodies());
		//尿酮体定量检测值（mmol/L）
		health.setKetQualResultValue(null);
		//尿微量白蛋白（mg/dL)
		BigDecimal urineMalb = new BigDecimal(exam.getMicroalbuminuria());
		health.setUrineMalb(urineMalb);
		//尿液酸碱度
		health.setUrinePh(null);
		//皮肤检查结果代码
		health.setSkinCode(exam.getExaminationSkin());
		//皮肤检查结果其他描述
		health.setSkinOthersDesc(exam.getExaminationSkinOther());
		//脾大代码
		health.setSplenomegalyCode(exam.getExaminationAbdomenSplenomegaly());
		//脾大描述
		health.setHasSplenomegalyDesc(exam.getExaminationSplenomegalyMemo());
		//其他B超检查异常描述
		health.setBscanOthersAbnormDesc(exam.getOtherbMemo());
		//其他B超检査异常标志
		health.setBscanOthersCode(exam.getOtherB());
		//其他查体结果
		health.setOtherHealthExamResult(exam.getExaminationOther());
		//其他辅助检查
		health.setOtherAssistExam(exam.getOther());
		//其他尿常规
		health.setUrineOthers(exam.getUrineOther());
		//其他系统疾病代码
		health.setDiseOthersCode(exam.getOtherDisease());
		//其他系统疾病描述
		health.setDiseOthersAbnormDesc(exam.getOtherDiseaseMemo());
		//其他系统疾病代码
		health.setDiseaseOthersCode(null);
		//其他系统疾病中文
		health.setDiseaseOthersValue(null);
		//其他血常规
		health.setCbcOthers(exam.getBloodOther());
		//区分大小体检1表示是大体检，其他值是小体检，梧州传入“1”
		health.setIsBigExam(Short.parseShort("1"));
		//龋齿数左下
		health.setDecayedBlToothNum(NumberUtils.convertToLong(exam.getOrganCariesBottomleft()));
		//龋齿数右下
		health.setDecayedBrToothNum(NumberUtils.convertToLong(exam.getOrganCariesBottomright()));
		//龋齿数左上
		health.setDecayedUlToothNum(NumberUtils.convertToLong(exam.getOrganCariesTopleft()));
		//龋齿数右上
		health.setDecayedUrToothNum(NumberUtils.convertToLong(exam.getOrganCariesTopright()));
		//缺齿全口
		health.setAllLoseTeeth(null);
		//缺齿数左下
		health.setLoseBlTeethNum(NumberUtils.convertToLong(exam.getOrganHypodontiaBottomleft()));
		//缺齿数右下
		health.setLoseBrTeethNum(NumberUtils.convertToLong(exam.getOrganHypodontiaBottomright()));
		//缺齿数左上
		health.setLoseUlTeethNum(NumberUtils.convertToLong(exam.getOrganHypodontiaTopleft()));
		//缺齿数右上
		health.setLoseUrTeethNum(NumberUtils.convertToLong(exam.getOrganHypodontiaTopright()));
		//日吸烟量（支）
		BigDecimal dailySmoking = new BigDecimal(exam.getLifewaySmokeNumber());
		health.setDailySmoking(dailySmoking);
		//日饮酒量（两)
		BigDecimal dailyDrinking = new BigDecimal(exam.getLifewayDrinkNumber());
		health.setDailyDrinking(dailyDrinking);		
		//乳腺代码
		String breast = exam.getExaminationBreast();
		if(StringUtil.isNotEmpty(breast)){
			health.setBreastCode(exam.getExaminationBreast().replaceAll(",", "#"));
			String[] s = breast.split(",");
			String breastValue = "";
			for(int i = 0; i < s.length; i++){
				if(StringUtil.isNotEmpty(s[i])){
					if(!"5".equals(s[i])){
						breastValue = breastValue + CodeToValue.breastConvert(s[i]) + "#";
					}else{
						breastValue = breastValue + exam.getExaminationBreastOther() + "#";
					}					
				}
			}
			breastValue.substring(0, breastValue.length() - 1);
			//乳腺中文
			health.setBreastValue(breastValue);
		}		
		//身高（cm)
		BigDecimal height = new BigDecimal(exam.getBaseHeight());
		health.setHeight(height);
		//体重(kg)
		BigDecimal weight = new BigDecimal(exam.getBaseWeight());
		health.setWeight(weight);
		//神经系统疾病代码
		health.setNerveOtherDiseaseCode(null);
		//神经系统疾病中文
		health.setNerveOtherDiseaseValue(null);
		//肾脏疾病代码
		health.setDiseKidneyCode(exam.getKidneyDisease());
		//肾脏疾病中文
		health.setDiseKidneyValue(exam.getKidneyDiseaseOther());
		//是否0~6岁儿童
		health.setIsChild(null);
		//是否龋齿代码值
		health.setIsDecayedTooth(NumberUtils.convertToShort(exam.getOrganCaries()));
		//是否缺齿代码值
		health.setIsLosetTeeth(NumberUtils.convertToShort(exam.getOrganHypodontia()));
		//是否义齿代码值
		health.setIsFalseTeeth(NumberUtils.convertToShort(exam.getOrganDenture()));
		//是否孕产妇
		health.setIsMaternal(null);
		//糖化血红蛋白值（％)
		BigDecimal ghb = new BigDecimal(exam.getGlycosylatedHemoglobin());
		health.setGhb(ghb);
		//糖尿病体检标识1是0否
		health.setIsDiabetes(base.getIsDiabetes() == null?null:base.getIsDiabetes().shortValue());
		//体温（℃)
		BigDecimal bodyTemperature = new BigDecimal(exam.getBaseTemperature());
		health.setBodyTemperature(bodyTemperature);
		//体质指数
		BigDecimal bmi = new BigDecimal(exam.getBaseBmi());
		health.setBmi(bmi);
		//听力检测结果代码
		health.setHearingCode(exam.getOrganHearing());
		//同型半胱氨酸umol/L
		health.setHomocysteine(null);
		//桶状胸代码
		health.setBarrelChestCode(exam.getExaminationBarrelChest());
		//外阴异常标志
		health.setVulvaCode(exam.getExaminationWomanVulva());
		//外阴异常描述
		health.setVulvaAbnormDesc(exam.getExaminationVulvaMemo());
		//危险因素控制代码
		health.setRiskFactorControlCode(exam.getDangerControlling());
		//危险因素控制中文
		health.setRiskFactorControlValue(exam.getDangerControllingOther());
		//吸烟状况代码
		health.setSmokingStatusCode(exam.getLifewaySmokeStatus());
		//下肢水肿代码
		health.setEoleCode(exam.getExaminationLowerextremityEdema());
		//心电图异常标志
		health.setEcgAbnormCode(exam.getCardiogram());
		//心电图异常描述
		health.setEcgAbnormDesc(exam.getCardiogramMemo());
		//心电图代码
		health.setElectrocardiogramCode(null);		
		//心电图中文
		health.setElectrocardiogramValue(null);
		//心律类别代码
		health.setHeartRhythmTypeCode(exam.getExaminationHeartRhythm());
		//心率(次/min)
		health.setHeartRate(NumberUtils.convertToShort(exam.getExaminationHeartRate()));
		//心脏疾病代码
		health.setDiseHeartCode(exam.getHeartDisease());
		//心脏疾病中文
		health.setDiseHeartValue(exam.getHeartDiseaseOther());
		//心脏杂音代码
		health.setHeartMurmurCode(exam.getExaminationHeartNoise());
		//心脏杂音描述
		health.setHeartMurmurDesc(exam.getExaminationNoiseOther());
		//胸部X线检查异常标志
		health.setXrayChestCode(exam.getChestX());
		//胸部X线检査异常描述
		health.setXrayChestAbnormDesc(exam.getXMemo());
		//血管疾病代码
		health.setDiseBloodVesselCode(exam.getVascularDisease());
		//血管疾病中文
		health.setDiseBloodVesselValue(exam.getVascularDiseaseOther());
		//血红蛋白值(g/L)
		BigDecimal hgb = new BigDecimal(exam.getBloodHemoglobin());
		health.setHgb(hgb);
		//血钾浓度（mmol/L)
		BigDecimal bloodk = new BigDecimal(exam.getBloodK());
		health.setBloodk(bloodk);
		//血钠浓度（mmol/L)
		BigDecimal bloodNa = new BigDecimal(exam.getBloodNa());
		health.setBloodNa(bloodNa);
		//血尿素氮检测值（mmol/L)
		health.setBun(null);
		//血清低密度脂蛋白胆固醇检测值（mmol/L)
		BigDecimal ldlc = new BigDecimal(exam.getLdl());
		health.setLdlc(ldlc);
		//血清谷丙转氨酶值（U/L)
		BigDecimal sgpt = new BigDecimal(exam.getSgft());
		health.setSgpt(sgpt);
		//血清谷草转氨酶值（U/L)
		BigDecimal ast = new BigDecimal(exam.getAst());
		health.setAst(ast);
		//血清肌酐值(μmol/L)
		BigDecimal scr = new BigDecimal(exam.getScr());
		health.setScr(scr);
		//血淸高密度脂蛋白胆固醇检测值(mmol/L)
		BigDecimal hdlc = new BigDecimal(exam.getHdl());
		health.setHdlc(hdlc);
		//血小板计数值(G/L)
		BigDecimal plt = new BigDecimal(exam.getBloodPlatelet());
		health.setPlt(plt);
		//血型：ABO
		health.setAboValue(base.getBloodGroup());
		//血型：RH
		health.setRhValue(base.getBloodRh());
		//咽部检查结果代码
		health.setPharynxExamResultCode(exam.getOrganGuttur());
		//眼部疾病代码
		health.setDiseEyeCode(exam.getOcularDiseases());
		//眼部疾病中文
		health.setDiseEyeValue(exam.getOcularDiseasesOther());
		//眼底检査结果代码
		health.setEyegroundCode(exam.getExaminationEye());
		//眼底检查结果异常描述
		health.setEyegroundAbnormDesc(exam.getExaminationEyeOther());
		//腰围(cm)
		BigDecimal waist = new BigDecimal(exam.getBaseWaist());
		health.setWaist(waist);
		//乙型肝炎病毒e抗体检测结果代码
		health.setHbeabTestResultCode(null);
		//乙型肝炎病毒e抗原检测结果代码
		health.setHbeagTestResultCode(null);
		//乙型肝炎病毒表面抗体检测结果代码
		health.setHbsabTestResultCode(null);
		//乙型肝炎病毒表面抗原检测结果代码
		health.setHbsagTestResultCode(exam.getHb());
		//乙型肝炎病毒核心抗体检测结果代码
		health.setHbcabTestResultCode(null);
		//义齿全口
		health.setAllFalseTeeth(null);
		//义齿数左下
		health.setFalseBlTeethNum(NumberUtils.convertToLong(exam.getOrganDentureBottomleft()));
		//义齿数右下
		health.setFalseBrTeethNum(NumberUtils.convertToLong(exam.getOrganDentureBottomright()));
		//义齿数左上
		health.setFalseUlTeethNum(NumberUtils.convertToLong(exam.getOrganDentureTopleft()));
		//义齿数右上
		health.setFalseUrTeethNum(NumberUtils.convertToLong(exam.getOrganDentureTopright()));
		//阴道异常标志
		health.setVaginaCode(exam.getExaminationWomanVagina());
		//阴道异常描述
		health.setVaginaAbnormDesc(exam.getExaminationVaginaMemo());
		//饮酒频率代码
		health.setDrinkingFreqCode(exam.getLifewayDrinkStatus());		
		//饮酒种类代码
		String drinking = exam.getLifewayDrinkType();
		if(StringUtil.isNotEmpty(drinking)){
			health.setDrinkingTypeCode(exam.getLifewayDrinkType().replaceAll(",", "#"));
			String[] s = drinking.split(",");
			String drinkingTypeValue = "";
			for(int i = 0; i < s.length; i++){
				if(StringUtil.isNotEmpty(s[i])){
					if(!"5".equals(s[i])){
						drinkingTypeValue = drinkingTypeValue + CodeToValue.drinkingConvert(s[i]) + "#";	
					}else{
						drinkingTypeValue = drinkingTypeValue + exam.getLifewayDrinkOther() + "#";
					}	
						
				}
			}
			drinkingTypeValue.substring(0, drinkingTypeValue.length() - 1);
			//饮酒种类中文
			health.setDrinkingTypeValue(drinkingTypeValue);
		}
		//饮食习惯代码
		String eating = exam.getLifewayDiet();
		if(StringUtil.isNotEmpty(eating)){
			health.setEatingHabitCode(exam.getLifewayDiet().replaceAll(",", "#"));
			String[] s = eating.split(",");
			String eatingValue = "";
			for(int i = 0; i < s.length; i++){
				if(StringUtil.isNotEmpty(s[i])){
					eatingValue = eatingValue + CodeToValue.eatingConvert(s[i]) + "#";		
				}
			}
			eatingValue.substring(0, eatingValue.length() - 1);
			//饮食习惯中文
			health.setEatingHabitValue(eatingValue);
		}
		//右侧收缩压（mmHg)
		health.setRdbp(exam.getBaseBloodPressureRightHigh() == null?null:exam.getBaseBloodPressureRightHigh().shortValue());
		//右侧舒张压（mmHg)
		health.setRsbp(exam.getBaseBloodPressureRightLow() == null?null:exam.getBaseBloodPressureRightLow().shortValue());
		//右眼矫正远视力值
		BigDecimal rightCorrectEyesight = new BigDecimal(exam.getOrganCorrectedvisionRight());
		health.setRightCorrectEyesight(rightCorrectEyesight);
		//右眼裸眼远视力值
		BigDecimal rightOriginalEyesight = new BigDecimal(exam.getOrganVisionRight());
		health.setRightOriginalEyesight(rightOriginalEyesight);
		//运动功能状态代
		health.setMovementFunctionCode(exam.getOrganMovement());
		//责任医生ID
		health.setRespDoctorId(base.getDoctorId());
		//责任医师姓名
		health.setRespDoctorName(base.getDoctorName());
		//症状代码
		String symptom = exam.getSymptom();
		if(StringUtil.isNotEmpty(symptom)){
			health.setHealthExamSymptomCode(exam.getSymptom().replaceAll(",", "#"));
			String[] s = symptom.split(",");
			String symptomValue = "";
			for(int i = 0; i < s.length; i++){
				if(StringUtil.isNotEmpty(s[i])){
					if(!"25".equals(s[i])){
						symptomValue = symptomValue + CodeToValue.symptomConvert(s[i]) + "#";
					}else{
						symptomValue = symptomValue + exam.getSymptomOther() + "#";
					}					
				}
			}
			symptomValue.substring(0, symptomValue.length() - 1);
			//症状中文
			health.setHealthExamSymptomValue(symptomValue);
		}
		//职业病危险工种
		health.setOccupExposureWork(exam.getLifewayJob());
		//职业病危险工种从业时间（年）
		health.setOccupExposureWorkYear(NumberUtils.convertToShort(exam.getLifewayJobPeriod()));
		//职业病危险因素标志
		health.setOccupExposureCode(exam.getLifewayOccupationalDisease());
		//总胆固醇值（mmol/L)
		BigDecimal tcho = new BigDecimal(exam.getTc());
		health.setTcho(tcho);
		//总胆红素值（μmol/L)
		BigDecimal tbi = new BigDecimal(exam.getTotalBilirubin());
		health.setTbi(tbi);
		//足背动脉搏动代码
		health.setPofdaCode(exam.getExaminationDorsalArtery());
		//醉酒标志
		health.setDrunkCode(exam.getLifewayDrinkOneyear());
		//左侧收缩压（mmHg)
		health.setLsbp(exam.getBaseBloodPressureLeftHigh() == null?null:exam.getBaseBloodPressureLeftHigh().shortValue());
		//左侧舒张压（mmHg)
		health.setLdbp(exam.getBaseBloodPressureLeftLow() == null?null:exam.getBaseBloodPressureLeftLow().shortValue());		
		//左眼矫正远视力值
		BigDecimal leftCorrectEyesight = new BigDecimal(exam.getOrganCorrectedvisionLeft());
		health.setLeftCorrectEyesight(leftCorrectEyesight);
		//左眼裸眼远视力值
		BigDecimal leftOriginalEyesight = new BigDecimal(exam.getOrganVisionLeft());
		health.setLeftOriginalEyesight(leftOriginalEyesight);
		
		return health;
	}
	
	public static HealthExam addTcmToHealthExam(HealthExam exam,ElderlyTcmRecord record){
		exam.setElderTcmHealthId(record.getId());		
		//中医平和质判定结果代码
		exam.setGentleQualityCode(record.getPinghezhiResult() == null?"":record.getPinghezhiResult().toString());
		//中医气虚质判定结果代码
		exam.setQiDeficiencyCode(record.getQixuzhiResult() == null?"":record.getQixuzhiResult().toString());		
		//中医气郁质判定结果代码
		exam.setQiDepressionCode(record.getQiyuzhiResult() == null?"":record.getQiyuzhiResult().toString());
		//中医湿热质判定结果代码
		exam.setDampHeatCode(record.getShirezhiResult() == null?"":record.getShirezhiResult().toString());
		//中医痰湿质判定结果代码
		exam.setPhlegmWetCode(record.getTanshizhiResult() == null?"":record.getTanshizhiResult().toString());
		//中医特秉质判定结果代码
		exam.setSpecialDiathsisCode(record.getTebingzhiResult() == null?"":record.getTebingzhiResult().toString());
		//中医血瘀质判定结果代码
		exam.setBloodStasisCode(record.getXueyuzhiResult() == null?"":record.getXueyuzhiResult().toString());
		//中医阳虚质判定结果代码
		exam.setYangDeficiencyCode(record.getYangxuzhiResult() == null?"":record.getYangxuzhiResult().toString());
		//中医阴虚质判定结果代码
		exam.setYinDeficiencyCode(record.getYinxuzhiResult() == null?"":record.getYinxuzhiResult().toString());
		
		return exam;
	}
	
	public static HealthExamInhos convertToInhos(HospitalizedRecord hos){
		HealthExamInhos in = new HealthExamInhos();
		//个人健康体检住院治疗情况ID
		in.setHealthExamInhosId(hos.getId());
		//入院日期/建床日期
		in.setAdmissionDate(DateUtil.getDate(hos.getInHospitalTime(), "yyyy-MM-dd"));
		//原因
		in.setAdmissionReason(hos.getReason());
		//出院日期/撤床日期
		in.setDischargeDate(DateUtil.getDate(hos.getLeaveHospitalTime(), "yyyy-MM-dd"));
		//个人健康体检ID
		in.setHealthExamId(hos.getExamId());
		//医疗机构名称
		in.setHospitalName(hos.getHospitalOrgan());
		//住院史类型代码(1住院史2病床史)
		in.setInhosHistoryTypeCode(hos.getHospitalizedType()==null?"1":hos.getHospitalizedType().toString());
		//病案号
		in.setMedicalRecordNo(hos.getCaseCode());		
		return in;
	}
	
	public static HealthExamDrug convertToDrug(TakeMedicineRecord med){		
		HealthExamDrug drug = new HealthExamDrug();
		//个人健康体检用药情况ID
		drug.setHealthExamDrugId(med.getId());
		//服药依从性代码
		drug.setDrugComplianceCode(med.getMedicineCompliance());
		//服药依从性中文
		drug.setDrugComplianceValue(CodeToValue.complianceConvert(med.getMedicineCompliance()));
		//用量
		drug.setDrugDose(med.getMedicineDosage());
		//药物名称
		drug.setDrugName(med.getMedicineName());
		//用药时间
		drug.setDrugTime(med.getMedicineTime());
		//用法代码
		drug.setDrugUsageCode(med.getMedicineUsage());
		//个人健康体检ID
		drug.setHealthExamId(med.getExamId());
		return drug;
	}
	
	public static HealthExamNoplanvacc convertToVaccination(VaccinationRecord v){		
		HealthExamNoplanvacc vacc = new HealthExamNoplanvacc();
		//个人健康体检用药情况ID
		vacc.setHealthExamNoplanVaccId(v.getId());
		//个人健康体检ID
		vacc.setHealthExamId(v.getExamId());
		//表内顺序
		vacc.setSsn(null);
		//疫苗接种日期
		vacc.setVaccinationDate(DateUtil.getDate(v.getVaccinationTime(), "yyyy-MM-dd"));
		//疫苗接种单位名称
		vacc.setVaccinationOrgName(v.getVaccinationOrganName());
		//疫苗名称代码
		vacc.setVaccineCode(v.getVaccinationName());
		return vacc;
	}
	
	public static ElderSelfcareAbility convertToSelfcare(ElderlySelfcareEstimate self){		
		ElderSelfcareAbility ability = new ElderSelfcareAbility();
		//老年人自理能力评估表ID
		ability.setElderSelfcareAbilityId(self.getId());
		//个人档案ID
		ability.setPersonInfoId(self.getArchiveNo());
		//老年人健康状态自我评估代码
		ability.setElderHealthAssessCode(self.getJudgementResult());
		String result = self.getAnswerResult();
		String[] score = result.split(",");
		//进餐评分
		ability.setDineScore(NumberUtils.convertToShort(score[0]));
		//梳洗评分
		ability.setCleanupScore(NumberUtils.convertToShort(score[1]));
		//穿衣评分
		ability.setDefecationScore(NumberUtils.convertToShort(score[2]));
		//如厕评分
		ability.setDefecationScore(NumberUtils.convertToShort(score[3]));
		//活动评分
		ability.setActivityScore(NumberUtils.convertToShort(score[4]));
		//总评分
		ability.setTotalScore(self.getTotalScore()==null?null:self.getTotalScore().shortValue());
		//填表时间
		ability.setFillDate(self.getCreateTime());
		//录入机构ID
		ability.setCreateOrgId(self.getCreateOrg());
		//录入机构名称
		ability.setOrgName(self.getCreateOrgName());
		//录入人ID
		ability.setCreatorId(self.getCreateUser());
		//录入人姓名
		ability.setCreator(self.getCreateName());
		//录入时间
		ability.setCreateTime(self.getCreateTime());
		//最后更新机构ID
		ability.setModifiedOrgId(null);
		//最后更新机构名称
		ability.setModifiedOrgName(null);
		//最后更新人ID
		ability.setModifierId(self.getUpdateUser());
		//最后更新人姓名
		ability.setModifier(self.getUpdateName());
		//最后更新时间
		ability.setModifiedTime(self.getUpdateTime());
		//考核项总数
		ability.setAssessmentCount(5);
		//未考核项
		ability.setMissingCount(0);
		//完整率
		BigDecimal intactRate = new BigDecimal("1");
		ability.setIntactRate(intactRate);
		//传入“5”
		ability.setIsAppCreate(Short.valueOf("5"));
		//评价医生姓名
		ability.setDoctorName(self.getCreateName());
		//评价医生ID
		ability.setDoctorId(self.getCreateUser());
		
		return ability;
	}	
	
	public static ElderTcmHealth convertToTcm(ElderlyTcmRecord record){		
		ElderTcmHealth tcm = new ElderTcmHealth();
		//老年人中医药健康表ID
		tcm.setElderTcmHealthId(record.getId());
		//个人档案ID
		tcm.setPersonInfoId(record.getArchiveNo());
		//编号
		tcm.setElderTcmHealthNo(null);
		//姓名
		tcm.setName(record.getName());
		
		String result = record.getAnswerResult();
		String[] score = result.split(",");
		//(1)您精力充沛吗？（指精神头足，乐于做事）
		tcm.setEnergy(score[0]);
		//2)您容易疲乏吗？（指体力如何，是否稍微活动一下或做一点家务劳动就感到累）
		tcm.setFatigue(score[1]);
		//(3)您容易气短，呼吸短促，接不上气吗？
		tcm.setBreathe(score[2]);
		//(4)您说话声音低弱无力吗?（指说话没有力气）
		tcm.setSpeak(score[3]);
		//(5)您感到闷闷不乐、情绪低沉吗?（指心情不愉快，情绪低落）
		tcm.setUnpleasant(score[4]);
		//(6)您容易精神紧张、焦虑不安吗?（指遇事是否心情紧张）
		tcm.setNervous(score[5]);
		//(7)您因为生活状态改变而感到孤独、失落吗？
		tcm.setSolitary(score[6]);
		//(8)您容易感到害怕或受到惊吓吗?
		tcm.setScare(score[7]);
		//(9)您感到身体超重不轻松吗?(感觉身体沉重) [BMI指数=体重（kg）/身高2（m）]
		tcm.setWeight(score[8]);
		//(10)您眼睛干涩吗?
		tcm.setEye(score[9]);
		//(11)您手脚发凉吗?（不包含因周围温度低或穿的少导致的手脚发冷）
		tcm.setHand(score[10]);
		//(12)您胃脘部、背部或腰膝部怕冷吗？（指上腹部、背部、腰部或膝关节等，有一处或多处怕冷）
		tcm.setCraw(score[11]);
		//(13)您比一般人耐受不了寒冷吗？（指比别人容易害怕冬天或是夏天的冷空调、电扇等
		tcm.setCold(score[12]);
		//(14)您容易患感冒吗?（指每年感冒的次数）
		tcm.setCatchacold(score[13]);
		//(15)您没有感冒时也会鼻塞、流鼻涕吗?
		tcm.setRunathenose(score[14]);
		//(16)您有口粘口腻，或睡眠打鼾吗？
		tcm.setMouth(score[15]);
		//(17)您容易过敏(对药物、食物、气味、花粉或在季节交替、气候变化时)吗?
		tcm.setFood(score[16]);
		//(18)您的皮肤容易起荨麻疹吗? (包括风团、风疹块、风疙瘩)
		tcm.setDerma(score[17]);
		//(19)您的皮肤在不知不觉中会出现青紫瘀斑、皮下出血吗?（指皮肤在没有外伤的情况下出现青一块紫一块的情况）
		tcm.setBleeding(score[18]);
		//(20)您的皮肤一抓就红，并出现抓痕吗?（指被指甲或钝物划过后皮肤的反应）
		tcm.setFingermail(score[19]);
		//(21)您皮肤或口唇干吗?
		tcm.setOraldry(score[20]);
		//(22)您有肢体麻木或固定部位疼痛的感觉吗？
		tcm.setAche(score[21]);
		//(23)您面部或鼻部有油腻感或者油亮发光吗?（指脸上或鼻子）
		tcm.setFace(score[22]);
		//(24)您面色或目眶晦黯，或出现褐色斑块/斑点吗?
		tcm.setSpot(score[23]);
		//(25)您有皮肤湿疹、疮疖吗？
		tcm.setSore(score[24]);
		//(26)您感到口干咽燥、总想喝水吗？
		tcm.setDrinking(score[25]);
		//(27)您感到口苦或嘴里有异味吗?（指口苦或口臭）
		tcm.setBittertaste(score[26]);
		//(28)您腹部肥大吗?（指腹部脂肪肥厚）
		tcm.setAbdomen(score[27]);
		//(29)您吃(喝)凉的东西会感到不舒服或者怕吃(喝)凉的东西吗？（指不喜欢吃凉的食物，或吃了凉的食物后会不舒服）
		tcm.setUncomfortable(score[28]);
		//(30)您有大便黏滞不爽、解不尽的感觉吗?(大便容易粘在马桶或便坑壁上)
		tcm.setUnwell(score[29]);
		//(31)您容易大便干燥吗?
		tcm.setMalaise(score[30]);
		//(32)您舌苔厚腻或有舌苔厚厚的感觉吗?（如果自我感觉不清楚可由调查员观察后填写）
		tcm.setTongue(score[31]);
		//(33)您舌下静脉瘀紫或增粗吗？（可由调查员辅助观察后填写
		tcm.setVein(score[32]);
		//气虚质得分
		tcm.setQiDeficiencyScore(record.getQixuzhiScore() == null?null:record.getQixuzhiScore().shortValue());
		//气虚质代码
		tcm.setQiDeficiencyCode(record.getQixuzhiResult() == null?"":record.getQixuzhiResult().toString());
		//阳虚质得分
		tcm.setYangDeficiencyScore(record.getYangxuzhiScore() == null?null:record.getYangxuzhiScore().shortValue());
		//阳虚质代码
		tcm.setYangDeficiencyCode(record.getYangxuzhiResult() == null?"":record.getYangxuzhiResult().toString());
		//阴虚质得分
		tcm.setYinDeficiencyScore(record.getYinxuzhiScore() == null?null:record.getYinxuzhiScore().shortValue());
		//阴虚质代码
		tcm.setYinDeficiencyCode(record.getYinxuzhiResult() == null?"":record.getYinxuzhiResult().toString());
		//痰湿质得分
		tcm.setPhlegmWetScore(record.getTanshizhiScore() == null?null:record.getTanshizhiScore().shortValue());
		//痰湿质代码
		tcm.setPhlegmWetCode(record.getTanshizhiResult() == null?"":record.getTanshizhiResult().toString());
		//湿热质得分
		tcm.setDampHeatScore(record.getShirezhiScore() == null?null:record.getShirezhiScore().shortValue());
		//湿热质代码
		tcm.setDampHeatCode(record.getShirezhiResult() == null?"":record.getShirezhiResult().toString());
		//血瘀质得分
		tcm.setBloodStasisScore(record.getXueyuzhiScore() == null?null:record.getXueyuzhiScore().shortValue());
		//血瘀质代码
		tcm.setBloodStasisCode(record.getXueyuzhiResult() == null?"":record.getXueyuzhiResult().toString());
		//气郁质得分
		tcm.setQiDepressionScore(record.getQiyuzhiScore() == null?null:record.getQiyuzhiScore().shortValue());
		//气郁质代码
		tcm.setQiDepressionCode(record.getQiyuzhiResult() == null?"":record.getQiyuzhiResult().toString());
		//特禀质得分
		tcm.setSpecialDiathsisScore(record.getTebingzhiSorce() == null?null:record.getTebingzhiSorce().shortValue());
		//特禀质代码
		tcm.setSpecialDiathsisCode(record.getTebingzhiResult() == null?"":record.getTebingzhiResult().toString());
		//平和质得分
		tcm.setGentleQualityScore(record.getPinghezhiSorce() == null?null:record.getPinghezhiSorce().shortValue());
		//平和质代码
		tcm.setGentleQualityCode(record.getPinghezhiResult() == null?"":record.getPinghezhiResult().toString());
		//签名医师ID
		tcm.setDoctorId(record.getCreateUser());
		//签名医生姓名
		tcm.setDoctorName(record.getTestDoctor());
		//填表时间
		tcm.setFillDate(DateUtil.getDate(record.getTestDate(), "yyyy-MM-dd"));
		//录入机构ID
		tcm.setCreateOrgId(record.getCreateOrg());
		//录入机构名称
		tcm.setOrgName(record.getCreateOrgName());
		//录入人ID
		tcm.setCreatorId(record.getCreateUser());
		//录入人姓名
		tcm.setCreator(record.getCreateName());
		//录入时间
		tcm.setCreateTime(record.getCreateTime());
		//最后更新机构ID
		tcm.setModifiedOrgId(null);
		//最后更新机构名称
		tcm.setModifiedOrgName(null);
		//最后更新人ID
		tcm.setModifierId(record.getUpdateUser());
		//最后更新人姓名
		tcm.setModifier(record.getUpdateName());
		//最后更新时间
		tcm.setModifiedTime(record.getUpdateTime());
		//传入“5”
		tcm.setIsAppCreate(Short.valueOf("5"));
		return tcm;
	}
}
