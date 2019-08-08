package com.zkhw.flup.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//新生儿基本信息表
public class NeonatusInfo implements Serializable {
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
     * 性别
     */
    private String sex;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 家庭住址
     */
    private String homeAddress;

    /**
     * 父亲姓名
     */
    private String fatherName;

    /**
     * 父亲职业
     */
    private String fatherProfession;

    /**
     * 父亲电话
     */
    private String fatherPhone;

    /**
     * 父亲出生日期
     */
    private String fatherBirthday;

    /**
     * 母亲名字
     */
    private String motherName;

    /**
     * 母亲职业
     */
    private String motherProfession;

    /**
     * 母亲电话
     */
    private String motherPhone;

    /**
     * 母亲出生日期
     */
    private String motherBirthday;

    /**
     * 孕周
     */
    private Integer gestationalWeeks;

    /**
     * 妊娠期间患病情况
     */
    private String sickenStasus;

    /**
     * 患病其他
     */
    private String sickenOther;

    /**
     * 助产结构名称
     */
    private String midwifeOrg;

    /**
     * 出生情况
     */
    private String birthSituation;

    /**
     * 出生情况其他
     */
    private String birthOther;

    /**
     * 新生儿窒息
     */
    private String asphyxiaNeonatorum;

    /**
     * 窒息时间
     */
    private String asphyxiaTime;

    /**
     * 畸形
     */
    private String deformity;

    /**
     * 畸形其他
     */
    private String deformityOther;

    /**
     * 新生儿听力
     */
    private String hearing;

    /**
     * 新生儿疾病
     */
    private String disease;

    /**
     * 其他疾病
     */
    private String diseaseOther;

    /**
     * 出生体重
     */
    private String birthWeight;

    /**
     * 目前体重
     */
    private String weight;

    /**
     * 出生身高
     */
    private String birthHeight;

    /**
     * 喂养方式
     */
    private String feedingPatterns;

    /**
     * 吃奶次数
     */
    private Integer milkNum;

    /**
     * 吃奶量
     */
    private Integer milkIntake;

    /**
     * 呕吐
     */
    private String vomit;

    /**
     * 大便
     */
    private String shit;

    /**
     * 大便次数
     */
    private Integer defecationNum;

    /**
     * 体温
     */
    private String temperature;

    /**
     * 心率
     */
    private Integer heartRate;

    /**
     * 呼吸评率
     */
    private Integer breathingRate;

    /**
     * 面色
     */
    private String complexion;

    /**
     * 面色其他
     */
    private String complexionOther;

    /**
     * 黄疸部位
     */
    private String aurigo;

    /**
     * 黄疸其他部位
     */
    private String aurigoOther;

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
     * 前囱其他
     */
    private String anteriorFontanelleOther;

    /**
     * 眼睛是否异常
     */
    private String eye;

    /**
     * 四肢活动度
     */
    private String extremityMobility;

    /**
     * 耳外观
     */
    private String ear;

    /**
     * 颈部包块
     */
    private String neckMass;

    /**
     * 鼻子
     */
    private String nose;

    /**
     * 皮肤
     */
    private String skin;

    /**
     * 皮肤其他
     */
    private String skinOther;

    /**
     * 口腔
     */
    private String oralCavity;

    /**
     * 肛门
     */
    private String anus;

    /**
     * 心肺听诊
     */
    private String heartLung;

    /**
     * 胸部
     */
    private String breast;

    /**
     * 腹部触诊
     */
    private String abdominalTouch;

    /**
     * 脊柱
     */
    private String spine;

    /**
     * 外生殖器
     */
    private String aedea;

    /**
     * 脐带
     */
    private String umbilicalCord;

    /**
     * 脐带其他
     */
    private String umbilicalCordOther;

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
     * 指导
     */
    private String guidance;

    /**
     * 指导其他
     */
    private String guidanceOther;

    /**
     * 访问日期
     */
    private String visitDate;

    /**
     * 下次访问日期
     */
    private String nextVisitDate;

    /**
     * 下次访问地址
     */
    private String nextVisitAddress;

    /**
     * 随访医生签名
     */
    private String visitDoctor;

    /**
     * 省编码
     */
    private String provinceCode;

    /**
     * 省名称
     */
    private String provinceName;

    /**
     * 市编码
     */
    private String cityCode;

    /**
     * 市名称
     */
    private String cityName;

    /**
     * 县编码
     */
    private String countyCode;

    /**
     * 县名称
     */
    private String countyName;

    /**
     * 镇编码
     */
    private String townsCode;

    /**
     * 镇名称
     */
    private String townsName;

    /**
     * 
     */
    private String villageCode;

    /**
     * 
     */
    private String villageName;

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
     * neonatus_info
     */
    private static final long serialVersionUID = 1L;

}