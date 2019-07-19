package com.wuzhou.pub.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuzhou.pub.dao.ElderExamLedgerDao;
import com.wuzhou.pub.dao.ElderInfoDao;
import com.wuzhou.pub.dao.ElderSelfcareAbilityDao;
import com.wuzhou.pub.dao.ElderTcmHealthDao;
import com.wuzhou.pub.dao.HealthExamDao;
import com.wuzhou.pub.dao.HealthExamDrugDao;
import com.wuzhou.pub.dao.HealthExamInhosDao;
import com.wuzhou.pub.dao.HealthExamNoplanvaccDao;
import com.wuzhou.pub.dao.PosDao;
import com.wuzhou.pub.entity.ElderExamLedger;
import com.wuzhou.pub.entity.ElderInfo;
import com.wuzhou.pub.entity.ElderSelfcareAbility;
import com.wuzhou.pub.entity.ElderTcmHealth;
import com.wuzhou.pub.entity.HealthExam;
import com.wuzhou.pub.entity.HealthExamDrug;
import com.wuzhou.pub.entity.HealthExamInhos;
import com.wuzhou.pub.entity.HealthExamNoplanvacc;
import com.wuzhou.pub.entity.Pos;
import com.wuzhou.pub.service.WuzhouSynService;
import com.wuzhou.pub.utils.CodeToValue;
import com.wuzhou.pub.utils.ConvertObjectData;
import com.zkhw.common.utils.CodeUtil;
import com.zkhw.framework.utils.DateUtil;
import com.zkhw.ltd.dao.OrganizationDao;
import com.zkhw.ltd.entity.Organization;
import com.zkhw.pub.dao.ElderlySelfcareEstimateDao;
import com.zkhw.pub.dao.ElderlyTcmRecordDao;
import com.zkhw.pub.dao.HospitalizedRecordDao;
import com.zkhw.pub.dao.PhysicalExaminationDao;
import com.zkhw.pub.dao.ResidentBaseInfoDao;
import com.zkhw.pub.dao.TakeMedicineRecordDao;
import com.zkhw.pub.dao.VaccinationRecordDao;
import com.zkhw.pub.entity.ElderlySelfcareEstimate;
import com.zkhw.pub.entity.ElderlyTcmRecord;
import com.zkhw.pub.entity.HospitalizedRecord;
import com.zkhw.pub.entity.PhysicalExamination;
import com.zkhw.pub.entity.ResidentBaseInfo;
import com.zkhw.pub.entity.TakeMedicineRecord;
import com.zkhw.pub.entity.VaccinationRecord;

@Service
public class WuzhouSynServiceImpl implements WuzhouSynService {

	@Autowired
	private ResidentBaseInfoDao residentBaseInfoDao; 
	
	@Autowired
	private PhysicalExaminationDao physicalExaminationDao;
	
	@Autowired
	private HealthExamDao healthExamDao;

	@Autowired
	private HospitalizedRecordDao hospitalizedRecordDao;
	
	@Autowired
	private TakeMedicineRecordDao takeMedicineRecordDao;
	
	@Autowired
	private VaccinationRecordDao vaccinationRecordDao;
	
	@Autowired
	private ElderlySelfcareEstimateDao elderlySelfcareEstimateDao;
	
	@Autowired
	private ElderlyTcmRecordDao elderlyTcmRecordDao;
	
	@Autowired
	private HealthExamInhosDao healthExamInhosDao;
	
	@Autowired
	private HealthExamDrugDao healthExamDrugDao;
	
	@Autowired
	private HealthExamNoplanvaccDao healthExamNoplanvaccDao;
	
	@Autowired
	private ElderSelfcareAbilityDao elderSelfcareAbilityDao;
	
	@Autowired
	private ElderTcmHealthDao elderTcmHealthDao;
	
	@Autowired
	private PosDao posDao;
	
	@Autowired
	private OrganizationDao organizationDao;
	
	@Autowired
	private ElderExamLedgerDao elderExamLedgerDao;
	
	@Autowired
	private ElderInfoDao elderInfoDao;
	
	@Override
	public void sync() {
		List<PhysicalExamination> list = physicalExaminationDao.findWuzhouSyncList();
		if(list != null && list.size() > 0){
			
			for(int i = 0; i < list.size(); i++){
				try{
					ResidentBaseInfo info = new ResidentBaseInfo();
					PhysicalExamination phy = list.get(i);
					
					List<ResidentBaseInfo> residents = residentBaseInfoDao.findResidentByArchiveNo(phy.getArchiveNo());
					if(residents != null && residents.size() > 0){
						info = residents.get(0);
					}
					HealthExam exam = ConvertObjectData.convertToHealthExam(phy,info);
									
					List<HospitalizedRecord> hosps = hospitalizedRecordDao.findRecordByExamId(phy.getId());
					if(hosps != null && hosps.size() > 0){
						for(int j = 0; j < hosps.size(); j++){
							HealthExamInhos in = ConvertObjectData.convertToInhos(hosps.get(j));
							healthExamInhosDao.insertSelective(in);
						}
					}
					List<TakeMedicineRecord> meds = takeMedicineRecordDao.findRecordByExamId(phy.getId());
					if(meds != null && meds.size() > 0){
						for(int j = 0; j < meds.size(); j++){
							HealthExamDrug drug = ConvertObjectData.convertToDrug(meds.get(j));
							healthExamDrugDao.insertSelective(drug);
						}
					}
	
					List<VaccinationRecord> vaccs = vaccinationRecordDao.findRecordByExamId(phy.getId());
					if(vaccs != null && vaccs.size() > 0){
						for(int j = 0; j < vaccs.size(); j++){
							HealthExamNoplanvacc va = ConvertObjectData.convertToVaccination(vaccs.get(j));
							healthExamNoplanvaccDao.insertSelective(va);
						}
					}
					
					List<ElderlySelfcareEstimate>  selfs = elderlySelfcareEstimateDao.findSelfcareListByExamid(phy.getId());
					if(selfs != null && selfs.size() > 0){
						ElderSelfcareAbility ability = ConvertObjectData.convertToSelfcare(selfs.get(0));
						elderSelfcareAbilityDao.insertSelective(ability);
	
					}
					
					List<ElderlyTcmRecord>  tcms = elderlyTcmRecordDao.findTcmListByExamId(phy.getId());
					if(tcms != null && tcms.size() > 0){
						ElderTcmHealth tcm = ConvertObjectData.convertToTcm(tcms.get(0));
						elderTcmHealthDao.insertSelective(tcm);
						exam = ConvertObjectData.addTcmToHealthExam(exam, tcms.get(0));
					}
					
					healthExamDao.insertSelective(exam);
					
					phy.setUploadStatus(1);
					phy.setUploadTime(new Date());
					
					physicalExaminationDao.updateByPrimaryKeySelective(phy);
					
					List<ElderInfo> elders = elderInfoDao.findByPersonInfoId(info.getId());
					if(elders != null && elders.size() > 0){
						ElderExamLedger leger = new ElderExamLedger();
						//65岁老年人体检管理台账ID
						leger.setElderExamLedgerId(CodeUtil.getUUID());
						//体检ID
						leger.setHealthExamId(phy.getId());
						//录入机构ID
						leger.setCreateOrgId(phy.getCreateOrg());
						//录入机构名称
						leger.setOrgName(phy.getCreateOrgName());
						//录入时间
						leger.setCreateTime(phy.getCreateTime());
						//录入人ID
						leger.setCreatorId(phy.getCreateUser());
						//录入人姓名
						leger.setCreator(phy.getCreateName());
						//体检日期
						leger.setExamDate(phy.getCreateTime());
						//个人档案ID
						leger.setPersonInfoId(info.getId());
						//本人姓名
						leger.setName(phy.getName());
						//身份证证号
						leger.setIdNo(phy.getIdNumber());
						//ABO血型
						leger.setAboCode(info.getBloodGroup());
						//地址
						leger.setAddress(info.getResidenceAddress());
						//老年人认知功能筛查
						leger.setElderCognition(phy.getBaseCognitionEstimate());
						//老年人抑郁情况筛查
						leger.setElderDepression(phy.getBaseFeelingEstimate());
						//自理能力评估结果
						leger.setElderSelfCareAssess(phy.getBaseSelfcareEstimate());
						//性别中文
						leger.setSexValue(CodeToValue.sexConvert(info.getSex()));
						//出生日期
						leger.setBirthday(DateUtil.getDate(info.getBirthday(), "yyyy-MM-dd"));
						//健康评价异常
						leger.setHealthAbnormDesc(phy.getHealthEvaluation());
						
						leger.setYear(2019l);
						
						elderExamLedgerDao.insertSelective(leger);
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}				
			}
		}
	}

	@Override
	public void orgSync() {
		// TODO Auto-generated method stub
		List<Pos> list = posDao.findAll();
		if(list != null && list.size() > 0){
			for(int i = 0; i < list.size(); i++){
				Pos pos = list.get(i);
				Organization org = organizationDao.selectByPrimaryKey(pos.getPosId());
				if(org != null){
					continue;
				}else{
					Organization o = new Organization();
					o.setId(pos.getPosId());
					o.setPubOrgcode(pos.getPosCode());
					o.setOrganName(pos.getPosName());
					o.setOrganParentCode(pos.getPosPid());
					o.setOrganCode(pos.getPosId());
					o.setOrganShortName(pos.getPosName());
					o.setIsDelete(0);
					o.setProvinceCode("45");
					o.setProvinceName("广西");
					o.setCityCode("450400");
					o.setCityName("梧州市");
				}
			}
		}
	}

	@Override
	public void testElderExamLedger() {
		// TODO Auto-generated method stub
		List<PhysicalExamination> list = physicalExaminationDao.findWuzhouSyncList();
		if(list != null && list.size() > 0){
			
			for(int i = 0; i < list.size(); i++){
				try{
					ResidentBaseInfo info = new ResidentBaseInfo();
					PhysicalExamination phy = list.get(i);
					
					List<ResidentBaseInfo> residents = residentBaseInfoDao.findResidentByArchiveNo(phy.getArchiveNo());
					if(residents != null && residents.size() > 0){
						info = residents.get(0);
					}
					
					ElderExamLedger leger = new ElderExamLedger();
					//65岁老年人体检管理台账ID
					leger.setElderExamLedgerId(CodeUtil.getUUID());
					//体检ID
					leger.setHealthExamId(phy.getId());
					//录入机构ID
					leger.setCreateOrgId(phy.getCreateOrg());
					//录入机构名称
					leger.setOrgName(phy.getCreateOrgName());
					//录入时间
					leger.setCreateTime(phy.getCreateTime());
					//录入人ID
					leger.setCreatorId(phy.getCreateUser());
					//录入人姓名
					leger.setCreator(phy.getCreateName());
					//体检日期
					leger.setExamDate(phy.getCreateTime());
					//个人档案ID
					leger.setPersonInfoId(info.getId());
					//本人姓名
					leger.setName(phy.getName());
					//身份证证号
					leger.setIdNo(phy.getIdNumber());
					//ABO血型
					leger.setAboCode(info.getBloodGroup());
					//地址
					leger.setAddress(info.getResidenceAddress());
					//老年人认知功能筛查
					leger.setElderCognition(phy.getBaseCognitionEstimate());
					//老年人抑郁情况筛查
					leger.setElderDepression(phy.getBaseFeelingEstimate());
					//自理能力评估结果
					leger.setElderSelfCareAssess(phy.getBaseSelfcareEstimate());
					//性别中文
					leger.setSexValue(CodeToValue.sexConvert(info.getSex()));
					//出生日期
					leger.setBirthday(DateUtil.getDate(info.getBirthday(), "yyyy-MM-dd"));
					//健康评价异常
					leger.setHealthAbnormDesc(phy.getHealthEvaluation());
					
					leger.setYear(2019l);
					
					elderExamLedgerDao.insertSelective(leger);
				}catch(Exception e){
					e.printStackTrace();
				}				
			}
		}		
	}

}
