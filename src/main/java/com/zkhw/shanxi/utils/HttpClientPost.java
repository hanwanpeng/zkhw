package com.zkhw.shanxi.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientPost {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private HttpRequestBase httpRequestBase;
	public CloseableHttpClient httpClient;
	public HttpClientPost() {
		httpRequestBase = new HttpPost();
	}

	public void setEntity(Object json) {
		if (json != null) {
			if (json instanceof String) {
				StringEntity entity = new StringEntity(json.toString(), Charset.forName("UTF-8"));
				((HttpPost) httpRequestBase).setEntity(entity);// 向下转型
			}
			if (json instanceof byte[]) {
				((HttpPost) httpRequestBase).setEntity(new ByteArrayEntity((byte[]) json));
			}
		}

	}
	public HttpResponse execute() throws Exception {
		//httpRequestBase.addHeader("Content-type","application/json; charset=utf-8");  
		//httpRequestBase.addHeader("Accept", "application/json"); 
		HttpResponse httpResponse = null;
		httpClient = HttpClients.createDefault();

		httpResponse = httpClient.execute(httpRequestBase);		
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		System.out.println("statusCode=" + statusCode);
		if (statusCode != HttpStatus.SC_OK && statusCode != 221) {
			String response = EntityUtils.toString(httpResponse.getEntity());
			logger.error("request failed  status:{}, response::{}", statusCode, response);
			throw new Exception("request failed: " + response);
		}

		return httpResponse;

	}
	
	public void setcompleteUrl(String url,Map<String, Object> params) {
		// TODO Auto-generated method stub
		if(params!=null)
		{
			url+="?";
			Set<Entry<String,Object>> entrys=params.entrySet();
			int size=entrys.size();
			int index=0;
			for(Entry<String,Object> entry:entrys)
			{
				url+=entry.getKey()+"="+entry.getValue();
				if(++index<size)
					url+="&";
			}
		}
		try {
			httpRequestBase.setURI(new URI(url));
		} catch (URISyntaxException e) {
			logger.error("url error: {}",e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void setHeader(Map<String, Object> params) {
		if (params != null) {
			Set<Entry<String, Object>> entrys = params.entrySet();
			for (Entry<String, Object> entry : entrys)
				httpRequestBase.setHeader(entry.getKey(),(String) entry.getValue());
		}
	}
}
