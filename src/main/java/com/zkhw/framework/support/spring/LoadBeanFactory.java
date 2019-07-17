package com.zkhw.framework.support.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoadBeanFactory {
	
	public static BeanFactory factory = null;
	
	public static  synchronized  BeanFactory GetFactory(){
		if (factory == null) {  
			factory = new ClassPathXmlApplicationContext(new String[] {"classpath*:spring-mvc/zks-*.xml","classpath*:spring/zks-*.xml"});
	    } 
		return factory;
	}
}
