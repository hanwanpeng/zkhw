package com.zkhw.flup.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//第 1次产前检查服务记录表
public class GravidaInfo implements Serializable {
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
     * 填表日期
     */
    private String visitDate;

    /**
     * 孕周
     */
    private Integer gestationalWeeks;

    /**
     * 孕妇年龄
     */
    private Integer gravidaAge;

    /**
     * 丈夫姓名
     */
    private String husbandName;

    /**
     * 丈夫年龄
     */
    private Integer husbandAge;

    /**
     * 丈夫电话
     */
    private String husbandPhone;

    /**
     * 孕次
     */
    private Integer pregnantNum;

    /**
     * 阴道分娩次数
     */
    private Integer naturalLabourNum;

    /**
     * 剖腹产次数
     */
    private Integer cesareanNum;

    /**
     * 末次月经日期
     */
    private String lastMenstruationDate;

    /**
     * 预产期
     */
    private String dueDate;

    /**
     * 既往史
     */
    private String pastIllness;

    /**
     * 既往史其他
     */
    private String pastIllnessOther;

    /**
     * 家族史
     */
    private String familyHistory;

    /**
     * 家族史其他
     */
    private String familyHistoryOther;

    /**
     * 个人史
     */
    private String habitsCustoms;

    /**
     * 个人史其他
     */
    private String habitsCustomsOther;

    /**
     * 妇产科手术史
     */
    private String isoperation;

    /**
     * 手术名称
     */
    private String operationName;

    /**
     * 自然流产次数
     */
    private Integer naturalAbortionNum;

    /**
     * 人工流产次数
     */
    private Integer abactioNum;

    /**
     * 死胎次数
     */
    private Integer fetaldeathNum;

    /**
     * 死产次数
     */
    private Integer stillbirthNum;

    /**
     * 新生儿死亡次数
     */
    private Integer neonatalDeathNum;

    /**
     * 出生缺陷儿次数
     */
    private Integer birthDefectNum;

    /**
     * 身高
     */
    private String height;

    /**
     * 体重
     */
    private String weight;

    /**
     * 体质指数bmi
     */
    private String bmi;

    /**
     * 血压高压
     */
    private Integer bloodPressureHigh;

    /**
     * 血压低压
     */
    private Integer bloodPressureLow;

    /**
     * 心脏
     */
    private String heart;

    /**
     * 心脏其他
     */
    private String heartOther;

    /**
     * 肺部
     */
    private String lungs;

    /**
     * 肺部其他
     */
    private String lungsOther;

    /**
     * 外阴
     */
    private String vulva;

    /**
     * 外阴其他
     */
    private String vulvaOther;

    /**
     * 阴道
     */
    private String vagina;

    /**
     * 阴道其他
     */
    private String vaginaOther;

    /**
     * 宫颈
     */
    private String cervix;

    /**
     * 宫颈其他
     */
    private String cervixOther;

    /**
     * 子宫
     */
    private String corpus;

    /**
     * 子宫其他
     */
    private String corpusOther;

    /**
     * 附件
     */
    private String accessories;

    /**
     * 附件其他
     */
    private String accessoriesOther;

    /**
     * 血红蛋白
     */
    private String hemoglobin;

    /**
     * 白细胞计数
     */
    private String leukocyte;

    /**
     * 血小板计数
     */
    private String platelet;

    /**
     * 血液检查其他
     */
    private String bloodOther;

    /**
     * 尿蛋白
     */
    private String urineProtein;

    /**
     * 尿糖
     */
    private String glycosuria;

    /**
     * 尿酮体
     */
    private String urineAcetoneBodies;

    /**
     * 尿潜血
     */
    private String bld;

    /**
     * 尿常规其他
     */
    private String urineOther;

    /**
     * 血糖
     */
    private String bloodSugar;

    /**
     * 血型
     */
    private String bloodGroup;

    /**
     * RH
     */
    private String bloodRh;

    /**
     * 血清谷丙转氨酶
     */
    private String sgft;

    /**
     * 血清谷草转氨酶
     */
    private String ast;

    /**
     * 白蛋白
     */
    private String albumin;

    /**
     * 总胆红素
     */
    private String totalBilirubin;

    /**
     * 结合胆红素
     */
    private String conjugatedBilirubin;

    /**
     * 血清肌酐
     */
    private String scr;

    /**
     * 血尿素
     */
    private String bloodUrea;

    /**
     * 阴道分泌物
     */
    private String vaginalFluid;

    /**
     * 阴道分泌物其他
     */
    private String vaginalFluidOther;

    /**
     * 阴道清洁度
     */
    private String vaginalCleaning;

    /**
     * 乙型肝炎表面抗原
     */
    private String hb;

    /**
     * 乙型肝炎表面抗体
     */
    private String hbsab;

    /**
     * 乙型肝炎e抗原
     */
    private String hbeag;

    /**
     * 乙型肝炎e抗体
     */
    private String hbeab;

    /**
     * 乙型肝炎核心抗体
     */
    private String hbcab;

    /**
     * 梅毒血清学实验
     */
    private String syphilis;

    /**
     * HIV抗体检测
     */
    private String hiv;

    /**
     * B超
     */
    private String bUltrasonic;

    /**
     * 其他检测
     */
    private String other;

    /**
     * 总体评估
     */
    private String generalAssessment;

    /**
     * 评估异常
     */
    private String assessmentError;

    /**
     * 保健指导
     */
    private String healthGuidance;

    /**
     * 保健指导其他
     */
    private String healthGuidanceOther;

    /**
     * 有无转诊
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
     * 下次访问日期
     */
    private String nextVisitDate;

    /**
     * 访问医生签名
     */
    private String visitDoctor;

    /**
     * 
     */
    private String status;

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
     * gravida_info
     */
    private static final long serialVersionUID = 1L;

}