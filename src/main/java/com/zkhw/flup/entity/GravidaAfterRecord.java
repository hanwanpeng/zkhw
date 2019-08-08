package com.zkhw.flup.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//孕产妇产后42天随访
public class GravidaAfterRecord implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 孕妇第一次检查ID
     */
    private String gravidaId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电子档案编号
     */
    private String archiveNo;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 访问日期
     */
    private String visitDate;

    /**
     * 分娩日期
     */
    private String childbirth;

    /**
     * 出院日期
     */
    private String dischargeDate;

    /**
     * 体温
     */
    private String temperature;

    /**
     * 一般健康状况
     */
    private String generalHealthStatus;

    /**
     * 一般心理状况
     */
    private String generalPsychologyStatus;

    /**
     * 血压高压
     */
    private Integer bloodPressureHigh;

    /**
     * 血压低压
     */
    private Integer bloodPressureLow;

    /**
     * 乳房是否异常
     */
    private String breast;

    /**
     * 乳房异常信息
     */
    private String breastError;

    /**
     * 恶露
     */
    private String lyma;

    /**
     * 恶露异常信息
     */
    private String lymaError;

    /**
     * 子宫
     */
    private String womb;

    /**
     * 子宫异常信息
     */
    private String wombError;

    /**
     * 伤口
     */
    private String wound;

    /**
     * 伤口异常
     */
    private String woundError;

    /**
     * 其他
     */
    private String other;

    /**
     * 分类
     */
    private String conditions;

    /**
     * 分类异常
     */
    private String conditionError;

    /**
     * 指导
     */
    private String guidance;

    /**
     * 其他指导
     */
    private String guidanceOther;

    /**
     * 有无转诊
     */
    private String transferTreatment;

    /**
     * 转诊原因
     */
    private String transferTreatmentReason;

    /**
     * 转诊机构和科室
     */
    private String transferTreatmentDepartment;

    /**
     * 下次随访日期
     */
    private String nextVisitDate;

    /**
     * 访问医生签名
     */
    private String visitDoctor;

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
    private String createOrg;

    /**
     * 
     */
    private String createOrgName;

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
     * 
     */
    private Integer uploadStatus;

    /**
     * 
     */
    private Date uploadTime;

    /**
     * 
     */
    private String uploadResult;

    /**
     * 产后1；产后42天2
     */
    private String recordType;

    /**
     * gravida_after_record
     */
    private static final long serialVersionUID = 1L;

}