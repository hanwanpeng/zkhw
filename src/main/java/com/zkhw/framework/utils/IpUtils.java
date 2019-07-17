package com.zkhw.framework.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class IpUtils {
	private static Logger logger = Logger.getLogger(IpUtils.class);
	/**
	 * 本地服务器IP地址
	 */
	private static String LOCAL_IP = "";
	
	static {
		// 获取本机IP地址
		try {
			String tmpIP;
			Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
			while (netInterfaces.hasMoreElements()) {
				NetworkInterface ni = netInterfaces.nextElement();
				Enumeration<InetAddress> ias = ni.getInetAddresses();
				while (ias.hasMoreElements()) {
					tmpIP = ias.nextElement().getHostAddress();
					if (!tmpIP.equals("127.0.0.1") && tmpIP.indexOf(':') < 0) {
						LOCAL_IP = tmpIP;
						break;
					}
				}
				if (LOCAL_IP.length() > 0) {
					break;
				}
			}
		} catch (Exception e) {
			logger.info("获取本机IP地址出错!");
			logger.error(e,e.fillInStackTrace());
		}
	}
	
	/**
	 * 获取本机IP地址
	 */
	public static String getLocalIp() {
		return LOCAL_IP;
	}

	/**
	 * 获取客户端IP地址
	 */
	public static String getClientIp() {
		String clientIp = "";
		
		try {
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			
			if (request != null) {
				clientIp = request.getRemoteAddr();
			}
		} catch (Exception e) {
			logger.info("无法获取客户端IP");
			logger.error(e,e.fillInStackTrace());			
		}
		
		return clientIp;
	}
}
