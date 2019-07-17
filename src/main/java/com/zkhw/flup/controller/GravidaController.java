package com.zkhw.flup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.entity.ChildrenHealthRecord;
import com.zkhw.flup.entity.GravidaAfterRecord;
import com.zkhw.flup.entity.GravidaFollowRecord;
import com.zkhw.flup.entity.GravidaInfo;
import com.zkhw.flup.query.GravidaInfoQuery;
import com.zkhw.flup.service.GravidaService;

@Controller
@RequestMapping("/pub/gravida")
public class GravidaController {

	@Autowired
	private GravidaService gravidaService;
	
	
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public PageInfos<GravidaInfo>  findGravidaList(GravidaInfoQuery gravida, PageInfos<GravidaInfo> pageData){
		pageData = gravidaService.findGravidaByPage(gravida, pageData);
		return pageData;		
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/getGravidaInfo", method = RequestMethod.GET)
	public ApiJsonResult  getGravidaInfo(String id){
		ApiJsonResult result = new ApiJsonResult();
		try{
			 GravidaInfo record = gravidaService.getGravidaInfoById(id);
			if(record != null){
				result.setCode("0");
				result.setData(record);
			}else{
				result.setCode("1");
				result.setMsg("孕产妇信息不存在");
			}
		}catch(Exception e){
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("查询异常");
		}				
		return result;		
	}	
	
	
	@ResponseBody
	@RequestMapping(value = "/getFollowRecord", method = RequestMethod.GET)
	public ApiJsonResult  getFollowRecord(GravidaFollowRecord gravida){
		ApiJsonResult result = new ApiJsonResult();
		try{
			GravidaFollowRecord record = gravidaService.findFollowRecordByOtherNum(gravida);
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
	@RequestMapping(value = "/gravidaAfterList", method = RequestMethod.GET)
	public PageInfos<GravidaAfterRecord> gravidaAfterList(GravidaAfterRecord gravida,PageInfos<GravidaAfterRecord> pageData){
		pageData = gravidaService.findGravidaAfterByPage(gravida,pageData);
		return pageData;	
	}	
	
	
	
	@ResponseBody
	@RequestMapping(value = "/getGravidaAfterRecord", method = RequestMethod.GET)
	public ApiJsonResult  getGravidaAfterRecord(String id){
		ApiJsonResult result = new ApiJsonResult();
		try{
			GravidaAfterRecord record = gravidaService.selectByPrimaryKey(id);
			if(record != null){
				result.setCode("0");
				result.setData(record);
			}else{
				result.setCode("1");
				result.setMsg("孕产妇信息不存在");
			}
		}catch(Exception e){
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("查询异常");
		}				
		return result;		
	}
	
	
	
	
	
}
