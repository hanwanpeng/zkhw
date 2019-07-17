package com.zkhw.api.bo;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserInfo {

	@JSONField(name = "ID")
	private String id;
	
	//用户名
	@JSONField(name = "USERID")
	private String userId;
	
	@JSONField(name = "LASTNAME")
	private String lastName;
	
	//名
	@JSONField(name = "FIRSTNAME")
	private String firstName;
		
	//单位编码
	@JSONField(name = "DEPTNO")
	private String deptNo; 
}
