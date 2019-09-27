package com.zkhw.pub.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.framework.utils.JsonConverter;
import com.zkhw.framework.utils.JsonWebPrintUtils;
import com.zkhw.pub.entity.ResidentBaseInfo;
import com.zkhw.pub.query.ResidentBaseInfoQuery;
import com.zkhw.pub.service.PhysicalExaminationService;
import com.zkhw.pub.vo.AbnormalResultsVo;
import com.zkhw.pub.vo.ExaminationListVo;
import com.zkhw.pub.vo.PhysicalExaminationVo;
import com.zkhw.pub.vo.TjDataVo;

@Controller
@RequestMapping("/pub/exam")
public class PhysicalExaminationContoller {
	
	@Autowired
	private PhysicalExaminationService physicalExaminationService;
	
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public PageInfos<ExaminationListVo>  findResidentList(ResidentBaseInfoQuery info, PageInfos<ResidentBaseInfo> pageData){
		PageInfos<ExaminationListVo> page = physicalExaminationService.findPhysicalExaminationByPage(info, pageData);
		return page;		
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void showResident(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,String archiveNo){
		try {
			PhysicalExaminationVo vo = physicalExaminationService.getPhysicalExaminationByArchiveNo(archiveNo);
			AbnormalResultsVo abnormalResultsVo = physicalExaminationService.physicalToAbnormalResults(archiveNo);
			if(abnormalResultsVo != null) {
				vo.setAbnormalResultsVo(abnormalResultsVo);
			}
			result.setData(vo);
			result.setCode("0");
			result.setMsg("成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("失败");
		}
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}
	
	
	/**
	 * 根据身份证号查询体检报告（小程序）
	 * @param req
	 * @param resp
	 * @param result
	 * @param archiveNo
	 */
	@RequestMapping(value = "/physicalByIdNumber", method = RequestMethod.GET)
	public void physicalByIdNumber(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,String idNumber){
		try {
			PhysicalExaminationVo vo = physicalExaminationService.physicalByIdNumber(idNumber);
			result.setData(vo);
			result.setCode("0");
			result.setMsg("成功");
		} catch (Exception e) {
			result.setCode("1");
			result.setMsg("失败");
		}
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}
	
	
	/**
	 * 修改将康体检信息
	 */
	@RequestMapping(value = "/updatePhysical", method = RequestMethod.GET)
	public void updatePhysical(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,String physical){
		try {
			PhysicalExaminationVo vo = JsonConverter.json2Obj(physical,PhysicalExaminationVo.class);
			physicalExaminationService.updatePhysical(vo);
			result.setCode("0");
			result.setMsg("成功");
		} catch (Exception e) {
			result.setCode("1");
			result.setMsg("失败");
		}
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}
	
	@RequestMapping(value = "/getTjdata", method = RequestMethod.GET)
	public void getTjdata(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,String archiveNo){
		try {
			TjDataVo vo = physicalExaminationService.findTjData(archiveNo);
			result.setData(vo);
			result.setCode("0");
			result.setMsg("成功");
		} catch (Exception e) {
			result.setCode("1");
			result.setMsg("失败");
		}
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}	
	
}
