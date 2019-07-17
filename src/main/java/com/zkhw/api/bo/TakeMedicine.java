package com.zkhw.api.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TakeMedicine extends BaseBo {

	private String id;
	
	private String archiveid;
	
	private String servicename;
	
	private String serviceid;
	
	//药物分类
	private String drugtype;
	
	//药物名称
	private String drugname;
	
	//用法
	private String usage;
	
	//频次
	private String frequency;
	
	//单次用量
	private String amount;
	
	//单次用量单位
	private String unit;
	
	//用药年限
	private String useyears;
	
	//用药年限单位
	private String useyearsunit;
	
	//服药依从性
	private String drugcompliance;
	
	//其它说明
	private String other;
	
	private String UUID;
}
