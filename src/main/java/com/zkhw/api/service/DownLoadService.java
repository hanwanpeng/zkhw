package com.zkhw.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zkhw.api.bo.AccountInfoBo;
import com.zkhw.api.bo.AppUpdateBo;
import com.zkhw.api.bo.AreaBo;
import com.zkhw.api.bo.CheckResidentBatchBo;
import com.zkhw.api.bo.CheckResidentBo;
import com.zkhw.api.bo.DictBo;
import com.zkhw.api.bo.OrgBo;
import com.zkhw.api.bo.ResidentDownBo;
import com.zkhw.api.bo.UserBo;
import com.zkhw.api.bo.YunfuBo;

@Service
public interface DownLoadService {

	OrgBo getOrgList(String startIndex,String returnSize,String duns);
	
	UserBo getUserList(String startIndex,String returnSize,String duns);
	
	ResidentDownBo getResidentList(String startIndex,String returnSize,String duns);
	
	AreaBo getAreaInfoList(String startIndex,String returnSize,String areaId);
	
	AreaBo getLevel3AreaInfoList(String startIndex,String returnSize);
	
	DictBo getDictInfoList(String startIndex,String returnSize);
	
	AccountInfoBo getAccountInfos(String startIndex,String returnSize);
	
	CheckResidentBo exitResdident(String idCard);
	
	List<CheckResidentBatchBo> exitResdidentBatch(String idCard);
	
	AppUpdateBo getAppUpdate();
	
	YunfuBo getYunfus(String startIndex,String returnSize);
}
