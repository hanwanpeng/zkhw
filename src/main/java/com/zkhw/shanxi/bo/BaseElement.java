package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

import lombok.Setter;

@Setter
public class BaseElement {

	
	private String name;
	
	
	private String value;

	@XmlAttribute(name="name")
	public String getName() {
		return name;
	}

	@XmlValue
	public String getValue() {
		return value;
	}	
}
