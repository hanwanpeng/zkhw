package com.zkhw.api.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Gravida42After extends BaseBo{

	private String id;
	
	//孕妇保健号
	private String mHealthNo;
	
	//健康档案号
	private String archiveid;
	
	//第一次产前随访序号
	private String examinfirid;
	
	//随访日期
	private String visitdate;
	
	//分娩日期
	private String LABOURDATE;
	
	//一般健康情况
	private String body;
	
	//一般心理情况
	private String psychology;
	
	//收缩压（mmHg）
	private Integer bloodpressure;
	
	//孕次
	private Integer pregtimes;
	
	//乳房
	private String breast;
	
	//恶露
	private String lochia;
	
	//子宫
	private String uterus;
	
	//伤口
	private String vulnus;
	
	//其他
	private String others;
	
	//分类
	private String types;
	
	//指导
	private String guide;
	
	//转诊原因
	private String transReason;
	
	//转诊科室
	private String transHos;
	
	//下次随访日期
	private String nextvisitdate;
	
	//随访医生签名
	private String visitdoc;

	//其它指导
	private String guideother;
	
	//乳房异常
	private String breastbug;
	
	//恶露异常
	private String lochiabug;
	
	//分类异常
	private String typesbug;
	
	//子宫异常
	private String uterusbug;
	
	//伤口异常
	private String vulnusbug;
	
	//舒张压（mmHg）
	private Integer diaspressure;
	
	//转诊记录
	private String referralId;
	
	//出院日期
	private String Outhorth;
	
	//处理结案|转诊
	private String ifzz;
	
	private String UUID;
}
