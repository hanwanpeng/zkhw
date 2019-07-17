package com.zkhw.flup.bo;

import java.util.List;

import com.zkhw.flup.entity.DiabetesFollowRecord;
import com.zkhw.flup.entity.FollowMedicineRecord;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DiabetesFollowBo {

	private DiabetesFollowRecord diabetes;
	
	private List<FollowMedicineRecord> medicineList;
}
