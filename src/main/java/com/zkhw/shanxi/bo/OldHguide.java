package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Setter;

@XmlRootElement(name = "ObjectInstance")
@Setter
public class OldHguide extends ExaminationObject {

	@XmlAttribute(name = "name")
	private String name = "EHR_HGuide_Older";

	@XmlAttribute(name = "id")
	private String id;

	// 健康档案ID
	@XmlElement(name = "Attribute")
	private BaseElement archiveId;

	// 电话
	@XmlElement(name = "Attribute")
	private BaseElement tel;

	// 姓名
	@XmlElement(name = "Attribute")
	private BaseElement fullname;

	// 性别
	@XmlElement(name = "Attribute")
	private BaseElement gender;

	// 出生日期
	@XmlElement(name = "Attribute")
	private BaseElement birthday;

	// 体质辨识结果/证型
	@XmlElement(name = "Attribute")
	private BaseElement diagnose;

	// 体质辨识结果/证型描述
	@XmlElement(name = "Attribute")
	private BaseElement diagnoseDesc;

	// 指导日期
	@XmlElement(name = "Attribute")
	private BaseElement eduDate;

	// 指导医生
	@XmlElement(name = "Attribute")
	private BaseElement eduDoctor;

	// 情志调摄
	@XmlElement(name = "Attribute")
	private BaseElement feel;

	// 饮食调养
	@XmlElement(name = "Attribute")
	private BaseElement eat;

	// 起居调摄
	@XmlElement(name = "Attribute")
	private BaseElement qjts;

	// 运动保健
	@XmlElement(name = "Attribute")
	private BaseElement sport;

	// 穴位保健
	@XmlElement(name = "Attribute")
	private BaseElement acupoint;

	// 经络保健
	@XmlElement(name = "Attribute")
	private BaseElement channels;

	// 注意事项
	@XmlElement(name = "Attribute")
	private BaseElement care;

	// 其他指导
	@XmlElement(name = "Attribute")
	private BaseElement orher;

	// 数据来源
	@XmlElement(name = "Attribute")
	private BaseElement DataSrc;

	// 数据来源说明
	@XmlElement(name = "Attribute")
	private BaseElement DataMonment;

	// 录入机构
	@XmlElement(name = "Attribute")
	private BaseElement duns;
	

}
