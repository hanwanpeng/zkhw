package com.zkhw.shanxi.vo;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CheckRecordVo {
	
	
	/**
	 * 主键UUID类型
	 */
	private String id;
	
	
	/**
	 * 个人档案ID
	 */
	private String aichiveNo;
	
	
	/**
	 * 身份证号
	 */
	private String idNumber;
	
	/**
	 * 检查时间
	 */
	private String checkDate;
	
	/**
	 * 检查人员
	 */
	private String checkdoctor;
	
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 联系方式
	 */
	private String phone;
	
	/**
	 * 健康卡号
	 */
	private String healthNO;
	
	/**
	 * 组织机构
	 */
	private String organName;
	
	/**
	 * 创建者
	 */
	private String createName;
	
	/**
	 * 创建时间
	 */
	private String createTime;
	
	/**
	 * 修改者
	 */
	private String updateName;
	
	/**
	 * 修改时间
	 */
	private String updateTime;
	
	/**
	 * 数据源类型
	 */
	private String dataResType;
	
	/**
	 * 设备供应商
	 */
	private String sSupplierCode;
	
	/**
	 * 设备编码
	 */
	private String sMachineCode;
	
	/**
	 * 是否上传成功
	 */
	private String isSuccess;
	
	/**
	 * 上传时间
	 */
	private String uploadTime;
	
	/**
	 * 上传失败原因
	 */
	private String errReason;
	
	
	
}
