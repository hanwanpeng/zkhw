package com.zkhw.base.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NetworkVehicleVo {
	
	/**
	 * 是否车联网车辆（1：车联网车辆，0：非车联网车辆）
	 */
	private String networkVehicle;

	/**
	 * 最后上传数据时间
	 */
	private String lastTime;
	
	
}
