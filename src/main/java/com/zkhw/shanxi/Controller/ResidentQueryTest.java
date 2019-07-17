package com.zkhw.shanxi.Controller;

import com.zkhw.common.config.Config;

import com.zkhw.shanxi.bo.Header;

import com.zkhw.shanxi.bo.ResidentQuery;
import com.zkhw.shanxi.bo.Residentdata;
import com.zkhw.shanxi.utils.ConvertObject;

import com.zkhw.shanxi.utils.TestPost;
import com.zkhw.shanxi.utils.XmlUtils;
import com.zkhw.shanxi.vo.ResidentVo;

public class ResidentQueryTest {
	

	/**
	 * 根据档案ID和身份证号查询个人档案信息
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Residentdata data = new Residentdata();
		//Businessdata data = new Businessdata();
		Header header = new Header();
		header.setFunctioncode("ARCH_4003");
		header.setErrCode("0");
		header.setErrMsg("");
		data.setHeader(header);
		
		//List<Object> list = new ArrayList<Object>();
		
		ResidentVo vo = new ResidentVo();
		vo.setTypeId("1");
		vo.setIdNumber("610423199112150013");
		
		ResidentQuery resident = ConvertObject.convertToResident(vo);
		//list.add(resident);
		
		
		data.setBody(resident);
		
		
		String reqXml = XmlUtils.modelToStringXML(data);
		reqXml = reqXml.replace("<body>", "<body><![CDATA[");
		reqXml = reqXml.replace("</body>", "]]></body>");
		
		System.out.println(reqXml);
		
		String areaCode = "6199";
		String duns = "61990011X1009";
		String token = "123456";
		String userId = "610404197712260672";
		String verifyCode = "123456";
		String compId = "123";
		
		
		String url = Config.shanxiUrl; 
		String param = "areaCode="+areaCode+"&duns="+duns+"&token="+token+"&userType=1&userId="+userId +
		"&functionCode=" + "ARCH_4003" + "&verifyCode=" + verifyCode + "&compId="+ compId +	"&reqXml=" + reqXml;
		System.out.println(param);
		System.out.println(url);
		String result = TestPost.sendPost(url, param, 300, 300);
		result = result.replaceAll("\r|\n|\t", "");
		System.out.println(result);
		
		
		/*if(!"".equals(result)){
			Object r = XmlUtils.xmlToBean(result, ResidentXml.class);
			if(r != null){
				ResidentXml x = (ResidentXml)r;
				//System.out.println("functionCode =" + x.getHeader().getFunctioncode());
				//System.out.println("errcode =" + x.getHeader().getErrCode());
				//System.out.println("msg =" + x.getHeader().getErrMsg());
				
				//ResidentBody oi = x.getBody().getObjectInstance();
				
				}
			}*/
		}
		
	
	
	
}
