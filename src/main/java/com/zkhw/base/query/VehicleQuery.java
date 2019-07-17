package com.zkhw.base.query;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleQuery {
	
	/**
	 * carId
	 */
	private String carId;
	

	/**
	 * token
	 */
	private String token;
	
	/**
	 * 
	 */
	private String dayTime;
	
	
	/**
	 * 开始时间
	 */
	private String startTime;
	
	/**
	 * 结束时间
	 */
	private String endTime;
	
}
