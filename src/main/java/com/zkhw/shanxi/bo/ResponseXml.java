package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import lombok.Setter;

@XmlRootElement(name="businessdata")
@XmlSeeAlso(ResponseError.class)
@Setter
public class ResponseXml {

	@XmlElement
	public ResponseHeader getHeader() {
		return header;
	}

	@XmlElement
	public ResponseBody getBody() {
		return body;
	}


	private ResponseHeader header;
	
	private ResponseBody body;
}
