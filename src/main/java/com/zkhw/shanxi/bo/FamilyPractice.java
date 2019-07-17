package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Setter;

@XmlRootElement(name = "ObjectInstance")
@Setter
public class FamilyPractice extends ExaminationObject{

	@XmlAttribute(name = "name")
	private String name = "EHR_Arch_Homebed";
	
	@XmlAttribute(name = "id")
	private String id;
	
	@XmlElement(name = "Attribute")
	private BaseElement archiveid;
	
	//服务项目
	@XmlElement(name = "Attribute")
	private BaseElement servicename;
	
	//业务表ID
	@XmlElement(name = "Attribute")
	private BaseElement serviceid;
	
	//入院日期
	@XmlElement(name = "Attribute")
	private BaseElement indate;
	
	//出院日期
	@XmlElement(name = "Attribute")
	private BaseElement outdate;
	
	//住院原因
	@XmlElement(name = "Attribute")
	private BaseElement reason;
	
	//医院名称
	@XmlElement(name = "Attribute")
	private BaseElement hospitalname;
	
	//病案号
	@XmlElement(name = "Attribute")
	private BaseElement inpno;
	
	//备注
	@XmlElement(name = "Attribute")
	private BaseElement remark;
	
	//机构码
	@XmlElement(name = "Attribute")
	private BaseElement duns;
}
