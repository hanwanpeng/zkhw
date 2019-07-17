package com.zkhw.shanxi.vo;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CheckResultVo {
	
	
	private String id;
	
	
	/**
	 * 电子档案编号
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
	 * 检查人员
	 */
	private String checkdoctor;
	
	/**
	 * 一体机检查报告地址
	 */
	private String checkUrl;
	
	/**
	 * 检查报告结果
	 */
	private String checkResult;
	
	/**
	 * 心率
	 */
	private String HeartRate;
	
	/**
	 * 心电数据（采样数据值逗号隔开）
	 */
	private String ECGData;
	
	/**
	 * 心电结果
	 */
	private String xdtresult;
	
	/**
	 * 心电图片
	 */
	private String imageurl;
	
	/**
	 * 图片地址url
	 */
	private String ECGUrl;
	
	/**
	 * 血糖
	 */
	private String glucose;
	
	/**
	 * 收缩压
	 */
	private String systolic;
	
	/**
	 * 舒张压
	 */
	private String diastolic;
	
	/**
	 * 血氧
	 */
	private String oxygen;
	
	/**
	 * 脉率
	 */
	private String pulse;
	
	/**
	 * 体温
	 */
	private String temperature;
	
	/**
	 * 尿白细胞酯酶
	 */
    private String leu;
    
    /**
     * 尿亚硝酸盐
     */
    private String nit;
    
    /**
     * 尿胆原
     */
    private String uro;
    
    /**
     * 尿蛋白
     */
    private String pro;
    
    /**
     * 尿酸碱度
     */
    private String ph;
    
    /**
     * 尿潜血
     */
    private String bld;
    
    /**
     * 尿比重
     */
    private String sg;
    
    /**
     * 尿酮体
     */
    private String ket;
    
    /**
     * 尿胆红素
     */
    private String bil;
    
    /**
     * 尿葡萄糖
     */
    private String glu;
    
    /**
     * 维生素C
     */
    private String vc;
    
    /**
     * 报告图片（二进制数据字符串）
     */
    private String Img;
	
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
