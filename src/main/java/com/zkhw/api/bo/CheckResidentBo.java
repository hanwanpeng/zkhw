package com.zkhw.api.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CheckResidentBo {

	private String errCode;
	
	private String errMsg;
	
	//1=是；0=否
	private Integer isBulid;
	
	private String archiveid;
	
	private String identityNo;
	
	private String fullname;
	
	private String gender;
	
	private String birthday;
	
	private String manageDuns;
	
	private String dutyDoctor;
}
 