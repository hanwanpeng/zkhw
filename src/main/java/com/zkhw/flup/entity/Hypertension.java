package com.zkhw.flup.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//高血压随访记录表
public class Hypertension implements Serializable {
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
     * 访问方式
     */
    private String visitType;

    /**
     * 症状
     */
    private String symptom;

    /**
     * 其他症状
     */
    private String otherSymptom;

    /**
     * 收缩压
     */
    private Integer sbp;

    /**
     * 舒张压
     */
    private Integer dbp;

    /**
     * 本次体重(kg)
     */
    private String weight;

    /**
     * 下次目标体重
     */
    private String targetWeight;

    /**
     * 身高(cm)
     */
    private String height;

    /**
     * 本次体质指数
     */
    private String bmi;

    /**
     * 下次目标体质指数
     */
    private String targetBmi;

    /**
     * 心率（次/分）
     */
    private Integer heartRate;

    /**
     * 其它体征
     */
    private String otherSign;

    /**
     * 日吸烟量
     */
    private Integer smoken;

    /**
     * 目标日吸烟量（支）
     */
    private Integer targetSomken;

    /**
     * 日饮酒量（两）
     */
    private Integer wine;

    /**
     * 目标日饮酒量（两）
     */
    private Integer targetWine;

    /**
     * 运动（次/周）
     */
    private Integer sportWeek;

    /**
     * 运动（分钟/次）
     */
    private Integer sportOnce;

    /**
     * 目标运动(次/周)
     */
    private Integer targetSportWeek;

    /**
     * 目标运动（分钟/次）
     */
    private Integer targetSportOnce;

    /**
     * 摄盐情况
     */
    private String saltIntake;

    /**
     * 目标摄盐情况
     */
    private String targetSaltIntake;

    /**
     * 心理调整
     */
    private String mindAdjust;

    /**
     * 遵医行为
     */
    private String doctorObey;

    /**
     * 辅助检查
     */
    private String assistExamine;

    /**
     * 服药依从性
     */
    private String drugObey;

    /**
     * 有无药物不良反应
     */
    private String untowardEffect;

    /**
     * 药物不良反应说明
     */
    private String untowardEffectDrug;

    /**
     * 此次随访分类
     */
    private String visitClass;

    /**
     * 转诊记录Id
     */
    private String referralCode;

    /**
     * 下次随访日期
     */
    private String nextVisitDate;

    /**
     * 访问医生签名
     */
    private String visitDoctor;

    /**
     * 评价与建议
     */
    private String advice;

    /**
     * 
     */
    private String createUser;

    /**
     * 创建者
     */
    private String createName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 
     */
    private String createOrg;

    /**
     * 
     */
    private String createOrgName;

    /**
     * 修改者
     */
    private String updateName;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 转诊机构及科别
     */
    private String transferOrgan;

    /**
     * 转诊原因
     */
    private String transferReason;

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
     * fuv_hypertension
     */
    private static final long serialVersionUID = 1L;

}