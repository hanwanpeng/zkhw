package com.zkhw.framework.support.aop;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.logging.Logger;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import com.zkhw.framework.datasource.DBContextHolder;
import com.zkhw.framework.datasource.Datasource;

public class DataSourceAdvice implements MethodBeforeAdvice, AfterReturningAdvice{
	private static Logger logger = Logger.getLogger(DataSourceAdvice.class.getName());

	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		
	}

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		Datasource d = method.getAnnotation(Datasource.class);
		String methodName = method.getName();
		if(d != null){
			String datas = d.value();
			DBContextHolder.setDBType(datas);
			logger.info("datasource advice, anotation method:" + methodName + ", database:"+datas);
		}
	}
	
	public  void  afterThrowing(Exception  ex)  throws  Throwable{  
		
		StringWriter writer = new StringWriter();
		ex.printStackTrace(new PrintWriter(writer));
		String error =  writer.getBuffer().toString();
		logger.info("执行方法异常:"+error);
		DBContextHolder.clearDBType();
	}
	
}
