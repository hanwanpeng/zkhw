package com.zkhw.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.zkhw.framework.utils.StringUtils;

/**
 * 
 * @author hm
 *
 */
@Service
public  class  CodeUtil {

	
	/**
	 * uuid
	 * @return
	 */
	public static String getUUID() {
		  UUID uuid = UUID.randomUUID();
		  String str = uuid.toString();
		  //去掉"-"符号
		  String temp = str.replace("-", "");
		  return temp;
	}
	
	
	/**
	 * 权限菜单编码  18位
	 * @return   年月日时分秒（14位）+4位随机码
	 */
	public static String getRightCode() {
		SimpleDateFormat fomat =  new SimpleDateFormat("yyyyMMddHHmmss");
		String code = fomat.format(new Date())+StringUtils.randomNumber(4);
		return code;
	}
	
	
	/**
	 * 用户编码    16位
	 * @return   年月日时分秒（12位）+4位随机码
	 */
	public static String getUserCode() {
		SimpleDateFormat fomat =  new SimpleDateFormat("yyMMddHHmmss");
		String code = fomat.format(new Date())+StringUtils.randomNumber(4);
		return code;
	}
	
	
	/**
	 * 获取订单编码 22位 
	 * 年月日时分秒（14位）+8位随机码
	 */
	public static String getOrderCode() {
		SimpleDateFormat fomat =  new SimpleDateFormat("yyyyMMddHHmmss");
		String code = fomat.format(new Date())+StringUtils.randomNumber(8);
		return code;
	}
	
	/**
	 *
	 * 申请单号
	 */
	public static String getRequisitionCode() {
		SimpleDateFormat fomat =  new SimpleDateFormat("yyyyMMddHHmmss");
		String code = "R"+fomat.format(new Date())+StringUtils.randomNumber(3);
		return code;
	}
	
	
	/**
	 *
	 * 支付订单号
	 */
	public static String getPayOrderCode() {
		SimpleDateFormat fomat =  new SimpleDateFormat("yyyyMMddHHmmss");
		String code = "P"+fomat.format(new Date())+StringUtils.randomNumber(9);
		return code;
	}
	
	

	/**
	 *
	 * 患者码编码
	 */
	public static String getPatientCode(String stationCode) {
		SimpleDateFormat fomat =  new SimpleDateFormat("yyyyMMddHHmmss");
		String code = stationCode+fomat.format(new Date())+StringUtils.randomNumber(5);
		return code;
	}
	
	/**
	 * 获取打包编码编码 26位 
	 * 年月日时分秒（17位）+9位随机码
	 */
	public static String getBaleCode() {
		SimpleDateFormat fomat =  new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String code = fomat.format(new Date())+StringUtils.randomNumber(9);
		return code;
	}
	
}
