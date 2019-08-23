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
import com.zkhw.flup.bo.TuberculosisListBo;
import com.zkhw.flup.entity.TuberculosisFollowRecord;
import com.zkhw.flup.entity.TuberculosisInfo;
import com.zkhw.flup.service.TuberculosisService;
import com.zkhw.framework.utils.JsonWebPrintUtils;
import com.zkhw.pub.query.ResidentBaseInfoQuery;

@Controller
@RequestMapping("/pub/tuberculosis")
public class TuberculosisController {

	@Autowired
	private TuberculosisService tuberculosisService;
	
	
	/**
	 * 肺结核花名册
	 * @param redident
	 * @param pageData
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/tuberculosisForExcel", method = RequestMethod.GET)
	public void tuberculosisForExcel(HttpServletRequest request, HttpServletResponse response,ApiJsonResult result,ResidentBaseInfoQuery resident){
			tuberculosisService.tuberculosisForExcel(result, request, response, resident);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public PageInfos<TuberculosisListBo>  findTuberculosisList(ResidentBaseInfoQuery redident, PageInfos<TuberculosisListBo> pageData){
		redident.setIsTuberculosis(1);
		pageData = tuberculosisService.findTuberculosisByPage(redident, pageData);
		return pageData;		
	}
	
	@ResponseBody
	@RequestMapping(value = "/findFollowList", method = RequestMethod.GET)
	public PageInfos<TuberculosisFollowRecord>  findFollowList(TuberculosisFollowRecord record, PageInfos<TuberculosisFollowRecord> pageData){
		pageData = tuberculosisService.findFollowRecordByPage(record, pageData);
		return pageData;		
	}
	
	@ResponseBody
	@RequestMapping(value = "/getFollowRecord", method = RequestMethod.GET)
	public ApiJsonResult  getFollowRecord(String id){
		ApiJsonResult result = new ApiJsonResult();
		try{
			TuberculosisFollowRecord record = tuberculosisService.getTuberculosisFollowRecordById(id);
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
	@RequestMapping(value = "/getTuberculosisInfo", method = RequestMethod.GET)
	public ApiJsonResult  getPsychosisInfo(String archiveNo){
		ApiJsonResult result = new ApiJsonResult();
		try{
			TuberculosisInfo record = tuberculosisService.getTuberculosisInfoByArchiveNo(archiveNo);
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
