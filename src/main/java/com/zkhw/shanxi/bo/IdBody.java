package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlElement;

import lombok.Setter;
//@XmlRootElement(name = "body")
@Setter
public class IdBody {
	
	
	private String typeName;
	
	private String instanceId;

	
	@XmlElement
	public String getTypeName() {
		return typeName;
	}
	
	@XmlElement
	public String getInstanceId() {
		return instanceId;
	}
		
}
