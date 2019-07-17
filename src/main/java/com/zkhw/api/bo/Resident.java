package com.zkhw.api.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Resident extends BaseBo{
	private String id;
	
	private String archiveid;
	
	private String fullname;
	
	private String gender;
	
	private String birthday;
	
	//身份证号
	private String identityno;
	
	private String img;
	
	//户籍地址
	private String resaddr_committee;
	
	//户籍地址（门牌号）
	private String resaddr_doorno;
	
	//现住址
	private String curaddr_committee;
	
	//详细住址
	private String curaddr_doorno;
	
	//工作单位
	private String company;
	
	//本人电话
	private String tel;
	
	//联系人姓名
	private String linkman;
	
	//联系人电话
	private String linkman_tel;
	
	//常住类型
	private String residenttype;
	
	//民族
	private String nation;
	
	//血型
	private String bloodgroup;
	
	//RH
	private String bloodrh;
	
	//文化程度
	private String education;
	
	//职业
	private String vocation;
	
	//婚姻状况
	private String marriage;
	
	//医疗费用支付方式
	private String paytype;
	
	//其它支付方式
	private String paytype_other;
	
	//过敏史
	private String hypersuses;
	
	//其它过敏史
	private String hypersuses_other;
	
	//暴露史
	private String undress;
	
	//其它暴露
	private String undress_other;
	
	//是否患高血压
	private String dishyperflag;
	
	//高血压确诊日期
	private String hyperDiagnoseDate;
	
	//是否患糖尿病
	private String disdmflag;
	
	//糖尿病确诊日期
	private String dmDiagnoseDate;
	
	//是否患冠心病
	private String disheartflag;
	
	//冠心病确诊日期
	private String heartDiagnoseDate;
	
	//是否患慢性阻塞性肺疾病
	private String dislungflag;
	
	//肺病确诊日期
	private String lungdiagnoseDate;
	
	//是否患恶性肿瘤
	private String distumorflag;
	
	//恶性肿瘤名称
	private String tumorName;
	
	//恶性肿瘤确诊日期
	private String tumorDiagnoseDate;
	
	//是否患脑卒中
	private String disstrokeflag;
	
	//脑卒中确诊日期
	private String strokeDiagnoseDate;
	
	//是否患重性精神疾病
	private String dismentalflag;
	
	//精神疾病确诊日期
	private String mentaDiagnoseDate;
	
	//是否患结核病
	private String distbflag;
	
	//肺结核确诊日期
	private String tbDiagnoseDate;
	
	//是否患肝炎
	private String dishepatitisflag;
	
	//肝炎确诊日期
	private String hepatitDiagnoseDate;
	
	//是否患其他法定传染病
	private String disinfectflag;
	
	//其他传染病确诊日期
	private String infectDiagnoseDate;
	
	//是否患职业病
	private String disoccupationflag;
	
	//职业病名称
	private String occupationName;
	
	//职业病确诊日期
	private String occupaDiagnoseDate;
	
	//是否患其他疾病
	private String disOtherflag;
	
	//其他疾病名称
	private String disOtherName;
	
	//其他疾病确诊日期
	private String disOtherDiagnoseDate;
	
	//有无遗传病史
	private String has_inherit_dis;
	
	//遗传病名称
	private String inherit_dis;
	
	//有无家族史
	private String hasfamilyList;
	
	//有无手术、外伤、输血史
	private String hasOps;
	
	//残疾情况
	private String deformity;
	
	//其它残疾名称
	private String deformity_other;
	
	//家庭档案id
	private String familyid;
	
	//与户主关系
	private String relationship;
	
	//社保/农合卡号
	private String medicareid;
	
	//档案状态
	private String archstatus;
	
	//责任医生
	private String dutydoctor;
	
	//建档日期
	private String build_date;
	
	//建档医生
	private String builddoctor;
	
	//备注
	private String remark;
	
	//身份证签发机关
	private String idcardIA;
	
	//身份证有效期起始日期
	private String idcardDateStart;
	
	//身份证有效期截止日期
	private String idcardDateEnd;
	
	//是否贫困
	private String isPoor;
	
	//是否签约
	private String isQianYue;
	
	//厨房排风设施
	private String Shhj_cfpfss;
	
	//厕所
	private String Shhj_cs;
	
	//牲畜栏
	private String Shhj_qcl;
	
	//燃料类型
	private String Shhj_rllx;
	
	//饮水
	private String Shhj_ys;
	
	private String UUID;
}
