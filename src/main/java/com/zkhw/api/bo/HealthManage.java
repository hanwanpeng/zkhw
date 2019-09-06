package com.zkhw.api.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HealthManage extends BaseBo{

	private String id;
	
	//体检分类
	private String checkFlag;
	
	//健康档案id
	private String archiveId;
	
	//体检日期
	private String checkdate;
	
	//责任医生
	private String dutydoctor;
	
	//症状
	private String symptom;
	
	//其他症状
	private String symptom_other;
	
	//体温(℃)
	private String heat;
	
	//脉率（次/分钟）
	private String cardiotach_ometer;
	
	//呼吸频率（次/分钟）
	private Integer breath_count;
	
	//血压(左侧舒张压)
	private Integer leftdbp;
	
	//血压(左侧收缩压)
	private Integer leftsbp;
	
	//血压(右侧舒张压)
	private Integer rightdbp;
	
	//血压(右侧收缩压)
	private Integer rightsbp;
	
	//身高（cm）
	private String height;
	
	//体重（kg）
	private String weight;
	
	//腰围(cm)
	private String waistline;
	
	//体质指数(kg/㎡)
	private String bmi;
	
	//老年人健康状态自我评估
	private String healthstate;
	
	//老年人生活自理能力自我评估
	private String livingstate;
	
	//自理能力评估id
	private String assessId;
	
	//老年人认知功能
	private String oldkown;
	
	//智检总分
	private Integer oldkown_fee;
	
	//老年人情感状态
	private String oldfeeling;
	
	//抑郁评分
	private Integer oldfeeling_fee;
	
	//锻炼频率
	private String exercise_frequency;
	
	//每次锻炼时间（分钟）
	private Integer exercise_timeslice;
	
	//坚持锻炼时间（年）
	private Integer persisttime;
	
	//锻炼方式
	private String exercise_method;
	
	//饮食习惯
	private String eat_habit;
	
	//吸烟状况
	private String smoke_frequency;
	
	//日吸烟量（支）
	private Integer smoke_count_day;
	
	//开始吸烟年龄（岁）
	private Integer smoke_start_age;
	
	//戒烟年龄（岁）
	private Integer smoke_end_age;
	
	//饮酒频率
	private String wine_frequency;
	
	//日饮酒量（两）
	private Integer wine_count;
	
	//是否戒酒
	private String wine_refrain;
	
	//戒酒年龄（岁）
	private Integer wine_refrain_age;
	
	//开始饮酒年龄（岁）
	private Integer wine_start_age;
	
	//近一年是否曾醉酒
	private String isstoned;
	
	//饮酒种类
	private String wine_type;
	
	//其它饮酒种类
	private String wine_other;
	
	//有无职业暴露
	private String undress;
	
	//职业
	private String undress_work;
	
	//从业时间（年）
	private Integer undress_worktime;
	
	//口唇
	private String lip;
	
	//齿列
	private String tooth;
	
	//缺齿-左上
	private String toothless_top;
	
	//缺齿-右下
	private String toothless_down;
	
	//缺齿-左下
	private String toothless_left;
	
	//缺齿-右上
	private String toothless_right;
	
	//龋齿-左上
	private String decayedtooth_top;
	
	//龋齿-右下
	private String decayedtooth_down;
	
	//龋齿-左下
	private String decayedtooth_left;
	
	//龋齿-右上
	private String decayedtooth_right;
	
	//义齿（假牙）-左上
	private String falsetooth_top;
	
	//义齿（假牙）-右下
	private String falsetooth_down;
	
	//义齿（假牙）-左下
	private String falsetooth_left;
	
	//义齿（假牙）-右上
	private String falsetooth_right;
	
	//咽部
	private String yanbu;
	
	//祼眼视力（左）
	private String eye_nakedness_left;
	
	//祼眼视力（右）
	private String eye_nakedness_right;
	
	//矫正视力（左）
	private String eye_remedy_left;
	
	//矫正视力（右）
	private String eye_remedy_right;
	
	//听力
	private String audition;
	
	//运动功能
	private String sport_fun;
	
	//眼底
	private String fundus;
	
	//眼底异常说明
	private String fundus_other;
	
	//皮肤
	private String skin;
	
	//皮肤_其它
	private String skin_other;
	
	//巩膜
	private String sclera;
	
	//巩膜_其它
	private String sclera_other;
	
	//淋巴结
	private String lymph;
	
	//淋巴结_其它
	private String lymph_other;
	
	//桶状胸
	private String barrel_chest;
	
	//呼吸音
	private String breathing;
	
	//呼吸音异常说明
	private String breathing_other;
	
	//罗音
	private String rales;
	
	//罗音_其它
	private String rales_other;
	
	//心率(次/分钟)
	private Integer heart_rate;
	
	//心律
	private Integer rhythm;
	
	//杂音
	private String noise;
	
	//杂音说明
	private String noise_memo;
	
	//压痛
	private String tenderness;
	
	//压痛说明
	private String tenderness_memo;
	
	//包块
	private String mass;
	
	//包块说明
	private String mass_memo;
	
	//肝大
	private String liver;
	
	//肝大说明
	private String liver_memo;
	
	//脾大
	private String spleen;
	
	//脾大说明
	private String spleen_memo;
	
	//移动性浊音
	private String dullness;
	
	//移动性浊音说明
	private String dullness_memo;
	
	//下肢水肿
	private String edema;
	
	//足背动脉搏动
	private String dorsal;
	
	//肛门指诊
	private String dre;
	
	//肛门指诊_其它
	private String dre_memo;
	
	//乳腺
	private String breast;
	
	//乳腺_其它
	private String breast_memo;
	
	//外阴
	private String vulva;
	
	//外阴异常说明
	private String vulva_memo;
	
	//阴道
	private String vaginal;
	
	//阴道异常说明
	private String vaginal_memo;
	
	//宫颈
	private String cervixed;
	
	//宫颈异常说明
	private String cervix_memo;
	
	//宫体
	private String palace;
	
	//宫体异常说明
	private String palace_memo;
	
	//附件
	private String attachment;
	
	//附件异常说明
	private String attachment_memo;
	
	//其它查体
	private String examination_memo;
	
	//血红蛋白（g/l）
	private String hemoglobined;
	
	//白细胞（×10<sup>9</sup> /l）
	private String leukocyte;
	
	//血小板（×10<sup>9</sup>/l）
	private String platelet;
	
	//血常规其它
	private String blood_memo;
	
	//尿蛋白
	private String urinary_protein;
	
	//尿糖
	private String urine;
	
	//尿酮体
	private String ketone;
	
	//尿潜血
	private String occult_blood;
	
	//尿常规其它
	private String urine_memo;
	
	//空腹血糖（mmol/l）
	private String bsugar_mmo;
	
	//空腹血糖（mg/dl）
	private String bsugar_mg;
	
	//心电图
	private String ecg;
	
	//心电图异常说明
	private String ecg_memo;
	
	//尿微量白蛋白（mg/dl）
	private String urinary_albumin;
	
	//大便潜血
	private String occult_blooded;
	
	//糖化血红蛋白(%)
	private String hemoglobin;
	
	//乙型肝炎表面抗原
	private String hbeag;
	
	//血清谷丙转氨酶(u/l)
	private String alt;
	
	//血清谷草转氨酶(u/l)
	private String ast;
	
	//白蛋白(g/l)
	private String albumin;
	
	//总胆红素(μmol/l)
	private String bilirubin_total;
	
	//结合胆红素(μmol/l)
	private String bilirubin_combine;
	
	//血清肌酐(μmol/l)
	private String scr;
	
	//血尿素氮(mmol/l)
	private String bun;
	
	//血钾浓度(mmol/l)
	private String potassium;
	
	//血钠浓度(mmol/l)
	private String serum_sodium;
	
	//总胆固醇(mmol/l)
	private String cholesterol;
	
	//甘油三酯(mmol/l)
	private String triglycerides;
	
	//血清低密度脂蛋白胆固醇(mmol/l)
	private String h_cholesterol;
	
	//血清高密度脂蛋白胆固醇(mmol/l)
	private String l_cholesterol;
	
	//胸部x线片
	private String xray;
	
	//胸部x线片异常说明
	private String xray_memo;
	
	//B超
	private String bultrasound;
	
	//B超异常说明
	private String bultrasound_memo;
	
	//其他B超
	private String bsound;
	
	//其他B超异常说明
	private String bsound_memo;
	
	//宫颈涂片
	private String cervix;
	
	//宫颈涂片异常说明
	private String cervix_Explain;
	
	//其它辅助检查
	private String check_other;
	
	//平和质
	private String physique_phz;
	
	//气虚质
	private String physique_qxz;
	
	//阳虚质
	private String physique_yangxz;
	
	//阴虚质
	private String physique_yinxz;
	
	//痰湿质
	private String physique_tsz;
	
	//湿热质
	private String physique_srz;
	
	//血瘀质
	private String physique_xyz;
	
	//气郁质
	private String physique_qyz;
	
	//特秉质
	private String physique_tbz;
	
	//脑血管疾病
	private String cerebrovascular;
	
	//其它脑血管疾病
	private String cerebrovascular_memo;
	
	//肾脏疾病
	private String kidney;
	
	//其它肾脏疾病
	private String kidney_other;
	
	//心脏疾病
	private String heartdis;
	
	//其它心脏疾病
	private String heartdis_other;
	
	//血管疾病
	private String blooddis;
	
	//其它血管疾病
	private String blooddis_other;
	
	//眼部疾病
	private String eysdis;
	
	//其它眼部疾病
	private String eysdis_other;
	
	//神经系统疾病
	private String nervousdis;
	
	//神经系统疾病说明
	private String nervousdis_memo;
	
	//有无其他系统疾病
	private String hasotherdis;
	
	//其他系统疾病说明
	private String otherdismemo;
	
	//体检有无异常
	private String checkresult;
	
	//健康评价
	private String healthesti;
	
	//健康指导
	private String healthguide;
	
	//危险因素控制
	private String dangercontrol;
	
	//减体重目标
	private String weighttarget;
	
	//建议接种疫苗
	private String advisebacterin;
	
	//其它危险因素控制
	private String otherdanger;
	
	//健康建议
	private String healthadvice;
	
	//粉尘
	private String fenchen;
	
	//粉尘描述
	private String fenchen_memo;
	
	//粉尘防护措施
	private String fenchen_val;
	
	//放射
	private String fangshe;
	
	//放射描述
	private String fangshe_memo;
	
	//放射防护措施
	private String fangshe_val;
	
	//物理
	private String wuli;
	
	//物理描述
	private String wuli_memo;
	
	//物理防护措施
	private String wuli_val;
	
	//化学
	private String huaxue;
	
	//化学描述
	private String huaxue_memo;
	
	//化学防护措施
	private String huaxue_val;
	
	//毒物其他
	private String duwu_qita;
	
	//毒物其他描述
	private String duwu_qita_memo;
	
	//毒物其他防护措施
	private String duwu_qita_val;
	
	private String zhuyuan_a_binganhao;
	
	private String zhuyuan_a_time;
	
	private String zhuyuan_a_yiliao;
	
	private String zhuyuan_a_yuanyin;
	
	private String zhuyuan_b_binganhao;
	
	private String zhuyuan_b_time;
	
	private String zhuyuan_b_yiliao;
	
	private String zhuyuan_b_yuanyin;	
	
	private String jiating_a_binganhao;
	
	private String jiating_a_time;
	
	private String jiating_a_yiliao;
	
	private String jiating_a_yuanyin;
	
	private String jiating_b_binganhao;
	
	private String jiating_b_time;
	
	private String jiating_b_yiliao;
	
	private String jiating_b_yuanyin;	
	
	private String UUID;
}
