package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlElement;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseHeader {
	
	private String functionCode;
		
	private String errCode;
		
	private String errMsg;

	@XmlElement
	public String getFunctionCode() {
		return functionCode;
	}

	@XmlElement
	public String getErrCode() {
		return errCode;
	}

	@XmlElement
	public String getErrMsg() {
		return errMsg;
	}	
}
