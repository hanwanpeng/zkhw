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
import com.zkhw.flup.bo.HypertensionInfoBo;
import com.zkhw.flup.bo.HypertensionListBo;
import com.zkhw.flup.service.HypertensionService;
import com.zkhw.framework.utils.JsonWebPrintUtils;
import com.zkhw.pub.query.ResidentBaseInfoQuery;

@Controller
@RequestMapping("/pub/hypertension")
public class HypertensionController {

	@Autowired
	private HypertensionService hypertensionService;
	
	/**
	 * 高血压花名册
	 * @param redident
	 * @param pageData
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/hypertensionForExcel", method = RequestMethod.GET)
	public void hypertensionForExcel(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,ResidentBaseInfoQuery redident){
		try {
			hypertensionService.hypertensionForExcel(redident);
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
	public PageInfos<HypertensionListBo>  findDiabetesList(ResidentBaseInfoQuery redident, PageInfos<HypertensionListBo> pageData){
		redident.setIsHypertension(1);
		pageData = hypertensionService.findHypertensionByPage(redident, pageData);
		return pageData;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/getFollowRecord", method = RequestMethod.GET)
	public ApiJsonResult  getFollowRecord(String id){
		ApiJsonResult result = new ApiJsonResult();
		try{
			HypertensionInfoBo record = hypertensionService.getHypertensionFollowRecordById(id);
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
}
