package com.wuzhou.pub.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuzhou.pub.dao.ElderSelfcareAbilityDao;
import com.wuzhou.pub.dao.ElderTcmHealthDao;
import com.wuzhou.pub.dao.HealthExamDao;
import com.wuzhou.pub.dao.HealthExamDrugDao;
import com.wuzhou.pub.dao.HealthExamInhosDao;
import com.wuzhou.pub.dao.HealthExamNoplanvaccDao;
import com.wuzhou.pub.entity.ElderSelfcareAbility;
import com.wuzhou.pub.entity.ElderTcmHealth;
import com.wuzhou.pub.entity.HealthExam;
import com.wuzhou.pub.entity.HealthExamDrug;
import com.wuzhou.pub.entity.HealthExamInhos;
import com.wuzhou.pub.entity.HealthExamNoplanvacc;
import com.wuzhou.pub.service.WuzhouSynService;
import com.wuzhou.pub.utils.ConvertObjectData;
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
	
	@Override
	public void sync() {
		List<PhysicalExamination> list = physicalExaminationDao.findWuzhouSyncList();
		if(list != null && list.size() > 0){
			
			for(int i = 0; i < list.size(); i++){
				ResidentBaseInfo info = new ResidentBaseInfo();
				PhysicalExamination phy = list.get(i);				
				List<ResidentBaseInfo> residents = residentBaseInfoDao.findResidentByArchiveNo(phy.getArchiveNo());
				if(residents != null && residents.size() > 0){
					info = residents.get(i);
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
				
			}
		}
	}

}
