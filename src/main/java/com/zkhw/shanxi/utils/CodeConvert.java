package com.zkhw.shanxi.utils;

public class CodeConvert {

	//症状
	public static String symptomConvert(String code){
		String name = "";
		if(code == null){
			return "";
		}
		switch (code) {
		case "1":
			name = "CV5101.27_28";
			break;
		case "2":
			name = "CV5101.27_1";
			break;
		case "3":
			name = "CV5101.27_2";
			break;
		case "4":
			name = "CV5101.27_3";
			break;
		case "5":
			name = "CV5101.27_4";
			break;
		case "6":
			name = "CV5101.27_5";
			break;
		case "7":
			name = "CV5101.27_6";	
			break;
		case "8":
			name = "CV5101.27_7";	
			break;
		case "9":
			name = "CV5101.27_8";	
			break;
		case "10":
			name = "CV5101.27_9";
			break;
		case "11":
			name = "CV5101.27_10";	
			break;
		case "12":
			name = "CV5101.27_11";				
			break;	
		case "13":
			name = "CV5101.27_12";				
			break;	
		case "14":
			name = "CV5101.27_13";				
			break;	
		case "15":
			name = "CV5101.27_14";	
			break;
		case "16":
			name = "CV5101.27_15";					
			break;	
		case "17":
			name = "CV5101.27_29";	
			break;	
		case "18":
			name = "CV5101.27_17";
			break;	
		case "19":
			name = "CV5101.27_18";	
			break;	
		case "20":
			name = "CV5101.27_19";
			break;	
		case "21":
			name = "CV5101.27_20";				
			break;	
		case "22":
			name = "CV5101.27_21";				
			break;
		case "23":
			name = "CV5101.27_22";				
			break;
		case "24":
			name = "CV5101.27_30";				
			break;
		case "25":
			name = "CV5101.27_99";				
			break;				
		default:
			break;
		}
		return name;
	}
	
	//生活自理
	public static String selfCareConvert(String code){
		String name = "";
		if(code == null){
			return "";
		}
		switch (code) {
		case "1":
			name = "SX0010_1";
			break;
		case "2":
			name = "SX0010_2";
			break;
		case "3":
			name = "SX0010_3";
			break;
		case "4":
			name = "SX0010_4";
			break;			
		default:
			break;
		}
		return name;
	}
	
	//生活自理
	public static String healthEstimateConvert(String code){
		String name = "";
		if(code == null){
			return "";
		}
		switch (code) {
		case "1":
			name = "SX0009_1";
			break;
		case "2":
			name = "SX0009_2";
			break;
		case "3":
			name = "SX0009_3";
			break;
		case "4":
			name = "SX0009_4";
			break;
		case "5":
			name = "SX0009_5";
			break;				
		default:
			break;
		}
		return name;
	}	
	
	//老年人认知功能,情感状态
	public static String cognitionEstimateConvert(String code){
		String name = "";
		if(code == null){
			return "";
		}
		switch (code) {
		case "1":
			name = "SX0078_1";
			break;
		case "2":
			name = "SX0078_1";
			break;			
		default:
			break;
		}
		return name;
	}
	
	//锻炼频率
	public static String exerciseFrequencyConvert(String code){
		String name = "";
		if(code == null){
			return "";
		}
		switch (code) {
		case "1":
			name = "CV5101.28_1";
			break;
		case "2":
			name = "CV5101.28_2";
			break;
		case "3":
			name = "CV5101.28_2";
			break;
		case "4":
			name = "CV5101.28_4";
			break;				
		default:
			break;
		}
		return name;
	}
	
	//饮食习惯
	public static String eatingConvert(String code){
		String name = "";
		if(code == null){
			return "";
		}
		switch (code) {
		case "1":
			name = "CV5101.29_1";
			break;
		case "2":
			name = "CV5101.29_2";
			break;
		case "3":
			name = "CV5101.29_3";
			break;
		case "4":
			name = "CV5101.29_4";
			break;
		case "5":
			name = "CV5101.29_5";	
			break;
		case "6":
			name = "CV5101.29_6";
			break;
		default:
			break;
		}
		return name;
	} 
	
	//吸烟状况
	public static String smokeConvert(String code){
		String name = "";
		if(code == null){
			return "";
		}
		switch (code) {
		case "1":
			name = "SX0079_1";
			break;
		case "2":
			name = "SX0079_2";
			break;
		case "3":
			name = "SX0079_3";
			break;			
		default:
			break;
		}
		return name;
	}
	
	//饮酒频率
	public static String drinkConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0080_1";
			break;
		case "2":
			name = "SX0080_2";
			break;
		case "3":
			name = "SX0080_3";
			break;
		case "4":
			name = "SX0080_4";
			break;
		default:
			break;
		}
		return name;
	} 
	
	//是否戒酒
	public static String drinkStopConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0081_1";
			break;
		case "2":
			name = "SX0081_2";
			break;
		default:
			break;
		}
		return name;
	} 

	//是否
	public static String isNotConvert(String code){
		String name = "";
		if(code == null){
			return "";
		}
		switch (code) {
		case "1":
			name = "SX0083_1";
			break;
		case "2":
			name = "SX0083_2";
			break;
		case "3":
			name = "SX0083_3";
			break;
		default:
			break;
		}
		return name;
	}
	
	public static String barrelChestConvert(String code){
		String name = "";
		if(code == null){
			return "";
		}
		switch (code) {
		case "2":
			name = "SX0083_1";
			break;
		case "1":
			name = "SX0083_2";
			break;
		case "3":
			name = "SX0083_3";
			break;
		default:
			break;
		}
		return name;
	} 	

	//饮酒种类
	public static String drinkTypeConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "CV5305.02_1";
			break;
		case "2":
			name = "CV5305.02_3";
			break;
		case "3":
			name = "CV5305.02_5";
			break;
		case "4":
			name = "CV5305.02_4";
			break;	
		case "5":
			name = "CV5305.02_9";
			break;				
		default:
			break;
		}
		return name;
	}
	
	//有无
	public static String haveNotConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0087_2";
			break;
		case "2":
			name = "SX0087_1";
			break;
		default:
			break;
		}
		return name;
	}
	
	//口唇
	public static String lipsConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "CV5102.12_1";
			break;
		case "2":
			name = "CV5102.12_2";
			break;
		case "3":
			name = "CV5102.12_3";
			break;
		case "4":
			name = "CV5102.12_4";
			break;
		case "5":
			name = "CV5102.12_5";	
			break;
		case "6":
			name = "CV5102.12_9";
			break;
		default:
			break;
		}
		return name;
	}
	
	//齿列
	public static String toothConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "CV5102.13_1";
			break;
		case "2":
			name = "CV5102.13_2";
			break;
		case "3":
			name = "CV5102.13_3";
			break;
		case "4":
			name = "CV5102.13_4";
			break;					
		default:
			break;
		}
		return name;
	}
	
	//咽部
	public static String gutturConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0015_1";
			break;
		case "2":
			name = "SX0015_2";
			break;
		case "3":
			name = "SX0015_3";
			break;
		default:
			break;
		}
		return name;
	} 
	
	//听力
	public static String hearingConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0016_1";
			break;
		case "2":
			name = "SX0016_2";
			break;
		default:
			break;
		}
		return name;
	}
	
	//运动功能
	public static String movementConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0017_1";
			break;
		case "2":
			name = "SX0017_2";
			break;
		default:
			break;
		}
		return name;
	}

	//正常异常
	public static String normalConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0084_1";
			break;
		case "2":
			name = "SX0084_2";
			break;
		default:
			break;
		}
		return name;
	}

	//皮肤
	public static String skinConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "CV5102.11_1";
			break;
		case "2":
			name = "CV5102.11_2";
			break;
		case "3":
			name = "CV5102.11_3";
			break;
		case "4":
			name = "CV5102.11_4";
			break;
		case "5":
			name = "CV5102.11_5";
			break;	
		case "6":
			name = "CV5102.11_6";
			break;
		case "7":
			name = "CV5102.11_9";
			break;			
		default:
			break;
		}
		return name;
	}

	//巩膜
	public static String scleraConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0089_1";
			break;
		case "2":
			name = "SX0089_2";
			break;
		case "3":
			name = "SX0089_3";
			break;
		case "4":
			name = "SX0089_4";
			break;		
		default:
			break;
		}
		return name;
	}

	//淋巴结
	public static String lymphConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "CV5102.17_1";
			break;
		case "2":
			name = "CV5102.17_2";
			break;
		case "3":
			name = "CV5102.17_3";
			break;
		case "4":
			name = "CV5102.17_9";
			break;		
		default:
			break;
		}
		return name;
	}

	//罗 音
	public static String raleConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0018_1";
			break;
		case "2":
			name = "SX0018_2";
			break;
		case "3":
			name = "SX0018_3";
			break;
		case "4":
			name = "SX0018_4";
			break;		
		default:
			break;
		}
		return name;
	}

	//心律
	public static String heartRhythmConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0019_1";
			break;
		case "2":
			name = "SX0019_2";
			break;
		case "3":
			name = "SX0019_3";
			break;	
		default:
			break;
		}
		return name;
	}

	//下肢水肿
	public static String edemaConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "CV5102.18_1";
			break;
		case "2":
			name = "CV5102.18_2";
			break;
		case "3":
			name = "CV5102.18_3";
			break;
		case "4":
			name = "CV5102.18_4";
			break;		
		default:
			break;
		}
		return name;
	}

	//足背动脉搏动
	public static String dorsalConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0020_1";
			break;
		case "2":
			name = "SX0020_2";
			break;
		case "3":
			name = "SX0020_3";
			break;
		case "4":
			name = "SX0020_4";
			break;		
		default:
			break;
		}
		return name;
	}

	// 肛门指诊
	public static String anusConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0021_1";
			break;
		case "2":
			name = "SX0021_2";
			break;
		case "3":
			name = "SX0021_3";
			break;
		case "4":
			name = "SX0021_4";
			break;	
		case "5":
			name = "SX0021_5";
			break;				
		default:
			break;
		}
		return name;
	}
	
	// 乳 腺
	public static String breastConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "CV5102.03_1";
			break;
		case "2":
			name = "CV5102.03_8";
			break;
		case "3":
			name = "CV5102.03_6";
			break;
		case "4":
			name = "CV5102.03_2";
			break;	
		case "5":
			name = "CV5102.03_9";
			break;				
		default:
			break;
		}
		return name;
	}

	//未见异常正常
	public static String noAbnormalityConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0086_1";
			break;
		case "2":
			name = "SX0086_2";
			break;
		default:
			break;
		}
		return name;
	}
	
	// 尿检测
	public static String urineConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "-":
			name = "SX0186_1";
			break;
		case "+-":
			name = "SX0186_2";
			break;
		case "+":
			name = "SX0186_3";
			break;
		case "++":
			name = "SX0186_4";
			break;	
		case "+++":
			name = "SX0186_5";
			break;				
		default:
			break;
		}
		return name;
	}
	
	//阴性阳性
	public static String feminineConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0085_1";
			break;
		case "2":
			name = "SX0085_2";
			break;
		default:
			break;
		}
		return name;
	}
	
	// 脑血管疾病
	public static String cerebrovascularDisease(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0023_1";
			break;
		case "2":
			name = "SX0023_2";
			break;
		case "3":
			name = "SX0023_3";
			break;
		case "4":
			name = "SX0023_4";
			break;	
		case "5":
			name = "SX0023_5";
			break;	
		case "6":
			name = "SX0023_6";
			break;			
		default:
			break;
		}
		return name;
	}
	
	// 肾脏疾病
	public static String kidneyDisease(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0024_1";
			break;
		case "2":
			name = "SX0024_2";
			break;
		case "3":
			name = "SX0024_3";
			break;
		case "4":
			name = "SX0024_4";
			break;	
		case "5":
			name = "SX0024_5";
			break;	
		case "6":
			name = "SX0024_6";
			break;			
		default:
			break;
		}
		return name;
	}	
	
	// 心脏疾病
	public static String heartDisease(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0025_1";
			break;
		case "2":
			name = "SX0025_2";
			break;
		case "3":
			name = "SX0025_3";
			break;
		case "4":
			name = "SX0025_4";
			break;	
		case "5":
			name = "SX0025_5";
			break;	
		case "6":
			name = "SX0025_6";
			break;
		case "7":
			name = "SX0025_7";
			break;				
		default:
			break;
		}
		return name;
	}
	
	// 血管疾病
	public static String vascularDisease(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0026_1";
			break;
		case "2":
			name = "SX0026_2";
			break;
		case "3":
			name = "SX0026_3";
			break;
		case "4":
			name = "SX0026_4";
			break;				
		default:
			break;
		}
		return name;
	}
	// 眼部疾病
	public static String ocularDiseases(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0027_1";
			break;
		case "2":
			name = "SX0027_2";
			break;
		case "3":
			name = "SX0027_3";
			break;
		case "4":
			name = "SX0027_4";
			break;	
		case "5":
			name = "SX0027_5";
			break;				
		default:
			break;
		}
		return name;
	}	

	//未发现有
	public static String notFoundConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0090_1";
			break;
		case "2":
			name = "SX0090_2";
			break;
		default:
			break;
		}
		return name;
	}
	//健康评价
	public static String healthEvaluationConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0087_2";
			break;
		case "2":
			name = "SX0087_1";
			break;
		default:
			break;
		}
		return name;
	}
	
	public static String healthGuidanceConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0029_1";
			break;
		case "2":
			name = "SX0029_2";
			break;
		case "3":
			name = "SX0029_3";
			break;			
		default:
			break;
		}
		return name;
	}

	// 危险因素控制
	public static String dangerControlling(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0030_1";
			break;
		case "2":
			name = "SX0030_2";
			break;
		case "3":
			name = "SX0030_3";
			break;
		case "4":
			name = "SX0030_4";
			break;	
		case "5":
			name = "SX0030_5";
			break;	
		case "6":
			name = "SX0030_6";
			break;
		case "7":
			name = "SX0030_7";
			break;				
		default:
			break;
		}
		return name;
	}

	//服药依从性
	public static String complianceConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0028_1";
			break;
		case "2":
			name = "SX0028_2";
			break;
		case "3":
			name = "SX0028_3";
			break;
		default:
			break;
		}
		return name;
	} 
	
	// 危险因素控制
	public static String checkFlagConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0356_1";
			break;
		case "2":
			name = "SX0356_2";
			break;
		case "3":
			name = "SX0356_3";
			break;
		case "4":
			name = "SX0356_4";
			break;	
		case "5":
			name = "SX0356_5";
			break;	
		case "6":
			name = "SX0356_6";
			break;
		case "7":
			name = "SX0356_7";
			break;				
		default:
			break;
		}
		return name;
	}
	
	//糖尿病随访方式
	public static String visitTypeConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0160_1";
			break;
		case "2":
			name = "SX0160_2";
			break;
		case "3":
			name = "SX0160_3";
			break;			
		default:
			break;
		}
		return name;
	}
	
	// 糖尿病症状
	public static String diabetesSymptomConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0058_1";
			break;
		case "2":
			name = "SX0058_2";
			break;
		case "3":
			name = "SX0058_3";
			break;
		case "4":
			name = "SX0058_4";
			break;	
		case "5":
			name = "SX0058_5";
			break;	
		case "6":
			name = "SX0058_6";
			break;	
		case "7":
			name = "SX0058_7";
			break;	
		case "8":
			name = "SX0058_8";
			break;	
		case "9":
			name = "SX0058_9";
			break;				
		default:
			break;
		}
		return name;
	}
	
	//糖尿病足背动脉搏动
	public static String diabetesDorsalConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0399_1";
			break;
		case "2":
			name = "SX0399_2";
			break;
		case "3":
			name = "SX0399_3";
			break;			
		default:
			break;
		}
		return name;
	}
	
	//糖尿病心里调整
	public static String diabetesPsychologyConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0056_1";
			break;
		case "2":
			name = "SX0056_2";
			break;
		case "3":
			name = "SX0056_3";
			break;			
		default:
			break;
		}
		return name;
	}

	//低血糖反应
	public static String reactiveHypoglycemiaConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0059_1";
			break;
		case "2":
			name = "SX0059_2";
			break;
		case "3":
			name = "SX0059_3";
			break;			
		default:
			break;
		}
		return name;
	}
	
	//糖尿病随访 分类
	public static String visitClassConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "CV5501.07_1";
			break;
		case "2":
			name = "CV5501.07_2";
			break;
		case "3":
			name = "CV5501.07_3";
			break;	
		case "4":
			name = "CV5501.07_4";
			break;				
		default:
			break;
		}
		return name;
	}
	
	//足背动脉搏动位置
	public static String pulsationPositionConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0398_1";
			break;
		case "2":
			name = "SX0398_2";
			break;
		case "3":
			name = "SX0398_3";
			break;			
		default:
			break;
		}
		return name;
	}
	
	// 糖尿病症状
	public static String hypertensionSymptomConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0054_1";
			break;
		case "2":
			name = "SX0054_2";
			break;
		case "3":
			name = "SX0054_3";
			break;
		case "4":
			name = "SX0054_4";
			break;	
		case "5":
			name = "SX0054_5";
			break;	
		case "6":
			name = "SX0054_6";
			break;	
		case "7":
			name = "SX0054_7";
			break;	
		case "8":
			name = "SX0054_8";
			break;	
		case "9":
			name = "SX0054_9";
			break;				
		default:
			break;
		}
		return name;
	}

	public static String saltIntakeConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0182_1";
			break;
		case "2":
			name = "SX0182_2";
			break;
		case "3":
			name = "SX0182_3";
			break;			
		default:
			break;
		}
		return name;
	}
	
	// 中医体质辨识
	public static String tcmConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0333_1";
			break;
		case "2":
			name = "SX0333_2";
			break;
		case "3":
			name = "SX0333_3";
			break;
		case "4":
			name = "SX0333_4";
			break;	
		case "5":
			name = "SX0333_5";
			break;				
		default:
			break;
		}
		return name;
	}
	
	// 中医Bmi
	public static String tcmBmiConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0334_1";
			break;
		case "2":
			name = "SX0334_2";
			break;
		case "3":
			name = "SX0334_3";
			break;
		case "4":
			name = "SX0334_4";
			break;	
		case "5":
			name = "SX0334_5";
			break;				
		default:
			break;
		}
		return name;
	}	
	
	// 中医感冒
	public static String tcmColdConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0335_1";
			break;
		case "2":
			name = "SX0335_2";
			break;
		case "3":
			name = "SX0335_3";
			break;
		case "4":
			name = "SX0335_4";
			break;	
		case "5":
			name = "SX0335_5";
			break;				
		default:
			break;
		}
		return name;
	}	

	//中医过敏
	public static String tcmAllergicConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0336_1";
			break;
		case "2":
			name = "SX0336_2";
			break;
		case "3":
			name = "SX0336_3";
			break;
		case "4":
			name = "SX0336_4";
			break;	
		case "5":
			name = "SX0336_5";
			break;				
		default:
			break;
		}
		return name;
	}
	
	//中医腹围
	public static String tcmAbdominalCircumferenceConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0337_1";
			break;
		case "2":
			name = "SX0337_2";
			break;
		case "3":
			name = "SX0337_3";
			break;
		case "4":
			name = "SX0337_4";
			break;	
		case "5":
			name = "SX0337_5";
			break;				
		default:
			break;
		}
		return name;
	}
	
	//中医体质辨识结果
	public static String tcmTzResultConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0088_1";
			break;
		case "2":
			name = "SX0088_2";
			break;
		case "3":
			name = "SX0088_3";
			break;			
		default:
			break;
		}
		return name;
	}
	//中医药保健指导
	public static String tcmGuidanceConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0352_1";
			break;
		case "2":
			name = "SX0352_2";
			break;
		case "3":
			name = "SX0352_3";
			break;
		case "4":
			name = "SX0352_4";
			break;	
		case "5":
			name = "SX0352_5";
			break;
		case "6":
			name = "SX0352_6";
			break;			
		default:
			break;
		}
		return name;
	}
	
	//中医体质辨识结果
	public static String tcmPingheConvert(String code){
		if(code == null){
			return "";
		}
		String name = "";
		switch (code) {
		case "1":
			name = "SX0401_1";
			break;
		case "2":
			name = "SX0401_2";
			break;
		case "3":
			name = "SX0401_3";
			break;			
		default:
			break;
		}
		return name;
	}	
}
