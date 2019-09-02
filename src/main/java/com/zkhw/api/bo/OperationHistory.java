package com.zkhw.api.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OperationHistory extends BaseBo{
	
	private String id;
	
	private String archiveId;
	
	private String happenDate;
	
	private String name;
	
	private String opsDuns;
	
	private String remark;
	
	private String type;
	
	private String uuid;

}
