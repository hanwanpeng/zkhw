package com.zkhw.api.bo;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DictInfo {

	@JSONField(name = "DICTID")
	private String dictId;
	
	//字典类别码
	@JSONField(name = "DICTTYPE")
	private String dictType;
	
	//字典类别名称
	@JSONField(name = "DICTMEMO")
	private String dictMemo;
	
	//字典码
	@JSONField(name = "ITEMCODE")
	private String itemCode;

	//完整字典码
	@JSONField(name = "DICTCODE")
	private String dictCode;
	
	//字典名称
	@JSONField(name = "ITEMNAME")
	private String itemName;
	
	//排列序号
	@JSONField(name = "ORDERNO")
	private Integer orderNo;
	
	//状态
	@JSONField(name = "DICTSTATUS")
	private String dictStatus;
	
	//备注
	@JSONField(name = "REMARK")
	private String remark;
}
