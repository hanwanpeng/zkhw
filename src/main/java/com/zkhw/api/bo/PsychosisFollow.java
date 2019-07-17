package com.zkhw.api.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PsychosisFollow extends BaseBo{

	private String id;
	
	//登记表id
	private String schizId;
	
	private String archiveid;
	
	private String visitDate;
	
	private String visitDoctor;
	
	private String VISITTYPED;
	
	//危险性
	private String dangerLevel;
	
	//目前症状
	private String symptom;
	
	//其它症状
	private String otherSymptom;
	
	//自知力
	private String insight;
	
	//睡眠情况
	private String sleeping;
	
	//饮食情况
	private String diet;
	
	//个人生活料理
	private String living;
	
	//家务劳动
	private String housework;
	
	//生产劳动及工作
	private String labor;
	
	//学习能力
	private String study;
	
	//社会人际交往
	private String communion;
	
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
	
	//自杀未遂(次)
	private Integer attemptedSuicide;
	
	//关锁情况
	private String lockstatus;
	
	//住院情况
	private String inpMemo;
	
	//末次出院时间
	private String latestOutDate;
	
	//实验室检查
	private String examination;
	
	//服药依从性
	private String drugComply;
	
	//药物不良反应
	private String hasAdverse;
	
	//药物不良反应说明
	private String adverseMemo;
	
	//治疗效果
	private String treatment;
	
	//康复措施
	private String recoverPlan;
	
	//其他康复措施
	private String recoverPlan_other;
	
	//本次随访分类
	private String visitType;
	
	//下次随访日期
	private String nextVisitDate;
	
	//其它危害行为(次)
	private Integer behavior;
	
	//危险行为
	private Integer Nobehavior;
	
	//是否转诊
	private String Ifzz;
	
	//转诊至机构及科室
	private String Zzxx;
	
	//转诊原因
	private String Zzyy;
	
	//若失访，原因
	private String Reafailure;
	
	//其它失访原因
	private String Scmptomother;
	
	//若死亡，原因
	private String Deathcause;
	
	//躯体疾病
	private String Bodyhealth;
	
	//其他死亡原因
	private String Dealmptomother;
	
	//死亡日期
	private String deathDate;
	
	private String UUID;
}
