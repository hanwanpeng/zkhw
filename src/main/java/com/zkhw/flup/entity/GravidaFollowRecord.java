package com.zkhw.flup.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//第 2～5 次产前随访服务记录表
public class GravidaFollowRecord implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String gravidaId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电子档案编码
     */
    private String archiveNo;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 项目
     */
    private String orderNum;

    /**
     * 访问日期
     */
    private String visitDate;

    /**
     * 孕周
     */
    private Integer gestationalWeeks;

    /**
     * 孕妇自述症状
     */
    private String symptom;

    /**
     * 体重
     */
    private String weight;

    /**
     * 宫高
     */
    private String fundusHeight;

    /**
     * 腹围
     */
    private String abdomenCircumference;

    /**
     * 胎位
     */
    private String fetusPosition;

    /**
     * 胎心率
     */
    private String fetalHeartRate;

    /**
     * 血压高压
     */
    private Integer bloodPressureHigh;

    /**
     * 血压低压
     */
    private Integer bloodPressureLow;

    /**
     * 血红蛋白
     */
    private String hemoglobin;

    /**
     * 尿蛋白
     */
    private String urineProtein;

    /**
     * 其他辅助检查
     */
    private String checkOther;

    /**
     * 分类
     */
    private String conditions;

    /**
     * 异常信息
     */
    private String errorInfo;

    /**
     * 指导
     */
    private String guidance;

    /**
     * 
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
     * gravida_follow_record
     */
    private static final long serialVersionUID = 1L;

}