package com.zkhw.flup.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.bo.DiabetesFollowBo;
import com.zkhw.flup.bo.DiabetesListBo;
import com.zkhw.flup.entity.DiabetesFollowRecord;
import com.zkhw.flup.service.DiabetesService;
import com.zkhw.framework.utils.JsonWebPrintUtils;
import com.zkhw.pub.query.ResidentBaseInfoQuery;

@Controller
@RequestMapping("/pub/diabetes")
public class DiabetesController {

	@Autowired
	private DiabetesService diabetesService;
	
	
	/**
	 * 糖尿病花名册
	 * @param redident
	 * @param pageData
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/diabetesForExcel", method = RequestMethod.GET)
	public void diabetesForExcel(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,ResidentBaseInfoQuery redident){
		try {
			diabetesService.diabetesForExcel(redident);
			result.setCode("0");
			result.setMsg("成功，已导出到桌面");
		}catch (Exception e) {
			result.setCode("1");
			result.setMsg("失败");
		}
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}
	
	
	
	
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public PageInfos<DiabetesListBo>  findDiabetesList(ResidentBaseInfoQuery redident, PageInfos<DiabetesListBo> pageData){
		redident.setIsDiabetes(1);
		pageData = diabetesService.findDiabetesByPage(redident, pageData);
		return pageData;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/getFollowRecord", method = RequestMethod.GET)
	public ApiJsonResult  getFollowRecord(String id){
		ApiJsonResult result = new ApiJsonResult();
		try{
			DiabetesFollowBo record = diabetesService.getDiabetesFollowRecordById(id);
			if(record != null){
				result.setCode("0");
				result.setData(record);
			}else{
				result.setCode("1");
				result.setMsg("访问记录不存在");
			}
		}catch(Exception e){
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("查询异常");
		}				
		return result;		
	}
	
	@ResponseBody
	@RequestMapping(value = "/findFollowList", method = RequestMethod.GET)
	public PageInfos<DiabetesFollowRecord>  findFollowList(DiabetesFollowRecord record, PageInfos<DiabetesFollowRecord> pageData){
		pageData = diabetesService.findFollowRecordByPage(record, pageData);
		return pageData;		
	}
}
