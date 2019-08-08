package com.zkhw.flup.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//糖尿病随访
public class DiabetesFollowRecord implements Serializable {
    /**
     * 
     */
    private String id;

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
     * 访问日期
     */
    private String visitDate;

    /**
     * 访问类型
     */
    private String visitType;

    /**
     * 症状
     */
    private String symptom;

    /**
     * 症状其他
     */
    private String symptomOther;

    /**
     * 血压高压
     */
    private Integer bloodPressureHigh;

    /**
     * 血压低压
     */
    private Integer bloodPressureLow;

    /**
     * 目前体重
     */
    private String weightNow;

    /**
     * 下次体重
     */
    private String weightNext;

    /**
     * 
     */
    private String height;

    /**
     * 目前体质指数
     */
    private String bmiNow;

    /**
     * 下次体质指数
     */
    private String bmiNext;

    /**
     * 足背动脉搏动
     */
    private String dorsalArtery;

    /**
     * 搏动位置(1：双侧 2：左侧 3：右侧）
     */
    private String pulsationPosition;

    /**
     * 
     */
    private String other;

    /**
     * 现在每天吸烟量
     */
    private Integer smokeNow;

    /**
     * 下次随访每天吸烟目标
     */
    private Integer smokeNext;

    /**
     * 现在每天饮酒量
     */
    private Integer drinkNow;

    /**
     * 下次随访每天饮酒目标量
     */
    private Integer drinkNext;

    /**
     * 目前每周运动次数
     */
    private Integer sportsNumNow;

    /**
     * 目前每次运动时长
     */
    private Integer sportsTimeNow;

    /**
     * 下次每周运动次数目标
     */
    private Integer sportsNumNext;

    /**
     * 下次每次运动时长目标
     */
    private Integer sportsTimeNext;

    /**
     * 目前每天主食量
     */
    private String stapleFoodNow;

    /**
     * 下次每天主食目标
     */
    private String stapleFoodNext;

    /**
     * 心理调整
     */
    private String psychologicalRecovery;

    /**
     * 遵医行为
     */
    private String medicalCompliance;

    /**
     * 空腹血糖值
     */
    private String bloodGlucose;

    /**
     * 糖化血红蛋白
     */
    private String glycosylatedHemoglobin;

    /**
     * 检查日期
     */
    private String checkDate;

    /**
     * 服药依从性
     */
    private String compliance;

    /**
     * 药物不良反应
     */
    private String untowardEffect;

    /**
     * 药物不良反应描述
     */
    private String untowardEffectDrug;

    /**
     * 低血糖反应
     */
    private String reactiveHypoglycemia;

    /**
     * 此次随访分类
     */
    private String followType;

    /**
     * 胰岛素名称
     */
    private String insulinName;

    /**
     * 胰岛素用法用量
     */
    private String insulinUsage;

    /**
     * 是否转诊
     */
    private String transferTreatment;

    /**
     * 转诊原因
     */
    private String transferTreatmentReason;

    /**
     * 转诊机构和科别
     */
    private String transferTreatmentDepartment;

    /**
     * 
     */
    private String nextVisitDate;

    /**
     * 
     */
    private String visitDoctor;

    /**
     * 
     */
    private String advice;

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
     * diabetes_follow_record
     */
    private static final long serialVersionUID = 1L;

}