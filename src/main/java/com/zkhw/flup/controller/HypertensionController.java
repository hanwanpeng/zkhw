package com.zkhw.flup.controller;

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
import com.zkhw.pub.query.ResidentBaseInfoQuery;

@Controller
@RequestMapping("/pub/hypertension")
public class HypertensionController {

	@Autowired
	private HypertensionService hypertensionService;
	
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public PageInfos<HypertensionListBo>  findDiabetesList(ResidentBaseInfoQuery redident, PageInfos<HypertensionListBo> pageData){
		redident.setIsDiabetes(1);
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
