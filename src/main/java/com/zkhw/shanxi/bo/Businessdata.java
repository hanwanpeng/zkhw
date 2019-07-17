package com.zkhw.shanxi.bo;

import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import lombok.Setter;

@XmlRootElement(name="businessdata")
@XmlSeeAlso(ExaminationObject.class)
@Setter
public class Businessdata {

	@XmlElement
	private Header header;
	
	@XmlAnyElement(lax = true)
	//@XmlElement	
	@XmlElementWrapper(name="body")
	private List<Object> body;
	
	
}
