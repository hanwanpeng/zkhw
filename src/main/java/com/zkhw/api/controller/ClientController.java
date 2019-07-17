package com.zkhw.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.util.StringUtil;
import com.zkhw.api.bo.Result;
import com.zkhw.framework.utils.JsonWebPrintUtils;
import com.zkhw.ltd.entity.Organization;
import com.zkhw.ltd.entity.User;
import com.zkhw.ltd.service.OrganizationService;
import com.zkhw.ltd.service.UserService;
import com.zkhw.shanxi.bo.BaseElement;
import com.zkhw.shanxi.bo.Header;
import com.zkhw.shanxi.bo.ResidentQuery;
import com.zkhw.shanxi.bo.Residentdata;
import com.zkhw.shanxi.utils.ConvertObject;
import com.zkhw.shanxi.utils.TestPost;
import com.zkhw.shanxi.utils.UrlUtils;
import com.zkhw.shanxi.utils.XmlUtils;
import com.zkhw.shanxi.vo.ResidentBody;
import com.zkhw.shanxi.vo.ResidentVo;
import com.zkhw.shanxi.vo.ResidentXml;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/getIsPoor")
	public void getIsPoor(HttpServletRequest request, HttpServletResponse response,String idNumber,String orgCode,String userId) {
		
		Result res = new Result();
		String ispoor = "0";
		Residentdata data = new Residentdata();
		Header header = new Header();
		header.setFunctioncode("ARCH_4003");
		header.setErrCode("0");
		header.setErrMsg("");
		data.setHeader(header);
		
		ResidentVo vo = new ResidentVo();
		vo.setTypeId("1");
		vo.setIdNumber(idNumber);
		
		ResidentQuery resident = ConvertObject.convertToResident(vo);

		data.setBody(resident);
		
		String reqXml = XmlUtils.modelToStringXML(data);
		reqXml = reqXml.replace("<body>", "<body><![CDATA[");
		reqXml = reqXml.replace("</body>", "]]></body>");
		String areaCode = "6199";
		Organization o = organizationService.getOrganizationByCode(orgCode);
		if(o != null){
			areaCode = o.getCountyCode();
		}
		String duns = orgCode;
		String token = "123456";
		User u = userService.findUserByCode(userId);
		if( u == null){
			u = userService.findUserByLoginName(userId);
		}
		if(u != null){
			if(StringUtil.isNotEmpty(u.getPubUsercode())){
				userId = u.getPubUsercode();
			}else{
				userId = u.getLoginName();
			}
		}
		String functionCode = "ARCH_4003";
		String verifyCode = "123456";
		String compId = "123";
		
		String result = this.send(areaCode, duns, token, userId, functionCode, verifyCode, compId, reqXml);
		System.out.println(result);
		if(!"".equals(result)){
			Object r = XmlUtils.xmlToBean(result, ResidentXml.class);
			if(r != null){
				ResidentXml x = (ResidentXml)r;
				String errCode = x.getHeader().getErrCode();
				if("0".equals(errCode)){
					ResidentBody body = x.getBody().getObjectInstance();
					if(body != null){

						BaseElement poor = body.getIsSign();
						if(poor != null){
							if(StringUtil.isNotEmpty(poor.getValue())){
								if("SX0083_1".equals(poor.getValue())){
									ispoor = "1";
								}else{
									ispoor = "0";
								}
							}
						}
					}
				}
			}
		}
		res.setCode(0);
		res.setData(ispoor);
		JsonWebPrintUtils.printApiResult(request, response, res);
	}
		
	private String send(String areaCode, String duns, String token,String userId, String functionCode,String verifyCode,String compId, String reqXml){
		String url = UrlUtils.getUrl(areaCode);
		String param = "areaCode="+areaCode+"&duns="+duns+"&token="+token+"&userType=1&userId="+userId +
		"&functionCode=" + functionCode + "&verifyCode=" + verifyCode +"&compId=" + compId + "&reqXml=" + reqXml;
		String result = TestPost.sendPost(url, param, 300, 300);
		return result;
		
	}
}
