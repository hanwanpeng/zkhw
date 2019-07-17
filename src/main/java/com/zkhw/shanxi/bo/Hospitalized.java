package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Setter;

@XmlRootElement(name = "ObjectInstance")
@Setter
public class Hospitalized extends ExaminationObject{

	@XmlAttribute(name = "name")
	private String name = "EHR_Arch_Inprecord";
	
	@XmlAttribute(name = "id")
	private String inprecordId;
	
	@XmlElement(name = "Attribute")
	private BaseElement archiveId;
	
	//服务项目
	@XmlElement(name = "Attribute")
	private BaseElement serviceName;
	
	//业务表ID
	@XmlElement(name = "Attribute")
	private BaseElement serviceId;
	
	//入院日期
	@XmlElement(name = "Attribute")
	private BaseElement inDate;
	
	//出院日期
	@XmlElement(name = "Attribute")
	private BaseElement outDate;
	
	//住院原因
	@XmlElement(name = "Attribute")
	private BaseElement reason;
	
	//医院名称
	@XmlElement(name = "Attribute")
	private BaseElement hospitalName;
	
	//病案号
	@XmlElement(name = "Attribute")
	private BaseElement inpNo;
	
	//备注
	@XmlElement(name = "Attribute")
	private BaseElement remark;
	
	//机构码
	@XmlElement(name = "Attribute")
	private BaseElement duns;
	
}
