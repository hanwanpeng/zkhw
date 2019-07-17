package com.zkhw.base.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class BaiduUtile {
	
	
	
	public static void main(String[] args) throws Exception { 
		String lat="31.931349213122"; 
		String lng="120.96189745647"; 
		
		String s = getLocationByBaiduMap(lng,lat);
		
		System.out.println(s); 
		
	}
	
	

	public static String getLocationByBaiduMap(String longitude, String latitude) throws Exception {
		System.out.println("--------------" + longitude + "-----------------");
		System.out.println("--------------" + latitude + "-----------------");
		String locJson = geturl("http://api.map.baidu.com/geoconv/v1/?coords=" + longitude + "," + latitude
				+ "&from=1&to=5&ak=7GAxnzcDaWjbiLx19K3Hge1OKBuK5alo");
		System.out.println(locJson);
		JSONObject jobject = JSON.parseObject(locJson);
		JSONArray jsonArray = jobject.getJSONArray("result");
		String lat = jsonArray.getJSONObject(0).getString("y");
		String lng = jsonArray.getJSONObject(0).getString("x");
		// System.out.println(lat);
		String addrJson = geturl("http://api.map.baidu.com/geocoder/v2/?ak=7GAxnzcDaWjbiLx19K3Hge1OKBuK5alo&location="
				+ lat + "," + lng + "&output=json&pois=1");
		System.out.println(addrJson);
		JSONObject jobjectaddr = JSON.parseObject(addrJson);
		// JSONObject rJsonObject=jobjectaddr.getJSONObject("result");
		// System.out.println(rJsonObject);
		String addr = jobjectaddr.getJSONObject("result").getString("formatted_address");
		// addr=(String) JSON.parseObject(addr).get("city");
		// addr=new String(addr.getBytes("gbk"),"UTF-8");
		return addr;
	}

	private static String geturl(String geturl) throws Exception {
		// 请求的webservice的url
		URL url = new URL(geturl);
		// 创建http链接
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		// 设置请求的方法类型 httpURLConnection.setRequestMethod("POST");

		httpURLConnection.setRequestMethod("POST");
		httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setDoInput(true);
		OutputStream outputStream = httpURLConnection.getOutputStream();
		String content = "user_id=" + URLEncoder.encode("13846", "utf-8");
		outputStream.write(content.getBytes());
		InputStream inputStream = httpURLConnection.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		while ((line = in.readLine()) != null) {
			buffer.append(line);
		}

		String str = buffer.toString();
		return str;
	}

}
