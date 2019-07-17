package com.zkhw.shanxi.vo;

import javax.xml.bind.annotation.XmlElement;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ResidentObject {
	
	
	private ResidentBody objectInstance;
	
	@XmlElement
	public ResidentBody getObjectInstance() {
		return objectInstance;
	}

	

	

}
