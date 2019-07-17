package com.zkhw.flup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.bo.PsychosisFollowBo;
import com.zkhw.flup.bo.PsychosisListBo;
import com.zkhw.flup.entity.PsychosisFollowRecord;
import com.zkhw.flup.entity.PsychosisInfo;
import com.zkhw.flup.service.PsychosisService;
import com.zkhw.pub.query.ResidentBaseInfoQuery;

@Controller
@RequestMapping("/pub/psychosis")
public class PsychosisController {

	@Autowired
	private PsychosisService psychosisService;
	
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public PageInfos<PsychosisListBo>  findPsychosisList(ResidentBaseInfoQuery redident, PageInfos<PsychosisListBo> pageData){
		redident.setIsPsychosis(1);
		pageData = psychosisService.findPsychosisByPage(redident, pageData);
		return pageData;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/getFollowRecord", method = RequestMethod.GET)
	public ApiJsonResult  getFollowRecord(String id){
		ApiJsonResult result = new ApiJsonResult();
		try{
			PsychosisFollowBo record = psychosisService.getPsychosisFollowRecordById(id);
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
	public PageInfos<PsychosisFollowRecord>  findFollowList(PsychosisFollowRecord record, PageInfos<PsychosisFollowRecord> pageData){
		pageData = psychosisService.findFollowRecordByPage(record, pageData);
		return pageData;		
	}
	
	@ResponseBody
	@RequestMapping(value = "/getPsychosisInfo", method = RequestMethod.GET)
	public ApiJsonResult  getPsychosisInfo(String archiveNo){
		ApiJsonResult result = new ApiJsonResult();
		try{
			PsychosisInfo record = psychosisService.getPsychosisInfoByArchiveNo(archiveNo);
			if(record != null){
				result.setCode("0");
				result.setData(record);
			}else{
				result.setCode("1");
				result.setMsg("用户信息不存在");
			}
		}catch(Exception e){
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("查询异常");
		}				
		return result;		
	}
}
