package com.zkhw.shanxi.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResidentVo {

	/**
	 * 类型1身份证2档案号
	 */
	private String typeId;

	
	
	
	/**
	 * 主键
	 */
	private String id;

	/**
	 * 电子档案唯一编码
	 */
	private String archiveNo;

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
	 * 身份证号
	 */
	private String idNumber;
	
	/**
	 * 户籍地址
	 */
	private String registerAddress;

	/**
	 * 户籍所在地(门牌号)（无）
	 */
	private String registerAddressDoor;

	/**
	 * 现住址
	 */
	private String residenceAddress;
	
	/**
	 * 现住址(门牌号)（无）
	 */
	private String residenceAddressDoor;
	
	/**
	 * 工作单位（无）
	 */
	private String company;

	/**
	 * 电话
	 */
	private String phone;

	/**
	 * 联系人
	 */
	private String linkName;

	/**
	 * 联系人电话
	 */
	private String linkPhone;

	/**
	 * 常住类型
	 */
	private String residentType;

	/**
	 * 民族
	 */
	private String nation;

	/**
	 * 健康卡号
	 */
	private String medicalCode;

	/**
	 * 责任医生
	 */
	private String doctorName;

	/**
	 * 是否贫困
	 */
	private Integer isPoor;

	/**
	 * 建档日期
	 */
	private String createTime;

	/**
	 * 建档医生
	 */
	private String createName;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 建档机构
	 */
	private String aichiveOrg;
	
	private String archiveid;
	
	private String archstatus;

}
