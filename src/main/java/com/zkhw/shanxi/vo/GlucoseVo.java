package com.zkhw.shanxi.vo;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GlucoseVo {
	
	
	private String id;
	
	private String ExamID;
	
	/**
	 * 血糖
	 */
	private String glucose;
	
	/**
	 * 电子档案编号
	 */
	private String aichiveNo;
	
	/**
	 * 身份证号
	 */
	private String idNumber;
	
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
