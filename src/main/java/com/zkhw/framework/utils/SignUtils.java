package com.zkhw.framework.utils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

/**
 * 签名工具类，要根据需求进行调�?;
 *
 */
public class SignUtils {
	private static final String CHARSET = "UTF-8";
	private static Logger logger = Logger.getLogger(SignUtils.class);
	
	public static void main(String[] args) {
		/*String secretKey = ApiConstants.SECRET_KEY_DEMO;
		Map<String,String> params = new HashMap<String, String>();
		params.put("method", "zks.demo.findUser");
		params.put("x", "1");
		params.put("y", "2");
		String sign = SignUtils.getSHA1Sign(params, secretKey);
		System.out.println("sign=" + sign); //ad2cfcca88970606b4c43f96e3f6f89beb0944aa
*/	}
	
    /**
     * getMD5Sign 			获取MD5签名
     * @param params		业务参数
     * @param secretKey 	客户标识密文
     * @return String		签名
     */
	public static String getMD5Sign(Map<String, String> params, String secretKey) {
		String sign = "";
		
		// 按参数名排序
		Map<String, String> sortMap = new TreeMap<String, String>();
		sortMap.putAll(params);
		
		// 生成待签名明�?
		StringBuffer sb = new StringBuffer();
		for (Map.Entry<String, String> entry : sortMap.entrySet()) {
			sb.append(String.valueOf(entry.getValue()));
		}
		sb.append(secretKey);
		
		logger.info("待签名参数：" + sortMap.toString() + secretKey);
		sign = MD5(sb.toString());
		logger.info("生成MD5签名�?" + sign);
		return sign;
	}

    /**
     * getSHA1SignByUser 	获取SHA1签名-客户相关
     * @param params		业务参数
     * @param apiPublicKey 	api公钥
     * @param apiSecretKey 	api秘钥
     * @param userSecret 	客户标识密文
     * @return String		签名
     */
	public static String getSHA1Sign(Map<String, String> params,String secretKey) {
		String sign = "";

		// 按参数名排序
		Map<String, String> sortMap = new TreeMap<String, String>();
		sortMap.putAll(params);

		// 生成待签名明�?
		StringBuffer sb = new StringBuffer();
		for (Map.Entry<String, String> entry : sortMap.entrySet()) {
			sb.append(String.valueOf(entry.getValue()));
		}
		sb.append(secretKey);
		
		logger.info("待签名参数：" + sortMap.toString() + secretKey );
		sign = SHA1(sb.toString());
		logger.info("生成SHA1签名�?" + sign);
		return sign;
	}

	// MD5加密算法
	public static String MD5(String sourceStr) {
		String result = "";
		MessageDigest md = null;
		
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			logger.error(e);
			return result;
		}

		byte sourceBytes[] = null;
		
        try {
        	sourceBytes = sourceStr.getBytes(CHARSET);
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			sourceBytes = sourceStr.getBytes();
		}
		
		md.update(sourceBytes);
		byte b[] = md.digest();
		int i;
		StringBuffer buf = new StringBuffer("");
		for (int offset = 0; offset < b.length; offset++) {
			i = b[offset];
			if (i < 0)
				i += 256;
			if (i < 16)
				buf.append("0");
			buf.append(Integer.toHexString(i));
		}
		result = buf.toString();
		// logger.info("MD5(" + sourceStr + ",32) = " + result);32�?
		// logger.info("MD5(" + sourceStr + ",16) = " +
		// buf.toString().substring(8, 24));16�?
		
		return result;
	}

	// SHA1加密算法
	public static String SHA1(String decript) {
		String result = "";
		MessageDigest digest = null;
		
		try {
			digest = java.security.MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			logger.error(e);
			return result;
		}

		byte sourceBytes[] = null;
		
        try {
        	sourceBytes = decript.getBytes(CHARSET);
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			sourceBytes = decript.getBytes();
		}
		
		digest.update(sourceBytes);
		byte messageDigest[] = digest.digest();
		// Create Hex String
		StringBuffer hexString = new StringBuffer();
		// 字节数组转换�? 十六进制 �?
		for (int i = 0; i < messageDigest.length; i++) {
			String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
			if (shaHex.length() < 2) {
				hexString.append(0);
			}
			hexString.append(shaHex);
		}
		result = hexString.toString();
		
		return result;
	}
}
