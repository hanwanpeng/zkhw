package com.zkhw.pub.service.impl;

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
import com.zkhw.common.utils.AliOssUtil;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.pub.dao.HospitalizedRecordDao;
import com.zkhw.pub.dao.PhysicalExaminationDao;
import com.zkhw.pub.dao.ResidentBaseInfoDao;
import com.zkhw.pub.dao.TakeMedicineRecordDao;
import com.zkhw.pub.dao.TjBcDao;
import com.zkhw.pub.dao.TjNcgDao;
import com.zkhw.pub.dao.TjSgtzDao;
import com.zkhw.pub.dao.TjShDao;
import com.zkhw.pub.dao.TjXcgDao;
import com.zkhw.pub.dao.TjXdtDao;
import com.zkhw.pub.dao.TjXyDao;
import com.zkhw.pub.dao.VaccinationRecordDao;
import com.zkhw.pub.entity.HospitalizedRecord;
import com.zkhw.pub.entity.PhysicalExamination;
import com.zkhw.pub.entity.ResidentBaseInfo;
import com.zkhw.pub.entity.TakeMedicineRecord;
import com.zkhw.pub.entity.TjBc;
import com.zkhw.pub.entity.TjNcg;
import com.zkhw.pub.entity.TjSgtz;
import com.zkhw.pub.entity.TjSh;
import com.zkhw.pub.entity.TjXcg;
import com.zkhw.pub.entity.TjXdt;
import com.zkhw.pub.entity.TjXy;
import com.zkhw.pub.entity.VaccinationRecord;
import com.zkhw.pub.query.ResidentBaseInfoQuery;
import com.zkhw.pub.service.PhysicalExaminationService;
import com.zkhw.pub.vo.ExaminationListVo;
import com.zkhw.pub.vo.PhysicalExaminationVo;
import com.zkhw.pub.vo.TjDataVo;

@Service
public class PhysicalExaminationServiceImpl implements PhysicalExaminationService {

	@Autowired
	private PhysicalExaminationDao physicalExaminationDao;
	
	@Autowired
	private HospitalizedRecordDao hospitalizedRecordDao;
	
	@Autowired
	private TakeMedicineRecordDao takeMedicineRecordDao;
	
	@Autowired
	private VaccinationRecordDao vaccinationRecordDao;
	
	@Autowired
	private ResidentBaseInfoDao residentBaseInfoDao;
	
	@Autowired
	private TjNcgDao tjNcgDao;
	
	@Autowired
	private TjSgtzDao tjSgtzDao;
	
	@Autowired
	private TjShDao tjShDao;
	
	@Autowired
	private TjXcgDao tjXcgDao;
	
	@Autowired
	private TjXyDao tjXyDao;
	
	@Autowired
	private TjBcDao tjBcDao;
	
	@Autowired
	private TjXdtDao tjXdtDao;
	
	@Override
	public PhysicalExaminationVo getPhysicalExaminationByArchiveNo(String archiveNo) {
		PhysicalExamination exam = physicalExaminationDao.getLastByArchiveNo(archiveNo);
		PhysicalExaminationVo vo = new PhysicalExaminationVo();
		if(exam != null){			
			BeanUtils.copyProperties(exam,vo);
			List<HospitalizedRecord> hosps = hospitalizedRecordDao.findRecordByExamId(exam.getId());
			vo.setHospitals(hosps);
			List<TakeMedicineRecord> meds = takeMedicineRecordDao.findRecordByExamId(exam.getId());
			vo.setMedicines(meds);
			List<VaccinationRecord> vaccs = vaccinationRecordDao.findRecordByExamId(exam.getId());
			vo.setVaccinations(vaccs);			
		}
		
		return vo;
	}

	
	
	/**
	 * 根据身份证号查询体检报告
	 */
	@Override
	public PhysicalExaminationVo physicalByIdNumber(String idNumber) {
		PhysicalExamination physical = physicalExaminationDao.physicalByIdNumber(idNumber);
		
		PhysicalExaminationVo vo = new PhysicalExaminationVo();
		if(physical != null){			
			BeanUtils.copyProperties(physical,vo);
			List<HospitalizedRecord> hosps = hospitalizedRecordDao.findRecordByExamId(physical.getId());
			vo.setHospitals(hosps);
			List<TakeMedicineRecord> meds = takeMedicineRecordDao.findRecordByExamId(physical.getId());
			vo.setMedicines(meds);
			List<VaccinationRecord> vaccs = vaccinationRecordDao.findRecordByExamId(physical.getId());
			vo.setVaccinations(vaccs);			
		}
		
		return vo;
	}


	
	/*public static void main(String[] args) {
		
		PhysicalExaminationVo physicalExaminationVo = new PhysicalExaminationVo();
		HospitalizedRecord h = new HospitalizedRecord();
		TakeMedicineRecord t = new TakeMedicineRecord();
		VaccinationRecord v = new VaccinationRecord();
		
		ArrayList<HospitalizedRecord> hl = new ArrayList<HospitalizedRecord>();
		ArrayList<TakeMedicineRecord> tl = new ArrayList<TakeMedicineRecord>();
		ArrayList<VaccinationRecord> vl = new ArrayList<VaccinationRecord>();
		
		hl.add(h);
		tl.add(t);
		vl.add(v);
		
		physicalExaminationVo.setHospitals(hl);
		physicalExaminationVo.setMedicines(tl);
		physicalExaminationVo.setVaccinations(vl);
		
		String obj2JsonWithNullProperty = JsonConverter.obj2JsonWithNullProperty(physicalExaminationVo);
		System.out.println(obj2JsonWithNullProperty);
		
	}*/
	
	
	
	
	
	/**
	 * 修改健康体检表
	 */
	@Override
	public void updatePhysical(PhysicalExaminationVo vo) {
		String archiveNo = vo.getArchiveNo();
		
		//健康体检表
		 PhysicalExamination physicalExamination = new PhysicalExamination();
		BeanUtils.copyProperties(vo, physicalExamination);
		physicalExamination.setArchiveNo(archiveNo);
		//physicalExamination.setUpdateName(updateName);
		physicalExamination.setUpdateTime(new Date());
		physicalExaminationDao.updateByPrimaryKeySelective(physicalExamination);
		
		//住院记录表
		List<HospitalizedRecord> hospitalsList = vo.getHospitals();
		HospitalizedRecord hospitalizedRecord = null;
		for (int i = 0; i < hospitalsList.size(); i++) {
			hospitalizedRecord = hospitalsList.get(i);
			hospitalizedRecord.setArchiveNo(archiveNo);
			//hospitalizedRecord.setUpdateName(updateName);
			hospitalizedRecord.setUpdateTime(new Date());
			hospitalizedRecordDao.updateByPrimaryKeySelective(hospitalizedRecord);
		}
		
		//用药记录表
		List<TakeMedicineRecord> medicinesList = vo.getMedicines();
		TakeMedicineRecord takeMedicineRecord = null;
		for (int i = 0; i < medicinesList.size(); i++) {
			takeMedicineRecord = medicinesList.get(i);
			takeMedicineRecord.setArchiveNo(archiveNo);
			//takeMedicineRecord.setUpdateName(updateName);
			takeMedicineRecord.setUpdateTime(new Date());
			takeMedicineRecordDao.updateByPrimaryKeySelective(takeMedicineRecord);
		}
		//预防接种记录表
		List<VaccinationRecord> vaccinationsList = vo.getVaccinations();
		VaccinationRecord vaccinationRecord = null;
		for (int i = 0; i < vaccinationsList.size(); i++) {
			vaccinationRecord = vaccinationsList.get(i);
			vaccinationRecord.setArchiveNo(archiveNo);
			//vaccinationRecord.setUpdateName(updateName);
			vaccinationRecord.setUpdateTime(new Date());
			vaccinationRecordDao.updateByPrimaryKeySelective(vaccinationRecord);
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Map<String, String> exportPdf(String archiveNo) {
		Map<String, String> map = new HashMap<String,String>();
		PhysicalExamination exam = physicalExaminationDao.selectByPrimaryKey(archiveNo);
		if(exam != null ){		
			String ar = exam.getArchiveNo();
			map.put("a1", ar.substring(0,1));
			map.put("a2", ar.substring(1,2));
			map.put("a3", ar.substring(2,3));
			map.put("a4", ar.substring(3,4));
			map.put("a5", ar.substring(4,5));
			map.put("a6", ar.substring(5,6));
			map.put("a7", ar.substring(6,7));
			map.put("a8", ar.substring(7,8));
			map.put("a9", ar.substring(8,9));
			map.put("a10", ar.substring(9,10));
			map.put("a11", ar.substring(10,11));
			map.put("a12", ar.substring(11,12));
			map.put("a13", ar.substring(12,13));
			map.put("a14", ar.substring(13,14));
			map.put("a15", ar.substring(14,15));
			map.put("a16", ar.substring(15,16));
			map.put("a17", ar.substring(16,17));
			
			List<ResidentBaseInfo> list = residentBaseInfoDao.findResidentByArchiveNo(exam.getArchiveNo());
			if(list != null && list.size() > 0){
				ResidentBaseInfo info = list.get(0);
				Date cdate = info.getCreateTime();
				
				//姓名
				map.put("name", info.getName());
				//现住址
				map.put("address", info.getResidenceAddress());
				//户籍地址
				map.put("raddress", info.getRegisterAddress());
				
				map.put("phone", info.getPhone());
				//乡镇名称
				map.put("townsName", info.getTownsName());
				//村委会名称
				map.put("villageName", info.getVillageName());
				//建档机构
				map.put("aichiveOrg", info.getAichiveOrg());
				//建档人
				map.put("createUser", info.getCreateName());
				//责任医生
				map.put("doctorName", info.getDoctorName());
				
				map.put("cyear", String.valueOf(1900 + cdate.getYear()));
				map.put("cmonth", String.valueOf(cdate.getMonth() + 1));
				map.put("cdate", String.valueOf(cdate.getDate()));	
			}
				
			//姓名
			map.put("name", exam.getName());
			//体检日期
			String checkDate = exam.getCheckDate();
			if(StringUtil.isNotEmpty(checkDate)){
				String[] time = checkDate.split("-");
				map.put("year", time[0]);	
				map.put("month", time[1]);
				map.put("date", time[2]);
			}
			//症状
			String symptom = exam.getSymptom();
			if(!"".equals(symptom)){
				String[] sym = symptom.split(",");
				for(int i = 1; i <= sym.length; i++){
					map.put("sym" + i , sym[i -1]);
				}
			}			
			//症状其他
			map.put("symother", exam.getSymptomOther());
			//体温
			map.put("temperature", exam.getBaseTemperature());
			//脉搏
			map.put("heartbeat", exam.getBaseHeartbeat());
			//呼吸频率
			map.put("respiratory", exam.getBaseRespiratory());
			//左舒张压
			map.put("leftdbp", exam.getBaseBloodPressureLeftLow() == null?"":exam.getBaseBloodPressureLeftLow().toString());
			//左收缩压
			map.put("leftsbp", exam.getBaseBloodPressureLeftHigh() == null?"":exam.getBaseBloodPressureLeftHigh().toString());

			//右舒张压
			map.put("rightdbp", exam.getBaseBloodPressureRightLow() == null?"":exam.getBaseBloodPressureRightLow().toString());
			//右收缩压
			map.put("rightsbp", exam.getBaseBloodPressureRightHigh() == null?"":exam.getBaseBloodPressureRightHigh().toString());
			//身高
			map.put("height", exam.getBaseHeight());
			//体重
			map.put("weight", exam.getBaseWeight());
			//腰围
			map.put("waist", exam.getBaseWaist() );
			//bmi
			map.put("bmi", exam.getBaseBmi());
			//老年人健康状态自我评估
			map.put("health", exam.getBaseHealthEstimate());
			//老年人生活自理能力自我评估
			map.put("selfcare", exam.getBaseSelfcareEstimate());
			//老年人认知功能
			map.put("cognition", exam.getBaseCognitionEstimate());
			//老年人智力得分
			map.put("cognitionScore", exam.getBaseCognitionScore());
			//老年人情感状态
			map.put("feeling", exam.getBaseFeelingEstimate());
			//老年人抑郁评分
			map.put("feelingScore", exam.getBaseFeelingScore());
			//锻炼频率
			map.put("frequency", exam.getLifewayExerciseFrequency());
			//每次锻炼时间
			map.put("time", exam.getLifewayExerciseTime());
			//坚持锻炼时间
			map.put("exerciseYear", exam.getLifewayExerciseYear());
			//锻炼方式
			map.put("exerciseType", exam.getLifewayExerciseType());
			//饮食习惯
			String diets = exam.getLifewayDiet();
			if(!"".equals(diets)){
				String[] diet = diets.split(",");
				for(int i = 1; i <= diet.length; i++){
					map.put("diet" + i , diet[i -1]);
				}
			}
			//吸烟状况
			map.put("smoke", exam.getLifewaySmokeStatus());
			//日吸烟量
			map.put("smokeNumber", exam.getLifewaySmokeNumber());
			//开始吸烟年龄
			map.put("smokeStartage", exam.getLifewaySmokeStartage());
			//戒烟年龄
			map.put("smokeEndage", exam.getLifewaySmokeEndage());
			//饮酒频率
			map.put("drink", exam.getLifewayDrinkStatus());
			//日饮酒量
			map.put("drinkNumber", exam.getLifewayDrinkNumber());
			//是否戒酒
			map.put("drinkStop", exam.getLifewayDrinkStop());	
			//戒酒年龄
			map.put("drinkStopage", exam.getLifewayDrinkStopage());	
			//开始饮酒年龄
			map.put("drinkStartage", exam.getLifewayDrinkStartage());	
			//近一年内是否醉酒
			map.put("drunkenness", exam.getLifewayDrinkOneyear());	
			//饮酒种类
			String drinkType = exam.getLifewayDrinkType();
			if(!"".equals(drinkType)){
				String[] d = drinkType.split(",");
				for(int i = 1; i <= d.length; i++){
					map.put("drinkType" + i , d[i -1]);
				}
			}
			//饮酒种类其他
			map.put("drinkOther", exam.getLifewayDrinkOther());
			
			//是否有职业病危害接触
			map.put("occupational", exam.getLifewayOccupationalDisease());
			//工种
			map.put("job", exam.getLifewayJob());
			//从业时间
			map.put("jobPeriod", exam.getLifewayJobPeriod());
			//毒物粉尘
			map.put("dust", exam.getLifewayHazardousDust());
			//毒物粉尘粉尘预防措施
			map.put("dustP", exam.getLifewayDustPreventive());
			//放射物质
			map.put("radiation", exam.getLifewayHazardousRadiation());
			//放射物质预防措施
			map.put("radiationP", exam.getLifewayRadiationPreventive());			
			//物理因素
			map.put("physical", exam.getLifewayHazardousPhysical());	
			//物理因素预防措施
			map.put("physicalP", exam.getLifewayPhysicalPreventive());			
			//化学物质
			map.put("chemical", exam.getLifewayHazardousChemical());	
			//化学物质预防措施
			map.put("chemicalP", exam.getLifewayChemicalPreventive());
			//其他危险种类
			map.put("hazardousOther", exam.getLifewayHazardousOther());
			//其他预防措施
			map.put("otherP", exam.getLifewayOtherPreventive());
			//口唇
			map.put("lips", exam.getOrganLips());
			//齿列
			String tooth = exam.getOrganTooth();
			if(!"".equals(tooth)){
				String[] t = tooth.split(",");
				for(int i = 1; i <= t.length; i++){
					map.put("tooth" + i , t[i-1]);
				}
			}
			//左上缺齿
			map.put("hTopleft", exam.getOrganHypodontiaTopleft());
			//右上缺齿
			map.put("hTopright", exam.getOrganHypodontiaTopright());	
			//左下缺齿
			map.put("hBottomleft", exam.getOrganHypodontiaBottomleft());
			//右下缺齿
			map.put("hBottomright", exam.getOrganHypodontiaBottomright());
			
			//左上龋齿
			map.put("cTopleft", exam.getOrganCariesTopleft());	
			//右上龋齿
			map.put("cTopright", exam.getOrganCariesTopright());	
			//左下龋齿
			map.put("cBottomleft", exam.getOrganCariesBottomleft());
			//右下龋齿
			map.put("cBottomright", exam.getOrganCariesBottomright());

			//左上假牙
			map.put("dTopleft", exam.getOrganDentureTopleft());
			//右上假牙
			map.put("dTopright", exam.getOrganDentureTopright());	
			//左下假牙
			map.put("dBottomleft", exam.getOrganDentureBottomleft());
			//右下假牙
			map.put("dBottomright", exam.getOrganDentureBottomright());
			
			//咽喉
			map.put("guttur", exam.getOrganGuttur());			
			//左眼视力
			map.put("visionLeft", exam.getOrganVisionLeft());	
			//右眼视力
			map.put("visionRight", exam.getOrganVisionRight());	
			//左眼矫正视力
			map.put("cvisionLeft", exam.getOrganCorrectedvisionLeft());	
			//右眼矫正视力
			map.put("cvisionRight", exam.getOrganCorrectedvisionRight());	
			//听力
			map.put("hearing", exam.getOrganHearing());	
			//运动功能
			map.put("movement", exam.getOrganMovement());	
			//眼底
			map.put("eye", exam.getExaminationEye());	
			//眼底异常描述
			map.put("eyeOther", exam.getExaminationEyeOther());	
			//皮肤
			map.put("skin", exam.getExaminationSkin());	
			//皮肤其他
			map.put("skinOther", exam.getExaminationSkinOther());	
			//巩膜
			map.put("sclera", exam.getExaminationSclera());	
			//巩膜其他
			map.put("scleraOther", exam.getExaminationScleraOther());	
			//淋巴结
			map.put("lymph", exam.getExaminationLymph());	
			//淋巴结其他
			map.put("lymphOther", exam.getExaminationLymphOther());
			
			//桶状胸
			map.put("barrel", exam.getExaminationBarrelChest());			
			//呼吸音
			map.put("breath", exam.getExaminationBreathSounds());
			//呼吸音异常描述
			map.put("breathOther", exam.getExaminationBreathOther());			
			//罗音
			map.put("rale", exam.getExaminationRale());	
			//罗音其他
			map.put("raleOther", exam.getExaminationRaleOther());
			//心率
			map.put("heartRate", exam.getExaminationHeartRate());
			//心律
			map.put("rhythm", exam.getExaminationHeartRhythm());
			//心脏杂音
			map.put("heartNoise", exam.getExaminationHeartNoise());
			//杂音其他说明
			map.put("noiseOther", exam.getExaminationNoiseOther());

			//腹部压痛
			map.put("tenderness", exam.getExaminationAbdomenTenderness());
			//腹部压痛描述
			map.put("tendernessMemo", exam.getExaminationTendernessMemo());
			//包块
			map.put("mass", exam.getExaminationAbdomenMass());
			//包块描述
			map.put("massMemo", exam.getExaminationMassMemo());
			//腹部肝大
			map.put("hepatomegaly", exam.getExaminationAbdomenHepatomegaly());			
			//腹部肝大描述
			map.put("hepatomegalyMemo", exam.getExaminationHepatomegalyMemo());	
			//腹部脾大
			map.put("splenomegaly", exam.getExaminationAbdomenSplenomegaly());	
			//腹部脾大描述
			map.put("splenomegalyMemo", exam.getExaminationSplenomegalyMemo());				
			//移动性浊音
			map.put("shiftingdullness", exam.getExaminationAbdomenShiftingdullness());	
			//移动性浊音描述
			map.put("shiftingdullnessMemo", exam.getExaminationShiftingdullnessMemo());	
			
			//下肢水肿
			map.put("edema", exam.getExaminationLowerextremityEdema());	
			//足背动脉搏动
			map.put("dorsal", exam.getExaminationDorsalArtery());	
			//肛门指诊
			map.put("anus", exam.getExaminationAnus());			
			//肛门指诊其他
			map.put("anusOther", exam.getExaminationAnusOther());	
			//乳腺
			String breasts = exam.getExaminationBreast();
			if(!"".equals(breasts)){
				String[] b = breasts.split(",");
				for(int i = 1; i <= b.length; i++){
					map.put("breast" + i , b[i -1]);
				}
			}
			//乳腺其他
			map.put("breastOther", exam.getExaminationBreastOther());

			//妇科外阴
			map.put("vulva", exam.getExaminationWomanVulva());
			//外阴异常描述
			map.put("vulvaMemo", exam.getExaminationVulvaMemo());
			//妇科阴道
			map.put("vagina", exam.getExaminationWomanVagina());	
			//阴道异常描述
			map.put("vaginaMemo", exam.getExaminationVaginaMemo());			
			//妇科宫颈
			map.put("cervix", exam.getExaminationWomanCervix());	
			//宫颈异常描述
			map.put("cervixMemo", exam.getExaminationCervixMemo());
			//妇科宫体
			map.put("corpus", exam.getExaminationWomanCorpus());
			//宫体异常描述
			map.put("corpusMemo", exam.getExaminationCorpusMemo());
			//妇科附件
			map.put("accessories", exam.getExaminationWomanAccessories());
			//附件异常描述
			map.put("accessoriesMemo", exam.getExaminationAccessoriesMemo());
			//查体其他
			map.put("examOther", exam.getExaminationOther());
			
			//血红蛋白
			map.put("hemoglobin", exam.getBloodHemoglobin());			
			//白细胞
			map.put("leukocyte", exam.getBloodLeukocyte());	
			//血小板
			map.put("platelet", exam.getBloodPlatelet());	
			//血常规其他
			map.put("bloodOther", exam.getBloodOther());
			//尿蛋白
			map.put("protein", exam.getUrineProtein());	
			//尿糖
			map.put("glycosuria", exam.getGlycosuria());	
			//尿酮体
			map.put("acetone", exam.getUrineAcetoneBodies());
			//尿潜血
			map.put("bld", exam.getBld());
			//尿常规其他
			map.put("urineOther", exam.getUrineOther());
			//空腹血糖mol
			map.put("mmol", exam.getBloodGlucoseMmol());
			//空腹血糖mg
			map.put("mg", exam.getBloodGlucoseMg());
			//心电图
			map.put("cardiogram", exam.getCardiogram());
			//心电图心电图描述
			map.put("cardiogramMemo", exam.getCardiogramMemo());			
			//尿微量白蛋白
			map.put("microalbuminuria", exam.getMicroalbuminuria());	
			//大便潜血
			map.put("fob", exam.getFob());	
			//糖化血红蛋白
			map.put("glyHemoglobin", exam.getGlycosylatedHemoglobin());	
			//乙型肝炎表面抗原
			map.put("hb", exam.getHb());	
			
			//血清谷丙转氨酶
			map.put("sgft", exam.getSgft());				
			//血清谷草转氨酶
			map.put("ast", exam.getAst());	
			//白蛋白
			map.put("albumin", exam.getAlbumin());	
			//总胆红素
			map.put("tBilirubin", exam.getTotalBilirubin());
			//结合胆红素
			map.put("cBilirubin", exam.getConjugatedBilirubin());
			//血清肌酐
			map.put("scr", exam.getScr());
			//血尿素
			map.put("urea", exam.getBloodUrea());
			//血钾浓度
			map.put("bloodK", exam.getBloodK());
			//血钠浓度
			map.put("bloodNa", exam.getBloodNa());
			//总胆固醇
			map.put("tc", exam.getTc());
			//甘油三酯
			map.put("tg", exam.getTg());
			//血清低密度脂蛋白胆固醇
			map.put("ldl", exam.getLdl());			
			//血清高密度脂蛋白胆固醇
			map.put("hdl", exam.getHdl());	
			
			//胸部X线片
			map.put("chestX", exam.getChestX());
			//X线片描述
			map.put("xMemo", exam.getXMemo());
			//腹部B超
			map.put("ultrasound", exam.getUltrasoundAbdomen());
			//腹部B超异常描述
			map.put("ultrasoundMemo", exam.getUltrasoundMemo());
			//其他B超
			map.put("otherB", exam.getOtherB());
			//其他B超异常描述
			map.put("otherbMemo", exam.getOtherbMemo());
			//宫颈涂片
			map.put("smear", exam.getCervicalSmear());
			//宫颈涂片异常描述
			map.put("smearMemo", exam.getCervicalSmearMemo());			
			//其他辅助检查
			map.put("other", exam.getOther());
			
			//脑血管疾病
			String cere = exam.getCerebrovascularDisease();
			if(!"".equals(cere)){
				String[] c = cere.split(",");
				for(int i = 1; i <= c.length; i++){
					map.put("cere" + i , c[i-1]);
				}
			}
			//其他脑血管疾病
			map.put("cereother", exam.getCerebrovascularDiseaseOther());			
			//肾脏疾病
			String kidn = exam.getKidneyDisease();
			if(!"".equals(kidn)){
				String[] k = kidn.split(",");
				for(int i = 1; i <= k.length; i++){
					map.put("kidn" + i , k[i-1]);
				}
			}	
			//肾脏疾病其他
			map.put("kidnother", exam.getKidneyDiseaseOther());	
			//心脏疾病
			String heart = exam.getHeartDisease();
			if(!"".equals(heart)){
				String[] h = heart.split(",");
				for(int i = 1; i <= h.length; i++){
					map.put("heart" + i , h[i-1]);
				}
			}
			//其他心脏疾病
			map.put("heartother", exam.getHeartDiseaseOther());	
			//血管疾病
			String vas = exam.getVascularDisease();
			if(!"".equals(vas)){
				String[] v = vas.split(",");
				for(int i = 1; i <= v.length; i++){
					map.put("vas" + i , v[i-1]);
				}
			}
			//其他血管疾病
			map.put("vasother", exam.getVascularDiseaseOther());				
			//眼部疾病
			String ocu = exam.getOcularDiseases();
			if(!"".equals(ocu)){
				String[] o = ocu.split(",");
				for(int i = 1; i <= o.length; i++){
					map.put("ocu" + i , o[i-1]);
				}
			}
			//其他眼部疾病
			map.put("ocuother", exam.getOcularDiseasesOther());
			//神经系统疾病
			map.put("nervous", exam.getNervousSystemDisease());			
			//神经系统疾病描述
			map.put("nervousMemo", exam.getNervousDiseaseMemo());	
			//其他系统疾病
			map.put("oDisease", exam.getOtherDisease());			
			//其他疾病描述
			map.put("oDiseaseMemo", exam.getOtherDiseaseMemo());
			
			List<HospitalizedRecord> hosps = hospitalizedRecordDao.findRecordByExamId(exam.getId());
			if(hosps != null && hosps.size() > 0){
				int h = 0;
				int f = 0;
				for(int i = 0; i < hosps.size(); i++){
					HospitalizedRecord hos = hosps.get(i);
					int type = hos.getHospitalizedType();
					if(type == 1){
						h = h + 1;
						map.put("hospin" + h, hos.getInHospitalTime());
						map.put("hospput" + h, hos.getLeaveHospitalTime());
						map.put("hospreason" + h, hos.getReason());
						map.put("hosporg" + h, hos.getHospitalOrgan());
						map.put("hospcase" + h, hos.getCaseCode());
					}else{
						f = f + 1;
						map.put("famin" + f, hos.getInHospitalTime());
						map.put("famput" + f, hos.getLeaveHospitalTime());
						map.put("famreason" + f, hos.getReason());
						map.put("famorg" + f, hos.getHospitalOrgan());
						map.put("famcase" + f, hos.getCaseCode());						
					}
					
				}
			}
			
			List<TakeMedicineRecord> meds = takeMedicineRecordDao.findRecordByExamId(exam.getId());
			if(meds != null && meds.size() > 0){
				for(int i = 1; i <= meds.size(); i++){
					TakeMedicineRecord take = meds.get(i-1);
					map.put("medName" + i, take.getMedicineName());
					map.put("medUsage" + i, take.getMedicineUsage());
					map.put("medDosage" + i, take.getMedicineDosage());
					map.put("medTime" + i, take.getMedicineTime());
					map.put("medCompliance" + i, take.getMedicineCompliance());
				}
			}
		
			List<VaccinationRecord> vaccs = vaccinationRecordDao.findRecordByExamId(exam.getId());
			if(vaccs != null && vaccs.size() > 0){
				for(int i = 1; i <= vaccs.size(); i++){
					VaccinationRecord vac = vaccs.get(i-1);
					map.put("vaccName" + i, vac.getVaccinationName());
					map.put("vaccTime" + i, vac.getVaccinationTime());
					map.put("vaccOrg" + i, vac.getVaccinationOrganName());
				}
			}
	
			//健康评价
			map.put("isHeredity", exam.getHealthEvaluation());
			
			map.put("abnormal1", exam.getAbnormal1());
			map.put("abnormal2", exam.getAbnormal2());
			map.put("abnormal3", exam.getAbnormal3());
			map.put("abnormal4", exam.getAbnormal4());
			//健康指导
			String guidance = exam.getHealthGuidance();
			if(!"".equals(guidance)){
				String[] gui = guidance.split(",");
				for(int i = 1; i <= gui.length; i++){
					map.put("gui" + i , gui[i-1]);
				}
			}
			
			//危险因素控制
			String danger = exam.getDangerControlling();
			if(!"".equals(danger)){
				String[] d = danger.split(",");
				for(int i = 1; i <= d.length; i++){
					map.put("danger" + i , d[i-1]);
				}
			}	
			//目标体重
			map.put("targetWeight", exam.getTargetWeight());
			//其他危险因素控制
			map.put("dangerOther", exam.getDangerControllingOther());
			//建议接种疫苗
			map.put("bacterin", exam.getAdviseBacterin());
			//健康建议
			map.put("advice", exam.getHealthAdvice());
			
		}
		return map;
	}



	@Override
	public PageInfos<ExaminationListVo> findPhysicalExaminationByPage(ResidentBaseInfoQuery record,
			PageInfos<ResidentBaseInfo> pageData) {
		
		PageHelper.startPage( (int)pageData.getPage(), (int)pageData.getPageSize());//pageNum, pageSize
		List<ResidentBaseInfo> list = residentBaseInfoDao.findResidentList(record);
		PageInfo<ResidentBaseInfo> page = new PageInfo<ResidentBaseInfo>(list);
		
		PageInfos<ExaminationListVo> examPage = new PageInfos<ExaminationListVo>();
		List<ExaminationListVo> voList = new ArrayList<ExaminationListVo>();
		for(int i = 0 ; i < list.size(); i++){
			ExaminationListVo vo = new ExaminationListVo();
			BeanUtils.copyProperties(list.get(i),vo);
			PhysicalExamination exam = physicalExaminationDao.getLastByArchiveNo(vo.getArchiveNo());
			if(exam != null){
				vo.setExamId(exam.getId());
				vo.setCheckDate(exam.getCheckDate());
			}
			
			voList.add(vo);
		}
		examPage.setPage(page.getPageNum());      //当前页码
		examPage.setPageCount(page.getPages());   //总页数
		examPage.setPageSize(page.getPageSize()); //每页记录数
		examPage.setTotal(page.getTotal());       //总记录数
		examPage.setRows(voList);
		return examPage;
	}



	@Override
	public TjDataVo findTjData(String archiveNo) {
		TjDataVo data = new TjDataVo();
		data.setArchiveNo(archiveNo);
		List<ResidentBaseInfo> list = residentBaseInfoDao.findResidentByArchiveNo(archiveNo);
		if(list != null && list.size() > 0){			
			data.setIdNumber(list.get(0).getIdNumber());
			data.setName(list.get(0).getName());
		}
		List<TjNcg> ncgList = tjNcgDao.findListByAichiveNo(archiveNo);
		data.setNcgList(ncgList);
		List<TjSgtz> sgtzList = tjSgtzDao.findListByAichiveNo(archiveNo);
		data.setSgtzList(sgtzList);
		List<TjSh> shList = tjShDao.findListByAichiveNo(archiveNo);
		data.setShList(shList);
		List<TjXcg> xcgList = tjXcgDao.findListByAichiveNo(archiveNo);
		data.setXcgList(xcgList);
		List<TjXy> xyList = tjXyDao.findListByAichiveNo(archiveNo);
		data.setXyList(xyList);
		List<TjBc> bcList = tjBcDao.findListByAichiveNo(archiveNo);
		TjBc tjBc = null;
		String bupic01 = "";
		String bupic02 = "";
		for (int i = 0; i < bcList.size(); i++) {
			tjBc = bcList.get(i);
			bupic01 = tjBc.getBupic01();
			bupic02 = tjBc.getBupic02();
			if(!StringUtil.isEmpty(bupic01)) {
				String presignedURL01 = AliOssUtil.presignedURL("bctp2019", bupic01);
				tjBc.setBupic01(presignedURL01);
			}
			if(!StringUtil.isEmpty(bupic02)) {
				String presignedURL02 = AliOssUtil.presignedURL("bctp2019", bupic02);
				tjBc.setBupic02(presignedURL02);
			}
		}
		ArrayList<TjBc> arrayList = new ArrayList<TjBc>();
		arrayList.add(tjBc);
		data.setBcList(arrayList);
		List<TjXdt> xdtList = tjXdtDao.findListByAichiveNo(archiveNo);
		TjXdt tjXdt = null;
		String imageurl = "";
		for(int j = 0; j < xdtList.size();j++) {
			tjXdt = xdtList.get(j);
			imageurl = tjXdt.getImageurl();
			if(!StringUtil.isEmpty(imageurl)) {
				String presignedURL01 = AliOssUtil.presignedURL("xdtp2019", imageurl);
				tjXdt.setImageurl(presignedURL01);
			}
		}
		ArrayList<TjXdt> TjXdtList = new ArrayList<TjXdt>();
		TjXdtList.add(tjXdt);
		data.setXdtList(TjXdtList);
		return data;
	}	
	
}
