package com.zkhw.api.bo;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseBo {

	//机构
	private String duns;
	
	//创建者
	private String created_By;
	
	//创建时间
	@JSONField(name = "created_date")
	private String created_Date;
	
	//修改者
	private String updated_By;
	
	//修改时间
	private String updated_Date;
}
