package com.zkhw.flup.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//肺结核第一次访问记录表
public class TuberculosisInfo implements Serializable {
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
     * 患者类型
     */
    private String patientType;

    /**
     * 痰菌类型
     */
    private String sputumBacteriumType;

    /**
     * 耐药类型
     */
    private String drugFastType;

    /**
     * 症状及体征
     */
    private String symptom;

    /**
     * 症状其他
     */
    private String symptomOther;

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
     * 督导人员选择
     */
    private String supervisorType;

    /**
     * 督导其他
     */
    private String supervisorOther;

    /**
     * 单独居室
     */
    private String singleRoom;

    /**
     * 通风情况
     */
    private String ventilation;

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
     * 取药地址
     */
    private String getMedicineAddress;

    /**
     * 取药日期
     */
    private String getMedicineDate;

    /**
     * 服药记录卡的填写
     */
    private String medicineRecord;

    /**
     * 服药方法及药品存放
     */
    private String medicineLeave;

    /**
     * 肺结核治疗疗程
     */
    private String treatmentCourse;

    /**
     * 不规律服药危害
     */
    private String erratically;

    /**
     * 服药后的不良反应及处理
     */
    private String untowardEffect;

    /**
     * 治疗期间复诊查痰
     */
    private String furtherConsultation;

    /**
     * 外出期间如何坚持服药
     */
    private String insist;

    /**
     * 生活习惯及注意事项
     */
    private String habitsCustoms;

    /**
     * 密切接触者检查
     */
    private String intimateContact;

    /**
     * 下次随访日期
     */
    private String nextVisitDate;

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
     * tuberculosis_info
     */
    private static final long serialVersionUID = 1L;

}