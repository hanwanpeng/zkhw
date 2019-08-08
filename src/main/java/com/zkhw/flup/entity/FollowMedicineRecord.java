package com.zkhw.flup.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//随访用药记录表
public class FollowMedicineRecord implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 随访id
     */
    private String followId;

    /**
     * 电子档案唯一编码
     */
    private String archiveNo;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 服务名称
     */
    private String serviceName;

    /**
     * 药物类型
     */
    private String medicineType;

    /**
     * 药物名称
     */
    private String drugName;

    /**
     * 用法
     */
    private String medicineUsage;

    /**
     * 每次几次
     */
    private String num;

    /**
     * 用量
     */
    private String dosage;

    /**
     * 用量单位
     */
    private String unit;

    /**
     * 用药时间
     */
    private String medicineTime;

    /**
     * 用药年限单位
     */
    private String medicineTimeUnit;

    /**
     * 服药依从性
     */
    private String medicineCompliance;

    /**
     * 其他说明
     */
    private String other;

    /**
     * 
     */
    private String createUser;

    /**
     * 
     */
    private String createName;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private String updateUser;

    /**
     * 
     */
    private String updateName;

    /**
     * 
     */
    private Date updateTime;

    /**
     * follow_medicine_record
     */
    private static final long serialVersionUID = 1L;
}