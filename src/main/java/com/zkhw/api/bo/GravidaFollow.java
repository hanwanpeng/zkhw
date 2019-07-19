package com.zkhw.api.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GravidaFollow extends BaseBo{

	private String id;
	
	private String orderNum;
	//孕妇保健号
	private String mHealthNo;
	
	private String archiveid;
	
	//第一次产前随访序号
	private String examinfirid;
	
	//随访日期
	private String visitdate;
	
	//孕周（周）
	private Integer week;
	
	//主诉
	private String mainsuit;
	
	//体重（kg）s
	private String weight;
	
	//宫低高度（cm）
	private String uterusheight;
	
	//孕次
	private Integer pregtimes;
	
	//腹围（cm）
	private String abdominalGirth;
	
	//胎位
	private String fetusPosition;
	
	//胎心率（次/分钟）
	private String fetalHeartRate;
	
	//收缩压（mmHg）
	private Integer bloodpressure;
	
	//舒张压（mmHg）
	private Integer diaspressure;
	
	//血红蛋白（g/L）
	private String HB;
	
	//尿蛋白（g/L）
	private String LEU;
	
	//其他辅助检查
	private String otherExamin;
	
	//分类
	private String types;
	
	//指导
	private String guide;
	
	//转诊原因
	private String transReason;
	
	//转诊科室
	private String transHos;
	
	//分类异常
	private String typesbug;
	
	//其它指导
	private String guideother;
	
	//下次随访日期
	private String nextvisitdate;
	
	//随访医生签名
	private String visitdoc;
	
	//转诊记录
	private String referralId;
	
	private String UUID;
}
