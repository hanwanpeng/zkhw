package com.zkhw.api.bo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JingShenBingVisit {

	private PsychosisFollow LogBody;
	
	private List<TakeMedicine> TakeMedicineRecord;
}
