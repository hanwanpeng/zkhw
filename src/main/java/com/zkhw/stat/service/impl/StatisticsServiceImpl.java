package com.zkhw.stat.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.util.StringUtil;
import com.zkhw.flup.dao.DiabetesFollowRecordDao;
import com.zkhw.flup.dao.GravidaInfoDao;
import com.zkhw.flup.dao.HypertensionDao;
import com.zkhw.flup.dao.NeonatusInfoDao;
import com.zkhw.flup.entity.DiabetesFollowRecord;
import com.zkhw.flup.entity.Hypertension;
import com.zkhw.ltd.dao.OrganizationDao;
import com.zkhw.ltd.dao.UserDao;
import com.zkhw.ltd.entity.Organization;
import com.zkhw.pub.dao.ElderlySelfcareEstimateDao;
import com.zkhw.pub.dao.ElderlyTcmRecordDao;
import com.zkhw.pub.dao.PhysicalExaminationDao;
import com.zkhw.pub.dao.ResidentBaseInfoDao;
import com.zkhw.pub.entity.PhysicalExamination;
import com.zkhw.pub.entity.ResidentBaseInfo;
import com.zkhw.stat.query.ResidentQuery;
import com.zkhw.stat.service.StatisticsService;
import com.zkhw.stat.vo.ChildVo;
import com.zkhw.stat.vo.ElderlyEstimateVo;
import com.zkhw.stat.vo.ElderlyRecordVo;
import com.zkhw.stat.vo.ElderlyVo;
import com.zkhw.stat.vo.FlupVo;
import com.zkhw.stat.vo.GravidaVo;
import com.zkhw.stat.vo.PersonVo;
import com.zkhw.stat.vo.PhysicalVo;
import com.zkhw.stat.vo.ResidentAgeVo;
import com.zkhw.stat.vo.StatResidentVo;
import com.zkhw.stat.vo.StatisticsVo;

@Service
public class StatisticsServiceImpl implements StatisticsService {

	@Resource
	private UserDao userDao;
	
	@Autowired
	private OrganizationDao organizationDao;
	
	@Autowired
	private ResidentBaseInfoDao residentBaseInfoDao;
	
	@Autowired
	private StatisticsService statisticsService;
	
	@Autowired
	private PhysicalExaminationDao physicalExaminationDao;
	
	@Autowired
	private ElderlySelfcareEstimateDao elderlySelfcareEstimateDao;
	
	@Autowired
	private ElderlyTcmRecordDao elderlyTcmRecordDao;
	
	@Autowired
	private NeonatusInfoDao neonatusInfoDao;
	
	@Autowired
	private GravidaInfoDao gravidaInfoDao;
	
	@Autowired
	private HypertensionDao hypertensionDao;
	
	@Autowired
	private DiabetesFollowRecordDao diabetesFollowRecordDao;
	
	
	/**
	 * 个人统计（通过身份证号查询）-小程序
	 */
	@Override
	public PersonVo statForIdNumber(ResidentQuery query) {
		PersonVo personVo = residentBaseInfoDao.statForIdNumber(query);
		
		//高血压走势
		Integer isHypertension = personVo.getIsHypertension();
		List<Hypertension> hypertensionList = null;
		if(isHypertension != null && isHypertension == 1 ) {
			hypertensionList = hypertensionDao.statForIdNumber(query);
			personVo.setHypertensionList(hypertensionList);
		}
		//糖尿病走势
		Integer isDiabetes = personVo.getIsDiabetes();
		List<DiabetesFollowRecord> diabetesFollowRecordList = null;
		if(isDiabetes != null && isDiabetes == 1) {
			diabetesFollowRecordList = diabetesFollowRecordDao.statForIdNumber(query);
			personVo.setDiabetesFollowRecordList(diabetesFollowRecordList);
		}
		return personVo;
	}
	
	
	/**
	 * 孕产妇统计
	 */
	@Override
	public GravidaVo statForGravida(ResidentQuery query) {
		GravidaVo gravidaVo = gravidaInfoDao.statForGravida(query);
		return gravidaVo;
	}
	
	
	/**
	 * 0-6岁儿童统计
	 */
	@Override
	public ChildVo statForChild(ResidentQuery query) {
		ChildVo childVo = neonatusInfoDao.statForChild(query);
		return childVo;
	}
	
	
	/**
	 * 慢病随访统计
	 */
	@Override
	public FlupVo statForFlup(ResidentQuery query) {
		//已经随访的慢病人数
		List<FlupVo> flupVoList = residentBaseInfoDao.statForFlup(query);
		FlupVo flupVo = flupVoList.get(0);
		//慢病人数
		StatResidentVo statResident = residentBaseInfoDao.statResidentForMan(query);
		if(statResident != null) {
			flupVo.setHypertensionTotal(statResident.getHypertensionNum());//高血压总人数
			flupVo.setDiabetesTotal(statResident.getDiabetesNum());//糖尿病总人数
			flupVo.setTuberculosisTotal(statResident.getTuberculosisNum());//肺结核总人数
			flupVo.setPsychosisTotal(statResident.getPsychosisNum());//精神病总人数
		}
		return flupVo;
	}
	
	
	/**
	 * 老年人统计
	 */
	@Override
	public ElderlyVo statForElderly(ResidentQuery query) {
		//老年人体检数
		ElderlyVo elderlyVo = residentBaseInfoDao.statForElderly(query);
		Integer elderlyYet = elderlyVo.getElderlyYet();
		//65岁老年总人数
		List<ElderlyVo> elderlyVoList = residentBaseInfoDao.statForElderlyNnm(query);
		Integer elderlyNum = null;
		if(elderlyVoList != null && !elderlyVoList.isEmpty()) {
			elderlyNum = elderlyVoList.get(0).getElderlyNum();
		}
		//未体检的人数
		Integer elderlyNo = elderlyNum - elderlyYet;
		elderlyVo.setElderlyNo(elderlyNo);
		elderlyVo.setElderlyNum(elderlyNum);
		
		//生活自理人数
		ElderlyEstimateVo estimateNum = elderlySelfcareEstimateDao.statForEstimate(query);
		if(estimateNum!=null) {
			elderlyVo.setEstimateNum(estimateNum.getEstimateNum());
	}
		
		//中医体质辨识人数
		List<ElderlyRecordVo> recordNumList = elderlyTcmRecordDao.statForRecord(query);
		if(recordNumList != null && !recordNumList.isEmpty()) {
			elderlyVo.setRecordNum(recordNumList.get(0).getRecordNum());
		}
		
		
		return elderlyVo;
	}
	
	
	/**
	 * 重点人群统计
	 */
	@Override
	public StatResidentVo statForSpecialMan(ResidentQuery query) {
		StatResidentVo statResidentVo = new StatResidentVo();
		StatResidentVo statResident = residentBaseInfoDao.statResidentForMan(query);
		statResidentVo.setElderNum(statResident.getElderNum());//老年人
		statResidentVo.setHypertensionNum(statResident.getHypertensionNum());//高血压
		statResidentVo.setNewlyHypertensionNum(statResident.getHypertensionNum());//新增高血压人数
		statResidentVo.setDiabetesNum(statResident.getDiabetesNum());//糖尿病
		statResidentVo.setNewlyDiabetesNum(statResident.getDiabetesNum());//新增糖尿病人数
		statResidentVo.setTuberculosisNum(statResident.getTuberculosisNum());//结核病人数
		statResidentVo.setNewlyTuberculosisNum(statResident.getTuberculosisNum());//新增结核病人数
		statResidentVo.setPsychosisNum(statResident.getPsychosisNum());//精神病人数
		statResidentVo.setNewlyPsychosisNum(statResident.getPsychosisNum());//新增精神病人数
		statResidentVo.setPoorNum(statResident.getPoorNum());//贫困人数
		return statResidentVo;
	}
	
	
	/**
	 * 年龄段分布统计(男女)
	 */
	@Override
	public ResidentAgeVo statForAge(ResidentQuery query) {
		
		List<ResidentBaseInfo> resident = residentBaseInfoDao.statForAge(query);
		ResidentAgeVo residentAgeVo = new ResidentAgeVo();
		ResidentBaseInfo residentBaseInfo = null;
		Integer age = null;
		String sex = null;
		int manSixAgeNum = 0;
		int womanSixAgeNum = 0;
		int manTwentyFiveAgeNum = 0;
		int womanTwentyFiveAgeNum = 0;
		int manSixtyFourAgeNum = 0;
		int womanSixtyFourAgeNum = 0;
		int manSixtyFiveAgeNum = 0;
		int womanSixtyFiveAgeNum = 0;
		for (int i = 0; i < resident.size(); i++) {
			residentBaseInfo = resident.get(i);
			age = residentBaseInfo.getAge();
			sex = residentBaseInfo.getSex();
			if(age <= 6 && sex.equals("1")) {//0-6岁人数 1男
				manSixAgeNum += 1;
			}
			if(age <= 6 && sex.equals("2")) {//0-6岁人数 2女
				womanSixAgeNum += 1;
			}
			if(age >= 7 && age <= 25 && sex.equals("1")) {//7-25岁人数1男
				manTwentyFiveAgeNum += 1;
			}
			if(age >= 7 && age <= 25 && sex.equals("2")) {//7-25岁人数2女
				womanTwentyFiveAgeNum += 1;
			}
			if(age >= 26 && age <= 64 && sex.equals("1")) {//26-64岁人数1男
				manSixtyFourAgeNum += 1;
			}
			if(age >= 26 && age <= 64 && sex.equals("2")) {//26-64岁人数2女
				womanSixtyFourAgeNum += 1;
			}
			if(age >= 65 && sex.equals("1")) {//65岁及以上人数1男
				manSixtyFiveAgeNum += 1;
			}
			if(age >= 65 && sex.equals("2")) {//65岁及以上人数2女
				womanSixtyFiveAgeNum += 1;
			}
			
		}
		
		residentAgeVo.setTotalSixAgeNum(manSixAgeNum + womanSixAgeNum);
		residentAgeVo.setManSixAgeNum(manSixAgeNum);
		residentAgeVo.setWomanSixAgeNum(womanSixAgeNum);
		
		residentAgeVo.setTotalTwentyFiveAgeNum(manTwentyFiveAgeNum + womanTwentyFiveAgeNum);
		residentAgeVo.setManTwentyFiveAgeNum(manTwentyFiveAgeNum);
		residentAgeVo.setWomanTwentyFiveAgeNum(womanTwentyFiveAgeNum);
		
		residentAgeVo.setTotalSixtyFourAgeNum(manSixtyFourAgeNum + womanSixtyFourAgeNum);
		residentAgeVo.setManSixtyFourAgeNum(manSixtyFourAgeNum);
		residentAgeVo.setWomanSixtyFourAgeNum(womanSixtyFourAgeNum);
		
		residentAgeVo.setTotalSixtyFiveAgeNum(manSixtyFiveAgeNum + womanSixtyFiveAgeNum);
		residentAgeVo.setManSixtyFiveAgeNum(manSixtyFiveAgeNum);
		residentAgeVo.setWomanSixtyFiveAgeNum(womanSixtyFiveAgeNum);
		
		
		
		
		
		return residentAgeVo;
	}
	
	
	
	/**
	 * 按地区统计
	 */
	@Override
	public StatisticsVo statForArea(ResidentQuery query) {
		
		String villageCode = query.getVillageCode();
		String townsCode = query.getTownsCode();
		String countyCode = query.getCountyCode();
		String cityCode = query.getCityCode();
		String provinceCode = query.getProvinceCode();
		String createOrg = query.getCreateOrg();
		
		//根据当前登录用户的组织机构统计总人数
		StatisticsVo vo = physicalExaminationDao.allExamNum(query);
		Integer examTotalNum = vo.getExamTotalNum();//总人数
		
		ArrayList<PhysicalVo> arrayList = new ArrayList<PhysicalVo>();
		PhysicalVo physicalVo = new PhysicalVo();
		
		
		//按照村级查询
		if(!StringUtil.isEmpty(villageCode)) {
			//根据村地区编码查询组织机构编码
			Organization org = new Organization();
			org.setVillageCode(villageCode);
			List<Organization> orgList = organizationDao.selectByAreaCode(org);
			String villageName = orgList.get(0).getVillageName();
			String villCode = orgList.get(0).getVillageCode();
			
			String villageOrg = orgList.get(0).getOrganCode();
			//根据组织机构编码查询人数
			query.setCreateOrg(villageOrg);
			StatisticsVo villageNum = physicalExaminationDao.allExamNum(query);//村总人数
			if(villageNum.getExamTotalNum() != 0) {
				//男女人数
				List<PhysicalExamination> phyList = physicalExaminationDao.selectByOrg(villageOrg);
				int manNum = 0;
				int womanNum = 0;
					for(int j = 0; j < phyList.size(); j ++) {
						PhysicalExamination pe = phyList.get(j);
						String idNumber = pe.getIdNumber();
						if(18 == idNumber.length()) {
							String numStr = idNumber.substring(16, 17);
							int num = Integer.parseInt(numStr);
							if(num % 2 == 1) {//男 奇数
								manNum += 1;
							}
							if(num % 2 == 0) {//女 偶数
								womanNum += 1;
							}
						}
					}
					physicalVo.setName(villageName);
					physicalVo.setCode(villCode);
					physicalVo.setManNum(manNum);
					physicalVo.setWomanNum(womanNum);
					physicalVo.setVillageNum(villageNum.getExamTotalNum());
					arrayList.add(physicalVo);
				
			}
			
			
		}
		
		
		
		//地区是镇级
		if(!StringUtil.isEmpty(townsCode) && StringUtil.isEmpty(villageCode)) {
			//根据地区编码查询组织机构编码
			Organization org = new Organization();
			BeanUtils.copyProperties(query,org);
			//org.setTownsCode(townsCode);
			List<Organization> orgList = organizationDao.selectByAreaCode(org);
			String townsOrganCode = orgList.get(0).getOrganCode();
			//查询镇级以下的村级组织机构编码
			List<Organization> childOrgan = organizationDao.findChildren(townsOrganCode);
			StatisticsVo villageNum = null;
			Integer villNum = 0;
			//遍历统计所有村级机构的人数
			for (int i = 0; i < childOrgan.size(); i++) {
				Organization organization = childOrgan.get(i);
				String villageName = organization.getVillageName();
				String villCode = organization.getVillageCode();
				
				String childOrg = organization.getOrganCode();
				query.setCreateOrg(childOrg);
				villageNum = physicalExaminationDao.allExamNum(query);//村总人数
				villNum += villageNum.getExamTotalNum();
				if(villageNum.getExamTotalNum() != 0) {
					//查询男女的人数
					List<PhysicalExamination> phyList = physicalExaminationDao.selectByOrg(childOrg);
					int manNum = 0;
					int womanNum = 0;
						for(int j = 0; j < phyList.size(); j ++) {
							PhysicalExamination pe = phyList.get(j);
							String idNumber = pe.getIdNumber();
							if(18 == idNumber.length()) {
								String numStr = idNumber.substring(16, 17);
								int num = Integer.parseInt(numStr);
								if(num % 2 == 1) {//男 奇数
									manNum += 1;
								}
								if(num % 2 == 0) {//女 偶数
									womanNum += 1;
								}
							}
						}
						physicalVo.setName(villageName);
						physicalVo.setCode(villCode);
						physicalVo.setManNum(manNum);
						physicalVo.setWomanNum(womanNum);
						physicalVo.setVillageNum(villageNum.getExamTotalNum());
						arrayList.add(physicalVo);
				}
			}
			vo.setExamTotalNum(villNum);
		}
		
		
		//地区是县级
		if(!StringUtil.isEmpty(countyCode) && StringUtil.isEmpty(townsCode) && StringUtil.isEmpty(villageCode)) {
			//根据地区编码查询组织机构编码
			Organization org = new Organization();
			BeanUtils.copyProperties(query,org);
			//org.setProvinceCode(provinceCode);
			//org.setCityCode(cityCode);
			//org.setCountyCode(countyCode);
			List<Organization> orgList = organizationDao.selectByAreaCode(org);
			for (int i = 0; i < orgList.size(); i++) {
				String countyOrganCode = orgList.get(i).getOrganCode();
			
			//String countyOrganCode = orgList.get(0).getOrganCode();
				//查询县级以下的镇级组织机构编码
				List<Organization> childOrgan = organizationDao.findChildren(countyOrganCode);
				if(childOrgan.size() != 0) {
					StatisticsVo townsNum = null;
					Integer townNum = 0;
					//遍历统计所有村级机构的人数
					for (int z = 0; z < childOrgan.size(); z++) {
						Organization organization = childOrgan.get(z);
						String code = organization.getTownsCode();
						String name = organization.getTownsName();
						String childOrg = organization.getOrganCode();
						query.setCreateOrg(childOrg);
						townsNum = physicalExaminationDao.allExamNum(query);//镇总人数
						townNum += townsNum.getExamTotalNum();
						if(townsNum.getExamTotalNum() != 0) {
							
							//查询男女的人数
							List<PhysicalExamination> phyList = physicalExaminationDao.selectByOrg(childOrg);
							int manNum = 0;
							int womanNum = 0;
								for(int j = 0; j < phyList.size(); j ++) {
									PhysicalExamination pe = phyList.get(j);
									String idNumber = pe.getIdNumber();
									if(18 == idNumber.length()) {
										String numStr = idNumber.substring(16, 17);
										int num = Integer.parseInt(numStr);
										if(num % 2 == 1) {//男 奇数
											manNum += 1;
										}
										if(num % 2 == 0) {//女 偶数
											womanNum += 1;
										}
									}
									
								}
								physicalVo.setCode(code);
								physicalVo.setName(name);
								physicalVo.setManNum(manNum);
								physicalVo.setWomanNum(womanNum);
								physicalVo.setVillageNum(townsNum.getExamTotalNum());
								arrayList.add(physicalVo);
						}
							
						}
					vo.setExamTotalNum(townNum);
				}
			}
			
		}
		
		
		//地区是市级
		if(!StringUtil.isEmpty(cityCode) && StringUtil.isEmpty(countyCode)) {
			//根据地区编码查询组织机构编码
			Organization org = new Organization();
			org.setCityCode(cityCode);
			List<Organization> orgList = organizationDao.selectByAreaCode(org);
			String cityOrganCode = orgList.get(0).getOrganCode();
			//查询县级以下的镇级组织机构编码
			List<Organization> childOrgan = organizationDao.findChildren(cityOrganCode);
			StatisticsVo countyNum = null;
			//遍历统计所有村级机构的人数
			for (int i = 0; i < childOrgan.size(); i++) {
				Organization organization = childOrgan.get(i);
				String childOrg = organization.getOrganCode();
				query.setCreateOrg(childOrg);
				countyNum = physicalExaminationDao.allExamNum(query);//县总人数
				
				//查询男女的人数
				List<PhysicalExamination> phyList = physicalExaminationDao.selectByOrg(childOrg);
				int manNum = 0;
				int womanNum = 0;
					for(int j = 0; j < phyList.size(); j ++) {
						PhysicalExamination pe = phyList.get(j);
						String idNumber = pe.getIdNumber();
						String numStr = idNumber.substring(16, 17);
						int num = Integer.parseInt(numStr);
						if(num % 2 == 1) {//男 奇数
							manNum += 1;
						}
						if(num % 2 == 0) {//女 偶数
							womanNum += 1;
						}
					}
					physicalVo.setManNum(manNum);
					physicalVo.setWomanNum(womanNum);
					physicalVo.setVillageNum(countyNum.getExamTotalNum());
					arrayList.add(physicalVo);
			}
		}
		
		
		vo.setPhysicalList(arrayList);
		return vo;
	}



	
}
