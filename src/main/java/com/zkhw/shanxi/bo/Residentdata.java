package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import lombok.Setter;

@XmlRootElement(name="businessdata")
@XmlSeeAlso(ExaminationObject.class)
@Setter
public class Residentdata {

	@XmlElement
	private Header header;
	
	//@XmlAnyElement(lax = true)
	@XmlElement	
	//@XmlElementWrapper(name="body")
	private ResidentQuery body;
	
	
}
