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
	
	//户籍住址
	@JSONField(name = "REGISTER_COMMITTEE")
	private String register_committee;
	
	//现住址
	@JSONField(name = "CURADDR_COMMITTEE")
	private String curaddr_committee;
	
	//详细住址
	@JSONField(name = "CURADDR_DOORNO")
	private String curaddr_doorno;
	
	//工作单位
	@JSONField(name = "COMPANY")
	private String company;
	
	//本人电话
	@JSONField(name = "TEL")
	private String tel;
	
	//联系人姓名
	@JSONField(name = "LINKMAN")
	private String linkman;
	
	//联系人电话
	@JSONField(name = "LINKMAN_TEL")
	private String linkman_tel;
	
	//常住类型
	@JSONField(name = "RESIDENT_TYPE")
	private String resident_type;

	//民族
	@JSONField(name = "NATION")
	private String nation;
	
	//血型
	@JSONField(name = "BLOOD_GROUP")
	private String blood_group;
	
	//RH血型
	@JSONField(name = "BLOOD_RH")
	private String blood_rh;
	
	//文化程度
	@JSONField(name = "EDUCATION")
	private String education;
	
	//职业
	@JSONField(name = "PROFESSION")
	private String profession;
	
	//婚姻状况
	@JSONField(name = "MARITAL_STATUS")
	private String marital_status;

	//医疗费用支付方式
	@JSONField(name = "PAY_TYPE")
	private String pay_type;
	
	//其他支付方式
	@JSONField(name = "PAY_OTHER")
	private String pay_other;
	
	//药物过敏史
	@JSONField(name = "DRUG_ALLERGY")
	private String drug_allergy;
	
	//其他过敏
	@JSONField(name = "ALLERGY_OTHER")
	private String allergy_other;

	//暴露史
	@JSONField(name = "EXPOSURE")
	private String exposure;
	
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

	//是否遗传病
	@JSONField(name = "IS_HEREDITY")
	private String is_heredity;
	
	//遗传病名称
	@JSONField(name = "HEREDITY_NAME")
	private String heredity_name;
	
	//是否残疾
	@JSONField(name = "IS_DEFORMITY")
	private String is_deformity;
	
	//残疾名字
	@JSONField(name = "DEFORMITY_NAME")
	private String deformity_name;	

	//厨房排风设施
	@JSONField(name = "KITCHEN")
	private String kitchen;	
	
	//燃料类型
	@JSONField(name = "FUEL")
	private String fuel;	

	//燃料类型(其它)
	@JSONField(name = "OTHER_FUEL")
	private String other_fuel;

	//饮水
	@JSONField(name = "DRINK")
	private String drink;
	
	//饮水(其它)
	@JSONField(name = "OTHER_DRINK")
	private String other_drink;

	//厕所
	@JSONField(name = "TOILET")
	private String toilet;
	
	//禽畜栏
	@JSONField(name = "POULTRY")
	private String poultry;
	
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
