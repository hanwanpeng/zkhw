package com.zkhw.shanxi.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
public class TestPost {

	
	public static String sendPost(String url, String param, int readTimeout , int connectTimeout) {
			OutputStreamWriter out = null;
			BufferedReader in = null;
			String result = "";
			
			try {
				HttpURLConnection conn = getConnection(url,"TLS",readTimeout,connectTimeout);
				conn.setRequestProperty("accept", "*/*");
				conn.setRequestProperty("contentType","utf-8");
				conn.setRequestProperty("connection", "Keep-Alive");
				conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
				
				//post
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
				conn.setDoInput(true);
				
				out = new OutputStreamWriter(conn.getOutputStream(),"utf-8");
				out.write(param);
				out.flush();
				int status = conn.getResponseCode();
				System.out.println("status="+status);
				//in = new BufferedReader( new InputStreamReader(conn.getInputStream()));
				in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
				String line;
				while ((line = in.readLine()) != null) {
					result += line;
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (out != null) {
						out.close();
					}
					if (in != null) {
						in.close();
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			
			return result;
		}
		
	/**
	 * 
	 * @param url
	 * @param protocol
	 * @param readTimeout
	 * @param connectTimeout
	 * @return
	 */
	private static  HttpURLConnection getConnection(String url, String protocol, int readTimeout , int connectTimeout ){
			HttpURLConnection conn = null;
			// HTTPS
			if (url.toUpperCase().startsWith("HTTPS")){
				try{
					SSLContext sslContext = null;
					sslContext = SSLContext.getInstance(protocol);
					X509TrustManager[] xtmArray = new X509TrustManager[] {
							new X509TrustManager(){
								public void checkClientTrusted(X509Certificate[] chain, String authType) {}
								public void checkServerTrusted(X509Certificate[] chain, String authType) {}
								public X509Certificate[] getAcceptedIssuers() {
									return null;
								}
							} };
					sslContext.init(null, xtmArray, new java.security.SecureRandom());
					if (sslContext != null){
						HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
					}
					HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier(){
						public boolean verify(String arg0, SSLSession arg1){
							return true;
						}
					});
					conn = (HttpsURLConnection) (new URL(url).openConnection());
				}catch (Exception e){
					e.printStackTrace();
				}
			}else if (url.toUpperCase().startsWith("HTTP")){
				// HTTP
				try{
					conn = (HttpURLConnection) new URL(url).openConnection();
				}catch (IOException e){
					e.printStackTrace();
				}
			}
			if(readTimeout<30){
				readTimeout = 30;
			}
			if(connectTimeout<30){
				connectTimeout = 30;
			}
			conn.setReadTimeout(readTimeout * 1000);		//设置从主机读取数据超时（单位：毫秒）
			conn.setConnectTimeout(connectTimeout * 1000);	//设置连接主机超时（单位：毫秒）
			conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");
			conn.setRequestProperty("Charset", "utf-8");
			return conn;
		}	
}
