package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "businessdata")
@Setter
@Getter
public class IdXml {

	@XmlElement
	public ResponseHeader getHeader() {
		return header;
	}

	@XmlElement
	public IdBody getBody() {
		return body;
	}

	
	  private ResponseHeader header;
	  
	  private IdBody body;
	 
}
