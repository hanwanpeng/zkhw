package com.zkhw.stat.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlupVo {
	
	
	/**
	 * 高血压总人数
	 */
	private Integer hypertensionTotal;
	
	/**
	 * 已随访高血压人数
	 */
	private Integer hypertensionNum;
	
	
	/**
	 * 糖尿病总人数
	 */
	private Integer diabetesTotal;
	
	/**
	 * 已随访糖尿病人数
	 */
	private Integer diabetesNum;
	
	/**
	 * 肺结核总人数
	 */
	private Integer tuberculosisTotal;
	
	/**
	 * 已随访肺结核人数
	 */
	private Integer tuberculosisNum;
	
	/**
	 * 精神病总人数
	 */
	private Integer psychosisTotal;
	
	/**
	 * 已随访精神病人数
	 */
	private Integer psychosisNum;

}
