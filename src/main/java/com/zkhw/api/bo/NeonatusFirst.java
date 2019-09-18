package com.zkhw.api.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NeonatusFirst extends BaseBo{

	private String id;
	
	//儿童保健号
	private String healthNo;
	
	private String archiveid;
	
	//家庭住址
	private String address;
	
	//新生儿听力筛查
	private String hearingOfNewborn;
	
	//新生儿疾病筛查
	private String diseaseOfNewborn;
	
	//其他遗传代谢病
	private String diseaseOfNewborn1;
	
	//新生儿体重(kg)
	private String wightOfNewborn;
	
	//目前体重(kg)
	private String wight;
	
	//出生身长(cm)
	private String heightOfNewborn;
	
	//喂养方式
	private String feedWay;
	
	//吃奶量(ml/次)
	private Integer suckMeasure;
	
	//吃奶次数(次/日）
	private Integer suckTimes;
	
	//呕吐
	private String Vomit;
	
	//大便
	private String defecate;
	
	//大便次数（次/日）
	private Integer defecateTimes;
	
	//大便其他项
	private String defecate_other;
	
	//体温℃
	private String temperature;
	
	//脉率（次/分钟）
	private Integer pulseRate;
	
	//呼吸频率（次/分钟）
	private Integer breatheRate;
	
	//面色
	private String face;
	
	//面色其他
	private String face1;
	
	//黄疸部位
	private String jaundice;
	
	//前囟（cm*cm）
	private String bregma1;
	
	//前囟
	private String bregma;
	
	//前囟其他
	private String bregma2;
	
	//眼外观
	private String eyeAppearance;
	
	//眼外观异常
	private String eyeAppearance1;
	
	//四肢活动度
	private String limbsMobility;
	
	//四肢活动度异常
	private String limbsMobility1;
	
	//耳外观
	private String hearAppearance;
	
	//耳外观其他
	private String hearAppearance1;
	
	//颈部包块
	private String cervicalMasses;
	
	//颈部包块情况
	private String cervicalMasses1;
	
	//鼻子
	private String nose;
	
	//鼻子异常
	private String nose1;
	
	//皮肤
	private String skin;
	
	//皮肤异常
	private String skin1;
	
	//口腔
	private String mouth;
	
	//口腔异常
	private String mouth1;
	
	//肛门
	private String anus;
	
	//肛门异常
	private String anus1;
	
	//心肺听诊
	private String heart_lung;
	
	//心肺听诊异常
	private String heart_lung1;
	
	//外生殖器
	private String pudendum;
	
	//外生殖器异常
	private String pudendum1;
	
	//腹部触诊
	private String abdominalBallotte;
	
	//腹部触诊异常
	private String abdominalBallotte1;
	
	//脊柱
	private String spine;
	
	//脊柱异常
	private String spine1;
	
	//脐带
	private String funicle;
	
	//脐带其他
	private String funicle1;
	
	//胸部
	private String Breastexam;
	
	//胸部异常
	private String breastexam1;
	
	//其他指导
	private String guide_other;
	
	//转诊建议
	private String TransferConSug;
	
	//原因
	private String Reason;
	
	//机构及科室
	private String hospital;
	
	//指导
	private String guide;
	
	//本次访视日期
	private String currentVisitDate;
	
	//下次随访地点
	private String nextVisitAddress;
	
	//下次随访日期
	private String nextVisitDate;
	
	//随访医生签名
	private String visitDoctorName;
	
	//转诊记录
	private String referralId;
	
	private String UUID;
}
