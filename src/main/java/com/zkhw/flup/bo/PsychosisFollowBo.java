package com.zkhw.flup.bo;

import java.util.List;

import com.zkhw.flup.entity.FollowMedicineRecord;
import com.zkhw.flup.entity.PsychosisFollowRecord;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PsychosisFollowBo {

	private PsychosisFollowRecord psychosis;
	
	private List<FollowMedicineRecord> medicineList;
}
