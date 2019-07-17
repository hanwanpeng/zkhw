package com.zkhw.shanxi.utils;


import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.zkhw.common.config.Config;

public class HttpUtils {

	public static String send(String areaCode, String duns, String token,String userId,String functionCode,String verifyCode, String reqXml){
		String result = "";
		String url = Config.shanxiUrl; 
		HttpClientPost post = new HttpClientPost();
		try{
			//String encode = java.net.URLEncoder.encode(reqXml);
			//encode = encode.replaceAll("\\+", "%20");
			//System.out.println(encode);
			//encode="<?xml version=\\\"1.0\\\" encoding=\\\"utf-8\\\"?>";
			//encode = java.net.URLEncoder.encode(encode);
			//encode = encode.replaceAll("\\+", "%20");
			String postUrl = url + "?areaCode="+areaCode+"&duns="+duns+"&token="+token+"&userId="+userId +
					"&functionCode=" + functionCode + "&verifyCode=" + verifyCode +	"&reqXml=" + reqXml;	
			System.out.println(postUrl);
			
			post.setcompleteUrl(postUrl, null);
			HttpResponse httpResponse = post.execute();
			String response = EntityUtils.toString(httpResponse.getEntity());
			//result = response;
			System.out.println("response="+response);
			
			return response;
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			try {
			post.httpClient.close();
			}catch(Exception e) {
				
			}
		}
		return result;
	}
}
