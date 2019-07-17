package com.zkhw.ltd.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户
 * 
 *
 */
@Setter
@Getter
public class User implements Serializable {
	/**
	 * 用户编码
	 */
	private String userCode;
	
	/**公卫用户编码
	 * 
	 */
	private String pubUsercode;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 登录名
	 */
	private String loginName;

	/**
	 * 登录密码
	 */
	private String loginPass;

	/**
	 * 性别(1-男 0-女)
	 */
	private Integer sex;

	/**
	 * 工号
	 */
	private String jobNum;

	/**
	 * 电话
	 */
	private String telePhone;

	/**
	 * 邮箱
	 */
	private String mail;

	/**
	 * 出生日期
	 */
	private String birthday;

	/**
	 * 组织机构编码
	 */
	private String organCode;
	
	/**
	 * 上级机构编码
	 */
	
	private String parentOrgan;

	/**
	 * 部门编码
	 */
	private String departCode;

	/**
	 * 用户类型
	 */
	private String userTypeCode;

	/**
	 * 数据级别
	 */
	private Integer dataLevel;

	/**
	 * 状态（1-启用 2-停用）
	 */
	private Integer status;

	/**
	 * 是否删除(0-未删 1-已删)
	 */
	private Integer isDelete;

	/**
	 * 创建时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * 创建人编码
	 */
	private String createUserCode;

	/**
	 * 修改时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	/**
	 * 修改人编码
	 */
	private String updateUserCode;

	private static final long serialVersionUID = 1L;

	/**
	 * 部门编码及下属部门编码
	 */
	private List<String> departCodeList;

}