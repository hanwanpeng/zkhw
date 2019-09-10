package com.zkhw.stat.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExaminationNumVo {

	/**
	 * 体检总人数
	 */
	private Integer allExamNum;
	
	/**
	 * 老年人体检数
	 */
	private Integer examForElderlyNum;
	
	/**
	 * 高血压体检数
	 */
	private Integer examForHypertensionNum;
	
	/**
	 * 糖尿病体检数
	 */
	private Integer examForDiabetesNum;
	
	/**
	 * 肺结核体检数 
	 */
	private Integer examForTuberculosisNum;
	
	/**
	 * 精神病体检数
	 */
	private Integer examForPsychosisNum;
	

	
}
