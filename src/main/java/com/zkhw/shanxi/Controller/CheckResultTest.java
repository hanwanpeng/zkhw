package com.zkhw.shanxi.Controller;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.util.StringUtil;
import com.zkhw.common.config.Config;
import com.zkhw.shanxi.bo.Businessdata;
import com.zkhw.shanxi.bo.CheckResult;
import com.zkhw.shanxi.bo.Header;
import com.zkhw.shanxi.utils.ConvertObject;
import com.zkhw.shanxi.utils.IdTest;
import com.zkhw.shanxi.utils.TestPost;
import com.zkhw.shanxi.utils.XmlUtils;
import com.zkhw.shanxi.vo.CheckResultVo;

public class CheckResultTest {

	/**
	 * 检查报告
	 * @param args
	 */
	public static void main(String[] args) {

		Businessdata data = new Businessdata();
		
		Header header = new Header();
		header.setFunctioncode("YTJ1012");
		header.setErrCode("0");
		header.setErrMsg("");
		header.setCmd("insert");
		data.setHeader(header);
		
		List<Object> list = new ArrayList<Object>();
		
	     CheckResultVo checkResultVo = new CheckResultVo();
	     String typeName = "";
		IdTest idTest = new IdTest();
		String areaCode = "6104";//6199
		String duns = "61990011X1009";
		String token = "123456";
		String userId = "610404197712260672";
		String compId = "123";//企业的统一信用代码
		String id = idTest.getId(typeName, areaCode, duns, token, userId, compId);
		if(!StringUtil.isEmpty(id)){
			checkResultVo.setId(id);
		}
		
		
		
		checkResultVo.setIdNumber("131182199104265201");;// 个人档案Id
		checkResultVo.setIdNumber("131182199104265201");;// 被检查者身份证号
		
		checkResultVo.setCheckDate("2019-02-01");//检查时间
		checkResultVo.setName("韩");// 姓名
		checkResultVo.setPhone("13845216598");// 联系方式
		checkResultVo.setHealthNO("1358245895");// 健康卡号
		checkResultVo.setCheckdoctor("王大夫");//检查人员
		checkResultVo.setCheckUrl("");//一体机检查报告地址
		checkResultVo.setCheckResult("");//检查报告结果
		
		checkResultVo.setHeartRate("");//心率(未检测录入0)
		checkResultVo.setECGData("");//心电数据（采样数据值逗号隔开）
		checkResultVo.setXdtresult("");//心电结果（逗号隔开）
		checkResultVo.setImageurl("");//心电图片（二进制数据字符串）
		checkResultVo.setECGUrl("");//心电图浏览地址（浏览地址Url
		
		checkResultVo.setGlucose("");//血糖
		
		checkResultVo.setSystolic("");//收缩压
		checkResultVo.setDiastolic("");//舒张压
		
		checkResultVo.setOxygen("");//血氧
		checkResultVo.setPulse("");//脉率
		
		checkResultVo.setTemperature("");//体温
		
		checkResultVo.setLeu("");
		checkResultVo.setNit("");
		checkResultVo.setUro("");
		checkResultVo.setPro("");
		checkResultVo.setPh("");
		checkResultVo.setBld("");
		checkResultVo.setSg("");
		checkResultVo.setKet("");
		checkResultVo.setBil("");
		checkResultVo.setGlu("");
		checkResultVo.setVc("");
		checkResultVo.setImg("");
		
		checkResultVo.setOrganName("12352");// 机构
		checkResultVo.setCreateName("刘晓敏");// 创建者
		checkResultVo.setCreateTime("2019-02-01");// 创建时间
		checkResultVo.setUpdateName("刘丽");// 修改者
		checkResultVo.setUpdateTime("2019-02-01");// 修改时间
		checkResultVo.setDataResType("SX0374");// 数据源类型
		checkResultVo.setSSupplierCode("1325486595X");// 设备供应商
		checkResultVo.setSMachineCode("01^1321251232");// 设备编码
		checkResultVo.setIsSuccess("0");// 是否上传成功
		checkResultVo.setUploadTime("2019-02-01");// 上传时间
		checkResultVo.setErrReason("数据不全");// 上传失败原因
		
		CheckResult checkResult = ConvertObject.convertToCheckResult(checkResultVo);
		list.add(checkResult);
		
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
		
		/*String result = "";
		result = HttpUtils.send(areaCode, duns, token, userId, "CHECK_1001",verifyCode, reqXml);
		if(!"".equals(result)){
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
