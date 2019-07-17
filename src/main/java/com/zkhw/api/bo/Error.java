package com.zkhw.api.bo;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Error {
	@JSONField(name = "Id")
	private String Id;
	
	@JSONField(name = "Code")
	private String Code;
	
	@JSONField(name = "Info")
	private String Info;
}
