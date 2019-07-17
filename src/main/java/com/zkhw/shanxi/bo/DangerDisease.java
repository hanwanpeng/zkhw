package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Setter;

@XmlRootElement(name = "ObjectInstance")
@Setter
public class DangerDisease extends ExaminationObject {

	@XmlAttribute(name = "name")
	private String name = "EHR_Arch_Danger";

	@XmlAttribute(name = "id")
	private String id;

	//健康档案id
	@XmlElement(name = "Attribute")
	private BaseElement archiveId;

	// 服务项目
	@XmlElement(name = "Attribute")
	private BaseElement serviceName;

	// 业务表Id
	@XmlElement(name = "Attribute")
	private BaseElement serviceId;

	// 毒物种类（SX0013_1粉尘，SX0013_2放射物质，SX0013_3物理因素，SX0013_4化学物质，SX0013_5其他）
	@XmlElement(name = "Attribute")
	private BaseElement poisonType;

	// 毒物描述
	@XmlElement(name = "Attribute")
	private BaseElement poisonContent;

	// 有无防护措施关系（SX0014_0无，SX0014_1有）
	@XmlElement(name = "Attribute")
	private BaseElement hasfense;

	// 防护措施说明
	@XmlElement(name = "Attribute")
	private BaseElement fenseContent;

	// 备注
	@XmlElement(name = "Attribute")
	private BaseElement remark;

	// 机构
	@XmlElement(name = "Attribute")
	private BaseElement duns;

	

}
