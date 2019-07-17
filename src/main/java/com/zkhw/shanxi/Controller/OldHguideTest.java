package com.zkhw.shanxi.Controller;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.util.StringUtil;
import com.zkhw.common.config.Config;
import com.zkhw.shanxi.bo.Businessdata;
import com.zkhw.shanxi.bo.Header;
import com.zkhw.shanxi.bo.OldHguide;
import com.zkhw.shanxi.utils.ConvertObject;
import com.zkhw.shanxi.utils.IdTest;
import com.zkhw.shanxi.utils.TestPost;
import com.zkhw.shanxi.utils.XmlUtils;
import com.zkhw.shanxi.vo.OldHguideVo;

public class OldHguideTest {

	/**
	 * 增加/修改老年人中医健康指导
	 */
	public static void main(String[] args) {

		Businessdata data = new Businessdata();
		Header header = new Header();
		header.setFunctioncode("OLD_HGUIDE_1001");
		header.setErrCode("0");
		header.setErrMsg("");
		header.setCmd("insert");
		data.setHeader(header);

		List<Object> list = new ArrayList<Object>();

		OldHguideVo oldHguideVo = new OldHguideVo();
		// 获取Id
		String basicinfoName = "EHR_HGuide_Older";
		IdTest idTest = new IdTest();
		String areaCode = "6104";//6199
		String duns = "61990011X1009";
		String token = "123456";
		String userId = "610404197712260672";
		String compId = "123";//企业的统一信用代码
		String basicinfoId = idTest.getId(basicinfoName, areaCode, duns, token, userId, compId);
		if (!StringUtil.isEmpty(basicinfoId)) {
			oldHguideVo.setId(basicinfoId);
		}

		oldHguideVo.setIdNumber("131182199210256325");
		oldHguideVo.setTel("13784265236");// 电话
		oldHguideVo.setFullname("刘丽");// 姓名
		oldHguideVo.setGender("GB_T_2261.1_2003_2");// 性别
		oldHguideVo.setBirthday("1986-10-21");// 出生日期
		oldHguideVo.setDiagnose("SX0353_1");// 体质辨识结果/证型
		oldHguideVo.setDiagnoseDesc("肚子大");// 体质辨识结果/证型描述
		oldHguideVo.setEduDate("2019-02-01");// 指导日期
		oldHguideVo.setEduDoctor("131182199105263598");// 指导医生
		oldHguideVo.setFeel("情志调摄");// 情志调摄
		oldHguideVo.setEat("饮食调养");// 饮食调养
		oldHguideVo.setQjts("起居调摄");// 起居调摄
		oldHguideVo.setSport("运动保健");// 运动保健
		oldHguideVo.setAcupoint("穴位保健");// 穴位保健
		oldHguideVo.setChannels("经络保健");// 经络保健
		oldHguideVo.setCare("注意事项");// 注意事项
		oldHguideVo.setOrher("其他指导");// 其他指导
		oldHguideVo.setDataSrc("SX0374_3");// 数据来源
		oldHguideVo.setDataMonment("接口上传");// 数据来源说明
		oldHguideVo.setDuns("123");// 录入机构

		OldHguide oldHguide = ConvertObject.convertToInsertOldHguide(oldHguideVo);
		list.add(oldHguide);

		data.setBody(list);

		String reqXml = XmlUtils.modelToStringXML(data);
		reqXml = reqXml.replace("<body>", "<body><![CDATA[");
		reqXml = reqXml.replace("</body>", "]]></body>");
		System.out.println(reqXml);

		String verifyCode = "123456";


		String url = Config.shanxiUrl;
		String param = "areaCode=" + areaCode + "&duns=" + duns + "&token=" + token + "&userId=" + userId
				+ "&functionCode=" + "OLD_HGUIDE_1001" + "&verifyCode=" + verifyCode + "&compId=" + compId + "&reqXml="
				+ reqXml;

		String result = TestPost.sendPost(url, param, 300, 300);
		System.out.println(result);

	}

}
