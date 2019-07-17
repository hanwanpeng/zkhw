package com.zkhw.pub.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Ncg implements Serializable {
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
     * 
     */
    private String wbc;

    /**
     * 
     */
    private String leu;

    /**
     * 
     */
    private String nit;

    /**
     * 
     */
    private String uro;

    /**
     * 
     */
    private String pro;

    /**
     * 
     */
    private String ph;

    /**
     * 
     */
    private String bld;

    /**
     * 
     */
    private String sg;

    /**
     * 
     */
    private String ket;

    /**
     * 
     */
    private String bil;

    /**
     * 
     */
    private String glu;

    /**
     * 
     */
    private String vc;

    /**
     * 
     */
    private String ma;

    /**
     * 
     */
    private String acr;

    /**
     * 
     */
    private String ca;

    /**
     * 
     */
    private String cr;

    /**
     * 试纸类型（11G、11A）
     */
    private String type;

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
    private String zrysncg;

    /**
     * 上传云数据库的状态 0 未上传  1  上传
     */
    private Integer uploadStatus;

    /**
     * zkhw_tj_ncg
     */
    private static final long serialVersionUID = 1L;

   
}