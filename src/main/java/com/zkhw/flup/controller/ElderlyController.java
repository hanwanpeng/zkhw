package com.zkhw.flup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.bo.ElderlyListBo;
import com.zkhw.flup.service.ElderlyService;
import com.zkhw.pub.entity.ElderlySelfcareEstimate;
import com.zkhw.pub.entity.ElderlyTcmRecord;
import com.zkhw.pub.query.ResidentBaseInfoQuery;

@Controller
@RequestMapping("/pub/elderly")
public class ElderlyController {
	
	@Autowired
	private ElderlyService elderlyService;
	
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public PageInfos<ElderlyListBo>  findPsychosisList(ResidentBaseInfoQuery redident, PageInfos<ElderlyListBo> pageData){
		redident.setMinage(65);
		pageData = elderlyService.findElderlyByPage(redident, pageData);
		return pageData;
		
	}

	@ResponseBody
	@RequestMapping(value = "/findTcmList", method = RequestMethod.GET)
	public ApiJsonResult  findTcmList(String archiveNo){
		ApiJsonResult result = new ApiJsonResult();
		try{
			List<ElderlyTcmRecord> record = elderlyService.getElderlyTcm(archiveNo);
			result.setCode("0");
			result.setData(record);
			
		}catch(Exception e){
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("查询异常");
		}				
		return result;		
	}
	
	@ResponseBody
	@RequestMapping(value = "/getTcmRecord", method = RequestMethod.GET)
	public ApiJsonResult  getTcmRecord(String id){
		ApiJsonResult result = new ApiJsonResult();
		try{
			ElderlyTcmRecord record = elderlyService.getTcmById(id);
			if(record != null){
				result.setCode("0");
				result.setData(record);
			}else{
				result.setCode("1");
				result.setMsg("没有中医体质辨识记录");
			}
		}catch(Exception e){
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("查询异常");
		}				
		return result;		
	}
	
	@ResponseBody
	@RequestMapping(value = "/getSelfcare", method = RequestMethod.GET)
	public ApiJsonResult  getSelfcare(String examId){
		ApiJsonResult result = new ApiJsonResult();
		try{
			ElderlySelfcareEstimate record = elderlyService.getSelfcareListByExamid(examId);
			if(record != null){
				result.setCode("0");
				result.setData(record);
			}else{
				result.setCode("1");
				result.setMsg("没有生活自理能力评估记录");
			}
		}catch(Exception e){
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("查询异常");
		}				
		return result;		
	}
}
