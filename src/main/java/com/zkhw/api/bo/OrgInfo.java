package com.zkhw.api.bo;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrgInfo {

	//机构编码
	@JSONField(name = "DUNS")
	private String DUNS;
	
	//机构名称
	@JSONField(name = "NAME")
	private String NAME;
	
	//使用状态
	@JSONField(name = "USESTATUS")
	private String USESTATUS;
	
	//上级机构
	@JSONField(name = "PARENTSID")
	private String PARENTSID;
	
	//地址
	@JSONField(name = "ADDRESS")
	private String ADDRESS;
	
	//组织机构代码
	@JSONField(name = "ZZJGLM")
	private String ZZJGLM;
	
	//卫生机构级别1
	@JSONField(name = "LEVELX")
	private String LEVELX;
}
