package com.zkhw.code.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkhw.common.utils.ApiConstants;

@Controller
@RequestMapping("/code/nation")
public class NationController {

	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value = "/findNation", method = RequestMethod.GET)
	public Map findAllNation(){
		return ApiConstants.NATION;
		
	}
}
