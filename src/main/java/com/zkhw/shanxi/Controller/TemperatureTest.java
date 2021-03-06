package com.zkhw.shanxi.Controller;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.util.StringUtil;
import com.zkhw.common.config.Config;
import com.zkhw.shanxi.bo.Businessdata;
import com.zkhw.shanxi.bo.Header;
import com.zkhw.shanxi.bo.Temperature;
import com.zkhw.shanxi.utils.ConvertObject;
import com.zkhw.shanxi.utils.IdTest;
import com.zkhw.shanxi.utils.TestPost;
import com.zkhw.shanxi.utils.XmlUtils;
import com.zkhw.shanxi.vo.TemperatureVo;

public class TemperatureTest {

	/**
	 * 体温
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Businessdata data = new Businessdata();
		
		Header header = new Header();
		header.setFunctioncode("YTJ1011_7");
		header.setErrCode("0");
		header.setErrMsg("");
		header.setCmd("insert");
		data.setHeader(header);
		
		List<Object> list = new ArrayList<Object>();
		
		TemperatureVo temperatureVo = new TemperatureVo();
		String typeName = "";
		IdTest idTest = new IdTest();
		String areaCode = "6104";//6199
		String duns = "61990011X1009";
		String token = "123456";
		String userId = "610404197712260672";
		String compId = "123";//企业的统一信用代码
		String id = idTest.getId(typeName, areaCode, duns, token, userId, compId);
		if(!StringUtil.isEmpty(id)) {
			temperatureVo.setId(id);
		}
		
		// 主键（引用检查记录表ID）
		temperatureVo.setExamID("123456789");
		temperatureVo.setAichiveNo("131182255");
		temperatureVo.setTemperature("37.1");//体温
		temperatureVo.setIdNumber("131182199104265201");;// 个人档案Id
		temperatureVo.setIdNumber("131182199104265201");// 被检查者身份证号
		temperatureVo.setName("韩");// 姓名
		temperatureVo.setPhone("13845216598");// 联系方式
		temperatureVo.setHealthNO("1358245895");// 健康卡号
		temperatureVo.setOrganName("12352");// 机构
		temperatureVo.setCreateName("刘晓敏");// 创建者
		temperatureVo.setCreateTime("2019-02-01");// 创建时间
		temperatureVo.setUpdateName("刘丽");// 修改者
		temperatureVo.setUpdateTime("2019-02-01");// 修改时间
		temperatureVo.setDataResType("SX0374");// 数据源类型
		temperatureVo.setSSupplierCode("1325486595X");// 设备供应商
		temperatureVo.setSMachineCode("01^1321251232");// 设备编码
		temperatureVo.setIsSuccess("0");// 是否上传成功
		temperatureVo.setUploadTime("2019-02-01");// 上传时间
		temperatureVo.setErrReason("数据不全");// 上传失败原因
		
		
		Temperature tem = ConvertObject.convertToTem(temperatureVo);
		list.add(tem);
		
		data.setBody(list);
		
		String reqXml = XmlUtils.modelToStringXML(data);
		reqXml = reqXml.replace("<body>", "<body><![CDATA[");
		reqXml = reqXml.replace("</body>", "]]></body>");
		
		System.out.println(reqXml);
		
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
