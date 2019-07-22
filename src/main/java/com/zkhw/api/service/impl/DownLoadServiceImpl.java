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
import com.zkhw.pub.dao.ResidentBaseInfoDao;
import com.zkhw.pub.entity.ResidentBaseInfo;
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
			//info.setCuraddr_committee(curaddr_committee);
			info.setCuraddr_doorno(res.getResidenceAddress());

			info.setTel(res.getPhone());
			info.setLinkman(res.getLinkName());
			info.setLinkman_tel(res.getLinkPhone());

			info.setDishyperflag(res.getIsHypertension() == null?"":res.getIsHypertension().toString());
			info.setDisdmflag(res.getIsDiabetes() == null?"":res.getIsDiabetes().toString());
			info.setDismentalflag(res.getIsPsychosis() == null?"":res.getIsPsychosis().toString());
			info.setDistbflag(res.getIsTuberculosis() == null?"":res.getIsTuberculosis().toString());
			info.setArchstatus(res.getStatus());
			info.setDutydoctor(res.getDoctorId());
			info.setBuild_date(res.getCreateTime());
			info.setBuilddoctor(res.getCreateName());
			info.setDuns(res.getCreateOrg());
			info.setCreatedBy(res.getCreateUser());
			info.setCreatedDate(res.getCreateTime());
			
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

}
