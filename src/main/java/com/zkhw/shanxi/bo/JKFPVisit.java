package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Setter;

@XmlRootElement(name = "ObjectInstance")
@Setter
public class JKFPVisit extends ExaminationObject {

	@XmlAttribute(name = "name")
	private String name = "FP_Visit";

	@XmlAttribute(name = "id")
	private String id;

	// 档案ID
	@XmlElement(name = "Attribute")
	private BaseElement archiveid;

	// 身份证号
	@XmlElement(name = "Attribute")
	private BaseElement identityNo;

	//姓名
	@XmlElement(name = "Attribute")
	private BaseElement fullname;

	//性别
	@XmlElement(name = "Attribute")
	private BaseElement gender;

	//出生日期
	@XmlElement(name = "Attribute")
	private BaseElement birthday;

	//本次随访日期
	@XmlElement(name = "Attribute")
	private BaseElement visitDate;

	//此次随访方式
	@XmlElement(name = "Attribute")
	private BaseElement visitType;

	//随访医生
	@XmlElement(name = "Attribute")
	private BaseElement visitDoc;

	//工作内容
	@XmlElement(name = "Attribute")
	private BaseElement gznr;

	//评价与建议
	@XmlElement(name = "Attribute")
	private BaseElement advice;

	//机构码
	@XmlElement(name = "Attribute")
	private BaseElement duns;

	

}
