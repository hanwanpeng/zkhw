package com.zkhw.flup.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//精神障碍者个人信息表
public class PsychosisInfo implements Serializable {
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
     * 监护人姓名
     */
    private String guardianName;

    /**
     * 监护人与患者关系
     */
    private String guardianRelation;

    /**
     * 监护人地址
     */
    private String guardianAddress;

    /**
     * 监护人电话
     */
    private String guardianPhone;

    /**
     * 居委会联系人
     */
    private String neighborhoodCommitteeLinkman;

    /**
     * 居委会联系电话
     */
    private String neighborhoodCommitteeLinktel;

    /**
     * 户别
     */
    private String residentType;

    /**
     * 就业情况
     */
    private String employmentStatus;

    /**
     * 是否同意管理
     */
    private String agreeManage;

    /**
     * 同意签字人
     */
    private String agreeName;

    /**
     * 同意日期
     */
    private String agreeDate;

    /**
     * 初次发病日期
     */
    private String firstMorbidityDate;

    /**
     * 既往主要症状
     */
    private String symptom;

    /**
     * 
     */
    private String symptomOther;

    /**
     * 既往关锁情况
     */
    private String isolation;

    /**
     * 门诊
     */
    private String outpatient;

    /**
     * 首次抗精神药治疗时间
     */
    private String firstMedicineDate;

    /**
     * 住院次数
     */
    private Integer hospitalizedNum;

    /**
     * 诊断
     */
    private String diagnosis;

    /**
     * 确诊医院
     */
    private String diagnosisHospital;

    /**
     * 确诊日期
     */
    private String diagnosisDate;

    /**
     * 最近一次治疗效果
     */
    private String recentlyTreatmentEffect;

    /**
     * 危险行为
     */
    private String dangerousAct;

    /**
     * 轻度滋事次数
     */
    private Integer slightTroubleNum;

    /**
     * 肇事次数
     */
    private Integer causeTroubleNum;

    /**
     * 肇祸次数
     */
    private Integer causeAccidentNum;

    /**
     * 其他危害行为次数
     */
    private Integer harmOtherNum;

    /**
     * 自伤次数
     */
    private Integer autolesionNum;

    /**
     * 自杀未遂次数
     */
    private Integer attemptedSuicideNum;

    /**
     * 经济状况
     */
    private String economics;

    /**
     * 专科医生意见
     */
    private String specialistSuggestion;

    /**
     * 填表日期
     */
    private String recordDate;

    /**
     * 医生签字
     */
    private String recordDoctor;

    /**
     * 
     */
    private String remark;

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
     * psychosis_info
     */
    private static final long serialVersionUID = 1L;

}