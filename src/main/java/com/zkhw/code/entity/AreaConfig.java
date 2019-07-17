package com.zkhw.code.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AreaConfig implements Serializable {
	/**
	 * id,`code`,`name`,parent_code,full_name,level_type
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private Integer id;

	/**
	 * 编码
	 */
	private String code;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 父编码
	 */
	private String parentCode;

	/**
	 * 全称
	 */
	private String fullName;

	/**
	 * 级别
	 */
	private Integer levelType;
}