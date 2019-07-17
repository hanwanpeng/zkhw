package com.zkhw.common.utils;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zkhw.framework.redis.RedisClient;
import com.zkhw.framework.utils.CookieUtils;

/**
 * 基于redis的Session
 *
 */
public class GlobalSession {
	
	/**
	 * 获取全局session id 
	 * @return
	 */
	public String getSessionId(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		WebApplicationContext webApplicationContext =ContextLoader.getCurrentWebApplicationContext();
		RedisClient redisClient = (RedisClient)webApplicationContext.getBean("redisClient");
		String sessionId = null;
		
		Cookie cookie = CookieUtils.getCookieByName(request, ApiConstants.ZKHW_SESSIONID_COOKIE_NAME);
		if(cookie==null){ //第1次创建session，本次请求尚未携带此cookie(longwatch_session_id)
			sessionId = request.getSession().getId();
		}else{
			String sessionMapKey = ApiConstants.ZKHW_SESSION_MAPKEY_PREFIX + cookie.getValue();
			sessionId = redisClient.getHashValue(sessionMapKey, ApiConstants.ZKHW_SESSIONID_KEY);
		}
		return sessionId;
	}
	
	/**
	 * 在全局session中设置kv
	 */
	public void setAttribute(String key,String value){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		WebApplicationContext webApplicationContext =ContextLoader.getCurrentWebApplicationContext();
		RedisClient redisClient = (RedisClient)webApplicationContext.getBean("redisClient");
		String sessionMapKey = null;
		
		Cookie cookie = CookieUtils.getCookieByName(request, ApiConstants.ZKHW_SESSIONID_COOKIE_NAME);
		if(cookie==null){ //第1次创建session，本次请求尚未携带此cookie(longwatch_session_id)
			sessionMapKey = ApiConstants.ZKHW_SESSION_MAPKEY_PREFIX + request.getSession().getId();
		}else{
			sessionMapKey = ApiConstants.ZKHW_SESSION_MAPKEY_PREFIX + cookie.getValue();
		}
		redisClient.setHash(sessionMapKey, key, value);
		redisClient.expire(sessionMapKey, ApiConstants.SESSION_TIMEOUT*60); //session过期时间(60分)
	}
	
	/**
	 * 在全局session中获取值
	 */
	public String getAttribute(String key){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		WebApplicationContext webApplicationContext =ContextLoader.getCurrentWebApplicationContext();
		RedisClient redisClient = (RedisClient)webApplicationContext.getBean("redisClient");
		String sessionMapKey = null;
		
		Cookie cookie = CookieUtils.getCookieByName(request, ApiConstants.ZKHW_SESSIONID_COOKIE_NAME);
		if(cookie==null){ //第1次创建session，本次请求尚未携带此cookie(longwatch_session_id)
			sessionMapKey = ApiConstants.ZKHW_SESSION_MAPKEY_PREFIX + request.getSession().getId();
		}else{
			sessionMapKey = ApiConstants.ZKHW_SESSION_MAPKEY_PREFIX + cookie.getValue();
		}
		String value =redisClient.getHashValue(sessionMapKey, key);
		redisClient.expire(sessionMapKey, ApiConstants.SESSION_TIMEOUT*60); //session过期时间(60分)
		return value;
	}	
	
	/**
	 * 在全局session中删除kv
	 * @param key
	 */
	public void removeAttribute(String key){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		WebApplicationContext webApplicationContext =ContextLoader.getCurrentWebApplicationContext();
		RedisClient redisClient = (RedisClient)webApplicationContext.getBean("redisClient");
		String sessionMapKey = null;
		
		Cookie cookie = CookieUtils.getCookieByName(request, ApiConstants.ZKHW_SESSIONID_COOKIE_NAME);
		if(cookie==null){ //第1次创建session，本次请求尚未携带此cookie(longwatch_session_id)
			sessionMapKey = ApiConstants.ZKHW_SESSION_MAPKEY_PREFIX + request.getSession().getId();
		}else{
			sessionMapKey = ApiConstants.ZKHW_SESSION_MAPKEY_PREFIX + cookie.getValue();
		}
		redisClient.delHash(sessionMapKey, key);
		redisClient.expire(sessionMapKey, ApiConstants.SESSION_TIMEOUT*60); //session过期时间(60分)
	}

}
