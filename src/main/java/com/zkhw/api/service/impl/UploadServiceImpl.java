package com.zkhw.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.util.StringUtil;
import com.zkhw.api.bo.ChildenFollow;
import com.zkhw.api.bo.ChildenFollowBo;
import com.zkhw.api.bo.DiabetesBo;
import com.zkhw.api.bo.DiabetesFollow;
import com.zkhw.api.bo.Error;
import com.zkhw.api.bo.ErrorInfo;
import com.zkhw.api.bo.FollowResult;
import com.zkhw.api.bo.Gravida42After;
import com.zkhw.api.bo.Gravida42AfterBo;
import com.zkhw.api.bo.GravidaAfter;
import com.zkhw.api.bo.GravidaAfterBo;
import com.zkhw.api.bo.GravidaFirst;
import com.zkhw.api.bo.GravidaFirstBo;
import com.zkhw.api.bo.GravidaFollow;
import com.zkhw.api.bo.GravidaFollowBo;
import com.zkhw.api.bo.HealthManage;
import com.zkhw.api.bo.HealthManageBo;
import com.zkhw.api.bo.HypertensionBo;
import com.zkhw.api.bo.HypertensionFollow;
import com.zkhw.api.bo.HypertensionFollowUpLog;
import com.zkhw.api.bo.JingShenBingVisit;
import com.zkhw.api.bo.NeonatusBaseInfo;
import com.zkhw.api.bo.NeonatusBaseInfoBo;
import com.zkhw.api.bo.NeonatusFirst;
import com.zkhw.api.bo.NeonatusFirstBo;
import com.zkhw.api.bo.PsychosisBo;
import com.zkhw.api.bo.PsychosisFirst;
import com.zkhw.api.bo.PsychosisFollow;
import com.zkhw.api.bo.PsychosisInfoBo;
import com.zkhw.api.bo.Resident;
import com.zkhw.api.bo.ResidentUpBo;
import com.zkhw.api.bo.TakeMedicine;
import com.zkhw.api.bo.TangNiaoBingVisit;
import com.zkhw.api.bo.TuberculosisBo;
import com.zkhw.api.bo.TuberculosisFirst;
import com.zkhw.api.bo.TuberculosisFollow;
import com.zkhw.api.bo.TuberculosisFollowBo;
import com.zkhw.api.service.UploadService;
import com.zkhw.common.utils.CodeUtil;
import com.zkhw.flup.dao.ChildrenHealthRecordDao;
import com.zkhw.flup.dao.DiabetesFollowRecordDao;
import com.zkhw.flup.dao.FollowMedicineRecordDao;
import com.zkhw.flup.dao.GravidaAfterRecordDao;
import com.zkhw.flup.dao.GravidaFollowRecordDao;
import com.zkhw.flup.dao.GravidaInfoDao;
import com.zkhw.flup.dao.HypertensionDao;
import com.zkhw.flup.dao.NeonatusInfoDao;
import com.zkhw.flup.dao.PsychosisFollowRecordDao;
import com.zkhw.flup.dao.PsychosisInfoDao;
import com.zkhw.flup.dao.TuberculosisFollowRecordDao;
import com.zkhw.flup.dao.TuberculosisInfoDao;
import com.zkhw.flup.entity.ChildrenHealthRecord;
import com.zkhw.flup.entity.DiabetesFollowRecord;
import com.zkhw.flup.entity.FollowMedicineRecord;
import com.zkhw.flup.entity.GravidaAfterRecord;
import com.zkhw.flup.entity.GravidaFollowRecord;
import com.zkhw.flup.entity.GravidaInfo;
import com.zkhw.flup.entity.Hypertension;
import com.zkhw.flup.entity.NeonatusInfo;
import com.zkhw.flup.entity.PsychosisFollowRecord;
import com.zkhw.flup.entity.PsychosisInfo;
import com.zkhw.flup.entity.TuberculosisFollowRecord;
import com.zkhw.flup.entity.TuberculosisInfo;
import com.zkhw.framework.utils.DateUtil;
import com.zkhw.ltd.dao.OrganizationDao;
import com.zkhw.ltd.entity.Organization;
import com.zkhw.pub.dao.PhysicalExaminationDao;
import com.zkhw.pub.dao.ResidentBaseInfoDao;
import com.zkhw.pub.entity.PhysicalExamination;
import com.zkhw.pub.entity.ResidentBaseInfo;

@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	private ResidentBaseInfoDao residentBaseInfoDao;
	
	@Autowired
	private OrganizationDao organizationDao;

	@Autowired
	private FollowMedicineRecordDao followMedicineRecordDao;
	
	@Autowired
	private DiabetesFollowRecordDao diabetesFollowRecordDao;
	
	@Autowired
	private PsychosisFollowRecordDao psychosisFollowRecordDao;
	
	@Autowired
	private HypertensionDao hypertensionDao;
	
	@Autowired
	private PsychosisInfoDao psychosisInfoDao;
	
	@Autowired
	private TuberculosisInfoDao tuberculosisInfoDao;
	
	@Autowired
	private TuberculosisFollowRecordDao tuberculosisFollowRecordDao;
	
	@Autowired
	private GravidaFollowRecordDao gravidaFollowRecordDao;
	
	@Autowired
	private GravidaAfterRecordDao gravidaAfterRecordDao;
	
	@Autowired
	private GravidaInfoDao gravidaInfoDao;
	
	@Autowired
	private NeonatusInfoDao neonatusInfoDao;
	
	@Autowired
	private ChildrenHealthRecordDao childrenHealthRecordDao;
	
	@Autowired
	private PhysicalExaminationDao physicalExaminationDao;
	
	@Override
	public ErrorInfo diabetesUpload(DiabetesBo bo) {
		// TODO Auto-generated method stub
		ErrorInfo errInfo = new ErrorInfo();
		FollowResult result = new FollowResult();
		List<FollowResult> errList = new ArrayList<FollowResult>();
		for(int j = 0; j < bo.getTangNiaoBingVisit().size(); j++){
			Error err = new Error();
			try{
				TangNiaoBingVisit visit = bo.getTangNiaoBingVisit().get(j);
				DiabetesFollow follow = visit.getLogBody();
				DiabetesFollowRecord record = new DiabetesFollowRecord();
				err.setId(follow.getUUID());
				err.setInfo(follow.getId());
				record.setId(CodeUtil.getUUID());
				record.setArchiveNo(follow.getArchiveid());
				List<ResidentBaseInfo> residents = residentBaseInfoDao.findResidentByArchiveNo(follow.getArchiveid());
				String idNumber = "";
				if(residents != null && residents.size() > 0){
					record.setName(residents.get(0).getName());	
					record.setIdNumber(residents.get(0).getIdNumber());
					idNumber = residents.get(0).getIdNumber();
				}
				record.setVisitDate(follow.getVisitDate());
				record.setVisitType(follow.getVisitType());
				if(StringUtil.isNotEmpty(follow.getSymptom())){
					String s = follow.getSymptom().replaceAll("\\|", ",");
					record.setSymptom(s);
				}				
				record.setSymptomOther(follow.getSymptom_other());
				record.setBloodPressureHigh(follow.getSbp());
				record.setBloodPressureLow(follow.getDbp());
				record.setHeight(follow.getHeight());
				record.setWeightNow(follow.getWeight());
				record.setWeightNext(follow.getNWeight());	
				record.setBmiNow(follow.getBmi());
				record.setBmiNext(follow.getNBmi());
				record.setDorsalArtery(follow.getDorsal());
				if(StringUtil.isNotEmpty(follow.getAttenuate())){
					record.setPulsationPosition(follow.getAttenuate());
				}else if(StringUtil.isNotEmpty(follow.getDisapppear())){
					record.setPulsationPosition(follow.getDisapppear());
				}
				record.setOther(follow.getOtherSigns());
				record.setSmokeNow(follow.getSmokeAmount());
				record.setSmokeNext(follow.getNSmokeAmount());
				record.setDrinkNow(follow.getWineAmount());
				record.setDrinkNext(follow.getNWineAmount());
				record.setSportsNumNext(follow.getNSportperWeek());
				record.setSportsNumNow(follow.getSportperWeek());
				record.setSportsTimeNext(follow.getNSportOnce());
				record.setSportsTimeNow(follow.getSportOnce());
				record.setStapleFoodNext(follow.getNStapleAmount());
				record.setStapleFoodNow(follow.getStapleAmount());
				record.setPsychologicalRecovery(follow.getPsychology());		
				record.setMedicalCompliance(follow.getObeyDoctor());				
				record.setBloodGlucose(follow.getBsugar_mg());	
				record.setGlycosylatedHemoglobin(follow.getHemoglobin());				
				record.setCheckDate(follow.getCheckDate());			
				record.setCompliance(follow.getDrugComply());
				record.setUntowardEffect(follow.getHasAdverse());
				record.setReactiveHypoglycemia(follow.getAdverseOfSugar());
				record.setFollowType(follow.getVisitClass());
				record.setInsulinName(follow.getInsulinName());
				record.setInsulinUsage(follow.getInsulinUsage());	
				if(StringUtil.isNotEmpty(follow.getZzxx())){
					record.setTransferTreatment("1");
					record.setTransferTreatmentDepartment(follow.getZzxx());
					record.setTransferTreatmentReason(follow.getZzyy());					
				}
				
				record.setNextVisitDate(follow.getNextVisitDate());	
				record.setVisitDoctor(follow.getVisitDoc());	
				record.setAdvice(follow.getAdvice());
				record.setCreateName(follow.getCreated_By());
				record.setCreateOrg(follow.getDuns());
				Organization org = organizationDao.getOrganizationByCode(follow.getDuns());
				if(org != null){
					record.setCreateOrgName(org.getOrganName());
				}				
				record.setCreateTime(DateUtil.getDate(follow.getCreated_Date(), "yyyy-MM-dd HH:mm:ss"));
				//record.setCreateUser(createUser);										
				record.setUpdateName(follow.getUpdated_By());
				record.setUpdateTime(DateUtil.getDate(follow.getUpdated_Date(), "yyyy-MM-dd HH:mm:ss"));
				//record.setUpdateUser(updateUser);
				
				//record.setUploadResult(uploadResult);
				record.setUploadStatus(0);
				//record.setUploadTime(uploadTime);
				
				diabetesFollowRecordDao.insertSelective(record);
				err.setCode("0");
				result.setLogBody(err);
				List<TakeMedicine> list = visit.getTakeMedicineRecord();
				List<Error> takeMedicineRecord = new ArrayList<Error>();
				if(list != null && list.size() > 0){					
					for(int i = 0; i < list.size(); i++){
						TakeMedicine take = list.get(i);
						Error e = new Error();
						e.setId(take.getUUID());
						e.setInfo(take.getId());
						FollowMedicineRecord med = new FollowMedicineRecord();
						med.setId(CodeUtil.getUUID());
						med.setFollowId(record.getId());						
						med.setArchiveNo(take.getArchiveid());
						med.setIdNumber(idNumber);
						med.setServiceName(take.getServicename());
						med.setMedicineType(take.getDrugtype());
						med.setDrugName(take.getDrugname());
						med.setMedicineUsage(take.getUsage());		
						med.setNum(take.getFrequency());
					
						med.setDosage(take.getAmount());
						med.setUnit(take.getUnit());
						med.setMedicineTime(take.getUseyears());
						med.setMedicineTimeUnit(take.getUseyearsunit());
						med.setMedicineCompliance(take.getDrugcompliance());						
						med.setOther(take.getOther());
						
						med.setCreateName(follow.getCreated_By());
						med.setCreateTime(DateUtil.getDate(follow.getCreated_Date(), "yyyy-MM-dd HH:mm:ss"));
						//med.setCreateUser(createUser);
												
						med.setUpdateName(follow.getUpdated_By());
						med.setUpdateTime(DateUtil.getDate(follow.getUpdated_Date(), "yyyy-MM-dd HH:mm:ss"));
						//med.setUpdateUser(updateUser);
						followMedicineRecordDao.insertSelective(med);
						e.setCode("0");
						takeMedicineRecord.add(e);
					}						
				}
				result.setTakeMedicineRecord(takeMedicineRecord);
			}catch(Exception e){
				e.printStackTrace();
				err.setCode("-1");
				
			}
			errList.add(result);
		}
		errInfo.setTangNiaoBingVisit(errList);
		return errInfo;
	}

	@Override
	public ErrorInfo psychosisFollow(PsychosisBo bo) {
		// TODO Auto-generated method stub
		ErrorInfo errInfo = new ErrorInfo();
		FollowResult result = new FollowResult();
		List<FollowResult> errList = new ArrayList<FollowResult>();
		for(int j = 0; j < bo.getJingShenBingVisit().size(); j++){
			Error err = new Error();
			try{
				JingShenBingVisit visit = bo.getJingShenBingVisit().get(j);
				PsychosisFollow follow = visit.getLogBody();
				PsychosisFollowRecord record = new PsychosisFollowRecord();
				err.setId(follow.getUUID());
				err.setInfo(follow.getId());
				record.setId(CodeUtil.getUUID());								
				record.setArchiveNo(follow.getArchiveid());
				String idNumber= "";
				List<ResidentBaseInfo> residents = residentBaseInfoDao.findResidentByArchiveNo(follow.getArchiveid());
				if(residents != null && residents.size() > 0){
					record.setName(residents.get(0).getName());	
					record.setIdNumber(residents.get(0).getIdNumber());
					idNumber = residents.get(0).getIdNumber();
				}
				record.setVisitDate(follow.getVisitDate());
				record.setVisitType(follow.getVISITTYPED());
				record.setMissReason(follow.getReafailure());
				record.setMissReasonOther(follow.getScmptomother());
				record.setDieDate(follow.getDeathDate());
				record.setDieReason(follow.getDeathcause());
				record.setDieReasonOther(follow.getDealmptomother());
				record.setPhysicalDisease(follow.getBodyhealth());
				record.setFatalness(follow.getDangerLevel());
				if(StringUtil.isNotEmpty(follow.getSymptom())){
					record.setSymptom(follow.getSymptom().replaceAll("\\|", ","));
				}
				record.setSymptomOther(follow.getOtherSymptom());
				record.setInsight(follow.getInsight());
				record.setSleepStatus(follow.getSleeping());
				record.setDietaryStatus(follow.getDiet());
				record.setSelfHelp(follow.getLiving());
				record.setHousework(follow.getHousework());
				record.setWork(follow.getLabor());
				record.setLearningAbility(follow.getStudy());
				record.setInterpersonal(follow.getCommunion());
				if(follow.getNobehavior() != 1){
					record.setDangerousAct("7");
				}
				record.setSlightTroubleNum(follow.getTrouble());
				record.setCauseTroubleNum(follow.getAccident());
				record.setCauseAccidentNum(follow.getProblem());
				record.setHarmOtherNum(follow.getBehavior());
				record.setAutolesionNum(follow.getSelfInjury());				
				record.setAttemptedSuicideNum(follow.getAttemptedSuicide());
				record.setIsolation(follow.getLockstatus());
				record.setHospitalizedStatus(follow.getInpMemo());
				record.setOutHospitalDate(follow.getLatestOutDate());
				record.setLaboratoryExamination(follow.getExamination());				
				record.setCompliance(follow.getDrugComply());
				record.setUntowardEffect(follow.getHasAdverse());
				record.setUntowardEffectInfo(follow.getAdverseMemo());
				record.setTreatmentEffect(follow.getTreatment());				
				record.setTransferTreatment(follow.getIfzz());
				record.setTransferTreatmentDepartment(follow.getZzxx());
				record.setTransferTreatmentReason(follow.getZzyy());
				if(StringUtil.isNotEmpty(follow.getRecoverPlan())){
					record.setRehabilitationMeasure(follow.getRecoverPlan().replaceAll("\\|", ","));
				}				
				record.setRehabilitationMeasureOther(follow.getRecoverPlan_other());
				record.setNextVisitClassify(follow.getVisitType());
				record.setNextVisitDate(follow.getNextVisitDate());	
				record.setVisitDoctor(follow.getVisitDoctor());
				
				record.setCreateName(follow.getCreated_By());			
				record.setCreateOrg(follow.getDuns());
				Organization org = organizationDao.getOrganizationByCode(follow.getDuns());
				if(org != null){
					record.setCreateOrgName(org.getOrganName());
				}
				record.setCreateTime(DateUtil.getDate(follow.getCreated_Date(), "yyyy-MM-dd HH:mm:ss"));
				//record.setCreateUser(createUser);
																			
				record.setUpdateName(follow.getUpdated_By());
				record.setUpdateTime(DateUtil.getDate(follow.getUpdated_Date(), "yyyy-MM-dd HH:mm:ss"));
				//record.setUpdateUser(updateUser);
				
				//record.setUploadResult(uploadResult);
				record.setUploadStatus(0);
				//record.setUploadTime(uploadTime);
				
				psychosisFollowRecordDao.insertSelective(record);
				err.setCode("0");
				result.setLogBody(err);
				List<TakeMedicine> list = visit.getTakeMedicineRecord();
				List<Error> takeMedicineRecord = new ArrayList<Error>();
				if(list != null && list.size() > 0){					
					for(int i = 0; i < list.size(); i++){
						TakeMedicine take = list.get(i);
						Error e = new Error();
						e.setId(take.getUUID());
						e.setInfo(take.getId());
						FollowMedicineRecord med = new FollowMedicineRecord();
						med.setId(CodeUtil.getUUID());
						med.setFollowId(record.getId());						
						med.setArchiveNo(take.getArchiveid());
						med.setIdNumber(idNumber);
						med.setServiceName(take.getServicename());
						med.setMedicineType(take.getDrugtype());
						med.setDrugName(take.getDrugname());
						med.setMedicineUsage(take.getUsage());
						med.setNum(take.getFrequency());						
						med.setDosage(take.getAmount());
						med.setUnit(take.getUnit());
						med.setMedicineTime(take.getUseyears());
						med.setMedicineTimeUnit(take.getUseyearsunit());
						med.setMedicineCompliance(take.getDrugcompliance());						
						med.setOther(take.getOther());
						
						med.setCreateName(follow.getCreated_By());
						med.setCreateTime(DateUtil.getDate(follow.getCreated_Date(), "yyyy-MM-dd HH:mm:ss"));
						//med.setCreateUser(createUser);
												
						med.setUpdateName(follow.getUpdated_By());
						med.setUpdateTime(DateUtil.getDate(follow.getUpdated_Date(), "yyyy-MM-dd HH:mm:ss"));
						//med.setUpdateUser(updateUser);
						followMedicineRecordDao.insertSelective(med);
						e.setCode("0");
						takeMedicineRecord.add(e);
					}					
				}
				result.setTakeMedicineRecord(takeMedicineRecord);
			}catch(Exception e){
				e.printStackTrace();
				err.setCode("-1");
				
			}
			errList.add(result);
		}
		errInfo.setJingShenBingVisit(errList);
		return errInfo;
	}

	@Override
	public ErrorInfo hypertensionUpload(HypertensionBo bo) {
		// TODO Auto-generated method stub
		ErrorInfo errInfo = new ErrorInfo();
		FollowResult result = new FollowResult();
		List<FollowResult> errList = new ArrayList<FollowResult>();
		for(int j = 0; j < bo.getHypertensionFollowUpLog().size(); j++){
			Error err = new Error();
			try{
				HypertensionFollowUpLog visit = bo.getHypertensionFollowUpLog().get(j);
				HypertensionFollow follow = visit.getLogBody();
				Hypertension record = new Hypertension();
				err.setId(follow.getUUID());
				err.setInfo(follow.getId());
				record.setId(CodeUtil.getUUID());
				record.setArchiveNo(follow.getArchiveid());
				
				String idNumber = "";
				List<ResidentBaseInfo> residents = residentBaseInfoDao.findResidentByArchiveNo(follow.getArchiveid());
				if(residents != null && residents.size() > 0){
					record.setName(residents.get(0).getName());	
					record.setIdNumber(residents.get(0).getIdNumber());
					idNumber = residents.get(0).getIdNumber();
				}
				record.setVisitDate(follow.getVisitDate());
				record.setVisitType(follow.getVisitType());
				if(StringUtil.isNotEmpty(follow.getSymptom())){
					String s = follow.getSymptom().replaceAll("\\|", ",");
					record.setSymptom(s);
				}
				record.setOtherSymptom(follow.getSymptomother());
				record.setDbp(follow.getDbp());
				record.setSbp(follow.getSbp());
				record.setHeight(follow.getHeight());	
				record.setWeight(follow.getWeight());
				record.setTargetWeight(follow.getNWeight());
				record.setBmi(follow.getBmi());
				record.setTargetBmi(follow.getNBmi());
				record.setHeartRate(follow.getHeartRate());
				record.setOtherSign(follow.getOtherSigns());				
				record.setSmoken(follow.getSmokeAmount());
				record.setTargetSomken(follow.getNSmokeAmount());
				record.setWine(follow.getWineAmount());
				record.setTargetWine(follow.getNWineAmount());
				record.setSaltIntake(follow.getSaltIntake());		
				record.setTargetSaltIntake(follow.getNSaltIntake());
				record.setSportWeek(follow.getSportperWeek());
				record.setTargetSportWeek(follow.getNSportperWeek());
				record.setSportOnce(follow.getSportOnce());
				record.setTargetSportOnce(follow.getNSportOnce());
				record.setMindAdjust(follow.getPsychology());
				record.setDoctorObey(follow.getObeyDoc());
				record.setAssistExamine(follow.getAssistantCheck());
				record.setDrugObey(follow.getDrugCompliance());	
				record.setUntowardEffect(follow.getAdverseeffect());
				record.setUntowardEffectDrug(follow.getAdverseMemo());
				record.setVisitClass(follow.getVisitClass());
				record.setNextVisitDate(follow.getNextVisitDate());
				record.setVisitDoctor(follow.getVisitDoc());	
				
				record.setAdvice(follow.getAdvice());												
				//record.setReferralCode(follow.get);								
				record.setTransferOrgan(follow.getZzxx());
				record.setTransferReason(follow.getZzyy());
				
				record.setCreateName(follow.getCreated_By());			
				record.setCreateOrg(follow.getDuns());
				Organization org = organizationDao.getOrganizationByCode(follow.getDuns());
				if(org != null){
					record.setCreateOrgName(org.getOrganName());
				}
				record.setCreateTime(DateUtil.getDate(follow.getCreated_Date(), "yyyy-MM-dd HH:mm:ss"));
				//record.setCreateUser(createUser);
																			
				record.setUpdateName(follow.getUpdated_By());
				record.setUpdateTime(DateUtil.getDate(follow.getUpdated_Date(), "yyyy-MM-dd HH:mm:ss"));
				//record.setUpdateUser(updateUser);
				
				//record.setUploadResult(uploadResult);
				record.setUploadStatus(0);
				//record.setUploadTime(uploadTime);	
				
				hypertensionDao.insertSelective(record);
				err.setCode("0");
				result.setLogBody(err);
				List<TakeMedicine> list = visit.getTakeMedicineRecord();
				List<Error> takeMedicineRecord = new ArrayList<Error>();
				if(list != null && list.size() > 0){					
					for(int i = 0; i < list.size(); i++){
						TakeMedicine take = list.get(i);
						Error e = new Error();
						e.setId(take.getUUID());
						e.setInfo(take.getId());
						FollowMedicineRecord med = new FollowMedicineRecord();
						med.setId(CodeUtil.getUUID());
						med.setFollowId(record.getId());						
						med.setArchiveNo(record.getArchiveNo());
						med.setIdNumber(idNumber);
						med.setServiceName(take.getServicename());
						med.setMedicineType(take.getDrugtype());
						med.setDrugName(take.getDrugname());
						med.setMedicineUsage(take.getUsage());
						med.setNum(take.getFrequency());						
						med.setDosage(take.getAmount());
						med.setUnit(take.getUnit());
						med.setMedicineTime(take.getUseyears());
						med.setMedicineTimeUnit(take.getUseyearsunit());
						med.setMedicineCompliance(take.getDrugcompliance());						
						med.setOther(take.getOther());
						
						med.setCreateName(follow.getCreated_By());
						med.setCreateTime(DateUtil.getDate(follow.getCreated_Date(), "yyyy-MM-dd HH:mm:ss"));
						//med.setCreateUser(createUser);
												
						med.setUpdateName(follow.getUpdated_By());
						med.setUpdateTime(DateUtil.getDate(follow.getUpdated_Date(), "yyyy-MM-dd HH:mm:ss"));
						//med.setUpdateUser(updateUser);
						followMedicineRecordDao.insertSelective(med);
						e.setCode("0");
						takeMedicineRecord.add(e);
					}						
				}
				result.setTakeMedicineRecord(takeMedicineRecord);
				
			}catch(Exception e){
				e.printStackTrace();
				err.setCode("-1");
				
			}
			errList.add(result);
		}
		errInfo.setHypertensionFollowUpLog(errList);
		return errInfo;
	}

	@Override
	public ErrorInfo psychosisFirst(PsychosisInfoBo bo) {
		// TODO Auto-generated method stub
		ErrorInfo errInfo = new ErrorInfo();
		List<Error> errList = new ArrayList<Error>();
		for(int j = 0; j < bo.getJingShenBingInfo().size(); j++){
			Error err = new Error();
			try{
				PsychosisFirst first = bo.getJingShenBingInfo().get(j);				
				PsychosisInfo psy = new PsychosisInfo();
				err.setId(first.getUUID());
				err.setInfo(first.getId());
				psy.setId(CodeUtil.getUUID());
				psy.setArchiveNo(first.getArchiveid());
				List<ResidentBaseInfo> residents = residentBaseInfoDao.findResidentByArchiveNo(first.getArchiveid());
				//String idNumber = "";
				if(residents != null && residents.size() > 0){
					psy.setName(residents.get(0).getName());					
					psy.setIdNumber(residents.get(0).getIdNumber());
				}

				//监护人姓名
				psy.setGuardianName(first.getGuardian());
				//监护人与患者关系
				psy.setGuardianRelation(first.getRelation());
				//监护人地址
				psy.setGuardianAddress(first.getGuardianAddr());
				//监护人电话
				psy.setGuardianPhone(first.getGuardianTel());
				//居委会联系人
				psy.setNeighborhoodCommitteeLinkman(first.getLinkman());
				//居委会联系电话
				psy.setNeighborhoodCommitteeLinktel(first.getLinkmanTel());
				//户别
				psy.setResidentType(first.getHb());
				//就业情况
				psy.setEmploymentStatus(first.getJYQK());
				//是否同意管理
				psy.setAgreeManage(first.getIsAgree());
				//同意签字人
				psy.setAgreeName(first.getSignature());
				//同意日期
				psy.setAgreeDate(first.getSignatureDate());
				//初次发病日期
				psy.setFirstMorbidityDate(first.getOutbreakDate());	
				//既往主要症状
				if(StringUtil.isNotEmpty(first.getSymptom())){
					String s = first.getSymptom().replaceAll("\\|", ",");
					psy.setSymptom(s);
				}
				//症状其他
				psy.setSymptomOther(first.getOtherSymptom());
				//既往关锁情况
				psy.setIsolation(first.getLockqk());
				//门诊
				psy.setOutpatient(first.getOutp());
				//首次抗精神药治疗时间
				psy.setFirstMedicineDate(first.getFirstTreatDate());
				//住院次数
				psy.setHospitalizedNum(first.getInpCount());
				//诊断
				psy.setDiagnosis(first.getCurDiagnose());
				//确诊医院
				psy.setDiagnosisHospital(first.getDiagnoseHospital());
				//确诊日期
				psy.setDiagnosisDate(first.getDiagnoseDate());
				//最近一次治疗效果
				psy.setRecentlyTreatmentEffect(first.getLatestTreatRes());
				
				//psy.setDangerousAct(dangerousAct);
				//轻度滋事次数
				psy.setSlightTroubleNum(first.getTrouble());
				//肇事次数
				psy.setCauseTroubleNum(first.getAccident());
				//肇祸次数
				psy.setCauseAccidentNum(first.getProblem());
				//其他危害行为次数
				psy.setHarmOtherNum(first.getBehavior());
				//自伤次数
				psy.setAutolesionNum(first.getSelfInjury());
				//自杀未遂次数
				psy.setAttemptedSuicideNum(first.getAttemptedSuicide());
				
				//经济状况
				psy.setEconomics(first.getEconomic());
				//专科医生意见
				psy.setSpecialistSuggestion(first.getDoctAdvice());
				//填表日期
				psy.setRecordDate(first.getInputDate());
				//医生签字
				psy.setRecordDoctor(first.getDoctor());
				
				psy.setRemark(first.getRemark());
				
				psy.setCreateName(first.getCreated_By());
				psy.setCreateOrg(first.getDuns());
				Organization org = organizationDao.getOrganizationByCode(first.getDuns());
				if(org != null){
					psy.setCreateOrgName(org.getOrganName());
				}
				psy.setCreateTime(DateUtil.getDate(first.getCreated_Date(), "yyyy-MM-dd HH:mm:ss"));
				//psy.setCreateUser(first.getCreated_By());			
								
				psy.setUpdateName(first.getUpdated_By());
				psy.setUpdateTime(DateUtil.getDate(first.getUpdated_Date(), "yyyy-MM-dd HH:mm:ss"));
				//psy.setUpdateUser(first.getUpdated_By());
				//psy.setUploadResult(uploadResult);
				psy.setUploadStatus(0);
				//psy.setUploadTime(uploadTime);
				
				psychosisInfoDao.insertSelective(psy);
				err.setCode("0");
			}catch(Exception e){
				e.printStackTrace();
				err.setCode("-1");
				
			}
			errList.add(err);
		}
		errInfo.setJingShenBingInfo(errList);
		return errInfo;
	}

	@Override
	public ErrorInfo tuberculosisFirst(TuberculosisBo bo) {
		// TODO Auto-generated method stub
		ErrorInfo errInfo = new ErrorInfo();
		List<Error> errList = new ArrayList<Error>();
		for(int j = 0; j < bo.getFeiJieHeVisit1().size(); j++){
			Error err = new Error();
			try{
				TuberculosisFirst first = bo.getFeiJieHeVisit1().get(j);	
				boolean add = true;
				TuberculosisInfo tub = null;
				tub = tuberculosisInfoDao.getTuberculosisByArchiveNo(first.getArchiveid());
				if(tub != null){
					add = false;
				}else{
					tub = new TuberculosisInfo();
					tub.setId(CodeUtil.getUUID());
				}
				err.setId(first.getUUID());
				err.setInfo(first.getId());
				tub.setArchiveNo(first.getArchiveid());
				List<ResidentBaseInfo> residents = residentBaseInfoDao.findResidentByArchiveNo(first.getArchiveid());
				if(residents != null && residents.size() > 0){
					tub.setName(residents.get(0).getName());	
					tub.setIdNumber(residents.get(0).getIdNumber());
				}
				tub.setVisitDate(first.getVisitDate());
				tub.setVisitType(first.getVisitstyle());
				//患者类型
				tub.setPatientType(first.getPatientType());
				//痰菌类型
				tub.setSputumBacteriumType(first.getTjqk());
				//耐药类型
				tub.setDrugFastType(first.getNyqk());
				//症状及体征
				if(StringUtil.isNotEmpty(first.getSysmpsigns())){
					String s = first.getSysmpsigns().replaceAll("\\|", ",");
					tub.setSymptom(s);
				}
				//症状其他
				tub.setSymptomOther(first.getQtsysmpsigns());
				//化疗方案
				tub.setChemotherapyPlan(first.getHlscheme());
				//用法
				tub.setDrugsUsage(first.getUsage());
				//药品剂型
				tub.setDrugsType(first.getYpjx());
				//督导人员选择
				tub.setSupervisorType(first.getSupervisor());
				//督导其他
				tub.setSupervisorOther("");
				//单独居室
				tub.setSingleRoom(first.getSinglehome());
				//通风情况
				tub.setVentilation(first.getVentilate());
				//现在每天吸烟量
				if(StringUtil.isNotEmpty(first.getSmoke())){
					tub.setSmokeNow(Integer.valueOf(first.getSmoke()));
				}				
				//下次随访每天吸烟目标
				if(StringUtil.isNotEmpty(first.getSmoke_target())){
					tub.setSmokeNext(Integer.valueOf(first.getSmoke_target()));
				}				
				//现在每天饮酒量
				if(StringUtil.isNotEmpty(first.getDrink())){
					tub.setDrinkNow(Integer.valueOf(first.getDrink()));
				}				
				//下次随访每天饮酒目标量
				if(StringUtil.isNotEmpty(first.getDrink_target())){
					tub.setDrinkNext(Integer.valueOf(first.getDrink_target()));
				}				
				//取药地址
				tub.setGetMedicineAddress(first.getGetMedicineAddr());
				//取药日期
				tub.setGetMedicineDate(first.getGetMedicineDate());
				//服药记录卡的填写
				tub.setMedicineRecord(first.getFwjlk());
				//服药方法及药品存放
				tub.setMedicineLeave(first.getYwffjypcf());
				//肺结核治疗疗程
				tub.setTreatmentCourse(first.getFjhzllc());
				//不规律服药危害
				tub.setErratically(first.getBglfwwh());
				//服药后的不良反应及处理
				tub.setUntowardEffect(first.getFyhblfyjcl());
				//治疗期间复诊查痰
				tub.setFurtherConsultation(first.getZlqjfzct());
				//外出期间如何坚持服药
				tub.setInsist(first.getWcqjrhjcfy());
				//生活习惯及注意事项
				tub.setHabitsCustoms(first.getShxgjzysx());
				//密切接触者检查
				tub.setIntimateContact(first.getMqjczjc());
				//下次随访日期
				tub.setNextVisitDate(first.getNextvisitDate());
				//评估医生
				tub.setEstimateDoctor(first.getEvaluationDoctor());
				
				tub.setCreateName(first.getCreated_By());
				tub.setCreateOrg(first.getDuns());
				Organization org = organizationDao.getOrganizationByCode(first.getDuns());
				if(org != null){
					tub.setCreateOrgName(org.getOrganName());
				}
				tub.setCreateTime(DateUtil.getDate(first.getCreated_Date(), "yyyy-MM-dd HH:mm:ss"));
				//tub.setCreateUser(first.getCreated_By());
							
				tub.setUpdateName(first.getUpdated_By());
				tub.setUpdateTime(DateUtil.getDate(first.getUpdated_Date(), "yyyy-MM-dd HH:mm:ss"));
				//tub.setUpdateUser(first.getUpdated_By());
				//tub.setUploadResult(uploadResult);
				tub.setUploadStatus(0);
				//tub.setUploadTime(uploadTime);	
				if(add){
					tuberculosisInfoDao.insertSelective(tub);
				}else{
					tuberculosisInfoDao.updateByPrimaryKeySelective(tub);
				}
				err.setCode("0");
			}catch(Exception e){
				e.printStackTrace();
				err.setCode("-1");
				
			}
			errList.add(err);
		}
		errInfo.setFeiJieHeVisit1(errList);
		return errInfo;
	}

	@Override
	public ErrorInfo tuberculosisFollow(TuberculosisFollowBo bo) {
		// TODO Auto-generated method stub
		ErrorInfo errInfo = new ErrorInfo();
		List<Error> errList = new ArrayList<Error>();
		for(int j = 0; j < bo.getFeiJieHeVisit().size(); j++){
			Error err = new Error();
			try{
				TuberculosisFollow follow = bo.getFeiJieHeVisit().get(j);			
				TuberculosisFollowRecord record = new TuberculosisFollowRecord();
				err.setId(follow.getUUID());
				err.setInfo(follow.getId());
				record.setId(CodeUtil.getUUID());
				record.setArchiveNo(follow.getArchiveid());
				List<ResidentBaseInfo> residents = residentBaseInfoDao.findResidentByArchiveNo(follow.getArchiveid());
				if(residents != null && residents.size() > 0){
					record.setName(residents.get(0).getName());	
					record.setIdNumber(residents.get(0).getIdNumber());
				}
				record.setVisitDate(follow.getVisitDate());
				//治疗月序
				record.setMonthOrder(follow.getZlyx());
				//督导人员选择
				record.setSupervisorType(follow.getSupervisor());
				record.setVisitType(follow.getVisitstyle());
				//症状及体征
				if(StringUtil.isNotEmpty(follow.getSysmpsigns())){
					String s = follow.getSysmpsigns().replaceAll("\\|", ",");
					record.setSymptom(s);
				}
				record.setSymptomOther(follow.getQtsysmpsigns());
				//现在每天吸烟量
				if(StringUtil.isNotEmpty(follow.getSmoke())){
					record.setSmokeNow(Integer.valueOf(follow.getSmoke()));
				}				
				//下次随访每天吸烟目标
				if(StringUtil.isNotEmpty(follow.getSmoke_target())){
					record.setSmokeNext(Integer.valueOf(follow.getSmoke_target()));
				}				
				//现在每天饮酒量
				if(StringUtil.isNotEmpty(follow.getDrink())){
					record.setDrinkNow(Integer.valueOf(follow.getDrink()));
				}				
				//下次随访每天饮酒目标量
				if(StringUtil.isNotEmpty(follow.getDrink_target())){
					record.setDrinkNext(Integer.valueOf(follow.getDrink_target()));
				}
	
				//化疗方案
				record.setChemotherapyPlan(follow.getHlscheme());
				//用法
				record.setDrugsUsage(follow.getUsage());
				//药品剂型
				record.setDrugsType(follow.getYpjx());
				//漏服药次数
				record.setMiss(follow.getLfycs());
				//药物不良反应
				record.setUntowardEffect(follow.getYwblfy());
				//不良反应症状
				record.setUntowardEffectInfo(follow.getJtywblfy());
				//并发症或合并症
				record.setComplication(follow.getBfzhhbz());
				//并发症信息
				record.setComplicationInfo(follow.getJtbfzhhbz());
				//转诊机构和科别
				record.setTransferTreatmentDepartment(follow.getKb());
				//转诊原因
				record.setTransferTreatmentReason(follow.getReason());
				//转诊两周后随访结果
				record.setTwoweekVisitResult(follow.getSfjg());
				//处理意见
				record.setHandlingSuggestion(follow.getClyj());
				record.setNextVisitDate(follow.getNextvisitDate());
				//随访医生
				record.setVisitDoctor(follow.getVisitDoctor());
				//停止治疗日期
				record.setStopDate(follow.getCxtzzlsj());
				//停止治疗原因
				record.setStopReason(follow.getStopReason());
				//应该随访次数
				record.setMustVisitNum(follow.getMustVisitNum());
				//实际随访次数
				record.setActualVisitNum(follow.getActualVisitNum());
				//应服药次数
				record.setMustMedicineNum(follow.getMustMedicineNum());
				//实际服药次数
				record.setActualMedicineNum(follow.getActualMedicineNum());
				//服药率
				record.setMedicineRate(follow.getMedicineRate());
				//评估医生
				record.setEstimateDoctor(follow.getEvaluationDoctor());
				
				record.setCreateName(follow.getCreated_By());
				record.setCreateOrg(follow.getDuns());
				Organization org = organizationDao.getOrganizationByCode(follow.getDuns());
				if(org != null){
					record.setCreateOrgName(org.getOrganName());
				}
				record.setCreateTime(DateUtil.getDate(follow.getCreated_Date(), "yyyy-MM-dd HH:mm:ss"));
				//record.setCreateUser(follow.getCreated_By());

				record.setUpdateName(follow.getUpdated_By());
				record.setUpdateTime(DateUtil.getDate(follow.getUpdated_Date(), "yyyy-MM-dd HH:mm:ss"));
				//record.setUpdateUser(follow.getUpdated_By());
				//record.setUploadResult(uploadResult);
				record.setUploadStatus(0);
				//record.setUploadTime(uploadTime);		
				
				tuberculosisFollowRecordDao.insertSelective(record);
				
				err.setCode("0");
			}catch(Exception e){
				e.printStackTrace();
				err.setCode("-1");
				
			}
			errList.add(err);
		}
		errInfo.setFeiJieHeVisit(errList);
		return errInfo;
	}

	@Override
	public ErrorInfo gravidaFollow(GravidaFollowBo bo) {
		// TODO Auto-generated method stub
		ErrorInfo errInfo = new ErrorInfo();
		List<Error> errList = new ArrayList<Error>();
		for(int j = 0; j < bo.getChanQian2_5().size(); j++){
			Error err = new Error();
			try{
				GravidaFollow follow = bo.getChanQian2_5().get(j);
				GravidaFollowRecord record = new GravidaFollowRecord();
				err.setId(follow.getUUID());
				err.setInfo(follow.getId());
				record.setId(CodeUtil.getUUID());
				record.setArchiveNo(follow.getArchiveid());
				List<ResidentBaseInfo> residents = residentBaseInfoDao.findResidentByArchiveNo(follow.getArchiveid());
				if(residents != null && residents.size() > 0){
					record.setName(residents.get(0).getName());	
					record.setIdNumber(residents.get(0).getIdNumber());
				}
				
				record.setGravidaId(follow.getExaminfirid());
				record.setOrderNum(follow.getOrderNum());
				record.setVisitDate(follow.getVisitdate());
				//孕周
				record.setGestationalWeeks(follow.getWeek());
				//孕妇自述症状
				record.setSymptom(follow.getMainsuit());
				//体重
				record.setWeight(follow.getWeight());
				//宫高
				record.setFundusHeight(follow.getUterusheight());	
				//腹围
				record.setAbdomenCircumference(follow.getAbdominalGirth());
				//胎位
				record.setFetusPosition(follow.getFetusPosition());
				//胎心率
				record.setFetalHeartRate(follow.getFetalHeartRate());
				//收缩压（mmHg）
				record.setBloodPressureHigh(follow.getBloodpressure());
				//舒张压（mmHg）
				record.setBloodPressureLow(follow.getDiaspressure());
				//血红蛋白
				record.setHemoglobin(follow.getHB());
				//尿蛋白
				record.setUrineProtein(follow.getLEU());
				//其他辅助检查
				record.setCheckOther(follow.getOtherExamin());
				//分类
				record.setConditions(follow.getTypes());
				//异常信息
				record.setErrorInfo(follow.getTypesbug());
				//指导
				if(StringUtil.isNotEmpty(follow.getGuide())){
					record.setGuidance(follow.getGuide().replaceAll("\\|", ","));
				}
				record.setGuidanceOther(follow.getGuideother());
				//有无转诊
				//record.setTransferTreatment(transferTreatment);
				//转诊原因
				record.setTransferTreatmentReason(follow.getTransReason());
				//转诊机构和科室
				record.setTransferTreatmentDepartment(follow.getTransHos());
				//下次随访日期
				record.setNextVisitDate(follow.getNextvisitdate());	
				//访问医生签名
				record.setVisitDoctor(follow.getVisitdoc());
				
				record.setCreateName(follow.getCreated_By());
				record.setCreateOrg(follow.getDuns());
				Organization org = organizationDao.getOrganizationByCode(follow.getDuns());
				if(org != null){
					record.setCreateOrgName(org.getOrganName());
				}				
				record.setCreateTime(DateUtil.getDate(follow.getCreated_Date(), "yyyy-MM-dd HH:mm:ss"));
				//record.setCreateUser(follow.getCreated_By());
														
				record.setUpdateName(follow.getUpdated_By());
				record.setUpdateTime(DateUtil.getDate(follow.getUpdated_Date(), "yyyy-MM-dd HH:mm:ss"));
				//record.setUpdateUser(follow.getUpdated_By());
				//record.setUploadResult(uploadResult);
				record.setUploadStatus(0);
				//record.setUploadTime(uploadTime);
				
				gravidaFollowRecordDao.insertSelective(record);
				err.setCode("0");
			}catch(Exception e){
				e.printStackTrace();
				err.setCode("-1");
				
			}
			errList.add(err);
		}
		errInfo.setChanQian2_5(errList);
		return errInfo;
	}

	@Override
	public ErrorInfo gravidaAfter(GravidaAfterBo bo) {
		// TODO Auto-generated method stub
		ErrorInfo errInfo = new ErrorInfo();
		List<Error> errList = new ArrayList<Error>();
		for(int j = 0; j < bo.getChanHouVisit().size(); j++){
			Error err = new Error();
			try{
				GravidaAfter follow = bo.getChanHouVisit().get(j);
				GravidaAfterRecord record = new GravidaAfterRecord();
				err.setId(follow.getUUID());
				err.setInfo(follow.getId());
				record.setId(CodeUtil.getUUID());
				record.setArchiveNo(follow.getArchiveid());
				List<ResidentBaseInfo> residents = residentBaseInfoDao.findResidentByArchiveNo(follow.getArchiveid());
				if(residents != null && residents.size() > 0){
					record.setName(residents.get(0).getName());	
					record.setIdNumber(residents.get(0).getIdNumber());
				}
				
				record.setGravidaId(follow.getExaminfirid());
				record.setRecordType("1");
				record.setVisitDate(follow.getVisitdate());
				//分娩日期
				record.setChildbirth(follow.getLABOURDATE());
				//出院日期
				record.setDischargeDate(follow.getOUTHORTH());
				//体温
				record.setTemperature(follow.getTemperature());
				//一般健康状况
				record.setGeneralHealthStatus(follow.getBody());
				//一般心理状况
				record.setGeneralPsychologyStatus(follow.getPsychology());
				//收缩压（mmHg）
				record.setBloodPressureHigh(follow.getBloodpressure());
				//舒张压（mmHg）
				record.setBloodPressureLow(follow.getDiaspressure());
				//乳房是否异常
				record.setBreast(follow.getBreast());
				//乳房异常信息
				record.setBreastError(follow.getBreastbug());
				//恶露
				record.setLyma(follow.getLochia());
				//恶露异常信息
				record.setLymaError(follow.getLochiabug());
				//子宫
				record.setWomb(follow.getUterus());
				record.setWombError(follow.getUterusbug());
				//伤口
				record.setWound(follow.getVulnus());
				record.setWoundError(follow.getVulnusbug());
				//其他
				record.setOther(follow.getOthers());
				//分类
				record.setConditions(follow.getTypes());
				//异常信息
				record.setConditionError(follow.getTypesbug());
				//指导	
				if(StringUtil.isNotEmpty(follow.getGuide())){
					record.setGuidance(follow.getGuide().replaceAll("\\|", ","));
				}
				record.setGuidanceOther(follow.getGuideother());
				//有无转诊
				//record.setTransferTreatment(transferTreatment);
				//转诊原因
				record.setTransferTreatmentReason(follow.getTransReason());
				//转诊机构和科室
				record.setTransferTreatmentDepartment(follow.getTransHos());
				//下次随访日期
				record.setNextVisitDate(follow.getNextvisitdate());	
				//访问医生签名
				record.setVisitDoctor(follow.getVisitdoc());
				
				record.setCreateName(follow.getCreated_By());
				record.setCreateOrg(follow.getDuns());
				Organization org = organizationDao.getOrganizationByCode(follow.getDuns());
				if(org != null){
					record.setCreateOrgName(org.getOrganName());
				}				
				record.setCreateTime(DateUtil.getDate(follow.getCreated_Date(), "yyyy-MM-dd HH:mm:ss"));
				//record.setCreateUser(follow.getCreated_By());
														
				record.setUpdateName(follow.getUpdated_By());
				record.setUpdateTime(DateUtil.getDate(follow.getUpdated_Date(), "yyyy-MM-dd HH:mm:ss"));
				//record.setUpdateUser(follow.getUpdated_By());
				//record.setUploadResult(uploadResult);
				record.setUploadStatus(0);
				//record.setUploadTime(uploadTime);
				
				gravidaAfterRecordDao.insertSelective(record);
				err.setCode("0");
			}catch(Exception e){
				e.printStackTrace();
				err.setCode("-1");
				
			}
			errList.add(err);
		}
		errInfo.setChanHouVisit(errList);
		return errInfo;
	}

	@Override
	public ErrorInfo gravida42After(Gravida42AfterBo bo) {
		// TODO Auto-generated method stub
		ErrorInfo errInfo = new ErrorInfo();
		List<Error> errList = new ArrayList<Error>();
		for(int j = 0; j < bo.getChanHou42day().size(); j++){
			Error err = new Error();
			try{
				Gravida42After follow = bo.getChanHou42day().get(j);
				GravidaAfterRecord record = new GravidaAfterRecord();
				err.setId(follow.getUUID());
				err.setInfo(follow.getId());
				record.setId(CodeUtil.getUUID());
				record.setArchiveNo(follow.getArchiveid());
				List<ResidentBaseInfo> residents = residentBaseInfoDao.findResidentByArchiveNo(follow.getArchiveid());
				if(residents != null && residents.size() > 0){
					record.setName(residents.get(0).getName());	
					record.setIdNumber(residents.get(0).getIdNumber());
				}
				
				record.setGravidaId(follow.getExaminfirid());
				record.setRecordType("2");
				record.setVisitDate(follow.getVisitdate());
				//分娩日期
				record.setChildbirth(follow.getLABOURDATE());
				//出院日期
				record.setDischargeDate(follow.getOuthorth());
				//体温
				//record.setTemperature(follow.getTemperature());
				//一般健康状况
				record.setGeneralHealthStatus(follow.getBody());
				//一般心理状况
				record.setGeneralPsychologyStatus(follow.getPsychology());
				//收缩压（mmHg）
				record.setBloodPressureHigh(follow.getBloodpressure());
				//舒张压（mmHg）
				record.setBloodPressureLow(follow.getDiaspressure());
				//乳房是否异常
				record.setBreast(follow.getBreast());
				//乳房异常信息
				record.setBreastError(follow.getBreastbug());
				//恶露
				record.setLyma(follow.getLochia());
				//恶露异常信息
				record.setLymaError(follow.getLochiabug());
				//子宫
				record.setWomb(follow.getUterus());
				record.setWombError(follow.getUterusbug());
				//伤口
				record.setWound(follow.getVulnus());
				record.setWoundError(follow.getVulnusbug());
				//其他
				record.setOther(follow.getOthers());
				//分类
				record.setConditions(follow.getTypes());
				//异常信息
				record.setConditionError(follow.getTypesbug());
				//指导
				if(StringUtil.isNotEmpty(follow.getGuide())){
					record.setGuidance(follow.getGuide().replaceAll("\\|", ","));
				}			
				record.setGuidanceOther(follow.getGuideother());
				//有无转诊
				record.setTransferTreatment(follow.getIfzz());
				//转诊原因
				record.setTransferTreatmentReason(follow.getTransReason());
				//转诊机构和科室
				record.setTransferTreatmentDepartment(follow.getTransHos());
				//下次随访日期
				record.setNextVisitDate(follow.getNextvisitdate());	
				//访问医生签名
				record.setVisitDoctor(follow.getVisitdoc());
				
				record.setCreateName(follow.getCreated_By());
				record.setCreateOrg(follow.getDuns());
				Organization org = organizationDao.getOrganizationByCode(follow.getDuns());
				if(org != null){
					record.setCreateOrgName(org.getOrganName());
				}				
				record.setCreateTime(DateUtil.getDate(follow.getCreated_Date(), "yyyy-MM-dd HH:mm:ss"));
				//record.setCreateUser(follow.getCreated_By());
														
				record.setUpdateName(follow.getUpdated_By());
				record.setUpdateTime(DateUtil.getDate(follow.getUpdated_Date(), "yyyy-MM-dd HH:mm:ss"));
				//record.setUpdateUser(follow.getUpdated_By());
				//record.setUploadResult(uploadResult);
				record.setUploadStatus(0);
				//record.setUploadTime(uploadTime);
				
				gravidaAfterRecordDao.insertSelective(record);
				err.setCode("0");
			}catch(Exception e){
				e.printStackTrace();
				err.setCode("-1");
				
			}
			errList.add(err);
		}
		errInfo.setChanHou42day(errList);
		return errInfo;
	}

	@Override
	public ErrorInfo gravidaFirst(GravidaFirstBo bo) {
		// TODO Auto-generated method stub
		ErrorInfo errInfo = new ErrorInfo();
		List<Error> errList = new ArrayList<Error>();
		for(int j = 0; j < bo.getChanQian1().size(); j++){
			Error err = new Error();
			try{
				GravidaFirst follow = bo.getChanQian1().get(j);
				GravidaInfo record = new GravidaInfo();
				String id = CodeUtil.getUUID();
				err.setId(follow.getUUID());
				err.setInfo(id);
				record.setId(id);
				record.setArchiveNo(follow.getArchiveid());
				
				List<ResidentBaseInfo> residents = residentBaseInfoDao.findResidentByArchiveNo(follow.getArchiveid());
				if(residents != null && residents.size() > 0){
					record.setName(residents.get(0).getName());	
					record.setIdNumber(residents.get(0).getIdNumber());
				}
				record.setVisitDate(follow.getVisitdate());
				//孕周
				record.setGestationalWeeks(follow.getWeek());
				//孕妇年龄
				record.setGravidaAge(follow.getAge());
				//丈夫姓名
				record.setHusbandName(follow.getHasname());
				//丈夫年龄
				record.setHusbandAge(follow.getHasage());
				//丈夫电话
				record.setHusbandPhone(follow.getHasphone());
				//孕次
				record.setPregnantNum(follow.getPregtimes());
				//阴道分娩次数
				record.setNaturalLabourNum(follow.getBirthtimes1());
				//剖腹产次数
				record.setCesareanNum(follow.getBirthtimes2());
				//末次月经日期
				record.setLastMenstruationDate(follow.getLmpdate());
				//预产期
				record.setDueDate(follow.getWillbirthdate());
				//既往史
				record.setPastIllness(follow.getPasshistory());
				record.setPastIllnessOther(follow.getPasshistoryother());
				//家族史
				record.setFamilyHistory(follow.getFamilyhistory());
				record.setFamilyHistoryOther(follow.getFamilyhistoryother());
				//个人史
				record.setHabitsCustoms(follow.getSefthistory());
				record.setHabitsCustomsOther(follow.getSefthistoryother());
				//妇产科手术史
				record.setIsoperation(follow.getGynecolooperation());
				record.setOperationName(follow.getLadyoperahis());
				//自然流产次数
				record.setNaturalAbortionNum(follow.getBortion());
				//人工流产次数
				record.setAbactioNum(follow.getAbortion());
				//死胎次数
				record.setFetaldeathNum(follow.getStillborn());
				//死产次数
				record.setStillbirthNum(follow.getStillborth());
				//新生儿死亡次数
				record.setNeonatalDeathNum(follow.getBabydiea());
				//出生缺陷儿次数
				record.setBirthDefectNum(follow.getBabydefect());
				//身高
				record.setHeight(follow.getHeight());
				//体重
				record.setWeight(follow.getWeight());
				//体质指数bmi
				record.setBmi(follow.getBmi());
				//收缩压（mmHg）
				record.setBloodPressureHigh(follow.getBloodpressure());
				//舒张压（mmHg）
				record.setBloodPressureLow(follow.getDiaspressure());
				//心脏
				record.setHeart(follow.getHeart());
				record.setHeartOther(follow.getHeartbug());
				//肺部
				record.setLungs(follow.getBlellows());
				record.setLungsOther(follow.getBlellowsbug());
				//外阴
				record.setVulva(follow.getVulva());
				record.setVulvaOther(follow.getVulvabug());
				//阴道
				record.setVagina(follow.getVagina());
				record.setVaginaOther(follow.getVaginabug());
				//宫颈
				record.setCervix(follow.getNeckofuterus());
				record.setCervixOther(follow.getNeckofuterusbug());
				//子宫
				record.setCorpus(follow.getUterus());
				record.setCorpusOther(follow.getUterusbug());
				//附件
				record.setAccessories(follow.getAppendix());
				record.setAccessoriesOther(follow.getAppendixbug());
				//血红蛋白
				record.setHemoglobin(follow.getHB());
				//白细胞计数
				record.setLeukocyte(follow.getWBC());
				//血小板计数
				record.setPlatelet(follow.getPLT());
				//血液检查其他
				record.setBloodOther(follow.getBloodothers());
				//尿蛋白
				record.setUrineProtein(follow.getLEU());
				//尿糖
				record.setGlycosuria(follow.getGLUU());
				//尿酮体
				record.setUrineAcetoneBodies(follow.getNIT());
				//尿潜血
				record.setBld(follow.getBLU());
				//尿常规其他
				record.setUrineOther(follow.getUrineothers());
				//血糖
				record.setBloodSugar(follow.getBloodsugar());
				//血型
				record.setBloodGroup(follow.getBloodtype());
				//RH
				record.setBloodRh(follow.getBloodrh());
				//血清谷丙转氨酶
				record.setSgft(follow.getGPT());
				//血清谷草转氨酶
				record.setAst(follow.getAST());
				//白蛋白
				record.setAlbumin(follow.getALB());
				//总胆红素
				record.setTotalBilirubin(follow.getTBILI());
				//结合胆红素
				record.setConjugatedBilirubin(follow.getIBILI());
				//血清肌酐
				record.setScr(follow.getSerumCreatin());
				//血尿素
				record.setBloodUrea(follow.getBloodUrea());
				//阴道分泌物
				record.setVaginalFluid(follow.getVaginalFluid());
				//阴道分泌物其他
				record.setVaginalFluidOther(follow.getVaginalFluidother());
				//阴道清洁度
				record.setVaginalCleaning(follow.getVaginaClean());
				//乙型肝炎表面抗原
				record.setHb(follow.getHBSAG());
				//乙型肝炎表面抗体
				record.setHbsab(follow.getHBSAB());
				//乙型肝炎e抗原
				record.setHbeag(follow.getHBEAG());
				//乙型肝炎e抗体
				record.setHbeab(follow.getHBEAB());
				//乙型肝炎核心抗体
				record.setHbcab(follow.getHBCAB());
				//梅毒血清学实验
				record.setSyphilis(follow.getSyphilis());
				//HIV抗体检测
				record.setHiv(follow.getHIV());
				//B超
				record.setBUltrasonic(follow.getB());
				//record.setOther(other);
				//总体评估
				record.setGeneralAssessment(follow.getEvaluate());
				//评估异常
				record.setAssessmentError(follow.getEvaluatebug());
				//保健指导
				if(StringUtil.isNotEmpty(follow.getGuide())){
					record.setHealthGuidance(follow.getGuide().replaceAll("\\|", ","));
				}
				//保健指导其他
				record.setHealthGuidanceOther(follow.getGuideother());
				
				record.setTransferTreatment(follow.getReferralId());
				
				record.setTransferTreatmentReason(follow.getTransReason());
				
				record.setTransferTreatmentDepartment(follow.getTransHos());
				//下次随访日期
				record.setNextVisitDate(follow.getNextVisitDate());	
				//访问医生签名
				record.setVisitDoctor(follow.getVisitDoc());
				
				record.setStatus(follow.getCloseStatus());

				record.setCreateName(follow.getCreated_By());
				record.setCreateOrg(follow.getDuns());
				Organization org = organizationDao.getOrganizationByCode(follow.getDuns());
				if(org != null){
					record.setCreateOrgName(org.getOrganName());
				}				
				record.setCreateTime(DateUtil.getDate(follow.getCreated_Date(), "yyyy-MM-dd HH:mm:ss"));
				//record.setCreateUser(follow.getCreated_By());
														
				record.setUpdateName(follow.getUpdated_By());
				record.setUpdateTime(DateUtil.getDate(follow.getUpdated_Date(), "yyyy-MM-dd HH:mm:ss"));
				//record.setUpdateUser(follow.getUpdated_By());
				//record.setUploadResult(uploadResult);
				record.setUploadStatus(0);
				//record.setUploadTime(uploadTime);
				gravidaInfoDao.insertSelective(record);
				err.setCode("0");
			}catch(Exception e){
				e.printStackTrace();
				err.setCode("-1");
				
			}
			errList.add(err);
		}
		errInfo.setChanQian1(errList);
		return errInfo;
	}

	@Override
	public ErrorInfo residentUp(ResidentUpBo bo) {
		// TODO Auto-generated method stub
		ErrorInfo errInfo = new ErrorInfo();
		List<Error> errList = new ArrayList<Error>();
		for(int j = 0; j < bo.getArchive().size(); j++){
			Error err = new Error();
			try{
				Resident redisent = bo.getArchive().get(j);
				ResidentBaseInfo info = null;
				boolean add = true;
				List<ResidentBaseInfo> l = residentBaseInfoDao.findResidentByArchiveNo(redisent.getArchiveid());
				if(l != null && l.size() > 0){
					info = l.get(0);
					add = false;
				}				
				if(info == null){
					info = new ResidentBaseInfo();
					info.setId(CodeUtil.getUUID());
				}
				err.setId(redisent.getUUID());
				err.setInfo(redisent.getId());				
				
				
				//档案id
				info.setArchiveNo(redisent.getArchiveid());
				//姓名
				info.setName(redisent.getFullname());
				//性别
				info.setSex(redisent.getGender());
				//出生日期
				info.setBirthday(redisent.getBirthday());
				info.setAge(DateUtil.getAge(redisent.getBirthday()));
				//身份证号
				info.setIdNumber(redisent.getIdentityno());
				//户籍地址（门牌号）
				info.setRegisterAddress(redisent.getResaddr_doorno());
				//详细住址
				info.setResidenceAddress(redisent.getCuraddr_doorno());
				//工作单位
				info.setCompany(redisent.getCompany());
				//本人电话
				info.setPhone(redisent.getTel());
				//联系人姓名
				info.setLinkName(redisent.getLinkman());
				//联系人电话
				info.setLinkPhone(redisent.getLinkman_tel());
				//常住类型
				info.setResidentType(redisent.getResidenttype());
				//民族
				info.setNation(redisent.getNation());
				//血型
				info.setBloodGroup(redisent.getBloodgroup());
				//RH
				info.setBloodRh(redisent.getBloodrh());
				//文化程度
				info.setEducation(redisent.getEducation());
				//职业
				info.setProfession(redisent.getVocation());
				//婚姻状况
				info.setMaritalStatus(redisent.getMarriage());
				//医疗费用支付方式
				info.setPayType(redisent.getPaytype());
				//其它支付方式
				info.setPayOther(redisent.getPaytype_other());
				//过敏史
				info.setDrugAllergy(redisent.getHypersuses());
				//其它过敏史
				info.setAllergyOther(redisent.getHypersuses_other());
				//暴露史
				info.setExposure(redisent.getUndress());
				//是否患高血压
				if(StringUtil.isNotEmpty(redisent.getDishyperflag())){
					if("1".equals(redisent.getDishyperflag())){
						info.setIsHypertension(1);
					}else{
						info.setIsHypertension(0);
					}					
				}
				
				//是否患糖尿病
				if(StringUtil.isNotEmpty(redisent.getDisdmflag())){
					if("1".equals(redisent.getDisdmflag())){
						info.setIsDiabetes(1);
					}else{
						info.setIsDiabetes(0);
					}					
				}

				//是否患重性精神疾病
				if(StringUtil.isNotEmpty(redisent.getDismentalflag())){
					if("1".equals(redisent.getDismentalflag())){
						info.setIsPsychosis(1);
					}else{
						info.setIsPsychosis(0);
					}					
				}
				
				//是否患结核病
				if(StringUtil.isNotEmpty(redisent.getDistbflag())){
					if("1".equals((redisent.getDistbflag()))){
						info.setIsTuberculosis(1);
					}else{
						info.setIsTuberculosis(0);
					}					
				}
				//有无遗传病史
				if(StringUtil.isNotEmpty(redisent.getHas_inherit_dis())){
					info.setIsHeredity(Integer.valueOf(redisent.getHas_inherit_dis()));
				}				
				//遗传病名称
				info.setHeredityName(redisent.getInherit_dis());
				//其他疾病名称
				info.setDiseaseOther(redisent.getDisOtherName());
				//残疾情况
				info.setIsDeformity(redisent.getDeformity());
				//其它残疾名称
				info.setDeformityName(redisent.getDeformity_other());				
				info.setStatus("1");
				//责任医生
				info.setDoctorId(redisent.getDutydoctor());				
				info.setDoctorName(redisent.getCreated_By());
				//是否贫困
				if(StringUtil.isNotEmpty(redisent.getIsPoor())){
					info.setIsPoor(Integer.valueOf(redisent.getIsPoor()));
				}
				
				if(StringUtil.isNotEmpty(redisent.getIsQianYue())){
					if("1".equals((redisent.getIsQianYue()))){
						info.setIsSigning(1);
					}else{
						info.setIsSigning(0);
					}					
				}
				
				//厨房排风设施
				info.setKitchen(redisent.getShhj_cfpfss());
				//燃料类型
				info.setFuel(redisent.getShhj_rllx());
				//饮水
				info.setDrink(redisent.getShhj_ys());
				//厕所
				info.setToilet(redisent.getShhj_cs());
				//禽畜栏
				info.setPoultry(redisent.getShhj_qcl());
				//社保/农合卡号
				info.setMedicalCode(redisent.getMedicareid());
				
				info.setRemark(redisent.getRemark());
				
				info.setCreateUser(redisent.getBuilddoctor());
				info.setCreateName(redisent.getCreated_By());
				info.setCreateTime(DateUtil.getDate(redisent.getBuild_date(), "yyyy-MM-dd HH:mm:ss"));
				info.setCreateOrg(redisent.getDuns());
				Organization org = organizationDao.getOrganizationByCode(redisent.getDuns());
				if(org != null){
					info.setCreateOrgName(org.getOrganName());
					info.setProvinceCode(org.getProvinceCode());
					info.setProvinceName(org.getProvinceName());
					info.setCityCode(org.getCityCode());
					info.setCityName(org.getCityName());
					info.setCountyCode(org.getCountyCode());
					info.setCountyName(org.getCountyName());
					info.setTownsCode(org.getTownsCode());
					info.setTownsName(org.getTownsName());
					info.setVillageCode(org.getVillageCode());
					info.setVillageName(org.getVillageName());
					if(StringUtil.isEmpty(info.getVillageCode())){
						if(StringUtil.isNotEmpty(redisent.getCuraddr_committee())){
							if(redisent.getCuraddr_committee().length() == 12){
								info.setVillageCode(redisent.getCuraddr_committee());
							}
						}
					}
				}
				info.setIsSynchro(0);
				info.setUpdateName(redisent.getUpdated_By());
				info.setUpdateTime(DateUtil.getDate(redisent.getUpdated_Date(), "yyyy-MM-dd HH:mm:ss"));
				//med.setUpdateUser(updateUser);
				if(add){
					residentBaseInfoDao.insertSelective(info);
				}else{
					residentBaseInfoDao.updateByPrimaryKeySelective(info);
				}
				
				err.setCode("0");
			}catch(Exception e){
				e.printStackTrace();
				err.setCode("-1");
				
			}
			errList.add(err);
		}
		List<Error> OperationHistory = new ArrayList<Error>();
		errInfo.setOperationHistory(OperationHistory);
		errInfo.setArchive(errList);
		return errInfo;
	}

	@Override
	public ErrorInfo neonatusBaseInfo(NeonatusBaseInfoBo bo) {
		// TODO Auto-generated method stub
		ErrorInfo errInfo = new ErrorInfo();
		List<Error> errList = new ArrayList<Error>();
		for(int j = 0; j < bo.getChildrenBasicInfo().size(); j++){
			Error err = new Error();
			try{
				NeonatusBaseInfo follow = bo.getChildrenBasicInfo().get(j);
				NeonatusInfo record = neonatusInfoDao.getNeonatusByArchiveNo(follow.getArchiveid());
				err.setId(follow.getUUID());
				err.setInfo(follow.getId());
				boolean isNew = false;
				if(record == null){
					isNew = true;
					record = new NeonatusInfo();
					record.setId(CodeUtil.getUUID());
					record.setArchiveNo(follow.getArchiveid());
				}
				
				record.setName(follow.getFullname());
				record.setIdNumber(follow.getIdentityno());
				record.setSex(follow.getGender());
				record.setBirthday(follow.getBirthday());
				//家庭住址
				record.setHomeAddress(follow.getAddress());
				//父亲姓名
				record.setFatherName(follow.getFathername());
				//父亲职业
				record.setFatherProfession(follow.getFatherProfession());
				//父亲电话
				record.setFatherPhone(follow.getFatherPhone());
				//父亲出生日期
				record.setFatherBirthday(follow.getFatherBirthday());
				//母亲名字
				record.setMotherName(follow.getMothername());
				//母亲职业
				record.setMotherProfession(follow.getMatherProfession());
				//母亲电话
				record.setMotherPhone(follow.getMatherPhone());
				//母亲出生日期
				record.setMotherBirthday(follow.getMatherBirthday());
				//孕周
				record.setGestationalWeeks(follow.getPregnancyweek());
				//妊娠期间患病情况
				record.setSickenStasus(follow.getMatherPregnacy());
				//患病其他
				record.setSickenOther(follow.getMatherPregnacy_other());
				//助产机构名称
				record.setMidwifeOrg(follow.getHospitalname());
				//出生情况
				record.setBirthSituation(follow.getBirthdayStatus());
				//出生情况其他
				record.setBirthOther(follow.getBirthStatus_other());
				//新生儿窒息
				record.setAsphyxiaNeonatorum(follow.getAsphyxiaOfNewborn());
				//窒息时间
				record.setAsphyxiaTime(follow.getApgar());
				//畸形
				record.setDeformity(follow.getDeformity());
				//畸形其他
				record.setDeformityOther(follow.getDeformityinfo());
				//出生体重
				record.setBirthWeight(follow.getWeight());
				//出生身长（cm）
				record.setBirthHeight(follow.getHeight());
				if(isNew){
					//record.setCreateName(createName);
					record.setCreateOrg(follow.getDuns());
					Organization org = organizationDao.getOrganizationByCode(follow.getDuns());
					if(org != null){
						record.setCreateOrgName(org.getOrganName());
						record.setProvinceCode(org.getProvinceCode());
						record.setProvinceName(org.getProvinceName());
						record.setCityCode(org.getCityCode());
						record.setCityName(org.getCityName());
						record.setCountyCode(org.getCountyCode());
						record.setCountyName(org.getCountyName());
						record.setTownsCode(org.getTownsCode());
						record.setTownsName(org.getTownsName());
						record.setVillageCode(org.getVillageCode());
						record.setVillageName(org.getVillageName());
					}				
					record.setCreateTime(DateUtil.getDate(follow.getCreated_Date(), "yyyy-MM-dd HH:mm:ss"));
					record.setCreateUser(follow.getCreated_By());
															
					//record.setUpdateName(updateName);
					record.setUpdateTime(DateUtil.getDate(follow.getUpdated_Date(), "yyyy-MM-dd HH:mm:ss"));
					record.setUpdateUser(follow.getUpdated_By());
					//record.setUploadResult(uploadResult);
					record.setUploadStatus(0);
					//record.setUploadTime(uploadTime);
					
					neonatusInfoDao.insertSelective(record);
				}else{
					record.setUpdateTime(DateUtil.getDate(follow.getUpdated_Date(), "yyyy-MM-dd HH:mm:ss"));
					record.setUpdateUser(follow.getUpdated_By());
					
					neonatusInfoDao.updateByPrimaryKeySelective(record);
				}
								
				err.setCode("0");
			}catch(Exception e){
				e.printStackTrace();
				err.setCode("-1");
				
			}
			errList.add(err);
		}
		errInfo.setChildrenBasicInfo(errList);
		return errInfo;
	}

	@Override
	public ErrorInfo neonatusFirst(NeonatusFirstBo bo) {
		// TODO Auto-generated method stub
		ErrorInfo errInfo = new ErrorInfo();
		List<Error> errList = new ArrayList<Error>();
		for(int j = 0; j < bo.getChildrenFamilyVisit().size(); j++){
			Error err = new Error();
			try{
				NeonatusFirst follow = bo.getChildrenFamilyVisit().get(j);
				NeonatusInfo record = neonatusInfoDao.getNeonatusByArchiveNo(follow.getArchiveid());
				err.setId(follow.getUUID());
				err.setInfo(follow.getId());
				boolean isNew = false;
				if(record == null){
					isNew = true;
					record = new NeonatusInfo();
					record.setId(CodeUtil.getUUID());
					record.setArchiveNo(follow.getArchiveid());
				}
				
				//家庭住址
				if(StringUtil.isNotEmpty(follow.getAddress())){
					record.setHomeAddress(follow.getAddress());
				}
				
				//新生儿听力
				record.setHearing(follow.getHearingOfNewborn());
				//新生儿疾病
				record.setDisease(follow.getDiseaseOfNewborn());
				//其他疾病
				record.setDiseaseOther(follow.getDiseaseOfNewborn1());
				
				//出生体重
				if(StringUtil.isNotEmpty(follow.getWightOfNewborn())){
					record.setBirthWeight(follow.getWightOfNewborn());
				}
				//目前体重
				record.setWeight(follow.getWight());
				
				//出生身长（cm）
				if(StringUtil.isNotEmpty(follow.getHearingOfNewborn())){
					record.setBirthHeight(follow.getHearingOfNewborn());
				}
				//喂养方式
				record.setFeedingPatterns(follow.getFeedWay());
				//吃奶次数
				record.setMilkNum(follow.getSuckTimes());
				//吃奶量
				record.setMilkIntake(follow.getSuckMeasure());
				//呕吐
				record.setVomit(follow.getVomit());
				//大便
				record.setShit(follow.getDefecate());
				//大便次数
				record.setDefecationNum(follow.getDefecateTimes());
				//体温
				record.setTemperature(follow.getTemperature());
				//心率
				record.setHeartRate(follow.getPulseRate());				
				//呼吸频率
				record.setBreathingRate(follow.getBreatheRate());
				//面色
				record.setComplexion(follow.getFace());
				//面色其他
				record.setComplexionOther(follow.getFace1());
				//黄疸部位
				record.setAurigo(follow.getJaundice());
				
				//前囱状态
				record.setAnteriorFontanelle(follow.getBregma());
				//前囱高
				record.setAnteriorFontanelleHigh(follow.getBregma1());
				//前囱其他
				record.setAnteriorFontanelleOther(follow.getBregma2());
				//眼睛是否异常
				record.setEye(follow.getEyeAppearance());
				//四肢活动度
				record.setExtremityMobility(follow.getLimbsMobility());
				//耳外观
				record.setEar(follow.getHearAppearance());
				//颈部包块
				record.setNeckMass(follow.getCervicalMasses());
				//鼻子
				record.setNose(follow.getNose());
				//皮肤
				record.setSkin(follow.getSkin());
				//皮肤其他
				record.setSkinOther(follow.getSkin1());
				//口腔
				record.setOralCavity(follow.getMouth());
				//肛门
				record.setAnus(follow.getAnus());
				//心肺听诊
				record.setHeartLung(follow.getHeatr_lung());
				//胸部
				record.setBreast(follow.getBreastexam());
				//腹部触诊
				record.setAbdominalTouch(follow.getAbdominalBallotte());
				//脊柱
				record.setSpine(follow.getSpine());
				//外生殖器
				record.setAedea(follow.getPudendum());
				//脐带
				record.setUmbilicalCord(follow.getFunicle());
				//脐带其他
				record.setUmbilicalCordOther(follow.getFunicle1());
				//有无转诊
				record.setTransferTreatment(follow.getTransferConSug());
				//转诊原因
				record.setTransferTreatmentReason(follow.getReason());
				//转诊机构和科别
				record.setTransferTreatmentDepartment(follow.getHospital());
				//指导
				record.setGuidance(follow.getGuide());
				//指导其他
				record.setGuidanceOther(follow.getGuide_other());
				//访问日期
				record.setVisitDate(follow.getCurrentVisitDate());
				//下次访问日期
				record.setNextVisitDate(follow.getNextVisitDate());
				//下次访问地址
				record.setNextVisitAddress(follow.getNextVisitAddress());
				//随访医生签名
				record.setVisitDoctor(follow.getVisitDoctorName());
				if(isNew){
					//record.setCreateName(createName);
					record.setCreateOrg(follow.getDuns());
					Organization org = organizationDao.getOrganizationByCode(follow.getDuns());
					if(org != null){
						record.setCreateOrgName(org.getOrganName());
						record.setProvinceCode(org.getProvinceCode());
						record.setProvinceName(org.getProvinceName());
						record.setCityCode(org.getCityCode());
						record.setCityName(org.getCityName());
						record.setCountyCode(org.getCountyCode());
						record.setCountyName(org.getCountyName());
						record.setTownsCode(org.getTownsCode());
						record.setTownsName(org.getTownsName());
						record.setVillageCode(org.getVillageCode());
						record.setVillageName(org.getVillageName());
					}				
					record.setCreateTime(DateUtil.getDate(follow.getCreated_Date(), "yyyy-MM-dd HH:mm:ss"));
					record.setCreateUser(follow.getCreated_By());
															
					//record.setUpdateName(updateName);
					record.setUpdateTime(DateUtil.getDate(follow.getUpdated_Date(), "yyyy-MM-dd HH:mm:ss"));
					record.setUpdateUser(follow.getUpdated_By());
					//record.setUploadResult(uploadResult);
					record.setUploadStatus(0);
					//record.setUploadTime(uploadTime);
					
					neonatusInfoDao.insertSelective(record);
				}else{
					record.setUpdateTime(DateUtil.getDate(follow.getUpdated_Date(), "yyyy-MM-dd HH:mm:ss"));
					record.setUpdateUser(follow.getUpdated_By());
					
					neonatusInfoDao.updateByPrimaryKeySelective(record);
				}
								
				err.setCode("0");
			}catch(Exception e){
				e.printStackTrace();
				err.setCode("-1");
				
			}
			errList.add(err);
		}
		errInfo.setChildrenFamilyVisit(errList);
		return errInfo;
	}

	@Override
	public ErrorInfo childrenFollow(ChildenFollowBo bo) {
		// TODO Auto-generated method stub
		ErrorInfo errInfo = new ErrorInfo();
		List<Error> errList = new ArrayList<Error>();
		for(int j = 0; j < bo.getChildrenHealthCheck().size(); j++){
			Error err = new Error();
			try{
				ChildenFollow follow = bo.getChildrenHealthCheck().get(j);
				ChildrenHealthRecord record = new ChildrenHealthRecord();
				record.setId(CodeUtil.getUUID());
				record.setArchiveNo(follow.getArchiveid());
				err.setId(follow.getUUID());
				err.setInfo(follow.getId());
				NeonatusInfo info = neonatusInfoDao.getNeonatusByArchiveNo(follow.getArchiveid());
				if(info != null){
					record.setName(info.getName());
					record.setIdNumber(info.getIdNumber());
				}

				//月龄
				record.setAge(follow.getMoonAge());
				//随访日期
				record.setVisitDate(follow.getFollowupDate());
				//体重
				record.setWeight(follow.getWeight());
				//体重评价
				record.setWeightEvaluate(follow.getWeight1());
				//身高
				record.setHeight(follow.getHeight());
				//身高评价
				record.setHeightEvaluate(follow.getHeight1());
				//身高体重评估
				record.setWeightHeight(follow.getHeightorweightsys());
				//体格发育评价
				record.setPhysicalAssessment(follow.getPhysique());
				//头围
				record.setHeadCircumference(follow.getHeadGirth());
				//面色
				record.setComplexion(follow.getFaceColour());
				//面色其他
				//record.setComplexionOther(complexionOther);
				//皮肤
				record.setSkin(follow.getSkin());
				record.setSkinOther(follow.getSkinbug());
				//前囱状态
				record.setAnteriorFontanelle(follow.getBregma());
				//前囱高
				record.setAnteriorFontanelleHigh(follow.getBregma1());
				//颈部包块
				record.setNeckMass(follow.getNeckMasses());
				//眼睛是否异常
				record.setEye(follow.getEyeLayout());
				record.setEyeOther(follow.getEyeLayoutbug());
				//视力
				record.setVision(follow.getVision());
				//耳外观
				record.setEar(follow.getEarLayout());
				record.setEarOther(follow.getEarLayoutbug());
				//听力
				record.setHearing(follow.getHearing());
				//口腔
				record.setOralCavity(follow.getCavum());
				record.setCavityOther(follow.getCavumbug());
				//出牙数
				//record.setTeethingNum(follow.getTooth());
				//龋齿数
				//record.setCariesNum(cariesNum);
				//胸部
				record.setBreast(follow.getHeart_lung());
				record.setBreastOther(follow.getHeatr_lungbug());
				//腹部
				record.setAbdominal(follow.getAbdCavity());
				record.setAbdominalOther(follow.getAbdCavitybug());
				//脐部
				if(follow.getMoonAge() == 1){
					record.setUmbilicalCord(follow.getUmRegion());
					record.setUmbilicalOther(follow.getUmRegionother());
				}else{
					record.setUmbilicalCord(follow.getUmRegions());
					record.setUmbilicalOther(follow.getUmRegions_other());
				}
				
				//四肢
				record.setExtremity(follow.getExtremity());
				record.setExtremityOther(record.getExtremityOther());
				//步态
				record.setGait(follow.getTread());
				//可疑佝偻病症状
				record.setRicketsSymptom(follow.getShRicketsSymptom());
				//可疑佝偻病体征
				record.setRicketsSign(follow.getShRicketsSigns());
				//肛门
				record.setAnus(follow.getPortaHVestibule());
				record.setAnusOther(follow.getPortaHVestibulebug());
				//血红蛋白值
				record.setHemoglobin(follow.getHemoglobinValue());
				//其他
				record.setOther(follow.getPhysiqu_other());
				//户外活动时间
				record.setOutdoorTime(follow.getOpenActivity());
				
				//record.setVitamindName(vitamindName);
				//维生素D数量
				record.setVitamindNum(follow.getEdebleVietaminD());
				
				record.setGrowthResult(follow.getGrowthEvaluate());
				
				switch (follow.getMoonAge()) {
				case 3:
					record.setGrowth(follow.getThrmothdevelop());
					break;
				case 6:
					record.setGrowth(follow.getSixmothdevelop());
					break;
				case 8:
					record.setGrowth(follow.getEigdevelop());
					break;		
				case 12:
					record.setGrowth(follow.getTwelvedevelop());
					break;	
				case 18:
					record.setGrowth(follow.getEightdevelop());
					break;
				case 24:
					record.setGrowth(follow.getTwdevelop());
					break;	
				case 30:
					record.setGrowth(follow.getThrtydevelop());
					break;	
				case 36:
					record.setGrowth(follow.getThrdevelop());
					break;
				case 48:
					record.setGrowth(follow.getFourdevelop());
					break;	
				case 60:
					record.setGrowth(follow.getFivedevelop());
					break;	
				case 72:
					record.setGrowth(follow.getSixdevelop());
					break;					
				default:
					break;
				}
				
				//患病情况
				record.setSickenStasus(follow.getTwiFollowSickenStu());
				//肺炎次数
				record.setPneumoniaNum(follow.getPulmonary());
				//腹泻次数
				record.setDiarrheaNum(follow.getDiarrhea());
				//外伤次数
				record.setTraumaNum(follow.getWound());
				//患病其他
				record.setSickenOther(follow.getOthers());
				
				//record.setTransferTreatment(transferTreatment);
				//转诊原因
				record.setTransferTreatmentReason(follow.getReason());
				//转诊机构和科室
				record.setTransferTreatmentDepartment(follow.getHospital());
				//指导
				record.setGuidance(follow.getDirect());
				
				//record.setGuidanceOther(follow);
				//下次随访日期
				record.setNextVisitDate(follow.getNextFollowDate());
				//随方医生签名
				record.setVisitDoctor(follow.getFollowDicName());
				
				record.setCreateName(follow.getCreated_By());
				record.setCreateOrg(follow.getDuns());
				Organization org = organizationDao.getOrganizationByCode(follow.getDuns());
				if(org != null){
					record.setCreateOrgName(org.getOrganName());
				}				
				record.setCreateTime(DateUtil.getDate(follow.getCreated_Date(), "yyyy-MM-dd HH:mm:ss"));
				//record.setCreateUser(follow.getCreated_By());
														
				record.setUpdateName(follow.getUpdated_By());
				record.setUpdateTime(DateUtil.getDate(follow.getUpdated_Date(), "yyyy-MM-dd HH:mm:ss"));
				//record.setUpdateUser(follow.getUpdated_By());
				//record.setUploadResult(uploadResult);
				record.setUploadStatus(0);
				//record.setUploadTime(uploadTime);
					
				childrenHealthRecordDao.insertSelective(record);
				err.setCode("0");
			}catch(Exception e){
				e.printStackTrace();
				err.setCode("-1");
				
			}
			errList.add(err);
		}
		errInfo.setChildrenHealthCheck(errList);
		return errInfo;
	}

	@Override
	public ErrorInfo healthManage(HealthManageBo bo) {
		// TODO Auto-generated method stub
		ErrorInfo errInfo = new ErrorInfo();
		List<Error> errList = new ArrayList<Error>();
		for(int j = 0; j < bo.getElderlyHealthManage().size(); j++){
			Error err = new Error();
			try{
				HealthManage follow = bo.getElderlyHealthManage().get(j);
				PhysicalExamination record = new PhysicalExamination();
				err.setId(follow.getUUID());
				err.setInfo(follow.getId());

				record.setId(CodeUtil.getUUID());
				record.setArchiveNo(follow.getArchiveId());			
				List<ResidentBaseInfo> residents = residentBaseInfoDao.findResidentByArchiveNo(follow.getArchiveId());
				String idNumber = "";
				if(residents != null && residents.size() > 0){
					record.setName(residents.get(0).getName());	
					record.setIdNumber(residents.get(0).getIdNumber());
					idNumber = residents.get(0).getIdNumber();
					record.setIdNumber(idNumber);
				}
				
				//体检分类
				record.setCheckFlag(follow.getCheckFlag());
				//责任医生
				record.setDutydoctor(follow.getDutydoctor());
				record.setSymptom(follow.getSymptom());
				record.setSymptomOther(follow.getSymptom_other());
				record.setCheckDate(follow.getCheckdate());
				record.setBaseTemperature(follow.getHeat());
				record.setBaseHeartbeat(follow.getCardiotach_ometer());
				record.setBaseRespiratory(follow.getBreath_count()== null?"":follow.getBreath_count().toString());
				record.setBaseBloodPressureLeftHigh(follow.getLeftsbp());
				record.setBaseBloodPressureLeftLow(follow.getLeftdbp());
				record.setBaseBloodPressureRightHigh(follow.getRightsbp());
				record.setBaseBloodPressureRightLow(follow.getRightdbp());
				record.setBaseHeight(follow.getHeight());
				record.setBaseWeight(follow.getWeight());
				record.setBaseWaist(follow.getWaistline());
				record.setBaseBmi(follow.getBmi());
				
				record.setBaseHealthEstimate(follow.getHealthstate());
				record.setBaseSelfcareEstimate(follow.getLivingstate());
				record.setBaseCognitionEstimate(follow.getOldkown());
				record.setBaseCognitionScore(follow.getOldkown_fee() == null?"":follow.getOldkown_fee().toString());
				record.setBaseFeelingEstimate(follow.getOldfeeling());
				record.setBaseFeelingScore(follow.getOldfeeling_fee() == null?"":follow.getOldfeeling_fee().toString());
				
				record.setLifewayExerciseFrequency(follow.getExercise_frequency());
				record.setLifewayExerciseTime(follow.getExercise_timeslice() == null?"":follow.getExercise_timeslice().toString());
				record.setLifewayExerciseYear(follow.getPersisttime() == null?"":follow.getPersisttime().toString());
				record.setLifewayExerciseType(follow.getExercise_method());
				record.setLifewayDiet(follow.getEat_habit());
				
				record.setLifewaySmokeStatus(follow.getSmoke_frequency());
				record.setLifewaySmokeNumber(follow.getSmoke_count_day() == null?"":follow.getSmoke_count_day().toString());
				record.setLifewaySmokeStartage(follow.getSmoke_start_age() == null?"":follow.getSmoke_start_age().toString());
				record.setLifewaySmokeEndage(follow.getSmoke_end_age() == null?"":follow.getSmoke_end_age().toString());
				
				record.setLifewayDrinkStatus(follow.getWine_frequency());
				record.setLifewayDrinkNumber(follow.getWine_count() == null?"":follow.getWine_count().toString());
				record.setLifewayDrinkStop(follow.getWine_refrain());
				record.setLifewayDrinkStopage(follow.getWine_refrain_age() == null?"":follow.getWine_refrain_age().toString());
				record.setLifewayDrinkStartage(follow.getWine_start_age() == null?"":follow.getWine_start_age().toString());
				record.setLifewayDrinkOneyear(follow.getIsstoned());
				record.setLifewayDrinkType(follow.getWine_type());
				record.setLifewayDrinkOther(follow.getWine_other());
				
				record.setLifewayOccupationalDisease(follow.getUndress());
				record.setLifewayJob(follow.getUndress_work());
				record.setLifewayJobPeriod(follow.getUndress_worktime() == null?"":follow.getUndress_worktime().toString());
				
				record.setOrganLips(follow.getLip());
				record.setOrganTooth(follow.getTooth());
				record.setOrganHypodontiaTopleft(follow.getToothless_top());
				record.setOrganHypodontiaTopright(follow.getToothless_right());
				record.setOrganHypodontiaBottomleft(follow.getToothless_left());
				record.setOrganHypodontiaBottomright(follow.getToothless_down());
				record.setOrganCariesTopleft(follow.getDecayedtooth_top());
				record.setOrganCariesTopright(follow.getDecayedtooth_right());
				record.setOrganCariesBottomleft(follow.getDecayedtooth_left());
				record.setOrganCariesBottomright(follow.getDecayedtooth_down());
				record.setOrganDentureTopleft(follow.getFalsetooth_top());
				record.setOrganDentureTopright(follow.getFalsetooth_right());
				record.setOrganDentureBottomleft(follow.getFalsetooth_left());
				record.setOrganDentureBottomright(follow.getFalsetooth_down());
				
				record.setOrganGuttur(follow.getYanbu());
				record.setOrganVisionLeft(follow.getEye_nakedness_left());
				record.setOrganVisionRight(follow.getEye_nakedness_right());
				record.setOrganCorrectedvisionLeft(follow.getEye_remedy_left());
				record.setOrganCorrectedvisionRight(follow.getEye_remedy_right());
				record.setOrganHearing(follow.getAudition());
				record.setOrganMovement(follow.getSport_fun());
				
				record.setExaminationEye(follow.getFundus());
				record.setExaminationEyeOther(follow.getFundus_other());
				record.setExaminationSkin(follow.getSkin());
				record.setExaminationSkinOther(follow.getSkin_other());
				record.setExaminationSclera(follow.getSclera());
				record.setExaminationScleraOther(follow.getSclera_other());
				record.setExaminationLymph(follow.getLymph());
				record.setExaminationLymphOther(follow.getLymph_other());
				record.setExaminationBarrelChest(follow.getBarrel_chest());
				record.setExaminationBreathSounds(follow.getBreathing());
				record.setExaminationBreathOther(follow.getBreathing_other());
				record.setExaminationRale(follow.getRales());
				record.setExaminationRaleOther(follow.getRales_other());
				
				record.setExaminationHeartRate(follow.getHeart_rate() == null?"":follow.getHeart_rate().toString());
				record.setExaminationHeartRhythm(follow.getRhythm() == null?"":follow.getRhythm().toString());
				record.setExaminationHeartNoise(follow.getNoise());
				record.setExaminationNoiseOther(follow.getNoise_memo());
				
				record.setExaminationAbdomenTenderness(follow.getTenderness());
				record.setExaminationTendernessMemo(follow.getTenderness_memo());
				record.setExaminationAbdomenMass(follow.getMass());
				record.setExaminationMassMemo(follow.getMass_memo());
				record.setExaminationAbdomenHepatomegaly(follow.getLiver());
				record.setExaminationHepatomegalyMemo(follow.getLiver_memo());
				record.setExaminationAbdomenSplenomegaly(follow.getSpleen());
				record.setExaminationSplenomegalyMemo(follow.getSpleen_memo());
				record.setExaminationAbdomenShiftingdullness(follow.getDullness());
				record.setExaminationShiftingdullnessMemo(follow.getDullness_memo());
				record.setExaminationLowerextremityEdema(follow.getEdema());
				record.setExaminationDorsalArtery(follow.getDorsal());
				
				record.setExaminationAnus(follow.getDre());
				record.setExaminationAnusOther(follow.getDre_memo());
				record.setExaminationBreast(follow.getBreast());
				record.setExaminationBreastOther(follow.getBreast_memo());
				
				record.setExaminationWomanVulva(follow.getVulva());
				record.setExaminationVulvaMemo(follow.getVulva_memo());
				record.setExaminationWomanVagina(follow.getVaginal());
				record.setExaminationVaginaMemo(follow.getVaginal_memo());
				record.setExaminationWomanCervix(follow.getCervix());
				record.setExaminationCervixMemo(follow.getCervix_memo());
				record.setExaminationWomanCorpus(follow.getPalace());
				record.setExaminationCorpusMemo(follow.getPalace_memo());
				record.setExaminationWomanAccessories(follow.getAttachment());
				record.setExaminationAccessoriesMemo(follow.getAttachment_memo());
				record.setExaminationOther(follow.getExamination_memo());
				
				//血红蛋白
				record.setBloodHemoglobin(follow.getHemoglobined());
				//白细胞
				record.setBloodLeukocyte(follow.getLeukocyte());
				//血小板
				record.setBloodPlatelet(follow.getPlatelet());
				//血常规其他
				record.setBloodOther(follow.getBlood_memo());
				
				//尿蛋白
				record.setUrineProtein(follow.getUrinary_protein());
				//尿糖
				record.setGlycosuria(follow.getUrine());
				//尿酮体
				record.setUrineAcetoneBodies(follow.getKetone());
				//尿潜血
				record.setBld(follow.getOccult_blood());
				//尿常规其他
				record.setUrineOther(follow.getUrine_memo());
				
				//空腹血糖mol
				record.setBloodGlucoseMmol(follow.getBsugar_mmo());
				//空腹血糖mg
				record.setBloodGlucoseMg(follow.getBsugar_mg());
				//心电图
				record.setCardiogram(follow.getEcg());
				//心电图描述
				record.setCardiogramMemo(follow.getEcg_memo());
				
				//尿微量白蛋白
				record.setMicroalbuminuria(follow.getUrinary_albumin());
				//大便潜血
				record.setFob(follow.getOccult_blooded());
				//糖化血红蛋白
				record.setGlycosylatedHemoglobin(follow.getHemoglobin());
				//乙型肝炎表面抗原
				record.setHb(follow.getHbeag());
				//血清谷丙转氨酶
				record.setSgft(follow.getAlt());
				//血清谷草转氨酶
				record.setAst(follow.getAst());
				//白蛋白
				record.setAlbumin(follow.getAlbumin());
				//总胆红素
				record.setTotalBilirubin(follow.getBilirubin_total());
				//结合胆红素
				record.setConjugatedBilirubin(follow.getBilirubin_combine());
				//血清肌酐
				record.setScr(follow.getScr());
				//血尿素
				record.setBloodUrea(follow.getBun());
				//血钾浓度
				record.setBloodK(follow.getPotassium());
				//血钠浓度
				record.setBloodNa(follow.getSerum_sodium());
				//总胆固醇
				record.setTc(follow.getCholesterol());
				//甘油三酯
				record.setTg(follow.getTriglycerides());
				//血清低密度脂蛋白胆固醇
				record.setLdl(follow.getL_cholesterol());
				//血清高密度脂蛋白胆固醇
				record.setHdl(follow.getH_cholesterol());
				
				//胸部X线片
				record.setChestX(follow.getXray());
				//X线片描述
				record.setXMemo(follow.getXray_memo());
				//腹部B超
				record.setUltrasoundAbdomen(follow.getBultrasound());
				//腹部B超异常描述
				record.setUltrasoundMemo(follow.getBultrasound_memo());
				//其他B超
				record.setOtherB(follow.getBsound());
				//其他B超异常描述
				record.setOtherbMemo(follow.getBsound_memo());
				//宫颈涂片
				record.setCervicalSmear(follow.getCervix());
				//宫颈涂片异常描述
				record.setCervicalSmearMemo(follow.getCervix_Explain());
				//辅助检查-其他
				record.setOther(follow.getCheck_other());
				
				//脑血管疾病
				record.setCerebrovascularDisease(follow.getCerebrovascular());
				//其他脑血管疾病
				record.setCerebrovascularDiseaseOther(follow.getCerebrovascular_memo());
				//肾脏疾病
				record.setKidneyDisease(follow.getKidney());
				//肾脏疾病其他
				record.setKidneyDiseaseOther(follow.getKidney_other());
				//心脏疾病
				record.setHeartDisease(follow.getHeartdis());
				//其他心脏疾病
				record.setHeartDiseaseOther(follow.getHeartdis_other());
				//血管疾病
				record.setVascularDisease(follow.getBlooddis());
				record.setVascularDiseaseOther(follow.getBlooddis_other());
				//眼部疾病
				record.setOcularDiseases(follow.getEysdis());
				record.setOcularDiseasesOther(follow.getEysdis_other());
				//神经系统疾病
				record.setNervousSystemDisease(follow.getNervousdis());
				record.setNervousDiseaseMemo(follow.getNervousdis_memo());
				//其他系统疾病
				record.setOtherDisease(follow.getHasotherdis());
				record.setOtherDiseaseMemo(follow.getOtherdismemo());
				
				//健康评价
				record.setHealthEvaluation(follow.getHealthesti());
				//健康指导
				record.setHealthGuidance(follow.getHealthguide());
				//危险因素控制
				record.setDangerControlling(follow.getDangercontrol());
				//目标体重
				record.setTargetWeight(follow.getWeighttarget());
				//建议接种疫苗
				record.setAdviseBacterin(follow.getAdvisebacterin());
				//其他危险因素控制
				record.setDangerControllingOther(follow.getOtherdanger());
				//其他危险因素控制
				record.setHealthAdvice(follow.getHealthadvice());
						
				record.setCreateName(follow.getCreated_By());
				record.setCreateOrg(follow.getDuns());
				Organization org = organizationDao.getOrganizationByCode(follow.getDuns());
				if(org != null){
					record.setCreateOrgName(org.getOrganName());
				}				
				record.setCreateTime(DateUtil.getDate(follow.getCreated_Date(), "yyyy-MM-dd HH:mm:ss"));
				record.setCreateUser(follow.getCreated_By());
														
				record.setUpdateName(follow.getUpdated_By());
				record.setUpdateTime(DateUtil.getDate(follow.getUpdated_Date(), "yyyy-MM-dd HH:mm:ss"));
				record.setUpdateUser(follow.getUpdated_By());
				//record.setUploadResult(uploadResult);
				record.setUploadStatus(0);
				//record.setUploadTime(uploadTime);
				physicalExaminationDao.insertSelective(record);
				err.setCode("0");
			}catch(Exception e){
				e.printStackTrace();
				err.setCode("-1");
				
			}
			errList.add(err);
		}
		errInfo.setElderlyHealthManage(errList);
		return errInfo;
	}
}
