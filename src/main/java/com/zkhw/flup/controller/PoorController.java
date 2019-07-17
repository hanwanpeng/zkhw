package com.zkhw.flup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.flup.bo.PoorListBo;
import com.zkhw.flup.service.PoorService;
import com.zkhw.pub.query.ResidentBaseInfoQuery;

@Controller
@RequestMapping("/pub/poor")
public class PoorController {

	@Autowired
	private PoorService poorService;
	
	
	/**
	 * 贫困
	 * @param redident
	 * @param pageData
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public PageInfos<PoorListBo>  findDiabetesList(ResidentBaseInfoQuery redident, PageInfos<PoorListBo> pageData){
		redident.setIsPoor(1);
		pageData = poorService.findPoorByPage(redident, pageData);
		return pageData;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/getPoorFollow", method = RequestMethod.GET)
	public ApiJsonResult  getFollowRecord(String id){
		ApiJsonResult result = new ApiJsonResult();
		try{
			PoorListBo record = poorService.getPoorFollowRecordById(id);
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
