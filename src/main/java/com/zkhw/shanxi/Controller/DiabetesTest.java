package com.zkhw.shanxi.Controller;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.util.StringUtil;
import com.zkhw.common.config.Config;
import com.zkhw.shanxi.bo.Businessdata;
import com.zkhw.shanxi.bo.Diabetes;
import com.zkhw.shanxi.bo.Header;
import com.zkhw.shanxi.bo.ResponseError;
import com.zkhw.shanxi.bo.ResponseXml;
import com.zkhw.shanxi.bo.TakeMedicineCondition;
import com.zkhw.shanxi.utils.ConvertObject;
import com.zkhw.shanxi.utils.IdTest;
import com.zkhw.shanxi.utils.TestPost;
import com.zkhw.shanxi.utils.XmlUtils;
import com.zkhw.shanxi.vo.DiabetesVo;
import com.zkhw.shanxi.vo.TakeMedicineVo;

public class DiabetesTest {

	/**
	 * 糖尿病
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Businessdata data = new Businessdata();
		
		Header header = new Header();
		header.setFunctioncode("DM_1001");
		header.setErrCode("0");
		header.setErrMsg("");
		header.setCmd("insert");
		data.setHeader(header);
		
		List<Object> list = new ArrayList<Object>();
		
		DiabetesVo diabetesVo = new DiabetesVo();
		String dmvisitName = "EHR_Dis_Dmvisit";
		IdTest idTest = new IdTest();
		String areaCode = "6104";//6199
		String duns = "61990011X1009";
		String token = "123456";
		String userId = "610404197712260672";
		String compId = "123";//企业的统一信用代码
		String dmvisitId = idTest.getId(dmvisitName, areaCode, duns, token, userId, compId);
		if(!StringUtil.isEmpty(dmvisitId)) {
			diabetesVo.setId(dmvisitId);
		}
		
		diabetesVo.setIdNumber("131182199215263256");//档案ID
		diabetesVo.setVisitDate("2019-02-02");//访问日期
		diabetesVo.setVisitDoctor("131182199215263265");//访问医生签名
		diabetesVo.setVisitType("SX0160_2");//访问方式
		diabetesVo.setSymptom("SX0054_1");//症状
		diabetesVo.setSymptomOther("");//其他症状
		diabetesVo.setBloodPressureHigh(80);//收缩压
		diabetesVo.setBloodPressureLow(120);//舒张压
		diabetesVo.setWeightNow("120");//本次体重(kg)
		diabetesVo.setWeightNext("110");//下次目标体重
		diabetesVo.setHeight("152");//身高(cm)
		diabetesVo.setBmiNow("45");//本次体质指数
		diabetesVo.setBmiNext("40");//下次目标体质指数
		diabetesVo.setDorsalArtery("10");//足背动脉搏动SX0399
		diabetesVo.setOther("");// 其他体征
		diabetesVo.setSmokeNow(0);//日吸烟量
		diabetesVo.setSmokeNext(0);//目标日吸烟量（支）
		diabetesVo.setDrinkNow(0);//日饮酒量（两）
		diabetesVo.setDrinkNext(0);//目标日饮酒量（两）
		diabetesVo.setSportsNumNow(2);//运动（次/周）
		diabetesVo.setSportsTimeNow(1);//运动（分钟/次）
		diabetesVo.setSportsNumNext(3);//目标运动(次/周)
		diabetesVo.setSportsTimeNext(2);//目标运动（分钟/次）
		diabetesVo.setStapleFoodNow("500");// 主食（克/天）
		diabetesVo.setStapleFoodNext("600");// 目标主食（克/天）
		diabetesVo.setPsychologicalRecovery("SX0056_1");//心理调整
		diabetesVo.setMedicalCompliance("SX0056_1");//遵医行为
		diabetesVo.setBloodGlucose("32");// 空腹血糖值
		diabetesVo.setGlycosylatedHemoglobin("12");//糖化血红蛋白
		diabetesVo.setCheckDate("2019_02_12");// 糖化血红蛋白检查日期
		diabetesVo.setOtherCheck("");//其他检查
		diabetesVo.setCompliance("SX0028_1");  //服药依从性
		diabetesVo.setUntowardEffect("SX0059_1");  //有无药物不良反应
		diabetesVo.setUntowardEffectDrug("无");  //药物不良反应说明
		diabetesVo.setReactiveHypoglycemia("无");// 低血糖反应
		diabetesVo.setFollowType("CV5501.07_1");//此次随访分类
		diabetesVo.setReferralCode("1321524152");  //转诊记录Id
		diabetesVo.setNextVisitDate("2019-02-21");//下次随访日期
		diabetesVo.setAdvice("");  //评价与建议
		diabetesVo.setCreateOrg("132515");  //机构
		diabetesVo.setAttenuate("SX0398_1"); //减弱SX0398
		diabetesVo.setDisapppear("SX0398_1");// 消失SX0398
		diabetesVo.setTransferTreatmentReason("");  // 转诊机构及科别
		diabetesVo.setTransferTreatmentDepartment("");  //转诊原因
		
		
		
		Diabetes diabetes = ConvertObject.convertToDiabetes(diabetesVo);
		list.add(diabetes);
		
		
		//主要用药情况
		TakeMedicineVo takeVo = new TakeMedicineVo();
		//设置Id
		String druguseName = "EHR_Arch_Druguse";
		IdTest idTest2 = new IdTest();
		
		String druguseId = idTest2.getId(druguseName, areaCode, duns, token, userId, compId);
		if(!StringUtil.isEmpty(druguseId)) {
			takeVo.setId(druguseId);
		}
		
		takeVo.setArchiveNo("");
		takeVo.setIdNumber("131182199215263256");
		takeVo.setServiceName("SX0069_8");//SX0069_8 糖尿病
		takeVo.setExamId(dmvisitId);
		takeVo.setMedicineType("CV5301.06_100");
		takeVo.setMedicineName("阿莫西林");
		takeVo.setMedicineUsage("一日一次");
		takeVo.setFrequency("SX0153_10");
		takeVo.setMedicineDosage("");
		takeVo.setUnit("SX0154_5");
		takeVo.setMedicineTime("2");
		takeVo.setMedicineTimeUnit("CV4202.05_2");
		takeVo.setMedicineCompliance("SX0028_1");
		takeVo.setOther("");
		takeVo.setCreateOrg("610000000000466");
		
		TakeMedicineCondition take = ConvertObject.convertToTakeMedicine(takeVo);
		list.add(take);
		
		
		data.setBody(list);
		
		String reqXml = XmlUtils.modelToStringXML(data);
		reqXml = reqXml.replace("<body>", "<body><![CDATA[");
		reqXml = reqXml.replace("</body>", "]]></body>");
		System.out.println(reqXml);
		
		String verifyCode = "123456";
		
		String url = Config.shanxiUrl; 
		String param = "areaCode="+areaCode+"&duns="+duns+"&token="+token+"&userId="+userId +
		"&functionCode=" + "DM_1001" + "&verifyCode=" + verifyCode +"&compId=" + compId + "&reqXml=" + reqXml;
		
		String result = TestPost.sendPost(url, param, 300, 300);
		result = result.replaceAll("\r|\n|\t", "");
		System.out.println(result);
		
		if(!"".equals(result)){
			Object r = XmlUtils.xmlToBean(result, ResponseXml.class);
			if(r != null){
				ResponseXml x = (ResponseXml)r;
				System.out.println("functionCode =" + x.getHeader().getFunctionCode());
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
		}
		
	}
	
	
}
