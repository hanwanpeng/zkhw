package com.zkhw.shanxi.utils;

import java.lang.reflect.Field;

public class ReflectionUtils {

	public static String[] getFiledName(Object o) {
		Field[] fields = o.getClass().getDeclaredFields();
		String[] fieldNames = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
			// System.out.println(fields[i].getType());
			fieldNames[i] = fields[i].getName();
			
		}
		return fieldNames;
	}

	@SuppressWarnings("rawtypes")
	public static void setFieldValueByFieldName(String fieldName, Object object, Object value) {
		try {
			// 获取obj类的字节文件对象
			Class c = object.getClass();
			// 获取该类的成员变量
			Field f = c.getDeclaredField(fieldName);
			// 取消语言访问检查
			f.setAccessible(true);
			// 给变量赋值
			f.set(object, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Object getFieldValueByFieldName(String fieldName, Object object) {
	    try {
	        Field field = object.getClass().getDeclaredField(fieldName);
	        //设置对象的访问权限，保证对private的属性的访问
	        field.setAccessible(true);
	        return field.get(object);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

}
