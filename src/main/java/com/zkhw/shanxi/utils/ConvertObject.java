package com.zkhw.shanxi.utils;

import java.util.HashMap;
import java.util.Map;

import com.zkhw.shanxi.bo.BaseElement;
import com.zkhw.shanxi.bo.CheckRecord;
import com.zkhw.shanxi.bo.CheckResult;
import com.zkhw.shanxi.bo.DangerDisease;
import com.zkhw.shanxi.bo.Diabetes;
import com.zkhw.shanxi.bo.Elderly;
import com.zkhw.shanxi.bo.Examination;
import com.zkhw.shanxi.bo.FamilyPractice;
import com.zkhw.shanxi.bo.Glucose;
import com.zkhw.shanxi.bo.Hospitalized;
import com.zkhw.shanxi.bo.Hypertension;
import com.zkhw.shanxi.bo.JKFPVisit;
import com.zkhw.shanxi.bo.Ncg;
import com.zkhw.shanxi.bo.OldHguide;
import com.zkhw.shanxi.bo.Oxygen;
import com.zkhw.shanxi.bo.Resident;
import com.zkhw.shanxi.bo.ResidentQuery;
import com.zkhw.shanxi.bo.TakeMedicineCondition;
import com.zkhw.shanxi.bo.Temperature;
import com.zkhw.shanxi.bo.Tolic;
import com.zkhw.shanxi.bo.Vaccination;
import com.zkhw.shanxi.bo.Xdt;
import com.zkhw.shanxi.vo.CheckRecordVo;
import com.zkhw.shanxi.vo.CheckResultVo;
import com.zkhw.shanxi.vo.DangerDiseaseVo;
import com.zkhw.shanxi.vo.DiabetesVo;
import com.zkhw.shanxi.vo.ElderlyVo;
import com.zkhw.shanxi.vo.ExaminationVo;
import com.zkhw.shanxi.vo.GlucoseVo;
import com.zkhw.shanxi.vo.HospitalizedVo;
import com.zkhw.shanxi.vo.HypertensionVo;
import com.zkhw.shanxi.vo.JKFPVisitVo;
import com.zkhw.shanxi.vo.NcgVo;
import com.zkhw.shanxi.vo.OldHguideVo;
import com.zkhw.shanxi.vo.OxygenVo;
import com.zkhw.shanxi.vo.ResidentVo;
import com.zkhw.shanxi.vo.TakeMedicineVo;
import com.zkhw.shanxi.vo.TemperatureVo;
import com.zkhw.shanxi.vo.TolicVo;
import com.zkhw.shanxi.vo.VaccinationVo;
import com.zkhw.shanxi.vo.XdtVo;

public class ConvertObject {

	public static Examination convertExam(ExaminationVo vo) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("checkFlag", vo.getCheckFlag());
		map.put("archiveId", vo.getArchiveNo());
		//map.put("archiveId", vo.getIdNumber());
		map.put("checkdate", vo.getCheckDate());
		map.put("dutydoctor", vo.getDutydoctor());
		map.put("symptom", vo.getSymptom());
		map.put("symptom_other", vo.getSymptomOther());
		map.put("heat", vo.getBaseTemperature());
		map.put("cardiotach_ometer", vo.getBaseHeartbeat());
		map.put("breath_count", vo.getBaseRespiratory());
		map.put("leftdbp", vo.getBaseBloodPressureLeftLow() == null ? "" : vo.getBaseBloodPressureLeftLow().toString());
		map.put("leftsbp",
				vo.getBaseBloodPressureLeftHigh() == null ? "" : vo.getBaseBloodPressureLeftHigh().toString());
		map.put("rightdbp",
				vo.getBaseBloodPressureRightLow() == null ? "" : vo.getBaseBloodPressureRightLow().toString());
		map.put("rightsbp",
				vo.getBaseBloodPressureRightHigh() == null ? "" : vo.getBaseBloodPressureRightHigh().toString());
		map.put("height", vo.getBaseHeight());
		map.put("weight", vo.getBaseWeight());
		map.put("waistline", vo.getBaseWaist());
		map.put("bmi", vo.getBaseBmi());
		map.put("healthstate", vo.getBaseHealthEstimate());
		map.put("livingstate", vo.getBaseSelfcareEstimate());
		map.put("assessId", vo.getAssessId());
		map.put("oldkown", vo.getBaseCognitionEstimate());
		map.put("oldkown_fee", vo.getBaseCognitionScore());
		map.put("oldfeeling", vo.getBaseFeelingEstimate());
		map.put("oldfeeling_fee", vo.getBaseFeelingScore());
		map.put("exercise_frequency", vo.getLifewayExerciseFrequency());
		map.put("exercise_timeslice", vo.getLifewayExerciseTime());
		map.put("persisttime", vo.getLifewayExerciseYear());
		map.put("exercise_method", vo.getLifewayExerciseType());
		map.put("eat_habit", vo.getLifewayDiet());
		map.put("smoke_frequency", vo.getLifewaySmokeStatus());
		map.put("smoke_count_day", vo.getLifewaySmokeNumber());
		map.put("smoke_start_age", vo.getLifewaySmokeStartage());
		map.put("smoke_end_age", vo.getLifewaySmokeEndage());
		map.put("wine_frequency", vo.getLifewayDrinkStatus());
		map.put("wine_count", vo.getLifewayDrinkNumber());
		map.put("wine_refrain", vo.getLifewayDrinkStop());
		map.put("wine_refrain_age", vo.getLifewayDrinkStopage());
		map.put("wine_start_age", vo.getLifewayDrinkStartage());
		map.put("isstoned", vo.getLifewayDrinkOneyear());
		map.put("wine_type", vo.getLifewayDrinkType());
		map.put("wine_other", vo.getLifewayDrinkOther());
		map.put("undress", vo.getLifewayOccupationalDisease());
		map.put("undress_work", vo.getLifewayJob());
		map.put("undress_worktime", vo.getLifewayJobPeriod());
		map.put("lip", vo.getOrganLips());
		map.put("tooth", vo.getOrganTooth());
		map.put("toothless_top", vo.getOrganHypodontiaTopleft());
		map.put("toothless_down", vo.getOrganHypodontiaBottomright());
		map.put("toothless_left", vo.getOrganHypodontiaBottomleft());
		map.put("toothless_right", vo.getOrganHypodontiaTopright());
		map.put("decayedtooth_top", vo.getOrganCariesTopleft());
		map.put("decayedtooth_down", vo.getOrganCariesBottomright());
		map.put("decayedtooth_left", vo.getOrganCariesBottomleft());
		map.put("decayedtooth_right", vo.getOrganCariesTopright());
		map.put("falsetooth_top", vo.getOrganDentureTopleft());
		map.put("falsetooth_down", vo.getOrganDentureBottomright());
		map.put("falsetooth_left", vo.getOrganDentureBottomleft());
		map.put("falsetooth_right", vo.getOrganDentureTopright());
		map.put("yanbu", vo.getOrganGuttur());
		map.put("eye_nakedness_left", vo.getOrganVisionLeft());
		map.put("eye_nakedness_right", vo.getOrganVisionRight());
		map.put("eye_remedy_left", vo.getOrganCorrectedvisionLeft());
		map.put("eye_remedy_right", vo.getOrganCorrectedvisionRight());
		map.put("audition", vo.getOrganHearing());
		map.put("sport_fun", vo.getOrganMovement());
		map.put("fundus", vo.getExaminationEye());
		map.put("fundus_other", vo.getExaminationEyeOther());
		map.put("skin", vo.getExaminationSkin());
		map.put("skin_other", vo.getExaminationSkinOther());
		map.put("sclera", vo.getExaminationSclera());
		map.put("sclera_other", vo.getExaminationScleraOther());
		map.put("lymph", vo.getExaminationLymph());
		map.put("lymph_other", vo.getExaminationLymphOther());
		map.put("barrel_chest", vo.getExaminationBarrelChest());
		map.put("breathing", vo.getExaminationBreathSounds());
		map.put("breathing_other", vo.getExaminationBreastOther());
		map.put("rales", vo.getExaminationRale());
		map.put("rales_other", vo.getExaminationRaleOther());
		map.put("heart_rate", vo.getExaminationHeartRate());
		map.put("rhythm", vo.getExaminationHeartRhythm());
		map.put("noise", vo.getExaminationHeartNoise());
		map.put("noise_memo", vo.getExaminationNoiseOther());
		map.put("tenderness", vo.getExaminationAbdomenTenderness());
		map.put("tenderness_memo", vo.getExaminationTendernessMemo());
		map.put("mass", vo.getExaminationAbdomenMass());
		map.put("mass_memo", vo.getExaminationMassMemo());
		map.put("liver", vo.getExaminationAbdomenHepatomegaly());
		map.put("liver_memo", vo.getExaminationHepatomegalyMemo());
		map.put("spleen", vo.getExaminationAbdomenSplenomegaly());
		map.put("spleen_memo", vo.getExaminationSplenomegalyMemo());
		map.put("dullness", vo.getExaminationAbdomenShiftingdullness());
		map.put("dullness_memo", vo.getExaminationShiftingdullnessMemo());
		map.put("edema", vo.getExaminationLowerextremityEdema());
		map.put("dorsal", vo.getExaminationDorsalArtery());
		map.put("dre", vo.getExaminationAnus());
		map.put("dre_memo", vo.getExaminationAnusOther());
		map.put("breast", vo.getExaminationBreast());
		map.put("breast_memo", vo.getExaminationBreastOther());
		map.put("vulva", vo.getExaminationWomanVulva());
		map.put("vulva_memo", vo.getExaminationVulvaMemo());
		map.put("vaginal", vo.getExaminationWomanVagina());
		map.put("vaginal_memo", vo.getExaminationVaginaMemo());
		map.put("cervixed", vo.getExaminationWomanCervix());
		map.put("cervix_memo", vo.getExaminationCervixMemo());
		map.put("palace", vo.getExaminationWomanCorpus());
		map.put("palace_memo", vo.getExaminationCorpusMemo());
		map.put("attachment", vo.getExaminationWomanAccessories());
		map.put("attachment_memo", vo.getExaminationAccessoriesMemo());
		map.put("examination_memo", vo.getExaminationOther());
		map.put("hemoglobined", vo.getBloodHemoglobin());
		map.put("leukocyte", vo.getBloodLeukocyte());
		map.put("platelet", vo.getBloodPlatelet());
		map.put("blood_memo", vo.getBloodOther());
		map.put("urinary_protein", vo.getUrineProtein());
		map.put("urine", vo.getGlycosuria());
		map.put("ketone", vo.getUrineAcetoneBodies());
		map.put("occult_blood", vo.getBld());
		map.put("urine_memo", vo.getUrineOther());
		map.put("bsugar_mmo", vo.getBloodGlucoseMmol());
		map.put("bsugar_mg", vo.getBloodGlucoseMg());
		map.put("ecg", vo.getCardiogram());
		map.put("ecg_memo", vo.getCardiogramMemo());
		map.put("urinary_albumin", vo.getMicroalbuminuria());
		map.put("occult_blooded", vo.getFob());
		map.put("hemoglobin", vo.getGlycosylatedHemoglobin());
		map.put("hbeag", vo.getHb());
		map.put("alt", vo.getSgft());
		map.put("ast", vo.getAst());
		map.put("albumin", vo.getAlbumin());
		map.put("bilirubin_total", vo.getTotalBilirubin());
		map.put("bilirubin_combine", vo.getConjugatedBilirubin());
		map.put("scr", vo.getScr());
		map.put("bun", vo.getBloodUrea());
		map.put("potassium", vo.getBloodK());
		map.put("serum_sodium", vo.getBloodNa());
		map.put("cholesterol", vo.getTc());
		map.put("triglycerides", vo.getTg());
		map.put("h_cholesterol", vo.getLdl());
		map.put("l_cholesterol", vo.getHdl());
		map.put("xray", vo.getChestX());
		map.put("xray_memo", vo.getXMemo());
		map.put("bultrasound", vo.getUltrasoundAbdomen());
		map.put("bultrasound_memo", vo.getUltrasoundMemo());
		map.put("bsound", vo.getOtherB());
		map.put("bsound_memo", vo.getOtherbMemo());
		map.put("cervix", vo.getCervicalSmear());
		map.put("cervix_Explain", vo.getCervicalSmearMemo());
		map.put("check_other", vo.getOther());
		map.put("physique_phz", vo.getTcmPhz());
		map.put("physique_qxz", vo.getTcmQxz());
		map.put("physique_yangxz", vo.getTcmYangxz());
		map.put("physique_yinxz", vo.getTcmYinxz());
		map.put("physique_tsz", vo.getTcmTsz());
		map.put("physique_srz", vo.getTcmSrz());
		map.put("physique_xyz", vo.getTcmXyz());
		map.put("physique_qyz", vo.getTcmQyz());
		map.put("physique_tbz", vo.getTcmTbz());
		map.put("cerebrovascular", vo.getCerebrovascularDisease());
		map.put("cerebrovascular_memo", vo.getCerebrovascularDiseaseOther());
		map.put("kidney", vo.getKidneyDisease());
		map.put("kidney_other", vo.getKidneyDiseaseOther());
		map.put("heartdis", vo.getHeartDisease());
		map.put("heartdis_other", vo.getHeartDiseaseOther());
		map.put("blooddis", vo.getVascularDisease());
		map.put("blooddis_other", vo.getVascularDiseaseOther());
		map.put("eysdis", vo.getOcularDiseases());
		map.put("eysdis_other", vo.getOcularDiseasesOther());
		map.put("nervousdis", vo.getNervousSystemDisease());
		map.put("nervousdis_memo", vo.getNervousDiseaseMemo());
		map.put("hasotherdis", vo.getOtherDisease());
		map.put("otherdismemo", vo.getOtherDiseaseMemo());
		map.put("checkresult", vo.getHealthEvaluation());
		map.put("healthesti", vo.getAbnormal1() + vo.getAbnormal2() + vo.getAbnormal3() + vo.getAbnormal4());
		map.put("healthguide", vo.getHealthGuidance());
		map.put("dangercontrol", vo.getDangerControlling());
		map.put("weighttarget", vo.getTargetWeight());
		map.put("advisebacterin", vo.getAdviseBacterin());
		map.put("otherdanger", vo.getDangerControllingOther());
		map.put("healthadvice", vo.getHealthAdvice());
		map.put("duns", vo.getCreateOrg());

		Examination exam = new Examination();
		exam.setId(vo.getId());
		String[] f = ReflectionUtils.getFiledName(exam);
		for (int i = 0; i < f.length; i++) {
			if (!"id".equals(f[i]) && !"name".equals(f[i])) {
				BaseElement e = new BaseElement();
				e.setName(f[i]);
				e.setValue(map.get(f[i]));
				ReflectionUtils.setFieldValueByFieldName(f[i], exam, e);
			}
		}

		return exam;
	}

	public static Hospitalized convertToHospitalized(HospitalizedVo vo) {

		Map<String, String> map = new HashMap<String, String>();

		// map.put("archiveId", vo.getArchiveNo());
		map.put("archiveId", vo.getIdNumber());
		map.put("serviceName", vo.getServiceName());
		map.put("serviceId", vo.getExamId());
		map.put("inDate", vo.getInHospitalTime());
		map.put("outDate", vo.getLeaveHospitalTime());
		map.put("reason", vo.getReason());
		map.put("hospitalName", vo.getHospitalOrgan());
		map.put("inpNo", vo.getCaseCode());
		map.put("remark", vo.getRemark());
		map.put("duns", vo.getCreateOrg());

		Hospitalized hosp = new Hospitalized();
		hosp.setInprecordId(vo.getId());
		String[] f = ReflectionUtils.getFiledName(hosp);
		for (int i = 0; i < f.length; i++) {
			if (!"inprecordId".equals(f[i]) && !"name".equals(f[i])) {
				BaseElement e = new BaseElement();
				e.setName(f[i]);
				e.setValue(map.get(f[i]));
				ReflectionUtils.setFieldValueByFieldName(f[i], hosp, e);
			}
		}
		return hosp;
	}

	public static FamilyPractice convertToFamilyPractice(HospitalizedVo vo) {

		Map<String, String> map = new HashMap<String, String>();

		// map.put("archiveid", vo.getArchiveNo());
		map.put("archiveid", vo.getIdNumber());
		map.put("servicename", vo.getServiceName());
		map.put("serviceid", vo.getExamId());
		map.put("indate", vo.getInHospitalTime());
		map.put("outdate", vo.getLeaveHospitalTime());
		map.put("reason", vo.getReason());
		map.put("hospitalname", vo.getHospitalOrgan());
		map.put("inpno", vo.getCaseCode());
		map.put("remark", vo.getRemark());
		map.put("duns", vo.getCreateOrg());

		FamilyPractice family = new FamilyPractice();
		family.setId(vo.getId());
		String[] f = ReflectionUtils.getFiledName(family);
		for (int i = 0; i < f.length; i++) {
			if (!"id".equals(f[i]) && !"name".equals(f[i])) {
				BaseElement e = new BaseElement();
				e.setName(f[i]);
				e.setValue(map.get(f[i]));
				ReflectionUtils.setFieldValueByFieldName(f[i], family, e);
			}
		}
		return family;
	}

	public static TakeMedicineCondition convertToTakeMedicine(TakeMedicineVo vo) {

		Map<String, String> map = new HashMap<String, String>();

		// map.put("archiveid", vo.getArchiveNo());
		map.put("archiveid", vo.getIdNumber());
		map.put("servicename", vo.getServiceName());
		map.put("serviceid", vo.getExamId());
		map.put("drugtype", vo.getMedicineType());
		map.put("drugname", vo.getMedicineName());
		map.put("usage", vo.getMedicineUsage());
		map.put("frequency", vo.getFrequency());
		map.put("amount", vo.getMedicineDosage());
		map.put("unit", vo.getUnit());
		map.put("useyears", vo.getMedicineTime());
		map.put("useyearsunit", vo.getMedicineTimeUnit());
		map.put("drugcompliance", vo.getMedicineCompliance());
		map.put("other", vo.getOther());
		map.put("duns", vo.getCreateOrg());

		TakeMedicineCondition take = new TakeMedicineCondition();
		take.setId(vo.getId());
		String[] f = ReflectionUtils.getFiledName(take);
		for (int i = 0; i < f.length; i++) {
			if (!"id".equals(f[i]) && !"name".equals(f[i])) {
				BaseElement e = new BaseElement();
				e.setName(f[i]);
				e.setValue(map.get(f[i]));
				ReflectionUtils.setFieldValueByFieldName(f[i], take, e);
			}
		}
		return take;
	}

	public static Vaccination convertToVaccination(VaccinationVo vo) {

		Map<String, String> map = new HashMap<String, String>();

		// map.put("archiveId", vo.getArchiveNo());
		map.put("serviceName", vo.getServiceName());
		map.put("serviceId", vo.getExamId());
		map.put("archiveid", vo.getIdNumber());
		map.put("cardID", vo.getCardId());
		map.put("bacterinType", vo.getVaccinationType());
		map.put("bacterinid", vo.getVaccinationId());
		map.put("bacterinname", vo.getVaccinationName());
		map.put("acuscount", vo.getAcuscount());
		map.put("dose", vo.getDose());
		map.put("description", vo.getDescnption());
		map.put("inocustate", vo.getInocuState());
		map.put("sinocudate", vo.getSinocuDate());
		map.put("inocudoctor", vo.getInocuDoctor());
		map.put("registerperson", vo.getRegisterPerson());
		map.put("inocudate", vo.getVaccinationTime());
		map.put("dzjgm", vo.getDzjgm());
		map.put("batchnumber", vo.getBatchNumber());
		map.put("county", vo.getCounty());
		map.put("inoculationsite", vo.getInoculationSite());
		map.put("inoculationway", vo.getInoculationWay());
		map.put("inoculateDuns", vo.getVaccinationOrgan());
		map.put("inoculateDunsName", vo.getVaccinationOrganName());
		map.put("remark", vo.getRemark());
		map.put("validdate", vo.getValiddate());
		map.put("manufacturer", vo.getManufacturer());
		map.put("manufactCode", vo.getManufactCode());
		map.put("inputDate", vo.getInputDate());
		map.put("duns", vo.getVaccinationOrgan());

		Vaccination vaccina = new Vaccination();
		vaccina.setId(vo.getId());
		String[] f = ReflectionUtils.getFiledName(vaccina);
		for (int i = 0; i < f.length; i++) {
			if (!"id".equals(f[i]) && !"name".equals(f[i])) {
				BaseElement e = new BaseElement();
				e.setName(f[i]);
				e.setValue(map.get(f[i]));
				ReflectionUtils.setFieldValueByFieldName(f[i], vaccina, e);
			}
		}
		return vaccina;
	}
	
	
	
	public static DangerDisease convertToDangerDisease(DangerDiseaseVo vo) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("archiveId", vo.getArchiveId());
		map.put("serviceName", vo.getServiceName());
		map.put("serviceId", vo.getServiceId());
		map.put("poisonType", vo.getPoisonType());
		map.put("poisonContent", vo.getPoisonContent());
		map.put("hasfense", vo.getHasfense());
		map.put("fenseContent", vo.getFenseContent());
		map.put("remark", vo.getRemark());
		map.put("duns", vo.getDuns());

		DangerDisease dangerDisease = new DangerDisease();
		dangerDisease.setId(vo.getId());
		String[] f = ReflectionUtils.getFiledName(dangerDisease);
		for (int i = 0; i < f.length; i++) {
			if (!"id".equals(f[i]) && !"name".equals(f[i])) {
				BaseElement e = new BaseElement();
				e.setName(f[i]);
				e.setValue(map.get(f[i]));
				ReflectionUtils.setFieldValueByFieldName(f[i], dangerDisease, e);
			}
		}
		return dangerDisease;
	}
	
	
	
	
	

	/**
	 * 尿常规
	 * 
	 * @param vo
	 * @return
	 */
	public static Ncg convertToNcg(NcgVo vo) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("ExamID", vo.getAichiveNo());
		map.put("Leu", vo.getLeu());
		map.put("Nit", vo.getNit());
		map.put("Ubg", vo.getUro());
		map.put("Pro", vo.getPro());
		map.put("Ph", vo.getPh());
		map.put("Bld", vo.getBld());
		map.put("Sg", vo.getSg());
		map.put("Ket", vo.getKet());
		map.put("Bil", vo.getBil());
		map.put("Glu", vo.getGlu());
		map.put("Vc", vo.getVc());
		map.put("Img", vo.getImg());// 图片
		map.put("archiveId", vo.getIdNumber());
		map.put("CardNo", vo.getIdNumber());
		map.put("Name", vo.getName());// 姓名
		map.put("Phone", vo.getPhone());// 联系方式
		map.put("HealthNO", vo.getHealthNO());// 健康卡号
		map.put("duns", vo.getOrganName());// 机构
		map.put("created_By", vo.getCreateName());// 创建者
		map.put("created_Date", vo.getCreateTime());// 创建时间
		map.put("updated_By", vo.getUpdateName());// 修改者
		map.put("updated_Date", vo.getUpdateTime());// 修改时间
		map.put("dataResType", vo.getDataResType());// 数据源类型
		map.put("sSupplierCode", vo.getSSupplierCode());// 设备供应商
		map.put("sMachineCode", vo.getSMachineCode());// 设备编码
		map.put("IsSuccess", vo.getIsSuccess());// 是否上传成功
		map.put("uploadTime", vo.getUploadTime());// 上传时间
		map.put("errReason", vo.getErrReason()); // 上传失败原因

		Ncg ncg = new Ncg();
		ncg.setId(vo.getId());
		String[] f = ReflectionUtils.getFiledName(ncg);
		for (int i = 0; i < f.length; i++) {
			if (!"id".equals(f[i]) && !"name".equals(f[i])) {
				BaseElement e = new BaseElement();
				e.setName(f[i]);
				e.setValue(map.get(f[i]));
				ReflectionUtils.setFieldValueByFieldName(f[i], ncg, e);
			}
		}
		return ncg;
	}

	/**
	 * 心电图
	 * 
	 * @param vo
	 * @return
	 */
	public static Xdt convertToXdt(XdtVo vo) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("ExamID", vo.getExamID());// 主键（引用检查记录表ID）
		map.put("HeartRate", vo.getHeartRate());// 心率(未检测录入0)
		map.put("ECGData", vo.getECGData());// 心电数据（采样数据值逗号隔开）
		map.put("ECGResult", vo.getXdtresult());// 心电结果（逗号隔开）
		map.put("ECGImg", vo.getImageurl());// 心电图片（二进制数据字符串）
		map.put("ECGUrl", vo.getECGUrl());// 心电图浏览地址（浏览地址Url）

		map.put("archiveId", vo.getIdNumber());// 个人档案Id
		map.put("CardNo", vo.getIdNumber());// 被检查者身份证号
		map.put("Name", vo.getName());// 姓名
		map.put("Phone", vo.getPhone());// 联系方式
		map.put("HealthNO", vo.getHealthNO());// 健康卡号
		map.put("duns", vo.getOrganName());// 机构
		map.put("created_By", vo.getCreateName());// 创建者
		map.put("created_Date", vo.getCreateTime());// 创建时间
		map.put("updated_By", vo.getUpdateName());// 修改者
		map.put("updated_Date", vo.getUpdateTime());// 修改时
		map.put("dataResType", vo.getDataResType());// 数据源类型
		map.put("sSupplierCode", vo.getSSupplierCode());// 设备供应商
		map.put("sMachineCode", vo.getSMachineCode());// 设备编码
		map.put("IsSuccess", vo.getIsSuccess());// 是否上传成功
		map.put("uploadTime", vo.getUploadTime());// 上传时间
		map.put("errReason", vo.getErrReason()); // 上传失败原因

		Xdt xdt = new Xdt();
		xdt.setId(vo.getId());
		String[] f = ReflectionUtils.getFiledName(xdt);
		for (int i = 0; i < f.length; i++) {
			if (!"id".equals(f[i]) && !"name".equals(f[i])) {
				BaseElement e = new BaseElement();
				e.setName(f[i]);
				e.setValue(map.get(f[i]));
				ReflectionUtils.setFieldValueByFieldName(f[i], xdt, e);
			}
		}
		return xdt;
	}

	/**
	 * 体温
	 * 
	 * @param vo
	 * @return
	 */
	public static Temperature convertToTem(TemperatureVo vo) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("ExamID", vo.getExamID());// 主键（引用检查记录表ID）
		map.put("Temperature", vo.getTemperature());// 体温
		map.put("archiveId", vo.getIdNumber());// 个人档案Id
		map.put("CardNo", vo.getIdNumber());// 被检查者身份证号
		map.put("Name", vo.getName());// 姓名
		map.put("Phone", vo.getPhone());// 联系方式
		map.put("HealthNO", vo.getHealthNO());// 健康卡号
		map.put("duns", vo.getOrganName());// 机构
		map.put("created_By", vo.getCreateName());// 创建者
		map.put("created_Date", vo.getCreateTime());// 创建时间
		map.put("updated_By", vo.getUpdateName());// 修改者
		map.put("update_Date", vo.getUpdateTime());// 修改时间
		map.put("dateResType", vo.getDataResType());// 数据源类型
		map.put("sSupplierCode", vo.getSSupplierCode());// 设备供应商
		map.put("sMachineCode", vo.getSMachineCode());// 设备编码
		map.put("IsSuccess", vo.getIsSuccess());// 是否上传成功
		map.put("uploadTime", vo.getUploadTime());// 上传时间
		map.put("errReason", vo.getErrReason()); // 上传失败原因

		Temperature temperature = new Temperature();
		temperature.setId(vo.getId());
		String[] f = ReflectionUtils.getFiledName(temperature);
		for (int i = 0; i < f.length; i++) {
			if (!"id".equals(f[i]) && !"name".equals(f[i])) {
				BaseElement e = new BaseElement();
				e.setName(f[i]);
				e.setValue(map.get(f[i]));
				ReflectionUtils.setFieldValueByFieldName(f[i], temperature, e);
			}
		}
		return temperature;
	}

	/**
	 * 血氧饱和度
	 * 
	 * @param vo
	 * @return
	 */
	public static Oxygen convertToOxygen(OxygenVo vo) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("ExamID", vo.getExamID());// 主键（引用检查记录表ID）
		map.put("Oxygen", vo.getOxygen());// 血氧
		map.put("Pulse", vo.getPulse());// 脉率
		map.put("archiveId", vo.getIdNumber());// 个人档案Id
		map.put("CardNo", vo.getIdNumber());// 被检查者身份证号
		map.put("Name", vo.getName());// 姓名
		map.put("Phone", vo.getPhone());// 联系方式
		map.put("HealthNO", vo.getHealthNO());// 健康卡号
		map.put("duns", vo.getOrganName());// 机构
		map.put("created_By", vo.getCreateName());// 创建者
		map.put("created_Date", vo.getCreateTime());// 创建时间
		map.put("updated_By", vo.getUpdateName());// 修改者
		map.put("update_Date", vo.getUpdateTime());// 修改时间
		map.put("dateResType", vo.getDataResType());// 数据源类型
		map.put("sSupplierCode", vo.getSSupplierCode());// 设备供应商
		map.put("sMachineCode", vo.getSMachineCode());// 设备编码
		map.put("IsSuccess", vo.getIsSuccess());// 是否上传成功
		map.put("uploadTime", vo.getUploadTime());// 上传时间
		map.put("errReason", vo.getErrReason()); // 上传失败原因

		Oxygen oxygen = new Oxygen();
		oxygen.setId(vo.getId());
		String[] f = ReflectionUtils.getFiledName(oxygen);
		for (int i = 0; i < f.length; i++) {
			if (!"id".equals(f[i]) && !"name".equals(f[i])) {
				BaseElement e = new BaseElement();
				e.setName(f[i]);
				e.setValue(map.get(f[i]));
				ReflectionUtils.setFieldValueByFieldName(f[i], oxygen, e);
			}
		}
		return oxygen;
	}

	/**
	 * 血糖
	 * 
	 * @param vo
	 * @return
	 */
	public static Glucose convertToGlucose(GlucoseVo vo) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("ExamID", vo.getExamID());// 主键（引用检查记录表ID）
		map.put("Glucose", vo.getGlucose());// 血糖
		map.put("archiveId", vo.getIdNumber());// 个人档案Id
		map.put("CardNo", vo.getIdNumber());// 被检查者身份证号
		map.put("Name", vo.getName());// 姓名
		map.put("Phone", vo.getPhone());// 联系方式
		map.put("HealthNO", vo.getHealthNO());// 健康卡号
		map.put("duns", vo.getOrganName());// 机构
		map.put("created_By", vo.getCreateName());// 创建者
		map.put("created_Date", vo.getCreateTime());// 创建时间
		map.put("updated_By", vo.getUpdateName());// 修改者
		map.put("update_Date", vo.getUpdateTime());// 修改时间
		map.put("dateResType", vo.getDataResType());// 数据源类型
		map.put("sSupplierCode", vo.getSSupplierCode());// 设备供应商
		map.put("sMachineCode", vo.getSMachineCode());// 设备编码
		map.put("IsSuccess", vo.getIsSuccess());// 是否上传成功
		map.put("uploadTime", vo.getUploadTime());// 上传时间
		map.put("errReason", vo.getErrReason()); // 上传失败原因

		Glucose glucose = new Glucose();
		glucose.setId(vo.getId());
		String[] f = ReflectionUtils.getFiledName(glucose);
		for (int i = 0; i < f.length; i++) {
			if (!"id".equals(f[i]) && !"name".equals(f[i])) {
				BaseElement e = new BaseElement();
				e.setName(f[i]);
				e.setValue(map.get(f[i]));
				ReflectionUtils.setFieldValueByFieldName(f[i], glucose, e);
			}
		}
		return glucose;
	}

	/**
	 * 血压
	 * 
	 * @param vo
	 * @return
	 */
	public static Tolic convertToTolic(TolicVo vo) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("ExamID", vo.getExamID());// 主键（引用检查记录表ID）
		map.put("Systolic", vo.getSystolic());// 收缩压
		map.put("Diastolic", vo.getDiastolic());// 舒张压
		map.put("archiveId", vo.getIdNumber());// 个人档案Id
		map.put("CardNo", vo.getIdNumber());// 被检查者身份证号
		map.put("Name", vo.getName());// 姓名
		map.put("Phone", vo.getPhone());// 联系方式
		map.put("HealthNO", vo.getHealthNO());// 健康卡号
		map.put("duns", vo.getOrganName());// 机构
		map.put("created_By", vo.getCreateName());// 创建者
		map.put("created_Date", vo.getCreateTime());// 创建时间
		map.put("updated_By", vo.getUpdateName());// 修改者
		map.put("updated_Date", vo.getUpdateTime());// 修改时间
		map.put("dataResType", vo.getDataResType());// 数据源类型
		map.put("sSupplierCode", vo.getSSupplierCode());// 设备供应商
		map.put("sMachineCode", vo.getSMachineCode());// 设备编码
		map.put("IsSuccess", vo.getIsSuccess());// 是否上传成功
		map.put("uploadTime", vo.getUploadTime());// 上传时间
		map.put("errReason", vo.getErrReason()); // 上传失败原因

		Tolic tolic = new Tolic();
		tolic.setId(vo.getId());
		String[] f = ReflectionUtils.getFiledName(tolic);
		for (int i = 0; i < f.length; i++) {
			if (!"id".equals(f[i]) && !"name".equals(f[i])) {
				BaseElement e = new BaseElement();
				e.setName(f[i]);
				e.setValue(map.get(f[i]));
				ReflectionUtils.setFieldValueByFieldName(f[i], tolic, e);
			}
		}
		return tolic;
	}

	/**
	 * 检查记录
	 * 
	 * @param vo
	 * @return
	 */
	public static CheckRecord convertToCheckRecord(CheckRecordVo vo) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("archiveId", vo.getIdNumber());// 个人档案Id
		map.put("checkdoctor", vo.getCheckdoctor());// 检查人员
		map.put("checkDate", vo.getCheckDate());// 检查时间
		map.put("CardNo", vo.getIdNumber());// 被检查者身份证号
		map.put("Name", vo.getName());// 姓名
		map.put("Phone", vo.getPhone());// 联系方式
		map.put("HealthNO", vo.getHealthNO());// 健康卡号
		map.put("duns", vo.getOrganName());// 机构
		map.put("created_By", vo.getCreateName());// 创建者
		map.put("created_Date", vo.getCreateTime());// 创建时间
		map.put("updated_By", vo.getUpdateName());// 修改者
		map.put("update_Date", vo.getUpdateTime());// 修改时间
		map.put("dateResType", vo.getDataResType());// 数据源类型
		map.put("sSupplierCode", vo.getSSupplierCode());// 设备供应商
		map.put("sMachineCode", vo.getSMachineCode());// 设备编码
		map.put("IsSuccess", vo.getIsSuccess());// 是否上传成功
		map.put("uploadTime", vo.getUploadTime());// 上传时间
		map.put("errReason", vo.getErrReason()); // 上传失败原因

		CheckRecord checkRecord = new CheckRecord();
		checkRecord.setId(vo.getId());
		String[] f = ReflectionUtils.getFiledName(checkRecord);
		for (int i = 0; i < f.length; i++) {
			if (!"id".equals(f[i]) && !"name".equals(f[i])) {
				BaseElement e = new BaseElement();
				e.setName(f[i]);
				e.setValue(map.get(f[i]));
				ReflectionUtils.setFieldValueByFieldName(f[i], checkRecord, e);
			}
		}
		return checkRecord;
	}

	/**
	 * 检查报告
	 * 
	 * @param vo
	 * @return
	 */
	public static CheckResult convertToCheckResult(CheckResultVo vo) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("ID", vo.getId());
		map.put("archiveId", vo.getIdNumber());// 个人档案Id
		map.put("CardNo", vo.getIdNumber());// 被检查者身份证号
		map.put("checkDate", vo.getCheckDate());// 检查时间
		map.put("Name", vo.getName());// 姓名
		map.put("Phone", vo.getPhone());// 联系方式
		map.put("HealthNO", vo.getHealthNO());// 健康卡号
		map.put("checkdoctor", vo.getCheckdoctor());// 检查人员
		map.put("checkURl", vo.getCheckUrl());// 一体机检查报告地址
		map.put("checkResult", vo.getCheckResult());// 检查报告结果

		map.put("HeartRate", vo.getHeartRate());// 心率(未检测录入0)
		map.put("ECGData", vo.getECGData());// 心电数据（采样数据值逗号隔开）
		map.put("ECGResult", vo.getXdtresult());// 心电结果（逗号隔开）
		map.put("ECGImg", vo.getImageurl());// 心电图片（二进制数据字符串）
		map.put("ECGUrl", vo.getECGUrl());// 心电图浏览地址（浏览地址Url）

		map.put("Glucose", vo.getGlucose());// 血糖

		map.put("Systolic", vo.getSystolic());// 收缩压
		map.put("Diastolic", vo.getDiastolic());// 舒张压

		map.put("Oxygen", vo.getOxygen());// 血氧
		map.put("Pulse", vo.getPulse());// 脉率

		map.put("Temperature", vo.getTemperature());// 体温

		map.put("Leu", vo.getLeu());
		map.put("Nit", vo.getNit());
		map.put("Ubg", vo.getUro());
		map.put("Pro", vo.getPro());
		map.put("Ph", vo.getPh());
		map.put("Bld", vo.getBld());
		map.put("Sg", vo.getSg());
		map.put("Ket", vo.getKet());
		map.put("Bil", vo.getBil());
		map.put("Glu", vo.getGlu());
		map.put("Vc", vo.getVc());
		map.put("RutImg", vo.getImg());// 图片

		map.put("duns", vo.getOrganName());// 机构
		map.put("created_By", vo.getCreateName());// 创建者
		map.put("created_Date", vo.getCreateTime());// 创建时间
		map.put("updated_By", vo.getUpdateName());// 修改者
		map.put("update_Date", vo.getUpdateTime());// 修改时间
		map.put("dateResType", vo.getDataResType());// 数据源类型
		map.put("sSupplierCode", vo.getSSupplierCode());// 设备供应商
		map.put("sMachineCode", vo.getSMachineCode());// 设备编码
		map.put("IsSuccess", vo.getIsSuccess());// 是否上传成功
		map.put("uploadTime", vo.getUploadTime());// 上传时间
		map.put("errReason", vo.getErrReason()); // 上传失败原因

		CheckResult checkResult = new CheckResult();
		checkResult.setId(vo.getId());
		String[] f = ReflectionUtils.getFiledName(checkResult);
		for (int i = 0; i < f.length; i++) {
			if (!"id".equals(f[i]) && !"name".equals(f[i])) {
				BaseElement e = new BaseElement();
				e.setName(f[i]);
				e.setValue(map.get(f[i]));
				ReflectionUtils.setFieldValueByFieldName(f[i], checkResult, e);
			}
		}
		return checkResult;
	}

	/**
	 * 根据身份证号或档案号查询个人档案信息
	 * 
	 * @param vo
	 * @return
	 */
	public static ResidentQuery convertToResident(ResidentVo vo) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("typeId", vo.getTypeId());
		map.put("instanceId", vo.getIdNumber());// 个人档案Id

		ResidentQuery residentQuery = new ResidentQuery();
		String[] f = ReflectionUtils.getFiledName(residentQuery);
		for (int i = 0; i < f.length; i++) {
			if (!"id".equals(f[i]) && !"name".equals(f[i])) {
				BaseElement e = new BaseElement();
				e.setName(f[i]);
				e.setValue(map.get(f[i]));
				ReflectionUtils.setFieldValueByFieldName(f[i], residentQuery, e);
			}
		}
		return residentQuery;

	}

	/**
	 * 新增/修改建档
	 * 
	 * @param vo
	 * @return
	 */
	public static Resident convertToInsertResident(ResidentVo vo) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("ID", vo.getId());

		map.put("archiveNo", vo.getArchiveNo());// 纸质档案号
		map.put("fullname", vo.getName());// 姓名
		map.put("gender", vo.getSex());// 性别
		map.put("birthday", vo.getBirthday());// 出生日期
		map.put("identityno", vo.getIdNumber());// 身份证号
		map.put("resaddr_committee", vo.getRegisterAddress());// 户籍所在地
		map.put("resaddr_doorno", vo.getRegisterAddressDoor());// 户籍所在地(门牌号)
		map.put("curaddr_doorno", vo.getResidenceAddress());// 现住址
		map.put("curaddr_committee", vo.getResidenceAddressDoor());// 现住址(门牌号)
		map.put("company", vo.getCompany());// 工作单位
		map.put("tel", vo.getPhone());// 电话
		map.put("linkman", vo.getLinkName());// 联系人
		map.put("linkman_tel", vo.getLinkPhone());// 联系人电话
		map.put("residenttype", vo.getResidentType());// 常住类型
		map.put("nation", vo.getNation());// 民族
		map.put("medicareid", vo.getMedicalCode());// 健康卡号
		map.put("dutydoctor", vo.getDoctorName());// 责任医生
		map.put("isPoor", vo.getIsPoor() == null ? "" : vo.getIsPoor().toString());// 是否贫困
		map.put("build_date", vo.getCreateTime());// 建档日期
		map.put("builddoctor", vo.getCreateName());// 建档医生
		map.put("remark", vo.getRemark());// 备注
		map.put("duns", vo.getAichiveOrg());// 建档机构

		Resident resident = new Resident();
		resident.setId(vo.getId());
		String[] f = ReflectionUtils.getFiledName(resident);
		for (int i = 0; i < f.length; i++) {
			if (!"id".equals(f[i]) && !"name".equals(f[i])) {
				BaseElement e = new BaseElement();
				e.setName(f[i]);
				e.setValue(map.get(f[i]));
				ReflectionUtils.setFieldValueByFieldName(f[i], resident, e);
			}
		}
		return resident;
	}

	/**
	 * 新增/修改高血压随访
	 * 
	 * @param vo
	 * @return
	 */
	public static Hypertension convertToHypertension(HypertensionVo vo) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("ID", vo.getId());

		map.put("archiveid", vo.getIdNumber());// 档案id
		map.put("visitDate", vo.getVisitDate());// 访问日期
		map.put("visitType", vo.getVisitType());// 此次随访方式
		map.put("visitDoc", vo.getVisitDoctor());// 随访医生
		map.put("symptom", vo.getSymptom());// 症状
		map.put("symptomother", vo.getOtherSymptom());// 其他症状
		map.put("sbp", vo.getSbp() == null ? "" : vo.getSbp().toString());// 收缩压
		map.put("dbp", vo.getDbp() == null ? "" : vo.getDbp().toString());// 舒张压
		map.put("weight", vo.getWeight());// 本次体重
		map.put("nWeight",vo.getTargetWeight());// 下次目标体重
		map.put("height", vo.getHeight());// 身高
		map.put("bmi", vo.getBmi());// 本次体质指数
		map.put("nBmi", vo.getTargetBmi());// 下次目标体质指数
		map.put("heartRate", vo.getHeartRate() == null ? "" : vo.getHeartRate().toString());// 心率
		map.put("otherSigns", vo.getOtherSign());// 其他体征
		map.put("smokeAmount", vo.getSmoken() == null ? "" : vo.getSmoken().toString());// 日吸烟量
		map.put("nSmokeAmount", vo.getTargetSomken() == null ? "" : vo.getTargetSomken().toString());// 目标日吸烟量
		map.put("wineAmount", vo.getWine() == null ? "" : vo.getWine().toString());// 日饮酒量
		map.put("nWineAmount", vo.getTargetWine() == null ? "" : vo.getTargetWine().toString());// 目标日饮酒量
		map.put("sportperWeek", vo.getSportWeek() == null ? "" : vo.getSportWeek().toString());// 运动(次/周)
		map.put("visitClass", vo.getVisitClass());// 此次对方分类
		map.put("sportOnce", vo.getTargetSportOnce() == null ? "" : vo.getTargetSportOnce().toString());// 运动（分钟/次）
		map.put("nSportperWeek", vo.getTargetSportWeek() == null ? "" : vo.getTargetSportWeek().toString());// 目标运动（次/周）
		map.put("nSportOnce", vo.getTargetSportOnce() == null ? "" : vo.getTargetSportOnce().toString());// 目标运动（分钟/次）
		map.put("saltIntake", vo.getSaltIntake());// 摄盐情况（咸淡）
		map.put("nSaltIntake", vo.getTargetSaltIntake());// 目标摄盐情况（咸淡）
		map.put("psychology", vo.getMindAdjust());// 心里调整
		map.put("obeyDoc", vo.getDoctorObey());// 遵医行为
		map.put("assistantCheck", vo.getAssistExamine());// 辅助检查
		map.put("drugCompliance", vo.getDrugObey());// 服药依从性
		map.put("Adverseeffect", vo.getUntowardEffect());// 药物不良反应
		map.put("adverseMemo", vo.getUntowardEffectDrug());// 药物不良反应说明
		map.put("referralld", vo.getReferralCode());// 转诊记录Id
		map.put("nextVisitDate", vo.getNextVisitDate());// 下次随访日期
		map.put("advice", vo.getAdvice());// 评价与建议
		map.put("duns", vo.getCreateOrg());// 机构码
		map.put("kb", vo.getTransferOrgan());// 转诊机构及科别
		map.put("reason", vo.getTransferReason());// 转诊原因

		Hypertension hypertension = new Hypertension();
		hypertension.setId(vo.getId());
		String[] f = ReflectionUtils.getFiledName(hypertension);
		for (int i = 0; i < f.length; i++) {
			if (!"id".equals(f[i]) && !"name".equals(f[i])) {
				BaseElement e = new BaseElement();
				e.setName(f[i]);
				e.setValue(map.get(f[i]));
				ReflectionUtils.setFieldValueByFieldName(f[i], hypertension, e);
			}
		}
		return hypertension;
	}

	/**
	 * 糖尿病
	 * 
	 * @param vo
	 * @return
	 */
	public static Diabetes convertToDiabetes(DiabetesVo vo) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("ID", vo.getId());

		map.put("archiveid", vo.getIdNumber());// 档案id
		map.put("visitDate", vo.getVisitDate());// 本次随访日期
		map.put("visitDoctor", vo.getVisitDoctor());// 随访医生
		map.put("visitType", vo.getVisitType());// 此次随访方式SX0160
		map.put("symptom", vo.getSymptom());// 症状SX0054
		map.put("symptom_other", vo.getSymptomOther());// 其他症状
		map.put("sbp", vo.getBloodPressureHigh() == null ? "" : vo.getBloodPressureHigh().toString());// 收缩压
		map.put("dbp", vo.getBloodPressureLow() == null ? "" : vo.getBloodPressureLow().toString());// 舒张压
		map.put("weight", vo.getWeightNow());// 本次体重
		map.put("nWeight", vo.getWeightNext());// 下次目标体重
		map.put("height", vo.getHeight());// 身高
		map.put("bmi", vo.getBmiNow());// 本次体质指数
		map.put("nBmi", vo.getBmiNext());// 下次目标体质指数
		map.put("dorsal", vo.getDorsalArtery());// 足背动脉搏动SX0399
		map.put("otherSigns", vo.getOther());// 其他体征
		map.put("smokeAmount", vo.getSmokeNow() == null ? "" : vo.getSmokeNow().toString());// 日吸烟量
		map.put("nSmokeAmount", vo.getSmokeNext() == null ? "" : vo.getSmokeNext().toString());// 目标日吸烟量(支)
		map.put("wineAmount", vo.getDrinkNow() == null ? "" : vo.getDrinkNow().toString());// 日饮酒量
		map.put("nWineAmount", vo.getDrinkNext() == null ? "" : vo.getDrinkNext().toString());// 目标日饮酒量
		map.put("sportOfWeek", vo.getSportsNumNow() == null ? "" : vo.getSportsNumNow().toString());// 运动(次/周)
		map.put("sportOfOnce", vo.getSportsTimeNow() == null ? "" : vo.getSportsTimeNow().toString());// 运动（分钟/次）
		map.put("nSportOfWeek", vo.getSportsNumNext() == null ? "" : vo.getSportsNumNext().toString());// 目标运动（次/周）
		map.put("nSportOfOnce", vo.getSportsTimeNext() == null ? "" : vo.getSportsTimeNext().toString());// 目标运动（分钟/次）
		map.put("stapleAmount", vo.getStapleFoodNow());// 主食（克/天）
		map.put("nStapleAmount", vo.getStapleFoodNext());// 目标主食（克/天）
		map.put("psychology", vo.getPsychologicalRecovery());// 心里调整
		map.put("obeyDoctor", vo.getMedicalCompliance());// 遵医行为
		map.put("bsugar_mg", vo.getBloodGlucose());// 空腹血糖值
		map.put("hemoglobin", vo.getGlycosylatedHemoglobin());// 糖化血红蛋白
		map.put("checkDate", vo.getCheckDate());// 糖化血红蛋白检查日期
		map.put("otherCheck", vo.getOtherCheck());// 其他检查
		map.put("drugComply", vo.getCompliance());// 服药依从性
		map.put("hasAdverse", vo.getUntowardEffect());// 药物不良反应
		map.put("adverseMemo", vo.getUntowardEffectDrug());// 不良反应描述
		map.put("adverseOfSugar", vo.getReactiveHypoglycemia());// 低血糖反应
		map.put("visitClass", vo.getFollowType());// 此次随访分类
		map.put("referralld", vo.getReferralCode());// 转诊记录Id
		map.put("nextVisitDate", vo.getNextVisitDate());// 下次随访日期
		map.put("advice", vo.getAdvice());// 评价与建议
		map.put("duns", vo.getCreateOrg());// 机构码
		map.put("attenuate", vo.getAttenuate());// 减弱SX0398
		map.put("disapppear", vo.getDisapppear());// 消失SX0398
		map.put("reason", vo.getTransferTreatmentReason());// 转诊原因
		map.put("kb", vo.getTransferTreatmentDepartment());// 转诊机构及科别

		Diabetes diabetes = new Diabetes();
		diabetes.setId(vo.getId());
		String[] f = ReflectionUtils.getFiledName(diabetes);
		for (int i = 0; i < f.length; i++) {
			if (!"id".equals(f[i]) && !"name".equals(f[i])) {
				BaseElement e = new BaseElement();
				e.setName(f[i]);
				e.setValue(map.get(f[i]));
				ReflectionUtils.setFieldValueByFieldName(f[i], diabetes, e);
			}
		}
		return diabetes;
	}

	/**
	 * 中医体质辨识
	 * 
	 * @param vo
	 * @return
	 */
	public static Elderly convertToInsertElderly(ElderlyVo vo) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("ID", vo.getId());//

		map.put("archiveid", vo.getIdNumber());// 健康档案ID
		map.put("identityno", vo.getIdNumber());// 身份证号
		map.put("serviceid", vo.getServiceid());// 业务表id
		map.put("servicename", vo.getServicename());// 服务项目
		map.put("fullname", vo.getName());// 姓名
		map.put("isEnergeti", vo.getIsEnergeti());// 是否精力充沛
		map.put("isTired", vo.getIsTired());// 是否容易疲劳
		map.put("isLoseHeart", vo.getIsLoseHeart());// 是否容易气短
		map.put("isDeepVoice", vo.getIsDeepVoice());// 是否声音低弱无力
		map.put("isListless", vo.getIsListless());// 是否情绪低沉
		map.put("isJitter", vo.getIsJitter());// 是否精神紧张
		map.put("isAlone", vo.getIsAlone());// 是否孤独
		map.put("isScare", vo.getIsScare());// 是否害怕
		map.put("isHeavy", vo.getIsHeavy());// 是否身体沉重
		map.put("isEyeDry", vo.getIsEyeDry());// 是否眼睛干涩
		map.put("isExtreCold", vo.getIsExtreCold());// 是否手脚冰凉
		map.put("isAfaidCold", vo.getIsAfaidCold());// 是否腰膝怕冷
		map.put("isResistCold", vo.getIsResistCold());// 是否不能耐受寒冷
		map.put("isCatchCold", vo.getIsCatchCold());// 是否容易感冒
		map.put("isSnorty", vo.getIsSnorty());// 是否容易流鼻涕
		map.put("isStertorous", vo.getIsStertorous());// 是否睡眠打鼾
		map.put("isAllergic", vo.getIsAllergic());// 是否容易过敏
		map.put("isHives", vo.getIsHives());// 是否容易起麻疹
		map.put("isEndermicBlood", vo.getIsEndermicBlood());// 是否皮下出血
		map.put("isScore", vo.getIsScore());// 是否容易出现抓痕
		map.put("isFeverDry", vo.getIsFeverDry());// 是否容易嘴唇干裂
		map.put("isBodyPain", vo.getIsBodyPain());// 是否肢体疼痛
		map.put("isFaceLight", vo.getIsFaceLight());// 是否面部发亮
		map.put("isFleck", vo.getIsFleck());// 是否面色晦暗
		map.put("isTetter", vo.getIsTetter());// 是否湿疹
		map.put("isLikeDrink", vo.getIsLikeDrink());// 是否总想喝水
		map.put("ismouthBitter", vo.getArchiveNo());// 是否口苦
		map.put("ifFat", vo.getIfFat());// 是否腹部肥
		map.put("isScareColdFood", vo.getIsScareColdFood());// 是否害怕凉食
		map.put("isStoolStick", vo.getIsStoolStick());// 是否大便粘滞
		map.put("isStoolDry", vo.getIsStoolDry());// 是否大便干燥
		map.put("isLinguaMassin", vo.getIsLinguaMassin());// 是否舌苔厚重
		map.put("isLinguaVein", vo.getIsLinguaVein());// 是否静脉淤紫
		map.put("physique_qxz", vo.getQixuzhiResult());// 气虚质
		map.put("physique_yangxz", vo.getYangxuzhiResult());// 阳虚质
		map.put("physique_yinxz", vo.getYinxuzhiResult());// 阴虚质
		map.put("physique_tsz", vo.getTanshizhiResult());// 痰湿质
		map.put("physique_srz", vo.getShirezhiResult());// 湿热质
		map.put("physique_xyz", vo.getXueyuzhiResult());// 血瘀质
		map.put("physique_qyz", vo.getQiyuzhiResult());// 气郁质
		map.put("physique_tbz", vo.getTebingzhiResult());// 特秉质
		map.put("physique_phz", vo.getPinghezhiResult());// 平和质
		map.put("reportDate", vo.getTestDate());// 填表日期
		map.put("reportDoc", vo.getTestDoctor());// 医生签字
		map.put("duns", vo.getCreateOrg());// 机构码
		map.put("qxz_Score", vo.getQixuzhiScore() == null ? "" : vo.getQixuzhiScore().toString());// 气虚质得分
		map.put("yangxz_Score", vo.getYangxuzhiScore() == null ? "" : vo.getYangxuzhiScore().toString());// 阳虚质得分
		map.put("yinxz_Score", vo.getYinxuzhiScore() == null ? "" : vo.getYinxuzhiScore().toString());// 阴虚质得分
		map.put("tsz_Score", vo.getTanshizhiScore() == null ? "" : vo.getTanshizhiScore().toString());// 痰湿质得分
		map.put("srz_Score", vo.getShirezhiScore() == null ? "" : vo.getShirezhiScore().toString());// 湿热质得分
		map.put("xyz_Score", vo.getXueyuzhiScore() == null ? "" : vo.getXueyuzhiScore().toString());// 血瘀质得分
		map.put("qyz_Score", vo.getQiyuzhiScore() == null ? "" : vo.getQiyuzhiScore().toString());// 气郁质得分
		map.put("tbz_Score", vo.getTebingzhiSorce() == null ? "" : vo.getTebingzhiSorce().toString());// 特秉质得分
		map.put("phz_Score", vo.getPinghezhiSorce() == null ? "" : vo.getPinghezhiSorce().toString());// 平和质得分
		map.put("qxz_guide", vo.getQxz_guide());// 气虚质指导
		map.put("yangxz_guide", vo.getYangxz_guide());// 阳虚质指导
		map.put("yinxz_guide", vo.getYinxz_guide());// 阴虚质指导
		map.put("tsz_guide", vo.getTsz_guide());// 痰湿质指导
		map.put("srz_guide", vo.getSrz_guide());// 湿热质指导
		map.put("xyz_guide", vo.getXyz_guide());// 血瘀质指导
		map.put("qyz_guide", vo.getQyz_guide());// 气郁质指导
		map.put("tbz_guide", vo.getTbz_guide());// 特秉质指导
		map.put("phz_guide", vo.getPhz_guide());// 平和质指导
		map.put("qxz_guide_other", vo.getQxz_guide_other());// 气虚质其他指导
		map.put("yangxz_guide_other", vo.getYangxz_guide_other());// 阳虚质其他指导
		map.put("yinxz_guide_other", vo.getYinxz_guide_other());// 阴虚质其他指导
		map.put("tsz_guide_other", vo.getTsz_guide_other());// 痰湿质其他指导
		map.put("srz_guide_other", vo.getSrz_guide_other());// 湿热质其他指导
		map.put("xyz_guide_other", vo.getXyz_guide_other());// 血瘀质其他指导
		map.put("qyz_guide_other", vo.getQyz_guide_other());// 气郁质其他指导
		map.put("tbz_guide_other", vo.getTbz_guide_other());// 特秉质其他指导
		map.put("phz_guide_other", vo.getPhz_guide_other());// 平和质其他指导

		Elderly elderly = new Elderly();
		elderly.setId(vo.getId());
		String[] f = ReflectionUtils.getFiledName(elderly);
		for (int i = 0; i < f.length; i++) {
			if (!"id".equals(f[i]) && !"name".equals(f[i])) {
				BaseElement e = new BaseElement();
				e.setName(f[i]);
				e.setValue(map.get(f[i]));
				ReflectionUtils.setFieldValueByFieldName(f[i], elderly, e);
			}
		}
		return elderly;
	}

	/**
	 * 中医体质辨识
	 * 
	 * @param vo
	 * @return
	 */
	public static OldHguide convertToInsertOldHguide(OldHguideVo vo) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("ID", vo.getId());//

		map.put("archiveId", vo.getIdNumber());// 健康档案ID
		map.put("tel", vo.getTel());// 电话
		map.put("fullname", vo.getFullname());// 姓名
		map.put("gender", vo.getGender());// 性别
		map.put("birthday", vo.getBirthday());// 出生日期
		map.put("diagnose", vo.getDiagnose());// 体质辨识结果/证型
		map.put("diagnoseDesc", vo.getDiagnoseDesc());// 体质辨识结果/证型描述
		map.put("eduDate", vo.getEduDate());// 指导日期
		map.put("eduDoctor", vo.getEduDoctor());// 指导医生
		map.put("feel", vo.getFeel());// 情志调摄
		map.put("eat", vo.getEat());// 饮食调养
		map.put("qjts", vo.getQjts());// 起居调摄
		map.put("sport", vo.getSport());// 运动保健
		map.put("acupoint", vo.getAcupoint());// 穴位保健
		map.put("channels", vo.getChannels());// 经络保健
		map.put("care", vo.getCare());// 注意事项
		map.put("orher", vo.getOrher());// 其他指导
		map.put("DataSrc", vo.getDataSrc());// 数据来源
		map.put("DataMonment", vo.getDataMonment());// 数据来源说明
		map.put("duns", vo.getDuns());// 录入机构

		OldHguide oldHguide = new OldHguide();
		oldHguide.setId(vo.getId());
		String[] f = ReflectionUtils.getFiledName(oldHguide);
		for (int i = 0; i < f.length; i++) {
			if (!"id".equals(f[i]) && !"name".equals(f[i])) {
				BaseElement e = new BaseElement();
				e.setName(f[i]);
				e.setValue(map.get(f[i]));
				ReflectionUtils.setFieldValueByFieldName(f[i], oldHguide, e);
			}
		}
		return oldHguide;
	}
	
	
	/**
	 * 健康扶贫随访
	 * 
	 * @param vo
	 * @return
	 */
	public static JKFPVisit convertToInsertJKFPVisit(JKFPVisitVo vo) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("ID", vo.getId());//

		map.put("archiveid", vo.getIdNumber());// 健康档案ID
		map.put("identityNo", vo.getIdNumber());//身份证号
		map.put("fullname", vo.getName());// 姓名
		map.put("gender", vo.getSex());// 性别
		map.put("birthday", vo.getBirthday());// 出生日期
		map.put("visitDate", vo.getVisitDate());// 本次随访日期
		map.put("visitType", vo.getVisitType());// 此次随访方式
		map.put("visitDoc", vo.getVisitDoc());// 随访医生
		map.put("gznr", vo.getGznr());// 工作内容
		map.put("advice", vo.getAdvice());//评价与建议
		map.put("duns", vo.getCreateOrg());// 机构码
		

		JKFPVisit jkfp = new JKFPVisit();
		jkfp.setId(vo.getId());
		String[] f = ReflectionUtils.getFiledName(jkfp);
		for (int i = 0; i < f.length; i++) {
			if (!"id".equals(f[i]) && !"name".equals(f[i])) {
				BaseElement e = new BaseElement();
				e.setName(f[i]);
				e.setValue(map.get(f[i]));
				ReflectionUtils.setFieldValueByFieldName(f[i], jkfp, e);
			}
		}
		return jkfp;
	}
	
	
	
	

}
