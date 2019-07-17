package com.zkhw.api.bo;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrerResult {
	@JSONField(name = "ErrorInfo")
	private ErrorInfo errorInfo;
}
