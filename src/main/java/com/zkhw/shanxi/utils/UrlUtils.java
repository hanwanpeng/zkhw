package com.zkhw.shanxi.utils;

import com.zkhw.common.config.Config;

public class UrlUtils {
	
	public static String getUrl(String areaCode){
		String url = Config.shanxiUrl;
		
		switch (areaCode) {
		case "610929":
			url = Config.baiheUrl;
			break;	
		case "611022":
			url = Config.danfengUrl;
			break;
		default:
			break;
		}
		
		return url;
	}

}
