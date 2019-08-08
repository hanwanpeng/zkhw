package com.zkhw.flup.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//精神障碍者随访记录表
public class PsychosisFollowRecord implements Serializable {
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
     * 失访原因
     */
    private String missReason;

    /**
     * 失访原因其他
     */
    private String missReasonOther;

    /**
     * 死亡日期
     */
    private String dieDate;

    /**
     * 死亡原因
     */
    private String dieReason;

    /**
     * 躯体疾病
     */
    private String physicalDisease;

    /**
     * 死亡原因其他
     */
    private String dieReasonOther;

    /**
     * 危险性评估
     */
    private String fatalness;

    /**
     * 症状
     */
    private String symptom;

    /**
     * 症状其他
     */
    private String symptomOther;

    /**
     * 自知力
     */
    private String insight;

    /**
     * 睡眠状况
     */
    private String sleepStatus;

    /**
     * 饮食状况
     */
    private String dietaryStatus;

    /**
     * 个人生活自理
     */
    private String selfHelp;

    /**
     * 家务劳动
     */
    private String housework;

    /**
     * 生产劳动及工作
     */
    private String work;

    /**
     * 学习能力
     */
    private String learningAbility;

    /**
     * 社会人际交往
     */
    private String interpersonal;

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
     * 两次随访期间关锁情况
     */
    private String isolation;

    /**
     * 两次随访期间住院情况
     */
    private String hospitalizedStatus;

    /**
     * 末次出院日期
     */
    private String outHospitalDate;

    /**
     * 实验室检查
     */
    private String laboratoryExamination;

    /**
     * 用药依从性
     */
    private String compliance;

    /**
     * 用药不良反应
     */
    private String untowardEffect;

    /**
     * 不良反应信息
     */
    private String untowardEffectInfo;

    /**
     * 治疗效果
     */
    private String treatmentEffect;

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
     * 康复措施
     */
    private String rehabilitationMeasure;

    /**
     * 康复措施其他
     */
    private String rehabilitationMeasureOther;

    /**
     * 下次随访分类
     */
    private String nextVisitClassify;

    /**
     * 下次随访日期
     */
    private String nextVisitDate;

    /**
     * 
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
     * psychosis_follow_record
     */
    private static final long serialVersionUID = 1L;

}