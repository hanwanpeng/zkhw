package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Setter;

@XmlRootElement(name = "ObjectInstance")
@Setter
public class Diabetes extends ExaminationObject {

	@XmlAttribute(name = "name")
	private String name = "EHR_Dis_Dmvisit";

	@XmlAttribute(name = "id")
	private String id;

	// 档案id
	@XmlElement(name = "Attribute")
	private BaseElement archiveid;

	// 本次随访日期
	@XmlElement(name = "Attribute")
	private BaseElement visitDate;

	// 随访医生
	@XmlElement(name = "Attribute")
	private BaseElement visitDoctor;

	// 此次随访方式SX0160
	@XmlElement(name = "Attribute")
	private BaseElement visitType;

	// 症状SX0054
	@XmlElement(name = "Attribute")
	private BaseElement symptom;

	// 其他症状
	@XmlElement(name = "Attribute")
	private BaseElement symptom_other;

	// 收缩压
	@XmlElement(name = "Attribute")
	private BaseElement sbp;

	// 舒张压
	@XmlElement(name = "Attribute")
	private BaseElement dbp;

	// 本次体重
	@XmlElement(name = "Attribute")
	private BaseElement weight;

	// 下次目标体重
	@XmlElement(name = "Attribute")
	private BaseElement nWeight;

	// 身高
	@XmlElement(name = "Attribute")
	private BaseElement height;

	// 本次体质指数
	@XmlElement(name = "Attribute")
	private BaseElement bmi;

	// 下次目标体质指数
	@XmlElement(name = "Attribute")
	private BaseElement nBmi;

	// 足背动脉搏动SX0399
	@XmlElement(name = "Attribute")
	private BaseElement dorsal;

	// 其他体征
	@XmlElement(name = "Attribute")
	private BaseElement otherSigns;

	// 日吸烟量
	@XmlElement(name = "Attribute")
	private BaseElement smokeAmount;

	// 目标日吸烟量(支)
	@XmlElement(name = "Attribute")
	private BaseElement nSmokeAmount;

	// 日饮酒量
	@XmlElement(name = "Attribute")
	private BaseElement wineAmount;

	// 目标日饮酒量
	@XmlElement(name = "Attribute")
	private BaseElement nWineAmount;

	// 运动(次/周)
	@XmlElement(name = "Attribute")
	private BaseElement sportOfWeek;

	// 运动（分钟/次）
	@XmlElement(name = "Attribute")
	private BaseElement sportOfOnce;

	// 目标运动（次/周）
	@XmlElement(name = "Attribute")
	private BaseElement nSportOfWeek;

	// 目标运动（分钟/次）
	@XmlElement(name = "Attribute")
	private BaseElement nSportOfOnce;

	// 主食（克/天）
	@XmlElement(name = "Attribute")
	private BaseElement stapleAmount;

	// 目标主食（克/天）
	@XmlElement(name = "Attribute")
	private BaseElement nStapleAmount;

	// 心里调整
	@XmlElement(name = "Attribute")
	private BaseElement psychology;

	// 遵医行为
	@XmlElement(name = "Attribute")
	private BaseElement obeyDoctor;

	// 空腹血糖值
	@XmlElement(name = "Attribute")
	private BaseElement bsugar_mg;

	// 糖化血红蛋白
	@XmlElement(name = "Attribute")
	private BaseElement hemoglobin;

	// 糖化血红蛋白检查日期
	@XmlElement(name = "Attribute")
	private BaseElement checkDate;

	// 其他检查
	@XmlElement(name = "Attribute")
	private BaseElement otherCheck;

	// 服药依从性
	@XmlElement(name = "Attribute")
	private BaseElement drugComply;

	// 药物不良反应
	@XmlElement(name = "Attribute")
	private BaseElement hasAdverse;

	// 不良反应描述
	@XmlElement(name = "Attribute")
	private BaseElement adverseMemo;

	// 低血糖反应
	@XmlElement(name = "Attribute")
	private BaseElement adverseOfSugar;

	// 此次随访分类
	@XmlElement(name = "Attribute")
	private BaseElement visitClass;

	// 转诊记录Id
	@XmlElement(name = "Attribute")
	private BaseElement referralld;

	// 下次随访日期
	@XmlElement(name = "Attribute")
	private BaseElement nextVisitDate;

	// 评价与建议
	@XmlElement(name = "Attribute")
	private BaseElement advice;

	// 机构码
	@XmlElement(name = "Attribute")
	private BaseElement duns;

	// 减弱SX0398
	@XmlElement(name = "Attribute")
	private BaseElement attenuate;

	// 消失SX0398
	@XmlElement(name = "Attribute")
	private BaseElement disapppear;

	// 转诊原因
	@XmlElement(name = "Attribute")
	private BaseElement reason;

	// 转诊机构及科别
	@XmlElement(name = "Attribute")
	private BaseElement kb;

}
