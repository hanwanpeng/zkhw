package com.zkhw.api.bo;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrgModel {

	@JSONField(name = "DUNS")
	private String duns;
	
	@JSONField(name = "NAME")
	private String name;
	
	@JSONField(name = "USESTATUS")
	private String usestatus;
	
	@JSONField(name = "PARENTSID")
	private String parentsId;
	
	@JSONField(name = "ADDRESS")
	private String addresss;
	
	@JSONField(name = "ZZJGLM")
	private String zzjglm;
	
	@JSONField(name = "LEVELX")
	private String levelx;
	
	@JSONField(name = "STATUS")
	private String status;
	
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
