package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlElement;

import lombok.Setter;

@Setter
public class Header {

	@XmlElement
	private String functioncode;
	
	@XmlElement
	private String errCode;
	
	@XmlElement
	private String errMsg;
	
	@XmlElement
	private String cmd;
}
