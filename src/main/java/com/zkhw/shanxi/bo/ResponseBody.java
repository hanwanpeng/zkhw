package com.zkhw.shanxi.bo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import lombok.Setter;
@Setter
public class ResponseBody {
	
	private String rows_total;
		
	private String rows_suc;
		
	private String rows_faild;
		
	private String memo;
		
	List<ResponseError> error;
	

	@XmlElement
	public String getRows_total() {
		return rows_total;
	}

	@XmlElement
	public String getRows_suc() {
		return rows_suc;
	}

	@XmlElement
	public String getRows_faild() {
		return rows_faild;
	}

	@XmlElement
	public String getMemo() {
		return memo;
	}

	@XmlElementWrapper(name="errDetail")
	public List<ResponseError> getError() {
		return error;
	}
	
		
}
