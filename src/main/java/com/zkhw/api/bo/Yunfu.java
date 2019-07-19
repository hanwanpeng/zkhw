package com.zkhw.api.bo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Yunfu {

	@JSONField(name = "EXAMINID")
	private String examinid;
	
	@JSONField(name = "ARCHIVEID")
	private String archiveid;
	
	@JSONField(name = "CLOSESTATUS")
	private String closeStatus;
	
	@JSONField(name = "CLOSEDATE")
	private Date closeDate;
}
