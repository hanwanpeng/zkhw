package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Setter;

@XmlRootElement(name = "ObjectInstance")
@Setter
//@Getter
public class ResidentQuery extends ExaminationObject{
	
	@XmlAttribute(name = "name")
	private String name;

	@XmlAttribute(name = "id")
	private String id;
	
	
	@XmlElement(name = "Attribute")
	private BaseElement typeId;
	
	
	@XmlElement(name = "Attribute")
	private BaseElement instanceId;
	
	
	
	
}
