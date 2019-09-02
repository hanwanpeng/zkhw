package com.zkhw.api.bo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResidentUpBo {

	private List<Resident> Archive;
	
	private List<OperationHistory> OperationHistory;
	
	private List<FamilyHistory> FamilyHistory;
}
