package com.zkhw.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.framework.utils.DesEncrypt;
import com.zkhw.framework.utils.JsonConverter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
   
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		String token = request.getHeader("token");
		if(StringUtils.isNotBlank(token)){
			DesEncrypt des = new DesEncrypt();
			String login_name = des.decrypt(token);
			if(login_name != null){
				SystemParam.setUserId(login_name);
			}
		}
				
		boolean doAuth = false;
		// 如果不是映射到方法直接通过
		if (handler instanceof HandlerMethod) {
			Authority authMethod = ((HandlerMethod) handler).getMethodAnnotation(Authority.class);
			Authority authClass = ((HandlerMethod) handler).getMethod().getDeclaringClass().getAnnotation(Authority.class);
			// 没有声明需要权限,或者声明不验证权限
			if ((authMethod != null && authMethod.validate() == true) || (authClass != null && authClass.validate() == true)){
				doAuth = true;
			}
		}

		if (doAuth) {
			// 取http请求头中的token、refreshToken，用来验证身份
			String refreshToken = request.getHeader("refreshToken");
			ApiJsonResult result = new ApiJsonResult();
			result.setCode("99");

			if (StringUtils.isBlank(token)) {
				result.setMsg("验证token失败");
				response.getWriter().write(JsonConverter.obj2JsonWithNullProperty(result));
				return false;
			}
			if (StringUtils.isBlank(refreshToken)) {
				result.setMsg("验证token失败");
				response.getWriter().write(JsonConverter.obj2JsonWithNullProperty(result));
				return false;
			}
			// 拦截通过
			return true;
		} else {
			return true;
		}
     }
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		SystemParam.removeUserId();
	}
}