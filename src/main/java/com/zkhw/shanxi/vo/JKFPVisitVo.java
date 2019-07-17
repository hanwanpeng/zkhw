package com.zkhw.shanxi.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JKFPVisitVo {

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 档案ID
	 */
	private String archiveNo;

	/**
	 * 身份证号
	 */
	private String idNumber;
	
	/**
	 * 姓名
	 */
	private String name;
	

	/**
	 * 性别
	 */
	private String sex;

	/**
	 * 出生日期
	 */
	private String birthday;

	
	/**
	 * 本次随访日期
	 */
	private String visitDate;
	
	/**
	 * 随访方式
	 */
	private String visitType;
	
	/**
	 * 随方医生
	 */
	private String visitDoc;
	
	/**
	 * 工作内容
	 */
	private String gznr;
	
	
	/**
	 * 评价与建议
	 */
	private String advice;
	
	/**
	 * 机构码
	 */
	private String createOrg;
	

}
