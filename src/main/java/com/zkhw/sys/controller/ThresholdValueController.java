package com.zkhw.sys.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.util.StringUtil;
import com.zkhw.common.utils.CodeUtil;
import com.zkhw.common.utils.SystemParam;
import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.framework.utils.JsonConverter;
import com.zkhw.ltd.entity.User;
import com.zkhw.ltd.service.UserService;
import com.zkhw.sys.entity.ThresholdValue;
import com.zkhw.sys.service.ThresholdValueService;
import com.zkhw.sys.vo.ThresholdVo;

@Controller
@RequestMapping("/sys/threshold")
public class ThresholdValueController {

	@Autowired
	private ThresholdValueService thresholdValueService;
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/pagelist", method = RequestMethod.GET)
	public PageInfos<ThresholdValue>  findThresholdList(ThresholdValue record, PageInfos<ThresholdValue> pageData){
		pageData = thresholdValueService.findThresholdByPage(record, pageData);
		return pageData;
	}

	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ApiJsonResult  findThresholdList(ThresholdValue record){
		ApiJsonResult result = new ApiJsonResult();
		List<ThresholdValue> list = thresholdValueService.findThresholdList(record);
		result.setCode("0");
		result.setData(list);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ApiJsonResult saveThreshold(ThresholdValue record){
		ApiJsonResult result = new ApiJsonResult();
		try{
			String loginName = SystemParam.getUserId();
			User user = userService.findUserByLoginName(loginName);
			record.setId(CodeUtil.getUUID());
			if(user != null){
				record.setCreateUser(user.getUserCode());
				record.setCreateName(user.getUserName());
				record.setUpdateUser(user.getUserCode());
				record.setUpdateName(user.getUserName());
			}
			Date now = new Date();
			record.setCreateTime(now);
			record.setUpdateTime(now);
			thresholdValueService.saveThreshold(record);
			result.setCode("0");
		}catch(Exception e){
			result.setCode("1");
			result.setMsg("保存异常");
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateAll", method = RequestMethod.POST)
	public ApiJsonResult updateAllThreshold(String data){
		ApiJsonResult result = new ApiJsonResult();
		Date now = new Date();
		try{
			String loginName = SystemParam.getUserId();
			User user = userService.findUserByLoginName(loginName);			
			List<ThresholdVo> list = JsonConverter.json2ObjList(data, ThresholdVo.class);
			for(int i = 0; i < list.size(); i++){
				ThresholdVo vo = list.get(i);
				ThresholdValue val = new ThresholdValue();				
				val.setType(vo.getType());
				if(StringUtil.isNotEmpty(vo.getWarningMin())){
					val.setWarningMin(Float.valueOf(vo.getWarningMin()));
				}

				if(StringUtil.isNotEmpty(vo.getWarningMax())){
					val.setWarningMax(Float.valueOf(vo.getWarningMax()));
				}
				
				if(StringUtil.isNotEmpty(vo.getThresholdMax())){
					val.setThresholdMax(Float.valueOf(vo.getThresholdMax()));
				}

				if(StringUtil.isNotEmpty(vo.getThresholdMin())){
					val.setThresholdMin(Float.valueOf(vo.getThresholdMin()));
				}
				
				if(user != null){
					val.setUpdateUser(user.getUserCode());
					val.setUpdateName(user.getUserName());
				}
				
				val.setUpdateTime(now);				
				thresholdValueService.updateByType(val);
			}
			result.setCode("0");
		}catch(Exception e){
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("修改异常");
		}
		
		return result;
	}	

	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ApiJsonResult updateThreshold(ThresholdVo vo){
		ApiJsonResult result = new ApiJsonResult();
		Date now = new Date();
		try{
			String loginName = SystemParam.getUserId();
			User user = userService.findUserByLoginName(loginName);	
			
			ThresholdValue val = new ThresholdValue();				
			val.setType(vo.getType());
			if(StringUtil.isNotEmpty(vo.getWarningMin())){
				val.setWarningMin(Float.valueOf(vo.getWarningMin()));
			}

			if(StringUtil.isNotEmpty(vo.getWarningMax())){
				val.setWarningMax(Float.valueOf(vo.getWarningMax()));
			}
			
			if(StringUtil.isNotEmpty(vo.getThresholdMax())){
				val.setThresholdMax(Float.valueOf(vo.getThresholdMax()));
			}

			if(StringUtil.isNotEmpty(vo.getThresholdMin())){
				val.setThresholdMin(Float.valueOf(vo.getThresholdMin()));
			}
			
			if(user != null){
				val.setUpdateUser(user.getUserCode());
				val.setUpdateName(user.getUserName());
			}
			
			val.setUpdateTime(now);				
			thresholdValueService.updateByType(val);
			result.setCode("0");
		}catch(Exception e){
			e.printStackTrace();
			result.setCode("1");
			result.setMsg("修改异常");
		}
		
		return result;
	}
	@ResponseBody
	@RequestMapping(value = "/getThreshold", method = RequestMethod.POST)
	public ApiJsonResult getThreshold(String id){
		ThresholdValue threshold = thresholdValueService.getThresholdById(id);
		ApiJsonResult result = new ApiJsonResult();
		result.setCode("0");
		result.setData(threshold);
		return result;
	}
}
