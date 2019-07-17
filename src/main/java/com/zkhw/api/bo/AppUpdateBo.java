package com.zkhw.api.bo;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AppUpdateBo {

	@JSONField(name = "App_Version")
	private String app_Version;
	
	@JSONField(name = "AppPath")
	private String appPath;
	
	@JSONField(name = "AppName")
	private String appName;
	
	@JSONField(name = "isForce")
	private String isForce;
	
	@JSONField(name = "info")
	private String info;
	
	@JSONField(name = "size")
	private String size;
}
