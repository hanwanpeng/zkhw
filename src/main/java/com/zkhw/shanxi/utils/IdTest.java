package com.zkhw.shanxi.utils;

import com.zkhw.shanxi.bo.IdXml;

public class IdTest {

	
	public static void main(String[] args) {
		IdTest idTest = new IdTest();
		String areaCode = "6104";//6199
		String duns = "61990011X1009";
		String token = "123456";
		String userId = "610404197712260672";
		String compId = "123";//企业的统一信用代码
		idTest.getId("FP_Visit",areaCode,duns,token,userId,compId);
	
	}
	
	public String getId(String typeName,String areaCode,String duns,String token, String userId, String compId) {
		
		String url = UrlUtils.getUrl(areaCode);
		String param = "areaCode="+areaCode+"&duns="+duns+"&token="+token+"&userType=1&userId="+userId +"&compId=" + compId +
				"&functionCode=" + "COMM_1001" + "&typeName=" + typeName ;
		System.out.println(url);
		System.out.println(param);
		
		String result = TestPost.sendPost(url, param, 300, 300);
		result = result.replaceAll("\r|\n|\t", "");
		System.out.println(result);
		
		String id = "";
		if (!"".equals(result)) {
			Object r = XmlUtils.xmlToBean(result, IdXml.class);
			if (r != null) {
				IdXml x = (IdXml) r;
				/*System.out.println("functionCode =" + x.getHeader().getFunctioncode());
				System.out.println("errcode =" + x.getHeader().getErrCode());
				System.out.println("msg =" + x.getHeader().getErrMsg());
				System.out.println("typeName =" + x.getBody().getTypeName());
				System.out.println("id =" + x.getBody().getInstanceId());*/
				id = x.getBody().getInstanceId();
			}
		}
		System.out.println("id=" +id);
		return id;
	}

}
