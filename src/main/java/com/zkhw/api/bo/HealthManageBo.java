package com.zkhw.api.bo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HealthManageBo {

	private List<HealthManageUp> ElderlyHealthManage;
	
	private List<FeimianyiHis> FeimianyiHis;
}
