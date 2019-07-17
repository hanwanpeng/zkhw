package com.zkhw.shanxi.Controller;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.util.StringUtil;
import com.zkhw.common.config.Config;
import com.zkhw.shanxi.bo.Businessdata;
import com.zkhw.shanxi.bo.Header;
import com.zkhw.shanxi.bo.Resident;
import com.zkhw.shanxi.utils.ConvertObject;
import com.zkhw.shanxi.utils.IdTest;
import com.zkhw.shanxi.utils.TestPost;
import com.zkhw.shanxi.utils.XmlUtils;
import com.zkhw.shanxi.vo.ResidentVo;

public class ResidentTest {
	
	/**
	 * 增加/修改个人建档信息
	 */
	public static void main(String[] args) {

		Businessdata data = new Businessdata();
		Header header = new Header();
		header.setFunctioncode("ARCH_1002");
		header.setErrCode("0");
		header.setErrMsg("");
		header.setCmd("insert");
		data.setHeader(header);
		
		List<Object> list = new ArrayList<Object>();
		
		ResidentVo residentVo = new ResidentVo();
		//获取Id
		String basicinfoName = "EHR_Arch_Basicinfo";
		IdTest idTest = new IdTest();
		String areaCode = "6104";//6199
		String duns = "61990011X1009";
		String token = "123456";
		String userId = "610404197712260672";
		String compId = "123";//企业的统一信用代码
		String basicinfoId = idTest.getId(basicinfoName, areaCode, duns, token, userId, compId);
		if(!StringUtil.isEmpty(basicinfoId)) {
			residentVo.setId(basicinfoId);
		}
		
		residentVo.setArchiveNo("23");//纸质档案号
		residentVo.setName("刘丽");//姓名
		residentVo.setSex("1");//性别
		residentVo.setBirthday("2001-02-02");//出生日期
		residentVo.setIdNumber("131182199204256231");//身份证号
		residentVo.setRegisterAddress("123265");//户籍所在地(省市区的六位号码字段)
		residentVo.setRegisterAddressDoor("1001");// 户籍所在地(门牌号)
		residentVo.setResidenceAddress("123265");//现住址(省市区的六位号码字段)
		residentVo.setResidenceAddressDoor("1001");//现住址(门牌号)
		residentVo.setCompany("西安第四建筑");
		residentVo.setPhone("13845695623");//电话 
		residentVo.setLinkName("刘丽");//联系人 
		residentVo.setLinkPhone("13854695623");//联系人电话
		residentVo.setResidentType("户籍");//常住类型
		residentVo.setNation("汉");//民族
		residentVo.setMedicalCode("13152624586954856954");//健康卡号
		residentVo.setDoctorName("138132659568452136");//责任医生
		residentVo.setIsPoor(1);//是否贫困
		residentVo.setCreateTime("2019-02-21");//建档日期
		residentVo.setCreateName("132152616253261526");//建档医生
		residentVo.setRemark("正常");//备注
		residentVo.setAichiveOrg("13152645251");//建档机构
		residentVo.setArchiveid("131182199204256231");
		residentVo.setArchstatus("SX0100_1");
		
		Resident resident = ConvertObject.convertToInsertResident(residentVo);
		list.add(resident);
		
		data.setBody(list);
		
		String reqXml = XmlUtils.modelToStringXML(data);
		reqXml = reqXml.replace("<body>", "<body><![CDATA[");
		reqXml = reqXml.replace("</body>", "]]></body>");
		System.out.println(reqXml);
		
		String verifyCode = "123456";	
		
		String url = Config.shanxiUrl; 
		String param = "areaCode="+areaCode+"&duns="+duns+"&token="+token+"&userType=1&userId="+userId +
		"&functionCode=" + "ARCH_1002" + "&verifyCode=" + verifyCode +"&compId=" + compId + "&reqXml=" + reqXml;
		
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
