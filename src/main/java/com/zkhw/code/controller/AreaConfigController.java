package com.zkhw.code.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkhw.code.entity.AreaConfig;
import com.zkhw.common.utils.CommonUtil;

@Controller
@RequestMapping("/code/area")
public class AreaConfigController {

	@Autowired
	private CommonUtil commonUtil;
	
	
	@ResponseBody
	@RequestMapping(value = "/findAllProvince", method = RequestMethod.GET)
	public List<AreaConfig> findAllProvince(){
		return commonUtil.getAllProvince();
		
	}	
	
	@ResponseBody
	@RequestMapping(value = "/findCity", method = RequestMethod.GET)
	public List<AreaConfig> findCity(String provinceCode){
		return commonUtil.getCity(provinceCode);		
	}
	
	@ResponseBody
	@RequestMapping(value = "/findCounty", method = RequestMethod.GET)
	public List<AreaConfig> findCounty(String cityCode){
		return commonUtil.getCounty(cityCode);	
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/findTowns", method = RequestMethod.GET)
	public List<AreaConfig> findTowns(String countyCode){
		return commonUtil.getTowns(countyCode);			
	}	

	@ResponseBody
	@RequestMapping(value = "/findVillage", method = RequestMethod.GET)
	public List<AreaConfig> findVillage(String townsCode){
		return commonUtil.getVillage(townsCode);			
	}	
	
}
