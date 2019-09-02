package com.zkhw.api.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FamilyHistory extends BaseBo{

	private String archiveId;
	
	private String disease;
	
	private String familyDisId;
	
	private String otherDis;
	
	private String relation;
	
	private String uuid;
}
