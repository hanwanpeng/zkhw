package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Setter;

@XmlRootElement(name = "ObjectInstance")
@Setter
public class Hypertension extends ExaminationObject {

	@XmlAttribute(name = "name")
	private String name = "EHR_Dis_Hypertensionvisit";

	@XmlAttribute(name = "id")
	private String id;

	// 档案id
	@XmlElement(name = "Attribute")
	private BaseElement archiveid;

	// 本次随访日期
	@XmlElement(name = "Attribute")
	private BaseElement visitDate;

	// 此次随访方式SX0160
	@XmlElement(name = "Attribute")
	private BaseElement visitType;

	// 随访医生
	@XmlElement(name = "Attribute")
	private BaseElement visitDoc;

	// 症状SX0054
	@XmlElement(name = "Attribute")
	private BaseElement symptom;

	// 其他症状
	@XmlElement(name = "Attribute")
	private BaseElement symptomother;

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

	// 心率
	@XmlElement(name = "Attribute")
	private BaseElement heartRate;

	// 其他体征
	@XmlElement(name = "Attribute")
	private BaseElement otherSigns;

	// 日吸烟量
	@XmlElement(name = "Attribute")
	private BaseElement smokeAmount;

	// 目标日吸烟量
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
	private BaseElement sportperWeek;

	// 此次对方分类
	@XmlElement(name = "Attribute")
	private BaseElement visitClass;

	// 运动（分钟/次）
	@XmlElement(name = "Attribute")
	private BaseElement sportOnce;

	// 目标运动（次/周）
	@XmlElement(name = "Attribute")
	private BaseElement nSportperWeek;

	// 目标运动（分钟/次）
	@XmlElement(name = "Attribute")
	private BaseElement nSportOnce;

	// 摄盐情况（咸淡）
	@XmlElement(name = "Attribute")
	private BaseElement saltIntake;

	// 目标摄盐情况（咸淡）
	@XmlElement(name = "Attribute")
	private BaseElement nSaltIntake;

	// 心里调整
	@XmlElement(name = "Attribute")
	private BaseElement psychology;

	// 遵医行为
	@XmlElement(name = "Attribute")
	private BaseElement obeyDoc;

	// 辅助检查
	@XmlElement(name = "Attribute")
	private BaseElement assistantCheck;

	// 服药依从性
	@XmlElement(name = "Attribute")
	private BaseElement drugCompliance;

	// 药物不良反应
	@XmlElement(name = "Attribute")
	private BaseElement Adverseeffect;

	// 药物不良反应
	@XmlElement(name = "Attribute")
	private BaseElement adverseMemo;

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

	// 转诊机构及科别
	@XmlElement(name = "Attribute")
	private BaseElement kb;

	// 转诊原因
	@XmlElement(name = "Attribute")
	private BaseElement reason;

}
