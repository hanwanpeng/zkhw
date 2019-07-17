package com.zkhw.pub.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Xdt implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4026918175698143245L;

	/**
     * 
     */
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

    /**
     * 
     */
    private String ventrate;

    /**
     * 
     */
    private String pr;

    /**
     * 
     */
    private String qrs;

    /**
     * 
     */
    private String qt;

    /**
     * 
     */
    private String qtc;

    /**
     * 
     */
    private String pRT;

    /**
     * 
     */
    private String dob;

    /**
     * 
     */
    private String age;

    /**
     * 
     */
    private String gen;

    /**
     * 
     */
    private String dep;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 修改时间
     */
    private Date updatetime;

    /**
     * 
     */
    private String synchronizeType;

    /**
     * 
     */
    private String zrysxdt;

    /**
     * 图片地址url
     */
    private String imageurl;

    /**
     * 上传云数据库的状态 0 未上传  1  上传
     */
    private Integer uploadStatus;

    /**
     * 
     */
    private String hr;

    /**
     * 
     */
    private String p;

    /**
     * 
     */
    private String pqrs;

    /**
     * 
     */
    private String t;

    /**
     * 
     */
    private String rv5;

    /**
     * 
     */
    private String sv1;

    /**
     * 
     */
    private String baselineDrift;

    /**
     * 
     */
    private String myoelectricity;

    /**
     * 
     */
    private String frequency;

    /**
     * 描述
     */
    private String xdtdesc;

}