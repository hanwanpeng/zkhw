package com.zkhw.api.bo;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AreaInfo {

	//行政区划编码
	@JSONField(name = "ID")
	private String ID;
	
	//行政区划名称
	@JSONField(name = "NAME")
	private String NAME;
	
	//父级区划码
	@JSONField(name = "PID")
	private String PID;
	
	//行政区划全称
	@JSONField(name = "FULLNAME")
	private String FULLNAME;
	
	//行政级别
	@JSONField(name = "LEVELX")
	private String LEVELX;
	
	//排序
	@JSONField(name = "SEQ")
	private String SEQ;
	
	//使用状态
	@JSONField(name = "USESTATUS")
	private String USESTATUS;
}
