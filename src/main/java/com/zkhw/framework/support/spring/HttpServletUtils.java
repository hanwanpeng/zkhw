package com.zkhw.framework.support.spring;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class HttpServletUtils extends RequestContextHolder{
	
	/**
	 * Junit测试�? 封装�?单的HttpServletRequest <br/>
	 * 
	 * @param params request对象中的�?
	 */
	public static HttpServletRequest getRequest(){
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		return request;
	}
	
	/**
	 * Junit测试�? 封装�?单的HttpServletRequest <br/>
	 * 
	 * @param params request对象中的�?
	 */
	@SuppressWarnings("unchecked")
	public static HttpServletRequest getRequest(@SuppressWarnings("rawtypes") Map params){
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setParameters(params);
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		return request;
	}
	
	/**
	 * Junit测试�? 封装�?单的HttpServletResponse <br/>
	 * 
	 * @param params response对象中的�?
	 */
	public static HttpServletResponse getResponse(){
		MockHttpServletResponse response = new MockHttpServletResponse();
		return response;
	}
}
