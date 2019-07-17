package com.zkhw.api.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TuberculosisFollow extends BaseBo{

	private String id;
	
	//第一次随访id
	private String examinid;
	
	private String archiveid;
	
	private String visitDate;
	
	//治疗月序
	private Integer zlyx;
	
	//督导人员
	private String supervisor;
	
	//随访方式
	private String visitstyle;
	
	//症状及体征
	private String sysmpsigns;
	
	//其他
	private String qtsysmpsigns;
	
	//吸烟
	private String smoke;
	
	//目标吸烟量
	private String smoke_target;
	
	//饮酒
	private String drink;
	
	//目标饮酒量
	private String drink_target;
	
	//化疗方案
	private String hlscheme;
	
	//用法
	private String usage;
	
	//药品剂型
	private String ypjx;
	
	//漏服药次数
	private Integer lfycs;
	
	//药物不良反应
	private String ywblfy;
	
	//具体药物不良反应
	private String jtywblfy;
	
	//并发症或合并症
	private String bfzhhbz;
	
	//具体并发症或合并症
	private String jtbfzhhbz;
	
	//科别
	private String kb;
	
	//原因
	private String reason;
	
	//2周内随访，随访结果
	private String sfjg;
	
	//处理意见
	private String clyj;
	
	//下次随访时间
	private String nextvisitDate;
	
	//随访医生签名
	private String visitDoctor;
	
	//评估医生签名
	private String evaluationDoctor;
	
	//出现停止治疗时间
	private String cxtzzlsj;
	
	//停止治疗原因
	private String stopReason;
	
	//应该随访次数
	private Integer mustVisitNum;
	
	//实际随访次数
	private Integer actualVisitNum;
	
	//应服药次数
	private Integer mustMedicineNum;
	
	//实际服药次数
	private Integer actualMedicineNum;
	
	//服药率
	private String medicineRate;
	
	private String UUID;
}
