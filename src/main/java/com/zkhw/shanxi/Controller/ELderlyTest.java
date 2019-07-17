package com.zkhw.shanxi.Controller;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.util.StringUtil;
import com.zkhw.common.config.Config;
import com.zkhw.shanxi.bo.Businessdata;
import com.zkhw.shanxi.bo.Elderly;
import com.zkhw.shanxi.bo.Header;
import com.zkhw.shanxi.utils.ConvertObject;
import com.zkhw.shanxi.utils.IdTest;
import com.zkhw.shanxi.utils.TestPost;
import com.zkhw.shanxi.utils.XmlUtils;
import com.zkhw.shanxi.vo.ElderlyVo;

public class ELderlyTest {

	/**
	 * 中医体质辨识
	 */
	public static void main(String[] args) {

		Businessdata data = new Businessdata();
		Header header = new Header();
		header.setFunctioncode("OLD_HERB_1001");
		header.setErrCode("0");
		header.setErrMsg("");
		header.setCmd("insert");
		data.setHeader(header);

		List<Object> list = new ArrayList<Object>();

		ElderlyVo elderlyVo = new ElderlyVo();
		// 获取Id
		String oldHerbName = "EHR_Arch_OldHerb";
		IdTest idTest = new IdTest();
		String areaCode = "6104";//6199
		String duns = "61990011X1009";
		String token = "123456";
		String userId = "610404197712260672";
		String compId = "123";//企业的统一信用代码
		String oldHerbId = idTest.getId(oldHerbName, areaCode, duns, token, userId, compId);
		if (!StringUtil.isEmpty(oldHerbId)) {
			elderlyVo.setId(oldHerbId);
		}

		elderlyVo.setIdNumber("131182199104265023");
		elderlyVo.setServiceid("");
		elderlyVo.setServicename("");
		elderlyVo.setName("");
		// 问询
		elderlyVo.setIsEnergeti("SX0333_2");
		elderlyVo.setIsTired("SX0333_2");
		elderlyVo.setIsLoseHeart("SX0333_2");
		elderlyVo.setIsDeepVoice("SX0333_2");
		elderlyVo.setIsListless("SX0333_2");
		elderlyVo.setIsJitter("SX0333_2");
		elderlyVo.setIsAlone("SX0333_2");
		elderlyVo.setIsScare("SX0333_2");
		elderlyVo.setIsHeavy("SX0334_2");
		elderlyVo.setIsEyeDry("SX0333_2");
		elderlyVo.setIsExtreCold("SX0333_2");
		elderlyVo.setIsAfaidCold("SX0333_2");
		elderlyVo.setIsResistCold("SX0333_2");
		elderlyVo.setIsCatchCold("SX0335_2");
		elderlyVo.setIsSnorty("SX0333_2");
		elderlyVo.setIsStertorous("SX0333_2");
		elderlyVo.setIsAllergic("SX0336_2");
		elderlyVo.setIsHives("SX0333_2");
		elderlyVo.setIsEndermicBlood("SX0333_2");
		elderlyVo.setIsScore("SX0333_2");
		elderlyVo.setIsFeverDry("SX0333_2");
		elderlyVo.setIsBodyPain("SX0333_2");
		elderlyVo.setIsFaceLight("SX0333_2");
		elderlyVo.setIsFleck("SX0333_2");
		elderlyVo.setIsTetter("SX0333_2");
		elderlyVo.setIsLikeDrink("SX0333_2");
		elderlyVo.setArchiveNo("SX0333_2");
		elderlyVo.setIfFat("SX0333_2");
		elderlyVo.setIsScareColdFood("SX0333_2");
		elderlyVo.setIsStoolStick("SX0333_2()");
		elderlyVo.setIsStoolDry("SX0333_2");
		elderlyVo.setIsLinguaMassin("SX0333_2");
		elderlyVo.setIsLinguaVein("SX0333_2");
		// 结果
		elderlyVo.setQixuzhiResult("SX0088_2");
		elderlyVo.setYangxuzhiResult("SX0088_2");
		elderlyVo.setYinxuzhiResult("SX0088_2");
		elderlyVo.setTanshizhiResult("SX0088_2");
		elderlyVo.setShirezhiResult("SX0088_2");
		elderlyVo.setXueyuzhiResult("SX0088_2");
		elderlyVo.setQiyuzhiResult("SX0088_2");
		elderlyVo.setTebingzhiResult("SX0088_2");
		elderlyVo.setPinghezhiResult("SX0401_2");
		// 填表日期
		elderlyVo.setTestDate("2019-05-15");
		elderlyVo.setTestDoctor("131194199205126513");
		elderlyVo.setCreateOrg("123654789");
		// 得分
		elderlyVo.setQixuzhiScore(35);
		elderlyVo.setYangxuzhiScore(35);
		elderlyVo.setYinxuzhiScore(35);
		elderlyVo.setTanshizhiScore(35);
		elderlyVo.setShirezhiScore(35);
		elderlyVo.setXueyuzhiScore(35);
		elderlyVo.setQiyuzhiScore(35);
		elderlyVo.setTebingzhiSorce(35);
		elderlyVo.setPinghezhiSorce(35);
		// 指导
		elderlyVo.setQxz_guide("SX0352_4");
		elderlyVo.setYangxz_guide("SX0352_4");
		elderlyVo.setYinxz_guide("SX0352_4");
		elderlyVo.setTsz_guide("SX0352_4");
		elderlyVo.setSrz_guide("SX0352_4");
		elderlyVo.setXyz_guide("SX0352_4");
		elderlyVo.setQyz_guide("SX0352_4");
		elderlyVo.setTbz_guide("SX0352_4");
		elderlyVo.setPhz_guide("SX0352_4");
		// 其他指导
		elderlyVo.setQxz_guide_other("");
		elderlyVo.setYangxz_guide_other("");
		elderlyVo.setYinxz_guide_other("");
		elderlyVo.setTsz_guide_other("");
		elderlyVo.setSrz_guide_other("");
		elderlyVo.setXyz_guide_other("");
		elderlyVo.setQyz_guide_other("");
		elderlyVo.setTbz_guide_other("");
		elderlyVo.setPhz_guide_other("");

		Elderly elderly = ConvertObject.convertToInsertElderly(elderlyVo);
		list.add(elderly);

		data.setBody(list);

		String reqXml = XmlUtils.modelToStringXML(data);
		reqXml = reqXml.replace("<body>", "<body><![CDATA[");
		reqXml = reqXml.replace("</body>", "]]></body>");
		System.out.println(reqXml);

		String verifyCode = "123456";

		String url = Config.shanxiUrl;
		String param = "areaCode=" + areaCode + "&duns=" + duns + "&token=" + token + "&userId=" + userId
				+ "&functionCode=" + "OLD_HERB_1001" + "&verifyCode=" + verifyCode + "&compId=" + compId + "&reqXml="
				+ reqXml;

		String result = TestPost.sendPost(url, param, 300, 300);
		System.out.println(result);

	}

}
