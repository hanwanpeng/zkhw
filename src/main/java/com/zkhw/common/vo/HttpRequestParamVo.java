package com.zkhw.common.vo;

import com.alibaba.fastjson.JSONObject;

/**
 * 封装请求参数的实体类
 *
 */
public class HttpRequestParamVo {
	private JSONObject sysParam; //系统参数
	private JSONObject busParam; //业务参数
	
	public JSONObject getSysParam() {
		return sysParam;
	}
	public void setSysParam(JSONObject sysParam) {
		this.sysParam = sysParam;
	}
	public JSONObject getBusParam() {
		return busParam;
	}
	public void setBusParam(JSONObject busParam) {
		this.busParam = busParam;
	}
}
