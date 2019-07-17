package com.zkhw.shanxi.Controller;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.util.StringUtil;
import com.zkhw.common.config.Config;
import com.zkhw.shanxi.bo.Businessdata;
import com.zkhw.shanxi.bo.Header;
import com.zkhw.shanxi.bo.Xdt;
import com.zkhw.shanxi.utils.ConvertObject;
import com.zkhw.shanxi.utils.IdTest;
import com.zkhw.shanxi.utils.TestPost;
import com.zkhw.shanxi.utils.XmlUtils;
import com.zkhw.shanxi.vo.XdtVo;

public class XdtTest {

	/**
	 * 心电图
	 * @param args
	 */
	public static void main(String[] args) {

		Businessdata data = new Businessdata();
		
		Header header = new Header();
		header.setFunctioncode("YTJ1011_2");
		header.setErrCode("0");
		header.setErrMsg("");
		header.setCmd("insert");
		data.setHeader(header);
		
		List<Object> list = new ArrayList<Object>();
		
		XdtVo xdtVo = new XdtVo();
		String typeName = "EHR_Arch_HealthCheck";
		IdTest idTest = new IdTest();
		String areaCode = "6104";//6199
		String duns = "61990011X1009";
		String token = "123456";
		String userId = "610404197712260672";
		String compId = "123";//企业的统一信用代码
		String id = idTest.getId(typeName, areaCode, duns, token, userId, compId);
		if(!StringUtil.isEmpty(id)) {
			xdtVo.setId(id);
		}
		
		xdtVo.setExamID("123");
		xdtVo.setHeartRate("0");
		xdtVo.setECGData("1,2");
		xdtVo.setXdtresult("1,2,3");
		xdtVo.setImageurl("xm15263");
		xdtVo.setECGUrl("http://");
		xdtVo.setIdNumber("131182199104265014");
		xdtVo.setIdNumber("131182199104265201");
		xdtVo.setName("韩");
		xdtVo.setPhone("13845216598");
		xdtVo.setHealthNO("1358245895");
		xdtVo.setOrganName("12352");
		xdtVo.setCreateName("刘晓敏");
		xdtVo.setCreateTime("2019-02-01");
		xdtVo.setUpdateName("刘丽");
		xdtVo.setUpdateTime("2019-02-01");
		xdtVo.setDataResType("SX0374");
		xdtVo.setSSupplierCode("1325486595X");
		xdtVo.setSMachineCode("01^1321251232");
		xdtVo.setIsSuccess("0");
		xdtVo.setUploadTime("2019-02-01");
		xdtVo.setErrReason("数据不全");
		
		Xdt xdt = ConvertObject.convertToXdt(xdtVo);
		list.add(xdt);
		
		data.setBody(list);
		
		String reqXml = XmlUtils.modelToStringXML(data);
		reqXml = reqXml.replace("<body>", "<body><![CDATA[");
		reqXml = reqXml.replace("</body>", "]]></body>");
		
		//System.out.println(reqXml);
		
		String verifyCode = "123456";
		
		String url = Config.shanxiUrl; 
		String param = "areaCode="+areaCode+"&duns="+duns+"&token="+token+"&userId="+userId +
		"&functionCode=" + "CHECK_1001" + "&verifyCode=" + verifyCode +	"&reqXml=" + reqXml;
		System.out.println(param);
		System.out.println(url);
		String result = TestPost.sendPost(url, param, 300, 300);
		System.out.println(result);
		
		
		//String result = "";
		//result = HttpUtils.send(areaCode, duns, token, userId, "CHECK_1001",verifyCode, reqXml);
		/*if(!"".equals(result)){
			Object r = XmlUtils.xmlToBean(result, ResponseXml.class);
			if(r != null){
				ResponseXml x = (ResponseXml)r;
				System.out.println("functionCode =" + x.getHeader().getFunctioncode());
				System.out.println("errcode =" + x.getHeader().getErrCode());
				System.out.println("msg =" + x.getHeader().getErrMsg());
				System.out.println("total =" + x.getBody().getRows_total());
				System.out.println("suc =" + x.getBody().getRows_suc());
				System.out.println("fail =" + x.getBody().getRows_faild());
				System.out.println("memo =" + x.getBody().getMemo());
				List<ResponseError> ll = x.getBody().getError();
				if(ll != null){
					for(int i = 0; i < ll.size(); i++){
						System.out.println(ll.get(i).getTypeId());
						System.out.println(ll.get(i).getInstanceId());
						System.out.println(ll.get(i).getErrorDesc());
					}
				}
			}
		}*/
		
	}
	
	
}
