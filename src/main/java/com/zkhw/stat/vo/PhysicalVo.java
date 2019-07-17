package com.zkhw.stat.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhysicalVo {


	private String name;
	
	private String code;
	
	/**
	 * 村总人数
	 */
	private Integer villageNum;

	/**
	 * 男人数
	 */
	private Integer manNum;

	/**
	 * 女人数
	 */
	private Integer womanNum;

}
