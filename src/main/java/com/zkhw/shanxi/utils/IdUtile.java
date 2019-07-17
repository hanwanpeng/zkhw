package com.zkhw.shanxi.utils;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

public class IdUtile {

	public static String send(String areaCode, String duns, String token,String userId,String functionCode,String typeName,String compId){
		String result = "";
		String url = UrlUtils.getUrl(areaCode);
		try{
			String postUrl = url + "?areaCode="+areaCode+"&duns="+duns+"&token="+token+"&userId="+userId +
					"&functionCode=" + functionCode + "&typeName=" + typeName + "&compId=" + compId;	
			System.out.println(postUrl);
			HttpClientPost post = new HttpClientPost();
			post.setcompleteUrl(postUrl, null);
			HttpResponse httpResponse = post.execute();
			String response = EntityUtils.toString(httpResponse.getEntity());
			result = response;
			System.out.println(response);
			post.httpClient.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}	
	
	
	
}
