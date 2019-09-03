package com.zkhw.shanxi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.util.StringUtil;
import com.zkhw.flup.dao.DiabetesFollowRecordDao;
import com.zkhw.flup.dao.FollowMedicineRecordDao;
import com.zkhw.flup.dao.HypertensionDao;
import com.zkhw.flup.dao.PoorFollowRecordDao;
import com.zkhw.flup.entity.DiabetesFollowRecord;
import com.zkhw.flup.entity.FollowMedicineRecord;
import com.zkhw.flup.entity.Hypertension;
import com.zkhw.flup.entity.PoorFollowRecord;
import com.zkhw.framework.utils.DateUtil;
import com.zkhw.ltd.entity.Organization;
import com.zkhw.ltd.entity.User;
import com.zkhw.ltd.service.OrganizationService;
import com.zkhw.ltd.service.UserService;
import com.zkhw.pub.dao.ElderlySelfcareEstimateDao;
import com.zkhw.pub.dao.ElderlyTcmRecordDao;
import com.zkhw.pub.dao.HospitalizedRecordDao;
import com.zkhw.pub.dao.PhysicalExaminationDao;
import com.zkhw.pub.dao.ResidentBaseInfoDao;
import com.zkhw.pub.dao.ResidentInfoTempDao;
import com.zkhw.pub.dao.TakeMedicineRecordDao;
import com.zkhw.pub.dao.VaccinationRecordDao;
import com.zkhw.pub.entity.ElderlyTcmRecord;
import com.zkhw.pub.entity.HospitalizedRecord;
import com.zkhw.pub.entity.PhysicalExamination;
import com.zkhw.pub.entity.ResidentBaseInfo;
import com.zkhw.pub.entity.ResidentInfoTemp;
import com.zkhw.pub.entity.TakeMedicineRecord;
import com.zkhw.pub.entity.VaccinationRecord;
import com.zkhw.pub.vo.ArchiveId;
import com.zkhw.shanxi.bo.BaseElement;
import com.zkhw.shanxi.bo.Businessdata;
import com.zkhw.shanxi.bo.Diabetes;
import com.zkhw.shanxi.bo.Elderly;
import com.zkhw.shanxi.bo.Examination;
import com.zkhw.shanxi.bo.FamilyPractice;
import com.zkhw.shanxi.bo.Header;
import com.zkhw.shanxi.bo.Hospitalized;
import com.zkhw.shanxi.bo.JKFPVisit;
import com.zkhw.shanxi.bo.Resident;
import com.zkhw.shanxi.bo.ResidentQuery;
import com.zkhw.shanxi.bo.Residentdata;
import com.zkhw.shanxi.bo.ResponseError;
import com.zkhw.shanxi.bo.ResponseXml;
import com.zkhw.shanxi.bo.TakeMedicineCondition;
import com.zkhw.shanxi.bo.Vaccination;
import com.zkhw.shanxi.service.ShanxiSyncService;
import com.zkhw.shanxi.utils.CodeConvert;
import com.zkhw.shanxi.utils.ConvertObject;
import com.zkhw.shanxi.utils.IdTest;
import com.zkhw.shanxi.utils.TestPost;
import com.zkhw.shanxi.utils.UrlUtils;
import com.zkhw.shanxi.utils.XmlUtils;
import com.zkhw.shanxi.vo.DiabetesVo;
import com.zkhw.shanxi.vo.ElderlyVo;
import com.zkhw.shanxi.vo.ExaminationVo;
import com.zkhw.shanxi.vo.HospitalizedVo;
import com.zkhw.shanxi.vo.HypertensionVo;
import com.zkhw.shanxi.vo.JKFPVisitVo;
import com.zkhw.shanxi.vo.ResidentBody;
import com.zkhw.shanxi.vo.ResidentVo;
import com.zkhw.shanxi.vo.ResidentXml;
import com.zkhw.shanxi.vo.TakeMedicineVo;
import com.zkhw.shanxi.vo.VaccinationVo;

@Service
public class ShanxiSyncServiceImpl implements ShanxiSyncService {

	@Autowired
	private PhysicalExaminationDao physicalExaminationDao;
	
	@Autowired
	private HospitalizedRecordDao hospitalizedRecordDao;
	
	@Autowired
	private TakeMedicineRecordDao takeMedicineRecordDao;
	
	@Autowired
	private VaccinationRecordDao vaccinationRecordDao;
	
	@Autowired
	private ResidentInfoTempDao residentInfoTempDao;
	
	@Autowired
	private ResidentBaseInfoDao residentBaseInfoDao;
	
	@Autowired
	private ElderlySelfcareEstimateDao elderlySelfcareEstimateDao;
	
	@Autowired
	private ElderlyTcmRecordDao elderlyTcmRecordDao;
	
	@Autowired
	private DiabetesFollowRecordDao diabetesFollowRecordDao;
	
	@Autowired
	private FollowMedicineRecordDao followMedicineRecordDao;
	
	@Autowired
	private HypertensionDao hypertensionDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private PoorFollowRecordDao poorFollowRecordDao;
	
	@Override
	public void examSync() {
		// TODO Auto-generated method stub
		List<PhysicalExamination> list = physicalExaminationDao.findShanxiSyncList();
		if(list != null && list.size() > 0){
			for(int i = 0; i < list.size(); i++){
				try{
					PhysicalExamination phy = list.get(i);	
/*					String d = DateUtil.fmtDate(phy.getCreateTime(), "yyyy-MM-dd");
					if(!d.equals("2019-07-26")){
						continue;
					}
					if(!phy.getIdNumber().equals("612430195304232221")){
						continue;
					}*/
					Businessdata data = new Businessdata();
					
					Header header = new Header();
					header.setFunctioncode("CHECK_1001");
					header.setErrCode("0");
					header.setErrMsg("");
					header.setCmd("insert");
					data.setHeader(header);
					
					List<Object> olist = new ArrayList<Object>();
					
					ExaminationVo examVo = new ExaminationVo();
					BeanUtils.copyProperties(phy,examVo);
					ResidentBaseInfo info = residentBaseInfoDao.findResidentByIdNumber(examVo.getIdNumber());
					if(info != null){
						if(StringUtil.isNotEmpty(info.getDoctorId())){
							examVo.setDutydoctor(info.getDoctorId());
						}else{
							if(StringUtil.isNotEmpty(phy.getDutydoctor())){
								examVo.setDutydoctor(phy.getDutydoctor());
							}else{
								examVo.setDutydoctor(phy.getCreateUser());
							}
						}
						int age = DateUtil.getNominalAge(info.getBirthday());
						if(age >= 65){
							examVo.setCheckFlag(CodeConvert.checkFlagConvert("2"));
						}else if(info.getIsDiabetes() != null &&  info.getIsDiabetes() == 1){
							examVo.setCheckFlag(CodeConvert.checkFlagConvert("5"));
						}else if(info.getIsHypertension() != null && info.getIsHypertension() == 1){							
							examVo.setCheckFlag(CodeConvert.checkFlagConvert("4"));
						}else if(info.getIsPsychosis() != null && info.getIsPsychosis() == 1){
							examVo.setCheckFlag(CodeConvert.checkFlagConvert("6"));
						}else if(info.getIsPoor() != null && info.getIsPoor() == 1){
							examVo.setCheckFlag(CodeConvert.checkFlagConvert("7"));
						}else {
							examVo.setCheckFlag(CodeConvert.checkFlagConvert("3"));
						}
					}else {
						if(StringUtil.isNotEmpty(phy.getDutydoctor())){
							examVo.setDutydoctor(phy.getDutydoctor());
						}else{
							examVo.setDutydoctor(phy.getCreateUser());
						}
						examVo.setCheckFlag(CodeConvert.checkFlagConvert("3"));
					}
					
					String symptom = examVo.getSymptom();
					if(StringUtil.isNotEmpty(symptom)){
						String symptomValue = "";
						String[] s = symptom.split(",");
						for(int k = 0; k < s.length; k++){
							if(StringUtil.isNotEmpty(s[k])){
								symptomValue = symptomValue + CodeConvert.symptomConvert(s[k]) + "|";					
							}
						}
						symptomValue = symptomValue.substring(0, symptomValue.length() - 1);
						
						examVo.setSymptom(symptomValue);
					}

					String selfCare = CodeConvert.selfCareConvert(examVo.getBaseSelfcareEstimate());
					examVo.setBaseSelfcareEstimate(selfCare);
					
					String healthEstimate = CodeConvert.healthEstimateConvert(examVo.getBaseHealthEstimate());
					examVo.setBaseHealthEstimate(healthEstimate);
					
					String cognitionEstimate = CodeConvert.cognitionEstimateConvert(examVo.getBaseCognitionEstimate());
					examVo.setBaseCognitionEstimate(cognitionEstimate);
					
					String feelingEstimate = CodeConvert.cognitionEstimateConvert(examVo.getBaseFeelingEstimate());
					examVo.setBaseFeelingEstimate(feelingEstimate);
					
					String exerciseFrequency = CodeConvert.exerciseFrequencyConvert(examVo.getLifewayExerciseFrequency());
					examVo.setLifewayExerciseFrequency(exerciseFrequency);
					
					String eating = examVo.getLifewayDiet();
					if(StringUtil.isNotEmpty(eating)){
						String[] s = eating.split(",");
						String eatingValue = "";
						for(int k = 0; k < s.length; k++){
							if(StringUtil.isNotEmpty(s[k])){
								eatingValue = eatingValue + CodeConvert.eatingConvert(s[k]) + "|";		
							}
						}
						eatingValue = eatingValue.substring(0, eatingValue.length() - 1);
						examVo.setLifewayDiet(eatingValue);
					}
					
					String smokeStatus = CodeConvert.smokeConvert(examVo.getLifewaySmokeStatus());
					examVo.setLifewaySmokeStatus(smokeStatus);
					
					String drinkStatus = CodeConvert.drinkConvert(examVo.getLifewayDrinkStatus());
					examVo.setLifewayDrinkStatus(drinkStatus);
					
					String drinkStop = CodeConvert.drinkStopConvert(examVo.getLifewayDrinkStop());
					examVo.setLifewayDrinkStop(drinkStop);
					
					String drinkOneyear = CodeConvert.isNotConvert(examVo.getLifewayDrinkOneyear());
					examVo.setLifewayDrinkOneyear(drinkOneyear);
					
					String drinking = examVo.getLifewayDrinkType();
					if(StringUtil.isNotEmpty(drinking)){
						String[] s = drinking.split(",");
						String drinkingTypeValue = "";
						for(int k = 0; k < s.length; k++){
							if(StringUtil.isNotEmpty(s[k])){
								drinkingTypeValue = drinkingTypeValue + CodeConvert.drinkTypeConvert(s[k]) + "|";		
							}
						}
						drinkingTypeValue = drinkingTypeValue.substring(0, drinkingTypeValue.length() - 1);
						examVo.setLifewayDrinkType(drinkingTypeValue);
					}
					
					String occupationalDisease = CodeConvert.haveNotConvert(examVo.getLifewayOccupationalDisease());
					examVo.setLifewayOccupationalDisease(occupationalDisease);
					
					String lips = CodeConvert.lipsConvert(examVo.getOrganLips());
					examVo.setOrganLips(lips);

					String tooth = examVo.getOrganTooth();
					if(StringUtil.isNotEmpty(tooth)){
						String[] s = tooth.split(",");
						String toothValue = "";
						for(int k = 0; k < s.length; k++){
							if(StringUtil.isNotEmpty(s[k])){
								toothValue = toothValue + CodeConvert.toothConvert(s[k]) + "|";		
							}
						}
						toothValue = toothValue.substring(0, toothValue.length() - 1);
						examVo.setOrganTooth(toothValue);
					}else{
						examVo.setOrganTooth( CodeConvert.toothConvert("1"));
					}
					
					String guttur = CodeConvert.gutturConvert(examVo.getOrganGuttur());
					examVo.setOrganGuttur(guttur);
					
					String hearing = CodeConvert.hearingConvert(examVo.getOrganHearing());
					examVo.setOrganHearing(hearing);
					
					String movement = CodeConvert.movementConvert(examVo.getOrganMovement());
					examVo.setOrganMovement(movement);
					
					String eye = CodeConvert.normalConvert(examVo.getExaminationEye());
					examVo.setExaminationEye(eye);
					
					String skin = CodeConvert.skinConvert(examVo.getExaminationSkin());
					examVo.setExaminationSkin(skin);
					
					String sclera = CodeConvert.scleraConvert(examVo.getExaminationSclera());
					examVo.setExaminationSclera(sclera);
					
					String lymph = CodeConvert.lymphConvert(examVo.getExaminationLymph());
					examVo.setExaminationLymph(lymph);
					
					String barrelChest = CodeConvert.barrelChestConvert(examVo.getExaminationBarrelChest());
					examVo.setExaminationBarrelChest(barrelChest);
					
					String breathSounds = CodeConvert.normalConvert(examVo.getExaminationBreathSounds());
					examVo.setExaminationBreathSounds(breathSounds);
					
					String rale = CodeConvert.raleConvert(examVo.getExaminationRale());
					examVo.setExaminationRale(rale);
					
					String heartRhythm = CodeConvert.heartRhythmConvert(examVo.getExaminationHeartRhythm());
					examVo.setExaminationHeartRhythm(heartRhythm);
					
					String heartNoise = CodeConvert.haveNotConvert(examVo.getExaminationHeartNoise());
					examVo.setExaminationHeartNoise(heartNoise);
					
					String tenderness = CodeConvert.haveNotConvert(examVo.getExaminationAbdomenTenderness());
					examVo.setExaminationAbdomenTenderness(tenderness);
					
					String mass = CodeConvert.haveNotConvert(examVo.getExaminationAbdomenMass());
					examVo.setExaminationAbdomenMass(mass);
					
					String hepatomegaly = CodeConvert.haveNotConvert(examVo.getExaminationAbdomenHepatomegaly());
					examVo.setExaminationAbdomenHepatomegaly(hepatomegaly);
					
					String splenomegaly = CodeConvert.haveNotConvert(examVo.getExaminationAbdomenSplenomegaly());
					examVo.setExaminationAbdomenSplenomegaly(splenomegaly);
					
					String shiftingdullness = CodeConvert.haveNotConvert(examVo.getExaminationAbdomenShiftingdullness());
					examVo.setExaminationAbdomenShiftingdullness(shiftingdullness);
					
					String edema = CodeConvert.edemaConvert(examVo.getExaminationLowerextremityEdema());
					examVo.setExaminationLowerextremityEdema(edema);
					
					String dorsal  = CodeConvert.dorsalConvert(examVo.getExaminationDorsalArtery());
					examVo.setExaminationDorsalArtery(dorsal);
					
					String anus = CodeConvert.anusConvert(examVo.getExaminationAnus());
					examVo.setExaminationAnus(anus);
					
					String breast = examVo.getExaminationBreast();
					if(StringUtil.isNotEmpty(breast)){
						String[] s = breast.split(",");
						String breastValue = "";
						for(int k = 0; k < s.length; k++){
							if(StringUtil.isNotEmpty(s[k])){
								breastValue = breastValue + CodeConvert.breastConvert(s[k]) + "|";				
							}
						}
						breastValue = breastValue.substring(0, breastValue.length() - 1);
						examVo.setExaminationBreast(breastValue);
					}
					
					String vulva = CodeConvert.noAbnormalityConvert(examVo.getExaminationWomanVulva());
					examVo.setExaminationWomanVulva(vulva);
					
					String vagina = CodeConvert.noAbnormalityConvert(examVo.getExaminationWomanVagina());
					examVo.setExaminationWomanVagina(vagina);
					
					String cervix = CodeConvert.noAbnormalityConvert(examVo.getExaminationWomanCervix());
					examVo.setExaminationWomanCervix(cervix);
					
					String corpus = CodeConvert.noAbnormalityConvert(examVo.getExaminationWomanCorpus());
					examVo.setExaminationWomanCorpus(corpus);
					
					String accessories = CodeConvert.noAbnormalityConvert(examVo.getExaminationWomanAccessories());
					examVo.setExaminationWomanAccessories(accessories);
					
					String urineProtein = CodeConvert.urineConvert(examVo.getUrineProtein());
					examVo.setUrineProtein(urineProtein);
					
					String glycosuria = CodeConvert.urineConvert(examVo.getGlycosuria());
					examVo.setGlycosuria(glycosuria);
					
					String acetone = CodeConvert.urineConvert(examVo.getUrineAcetoneBodies());
					examVo.setUrineAcetoneBodies(acetone);
					
					String bld = CodeConvert.urineConvert(examVo.getBld());
					examVo.setBld(bld);
					
					String cardiogram = CodeConvert.normalConvert(examVo.getCardiogram());
					examVo.setCardiogram(cardiogram);
					
					String fob = CodeConvert.feminineConvert(examVo.getFob());
					examVo.setFob(fob);
					
					String hb = CodeConvert.feminineConvert(examVo.getHb());
					examVo.setHb(hb);
					
					String chestX = CodeConvert.normalConvert(examVo.getChestX());
					examVo.setChestX(chestX);
					
					String ultrasoundAbdomen = CodeConvert.normalConvert(examVo.getUltrasoundAbdomen());
					examVo.setUltrasoundAbdomen(ultrasoundAbdomen);
					
					String otherB = CodeConvert.normalConvert(examVo.getOtherB());
					examVo.setOtherB(otherB);
					
					String cervicalSmear = CodeConvert.normalConvert(examVo.getCervicalSmear());
					examVo.setCervicalSmear(cervicalSmear);
					
					String cerebrovascularDisease = examVo.getCerebrovascularDisease();
					if(StringUtil.isNotEmpty(cerebrovascularDisease)){
						String[] s = cerebrovascularDisease.split(",");
						String diseases = "";
						for(int k = 0; k < s.length; k++){
							if(StringUtil.isNotEmpty(s[k])){
								diseases = diseases + CodeConvert.cerebrovascularDisease(s[k]) + "|";				
							}
						}
						diseases = diseases.substring(0, diseases.length() - 1);
						examVo.setCerebrovascularDisease(diseases);
					}
					
					String kidneyDisease = examVo.getKidneyDisease();
					if(StringUtil.isNotEmpty(kidneyDisease)){
						String[] s = kidneyDisease.split(",");
						String diseases = "";
						for(int k = 0; k < s.length; k++){
							if(StringUtil.isNotEmpty(s[k])){
								diseases = diseases + CodeConvert.kidneyDisease(s[k]) + "|";				
							}
						}
						diseases = diseases.substring(0, diseases.length() - 1);
						examVo.setKidneyDisease(diseases);
					}					

					String heartDisease = examVo.getHeartDisease();
					if(StringUtil.isNotEmpty(heartDisease)){
						String[] s = heartDisease.split(",");
						String diseases = "";
						for(int k = 0; k < s.length; k++){
							if(StringUtil.isNotEmpty(s[k])){
								diseases = diseases + CodeConvert.heartDisease(s[k]) + "|";				
							}
						}
						diseases = diseases.substring(0, diseases.length() - 1);
						examVo.setHeartDisease(diseases);
					}	

					String vascularDisease = examVo.getVascularDisease();
					if(StringUtil.isNotEmpty(vascularDisease)){
						String[] s = vascularDisease.split(",");
						String diseases = "";
						for(int k = 0; k < s.length; k++){
							if(StringUtil.isNotEmpty(s[k])){
								diseases = diseases + CodeConvert.vascularDisease(s[k]) + "|";				
							}
						}
						diseases = diseases.substring(0, diseases.length() - 1);
						examVo.setVascularDisease(diseases);
					}

					String ocularDiseases = examVo.getOcularDiseases();
					if(StringUtil.isNotEmpty(ocularDiseases)){
						String[] s = ocularDiseases.split(",");
						String diseases = "";
						for(int k = 0; k < s.length; k++){
							if(StringUtil.isNotEmpty(s[k])){
								diseases = diseases + CodeConvert.ocularDiseases(s[k]) + "|";				
							}
						}
						diseases = diseases.substring(0, diseases.length() - 1);
						examVo.setOcularDiseases(diseases);
					}
					
					String nervousSystemDisease = CodeConvert.notFoundConvert(examVo.getNervousSystemDisease());
					examVo.setNervousSystemDisease(nervousSystemDisease);
					
					String otherDisease = CodeConvert.notFoundConvert(examVo.getOtherDisease());
					examVo.setOtherDisease(otherDisease);
					
					String healthEvaluation = CodeConvert.healthEvaluationConvert(examVo.getHealthEvaluation());
					examVo.setHealthEvaluation(healthEvaluation);
					
					String guidance = examVo.getHealthGuidance();
					if(StringUtil.isNotEmpty(guidance)){
						String[] s = guidance.split(",");
						String healthGuidanceValue = "";
						for(int k = 0; k < s.length; k++){
							if(StringUtil.isNotEmpty(s[k])){
								healthGuidanceValue = healthGuidanceValue + CodeConvert.healthGuidanceConvert(s[k]) + "|";		
							}
						}
						healthGuidanceValue = healthGuidanceValue.substring(0, healthGuidanceValue.length() - 1);
						examVo.setHealthGuidance(healthGuidanceValue);
					}
					
					String dangerControlling = examVo.getDangerControlling();
					if(StringUtil.isNotEmpty(dangerControlling)){
						String[] s = dangerControlling.split(",");
						String dangerValue = "";
						for(int k = 0; k < s.length; k++){
							if(StringUtil.isNotEmpty(s[k])){
								dangerValue = dangerValue + CodeConvert.dangerControlling(s[k]) + "|";		
							}
						}
						dangerValue = dangerValue.substring(0, dangerValue.length() - 1);
						examVo.setDangerControlling(dangerValue);
					}
					
					//获取Id
					String healthCheckName = "EHR_Arch_HealthCheck";
					IdTest idTest = new IdTest();
					String areaCode = "6199";
					Organization o = organizationService.getOrganizationByCode(phy.getCreateOrg());
					if(o != null){
						areaCode = o.getCountyCode();
					}

					String duns = phy.getCreateOrg();

					String token = "123456";

					String userId = phy.getCreateUser();
					User u = userService.findUserByCode(phy.getCreateUser());
					if( u == null){
						u = userService.findUserByLoginName(phy.getCreateUser());
					}
					if(u != null){
						if(StringUtil.isNotEmpty(u.getPubUsercode())){
							userId = u.getPubUsercode();
						}else{
							userId = u.getLoginName();
						}
					}
					
					String functionCode = "CHECK_1001";
					
					String verifyCode = "123456";
					
					String compId = "123";
					String healthCheckId = idTest.getId(healthCheckName, areaCode, duns, token, userId, compId);
					if(!StringUtil.isEmpty(healthCheckId)) {
						examVo.setId(healthCheckId);
					}
					
					Examination exam = ConvertObject.convertExam(examVo);
					olist.add(exam);
					
					List<HospitalizedRecord> hosps = hospitalizedRecordDao.findRecordByExamId(phy.getId());
					for(int j = 0; j < hosps.size(); j++){
						HospitalizedRecord hos = hosps.get(j);
						if(hos.getHospitalizedType() == 1){
							HospitalizedVo hospVo = new HospitalizedVo();
							BeanUtils.copyProperties(hos,hospVo);
							if(StringUtil.isEmpty(hospVo.getCreateOrg())){
								hospVo.setCreateOrg(examVo.getCreateOrg());
							}
							//设置Id
							String inprecordName = "EHR_Arch_Inprecord";
							IdTest idTest2 = new IdTest();
							String inprecordId = idTest2.getId(inprecordName, areaCode, duns, token, userId, compId);
							if(!StringUtil.isEmpty(inprecordId)) {
								hospVo.setId(inprecordId);
							}
							
							hospVo.setServiceName("SX0069_3");
							hospVo.setExamId(healthCheckId);
							
							Hospitalized h = ConvertObject.convertToHospitalized(hospVo);
							olist.add(h);
						}else{
							HospitalizedVo famVo = new HospitalizedVo();
							BeanUtils.copyProperties(hos,famVo);
							if(StringUtil.isEmpty(famVo.getCreateOrg())){
								famVo.setCreateOrg(examVo.getCreateOrg());
							}
							//设置Id
							String homebedName = "EHR_Arch_Homebed";
							IdTest idTest3 = new IdTest();
							String homebedId = idTest3.getId(homebedName, areaCode, duns, token, userId, compId);
							if(!StringUtil.isEmpty(homebedId)) {
								famVo.setId(homebedId);
							}
							
							famVo.setServiceName("SX0069_3");
							famVo.setExamId(healthCheckId);
							FamilyPractice fam = ConvertObject.convertToFamilyPractice(famVo);		
							olist.add(fam);
						}
					}
					List<TakeMedicineRecord> meds = takeMedicineRecordDao.findRecordByExamId(phy.getId());
					for(int j = 0; j < meds.size(); j++){
						TakeMedicineRecord med = meds.get(j);
						TakeMedicineVo takeVo = new TakeMedicineVo();
						BeanUtils.copyProperties(med,takeVo);
						if(StringUtil.isEmpty(takeVo.getCreateOrg())){
							takeVo.setCreateOrg(examVo.getCreateOrg());
						}
						//设置Id
						String druguseName = "EHR_Arch_Druguse";
						IdTest idTest4 = new IdTest();
						String druguseId = idTest4.getId(druguseName, areaCode, duns, token, userId, compId);
						if(!StringUtil.isEmpty(druguseId)) {
							takeVo.setId(druguseId);
						}
						
						takeVo.setServiceName("SX0069_3");
						takeVo.setExamId(healthCheckId);
						String compliance = CodeConvert.complianceConvert(takeVo.getMedicineCompliance());
						takeVo.setMedicineCompliance(compliance);
						
						TakeMedicineCondition take = ConvertObject.convertToTakeMedicine(takeVo);
						olist.add(take);
					}
					
					List<VaccinationRecord> vaccs = vaccinationRecordDao.findRecordByExamId(phy.getId());
					
					for(int j = 0; j < vaccs.size(); j++){
						VaccinationRecord vac = vaccs.get(j);
						VaccinationVo vaccVo = new VaccinationVo();
						BeanUtils.copyProperties(vac,vaccVo);
						if(StringUtil.isEmpty(vaccVo.getVaccinationOrgan())){
							vaccVo.setVaccinationOrgan(examVo.getCreateOrg());
						}
						//设置Id
						String inocNoteName = "EHR_Immu_InocNote";
						IdTest idTest5 = new IdTest();
						String inocNoteId = idTest5.getId(inocNoteName, areaCode, duns, token, userId, compId);
						if(!StringUtil.isEmpty(inocNoteId)) {
							vaccVo.setId(inocNoteId);
						}
						
						vaccVo.setExamId(healthCheckId);
						Vaccination vacc = ConvertObject.convertToVaccination(vaccVo);
						olist.add(vacc);
					}
					
					data.setBody(olist);
					
					String reqXml = XmlUtils.modelToStringXML(data);					
					reqXml = reqXml.replace("<body>", "<body><![CDATA[");
					reqXml = reqXml.replace("</body>", "]]></body>");
					System.out.println("reqXml=" + reqXml);
					String result = this.send(areaCode, duns, token, userId, functionCode, verifyCode, compId, reqXml);

					if(!"".equals(result)){
						Object r = XmlUtils.xmlToBean(result, ResponseXml.class);
						if(r != null){
							ResponseXml x = (ResponseXml)r;
							String errCode = x.getHeader().getErrCode();
							if("0".equals(errCode)){
								phy.setUploadStatus(1);
								phy.setUploadTime(new Date());
								
								physicalExaminationDao.updateByPrimaryKeySelective(phy);
							}else{
								System.out.println("msg =" + x.getHeader().getErrMsg());
								System.out.println("total =" + x.getBody().getRows_total());
								System.out.println("suc =" + x.getBody().getRows_suc());
								System.out.println("fail =" + x.getBody().getRows_faild());
								System.out.println("memo =" + x.getBody().getMemo());
								List<ResponseError> ll = x.getBody().getError();
								if(ll != null){
									for(int l = 0; l < ll.size(); l++){
										System.out.println(ll.get(l).getTypeId());
										System.out.println(ll.get(l).getInstanceId());
										System.out.println(ll.get(l).getErrorDesc());
									}
								}
							}
						}
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}		
	}

	@Override
	public void redidentSync() {
		// TODO Auto-generated method stub
		List<ResidentInfoTemp> list = residentInfoTempDao.findAll();
		for(int i = 0; i < list.size(); i++){
			ResidentInfoTemp temp = list.get(i);
			try{
				ResidentBaseInfo info = residentBaseInfoDao.findResidentByIdNumber(temp.getIdNumber());
				if(info == null){
					info = new ResidentBaseInfo();
					BeanUtils.copyProperties(temp,info);
					info.setAge(DateUtil.getAge(temp.getBirthday()));
					Organization o = organizationService.getOrganizationByCode(temp.getCreateOrg());
					if(o != null){
						if("61".equals(o.getProvinceCode())){
							//this.getResident(info, temp);
						}
					}

					int count = residentBaseInfoDao.insertSelective(info);
					if(count > 0 ){
						residentInfoTempDao.deleteByPrimaryKey(temp.getId());
					}					
				}else{
					String oldArchiveNo = temp.getArchiveNo();
					String archiveNo = info.getArchiveNo();
					
					ArchiveId archive = new ArchiveId();
					archive.setArchiveNo(archiveNo);
					archive.setOldArchiveNo(oldArchiveNo);
					
					physicalExaminationDao.updateArchiveNo(archive);
					elderlySelfcareEstimateDao.updateArchiveNo(archive);
					hospitalizedRecordDao.updateArchiveNo(archive);
					takeMedicineRecordDao.updateArchiveNo(archive);
					vaccinationRecordDao.updateArchiveNo(archive);
					elderlyTcmRecordDao.updateArchiveNo(archive);
					
					residentInfoTempDao.deleteByPrimaryKey(temp.getId());
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}
	
	private String send(String areaCode, String duns, String token,String userId, String functionCode,String verifyCode,String compId, String reqXml){
		String url = UrlUtils.getUrl(areaCode);
		String param = "areaCode="+areaCode+"&duns="+duns+"&token="+token+"&userType=1&userId="+userId +
		"&functionCode=" + functionCode + "&verifyCode=" + verifyCode +"&compId=" + compId + "&reqXml=" + reqXml;
		String result = TestPost.sendPost(url, param, 300, 300);
		return result;
		
	}

	@Override
	public void diabetesSync() {
		// TODO Auto-generated method stub
		List<DiabetesFollowRecord> diabetesList = diabetesFollowRecordDao.shanxiSyncList();
		if(diabetesList != null && diabetesList.size() > 0){
			for(int i = 0; i < diabetesList.size(); i++){
				DiabetesFollowRecord record = diabetesList.get(i);
				DiabetesVo diabetesVo = new DiabetesVo();
				BeanUtils.copyProperties(record,diabetesVo);
				
				String visitType = CodeConvert.visitTypeConvert(diabetesVo.getVisitType());
				diabetesVo.setVisitType(visitType);
				
				String symptom = diabetesVo.getSymptom();
				if(StringUtil.isNotEmpty(symptom)){
					String symptomValue = "";
					String[] s = symptom.split(",");
					for(int k = 0; k < s.length; k++){
						if(StringUtil.isNotEmpty(s[k])){
							symptomValue = symptomValue + CodeConvert.diabetesSymptomConvert(s[k]) + "|";					
						}
					}
					symptomValue = symptomValue.substring(0, symptomValue.length() - 1);
					
					diabetesVo.setSymptom(symptomValue);
				}

				String dorsal = CodeConvert.diabetesDorsalConvert(diabetesVo.getDorsalArtery());
				diabetesVo.setDorsalArtery(dorsal);
				
				String position = record.getPulsationPosition();
				if(StringUtil.isNotEmpty(position)){
					String p = CodeConvert.pulsationPositionConvert(position);
					if("2".equals(record.getDorsalArtery())){
						diabetesVo.setAttenuate(p);
					}else if("3".equals(record.getDorsalArtery())){
						diabetesVo.setDisapppear(p);
					}
				}
				
				String psychologicalRecovery = CodeConvert.diabetesPsychologyConvert(diabetesVo.getPsychologicalRecovery());
				diabetesVo.setPsychologicalRecovery(psychologicalRecovery);
				
				String medicalCompliance = CodeConvert.diabetesPsychologyConvert(diabetesVo.getMedicalCompliance());
				diabetesVo.setMedicalCompliance(medicalCompliance);
				
				String compliance = CodeConvert.complianceConvert(diabetesVo.getCompliance());
				diabetesVo.setCompliance(compliance);
				
				String untowardEffect = CodeConvert.haveNotConvert(diabetesVo.getUntowardEffect());
				diabetesVo.setUntowardEffect(untowardEffect);
				
				String reactiveHypoglycemia = CodeConvert.reactiveHypoglycemiaConvert(diabetesVo.getReactiveHypoglycemia());
				diabetesVo.setReactiveHypoglycemia(reactiveHypoglycemia);
				
				String followType = CodeConvert.visitClassConvert(diabetesVo.getFollowType());
				diabetesVo.setFollowType(followType);
				
				if(StringUtil.isEmpty(diabetesVo.getHeight())){
					diabetesVo.setHeight("0");
				}
				
				if(StringUtil.isEmpty(diabetesVo.getWeightNow())){
					diabetesVo.setWeightNow("0");
				}
				
				String dmvisitName = "EHR_Dis_Dmvisit";
				IdTest idTest = new IdTest();
				
				String areaCode = "6199";
				Organization o = organizationService.getOrganizationByCode(record.getCreateOrg());
				if(o != null){
					areaCode = o.getCountyCode();
				}

				String duns = record.getCreateOrg();

				String token = "123456";

				String userId = record.getCreateUser();
				
				User u = userService.findUserByCode(record.getCreateUser());
				if( u == null){
					u = userService.findUserByLoginName(record.getCreateUser());
				}
				if(u != null){
					if(StringUtil.isNotEmpty(u.getPubUsercode())){
						userId = u.getPubUsercode();
					}else{
						userId = u.getLoginName();
					}
				}

				String functionCode = "DM_1001";
				String verifyCode = "123456";
				String compId = "123";
				String dmvisitId = idTest.getId(dmvisitName, areaCode, duns, token, userId, compId);
				if(!StringUtil.isEmpty(dmvisitId)) {
					diabetesVo.setId(dmvisitId);
				}
				
				Businessdata data = new Businessdata();
				
				Header header = new Header();
				header.setFunctioncode("DM_1001");
				header.setErrCode("0");
				header.setErrMsg("");
				header.setCmd("insert");
				data.setHeader(header);
				
				List<Object> list = new ArrayList<Object>();
				Diabetes diabetes = ConvertObject.convertToDiabetes(diabetesVo);
				list.add(diabetes);
				
				List<FollowMedicineRecord> follow = followMedicineRecordDao.findMedicineListByFollowId(record.getId());
				if(follow != null && follow.size() > 0){
					for(int j = 0; j < follow.size(); j++){
						FollowMedicineRecord med = follow.get(j);
						//主要用药情况
						TakeMedicineVo takeVo = new TakeMedicineVo();
						//设置Id
						String druguseName = "EHR_Arch_Druguse";
						IdTest idTest2 = new IdTest();
						String druguseId = idTest2.getId(druguseName, areaCode, duns, token, userId, compId);
						if(!StringUtil.isEmpty(druguseId)) {
							takeVo.setId(druguseId);
						}
						
						takeVo.setExamId(diabetesVo.getId());
						takeVo.setArchiveNo(record.getArchiveNo());
						takeVo.setIdNumber(record.getIdNumber());
						takeVo.setServiceName("SX0069_8");
						takeVo.setMedicineType(med.getMedicineType());
						takeVo.setMedicineName(med.getDrugName());
						takeVo.setMedicineUsage(med.getMedicineUsage());
						takeVo.setFrequency(med.getNum() == null?"":med.getNum().toString());
						takeVo.setMedicineDosage(med.getDosage());
						takeVo.setUnit(med.getUnit());
						takeVo.setMedicineTime(med.getMedicineTime());
						takeVo.setMedicineTimeUnit(med.getMedicineTimeUnit());
						takeVo.setMedicineCompliance(med.getMedicineCompliance());
						takeVo.setOther(med.getOther());
						takeVo.setCreateOrg(record.getCreateOrg());
						
						TakeMedicineCondition take = ConvertObject.convertToTakeMedicine(takeVo);
						list.add(take);
					}
				}				
				data.setBody(list);
				
				String reqXml = XmlUtils.modelToStringXML(data);
				reqXml = reqXml.replace("<body>", "<body><![CDATA[");
				reqXml = reqXml.replace("</body>", "]]></body>");
								
				String result = this.send(areaCode, duns, token, userId, functionCode, verifyCode, compId, reqXml);
				if(!"".equals(result)){
					Object r = XmlUtils.xmlToBean(result, ResponseXml.class);
					if(r != null){
						ResponseXml x = (ResponseXml)r;
						String errCode = x.getHeader().getErrCode();
						if("0".equals(errCode)){
							record.setUploadStatus(1);
							record.setUploadTime(new Date());
							
							diabetesFollowRecordDao.updateByPrimaryKeySelective(record);
						}else{
							System.out.println("msg =" + x.getHeader().getErrMsg());
							System.out.println("total =" + x.getBody().getRows_total());
							System.out.println("suc =" + x.getBody().getRows_suc());
							System.out.println("fail =" + x.getBody().getRows_faild());
							System.out.println("memo =" + x.getBody().getMemo());
						}
					}
				}
			}
		}
	}

	@Override
	public void hypertensionSync() {
		// TODO Auto-generated method stub
		List<Hypertension> hyperList = hypertensionDao.shanxiSyncList();
		if(hyperList != null && hyperList.size() > 0){
			for(int i = 0; i < hyperList.size(); i++){
				Hypertension record = hyperList.get(i);
				if(!record.getIdNumber().equals("612430195910072221")){
					continue;
				}
				Businessdata data = new Businessdata();

				Header header = new Header();
				header.setFunctioncode("HYPER_1001");
				header.setErrCode("0");
				header.setErrMsg("");
				header.setCmd("insert");
				data.setHeader(header);

				List<Object> list = new ArrayList<Object>();

				HypertensionVo hypertensionVo = new HypertensionVo();
				BeanUtils.copyProperties(record,hypertensionVo);
				
				String visitType = CodeConvert.visitTypeConvert(hypertensionVo.getVisitType());
				hypertensionVo.setVisitType(visitType);
				
				String symptom = hypertensionVo.getSymptom();
				if(StringUtil.isNotEmpty(symptom)){
					String symptomValue = "";
					String[] s = symptom.split(",");
					for(int k = 0; k < s.length; k++){
						if(StringUtil.isNotEmpty(s[k])){
							symptomValue = symptomValue + CodeConvert.hypertensionSymptomConvert(s[k]) + "|";					
						}
					}
					symptomValue = symptomValue.substring(0, symptomValue.length() - 1);
					
					hypertensionVo.setSymptom(symptomValue);
				}
				
				String visitClass = CodeConvert.visitClassConvert(hypertensionVo.getVisitClass());
				hypertensionVo.setVisitClass(visitClass);
				
				String drugObey = CodeConvert.complianceConvert(hypertensionVo.getDrugObey());
				hypertensionVo.setDrugObey(drugObey);
				
				String untowardEffect = CodeConvert.haveNotConvert(hypertensionVo.getUntowardEffect());
				hypertensionVo.setUntowardEffect(untowardEffect);
				
				String saltIntake = CodeConvert.saltIntakeConvert(hypertensionVo.getSaltIntake());
				hypertensionVo.setSaltIntake(saltIntake);
				
				String targetSaltIntake = CodeConvert.saltIntakeConvert(hypertensionVo.getTargetSaltIntake());
				hypertensionVo.setTargetSaltIntake(targetSaltIntake);
				
				if(StringUtil.isEmpty(hypertensionVo.getHeight())){
					hypertensionVo.setHeight("0");
				}
				
				if(StringUtil.isEmpty(hypertensionVo.getWeight())){
					hypertensionVo.setWeight("0");
				}
				
				String hypertensionName = "EHR_Dis_Hypertensionvisit";
				IdTest idTest = new IdTest();

				String areaCode = "6199";
				Organization o = organizationService.getOrganizationByCode(record.getCreateOrg());
				if(o != null){
					areaCode = o.getCountyCode();
				}

				String duns = record.getCreateOrg();

				String token = "123456";

				String userId = record.getCreateUser();
				User u = userService.findUserByCode(record.getCreateUser());
				if( u == null){
					u = userService.findUserByLoginName(record.getCreateUser());
				}
				if(u != null){
					if(StringUtil.isNotEmpty(u.getPubUsercode())){
						userId = u.getPubUsercode();
					}else{
						userId = u.getLoginName();
					}
				}
				
				String functionCode = "HYPER_1001";
				String verifyCode = "123456";
				String compId = "123";
				String hypertensionId = idTest.getId(hypertensionName, areaCode, duns, token, userId, compId);
				if (!StringUtil.isEmpty(hypertensionId)) {
					hypertensionVo.setId(hypertensionId);
				}


				com.zkhw.shanxi.bo.Hypertension hyper = ConvertObject.convertToHypertension(hypertensionVo);
				list.add(hyper);

				List<FollowMedicineRecord> follow = followMedicineRecordDao.findMedicineListByFollowId(record.getId());
				if(follow != null && follow.size() > 0){
					for(int j = 0; j < follow.size(); j++){
						FollowMedicineRecord med = follow.get(j);
						//主要用药情况
						TakeMedicineVo takeVo = new TakeMedicineVo();
						//设置Id
						String druguseName = "EHR_Arch_Druguse";
						IdTest idTest2 = new IdTest();
						
						String druguseId = idTest2.getId(druguseName, areaCode, duns, token, userId, compId);
						if(!StringUtil.isEmpty(druguseId)) {
							takeVo.setId(druguseId);
						}
						
						takeVo.setExamId(hypertensionId);
						takeVo.setArchiveNo(record.getArchiveNo());
						takeVo.setIdNumber(record.getIdNumber());
						takeVo.setServiceName("SX0069_6");
						takeVo.setMedicineType(med.getMedicineType());
						takeVo.setMedicineName(med.getDrugName());
						takeVo.setMedicineUsage(med.getMedicineUsage());
						takeVo.setFrequency(med.getNum() == null?"":med.getNum().toString());
						takeVo.setMedicineDosage(med.getDosage());
						takeVo.setUnit(med.getUnit());
						takeVo.setMedicineTime(med.getMedicineTime());
						takeVo.setMedicineTimeUnit(med.getMedicineTimeUnit());
						takeVo.setMedicineCompliance(med.getMedicineCompliance());
						takeVo.setOther(med.getOther());
						takeVo.setCreateOrg(record.getCreateOrg());
						
						TakeMedicineCondition take = ConvertObject.convertToTakeMedicine(takeVo);
						list.add(take);
					}
				}

				data.setBody(list);

				String reqXml = XmlUtils.modelToStringXML(data);
				reqXml = reqXml.replace("<body>", "<body><![CDATA[");
				reqXml = reqXml.replace("</body>", "]]></body>");
				System.out.println(reqXml);
				
				String result = this.send(areaCode, duns, token, userId, functionCode, verifyCode, compId, reqXml);
				if(!"".equals(result)){
					Object r = XmlUtils.xmlToBean(result, ResponseXml.class);
					if(r != null){
						ResponseXml x = (ResponseXml)r;
						String errCode = x.getHeader().getErrCode();
						if("0".equals(errCode)){
							record.setUploadStatus(1);
							record.setUploadTime(new Date());
							
							hypertensionDao.updateByPrimaryKeySelective(record);
						}else{
							System.out.println("msg =" + x.getHeader().getErrMsg());
							System.out.println("total =" + x.getBody().getRows_total());
							System.out.println("suc =" + x.getBody().getRows_suc());
							System.out.println("fail =" + x.getBody().getRows_faild());
							System.out.println("memo =" + x.getBody().getMemo());
						}
					}
				}
			}
		}
	}

	@Override
	public void tcmSync() {
		// TODO Auto-generated method stub
		List<ElderlyTcmRecord> tcmList = elderlyTcmRecordDao.shanxiSyncList();
		if(tcmList != null && tcmList.size() > 0){
			for(int i = 0; i < tcmList.size(); i++){
				ElderlyTcmRecord record = tcmList.get(i);
				String[] answers = record.getAnswerResult().split("\\|");
				
				
				Businessdata data = new Businessdata();
				Header header = new Header();
				header.setFunctioncode("OLD_HERB_1001");
				header.setErrCode("0");
				header.setErrMsg("");
				header.setCmd("insert");
				data.setHeader(header);

				List<Object> list = new ArrayList<Object>();

				ElderlyVo elderlyVo = new ElderlyVo();
				// 获取Id
				String oldHerbName = "EHR_Arch_OldHerb";
				IdTest idTest = new IdTest();

				String areaCode = "6199";
				Organization o = organizationService.getOrganizationByCode(record.getCreateOrg());
				if(o != null){
					areaCode = o.getCountyCode();
				}

				String duns = record.getCreateOrg();

				String token = "123456";

				String userId = record.getCreateUser();
				User u = userService.findUserByCode(record.getCreateUser());
				if( u == null){
					u = userService.findUserByLoginName(record.getCreateUser());
				}
				if(u != null){
					if(StringUtil.isNotEmpty(u.getPubUsercode())){
						userId = u.getPubUsercode();
					}else{
						userId = u.getLoginName();
					}
				}

				String functionCode = "OLD_HERB_1001";
				
				String verifyCode = "123456";

				String compId = "123";	
				String oldHerbId = idTest.getId(oldHerbName, areaCode, duns, token, userId, compId);
				if (!StringUtil.isEmpty(oldHerbId)) {
					elderlyVo.setId(oldHerbId);
				}

				elderlyVo.setIdNumber(record.getIdNumber());
				elderlyVo.setServiceid("");
				elderlyVo.setServicename("");
				elderlyVo.setName(record.getName());
				// 问询
				for(int j = 0; j < answers.length; j++){
					String[] result = answers[j].split(":");
					String name = "";
					switch (result[0]) {
					case "1":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsEnergeti(name);
						break;
					case "2":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsTired(name);
						break;
					case "3":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsLoseHeart(name);
						break;
					case "4":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsDeepVoice(name);
						break;	
					case "5":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsListless(name);
						break;
					case "6":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsJitter(name);
						break;	
					case "7":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsAlone(name);
						break;	
					case "8":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsScare(name);
						break;	
					case "9":
						name = CodeConvert.tcmBmiConvert(result[1]);
						elderlyVo.setIsHeavy(name);
						break;
					case "10":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsEyeDry(name);
						break;	
					case "11":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsExtreCold(name);
						break;
					case "12":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsAfaidCold(name);
						break;	
					case "13":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsResistCold(name);
						break;	
					case "14":
						name = CodeConvert.tcmColdConvert(result[1]);
						elderlyVo.setIsCatchCold(name);
						break;	
					case "15":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsSnorty(name);
						break;	
					case "16":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsStertorous(name);
						break;	
					case "17":
						name = CodeConvert.tcmAllergicConvert(result[1]);
						elderlyVo.setIsAllergic(name);
						break;	
					case "18":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsHives(name);
						break;	
					case "19":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsEndermicBlood(name);
						break;	
					case "20":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsScore(name);
						break;	
					case "21":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsFeverDry(name);
						break;	
					case "22":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsBodyPain(name);
						break;	
					case "23":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsFaceLight(name);
						break;	
					case "24":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsFleck(name);
						break;	
					case "25":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsTetter(name);
						break;	
					case "26":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsLikeDrink(name);
						break;	
					case "27":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsmouthBitter(name);
						break;	
					case "28":
						name = CodeConvert.tcmAbdominalCircumferenceConvert(result[1]);
						elderlyVo.setIfFat(name);
						break;	
					case "29":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsScareColdFood(name);
						break;	
					case "30":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsStoolStick(name);
						break;	
					case "31":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsStoolDry(name);
						break;	
					case "32":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsLinguaMassin(name);
						break;	
					case "33":
						name = CodeConvert.tcmConvert(result[1]);
						elderlyVo.setIsLinguaVein(name);
						break;							
					default:
						break;
					}
				}
																																				
				// 结果
				elderlyVo.setQixuzhiResult(CodeConvert.tcmTzResultConvert(record.getQixuzhiResult().toString()));
				elderlyVo.setYangxuzhiResult(CodeConvert.tcmTzResultConvert(record.getYangxuzhiResult().toString()));
				elderlyVo.setYinxuzhiResult(CodeConvert.tcmTzResultConvert(record.getYinxuzhiResult().toString()));
				elderlyVo.setTanshizhiResult(CodeConvert.tcmTzResultConvert(record.getTanshizhiResult().toString()));
				elderlyVo.setShirezhiResult(CodeConvert.tcmTzResultConvert(record.getShirezhiResult().toString()));
				elderlyVo.setXueyuzhiResult(CodeConvert.tcmTzResultConvert(record.getXueyuzhiResult().toString()));
				elderlyVo.setQiyuzhiResult(CodeConvert.tcmTzResultConvert(record.getQiyuzhiResult().toString()));
				elderlyVo.setTebingzhiResult(CodeConvert.tcmTzResultConvert(record.getTebingzhiResult().toString()));
				elderlyVo.setPinghezhiResult(CodeConvert.tcmPingheConvert(record.getPinghezhiResult().toString()));
				// 填表日期
				elderlyVo.setTestDate(record.getTestDate());
				elderlyVo.setTestDoctor(record.getTestDoctor());
				elderlyVo.setCreateOrg(record.getCreateOrg());
				// 得分
				elderlyVo.setQixuzhiScore(record.getQixuzhiScore());
				elderlyVo.setYangxuzhiScore(record.getYangxuzhiScore());
				elderlyVo.setYinxuzhiScore(record.getYinxuzhiScore());
				elderlyVo.setTanshizhiScore(record.getTanshizhiScore());
				elderlyVo.setShirezhiScore(record.getShirezhiScore());
				elderlyVo.setXueyuzhiScore(record.getXueyuzhiScore());
				elderlyVo.setQiyuzhiScore(record.getQiyuzhiScore());
				elderlyVo.setTebingzhiSorce(record.getTebingzhiSorce());
				elderlyVo.setPinghezhiSorce(record.getPinghezhiSorce());
				
				// 指导

				String guide = record.getTcmGuidance();
				if(StringUtil.isNotEmpty(guide)){
					String guideValue = "";
					String[] s = guide.split(",");
					Set<String> set = new HashSet<String>();
					for(int k = 0; k < s.length; k++){
						if(StringUtil.isNotEmpty(s[k])){
							boolean b = set.add(s[k]);
							if(b){
								guideValue = guideValue + CodeConvert.tcmGuidanceConvert(s[k]) + "|";	
							}
						}
					}
					guideValue = guideValue.substring(0, guideValue.length() - 1);
					
					elderlyVo.setQxz_guide(guideValue);
					elderlyVo.setYangxz_guide(guideValue);
					elderlyVo.setYinxz_guide(guideValue);
					elderlyVo.setTsz_guide(guideValue);
					elderlyVo.setSrz_guide(guideValue);
					elderlyVo.setXyz_guide(guideValue);
					elderlyVo.setQyz_guide(guideValue);
					elderlyVo.setTbz_guide(guideValue);
					elderlyVo.setPhz_guide(guideValue);
				}
				
				// 其他指导
				elderlyVo.setQxz_guide_other(record.getGuidanceOther());
				elderlyVo.setYangxz_guide_other(record.getGuidanceOther());
				elderlyVo.setYinxz_guide_other(record.getGuidanceOther());
				elderlyVo.setTsz_guide_other(record.getGuidanceOther());
				elderlyVo.setSrz_guide_other(record.getGuidanceOther());
				elderlyVo.setXyz_guide_other(record.getGuidanceOther());
				elderlyVo.setQyz_guide_other(record.getGuidanceOther());
				elderlyVo.setTbz_guide_other(record.getGuidanceOther());
				elderlyVo.setPhz_guide_other(record.getGuidanceOther());

				Elderly elderly = ConvertObject.convertToInsertElderly(elderlyVo);
				list.add(elderly);

				data.setBody(list);

				String reqXml = XmlUtils.modelToStringXML(data);
				reqXml = reqXml.replace("<body>", "<body><![CDATA[");
				reqXml = reqXml.replace("</body>", "]]></body>");
				System.out.println(reqXml);
				
				String result = this.send(areaCode, duns, token, userId, functionCode, verifyCode, compId, reqXml);
				if(!"".equals(result)){
					Object r = XmlUtils.xmlToBean(result, ResponseXml.class);
					if(r != null){
						ResponseXml x = (ResponseXml)r;
						String errCode = x.getHeader().getErrCode();
						if("0".equals(errCode)){
							record.setUploadStatus(1);
							record.setUploadTime(new Date());
							
							elderlyTcmRecordDao.updateByPrimaryKeySelective(record);
						}else{
							System.out.println("msg =" + x.getHeader().getErrMsg());
							System.out.println("total =" + x.getBody().getRows_total());
							System.out.println("suc =" + x.getBody().getRows_suc());
							System.out.println("fail =" + x.getBody().getRows_faild());
							System.out.println("memo =" + x.getBody().getMemo());
						}
					}
				}
			}
		}

	}

	@Override
	public void poorFollowSync() {
		// TODO Auto-generated method stub
		List<PoorFollowRecord> poorList = poorFollowRecordDao.shanxiSyncList();
		if(poorList != null && poorList.size() > 0){
			for(int i = 0; i < poorList.size(); i++){
				try{
					PoorFollowRecord record = poorList.get(i);
					
					JKFPVisitVo jkfpVisitVo = new JKFPVisitVo();	
					
					jkfpVisitVo.setArchiveNo(record.getArchiveNo());//纸质档案号
					jkfpVisitVo.setIdNumber(record.getIdNumber());//身份证号
					jkfpVisitVo.setName(record.getName());//姓名
					jkfpVisitVo.setSex(record.getSex());//性别
					jkfpVisitVo.setBirthday(record.getBirthday());//出生日期
					jkfpVisitVo.setVisitDate(record.getVisitDate());//本次随访日期
					jkfpVisitVo.setVisitType(record.getVisitType());//此次随访方式
					jkfpVisitVo.setVisitDoc(record.getVisitDoctor());//随访医生
					jkfpVisitVo.setGznr(record.getWorkInfo());//工作内容
					jkfpVisitVo.setAdvice(record.getAdvice());//评价与建议
					jkfpVisitVo.setCreateOrg(record.getCreateOrg());//机构码
					
					
					Businessdata data = new Businessdata();
					Header header = new Header();
					header.setFunctioncode("JKFP_VISIT_1001");
					header.setErrCode("0");
					header.setErrMsg("");
					header.setCmd("insert");
					data.setHeader(header);
					
					List<Object> list = new ArrayList<Object>();
					
					
					//获取Id
					String fpName = "FP_Visit";
					IdTest idTest = new IdTest();
					
					String areaCode = "6104";//6199
					Organization o = organizationService.getOrganizationByCode(record.getCreateOrg());
					if(o != null){
						areaCode = o.getCountyCode();
					}
					String duns = record.getCreateOrg();
					
					String token = "123456";
					
					String userId = record.getCreateUser();
					
					User u = userService.findUserByCode(record.getCreateUser());
					if( u == null){
						u = userService.findUserByLoginName(record.getCreateUser());
					}
					if(u != null){
						if(StringUtil.isNotEmpty(u.getPubUsercode())){
							userId = u.getPubUsercode();
						}else{
							userId = u.getLoginName();
						}
					}
					
					String functionCode = "JKFP_VISIT_1001";
					String verifyCode = "123456";
					String compId = "123";//企业的统一信用代码
					
					String fpNameId = idTest.getId(fpName, areaCode, duns, token, userId, compId);
					if(!StringUtil.isEmpty(fpNameId)) {
						jkfpVisitVo.setId(fpNameId);
					}
										
					
					JKFPVisit jkfpVisit = ConvertObject.convertToInsertJKFPVisit(jkfpVisitVo);
					list.add(jkfpVisit);
					
					data.setBody(list);
					
					String reqXml = XmlUtils.modelToStringXML(data);
					reqXml = reqXml.replace("<body>", "<body><![CDATA[");
					reqXml = reqXml.replace("</body>", "]]></body>");
					System.out.println(reqXml);
							
					
						
					String result = this.send(areaCode, duns, token, userId, functionCode, verifyCode, compId, reqXml);
					System.out.println(result);
					if(!"".equals(result)){
						Object r = XmlUtils.xmlToBean(result, ResponseXml.class);
						if(r != null){
							ResponseXml x = (ResponseXml)r;
							String errCode = x.getHeader().getErrCode();
							if("0".equals(errCode)){
								record.setUploadStatus(1);
								record.setUploadTime(new Date());
								
								poorFollowRecordDao.updateByPrimaryKeySelective(record);
							}else{
								System.out.println("msg =" + x.getHeader().getErrMsg());
								System.out.println("total =" + x.getBody().getRows_total());
								System.out.println("suc =" + x.getBody().getRows_suc());
								System.out.println("fail =" + x.getBody().getRows_faild());
								System.out.println("memo =" + x.getBody().getMemo());
							}
						}
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private void getResident(ResidentBaseInfo info, ResidentInfoTemp temp){
		try{
			Residentdata data = new Residentdata();
			Header header = new Header();
			header.setFunctioncode("ARCH_4003");
			header.setErrCode("0");
			header.setErrMsg("");
			data.setHeader(header);
			
			ResidentVo vo = new ResidentVo();
			vo.setTypeId("1");
			vo.setIdNumber(temp.getIdNumber());
			
			ResidentQuery resident = ConvertObject.convertToResident(vo);
	
			data.setBody(resident);
			
			String reqXml = XmlUtils.modelToStringXML(data);
			reqXml = reqXml.replace("<body>", "<body><![CDATA[");
			reqXml = reqXml.replace("</body>", "]]></body>");
			String areaCode = "6199";
			Organization corg = organizationService.getOrganizationByCode(temp.getCreateOrg());
			if(corg != null){
				areaCode = corg.getCountyCode();
			}
			String duns = temp.getCreateOrg();
			String token = "123456";
			String userId = temp.getCreateUser();
			User user = userService.findUserByCode(temp.getCreateUser());
			if( user == null){
				user = userService.findUserByLoginName(temp.getCreateUser());
			}
			if(user != null){
				if(StringUtil.isNotEmpty(user.getPubUsercode())){
					userId = user.getPubUsercode();
				}else{
					userId = user.getLoginName();
				}
			}
			String functionCode = "ARCH_4003";
			String verifyCode = "123456";
			String compId = "123";
			
			String result = this.send(areaCode, duns, token, userId, functionCode, verifyCode, compId, reqXml);
			if(!"".equals(result)){
				Object r = XmlUtils.xmlToBean(result, ResidentXml.class);
				if(r != null){
					ResidentXml x = (ResidentXml)r;
					String errCode = x.getHeader().getErrCode();
					if("0".equals(errCode)){
						ResidentBody body = x.getBody().getObjectInstance();
						if(body != null){
							BaseElement archive = body.getArchiveid();
							info.setPbArchive(archive.getValue());
							
							//BaseElement status = body.getArchstatus();
							
							BaseElement birth = body.getBirthday();
							if(birth != null){
								if(StringUtil.isNotEmpty(birth.getValue())){
									info.setBirthday(birth.getValue());
									info.setAge(DateUtil.getNominalAge(birth.getValue()));
								}
							}
							//BaseElement date = body.getBuild_date();
							BaseElement doc = body.getBuilddoctor();
							if(doc != null){
								if(StringUtil.isNotEmpty(doc.getValue())){											
									info.setCreateUser(doc.getValue());
									User u = userService.findUserByCode(doc.getValue());
									if(u != null){
										info.setCreateName(u.getUserName());
									}
								}
							}
							
							//body.getCuraddr_committee();									
							BaseElement address = body.getCuraddr_doorno();
							if(address != null){
								if(StringUtil.isNotEmpty(address.getValue())){
									info.setResidenceAddress(address.getValue());;
								}
							}
	
							BaseElement dm = body.getDisdmflag();
							if(dm != null){
								if(StringUtil.isNotEmpty(dm.getValue())){
									if("1".equals(dm.getValue())){
										info.setIsDiabetes(1);
									}else{
										info.setIsDiabetes(0);
									}
									
								}
							}									
							//body.getDisheartflag();
							
							BaseElement hyper = body.getDishyperflag();
							if(hyper != null){
								if(StringUtil.isNotEmpty(hyper.getValue())){											
									if("1".equals(hyper.getValue())){
										info.setIsHypertension(1);
									}else{
										info.setIsHypertension(0);
									}
								}
							}
							BaseElement org = body.getDuns();	
							if(org != null){
								if(StringUtil.isNotEmpty(org.getValue())){
									info.setCreateOrg(org.getValue());
									Organization o = organizationService.getOrganizationByCode(org.getValue());
									if(o != null){
										info.setCreateOrgName(o.getOrganName());
									}
								}
							}
							
							BaseElement dutydoc = body.getDutydoctor();
							if(dutydoc != null){
								if(StringUtil.isNotEmpty(dutydoc.getValue())){											
									info.setDoctorId(dutydoc.getValue());
									User u = userService.findUserByCode(dutydoc.getValue());
									if(u != null){
										info.setDoctorName(dutydoc.getValue());
									}
								}
							}
							//body.getFullname();
							//body.getGender();
							//body.getIdentityno();
							//body.getResaddr_committee();
							
							BaseElement resadd = body.getResaddr_doorno();
							if(resadd != null){
								if(StringUtil.isNotEmpty(resadd.getValue())){
									info.setRegisterAddress(resadd.getValue());
								}
							}									
	
							BaseElement tel = body.getTel();
							if(tel != null){
								if(StringUtil.isNotEmpty(tel.getValue())){
									info.setPhone(tel.getValue());
								}
							}	
							
							BaseElement sign = body.getIsSign();
							if(sign != null){
								if(StringUtil.isNotEmpty(sign.getValue())){
									info.setIsSigning(Integer.parseInt(sign.getValue()));
								}
							}
							
							BaseElement poor = body.getIsSign();
							if(poor != null){
								if(StringUtil.isNotEmpty(poor.getValue())){
									if("SX0083_1".equals(poor.getValue())){
										info.setIsPoor(1);
									}else{
										info.setIsPoor(0);
									}
								}
							}
						}
						
					}
				}else{
					Businessdata udata = new Businessdata();
					Header uheader = new Header();
					uheader.setFunctioncode("ARCH_1002");
					uheader.setErrCode("0");
					uheader.setErrMsg("");
					uheader.setCmd("insert");
					data.setHeader(uheader);
					
					List<Object> ulist = new ArrayList<Object>();
					
					ResidentVo residentVo = new ResidentVo();
					//获取Id
					String basicinfoName = "EHR_Arch_Basicinfo";
					IdTest idTest = new IdTest();
					String basicinfoId = idTest.getId(basicinfoName, areaCode, duns, token, userId, compId);
					if(!StringUtil.isEmpty(basicinfoId)) {
						residentVo.setId(basicinfoId);
					}
					
					residentVo.setArchiveNo(info.getArchiveNo());//纸质档案号
					residentVo.setName(info.getName());//姓名
					residentVo.setSex("1");//性别
					residentVo.setBirthday(info.getBirthday());//出生日期
					residentVo.setIdNumber(info.getIdNumber());//身份证号
					//residentVo.setRegisterAddress("123265");//户籍所在地(省市区的六位号码字段)
					residentVo.setRegisterAddressDoor(info.getRegisterAddress());// 户籍所在地(门牌号)
					//residentVo.setResidenceAddress("123265");//现住址(省市区的六位号码字段)
					residentVo.setResidenceAddressDoor(info.getResidenceAddress());//现住址(门牌号)
					residentVo.setCompany(info.getCompany());
					residentVo.setPhone(info.getPhone());//电话 
					residentVo.setLinkName(info.getLinkName());//联系人 
					residentVo.setLinkPhone(info.getLinkPhone());//联系人电话
					residentVo.setResidentType("户籍");//常住类型
					residentVo.setNation("汉");//民族
					residentVo.setMedicalCode(info.getMedicalCode());//健康卡号
					residentVo.setDoctorName(info.getDoctorId());//责任医生
					residentVo.setIsPoor(1);//是否贫困
					residentVo.setCreateTime(DateUtil.getTodayString());//建档日期
					residentVo.setCreateName(info.getCreateUser());//建档医生
					residentVo.setRemark(info.getRemark());//备注
					residentVo.setAichiveOrg(info.getCreateOrg());//建档机构
					
					Resident res = ConvertObject.convertToInsertResident(residentVo);
					ulist.add(res);
					
					udata.setBody(ulist);
					
					String ureqXml = XmlUtils.modelToStringXML(data);
					ureqXml = ureqXml.replace("<body>", "<body><![CDATA[");
					ureqXml = ureqXml.replace("</body>", "]]></body>");
					System.out.println(ureqXml);
					
					
					String uareaCode = "6199";
					
					String uduns = "61990011X1009";
					
					String utoken = "123456";
					
					String uuserId = "610404197712260672";
					
					String uverifyCode = "123456";
					
					String ufunctionCode = "ARCH_1002";
					
					String ucompId = "123";
					
					String uresult = this.send(uareaCode, uduns, utoken, uuserId, ufunctionCode, uverifyCode, ucompId, ureqXml);
					if(!"".equals(uresult)){
						Object ur = XmlUtils.xmlToBean(result, ResponseXml.class);
						if(ur != null){
							ResponseXml x = (ResponseXml)ur;
							String errCode = x.getHeader().getErrCode();
							if("0".equals(errCode)){
							}else{
								System.out.println("msg =" + x.getHeader().getErrMsg());
								System.out.println("total =" + x.getBody().getRows_total());
								System.out.println("suc =" + x.getBody().getRows_suc());
								System.out.println("fail =" + x.getBody().getRows_faild());
								System.out.println("memo =" + x.getBody().getMemo());
							}
						}
					}							
				}
			}					
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
