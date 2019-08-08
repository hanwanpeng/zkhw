package com.zkhw.flup.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//0-6岁儿童健康检查记录表
public class ChildrenHealthRecord implements Serializable {
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
     * 月龄
     */
    private Integer age;

    /**
     * 随访日期
     */
    private String visitDate;

    /**
     * 体重
     */
    private String weight;

    /**
     * 体重评价
     */
    private String weightEvaluate;

    /**
     * 身高
     */
    private String height;

    /**
     * 身高评价
     */
    private String heightEvaluate;

    /**
     * 身高体重评估
     */
    private String weightHeight;

    /**
     * 体格发育评价
     */
    private String physicalAssessment;

    /**
     * 头围
     */
    private String headCircumference;

    /**
     * 面色
     */
    private String complexion;

    /**
     * 面色其他
     */
    private String complexionOther;

    /**
     * 皮肤
     */
    private String skin;

    /**
     * 
     */
    private String skinOther;

    /**
     * 前囱宽
     */
    private String anteriorFontanelleWide;

    /**
     * 前囱高
     */
    private String anteriorFontanelleHigh;

    /**
     * 前囱状态
     */
    private String anteriorFontanelle;

    /**
     * 颈部包块
     */
    private String neckMass;

    /**
     * 眼睛是否异常
     */
    private String eye;

    /**
     * 
     */
    private String eyeOther;

    /**
     * 视力
     */
    private String vision;

    /**
     * 耳外观
     */
    private String ear;

    /**
     * 
     */
    private String earOther;

    /**
     * 听力
     */
    private String hearing;

    /**
     * 口腔
     */
    private String oralCavity;

    /**
     * 
     */
    private String cavityOther;

    /**
     * 出牙数
     */
    private Integer teethingNum;

    /**
     * 龋齿数
     */
    private Integer cariesNum;

    /**
     * 胸部
     */
    private String breast;

    /**
     * 
     */
    private String breastOther;

    /**
     * 腹部
     */
    private String abdominal;

    /**
     * 
     */
    private String abdominalOther;

    /**
     * 脐部
     */
    private String umbilicalCord;

    /**
     * 
     */
    private String umbilicalOther;

    /**
     * 四肢
     */
    private String extremity;

    /**
     * 
     */
    private String extremityOther;

    /**
     * 步态
     */
    private String gait;

    /**
     * 可疑佝偻病症状
     */
    private String ricketsSymptom;

    /**
     * 可疑佝偻病体征
     */
    private String ricketsSign;

    /**
     * 肛门
     */
    private String anus;

    /**
     * 
     */
    private String anusOther;

    /**
     * 血红蛋白值
     */
    private String hemoglobin;

    /**
     * 其他
     */
    private String other;

    /**
     * 户外活动时间
     */
    private String outdoorTime;

    /**
     * 维生素D名称
     */
    private String vitamindName;

    /**
     * 维生素D数量
     */
    private String vitamindNum;

    /**
     * 评估结果
     */
    private String growthResult;

    /**
     * 发育评估
     */
    private String growth;

    /**
     * 患病情况
     */
    private String sickenStasus;

    /**
     * 肺炎次数
     */
    private Integer pneumoniaNum;

    /**
     * 腹泻次数
     */
    private Integer diarrheaNum;

    /**
     * 外伤次数
     */
    private Integer traumaNum;

    /**
     * 患病其他
     */
    private String sickenOther;

    /**
     * 是否转诊
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
     * 指导
     */
    private String guidance;

    /**
     * 指导其他
     */
    private String guidanceOther;

    /**
     * 下次随访日期
     */
    private String nextVisitDate;

    /**
     * 随方医生签名
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
     * children_health_record
     */
    private static final long serialVersionUID = 1L;

}