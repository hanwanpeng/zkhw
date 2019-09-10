package com.zkhw.stat.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExaminationVo {

	/**
	 * 2019年体检
	 */
	private Integer examinationNum;
	
	/**
	 * 26岁—64岁体检
	 */
	private Integer twentySixNum;
	
	/**
	 * 65岁以上老年人体检
	 */
	private Integer elderlyYet;
	
	/**
	 * 贫困户体检
	 */
	private Integer poorExamNum;
	
	
	/**
	 * 贫困户患慢病人员
	 */
	private Integer poorAndDiseaseNum;
	
}
