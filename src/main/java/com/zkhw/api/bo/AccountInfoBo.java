package com.zkhw.api.bo;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountInfoBo {

	@JSONField(name = "SyncTime")
	private String SyncTime;
	
	@JSONField(name = "Total")
	private Integer Total;
	
	@JSONField(name = "Start")
	private Integer Start;
	
	@JSONField(name = "ReturnSize")
	private Integer ReturnSize;
	
	@JSONField(name = "Models")
	List<AccountInfo> Models;
}
