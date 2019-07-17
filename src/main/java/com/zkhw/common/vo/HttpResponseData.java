package com.zkhw.common.vo;

import java.util.List;
import java.util.Map;

/**
 * Http请求返回数据实体
 *
 */
public class HttpResponseData {
	// 报文头
	private Map<String, List<String>> header;
	
	// 正文
	private String body;
	
	public Map<String, List<String>> getHeader() {
		return header;
	}
	public void setHeader(Map<String, List<String>> header) {
		this.header = header;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}
