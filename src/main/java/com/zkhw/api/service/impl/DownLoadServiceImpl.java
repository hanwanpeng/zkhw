package com.zkhw.api.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.zkhw.api.bo.AccountInfo;
import com.zkhw.api.bo.AccountInfoBo;
import com.zkhw.api.bo.AppUpdateBo;
import com.zkhw.api.bo.AreaBo;
import com.zkhw.api.bo.AreaInfo;
import com.zkhw.api.bo.CheckResidentBatchBo;
import com.zkhw.api.bo.CheckResidentBo;
import com.zkhw.api.bo.DictBo;
import com.zkhw.api.bo.DictInfo;
import com.zkhw.api.bo.FamilyHistory;
import com.zkhw.api.bo.OperationHistory;
import com.zkhw.api.bo.OrgBo;
import com.zkhw.api.bo.OrgInfo;
import com.zkhw.api.bo.ResidentDownBo;
import com.zkhw.api.bo.ResidentInfo;
import com.zkhw.api.bo.UserBo;
import com.zkhw.api.bo.UserInfo;
import com.zkhw.api.bo.Yunfu;
import com.zkhw.api.bo.YunfuBo;
import com.zkhw.api.service.DownLoadService;
import com.zkhw.code.dao.AreaConfigDao;
import com.zkhw.code.dao.DictionariesDao;
import com.zkhw.code.entity.AreaConfig;
import com.zkhw.code.entity.Dictionaries;
import com.zkhw.flup.dao.GravidaInfoDao;
import com.zkhw.flup.entity.GravidaInfo;
import com.zkhw.flup.query.GravidaInfoQuery;
import com.zkhw.framework.utils.DateUtil;
import com.zkhw.ltd.dao.OrganizationDao;
import com.zkhw.ltd.dao.UserDao;
import com.zkhw.ltd.entity.Organization;
import com.zkhw.ltd.entity.User;
import com.zkhw.pub.dao.FamilyRecordDao;
import com.zkhw.pub.dao.MentachysisRecordDao;
import com.zkhw.pub.dao.OperationRecordDao;
import com.zkhw.pub.dao.ResidentBaseInfoDao;
import com.zkhw.pub.dao.ResidentDiseasesDao;
import com.zkhw.pub.dao.TraumatismRecordDao;
import com.zkhw.pub.entity.FamilyRecord;
import com.zkhw.pub.entity.MetachysisRecord;
import com.zkhw.pub.entity.OperationRecord;
import com.zkhw.pub.entity.ResidentBaseInfo;
import com.zkhw.pub.entity.ResidentDiseases;
import com.zkhw.pub.entity.TraumatismRecord;
import com.zkhw.pub.query.ResidentBaseInfoQuery;
import com.zkhw.sys.dao.AppVersionsDao;
import com.zkhw.sys.entity.AppVersions;

@Service
public class DownLoadServiceImpl implements DownLoadService {

	@Autowired
	private OrganizationDao organizationDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ResidentBaseInfoDao residentBaseInfoDao;
	
	@Autowired
	private AreaConfigDao areaConfigDao;
	
	@Autowired
	private DictionariesDao dictionariesDao;
	
	@Autowired
	private AppVersionsDao appVersionsDao;
	
	@Autowired
	private GravidaInfoDao gravidaInfoDao;
	
	@Autowired
	private ResidentDiseasesDao residentDiseasesDao;
	
	@Autowired
	private FamilyRecordDao familyRecordDao;
	
	@Autowired
	private OperationRecordDao operationRecordDao;
	
	@Autowired
	private TraumatismRecordDao traumatismRecordDao;
	
	@Autowired
	private MentachysisRecordDao mentachysisRecordDao;
	
	@Override
	public OrgBo getOrgList(String startIndex, String returnSize, String duns) {
		int start = 0;		
		int pageSize = 0;
		int total = 0;
		OrgBo bo = new OrgBo();
		List<OrgInfo> orgList = new ArrayList<OrgInfo>();
		List<Organization> list = new ArrayList<Organization>();
		if(StringUtil.isEmpty(startIndex)){
			start = 1;
		}else{
			start = Integer.parseInt(startIndex);
		}
		
		if(StringUtil.isNotEmpty(returnSize)){
			pageSize = Integer.parseInt(returnSize);
		}
		
		if(pageSize != 0){
			//PageHelper.startPage(start, pageSize);//pageNum, pageSize	
			PageHelper.offsetPage(start, pageSize);
		}	
		if(StringUtil.isNotEmpty(duns)){
			List<Organization> childList = organizationDao.findChildren(duns);
			PageInfo<Organization> page = new PageInfo<Organization>(list);
			total = Integer.parseInt(String.valueOf(page.getTotal() + 1));
			Organization o = organizationDao.getOrganizationByCode(duns);
			list.add(o);
			list.addAll(childList);
		}else{
			list = organizationDao.findOrganizationList(new Organization());
			PageInfo<Organization> page = new PageInfo<Organization>(list);
			total = Integer.parseInt(String.valueOf(page.getTotal()));
		}
		for(int i = 0; i < list.size(); i++){
			Organization org = list.get(i);
			OrgInfo info = new OrgInfo();
			info.setADDRESS(org.getAddress());
			info.setDUNS(org.getOrganCode());
			info.setLEVELX(org.getOrganLevel());
			info.setNAME(org.getOrganName());
			info.setPARENTSID(org.getOrganParentCode());
			info.setUSESTATUS("1");
			info.setZZJGLM(org.getOrganCode().substring(org.getOrganCode().length() -3, org.getOrganCode().length()));
			orgList.add(info);
		}
		
		bo.setSyncTime(DateUtil.getTodaySecondString());
		bo.setModels(orgList);
		bo.setReturnSize(orgList.size());
		if(StringUtil.isNotEmpty(startIndex)){
			bo.setStart(Integer.parseInt(startIndex));
		}else{
			bo.setStart(1);
		}		
		bo.setTotal(total);
		return bo;
	}

	@Override
	public UserBo getUserList(String startIndex, String returnSize, String duns) {
		int start = 0;		
		int pageSize = 0;
		int total = 0;
		UserBo bo = new UserBo();
		List<UserInfo> userList = new ArrayList<UserInfo>();
		List<User> list = new ArrayList<User>();
		if(StringUtil.isEmpty(startIndex)){
			start = 1;
		}else{
			start = Integer.parseInt(startIndex);
		}
		
		if(StringUtil.isNotEmpty(returnSize)){
			pageSize = Integer.parseInt(returnSize);
		}
		
		if(pageSize != 0){
			//PageHelper.startPage(start, pageSize);//pageNum, pageSize	
			PageHelper.offsetPage(start, pageSize);
		}	
		if(StringUtil.isNotEmpty(duns)){
			list = userDao.findUserByOrgan(duns);
		}else{
			list = userDao.findUserBySearch(new User());
		}
		PageInfo<User> page = new PageInfo<User>(list);
		total = Integer.parseInt(String.valueOf(page.getTotal()));
		
		for(int i = 0; i < list.size(); i++){
			User u = list.get(i);
			UserInfo info = new UserInfo();
			info.setId(u.getUserCode());
			info.setUserId(u.getLoginName());
			info.setFirstName(u.getUserName());
			info.setDeptNo(u.getOrganCode());
			userList.add(info);
		}
		
		bo.setSyncTime(DateUtil.getTodaySecondString());
		bo.setModels(userList);
		bo.setReturnSize(userList.size());
		if(StringUtil.isNotEmpty(startIndex)){
			bo.setStart(Integer.parseInt(startIndex));
		}else{
			bo.setStart(1);
		}		
		bo.setTotal(total);
		return bo;
	}

	@Override
	public ResidentDownBo getResidentList(String startIndex, String returnSize, String duns) {
		int start = 0;			
		int pageSize = 0;
		int total = 0;
		ResidentDownBo bo = new ResidentDownBo();
		List<ResidentInfo> infoList = new ArrayList<ResidentInfo>();
		if(StringUtil.isEmpty(startIndex)){
			start = 1;
		}else{
			start = Integer.parseInt(startIndex);
		}
		
		if(StringUtil.isNotEmpty(returnSize)){
			pageSize = Integer.parseInt(returnSize);
		}
		ResidentBaseInfoQuery query = new ResidentBaseInfoQuery();
		if(StringUtil.isNotEmpty(duns)){
			Organization o = organizationDao.getOrganizationByCode(duns);
			if(StringUtil.isNotEmpty(o.getVillageCode())){
				query.setVillageCode(o.getVillageCode());
			}else if(StringUtil.isNotEmpty(o.getTownsCode())){
				query.setTownsCode(o.getTownsCode());
			}else if(StringUtil.isNotEmpty(o.getCountyCode())){
				query.setCountyCode(o.getCountyCode());;
			}else{
				query.setOrgCode(duns);	
			}
		}
		if(pageSize != 0){
			//PageHelper.startPage(start, pageSize);//pageNum, pageSize	
			PageHelper.offsetPage(start, pageSize);
		}	
		List<ResidentBaseInfo> list = residentBaseInfoDao.findResidentList(query);
		PageInfo<ResidentBaseInfo> page = new PageInfo<ResidentBaseInfo>(list);
		total = Integer.parseInt(String.valueOf(page.getTotal()));
		for(int i = 0; i < list.size(); i++){
			ResidentBaseInfo res = list.get(i);
			ResidentInfo info = new ResidentInfo();
			info.setId(res.getId());
			info.setArchiveid(res.getArchiveNo());
			info.setGender(res.getSex());
			info.setFullname(res.getName());
			info.setBirthday(res.getBirthday());
			
			info.setIdentityno(res.getIdNumber());
			info.setRegister_committee(res.getRegisterAddress());
			//info.setCuraddr_committee(curaddr_committee);
			info.setCuraddr_doorno(res.getResidenceAddress());
			info.setCompany(res.getCompany());

			info.setTel(res.getPhone());
			info.setLinkman(res.getLinkName());
			info.setLinkman_tel(res.getLinkPhone());
			info.setResident_type(res.getResidentType());
			info.setNation(res.getNation());
			info.setBlood_group(res.getBloodGroup());
			info.setBlood_rh(res.getBloodRh());
			info.setEducation(res.getEducation());
			info.setProfession(res.getProfession());
			info.setMarital_status(res.getMaritalStatus());
			info.setPay_type(res.getPayType());
			info.setPay_other(res.getPayOther());
			
			info.setDrug_allergy(res.getDrugAllergy());
			info.setAllergy_other(res.getAllergyOther());
			info.setExposure(res.getExposure());
			
			info.setDishyperflag(res.getIsHypertension() == null?"":res.getIsHypertension().toString());
			info.setDisdmflag(res.getIsDiabetes() == null?"":res.getIsDiabetes().toString());
			info.setDismentalflag(res.getIsPsychosis() == null?"":res.getIsPsychosis().toString());
			info.setDistbflag(res.getIsTuberculosis() == null?"":res.getIsTuberculosis().toString());
			
			info.setIs_heredity(res.getIsHeredity() == null?"0":res.getIsHeredity().toString());
			info.setHeredity_name(res.getHeredityName());
			info.setIs_deformity(res.getIsDeformity());
			info.setDeformity_name(res.getDeformityName());
			
			info.setKitchen(res.getKitchen());
			info.setFuel(res.getFuel());
			info.setOther_fuel(res.getOtherFuel());
			info.setDrink(res.getDrink());
			info.setOther_drink(res.getOtherDrink());
			info.setToilet(res.getToilet());
			info.setPoultry(res.getPoultry());
			
			info.setArchstatus(res.getStatus());
			info.setDutydoctor(res.getDoctorId());
			info.setIspoor(res.getIsPoor() == null?"":res.getIsPoor().toString());
			info.setBuild_date(res.getCreateTime());
			info.setBuilddoctor(res.getCreateName());
			info.setDuns(res.getCreateOrg());
			info.setCreatedBy(res.getCreateUser());
			info.setCreatedDate(res.getCreateTime());
						
			this.getDiseases(info);
			this.getFamilyHistory(info);
			this.getOperationHistory(info);
			infoList.add(info);
		}
		
		bo.setSyncTime(DateUtil.getTodaySecondString());
		bo.setModels(infoList);
		bo.setReturnSize(infoList.size());
		if(StringUtil.isNotEmpty(startIndex)){
			bo.setStart(Integer.parseInt(startIndex));
		}else{
			bo.setStart(1);
		}		
		bo.setTotal(total);
		return bo;
	}

	@Override
	public AreaBo getAreaInfoList(String startIndex, String returnSize, String areaId) {
		int start = 0;			
		int pageSize = 0;
		int total = 0;
		AreaBo bo = new AreaBo();
		List<AreaInfo> areaList = new ArrayList<AreaInfo>();
		List<AreaConfig> list = new ArrayList<AreaConfig>();
		if(StringUtil.isEmpty(startIndex)){
			start = 1;
		}else{
			start = Integer.parseInt(startIndex);
		}
		
		if(StringUtil.isNotEmpty(returnSize)){
			pageSize = Integer.parseInt(returnSize);
		}
		
		int lev = 0;
		if(StringUtil.isNotEmpty(areaId)){
			AreaConfig area = areaConfigDao.findAreaByCode(areaId);
			lev = area.getLevelType();
			list.add(area);
		}
		List<AreaConfig> childList = null;
		if(pageSize != 0){
			//PageHelper.startPage(start, pageSize);//pageNum, pageSize	
			PageHelper.offsetPage(start, pageSize);
		}	
		if(StringUtil.isNotEmpty(areaId)){
			if(lev == 1){
				childList  = areaConfigDao.findCityByCode(areaId);
			}else if(lev == 2){
				childList = areaConfigDao.findCountyByCode(areaId);
			}else if(lev == 3){
				childList = areaConfigDao.findTownsByCode(areaId);
			}else if(lev == 4){
				childList = areaConfigDao.findVillageByCode(areaId);
			}
			
			PageInfo<AreaConfig> page = new PageInfo<AreaConfig>(childList);
			total = Integer.parseInt(String.valueOf(page.getTotal() + 1));
			if(childList != null){
				list.addAll(childList);
			}
		}else{
			list = areaConfigDao.findAllArea();
			PageInfo<AreaConfig> page = new PageInfo<AreaConfig>(list);
			total = Integer.parseInt(String.valueOf(page.getTotal()));
		}
		for(int i = 0; i < list.size(); i++){
			AreaConfig a = list.get(i);
			AreaInfo info = new AreaInfo();
			info.setID(a.getCode());
			info.setFULLNAME(a.getName());
			info.setNAME(a.getName());
			info.setUSESTATUS("1");
			info.setLEVELX(a.getLevelType() == null?"0":a.getLevelType().toString());
			info.setPID(a.getParentCode());
			areaList.add(info);
		}

		bo.setSyncTime(DateUtil.getTodaySecondString());
		bo.setModels(areaList);
		bo.setReturnSize(areaList.size());
		if(StringUtil.isNotEmpty(startIndex)){
			bo.setStart(Integer.parseInt(startIndex));
		}else{
			bo.setStart(1);
		}		
		bo.setTotal(total);
		return bo;
	}

	@Override
	public AreaBo getLevel3AreaInfoList(String startIndex, String returnSize) {
		int start = 0;			
		int pageSize = 0;
		int total = 0;
		AreaBo bo = new AreaBo();
		List<AreaInfo> areaList = new ArrayList<AreaInfo>();
		List<AreaConfig> list = new ArrayList<AreaConfig>();
		if(StringUtil.isEmpty(startIndex)){
			start = 1;
		}else{
			start = Integer.parseInt(startIndex);
		}
		
		if(StringUtil.isNotEmpty(returnSize)){
			pageSize = Integer.parseInt(returnSize);
		}
		
		if(pageSize != 0){
			//PageHelper.startPage(start, pageSize);//pageNum, pageSize	
			PageHelper.offsetPage(start, pageSize);
		}	
		
		list = areaConfigDao.findAreaByLevel(3);
		PageInfo<AreaConfig> page = new PageInfo<AreaConfig>(list);
		total = Integer.parseInt(String.valueOf(page.getTotal()));
		for(int i = 0; i < list.size(); i++){
			AreaConfig a = list.get(i);
			AreaInfo info = new AreaInfo();
			info.setID(a.getCode());
			info.setFULLNAME(a.getName());
			info.setNAME(a.getName());
			info.setUSESTATUS("1");
			info.setLEVELX(a.getLevelType().toString());
			info.setPID(a.getParentCode());
			areaList.add(info);
		}
		bo.setSyncTime(DateUtil.getTodaySecondString());
		bo.setModels(areaList);
		bo.setReturnSize(areaList.size());
		if(StringUtil.isNotEmpty(startIndex)){
			bo.setStart(Integer.parseInt(startIndex));
		}else{
			bo.setStart(1);
		}		
		bo.setTotal(total);
		return bo;
	}

	@Override
	public DictBo getDictInfoList(String startIndex, String returnSize) {
		int start = 0;			
		int pageSize = 0;
		int total = 0;
		DictBo bo = new DictBo();
		List<DictInfo> dictList = new ArrayList<DictInfo>();
		List<Dictionaries> list = new ArrayList<Dictionaries>();
		if(StringUtil.isEmpty(startIndex)){
			start = 1;
		}else{
			start = Integer.parseInt(startIndex);
		}
		
		if(StringUtil.isNotEmpty(returnSize)){
			pageSize = Integer.parseInt(returnSize);
		}
		
		if(pageSize != 0){
			//PageHelper.startPage(start, pageSize);//pageNum, pageSize	
			PageHelper.offsetPage(start, pageSize);
		}	
		
		list = dictionariesDao.findAll();
		PageInfo<Dictionaries> page = new PageInfo<Dictionaries>(list);
		total = Integer.parseInt(String.valueOf(page.getTotal()));
		for(int i = 0; i < list.size(); i++){
			Dictionaries a = list.get(i);
			DictInfo info = new DictInfo();
			info.setDictCode(a.getDictcode());
			info.setDictId(a.getDictid());
			info.setDictMemo(a.getDictmemo());
			info.setDictStatus(a.getDictstatus());
			info.setDictType(a.getDicttype());
			info.setItemCode(a.getItemcode());
			info.setItemName(a.getItemname());
			info.setOrderNo(a.getOrderno());
			info.setRemark(a.getRemark());
			dictList.add(info);
		}
		bo.setSyncTime(DateUtil.getTodaySecondString());
		bo.setModels(dictList);
		bo.setReturnSize(dictList.size());
		if(StringUtil.isNotEmpty(startIndex)){
			bo.setStart(Integer.parseInt(startIndex));
		}else{
			bo.setStart(1);
		}		
		bo.setTotal(total);
		return bo;
	}

	@Override
	public AccountInfoBo getAccountInfos(String startIndex, String returnSize) {
		int start = 0;		
		int pageSize = 0;
		int total = 0;
		AccountInfoBo bo = new AccountInfoBo();
		List<AccountInfo> accountList = new ArrayList<AccountInfo>();
		List<User> list = new ArrayList<User>();
		if(StringUtil.isEmpty(startIndex)){
			start = 1;
		}else{
			start = Integer.parseInt(startIndex);
		}
		
		if(StringUtil.isNotEmpty(returnSize)){
			pageSize = Integer.parseInt(returnSize);
		}
		
		if(pageSize != 0){
			//PageHelper.startPage(start, pageSize);//pageNum, pageSize	
			PageHelper.offsetPage(start, pageSize);
		}	

		list = userDao.findUserBySearch(new User());

		PageInfo<User> page = new PageInfo<User>(list);
		total = Integer.parseInt(String.valueOf(page.getTotal()));
		
		for(int i = 0; i < list.size(); i++){
			User u = list.get(i);
			AccountInfo info = new AccountInfo();
			info.setUserId(u.getLoginName());
			info.setPwd(u.getLoginPass());
			info.setStatus(u.getStatus() == null?"1":u.getStatus().toString());
			info.setCreateTime(u.getCreateTime());
			info.setUpdateTime(u.getUpdateTime());
			info.setDuns(u.getOrganCode());
			accountList.add(info);
		}
		
		bo.setSyncTime(DateUtil.getTodaySecondString());
		bo.setModels(accountList);
		bo.setReturnSize(accountList.size());
		if(StringUtil.isNotEmpty(startIndex)){
			bo.setStart(Integer.parseInt(startIndex));
		}else{
			bo.setStart(1);
		}		
		bo.setTotal(total);
		return bo;
	}

	@Override
	public CheckResidentBo exitResdident(String idCard) {
		CheckResidentBo bo = new CheckResidentBo();
		ResidentBaseInfo info = residentBaseInfoDao.findResidentByIdNumber(idCard);
		if(info != null){
			bo.setErrCode("0");
			bo.setIsBulid(1);
			bo.setArchiveid(info.getArchiveNo());
			bo.setIdentityNo(info.getIdNumber());
			bo.setFullname(info.getName());
			bo.setGender(info.getSex());
			bo.setBirthday(info.getBirthday());
			bo.setManageDuns(info.getCreateOrg());
			bo.setDutyDoctor(info.getDoctorName());
		}else{
			bo.setErrCode("0");
			bo.setIsBulid(0);
		}
		return bo;
	}

	@Override
	public AppUpdateBo getAppUpdate() {
		AppUpdateBo bo = null;
		AppVersions version = appVersionsDao.getHeadVersion();
		if(version != null){
			bo = new AppUpdateBo();
			bo.setApp_Version(version.getAppVersion());
			bo.setAppName(version.getAppName());
			bo.setAppPath(version.getAppPath());
			bo.setInfo(version.getInfo());
			bo.setIsForce(version.getIsForce());
			bo.setSize(version.getSize());
		}
		return bo;
	}

	@Override
	public List<CheckResidentBatchBo> exitResdidentBatch(String idCard) {
		List<CheckResidentBatchBo> boList = new ArrayList<CheckResidentBatchBo>();
		if(StringUtil.isNotEmpty(idCard)){
			String[] idCards = idCard.split(",");
			for(int i = 0; i < idCards.length; i++){
				CheckResidentBatchBo bo = new CheckResidentBatchBo();
				ResidentBaseInfo info = residentBaseInfoDao.findResidentByIdNumber(idCards[i]);
				if(info != null){
					bo.setErrCode("0");
					bo.setIsBulid(1);
					bo.setArchiveid(info.getArchiveNo());
					bo.setIdentityNo(info.getIdNumber());
					bo.setFullname(info.getName());
					bo.setGender(info.getSex());
					bo.setBirthday(info.getBirthday());
					bo.setManageDuns(info.getCreateOrg());
					bo.setDutyDoctor(info.getDoctorName());
					
				}else{
					bo.setErrCode("0");
					bo.setIsBulid(0);
				}
				boList.add(bo);
			}
		}
		return boList;
	}

	@Override
	public YunfuBo getYunfus(String startIndex, String returnSize) {
		// TODO Auto-generated method stub
		int start = 0;		
		int pageSize = 0;
		int total = 0;
		YunfuBo bo = new YunfuBo();
		List<Yunfu> accountList = new ArrayList<Yunfu>();
		List<GravidaInfo> list = new ArrayList<GravidaInfo>();
		if(StringUtil.isEmpty(startIndex)){
			start = 1;
		}else{
			start = Integer.parseInt(startIndex);
		}
		
		if(StringUtil.isNotEmpty(returnSize)){
			pageSize = Integer.parseInt(returnSize);
		}
		
		if(pageSize != 0){
			//PageHelper.startPage(start, pageSize);//pageNum, pageSize	
			PageHelper.offsetPage(start, pageSize);
		}	
		list = gravidaInfoDao.findGravidaList(new GravidaInfoQuery());

		PageInfo<GravidaInfo> page = new PageInfo<GravidaInfo>(list);
		total = Integer.parseInt(String.valueOf(page.getTotal()));
		
		for(int i = 0; i < list.size(); i++){
			GravidaInfo g = list.get(i);
			Yunfu info = new Yunfu();
			info.setExaminid(g.getId());
			info.setArchiveid(g.getArchiveNo());
			info.setCloseStatus(g.getStatus());
			accountList.add(info);
		}
		
		bo.setSyncTime(DateUtil.getTodaySecondString());
		bo.setModels(accountList);
		bo.setReturnSize(accountList.size());
		if(StringUtil.isNotEmpty(startIndex)){
			bo.setStart(Integer.parseInt(startIndex));
		}else{
			bo.setStart(1);
		}		
		bo.setTotal(total);
		return bo;
	}

	private ResidentInfo getDiseases(ResidentInfo info){
		try{
			ResidentDiseases dis = new ResidentDiseases();
			dis.setArchiveNo(info.getArchiveid());
			List<ResidentDiseases> disList = residentDiseasesDao.selectByArchiveNo(dis);
			if(disList != null && disList.size() > 0){
				for(int i = 0; i < disList.size(); i++){
					ResidentDiseases d = disList.get(i);
					String code = d.getDiseaseType();
					switch (code) {
					case "2":
						info.setDishyperflag("1");
						info.setHyperDiagnoseDate(d.getDiseaseDate());
						break;
					case "3":
						info.setDisdmflag("1");
						info.setDmDiagnoseDate(d.getDiseaseDate());
						break;	
					case "4":
						info.setDisheartflag("1");
						info.setHeartDiagnoseDate(d.getDiseaseDate());
						break;
					case "5":
						info.setDislungflag("1");
						info.setLungdiagnoseDate(d.getDiseaseDate());
						break;
					case "6":
						info.setDistumorflag("1");
						info.setTumorName(d.getDiseaseName());
						info.setTumorDiagnoseDate(d.getDiseaseDate());
						break;
					case "7":
						info.setDisstrokeflag("1");
						info.setStrokeDiagnoseDate(d.getDiseaseDate());
						break;	
					case "8":
						info.setDismentalflag("1");
						info.setMentaDiagnoseDate(d.getDiseaseDate());
						break;	
					case "9":
						info.setDistbflag("1");
						info.setTbDiagnoseDate(d.getDiseaseDate());
						break;	
					case "10":
						info.setDishepatitisflag("1");
						info.setHepatitDiagnoseDate(d.getDiseaseDate());
						break;	
					case "11":
						info.setDisinfectflag("1");
						info.setInfectDiagnoseDate(d.getDiseaseDate());
						break;
					case "12":
						info.setDisoccupationflag("1");
						info.setOccupationName(d.getDiseaseName());
						info.setOccupaDiagnoseDate(d.getDiseaseDate());
						break;	
					case "13":
						info.setDisOtherflag("1");
						info.setDisOtherName(d.getDiseaseName());
						info.setDisOtherDiagnoseDate(d.getDiseaseDate());
						break;						
					default:
						break;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return info;
		
	}
	
	private ResidentInfo getFamilyHistory(ResidentInfo info){
		try{			
			List<FamilyHistory> hisList = new ArrayList<FamilyHistory>();
			FamilyRecord fam = new FamilyRecord();
			fam.setArchiveNo(info.getArchiveid());
			List<FamilyRecord> famList = familyRecordDao.selectByArchiveNo(fam);
			if(famList != null && famList.size() > 0){
				for(int i = 0; i < famList.size(); i++){
					FamilyHistory his = new FamilyHistory();
					his.setArchiveId(famList.get(i).getArchiveNo());
					his.setDisease(famList.get(i).getDiseaseCode());
					his.setDuns(info.getDuns());
					his.setFamilyDisId(famList.get(i).getId());
					his.setOtherDis(famList.get(i).getDiseaseName());
					his.setRelation(famList.get(i).getRelation());
					
					his.setCreated_By(famList.get(i).getCreateName());
					if(famList.get(i).getCreateTime() != null){
						his.setCreated_Date(DateUtil.getDateTimeString(famList.get(i).getCreateTime()));
					}
					his.setUpdated_By(famList.get(i).getUpdateName());
					if(famList.get(i).getUpdateTime() != null){
						his.setUpdated_Date(DateUtil.getDateTimeString(famList.get(i).getUpdateTime()));
					}
					
					his.setUuid(famList.get(i).getId());
					hisList.add(his);
				}
			}
			info.setFamilyHistory(hisList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return info;
	}
	
	private ResidentInfo getOperationHistory(ResidentInfo info){
		try{
			List<OperationHistory> hisList = new ArrayList<OperationHistory>();
			OperationRecord ope = new OperationRecord();			
			ope.setArchiveNo(info.getArchiveid());
			List<OperationRecord> opeList = operationRecordDao.selectByArchiveNo(ope);
			if(opeList != null && opeList.size() > 0){
				for(int i = 0; i < opeList.size(); i++){
					OperationHistory his = new OperationHistory();
					his.setArchiveId(opeList.get(i).getArchiveNo());
					his.setName(opeList.get(i).getOperationName());
					his.setHappenDate(opeList.get(i).getOperationTime());
					his.setDuns(info.getDuns());
					his.setId(opeList.get(i).getId());
					his.setType("SX0075_1");
					
					his.setCreated_By(opeList.get(i).getCreateName());
					if(opeList.get(i).getCreateTime() != null){
						his.setCreated_Date(DateUtil.getDateTimeString(opeList.get(i).getCreateTime()));
					}
					his.setUpdated_By(opeList.get(i).getUpdateName());
					if(opeList.get(i).getUpdateTime() != null){
						his.setUpdated_Date(DateUtil.getDateTimeString(opeList.get(i).getUpdateTime()));
					}
					
					his.setUuid(opeList.get(i).getId());
					hisList.add(his);
				}
			}
			
			TraumatismRecord tra = new TraumatismRecord();			
			tra.setArchiveNo(info.getArchiveid());
			List<TraumatismRecord> traList = traumatismRecordDao.selectByArchiveNo(tra);
			if(traList != null && traList.size() > 0){
				for(int i = 0; i < traList.size(); i++){
					OperationHistory his = new OperationHistory();
					his.setArchiveId(traList.get(i).getArchiveNo());
					his.setName(traList.get(i).getTraumatismName());
					his.setHappenDate(traList.get(i).getTraumatismTime());
					his.setDuns(info.getDuns());
					his.setId(traList.get(i).getId());
					his.setType("SX0075_2");
					
					his.setCreated_By(traList.get(i).getCreateName());
					if(traList.get(i).getCreateTime() != null){
						his.setCreated_Date(DateUtil.getDateTimeString(traList.get(i).getCreateTime()));
					}
					his.setUpdated_By(traList.get(i).getUpdateName());
					if(traList.get(i).getUpdateTime() != null){
						his.setUpdated_Date(DateUtil.getDateTimeString(traList.get(i).getUpdateTime()));
					}
					
					his.setUuid(opeList.get(i).getId());
					hisList.add(his);
				}
			}

			MetachysisRecord met = new MetachysisRecord();			
			met.setArchiveNo(info.getArchiveid());
			List<MetachysisRecord> metList = mentachysisRecordDao.selectByArchiveNo(met);
			if(metList != null && metList.size() > 0){
				for(int i = 0; i < metList.size(); i++){
					OperationHistory his = new OperationHistory();
					his.setArchiveId(metList.get(i).getArchiveNo());
					his.setName(metList.get(i).getMetachysisReasonn());
					his.setHappenDate(metList.get(i).getMetachysisTime());
					his.setDuns(info.getDuns());
					his.setId(metList.get(i).getId());
					his.setType("SX0075_3");
					
					his.setCreated_By(metList.get(i).getCreateName());
					if(metList.get(i).getCreateTime() != null){
						his.setCreated_Date(DateUtil.getDateTimeString(metList.get(i).getCreateTime()));
					}
					his.setUpdated_By(metList.get(i).getUpdateName());
					if(metList.get(i).getUpdateTime() != null){
						his.setUpdated_Date(DateUtil.getDateTimeString(metList.get(i).getUpdateTime()));
					}
					
					his.setUuid(opeList.get(i).getId());
					hisList.add(his);
				}
			}
			
			info.setOperationHistory(hisList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return info;
	}
}
