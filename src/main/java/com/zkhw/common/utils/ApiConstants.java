package com.zkhw.common.utils;

import java.util.HashMap;
import java.util.Map;

public class ApiConstants {
	
	//示例secret key
	public static final String SECRET_KEY_DEMO = "5q6kqkl4950du1g3qrow1qxsfgclhfxb";
		
	//Session在redis中的key前缀
	public static final String ZKHW_SESSION_MAPKEY_PREFIX = "zkhw_session_id_";
	
	//SessionId在cookie中的key
	public static final String ZKHW_SESSIONID_COOKIE_NAME = "zkhw_session_id";
	
	//SessionId在sessionmap中的key
	public static final String ZKHW_SESSIONID_KEY = "zkhwSessionId";
	
	//redis key常量
	public static final String REDIS_KEY_PREFIX_SESSION = "zkhw_login_name_";          //pc端
	public static final String REDIS_KEY_PREFIX_APP_SESSION = "zkhw_login_app_name_";  //app端
	
	public static final int SESSION_TIMEOUT=60; //分钟
	
	//cookies key常量
	public static final String COOKIES_KEY_LOGIN_NAME = "zkhw_login_name";
	public static final String COOKIES_KEY_LOGIN_APP_NAME = "zkhw_login_app_name";  //app端
	
	public static final int COOKIE_MAX_AGE=60*60*24; //秒
	
	//省市区
	public static final String AREA_ALL ="AREA_ALL";
	
	//省级key
	public static final String AREA_PROVINCE_CODE  = "PROVINCE_KEY";
	
	//市级key前缀
	public static final String AREA_CITY_CODE  = "AREA_CITY_CODE_";
	
	//区县级key前缀
	public static final String AREA_COUNTY_CODE  = "AREA_COUNTY_CODE_";
	
	//乡镇前缀
	public static final String AREA_TOWNS_CODE  = "AREA_TOWNS_CODE_";
	
	//村
	public static final String AREA_VILLAGE_CODE  = "AREA_VILLAGE_CODE_";
	
	//模块(公共的)   list
	public static final String ZKHW_MODULE = "ZKHW_MODULE";
	
	//系统菜单
	public static final String ZKHW_MENU = "ZKHW_MENU";

	// 权限前缀
	public static final String ZKHW_RIGHT = "ZKHW_RIGHT_";
	
	//web来源
	public static final int WEB_SOURCE = 0;
		   
    //获取所有的地区
    public static final String All_Area= "All_Area";
    
    public static final Map<String,String> NATION = new HashMap<String,String>();
    
    static{
    	NATION.put("08","壮族");
    	NATION.put("11","满族");
    	NATION.put("03","回族");
    	NATION.put("06","苗族");
    	NATION.put("05","维吾尔族");
    	NATION.put("15","土家族");
    	NATION.put("07","彝族");
    	NATION.put("02","蒙古族");
    	NATION.put("04","藏族");
    	NATION.put("09","布依族");
    	NATION.put("12","侗族");
    	NATION.put("13","瑶族");
    	NATION.put("10","朝鲜族");
    	NATION.put("14","白族");
    	NATION.put("16","哈尼族");
    	NATION.put("17","哈萨克族");
    	NATION.put("19","黎族");
    	NATION.put("18","傣族");
    	NATION.put("22","畲族");
    	NATION.put("20","傈僳族");
    	NATION.put("37","仡佬族");
    	NATION.put("26","东乡族");
    	NATION.put("23","高山族");
    	NATION.put("24","拉祜族");
    	NATION.put("25","水族");
    	NATION.put("21","佤族");
    	NATION.put("27","纳西族");
    	NATION.put("33","羌族");
    	NATION.put("30","土族");
    	NATION.put("32","仫佬族");
    	NATION.put("38","锡伯族");
    	NATION.put("29","柯尔克孜族");
    	NATION.put("31","达斡尔族");
    	NATION.put("28","景颇族");
    	NATION.put("36","毛南族");
    	NATION.put("35","撒拉族");
    	NATION.put("34","布朗族");
    	NATION.put("41","塔吉克族");
    	NATION.put("39","阿昌族");
    	NATION.put("40","普米族");
    	NATION.put("45","鄂温克族");
    	NATION.put("42","怒族");
    	NATION.put("49","京族");
    	NATION.put("56","基诺族");
    	NATION.put("46","德昂族");
    	NATION.put("47","保安族");
    	NATION.put("44","俄罗斯族");
    	NATION.put("48","裕固族");
    	NATION.put("43","乌兹别克族");
    	NATION.put("54","门巴族");
    	NATION.put("52","鄂伦春族");
    	NATION.put("51","独龙族");
    	NATION.put("50","塔塔尔族");
    	NATION.put("53","赫哲族");
    	NATION.put("55","珞巴族");

    }
       
}
