package com.zkhw.framework.utils;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonConverter {
	
	/**
	 * 将json串转为对�?
	 */
	public static JSONObject json2Obj(String jsonStr) {
		Object obj = JSON.parse(jsonStr);
		return (JSONObject)obj;
	}

	/**
	 * 将json转为指定类型的java对象
	 */
	public static <T> T json2Obj(String jsonStr,Class<T> clazz){
		return JSON.parseObject(jsonStr, clazz);
	}
  
	/**
	 * 将json转为指定类型的java对象集合
	 */
	public static <T> List<T> json2ObjList(String jsonStr,Class<T> clazz){
		return JSON.parseArray(jsonStr, clazz);
	}
	
	/**
	 * 将对象转为json字符�? ,空�?�属性不输出
	 */
	public static String obj2Json(Object obj) {
		return JSON.toJSONString(obj,JsonValueFilter.filter);
	}
	
	/**
	 * 将对象转为json字符�? ,空�?�属性不输出,与obj2Json() 功能相同
	 */
	public static String obj2JsonWithOutNullProperty(Object obj) {
		return JSON.toJSONString(obj,JsonValueFilter.filter);
	}
	
	/**
	 * 将对象转为json字符�?,空�?�属性输�?
	 */
	public static String obj2JsonWithNullProperty(Object obj) {
		return JSONObject.toJSONString(obj,JsonValueFilter.filter,SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty);
	}
	
}
