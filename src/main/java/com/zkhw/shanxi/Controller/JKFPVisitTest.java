package com.zkhw.shanxi.Controller;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.util.StringUtil;
import com.zkhw.common.config.Config;
import com.zkhw.shanxi.bo.Businessdata;
import com.zkhw.shanxi.bo.Header;
import com.zkhw.shanxi.bo.JKFPVisit;
import com.zkhw.shanxi.utils.ConvertObject;
import com.zkhw.shanxi.utils.IdTest;
import com.zkhw.shanxi.utils.TestPost;
import com.zkhw.shanxi.utils.XmlUtils;
import com.zkhw.shanxi.vo.JKFPVisitVo;

public class JKFPVisitTest {
	
	/**
	 * 增加/修改健康扶贫
	 */
	public static void main(String[] args) {

		Businessdata data = new Businessdata();
		Header header = new Header();
		header.setFunctioncode("JKFP_VISIT_1001");
		header.setErrCode("0");
		header.setErrMsg("");
		header.setCmd("insert");
		data.setHeader(header);
		
		List<Object> list = new ArrayList<Object>();
		
		JKFPVisitVo jkfpVisitVo = new JKFPVisitVo();
		//获取Id
		String fpName = "FP_Visit";
		IdTest idTest = new IdTest();
		String areaCode = "6104";//6199
		String duns = "61990011X1009";
		String token = "123456";
		String userId = "610404197712260672";
		String compId = "123";//企业的统一信用代码
		String fpNameId = idTest.getId(fpName, areaCode, duns, token, userId, compId);
		if(!StringUtil.isEmpty(fpNameId)) {
			jkfpVisitVo.setId(fpNameId);
		}
		
		jkfpVisitVo.setArchiveNo("23");//纸质档案号
		jkfpVisitVo.setIdNumber("13118219910526326");//身份证号
		jkfpVisitVo.setName("刘丽");//姓名
		jkfpVisitVo.setSex("GB_T_2261.1_2003_1");//性别
		jkfpVisitVo.setBirthday("2001-02-02");//出生日期
		jkfpVisitVo.setVisitDate("2019-02-12");//本次随访日期
		jkfpVisitVo.setVisitType("SX0160_3");//此次随访方式
		jkfpVisitVo.setVisitDoc("131192156232653269");//随访医生
		jkfpVisitVo.setGznr("扶贫");//工作内容
		jkfpVisitVo.setAdvice("评价与建议");//评价与建议
		jkfpVisitVo.setCreateOrg("123");//机构码
		
		
		JKFPVisit jkfpVisit = ConvertObject.convertToInsertJKFPVisit(jkfpVisitVo);
		list.add(jkfpVisit);
		
		data.setBody(list);
		
		String reqXml = XmlUtils.modelToStringXML(data);
		reqXml = reqXml.replace("<body>", "<body><![CDATA[");
		reqXml = reqXml.replace("</body>", "]]></body>");
		System.out.println(reqXml);
				
		String verifyCode = "123456";
			
		String url = Config.shanxiUrl; 
		String param = "areaCode="+areaCode+"&duns="+duns+"&token="+token+"&userId="+userId +
		"&functionCode=" + "JKFP_VISIT_1001" + "&verifyCode=" + verifyCode +"&compId=" + compId + "&reqXml=" + reqXml;
		
		String result = TestPost.sendPost(url, param, 300, 300);
		System.out.println(result);
		
		
	}
	
	
	
	

	/**
	 * 根据档案ID和身份证号查询个人档案信息
	 * @param args
	 */
	/*public static void main(String[] args) {
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
		//reqXml = reqXml.replace("<body>", "<body><![CDATA[");
		//reqXml = reqXml.replace("</body>", "]]></body>");
		
		System.out.println(reqXml);
		
		String areaCode = "6199";
		String duns = "61990011X1009";
		String token = "123456";
		String userId = "610404197712260672";
		String verifyCode = "123456";
		String compId = "123";
		
		
		String url = Config.shanxiUrl; 
		String param = "areaCode="+areaCode+"&duns="+duns+"&token="+token+"&userId="+userId +
		"&functionCode=" + "ARCH_4003" + "&verifyCode=" + verifyCode + "&compId="+ compId +	"&reqXml=" + reqXml;
		System.out.println(param);
		System.out.println(url);
		String result = TestPost.sendPost(url, param, 300, 300);
		result = result.replaceAll("\r|\n|\t", "");
		System.out.println(result);
		
		
		if(!"".equals(result)){
			Object r = XmlUtils.xmlToBean(result, ResidentXml.class);
			if(r != null){
				ResidentXml x = (ResidentXml)r;
				//System.out.println("functionCode =" + x.getHeader().getFunctioncode());
				//System.out.println("errcode =" + x.getHeader().getErrCode());
				//System.out.println("msg =" + x.getHeader().getErrMsg());
				
				//ResidentBody oi = x.getBody().getObjectInstance();
				
				}
			}
		}*/
		
	
	
	
}
