package com.zkhw.shanxi.vo;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class XdtVo {
	
	
	private String id;
	
	private String ExamID;
	
	/**
	 * 心率
	 */
	private String HeartRate;
	
	/**
	 * 心电数据（采样数据值逗号隔开）
	 */
	private String ECGData;
	
	
	/**
	 * 心电图浏览地址（浏览地址Url）
	 */
	private String ECGUrl;
	
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
	 * 修改者
	 */
	private String updateName;
	
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
	private String IsSuccess;
	
	/**
	 * 上传时间
	 */
	private String uploadTime;
	
	/**
	 * 上传失败原因
	 */
	private String errReason;
	
	

	/**
	 * 电子档案编号
	 */
	private String aichiveNo;

	/**
	 * 身份证号
	 */
	private String idNumber;

	/**
	 * 条码编号
	 */
	private String barCode;

	/**
     * 社保卡号
     */
    private String socialsecuritycode;

	/**
	 * 诊断结果
	 */
	private String xdtresult;

	/**
	 * 医生
	 */
	private String xdtdoctor;

	/**
	 * 名称
	 */
	private String xdtname;

	private String ventrate;

	private String pr;

	private String qrs;

	private String qt;

	private String qtc;

	private String pRT;

	private String dob;

	private String age;

	private String gen;

	private String dep;

	private String createTime;

	private String updateTime;

	private String synchronizeType;

	private String zrysxdt;

	/**
	 * 图片地址url
	 */
	private String imageurl;

	/**
	 * 上传云数据库的状态 0 未上传  1  上传
	 */
	private Integer uploadStatus;

	private String hr;

	private String p;

	private String pqrs;

	private String t;

	private String rv5;

	private String sv1;

	private String baselineDrift;

	private String myoelectricity;
	
	private String frequency;

	/**
	 * 描述
	 */
	private String xdtdesc;
	
	

	
	
}
