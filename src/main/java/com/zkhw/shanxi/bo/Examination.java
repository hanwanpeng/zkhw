package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Setter;

@XmlRootElement(name = "ObjectInstance")
@Setter
public class Examination extends ExaminationObject {

	@XmlAttribute(name = "name")
	private String name = "EHR_Arch_HealthCheck";

	@XmlAttribute(name = "id")
	private String id;

	// 检查分类 SX0356
	@XmlElement(name = "Attribute")
	private BaseElement checkFlag;

	// 健康档案ID
	@XmlElement(name = "Attribute")
	private BaseElement archiveId;

	// 检查日期
	@XmlElement(name = "Attribute")
	private BaseElement checkdate;

	// 责任医生
	@XmlElement(name = "Attribute")
	private BaseElement dutydoctor;

	// 症状 CV5101.27
	@XmlElement(name = "Attribute")
	private BaseElement symptom;

	// 其他症状
	@XmlElement(name = "Attribute")
	private BaseElement symptom_other;

	// 体温(℃)
	@XmlElement(name = "Attribute")
	private BaseElement heat;

	// 脉率（次/分钟）
	@XmlElement(name = "Attribute")
	private BaseElement cardiotach_ometer;

	// 呼吸频率（次/分钟）
	@XmlElement(name = "Attribute")
	private BaseElement breath_count;

	// 血压(左侧舒张压)
	@XmlElement(name = "Attribute")
	private BaseElement leftdbp;

	// 血压(左侧收缩压)
	@XmlElement(name = "Attribute")
	private BaseElement leftsbp;

	// 血压(右侧舒张压)
	@XmlElement(name = "Attribute")
	private BaseElement rightdbp;

	// 血压(右侧收缩压)
	@XmlElement(name = "Attribute")
	private BaseElement rightsbp;

	// 身高（cm）
	@XmlElement(name = "Attribute")
	private BaseElement height;

	// 体重（kg）
	@XmlElement(name = "Attribute")
	private BaseElement weight;

	// 腰围(cm)
	@XmlElement(name = "Attribute")
	private BaseElement waistline;

	// 体质指数(kg/㎡)
	@XmlElement(name = "Attribute")
	private BaseElement bmi;

	// 老年人健康状态自我评估 SX0009
	@XmlElement(name = "Attribute")
	private BaseElement healthstate;

	// 老年人生活自理能力自我评估 SX0010
	@XmlElement(name = "Attribute")
	private BaseElement livingstate;

	// 自理能力评估id
	@XmlElement(name = "Attribute")
	private BaseElement assessId;

	// 老年人认知功能 SX0078
	@XmlElement(name = "Attribute")
	private BaseElement oldkown;

	// 智检总分
	@XmlElement(name = "Attribute")
	private BaseElement oldkown_fee;

	// 老年人情感状态 SX0078
	@XmlElement(name = "Attribute")
	private BaseElement oldfeeling;

	// 抑郁评分
	@XmlElement(name = "Attribute")
	private BaseElement oldfeeling_fee;

	// 锻炼频率 CV5101.28
	@XmlElement(name = "Attribute")
	private BaseElement exercise_frequency;

	// 每次锻炼时间（分钟）
	@XmlElement(name = "Attribute")
	private BaseElement exercise_timeslice;

	// 坚持锻炼时间（年）
	@XmlElement(name = "Attribute")
	private BaseElement persisttime;

	// 锻炼方式
	@XmlElement(name = "Attribute")
	private BaseElement exercise_method;

	// 饮食习惯 CV5101.29
	@XmlElement(name = "Attribute")
	private BaseElement eat_habit;

	// 吸烟状况 SX0079
	@XmlElement(name = "Attribute")
	private BaseElement smoke_frequency;

	// 日吸烟量（支）
	@XmlElement(name = "Attribute")
	private BaseElement smoke_count_day;

	// 开始吸烟年龄（岁）
	@XmlElement(name = "Attribute")
	private BaseElement smoke_start_age;

	// 戒烟年龄（岁）
	@XmlElement(name = "Attribute")
	private BaseElement smoke_end_age;

	// 饮酒频率 SX0080
	@XmlElement(name = "Attribute")
	private BaseElement wine_frequency;

	// 日饮酒量（两）
	@XmlElement(name = "Attribute")
	private BaseElement wine_count;

	// 是否戒酒 SX0081
	@XmlElement(name = "Attribute")
	private BaseElement wine_refrain;

	// 戒酒年龄（岁）
	@XmlElement(name = "Attribute")
	private BaseElement wine_refrain_age;

	// 开始饮酒年龄（岁）
	@XmlElement(name = "Attribute")
	private BaseElement wine_start_age;

	// 近一年是否曾醉酒 SX0083
	@XmlElement(name = "Attribute")
	private BaseElement isstoned;

	// 饮酒种类 CV5305.02
	@XmlElement(name = "Attribute")
	private BaseElement wine_type;

	// 其它饮酒种类
	@XmlElement(name = "Attribute")
	private BaseElement wine_other;

	// 有无职业暴露 SX0087
	@XmlElement(name = "Attribute")
	private BaseElement undress;

	// 职业
	@XmlElement(name = "Attribute")
	private BaseElement undress_work;

	// 从业时间（年）
	@XmlElement(name = "Attribute")
	private BaseElement undress_worktime;

	// 口唇 CV5102.12
	@XmlElement(name = "Attribute")
	private BaseElement lip;

	// 齿列 CV5102.13
	@XmlElement(name = "Attribute")
	private BaseElement tooth;

	// 缺齿-左上
	@XmlElement(name = "Attribute")
	private BaseElement toothless_top;

	// 缺齿-右下
	@XmlElement(name = "Attribute")
	private BaseElement toothless_down;

	// 缺齿-左下
	@XmlElement(name = "Attribute")
	private BaseElement toothless_left;

	// 缺齿-右上
	@XmlElement(name = "Attribute")
	private BaseElement toothless_right;

	// 龋齿-左上
	@XmlElement(name = "Attribute")
	private BaseElement decayedtooth_top;

	// 龋齿-右下
	@XmlElement(name = "Attribute")
	private BaseElement decayedtooth_down;

	// 龋齿-左下
	@XmlElement(name = "Attribute")
	private BaseElement decayedtooth_left;

	// 龋齿-右上
	@XmlElement(name = "Attribute")
	private BaseElement decayedtooth_right;

	// 义齿（假牙）-左上
	@XmlElement(name = "Attribute")
	private BaseElement falsetooth_top;

	// 义齿（假牙）-右下
	@XmlElement(name="Attribute")
	private BaseElement falsetooth_down;

	// 义齿（假牙）-左下
	@XmlElement(name="Attribute")
	private BaseElement falsetooth_left;

	// 义齿（假牙）-右上
	@XmlElement(name="Attribute")
	private BaseElement falsetooth_right;

	// 咽部 SX0015
	@XmlElement(name="Attribute")
	private BaseElement yanbu;

	// 祼眼视力（左）
	@XmlElement(name="Attribute")
	private BaseElement eye_nakedness_left;

	// 祼眼视力（右）
	@XmlElement(name="Attribute")
	private BaseElement eye_nakedness_right;

	// 矫正视力（左）
	@XmlElement(name="Attribute")
	private BaseElement eye_remedy_left;

	// 矫正视力（右）
	@XmlElement(name="Attribute")
	private BaseElement eye_remedy_right;

	// 听力 SX0016
	@XmlElement(name="Attribute")
	private BaseElement audition;

	// 运动功能 SX0017
	@XmlElement(name="Attribute")
	private BaseElement sport_fun;

	// 眼底 SX0084
	@XmlElement(name="Attribute")
	private BaseElement fundus;

	// 眼底异常说明
	@XmlElement(name="Attribute")
	private BaseElement fundus_other;

	// 皮肤 CV5102.11
	@XmlElement(name="Attribute")
	private BaseElement skin;

	// 皮肤_其它
	@XmlElement(name="Attribute")
	private BaseElement skin_other;

	// 巩膜 SX0089
	@XmlElement(name="Attribute")
	private BaseElement sclera;

	// 巩膜_其它
	@XmlElement(name="Attribute")
	private BaseElement sclera_other;

	// 淋巴结 CV5102.17
	@XmlElement(name="Attribute")
	private BaseElement lymph;

	// 淋巴结_其它
	@XmlElement(name="Attribute")
	private BaseElement lymph_other;

	// 桶状胸 SX0083
	@XmlElement(name="Attribute")
	private BaseElement barrel_chest;

	@XmlElement(name="Attribute")
	private BaseElement breathing; // 呼吸音 SX0084

	@XmlElement(name="Attribute")
	private BaseElement breathing_other; // 呼吸音异常说明

	@XmlElement(name="Attribute")
	private BaseElement rales; // 罗音 SX0018

	@XmlElement(name="Attribute")
	private BaseElement rales_other; // 罗音_其它

	@XmlElement(name="Attribute")
	private BaseElement heart_rate; // 心率(次/分钟)

	@XmlElement(name="Attribute")
	private BaseElement rhythm; // 心律 SX0019

	@XmlElement(name="Attribute")
	private BaseElement noise; // 杂音 SX0087

	@XmlElement(name="Attribute")
	private BaseElement noise_memo; // 杂音说明

	@XmlElement(name="Attribute")
	private BaseElement tenderness; // 压痛 SX0087

	@XmlElement(name="Attribute")
	private BaseElement tenderness_memo; // 压痛说明

	@XmlElement(name="Attribute")
	private BaseElement mass; // 包块 SX0087

	@XmlElement(name="Attribute")
	private BaseElement mass_memo; // 包块说明

	@XmlElement(name="Attribute")
	private BaseElement liver; // 肝大SX0087

	@XmlElement(name="Attribute")
	private BaseElement liver_memo; // 肝大说明

	@XmlElement(name="Attribute")
	private BaseElement spleen; // 脾大SX0087

	@XmlElement(name="Attribute")
	private BaseElement spleen_memo; // 脾大说明

	@XmlElement(name="Attribute")
	private BaseElement dullness; // 移动性浊音SX0087

	@XmlElement(name="Attribute")
	private BaseElement dullness_memo; // 移动性浊音说明

	@XmlElement(name="Attribute")
	private BaseElement edema; // 下肢水肿CV5102.18

	@XmlElement(name="Attribute")
	private BaseElement dorsal; // 足背动脉搏动SX0020

	@XmlElement(name="Attribute")
	private BaseElement dre; // 肛门指诊SX0021

	@XmlElement(name="Attribute")
	private BaseElement dre_memo; // 肛门指诊_其它

	@XmlElement(name="Attribute")
	private BaseElement breast; // 乳腺 CV5102.03

	@XmlElement(name="Attribute")
	private BaseElement breast_memo; // 乳腺_其它

	@XmlElement(name="Attribute")
	private BaseElement vulva; // 外阴SX0086

	@XmlElement(name="Attribute")
	private BaseElement vulva_memo; // 外阴异常说明

	@XmlElement(name="Attribute")
	private BaseElement vaginal; // 阴道SX0086

	@XmlElement(name="Attribute")
	private BaseElement vaginal_memo; // 阴道异常说明

	@XmlElement(name="Attribute")
	private BaseElement cervixed; // 宫颈 SX0086

	@XmlElement(name="Attribute")
	private BaseElement cervix_memo; // 宫颈异常说明

	@XmlElement(name="Attribute")
	private BaseElement palace; // 宫体 SX0086

	@XmlElement(name="Attribute")
	private BaseElement palace_memo; // 宫体异常说明

	@XmlElement(name="Attribute")
	private BaseElement attachment; // 附件 SX0086

	@XmlElement(name="Attribute")
	private BaseElement attachment_memo; // 附件异常说明

	@XmlElement(name="Attribute")
	private BaseElement examination_memo; // 其它查体

	@XmlElement(name="Attribute")
	private BaseElement hemoglobined; // 血红蛋白（g/l）

	@XmlElement(name="Attribute")
	private BaseElement leukocyte; // 白细胞（×10<sup>9</sup> /l）

	@XmlElement(name="Attribute")
	private BaseElement platelet; // 血小板（×10<sup>9</sup>/l）

	@XmlElement(name="Attribute")
	private BaseElement blood_memo; // 血常规其它

	@XmlElement(name="Attribute")
	private BaseElement urinary_protein; // 尿蛋白 SX0186

	@XmlElement(name="Attribute")
	private BaseElement urine; // 尿糖 SX0186

	@XmlElement(name="Attribute")
	private BaseElement ketone; // 尿酮体 SX0186

	@XmlElement(name="Attribute")
	private BaseElement occult_blood; // 尿潜血 SX0186

	@XmlElement(name="Attribute")
	private BaseElement urine_memo; // 尿常规其它

	@XmlElement(name="Attribute")
	private BaseElement bsugar_mmo; // 空腹血糖（mmol/l）

	@XmlElement(name="Attribute")
	private BaseElement bsugar_mg; // 空腹血糖（mg/dl）

	@XmlElement(name="Attribute")
	private BaseElement ecg; // 心电图 SX0084

	@XmlElement(name="Attribute")
	private BaseElement ecg_memo; // 心电图异常说明

	@XmlElement(name="Attribute")
	private BaseElement urinary_albumin; // 尿微量白蛋白（mg/dl）

	@XmlElement(name="Attribute")
	private BaseElement occult_blooded; // 大便潜血 SX0085

	@XmlElement(name="Attribute")
	private BaseElement hemoglobin; // 糖化血红蛋白(%)

	@XmlElement(name="Attribute")
	private BaseElement hbeag; // 乙型肝炎表面抗原 SX0085

	@XmlElement(name="Attribute")
	private BaseElement alt; // 血清谷丙转氨酶(u/l)

	@XmlElement(name="Attribute")
	private BaseElement ast; // 血清谷草转氨酶(u/l)

	@XmlElement(name="Attribute")
	private BaseElement albumin; // 白蛋白(g/l)

	@XmlElement(name="Attribute")	
	private BaseElement bilirubin_total; // 总胆红素(μmol/l)

	@XmlElement(name="Attribute")
	private BaseElement bilirubin_combine; // 结合胆红素(μmol/l)

	@XmlElement(name="Attribute")
	private BaseElement scr; // 血清肌酐(μmol/l)

	@XmlElement(name="Attribute")
	private BaseElement bun; // 血尿素氮(mmol/l)

	@XmlElement(name="Attribute")
	private BaseElement potassium; // 血钾浓度(mmol/l)

	@XmlElement(name="Attribute")
	private BaseElement serum_sodium; // 血钠浓度(mmol/l)

	@XmlElement(name="Attribute")
	private BaseElement cholesterol; // 总胆固醇(mmol/l)

	@XmlElement(name="Attribute")
	private BaseElement triglycerides; // 甘油三酯(mmol/l)

	@XmlElement(name="Attribute")
	private BaseElement h_cholesterol; // 血清低密度脂蛋白胆固醇(mmol/l)

	@XmlElement(name="Attribute")
	private BaseElement l_cholesterol; // 血清高密度脂蛋白胆固醇(mmol/l)

	@XmlElement(name="Attribute")
	private BaseElement xray; // 胸部x线片 SX0084

	@XmlElement(name="Attribute")
	private BaseElement xray_memo; // 胸部x线片异常说明

	@XmlElement(name="Attribute")
	private BaseElement bultrasound; // B超 SX0084

	@XmlElement(name="Attribute")
	private BaseElement bultrasound_memo; // B超异常说明

	@XmlElement(name="Attribute")
	private BaseElement bsound; // 其他B超 SX0084

	@XmlElement(name="Attribute")
	private BaseElement bsound_memo; // 其他B超异常说明

	@XmlElement(name="Attribute")
	private BaseElement cervix; // 宫颈涂片 SX0084

	@XmlElement(name="Attribute")
	private BaseElement cervix_Explain; // 宫颈涂片异常说明

	@XmlElement(name="Attribute")
	private BaseElement check_other; // 其它辅助检查

	@XmlElement(name="Attribute")
	private BaseElement physique_phz; // 平和质 SX0088

	@XmlElement(name="Attribute")
	private BaseElement physique_qxz; // 气虚质 SX0088

	@XmlElement(name="Attribute")
	private BaseElement physique_yangxz; // 阳虚质 SX0088

	@XmlElement(name="Attribute")
	private BaseElement physique_yinxz; // 阴虚质 SX0088

	@XmlElement(name="Attribute")
	private BaseElement physique_tsz; // 痰湿质 SX0088

	@XmlElement(name="Attribute")
	private BaseElement physique_srz; // 湿热质 SX0088

	@XmlElement(name="Attribute")
	private BaseElement physique_xyz; // 血瘀质 SX0088

	@XmlElement(name="Attribute")
	private BaseElement physique_qyz; // 气郁质 SX0088

	@XmlElement(name="Attribute")
	private BaseElement physique_tbz; // 特秉质 SX0088

	@XmlElement(name="Attribute")
	private BaseElement cerebrovascular; // 脑血管疾病 SX0023

	@XmlElement(name="Attribute")
	private BaseElement cerebrovascular_memo; // 其它脑血管疾病

	@XmlElement(name="Attribute")
	private BaseElement kidney; // 肾脏疾病 SX0024

	@XmlElement(name="Attribute")
	private BaseElement kidney_other; // 其它肾脏疾病

	@XmlElement(name="Attribute")
	private BaseElement heartdis; // 心脏疾病 SX0025

	@XmlElement(name="Attribute")
	private BaseElement heartdis_other; // 其它心脏疾病

	@XmlElement(name="Attribute")
	private BaseElement blooddis; // 血管疾病 SX0026

	@XmlElement(name="Attribute")
	private BaseElement blooddis_other; // 其它血管疾病

	@XmlElement(name="Attribute")
	private BaseElement eysdis; // 眼部疾病 SX0027

	@XmlElement(name="Attribute")
	private BaseElement eysdis_other; // 其它眼部疾病

	@XmlElement(name="Attribute")
	private BaseElement nervousdis; // 神经系统疾病 SX0090

	@XmlElement(name="Attribute")
	private BaseElement nervousdis_memo; // 神经系统疾病说明

	@XmlElement(name="Attribute")
	private BaseElement hasotherdis; // 有无其他系统疾病 SX0090

	@XmlElement(name="Attribute")
	private BaseElement otherdismemo; // 其他系统疾病说明

	@XmlElement(name="Attribute")
	private BaseElement checkresult; // 体检有无异常 SX0087

	@XmlElement(name="Attribute")
	private BaseElement healthesti; // 健康评价

	@XmlElement(name="Attribute")
	private BaseElement healthguide; // 健康指导 SX0029

	@XmlElement(name="Attribute")
	private BaseElement dangercontrol; // 危险因素控制 SX0030

	@XmlElement(name="Attribute")
	private BaseElement weighttarget; // 减体重目标

	@XmlElement(name="Attribute")
	private BaseElement advisebacterin; // 建议接种疫苗
	
	@XmlElement(name="Attribute")
	private BaseElement otherdanger; // 其它危险因素控制

	@XmlElement(name = "Attribute")
	private BaseElement healthadvice; // 健康建议

	@XmlElement(name = "Attribute")
	private BaseElement duns; // 录入机构

}
