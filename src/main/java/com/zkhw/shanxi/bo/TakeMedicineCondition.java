package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Setter;

@XmlRootElement(name = "ObjectInstance")
@Setter
public class TakeMedicineCondition extends ExaminationObject{

	@XmlAttribute(name = "name")
	private String name = "EHR_Arch_Druguse";
	
	@XmlAttribute(name = "id")
	private String id;
	
	@XmlElement(name = "Attribute")
	private BaseElement archiveid;
	
	//SX0069
	@XmlElement(name = "Attribute")
	private BaseElement servicename;
	
	@XmlElement(name = "Attribute")
	private BaseElement serviceid;
	
	//药物分类 CV5301.06
	@XmlElement(name = "Attribute")
	private BaseElement drugtype;
	
	//药物名称
	@XmlElement(name = "Attribute")
	private BaseElement drugname;
	
	//用法
	@XmlElement(name = "Attribute")
	private BaseElement usage;
	
	//频次 SX0153
	@XmlElement(name = "Attribute")
	private BaseElement frequency;
	
	//单次用量
	@XmlElement(name = "Attribute")
	private BaseElement amount;
	
	//单次用量单位 SX0154
	@XmlElement(name = "Attribute")
	private BaseElement unit;
	
	//用药年限
	@XmlElement(name = "Attribute")
	private BaseElement useyears;
	
	//用药年限单位 CV4202.05
	@XmlElement(name = "Attribute")
	private BaseElement useyearsunit;
	
	//服药依从性 SX0028
	@XmlElement(name = "Attribute")
	private BaseElement drugcompliance;
	
	//其它说明
	@XmlElement(name = "Attribute")
	private BaseElement other;
	
	//机构
	@XmlElement(name = "Attribute")
	private BaseElement duns;
}
