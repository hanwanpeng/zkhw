package com.zkhw.api.bo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResidentInfo {

	@JSONField(name = "ID")
	private String id;
	
	@JSONField(name = "ARCHIVEID")
	private String archiveid;
	
	@JSONField(name = "ARCHIVENO")
	private String archiveNo;
	
	@JSONField(name = "FULLNAME")
	private String fullname;
	
	@JSONField(name = "GENDER")
	private String gender;
	
	@JSONField(name = "BIRTHDAY")
	private String birthday;
	
	//身份证号
	@JSONField(name = "IDENTITYNO")
	private String identityno;
	
	//现住址
	@JSONField(name = "CURADDR_COMMITTEE")
	private String curaddr_committee;
	
	//详细住址
	@JSONField(name = "CURADDR_DOORNO")
	private String curaddr_doorno;
	
	//本人电话
	@JSONField(name = "TEL")
	private String tel;
	
	//联系人姓名
	@JSONField(name = "LINKMAN")
	private String linkman;
	
	//联系人电话
	@JSONField(name = "LINKMAN_TEL")
	private String linkman_tel;
	
	//是否患高血压
	@JSONField(name = "DISHYPERFLAG")
	private String dishyperflag;
	
	//是否患糖尿病
	@JSONField(name = "DISDMFLAG")
	private String disdmflag;
	
	//是否患重性精神疾病
	@JSONField(name = "DISMENTALFLAG")
	private String dismentalflag;
	
	//是否患结核病
	@JSONField(name = "DISTBFLAG")
	private String distbflag;
	
	//档案状态
	@JSONField(name = "ARCHSTATUS")
	private String archstatus;
	
	//责任医生
	@JSONField(name = "DUTYDOCTOR")
	private String dutydoctor;
	
	@JSONField(name = "ISPOOR")
	private String ispoor;
	
	//建档日期
	@JSONField(name = "BUILD_DATE")
	private Date build_date;
	
	//建档医生
	@JSONField(name = "BUILDDOCTOR")
	private String builddoctor;
	
	//机构
	@JSONField(name = "DUNS")
	private String duns;
	
	//创建者
	@JSONField(name = "CREATEDBY")
	private String createdBy;
	
	//创建时间
	@JSONField(name = "CREATEDATE")
	private Date createdDate;
	
	//修改者
	@JSONField(name = "UPDATEDBY")
	private String updatedBy;
	
	//修改时间
	@JSONField(name = "UPDATEDDATE")
	private Date updatedDate;
	
}
