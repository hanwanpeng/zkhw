package com.zkhw.api.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChildenFollow  extends BaseBo{

	private String id;
	
	private String archiveid;
	
	//儿童保健号
	private String healthNo;
	
	//月龄
	private Integer moonAge;
	
	//随访日期
	private String followupDate;
	
	//体重（kg）
	private String weight;
	
	//体重评估
	private String weight1;
	
	//身长（cm）
	private String height;
	
	//身长评估
	private String height1;
	
	//身高/体重
	private String Heightorweight;
	
	//体重/身高评估
	private String heightorweightsys;
	
	//体格发育评价
	private String physique;
	
	//头围（cm）
	private String headGirth;
	
	//面色
	private String faceColour;
	
	//皮肤
	private String skin;
	
	//前囟
	private String bregma;
	
	//前囟(cm*cm)
	private String bregma1;
	
	//颈部包块
	private String neckMasses;
	
	//中医药健康管理服务
	private String herbalistService;
	
	//眼外观
	private String eyeLayout;
	
	//耳外观
	private String earLayout;
	
	//听力
	private String hearing;
	
	//视力
	private String vision;
	
	//出牙/
	private Integer tooth;
	
	//龋齿数(颗)
	private Integer caries;
	
	//口腔
	private String cavum;
	
	//心肺
	private String heart_lung;
	
	//腹部
	private String abdCavity;
	
	//脐部
	private String umRegion;
	
	//脐部
	private String umRegions;
	
	//脐部异常
	private String umRegions_other;
	
	//四肢
	private String extremity;
	
	//步态
	private String tread;
	
	//可疑佝偻病症状
	private String shRicketsSymptom;
	
	//可疑佝偻病体征
	private String shRicketsSigns;
	
	//肛门/外生殖
	private String portaHVestibule;
	
	//血红蛋白值(g/L)
	private String hemoglobinValue;
	
	//户外活动(小时/日)
	private String openActivity;
	
	//其他中医药健康服务
	private String herbService_other;
	
	//服用维生素D(IU/日)
	private String edebleVietaminD;
	
	//其他项
	private String physiqu_other;
	
	//发育评估
	private String growthEvaluate;
	
	//发育评估(6岁)
	private String sixdevelop;
	
	//发育评估(5岁)
	private String fivedevelop;
	
	//发育评估(4岁)
	private String fourdevelop;
	
	//发育评估(3岁)
	private String thrdevelop;
	
	//发育评估(30月)
	private String thrtydevelop;
	
	//发育评估(24月)
	private String twdevelop;
	
	//发育评估(18月)
	private String eightdevelop;
	
	//发育评估(12月)
	private String twelvedevelop;
	
	//发育评估(8月)
	private String eigdevelop;
	
	//发育评估(6月)
	private String sixmothdevelop;
	
	//发育评估(3月)
	private String thrmothdevelop;
	
	//两次随访患病情况
	private String twiFollowSickenStu;
	
	//肺炎（次）
	private Integer pulmonary;
	
	//腹泻（次）
	private Integer diarrhea;
	
	//外伤（次）
	private Integer wound;
	
	//其他（次）
	private String sickerothers;
	
	//其他
	private String others;
	
	//转诊记录编号
	private String referralId;
	
	//原因
	private String Reason;
	
	//机构及科室
	private String hospital;
	
	//指导
	private String direct;
	
	//下次随访日期
	private String nextFollowDate;
	
	//肤色异常
	private String skinbug;
	
	//眼外观异常
	private String eyeLayoutbug;
	
	//随访医生签名
	private String followDicName;
	
	//耳外观异常
	private String earLayoutbug;
	
	//口腔异常
	private String cavumbug;
	
	//心肺异常
	private String heart_lungbug;
	
	//腹部异常
	private String abdCavitybug;
	
	//脐部其它
	private String umRegionother;
	
	//四肢异常
	private String extremitybug;
	
	//肛门/外生殖异常
	private String portaHVestibulebug;
	
	private String UUID;
}
