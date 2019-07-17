package com.zkhw.api.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NeonatusBaseInfo extends BaseBo{

	private String id;
	
	private String archiveid;
	
	//出生医学证明编号
	private String certifino;
	
	//新生儿姓名
	private String fullname;
	
	//新生儿性别代码
	private String gender;
	
	//新生儿出生日期时间
	private String birthday;
	
	//儿童保健号
	private String healthNo;
	
	//身份证号
	private String identityno;
	
	//家庭住址
	private String address;
	
	//家庭住址-门牌号
	private String addrDoorNo;
	
	//母亲证件类型
	private String mCardType;
	
	//母亲姓名
	private String mothername;
	
	//母亲保健号
	private String mHealthNo;
	
	//母亲身份证件-号码
	private String motherid;
	
	//母亲出生日期
	private String matherBirthday;
	
	//母亲职业
	private String matherProfession;
	
	//是否管理
	private String isManage;
	
	//母亲电话
	private String matherPhone;
	
	//母亲妊娠患病情况
	private String matherPregnacy;
	
	//妊娠患病情况其他
	private String matherPregnacy_other;
	
	//父亲姓名
	private String fathername;
	
	//父亲出生日期
	private String fatherBirthday;
	
	//父亲身份证件-号码
	private String fatherid;
	
	//父亲职业
	private String fatherProfession;
	
	//其它出生情况
	private String birthStatus_other;
	
	//父亲电话
	private String fatherPhone;
	
	//Apgar评分
	private String apgar;
	
	//新生儿窒息
	private String asphyxiaOfNewborn;
	
	//出生情况
	private String birthdayStatus;
	
	//胎次
	private Integer Taici;
	
	//助产人员姓名
	private String doctorname;
	
	//助产机构名称
	private String hospitalname;
	
	//是否畸形
	private String deformity;
	
	//畸形情况
	private String deformityinfo;
	
	//出生孕周
	private Integer pregnancyweek;
	
	//出生身长（cm）
	private String height;
	
	//出生体重（g）
	private String weight;
	
	//备注
	private String Remark;
	
	private String UUID;
}
