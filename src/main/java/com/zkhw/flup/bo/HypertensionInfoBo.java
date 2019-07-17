package com.zkhw.flup.bo;

import java.util.List;

import com.zkhw.flup.entity.FollowMedicineRecord;
import com.zkhw.flup.entity.Hypertension;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HypertensionInfoBo {
	
	private Hypertension hypertension;
	
	private List<FollowMedicineRecord> medicineList;
}
