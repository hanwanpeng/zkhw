package com.zkhw.framework.handler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionResolver implements HandlerExceptionResolver{

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse arg1, Object arg2, Exception e) {
		Map<String,Object> map = new HashMap<String,Object>(); 
		e.printStackTrace();
		StringWriter writer = new StringWriter();
		e.printStackTrace(new PrintWriter(writer));
		String error =  writer.getBuffer().toString();
		String simplename = e.getClass().getSimpleName(); 
		if(!"ClientAbortException".equals(simplename)){ 
			//IMail mail = MailUtils.getSysDefaultMailConfig();
//			if(mail.isSendMail()){
//				String browser = IpBrowserUtils.getBrowserAndVersion(request);
//				String clientIp = IpBrowserUtils.getIp(request);
//				String ip =  IpBrowserUtils.getLocalIP();
//				mail.setTitle("服务器IP�?"+ ip +" 客户端IP:"+clientIp+" 请求地址:"+request.getRequestURL()+" 出现异常 浏览器版�?:"+browser);
//				mail.setContent(error);
//				MailSender mailSender = new MailSender();
//				try {
//					mailSender.mailSend(mail,ConstVar.mailUser,ConstVar.mailPsd,ConstVar.errorMail,false);
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
		}
		System.out.print(error);
        map.put("exception",error);//将错误信息传递给view  
        return new ModelAndView("/error/error",map);  
	}

}
