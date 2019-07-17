package com.zkhw.framework.utils;

public class NumberUtils {

	public static Short convertToShort(String s){
		Short r = null;
		if(s == null || "".equals(s.trim())){
			return null;
		}else{
			try{
				r = Short.parseShort(s);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return r;
	}
	
	public static Long convertToLong(String s){
		Long r = null;
		if(s == null || "".equals(s.trim())){
			return null;
		}else{
			try{
				r = Long.parseLong(s);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return r;
	}
}
