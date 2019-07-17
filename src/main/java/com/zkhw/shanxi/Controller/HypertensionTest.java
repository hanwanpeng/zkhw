package com.zkhw.shanxi.Controller;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.util.StringUtil;
import com.zkhw.common.config.Config;
import com.zkhw.shanxi.bo.Businessdata;
import com.zkhw.shanxi.bo.Header;
import com.zkhw.shanxi.bo.Hypertension;
import com.zkhw.shanxi.bo.ResponseError;
import com.zkhw.shanxi.bo.ResponseXml;
import com.zkhw.shanxi.bo.TakeMedicineCondition;
import com.zkhw.shanxi.utils.ConvertObject;
import com.zkhw.shanxi.utils.IdTest;
import com.zkhw.shanxi.utils.TestPost;
import com.zkhw.shanxi.utils.XmlUtils;
import com.zkhw.shanxi.vo.HypertensionVo;
import com.zkhw.shanxi.vo.TakeMedicineVo;

public class HypertensionTest {

	/**
	 * 高血压
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Businessdata data = new Businessdata();

		Header header = new Header();
		header.setFunctioncode("HYPER_1001");
		header.setErrCode("0");
		header.setErrMsg("");
		header.setCmd("insert");
		data.setHeader(header);

		List<Object> list = new ArrayList<Object>();

		HypertensionVo hypertensionVo = new HypertensionVo();
		String hypertensionName = "EHR_Dis_Hypertensionvisit";
		IdTest idTest = new IdTest();
		String areaCode = "6104";//6199
		String duns = "61990011X1009";
		String token = "123456";
		String userId = "610404197712260672";
		String compId = "123";//企业的统一信用代码
		String hypertensionId = idTest.getId(hypertensionName, areaCode, duns, token, userId, compId);
		if (!StringUtil.isEmpty(hypertensionId)) {
			hypertensionVo.setId(hypertensionId);
		}

		hypertensionVo.setIdNumber("131182199215263256");// 档案ID
		hypertensionVo.setVisitDate("2019-02-02");// 访问日期
		hypertensionVo.setVisitType("SX0160_2");// 访问方式
		hypertensionVo.setVisitDoctor("131182199215263265");// 访问医生签名
		hypertensionVo.setSymptom("SX0054_1");// 症状
		hypertensionVo.setOtherSymptom("");// 其他症状
		hypertensionVo.setSbp(80);// 收缩压
		hypertensionVo.setDbp(120);// 舒张压
		hypertensionVo.setWeight("60");// 本次体重(kg)
		hypertensionVo.setTargetWeight("80");// 下次目标体重
		hypertensionVo.setHeight("165");// 身高(cm)
		hypertensionVo.setBmi("23.5");// 本次体质指数
		hypertensionVo.setTargetBmi("23");// 下次目标体质指数
		hypertensionVo.setHeartRate(69);// 心率（次/分）
		hypertensionVo.setOtherSign("无");// 其它体征
		hypertensionVo.setSmoken(0);// 日吸烟量
		hypertensionVo.setTargetSomken(0);// 目标日吸烟量（支）
		hypertensionVo.setWine(0);// 日饮酒量（两）
		hypertensionVo.setTargetWine(0);// 目标日饮酒量（两）
		hypertensionVo.setSportWeek(2);// 运动（次/周）
		hypertensionVo.setSportOnce(1);// 运动（分钟/次）
		hypertensionVo.setVisitClass("CV5501.07_1");// 此次随访分类
		hypertensionVo.setTargetSportWeek(3);// 目标运动(次/周)
		hypertensionVo.setTargetSportOnce(2);// 目标运动（分钟/次）
		hypertensionVo.setSaltIntake("SX0182_1");// 摄盐情况
		hypertensionVo.setTargetSaltIntake("SX0182_1");// 目标摄盐情况
		hypertensionVo.setMindAdjust("SX0056_1");// 心理调整
		hypertensionVo.setDoctorObey("SX0056_1");// 遵医行为
		hypertensionVo.setAssistExamine("无");// 辅助检查
		hypertensionVo.setDrugObey("SX0028_1"); // 服药依从性
		hypertensionVo.setUntowardEffect("SX0059_1"); // 有无药物不良反应
		hypertensionVo.setUntowardEffectDrug("无"); // 药物不良反应说明
		hypertensionVo.setReferralCode("1321524152"); // 转诊记录Id
		hypertensionVo.setNextVisitDate("2019-02-21");// 下次随访日期
		hypertensionVo.setAdvice("无"); // 评价与建议
		hypertensionVo.setCreateOrg("132515"); // 机构
		hypertensionVo.setTransferOrgan(""); // 转诊机构及科别
		hypertensionVo.setTransferReason(""); // 转诊原因

		Hypertension hyper = ConvertObject.convertToHypertension(hypertensionVo);
		list.add(hyper);

		// 主要用药情况
		TakeMedicineVo takeVo = new TakeMedicineVo();
		// 设置Id
		String druguseName = "EHR_Arch_Druguse";
		IdTest idTest4 = new IdTest();

		String druguseId = idTest4.getId(druguseName, areaCode, duns, token, userId, compId);
		if (!StringUtil.isEmpty(druguseId)) {
			takeVo.setId(druguseId);
		}

		takeVo.setArchiveNo("");
		takeVo.setIdNumber("131182199104265014");
		takeVo.setServiceName("SX0069_6");// SX0069_8 糖尿病
		takeVo.setExamId(hypertensionId);
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
		String param = "areaCode=" + areaCode + "&duns=" + duns + "&token=" + token + "&userId=" + userId
				+ "&functionCode=" + "HYPER_1001" + "&verifyCode=" + verifyCode + "&compId=" + compId + "&reqXml="
				+ reqXml;

		String result = TestPost.sendPost(url, param, 300, 300);
		result = result.replaceAll("\r|\n|\t", "");
		System.out.println(result);

		
		if (!"".equals(result)) {
			Object r = XmlUtils.xmlToBean(result, ResponseXml.class);
			if (r != null) {
				ResponseXml x = (ResponseXml) r;
				System.out.println("functionCode =" + x.getHeader().getFunctionCode());
				System.out.println("errcode =" + x.getHeader().getErrCode());
				System.out.println("msg =" + x.getHeader().getErrMsg());
				System.out.println("total =" + x.getBody().getRows_total());
				System.out.println("suc =" + x.getBody().getRows_suc());
				System.out.println("fail =" + x.getBody().getRows_faild());
				System.out.println("memo =" + x.getBody().getMemo());
				List<ResponseError> ll = x.getBody().getError();
				if (ll != null) {
					for (int i = 0; i < ll.size(); i++) {
						System.out.println(ll.get(i).getTypeId());
						System.out.println(ll.get(i).getInstanceId());
						System.out.println(ll.get(i).getErrorDesc());
					}
				}
			}
		}

	}

}
