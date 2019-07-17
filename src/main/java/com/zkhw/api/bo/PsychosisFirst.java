package com.zkhw.api.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PsychosisFirst extends BaseBo{

	private String id;
	
	private String archiveid;
	
	//户别
	private String Hb;
	
	//就业情况
	private String JYQK;
	
	//监护人姓名
	private String guardian;
	
	//与患者关系
	private String relation;
	
	//监护人住址
	private String guardianAddr;
	
	//监护人电话
	private String guardianTel;
	
	//辖区村(居)委会联系人
	private String linkman;
	
	//联系人电话
	private String linkmanTel;
	
	//是否同意管理
	private String isAgree;
	
	//监护人签字
	private String signature;
		
	//签字时间
	private String signatureDate;
	
	//初次发病时间
	private String outbreakDate;
	
	//既往主要症状
	private String symptom;
	
	//其它症状
	private String otherSymptom;
	
	//门诊情况
	private String outp;
	
	//首次抗精神病药治疗时间
	private String firstTreatDate;
	
	//曾住精神专科医院/综合医院精神专科次数
	private Integer inpCount;
	
	//目前诊断
	private String curDiagnose;
	
	//确诊医院
	private String diagnoseHospital;
	
	//确诊日期
	private String diagnoseDate;
	
	//最近一次治疗效果
	private String latestTreatRes;
	
	//患病对家庭社会的影响
	private String impact;
	
	//轻度滋事(次)
	private Integer trouble;
	
	//肇事(次)
	private Integer accident;
	
	//肇祸(次)
	private Integer problem;
	
	//自伤(次)
	private Integer selfInjury;
	
	//其它危害行为(次)
	private Integer Behavior;
	
	//自杀未遂(次)
	private Integer attemptedSuicide;
	
	//关锁情况
	private String lockqk;
	
	//经济状况
	private String economic;
	
	//专科医生的意见
	private String doctAdvice;
	
	//填表日期
	private String inputDate;
	
	//医生签字
	private String doctor;
	
	//备注
	private String remark;
	
	private String UUID;
	
}
