package com.zkhw.pub.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//用药记录表
public class TakeMedicineRecord implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 
     */
    private String examId;

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
    private String medicineName;

    /**
     * 用法
     */
    private String medicineUsage;

    /**
     * 频次
     */
    private String frequency;

    /**
     * 用量
     */
    private String medicineDosage;

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
     * 机构
     */
    private String createOrg;

    /**
     * 创建人
     */
    private String createName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String updateName;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * take_medicine_record
     */
    private static final long serialVersionUID = 1L;

}