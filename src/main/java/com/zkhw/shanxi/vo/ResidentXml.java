package com.zkhw.shanxi.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.zkhw.shanxi.bo.ResponseHeader;

import lombok.Setter;

@XmlRootElement(name="businessdata")
@Setter
public class ResidentXml {

	private ResponseHeader header;

	private ResidentObject body;
	
	
	@XmlElement
	public ResponseHeader getHeader() {
		return header;
	}

	@XmlElement
	public ResidentObject getBody() {
		return body;
	}

	

}
