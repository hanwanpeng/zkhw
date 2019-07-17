package com.zkhw.flup.controller;

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
import com.zkhw.pub.query.ResidentBaseInfoQuery;

@Controller
@RequestMapping("/pub/diabetes")
public class DiabetesController {

	@Autowired
	private DiabetesService diabetesService;
	
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
