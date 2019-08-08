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
import com.zkhw.flup.entity.ChildrenHealthRecord;
import com.zkhw.flup.entity.NeonatusInfo;
import com.zkhw.flup.service.ChildrenService;
import com.zkhw.framework.utils.JsonWebPrintUtils;
import com.zkhw.pub.query.ResidentBaseInfoQuery;

@Controller
@RequestMapping("/pub/children")
public class ChildrenController {
	
	@Autowired
	private ChildrenService childrenService;
	
	/**
	 * 0-6岁儿童花名册
	 * @param redident
	 * @param pageData
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/childrenForExcel", method = RequestMethod.GET)
	public void minElderlyForExcel(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,NeonatusInfo neonatus){
		try {
			childrenService.childrenForExcel(neonatus);
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
	public PageInfos<NeonatusInfo>  findTuberculosisList(NeonatusInfo neonatus, PageInfos<NeonatusInfo> pageData){
		pageData = childrenService.findNeonatusByPage(neonatus, pageData);
		return pageData;		
	}
	
	@ResponseBody
	@RequestMapping(value = "/getNeonatusInfo", method = RequestMethod.GET)
	public ApiJsonResult  NeonatusInfo(String id){
		ApiJsonResult result = new ApiJsonResult();
		try{
			NeonatusInfo record = childrenService.getNeonatusById(id);
			if(record != null){
				result.setCode("0");
				result.setData(record);
			}else{
				result.setCode("1");
				result.setMsg("儿童信息不存在");
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
	public ApiJsonResult  getFollowRecord(ChildrenHealthRecord child){
		ApiJsonResult result = new ApiJsonResult();
		try{
			ChildrenHealthRecord record = childrenService.findFollowRecordByAge(child);
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
