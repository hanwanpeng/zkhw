package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Setter;

@XmlRootElement(name = "ObjectInstance")
@Setter
public class Elderly extends ExaminationObject {

	@XmlAttribute(name = "name")
	private String name = "EHR_Arch_OldHerb";

	@XmlAttribute(name = "id")
	private String id;

	// 健康档案ID
	@XmlElement(name = "Attribute")
	private BaseElement archiveid;

	// 身份证号
	@XmlElement(name = "Attribute")
	private BaseElement identityno;

	// 业务表id
	@XmlElement(name = "Attribute")
	private BaseElement serviceid;

	// 服务项目
	@XmlElement(name = "Attribute")
	private BaseElement servicename;

	// 姓名
	@XmlElement(name = "Attribute")
	private BaseElement fullname;

	// 是否精力充沛
	@XmlElement(name = "Attribute")
	private BaseElement isEnergeti;

	// 是否容易疲劳
	@XmlElement(name = "Attribute")
	private BaseElement isTired;

	// 是否容易气短
	@XmlElement(name = "Attribute")
	private BaseElement isLoseHeart;

	// 是否声音低弱无力
	@XmlElement(name = "Attribute")
	private BaseElement isDeepVoice;

	// 是否情绪低沉
	@XmlElement(name = "Attribute")
	private BaseElement isListless;

	// 是否精神紧张
	@XmlElement(name = "Attribute")
	private BaseElement isJitter;

	// 是否孤独
	@XmlElement(name = "Attribute")
	private BaseElement isAlone;

	// 是否害怕
	@XmlElement(name = "Attribute")
	private BaseElement isScare;

	// 是否身体沉重
	@XmlElement(name = "Attribute")
	private BaseElement isHeavy;

	// 是否眼睛干涩
	@XmlElement(name = "Attribute")
	private BaseElement isEyeDry;

	// 是否手脚冰凉
	@XmlElement(name = "Attribute")
	private BaseElement isExtreCold;

	// 是否腰膝怕冷
	@XmlElement(name = "Attribute")
	private BaseElement isAfaidCold;

	// 是否不能耐受寒冷
	@XmlElement(name = "Attribute")
	private BaseElement isResistCold;

	// 是否容易感冒
	@XmlElement(name = "Attribute")
	private BaseElement isCatchCold;

	// 是否容易流鼻涕
	@XmlElement(name = "Attribute")
	private BaseElement isSnorty;

	// 是否睡眠打鼾
	@XmlElement(name = "Attribute")
	private BaseElement isStertorous;

	// 是否容易过敏
	@XmlElement(name = "Attribute")
	private BaseElement isAllergic;

	// 是否容易起麻疹
	@XmlElement(name = "Attribute")
	private BaseElement isHives;

	// 是否皮下出血
	@XmlElement(name = "Attribute")
	private BaseElement isEndermicBlood;

	// 是否容易出现抓痕
	@XmlElement(name = "Attribute")
	private BaseElement isScore;

	// 是否容易嘴唇干裂
	@XmlElement(name = "Attribute")
	private BaseElement isFeverDry;

	// 是否肢体疼痛
	@XmlElement(name = "Attribute")
	private BaseElement isBodyPain;

	// 是否面部发亮
	@XmlElement(name = "Attribute")
	private BaseElement isFaceLight;

	// 是否面色晦暗
	@XmlElement(name = "Attribute")
	private BaseElement isFleck;

	// 是否湿疹
	@XmlElement(name = "Attribute")
	private BaseElement isTetter;

	// 是否总想喝水
	@XmlElement(name = "Attribute")
	private BaseElement isLikeDrink;

	// 是否口苦
	@XmlElement(name = "Attribute")
	private BaseElement ismouthBitter;

	// 是否腹部肥
	@XmlElement(name = "Attribute")
	private BaseElement ifFat;

	// 是否害怕凉食
	@XmlElement(name = "Attribute")
	private BaseElement isScareColdFood;

	// 是否答辩粘滞
	@XmlElement(name = "Attribute")
	private BaseElement isStoolStick;

	// 是否大便干燥
	@XmlElement(name = "Attribute")
	private BaseElement isStoolDry;

	// 是否舌苔厚重
	@XmlElement(name = "Attribute")
	private BaseElement isLinguaMassin;

	// 是否静脉淤紫
	@XmlElement(name = "Attribute")
	private BaseElement isLinguaVein;

	@XmlElement(name = "Attribute")
	private BaseElement physique_phz; // 平和质 SX0088

	@XmlElement(name = "Attribute")
	private BaseElement physique_qxz; // 气虚质 SX0088

	@XmlElement(name = "Attribute")
	private BaseElement physique_yangxz; // 阳虚质 SX0088

	@XmlElement(name = "Attribute")
	private BaseElement physique_yinxz; // 阴虚质 SX0088

	@XmlElement(name = "Attribute")
	private BaseElement physique_tsz; // 痰湿质 SX0088

	@XmlElement(name = "Attribute")
	private BaseElement physique_srz; // 湿热质 SX0088

	@XmlElement(name = "Attribute")
	private BaseElement physique_xyz; // 血瘀质 SX0088

	@XmlElement(name = "Attribute")
	private BaseElement physique_qyz; // 气郁质 SX0088

	@XmlElement(name = "Attribute")
	private BaseElement physique_tbz; // 特秉质 SX0088

	// 填表日期
	@XmlElement(name = "Attribute")
	private BaseElement reportDate;

	// 医生签字
	@XmlElement(name = "Attribute")
	private BaseElement reportDoc;

	// 机构码
	@XmlElement(name = "Attribute")
	private BaseElement duns;

	// 气虚质得分
	@XmlElement(name = "Attribute")
	private BaseElement qxz_Score;

	// 阳虚质得分
	@XmlElement(name = "Attribute")
	private BaseElement yangxz_Score;

	// 阴虚质得分
	@XmlElement(name = "Attribute")
	private BaseElement yinxz_Score;

	// 痰湿质得分
	@XmlElement(name = "Attribute")
	private BaseElement tsz_Score;

	// 湿热质得分
	@XmlElement(name = "Attribute")
	private BaseElement srz_Score;

	// 血瘀质得分
	@XmlElement(name = "Attribute")
	private BaseElement xyz_Score;

	// 气郁质得分
	@XmlElement(name = "Attribute")
	private BaseElement qyz_Score;

	// 特秉质得分
	@XmlElement(name = "Attribute")
	private BaseElement tbz_Score;

	// 平和质得分
	@XmlElement(name = "Attribute")
	private BaseElement phz_Score;

	@XmlElement(name = "Attribute")
	private BaseElement qxz_guide; // 气虚质指导

	@XmlElement(name = "Attribute")
	private BaseElement yangxz_guide; // 阳虚质指导

	@XmlElement(name = "Attribute")
	private BaseElement yinxz_guide; // 阴虚质指导

	@XmlElement(name = "Attribute")
	private BaseElement tsz_guide; // 痰湿质指导

	@XmlElement(name = "Attribute")
	private BaseElement srz_guide; // 湿热质指导

	@XmlElement(name = "Attribute")
	private BaseElement xyz_guide; // 血瘀质指导

	@XmlElement(name = "Attribute")
	private BaseElement qyz_guide; // 气郁质指导

	@XmlElement(name = "Attribute")
	private BaseElement tbz_guide; // 特秉质指导

	@XmlElement(name = "Attribute")
	private BaseElement phz_guide; // 平和质指导

	@XmlElement(name = "Attribute")
	private BaseElement qxz_guide_other; // 气虚质其他指导

	@XmlElement(name = "Attribute")
	private BaseElement yangxz_guide_other; // 阳虚质其他指导

	@XmlElement(name = "Attribute")
	private BaseElement yinxz_guide_other; // 阴虚质其他指导

	@XmlElement(name = "Attribute")
	private BaseElement tsz_guide_other; // 痰湿质其他指导

	@XmlElement(name = "Attribute")
	private BaseElement srz_guide_other; // 湿热质其他指导

	@XmlElement(name = "Attribute")
	private BaseElement xyz_guide_other; // 血瘀质其他指导

	@XmlElement(name = "Attribute")
	private BaseElement qyz_guide_other; // 气郁质其他指导

	@XmlElement(name = "Attribute")
	private BaseElement tbz_guide_other; // 特秉质其他指导

	@XmlElement(name = "Attribute")
	private BaseElement phz_guide_other; // 平和质其他指导

}
