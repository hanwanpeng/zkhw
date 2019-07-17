package com.wuzhou.pub.utils;

public class CodeToValue {
	
	//症状
	public static String symptomConvert(String code){
		String name = "";
		switch (code) {
		case "1":
			name = "无症状";
			break;
		case "2":
			name = "头痛";
			break;
		case "3":
			name = "头晕";
			break;
		case "4":
			name = "心悸";
			break;
		case "5":
			name = "胸闷";
			break;
		case "6":
			name = "胸痛";
			break;
		case "7":
			name = "慢性咳嗽";	
			break;
		case "8":
			name = "咳痰";	
			break;
		case "9":
			name = "呼吸困难";	
			break;
		case "10":
			name = "多饮";
			break;
		case "11":
			name = "多尿";	
			break;
		case "12":
			name = "体重下降";				
			break;	
		case "13":
			name = "乏力";				
			break;	
		case "14":
			name = "关节肿痛";				
			break;	
		case "15":
			name = "视力模糊";	
			break;
		case "16":
			name = "手脚麻木";					
			break;	
		case "17":
			name = "尿急";	
			break;	
		case "18":
			name = "尿痛";
			break;	
		case "19":
			name = "便秘";	
			break;	
		case "20":
			name = "腹泻";
			break;	
		case "21":
			name = "恶心呕吐";				
			break;	
		case "22":
			name = "眼花";				
			break;
		case "23":
			name = "耳鸣";				
			break;
		case "24":
			name = "乳房胀痛";				
			break;
		case "25":
			name = "其他";				
			break;				
		default:
			break;
		}
		return name;
	} 
	//饮食习惯
	public static String eatingConvert(String code){
		String name = "";
		switch (code) {
		case "1":
			name = "荤素均衡";
			break;
		case "2":
			name = "荤食为主";
			break;
		case "3":
			name = "素食为主";
			break;
		case "4":
			name = "嗜盐";
			break;
		case "5":
			name = "嗜油";	
			break;
		case "6":
			name = "嗜糖";
			break;
		default:
			break;
		}
		return name;
	} 

	//服药依从性
	public static String complianceConvert(String code){
		String name = "";
		switch (code) {
		case "1":
			name = "规律";
			break;
		case "2":
			name = "间断";
			break;
		case "3":
			name = "不服药";
			break;
		default:
			break;
		}
		return name;
	} 
	
	//健康指导
	public static String guidanceConvert(String code){
		String name = "";
		switch (code) {
		case "1":
			name = "纳入慢性病患者健康管理";
			break;
		case "2":
			name = "建议复查";
			break;
		case "3":
			name = "建议转诊";
			break;
		default:
			break;
		}
		return name;
	}
	
	public static String breastConvert(String code){
		String name = "";
		switch (code) {
		case "1":
			name = "未见异常";
			break;
		case "2":
			name = "乳房切除";
			break;
		case "3":
			name = "异常泌乳";
			break;
		case "4":
			name = "乳腺包块";
			break;	
		case "5":
			name = "其他";
			break;				
		default:
			break;
		}
		return name;
	}
	
	//饮酒种类
	public static String drinkingConvert(String code){
		String name = "";
		switch (code) {
		case "1":
			name = "白酒";
			break;
		case "2":
			name = "啤酒";
			break;
		case "3":
			name = "红酒";
			break;
		case "4":
			name = "黄酒";
			break;	
		case "5":
			name = "其他";
			break;				
		default:
			break;
		}
		return name;
	}
}
