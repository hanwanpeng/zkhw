package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Setter;

@XmlRootElement(name="error")
@Setter
public class ResponseError {
	
	private String typeId;
		
	private String instanceId;
		
	private String errorDesc;

	@XmlElement
	public String getTypeId() {
		return typeId;
	}

	@XmlElement
	public String getInstanceId() {
		return instanceId;
	}

	@XmlElement
	public String getErrorDesc() {
		return errorDesc;
	}	
}
