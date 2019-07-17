package com.zkhw.api.bo;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Result {

	@JSONField(name = "Code")
	private Integer Code;
	
	@JSONField(name = "Message")
	private String Message;
	
	@JSONField(name = "Data")
	private Object Data;
}
