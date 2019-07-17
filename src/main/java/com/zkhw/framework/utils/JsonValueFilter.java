package com.zkhw.framework.utils;

import com.alibaba.fastjson.serializer.ValueFilter;

/**
 * Json过滤�?
 *
 */
public class JsonValueFilter implements ValueFilter {
	public static JsonValueFilter filter = new JsonValueFilter();
	
	@Override
	public Object process(Object source, String name, Object value) {
		if(value instanceof Long){
			return value.toString();
		}
		return value;
	}
}
