package com.zkhw.pub.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//体检表
public class PhysicalExamination implements Serializable {
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
     * 检查批次
     */
    private String batchNo;

    /**
     * 条形码
     */
    private String barCode;

    /**
     * 
     */
    private String checkFlag;

    /**
     * 责任医生
     */
    private String dutydoctor;

    /**
     * 症状
     */
    private String symptom;

    /**
     * 症状其他
     */
    private String symptomOther;

    /**
     * 检查日期
     */
    private String checkDate;

    /**
     * 体温
     */
    private String baseTemperature;

    /**
     * 脉搏
     */
    private String baseHeartbeat;

    /**
     * 呼吸频率
     */
    private String baseRespiratory;

    /**
     * 左血压高压
     */
    private Integer baseBloodPressureLeftHigh;

    /**
     * 左血压低压
     */
    private Integer baseBloodPressureLeftLow;

    /**
     * 右血压高压
     */
    private Integer baseBloodPressureRightHigh;

    /**
     * 右血压低压
     */
    private Integer baseBloodPressureRightLow;

    /**
     * 身高
     */
    private String baseHeight;

    /**
     * 体重
     */
    private String baseWeight;

    /**
     * 腰围
     */
    private String baseWaist;

    /**
     * 体质指数BMI
     */
    private String baseBmi;

    /**
     * 老年人健康状况自我评估
     */
    private String baseHealthEstimate;

    /**
     * 老年人生活自理能力自我评估
     */
    private String baseSelfcareEstimate;

    /**
     * 老年人认知功能
     */
    private String baseCognitionEstimate;

    /**
     * 智力状态得分
     */
    private String baseCognitionScore;

    /**
     * 老年人情感状态
     */
    private String baseFeelingEstimate;

    /**
     * 老年人抑郁评分
     */
    private String baseFeelingScore;

    /**
     * 处理医生
     */
    private String baseDoctor;

    /**
     * 锻炼频率
     */
    private String lifewayExerciseFrequency;

    /**
     * 每次锻炼时间
     */
    private String lifewayExerciseTime;

    /**
     * 坚持锻炼时间
     */
    private String lifewayExerciseYear;

    /**
     * 锻炼方式
     */
    private String lifewayExerciseType;

    /**
     * 饮食习惯
     */
    private String lifewayDiet;

    /**
     * 吸烟状况
     */
    private String lifewaySmokeStatus;

    /**
     * 日吸烟量
     */
    private String lifewaySmokeNumber;

    /**
     * 开始吸烟年龄
     */
    private String lifewaySmokeStartage;

    /**
     * 戒烟年龄
     */
    private String lifewaySmokeEndage;

    /**
     * 饮酒频率
     */
    private String lifewayDrinkStatus;

    /**
     * 日饮酒量
     */
    private String lifewayDrinkNumber;

    /**
     * 是否戒酒
     */
    private String lifewayDrinkStop;

    /**
     * 戒酒年龄
     */
    private String lifewayDrinkStopage;

    /**
     * 开始饮酒年龄
     */
    private String lifewayDrinkStartage;

    /**
     * 近一年内是否醉酒
     */
    private String lifewayDrinkOneyear;

    /**
     * 饮酒种类
     */
    private String lifewayDrinkType;

    /**
     * 饮酒种类其他
     */
    private String lifewayDrinkOther;

    /**
     * 是否有职业病危害接触
     */
    private String lifewayOccupationalDisease;

    /**
     * 工种
     */
    private String lifewayJob;

    /**
     * 从业时间
     */
    private String lifewayJobPeriod;

    /**
     * 毒物粉尘
     */
    private String lifewayHazardousDust;

    /**
     * 粉尘预防措施
     */
    private String lifewayDustPreventive;

    /**
     * 放射物质
     */
    private String lifewayHazardousRadiation;

    /**
     * 放射物质预防措施
     */
    private String lifewayRadiationPreventive;

    /**
     * 物理因素
     */
    private String lifewayHazardousPhysical;

    /**
     * 物理因素预防措施
     */
    private String lifewayPhysicalPreventive;

    /**
     * 化学物质
     */
    private String lifewayHazardousChemical;

    /**
     * 化学物质预防措施
     */
    private String lifewayChemicalPreventive;

    /**
     * 其他危险种类
     */
    private String lifewayHazardousOther;

    /**
     * 其他预防措施
     */
    private String lifewayOtherPreventive;

    /**
     * 处理医生
     */
    private String lifewayDoctor;

    /**
     * 口唇
     */
    private String organLips;

    /**
     * 齿列
     */
    private String organTooth;

    /**
     * 缺齿
     */
    private String organHypodontia;

    /**
     * 左上缺齿
     */
    private String organHypodontiaTopleft;

    /**
     * 右上缺齿
     */
    private String organHypodontiaTopright;

    /**
     * 左下缺齿
     */
    private String organHypodontiaBottomleft;

    /**
     * 右下缺齿
     */
    private String organHypodontiaBottomright;

    /**
     * 龋齿
     */
    private String organCaries;

    /**
     * 左上龋齿
     */
    private String organCariesTopleft;

    /**
     * 右上龋齿
     */
    private String organCariesTopright;

    /**
     * 左下龋齿
     */
    private String organCariesBottomleft;

    /**
     * 右下龋齿
     */
    private String organCariesBottomright;

    /**
     * 假牙
     */
    private String organDenture;

    /**
     * 左上假牙
     */
    private String organDentureTopleft;

    /**
     * 右上假牙
     */
    private String organDentureTopright;

    /**
     * 左下假牙
     */
    private String organDentureBottomleft;

    /**
     * 右下假牙
     */
    private String organDentureBottomright;

    /**
     * 咽喉
     */
    private String organGuttur;

    /**
     * 左眼视力
     */
    private String organVisionLeft;

    /**
     * 右眼视力
     */
    private String organVisionRight;

    /**
     * 左眼矫正视力
     */
    private String organCorrectedvisionLeft;

    /**
     * 右眼矫正视力
     */
    private String organCorrectedvisionRight;

    /**
     * 听力
     */
    private String organHearing;

    /**
     * 运动功能
     */
    private String organMovement;

    /**
     * 处理医生
     */
    private String organDoctor;

    /**
     * 眼底
     */
    private String examinationEye;

    /**
     * 眼底异常描述
     */
    private String examinationEyeOther;

    /**
     * 皮肤
     */
    private String examinationSkin;

    /**
     * 皮肤其他
     */
    private String examinationSkinOther;

    /**
     * 巩膜
     */
    private String examinationSclera;

    /**
     * 巩膜其他
     */
    private String examinationScleraOther;

    /**
     * 淋巴结
     */
    private String examinationLymph;

    /**
     * 淋巴结其他
     */
    private String examinationLymphOther;

    /**
     * 桶状胸
     */
    private String examinationBarrelChest;

    /**
     * 呼吸音
     */
    private String examinationBreathSounds;

    /**
     * 呼吸音异常描述
     */
    private String examinationBreathOther;

    /**
     * 罗音
     */
    private String examinationRale;

    /**
     * 罗音其他
     */
    private String examinationRaleOther;

    /**
     * 心率
     */
    private String examinationHeartRate;

    /**
     * 心律
     */
    private String examinationHeartRhythm;

    /**
     * 心脏杂音
     */
    private String examinationHeartNoise;

    /**
     * 杂音其他说明
     */
    private String examinationNoiseOther;

    /**
     * 腹部压痛
     */
    private String examinationAbdomenTenderness;

    /**
     * 腹部压痛描述
     */
    private String examinationTendernessMemo;

    /**
     * 包块
     */
    private String examinationAbdomenMass;

    /**
     * 包块描述
     */
    private String examinationMassMemo;

    /**
     * 腹部肝大
     */
    private String examinationAbdomenHepatomegaly;

    /**
     * 腹部肝大描述
     */
    private String examinationHepatomegalyMemo;

    /**
     * 腹部脾大
     */
    private String examinationAbdomenSplenomegaly;

    /**
     * 腹部脾大描述
     */
    private String examinationSplenomegalyMemo;

    /**
     * 移动性浊音
     */
    private String examinationAbdomenShiftingdullness;

    /**
     * 移动性浊音描述
     */
    private String examinationShiftingdullnessMemo;

    /**
     * 下肢水肿
     */
    private String examinationLowerextremityEdema;

    /**
     * 足背动脉搏动
     */
    private String examinationDorsalArtery;

    /**
     * 肛门指诊
     */
    private String examinationAnus;

    /**
     * 肛门指诊其他
     */
    private String examinationAnusOther;

    /**
     * 乳腺
     */
    private String examinationBreast;

    /**
     * 乳腺其他
     */
    private String examinationBreastOther;

    /**
     * 
     */
    private String examinationDoctor;

    /**
     * 妇科外阴
     */
    private String examinationWomanVulva;

    /**
     * 外阴异常描述
     */
    private String examinationVulvaMemo;

    /**
     * 妇科阴道
     */
    private String examinationWomanVagina;

    /**
     * 阴道异常描述
     */
    private String examinationVaginaMemo;

    /**
     * 妇科宫颈
     */
    private String examinationWomanCervix;

    /**
     * 宫颈异常描述
     */
    private String examinationCervixMemo;

    /**
     * 妇科宫体
     */
    private String examinationWomanCorpus;

    /**
     * 宫体异常描述
     */
    private String examinationCorpusMemo;

    /**
     * 妇科附件
     */
    private String examinationWomanAccessories;

    /**
     * 附件异常描述
     */
    private String examinationAccessoriesMemo;

    /**
     * 
     */
    private String examinationWomanDoctor;

    /**
     * 查体-其他
     */
    private String examinationOther;

    /**
     * 血红蛋白
     */
    private String bloodHemoglobin;

    /**
     * 白细胞
     */
    private String bloodLeukocyte;

    /**
     * 血小板
     */
    private String bloodPlatelet;

    /**
     * 血常规其他
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
     * 空腹血糖mol
     */
    private String bloodGlucoseMmol;

    /**
     * 空腹血糖mg
     */
    private String bloodGlucoseMg;

    /**
     * 心电图
     */
    private String cardiogram;

    /**
     * 心电图描述
     */
    private String cardiogramMemo;

    /**
     * 心电图图片地址
     */
    private String cardiogramImg;

    /**
     * 尿微量白蛋白
     */
    private String microalbuminuria;

    /**
     * 大便潜血
     */
    private String fob;

    /**
     * 糖化血红蛋白
     */
    private String glycosylatedHemoglobin;

    /**
     * 乙型肝炎表面抗原
     */
    private String hb;

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
     * 血钾浓度
     */
    private String bloodK;

    /**
     * 血钠浓度
     */
    private String bloodNa;

    /**
     * 总胆固醇
     */
    private String tc;

    /**
     * 甘油三酯
     */
    private String tg;

    /**
     * 血清低密度脂蛋白胆固醇
     */
    private String ldl;

    /**
     * 血清高密度脂蛋白胆固醇
     */
    private String hdl;

    /**
     * 胸部X线片
     */
    private String chestX;

    /**
     * X线片描述
     */
    private String xMemo;

    /**
     * 胸部X图片
     */
    private String chestxImg;

    /**
     * 腹部B超
     */
    private String ultrasoundAbdomen;

    /**
     * 腹部B超异常描述
     */
    private String ultrasoundMemo;

    /**
     * 腹部b超图片
     */
    private String abdomenbImg;

    /**
     * 其他B超
     */
    private String otherB;

    /**
     * 其他B超异常描述
     */
    private String otherbMemo;

    /**
     * 其他B超图片
     */
    private String otherbImg;

    /**
     * 宫颈涂片
     */
    private String cervicalSmear;

    /**
     * 宫颈涂片异常描述
     */
    private String cervicalSmearMemo;

    /**
     * 辅助检查-其他
     */
    private String other;

    /**
     * 脑血管疾病
     */
    private String cerebrovascularDisease;

    /**
     * 其他脑血管疾病
     */
    private String cerebrovascularDiseaseOther;

    /**
     * 肾脏疾病
     */
    private String kidneyDisease;

    /**
     * 肾脏疾病其他
     */
    private String kidneyDiseaseOther;

    /**
     * 心脏疾病
     */
    private String heartDisease;

    /**
     * 其他心脏疾病
     */
    private String heartDiseaseOther;

    /**
     * 血管疾病
     */
    private String vascularDisease;

    /**
     * 其他血管疾病
     */
    private String vascularDiseaseOther;

    /**
     * 眼部疾病
     */
    private String ocularDiseases;

    /**
     * 其他眼部疾病
     */
    private String ocularDiseasesOther;

    /**
     * 神经系统疾病
     */
    private String nervousSystemDisease;

    /**
     * 神经系统疾病描述
     */
    private String nervousDiseaseMemo;

    /**
     * 其他系统疾病
     */
    private String otherDisease;

    /**
     * 其他疾病描述
     */
    private String otherDiseaseMemo;

    /**
     * 健康评价
     */
    private String healthEvaluation;

    /**
     * 健康评价异常描述1
     */
    private String abnormal1;

    /**
     * 健康评价异常描述2
     */
    private String abnormal2;

    /**
     * 健康评价异常描述3
     */
    private String abnormal3;

    /**
     * 健康评价异常描述4
     */
    private String abnormal4;

    /**
     * 健康指导
     */
    private String healthGuidance;

    /**
     * 危险因素控制
     */
    private String dangerControlling;

    /**
     * 目标体重
     */
    private String targetWeight;

    /**
     * 建议接种疫苗
     */
    private String adviseBacterin;

    /**
     * 其他危险因素控制
     */
    private String dangerControllingOther;

    /**
     * 健康建议
     */
    private String healthAdvice;

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
     * physical_examination_record
     */
    private static final long serialVersionUID = 1L;

}