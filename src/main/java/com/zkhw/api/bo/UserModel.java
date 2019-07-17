package com.zkhw.api.bo;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserModel {

	@JSONField(name = "ID")
	private String id;
	
	@JSONField(name = "USERID")
	private String userId;
	
	@JSONField(name = "LASTNAME")
	private String lastName;
	
	@JSONField(name = "FIRSTNAME")
	private String firstName;
	
	@JSONField(name = "DEPTNO")
	private String deptNo;
	
	@JSONField(name = "STATUS")
	private String status;
	
	@JSONField(name = "DUNS")
	private String duns;
	
	@JSONField(name = "DISABLED_BY")
	private String disabled_by;
	
	@JSONField(name = "DISABLED_DATE")
	private String disabled_date;
	
	@JSONField(name = "UPDATED_BY")
	private String updated_by;
	
	@JSONField(name = "UPDATED_DATE")
	private String updated_date;
	
	@JSONField(name = "CREATE_BY")
	private String create_by;
	
	@JSONField(name = "CREATE_DATE")
	private String create_date;
	
}
