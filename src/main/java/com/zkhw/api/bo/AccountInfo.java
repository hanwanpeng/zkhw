package com.zkhw.api.bo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountInfo {

	@JSONField(name = "UserId")
	private String userId;
	
	@JSONField(name = "Pwd")
	private String pwd;
	
	@JSONField(name = "Status")
	private String status;
	
	@JSONField(name = "CreateTime")
	private Date createTime;
	
	@JSONField(name = "UpdateTime")
	private Date updateTime;
	
	@JSONField(name = "UserName")
	private String userName;
	
	@JSONField(name = "Duns")
	private String duns;
	
	@JSONField(name = "Area")
	private String area;
	
	@JSONField(name = "DunsLevel")
	private String dunsLevel;
}
