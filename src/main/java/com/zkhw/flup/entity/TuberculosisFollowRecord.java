package com.zkhw.flup.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//肺结核随访记录表
public class TuberculosisFollowRecord implements Serializable {
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
     * 治疗月序
     */
    private Integer monthOrder;

    /**
     * 督导人员选择
     */
    private String supervisorType;

    /**
     * 访问方式
     */
    private String visitType;

    /**
     * 症状及体征
     */
    private String symptom;

    /**
     * 症状其他
     */
    private String symptomOther;

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
     * 化疗方案
     */
    private String chemotherapyPlan;

    /**
     * 用法
     */
    private String drugsUsage;

    /**
     * 药品剂型
     */
    private String drugsType;

    /**
     * 漏服药次数
     */
    private Integer miss;

    /**
     * 药物不良反应
     */
    private String untowardEffect;

    /**
     * 不良反应症状
     */
    private String untowardEffectInfo;

    /**
     * 并发症或合并症
     */
    private String complication;

    /**
     * 并发症信息
     */
    private String complicationInfo;

    /**
     * 转诊机构和科别
     */
    private String transferTreatmentDepartment;

    /**
     * 转诊原因
     */
    private String transferTreatmentReason;

    /**
     * 转诊两周后随访结果
     */
    private String twoweekVisitResult;

    /**
     * 处理意见
     */
    private String handlingSuggestion;

    /**
     * 下次随访日期
     */
    private String nextVisitDate;

    /**
     * 随访医生
     */
    private String visitDoctor;

    /**
     * 停止治疗日期
     */
    private String stopDate;

    /**
     * 停止治疗原因
     */
    private String stopReason;

    /**
     * 应该随访次数
     */
    private Integer mustVisitNum;

    /**
     * 实际随访次数
     */
    private Integer actualVisitNum;

    /**
     * 应服药次数
     */
    private Integer mustMedicineNum;

    /**
     * 实际服药次数
     */
    private Integer actualMedicineNum;

    /**
     * 服药率
     */
    private String medicineRate;

    /**
     * 评估医生
     */
    private String estimateDoctor;

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
     * 上传状态
     */
    private Integer uploadStatus;

    /**
     * 上传时间
     */
    private Date uploadTime;

    /**
     * 上传结果
     */
    private String uploadResult;

    /**
     * tuberculosis_follow_record
     */
    private static final long serialVersionUID = 1L;

}