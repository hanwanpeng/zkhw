package com.zkhw.api.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GravidaFirst extends BaseBo{

	private String id;
	
	//证件号码
	private String cardNo;
	
	//孕妇保健号
	private String mHealthNo;
	
	//证件类型
	private String cardType;
	
	//健康档案号
	private String archiveid;
	
	//孕产妇联系电话
	private String mTel;
	
	//孕产妇健康卡号
	private String mHealthCardNo;
	
	//填表日期
	private String visitdate;
	
	//孕妇姓名
	private String fullname;
	
	//出生日期
	private String birthday;
	
	//填表孕周
	private Integer week;
	
	//孕妇年龄
	private Integer age;
	
	//丈夫姓名
	private String hasname;
	
	//丈夫健康卡号
	private String fHealthCardNo;
	
	//丈夫证件类型
	private String fCardType;
	
	//丈夫证件号码
	private String fCardNo;
	
	//丈夫年龄
	private Integer hasage;
	
	//丈夫电话
	private String hasphone;
	
	//现住址行政区划代码
	private String curAddrCode;
	
	//现住址详细地址
	private String curAddr;
	
	//户籍地址详细地址
	private String regionAddr;
	
	//户籍地址行政区划代码
	private String regionAddrCode;
	
	//孕次
	private Integer pregtimes;
	
	//阴道分娩产
	private Integer birthtimes1;
	
	//剖宫产
	private Integer birthtimes2;
	
	//末次月经时间
	private String lmpdate;
	
	//预产期
	private String willbirthdate;
	
	//既往史
	private String passhistory;
	
	//家族史
	private String familyhistory;
	
	//个人史
	private String sefthistory;
	
	//妇科手术史
	private String gynecolooperation;
	
	//人工流产（次）
	private Integer abortion;
	
	//自然流产(次)
	private Integer bortion;
	
	//死胎（个）
	private Integer stillborn;
	
	//死产（次）
	private Integer stillborth;
	
	//新生儿死亡
	private Integer babydiea;
	
	//出生缺陷儿
	private Integer babydefect;
	
	//身高（cm）
	private String height;
	
	//体重（kg）
	private String weight;
	
	//体质指数
	private String bmi;
	
	//收缩压（mmHg）
	private Integer bloodpressure;
	
	//结案状态
	private String closeStatus;
	
	//心脏
	private String heart;
	
	//结案时间
	private String closeDate;
	
	//肺部
	private String blellows;
	
	//外阴
	private String vulva;
	
	//阴道
	private String vagina;
	
	//结案摘要
	private String closeSummary;
	
	//宫颈
	private String neckofuterus;
	
	//子宫
	private String uterus;
	
	//其它个人史
	private String sefthistoryother;
	
	//附件
	private String appendix;
	
	//血红蛋白值（g/L）
	private String HB;
	
	//白细胞计数值（/L）
	private String WBC;
	
	//血小板计数值（/L）
	private String PLT;
	
	//血常规其他
	private String bloodothers;
	
	//尿蛋白（g/L）
	private String LEU;
	
	//其它家族史
	private String familyhistoryother;
	
	//尿糖（mg/dl）
	private String GLUU;
	
	//其它阴道分泌物
	private String vaginalFluidother;
	
	//尿酮体
	private String NIT;
	
	//尿潜血
	private String BLU;
	
	//其它保健指导
	private String guideother;
	
	//尿常规其他
	private String urineothers;
	
	//血型
	private String bloodtype;
	
	//其它既往史
	private String passhistoryother;
	
	//转诊记录
	private String referralId;
	
	//妇科手术史名称
	private String ladyoperahis;
	
	//舒张压（mmHg）
	private Integer diaspressure;
	
	//rh阴性
	private String bloodrh;
	
	//心脏异常
	private String heartbug;
	
	//转诊原因
	private String transReason;
	
	//外阴异常
	private String vulvabug;
	
	//肺部异常
	private String blellowsbug;
	
	//血糖（mmol/L）
	private String bloodsugar;
	
	//阴道异常
	private String vaginabug;
	
	//血清谷丙转氨酶（U/L）
	private String GPT;
	
	//血清谷草转氨酶（U/L）
	private String AST;
	
	//宫颈异常
	private String neckofuterusbug;
	
	//白蛋白（g/L）
	private String ALB;
	
	//子宫异常
	private String uterusbug;
	
	//附件异常
	private String appendixbug;
	
	//总胆红素（μmol/L）
	private String TBILI;
	
	//结合胆红素（μmol/L）
	private String IBILI;
	
	//转诊机构
	private String transHos;
	
	//血清肌酐（μmol/L）
	private String serumCreatin;
	
	//血尿素氮（mmol/L）
	private String bloodUrea;
	
	//阴道分泌物
	private String vaginalFluid;
	
	//阴道清洁度
	private String vaginaClean;
	
	//乙型肝炎表面抗原
	private String HBSAG;
	
	//总体评估异常
	private String evaluatebug;
	
	//乙型肝炎表面抗体
	private String HBSAB;
	
	//乙型肝炎e抗原
	private String HBEAG;
	
	//乙型肝炎e抗体
	private String HBEAB;
	
	//乙型肝炎核心抗体
	private String HBCAB;
	
	//梅毒血清学实验
	private String syphilis;
	
	//HIV抗体检
	private String HIV;
	
	//B超
	private String B;
	
	private String other;
	
	//总体评估
	private String evaluate;
	
	//保健指导
	private String guide;
	
	//下次随访日期
	private String nextVisitDate;
	
	//随访医生签名
	private String visitDoc;
	
	//管理状态
	private String managed;
	
	//备注
	private String Memo;
	
	private String UUID;
}
