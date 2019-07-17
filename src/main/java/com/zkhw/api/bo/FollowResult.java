package com.zkhw.api.bo;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FollowResult {

	@JSONField(name = "LogBody")
	private Error LogBody;
	
	@JSONField(name = "TakeMedicineRecord")
	private List<Error> TakeMedicineRecord;
}
