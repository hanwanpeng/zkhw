package com.zkhw.flup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.entity.ChildrenTcmRecord;
import com.zkhw.flup.entity.NeonatusInfo;
import com.zkhw.flup.service.ChildrenTcmService;

@Controller
@RequestMapping("/pub/childrenTcm")
public class ChildrenTcmController {
	
	@Autowired
	private ChildrenTcmService childrenTcmService;
	
	/**
	 * 儿童中医健康服务
	 * @param neonatus
	 * @param pageData
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public PageInfos<NeonatusInfo>  findTuberculosisList(NeonatusInfo neonatus, PageInfos<NeonatusInfo> pageData){
		pageData = childrenTcmService.findNeonatusByPage(neonatus, pageData);
		return pageData;		
	}
	
	
	/**
	 * 查看
	 * @param child
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getFollowRecord", method = RequestMethod.GET)
	public ApiJsonResult  getFollowRecord(ChildrenTcmRecord child){
		ApiJsonResult result = new ApiJsonResult();
		try{
			ChildrenTcmRecord record = childrenTcmService.findFollowRecordByAge(child);
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
