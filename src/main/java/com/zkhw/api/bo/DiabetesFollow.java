package com.zkhw.api.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DiabetesFollow extends BaseBo{

	private String id;
	
	private String archiveid;
	
	//随访日期
	private String visitDate;
	
	//随访医生
	private String visitDoc;
	
	//随访方式
	private String visitType;
	
	//症状
	private String symptom;
	
	//其他症状
	private String symptom_other;
	
	//收缩压
	private Integer sbp;
	
	//舒张压
	private Integer dbp;
	
	//本次体重(kg)
	private String weight;
	
	//下次目标体重
	private String nWeight;
	
	//身高(cm)
	private String height;
	
	//本次体质指数
	private String bmi;
	
	//下次目标体质指数
	private String nBmi;
	
	//足背动脉搏动
	private String dorsal;
	
	//减弱
	private String Attenuate;
	
	//消失
	private String Disapppear;
	
	//其它体征
	private String otherSigns;
	
	//日吸烟量（支）
	private Integer smokeAmount;
	
	//目标日吸烟量（支）
	private Integer nSmokeAmount;
	
	//日饮酒量（两）
	private Integer wineAmount;
	
	//目标日饮酒量（两）
	private Integer nWineAmount;
	
	//运动(次/周)
	private Integer sportperWeek;
	
	//运动（分钟/次）
	private Integer sportOnce;
	
	//目标运动(次/周)
	private Integer nSportperWeek;
	
	//目标运动（分钟/次）
	private Integer nSportOnce;
	
	//主食(克/天)
	private String stapleAmount;
	
	//目标主食(克/天)
	private String nStapleAmount;
	
	//心理调整
	private String psychology;
	
	//遵医行为
	private String obeyDoctor;
	
	//空腹血糖(mmol/l )
	private String bsugar_mg;
	
	//糖化血红蛋白(%)
	private String hemoglobin;
	
	//检查日期
	private String checkDate;
	
	//其它检查
	private String otherCheck;
	
	//服药依从性
	private String drugComply;
	
	//有无药物不良反应
	private String hasAdverse;
	
	//不良反应描述
	private String adverseMemo;
	
	//低血糖反应
	private String adverseOfSugar;
	
	//胰岛素名称
	private String insulinName;
	
	//胰岛素用法
	private String insulinUsage;
	
	//转诊机构
	private String zzxx;
	
	//转诊原因
	private String zzyy;
	
	//此次随访分类
	private String visitClass;
	
	//下次随访日期
	private String nextVisitDate;
	
	//评价与建议
	private String advice;	
	
	private String UUID;
}
