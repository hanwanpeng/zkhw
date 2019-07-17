package com.zkhw.framework.datasource;

public class DBContextHolder {
	
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	
	 public static void setDBType(String dbType) {
		 contextHolder.set(dbType);
	 }
	 
	 public static String getDBType() {
		 return contextHolder.get();
	 }
	 
	 public static void clearDBType() {
		 contextHolder.remove(); 
	 }
}
