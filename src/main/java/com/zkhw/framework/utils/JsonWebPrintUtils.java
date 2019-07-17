package com.zkhw.framework.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * json输出工具
 * @author houmeng
 */
public class JsonWebPrintUtils {
	private static Logger logger = Logger.getLogger(JsonWebPrintUtils.class);
	
	/**
	 * 输出含空的元�?
	 * @param request 从Controller中传递进来的HttpServletRequest
	 * @param response 从Controller中传递进来的HttpServletResponse
	 * @param apiJsonResult 要输出到客户端的ApiJsonResult对象
	 */
	public static void printApiResult(HttpServletRequest request,HttpServletResponse response,Object jsonObject){
		response.setContentType(Constants.CONTENT_TYPE_JSON);
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Access-Control-Allow-Origin", "*");  
		response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE"); 
		response.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Methods, Access-Control-Max-Age, X-Auth-Token, Content-Type, Accept");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String result = JsonConverter.obj2JsonWithNullProperty(jsonObject);
			out.print(result); //输出到浏览器
		} catch (IOException e) {
			logger.error(e);
		} finally {
			if (out != null) {
				out.close();
			}
		}		
	}
	
	
	
	/**
	 * 输出不为空的元素
	 * @param request 从Controller中传递进来的HttpServletRequest
	 * @param response 从Controller中传递进来的HttpServletResponse
	 * @param apiJsonResult 要输出到客户端的ApiJsonResult对象
	 */
	public static void printOutNullApiResult(HttpServletRequest request,HttpServletResponse response,Object jsonObject){
		response.setContentType(Constants.CONTENT_TYPE_JSON);
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Access-Control-Allow-Origin", "*");  
		response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE"); 
		response.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Methods, Access-Control-Max-Age, X-Auth-Token, Content-Type, Accept");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String result = JsonConverter.obj2JsonWithOutNullProperty(jsonObject);
			out.print(result); //输出到浏览器
			logger.info(result);
		} catch (IOException e) {
			logger.error(e);
		} finally {
			if (out != null) {
				out.close();
			}
		}		
	}
	
	
	
	
	
	/**
	 * 
	 * @param request 从Controller中传递进来的HttpServletRequest
	 * @param response 从Controller中传递进来的HttpServletResponse
	 * @param String str
	 */
	public static void printString(HttpServletRequest request,HttpServletResponse response,String str){
		response.setContentType(Constants.CONTENT_TYPE_JSON);
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Access-Control-Allow-Origin", "*");  
		response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE"); 
		response.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Methods, Access-Control-Max-Age, X-Auth-Token, Content-Type, Accept");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(str); //输出到浏览器
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}	
}
