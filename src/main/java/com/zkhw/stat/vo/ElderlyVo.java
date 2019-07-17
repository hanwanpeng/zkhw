package com.zkhw.stat.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElderlyVo {
	
	
	/**
	 * 老年人总人数
	 */
	private Integer elderlyNum;
	
	/**
	 * 已体检老年人人数
	 */
	private Integer elderlyYet;
	
	/**
	 * 未体检老年人人数
	 */
	private Integer elderlyNo;
	
	/**
	 * 老年人生活自理能力评估人数
	 */
	private Integer estimateNum;
	
	/**
	 * 中医体质辨识人数
	 */
	private Integer recordNum;
	
	
	
	
	

}
