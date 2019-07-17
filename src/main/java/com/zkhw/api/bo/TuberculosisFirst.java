package com.zkhw.api.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TuberculosisFirst extends BaseBo{

	private String id;
	
	private String archiveid;
	
	private String visitDate;
	
	//随访方式
	private String visitstyle;
	
	//患者类型
	private String patientType;
	
	//痰菌情况
	private String tjqk;
	
	//耐药情况
	private String nyqk;
	
	//症状及体征
	private String sysmpsigns;
	
	//其他
	private String qtsysmpsigns;
	
	//化疗方案
	private String hlscheme;
	
	//用法
	private String usage;
	
	//药品剂型
	private String ypjx;
	
	//监督人员选择
	private String supervisor;
	
	//单独的居室
	private String singlehome;
	
	//通风情况
	private String ventilate;
	
	//吸烟
	private String smoke;
	
	//目标吸烟量
	private String smoke_target;
	
	//喝酒
	private String drink;
	
	//目标饮酒量
	private String drink_target;
	
	//取药地点
	private String getMedicineAddr;
	
	//取药时间
	private String getMedicineDate;
	
	//服务记录卡的填写
	private String fwjlk;
	
	//药物方法及药品存放
	private String ywffjypcf;
	
	//肺结核治疗疗程
	private String fjhzllc;
	
	//不规律服药危害
	private String bglfwwh;
	
	//服药后不良反应及处理
	private String fyhblfyjcl;
	
	//治疗期间复诊查痰
	private String zlqjfzct;
	
	//外出期间如何坚持服药
	private String wcqjrhjcfy;
	
	//生活习惯及注意事项
	private String shxgjzysx;
	
	//密切接触者检查
	private String mqjczjc;
	
	//下次随访时间
	private String nextvisitDate;
	
	//评估医生签名
	private String evaluationDoctor;
	
	//应访视次数
	private Integer yfscs;
	
	//实际访视次数
	private Integer sjfscs;
	
	//应服药次数
	private Integer yfycs;
	
	//实际服药次数
	private Integer sjfycs;
	
	//服药率
	private String fyl;
	
	//全程管理评估医生签名
	private String evalDoctor;
	
	//结案状态
	private String closeStatus;
	
	//结案时间
	private String closeDate;
	
	private String UUID;
	
}
