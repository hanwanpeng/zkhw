package com.zkhw.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;
import com.zkhw.common.vo.LoginVo;
import com.zkhw.framework.redis.RedisClient;
import com.zkhw.framework.utils.CookieUtils;
import com.zkhw.framework.utils.DesEncrypt;
import com.zkhw.framework.utils.JsonConverter;

/**
 * session操作工具类，使用redis存储
 * @author houmeng
 *
 */
public class SessionUtil {
	@SuppressWarnings("unused")
	private HttpServletRequest request;
	private HttpServletResponse response;
	private static GlobalSession longWatchSession = new GlobalSession();
	
	public SessionUtil(HttpServletRequest request,HttpServletResponse response){
		this.request = request;
		this.response = response;
	}
	
	/**
	 * 为客户生成全局sessionID
	 */
	public GlobalSession getSession(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		WebApplicationContext webApplicationContext =ContextLoader.getCurrentWebApplicationContext();
		RedisClient redisClient = (RedisClient)webApplicationContext.getBean("redisClient");
		
		//如果没session则创建(客户端无longwatch_session_id代表尚无session)
		Cookie cookie = CookieUtils.getCookieByName(request, ApiConstants.ZKHW_SESSIONID_COOKIE_NAME);
		if(cookie==null){
			String sessionId = request.getSession().getId();
			String sessionMapKey = ApiConstants.ZKHW_SESSION_MAPKEY_PREFIX + sessionId;
			redisClient.setHash(sessionMapKey, ApiConstants.ZKHW_SESSIONID_KEY, sessionId);
			redisClient.expire(sessionMapKey, ApiConstants.SESSION_TIMEOUT*60); //session过期时间(60分)
			//写cookie(longwatch_session_id)
			String cookie_name = ApiConstants.ZKHW_SESSIONID_COOKIE_NAME;
			Cookie cookie2 = new Cookie(cookie_name, sessionId);
			cookie2.setPath("/");
			response.addCookie(cookie2);
			return longWatchSession;
		}else{ //如果此用户已经有session，直接返回
			return longWatchSession;
		}
	}
	
	/**
	 * 向redis中存储登录数据
	 */
	public void setLoginVo(LoginVo loginVo){
		//json存入redis
		String json = JsonConverter.obj2Json(loginVo);
		WebApplicationContext webApplicationContext =ContextLoader.getCurrentWebApplicationContext();			
		RedisClient redisClient = (RedisClient)webApplicationContext.getBean("redisClient");
		redisClient.setEx(ApiConstants.REDIS_KEY_PREFIX_SESSION+loginVo.getUser().getLoginName(), json, ApiConstants.SESSION_TIMEOUT*60); //登录信息过期时间
		
		//写cookie
		//String cookie_name = Md5Encrypt.md5( ApiConstants.COOKIES_KEY_LOGIN_NAME );
		String cookie_name = ApiConstants.COOKIES_KEY_LOGIN_NAME;
		String cookie_value = null;
		try {
			DesEncrypt des = new DesEncrypt();
	    	cookie_value =des.encrypt( loginVo.getUser().getLoginName() );
		} catch (Exception e) {
			e.printStackTrace();
		}
		Cookie cookie = new Cookie(cookie_name, cookie_value);
		cookie.setPath("/");
		cookie.setMaxAge( ApiConstants.COOKIE_MAX_AGE ); //失效时间
		response.addCookie(cookie);
	}
	
	public void setAppLoginVo(LoginVo loginVo){
		//json存入redis
		String json = JsonConverter.obj2Json(loginVo);
		WebApplicationContext webApplicationContext =ContextLoader.getCurrentWebApplicationContext();			
		RedisClient redisClient = (RedisClient)webApplicationContext.getBean("redisClient");
		redisClient.setEx(ApiConstants.REDIS_KEY_PREFIX_APP_SESSION+loginVo.getUser().getLoginName(), json, ApiConstants.SESSION_TIMEOUT*60); //登录信息过期时间
		
		//写cookie
		//String cookie_name = Md5Encrypt.md5( ApiConstants.COOKIES_KEY_LOGIN_NAME );
		String cookie_name = ApiConstants.COOKIES_KEY_LOGIN_APP_NAME;
		String cookie_value = null;
		try {
			DesEncrypt des = new DesEncrypt();
	    	cookie_value =des.encrypt( loginVo.getUser().getLoginName() );
		} catch (Exception e) {
			e.printStackTrace();
		}
		Cookie cookie = new Cookie(cookie_name, cookie_value);
		cookie.setPath("/");
		cookie.setMaxAge( ApiConstants.COOKIE_MAX_AGE ); //失效时间
		response.addCookie(cookie);
	}
	
	
	
	
	/**
	 * 从redis获取登录数据
	 */
	public LoginVo getLoginVo(String login_name){
		//获取cookie_name
		//String cookie_name = Md5Encrypt.md5( ApiConstants.COOKIES_KEY_LOGIN_NAME );

		if( login_name == null ){
			return null;
		}
		//从redis中获取loginVo
		WebApplicationContext webApplicationContext =ContextLoader.getCurrentWebApplicationContext();			
		RedisClient redisClient = (RedisClient)webApplicationContext.getBean("redisClient");
		String key = ApiConstants.REDIS_KEY_PREFIX_SESSION+login_name;
		String jsonStr = redisClient.get(key);
		LoginVo loginVo = null;
		try {
			JSONObject jsonObj = JsonConverter.json2Obj(jsonStr);
			loginVo = JSONObject.toJavaObject(jsonObj, LoginVo.class );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//判断最近一次操作到当前是否超过ApiConstants.SESSION_TIMEOUT 分钟
		if(loginVo!=null){
			long interval = System.currentTimeMillis() - loginVo.getLastOperateTime();
			if( interval/1000/60 > ApiConstants.SESSION_TIMEOUT){
				loginVo = null;
			}
		}
		return loginVo;
	}
	
	/**
	 * 从redis中删除登录数据
	 */
	public void removeLoginVo(LoginVo loginVo){
		WebApplicationContext webApplicationContext =ContextLoader.getCurrentWebApplicationContext();			
		RedisClient redisClient = (RedisClient)webApplicationContext.getBean("redisClient");
		String key = ApiConstants.REDIS_KEY_PREFIX_SESSION+loginVo.getUser().getLoginName();
		redisClient.del(key);
	}
}
