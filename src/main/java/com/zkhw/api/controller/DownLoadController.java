package com.zkhw.api.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkhw.api.bo.AccountInfoBo;
import com.zkhw.api.bo.AppUpdateBo;
import com.zkhw.api.bo.AreaBo;
import com.zkhw.api.bo.CheckResidentBatchBo;
import com.zkhw.api.bo.CheckResidentBo;
import com.zkhw.api.bo.DictBo;
import com.zkhw.api.bo.OrgBo;
import com.zkhw.api.bo.ResidentDownBo;
import com.zkhw.api.bo.Result;
import com.zkhw.api.bo.UserBo;
import com.zkhw.api.service.DownLoadService;
import com.zkhw.framework.utils.JsonWebPrintUtils;

@Controller
@RequestMapping("/Api/Download")
public class DownLoadController {
	
	@Autowired
	private DownLoadService downLoadService;
	
	@ResponseBody
	@RequestMapping(value = "/GetOrgInfos")
	public void getOrgInfos(HttpServletRequest request, HttpServletResponse response,String accessTokenKey,String startIndex,
			String returnSize,String duns) {
		
		Result r = new Result();
		try{
			OrgBo bo = downLoadService.getOrgList(startIndex, returnSize, duns);
			r.setCode(0);
			r.setMessage("Success");
			r.setData(bo);
		}catch(Exception e){
			e.printStackTrace();
			r.setCode(1);			
		}
		
		JsonWebPrintUtils.printApiResult(request, response, r);
	}
	
	@ResponseBody
	@RequestMapping(value = "/GetUserInfos")
	public void getUserInfos(HttpServletRequest request, HttpServletResponse response,String accessTokenKey,String startIndex,
			String returnSize,String deptNo) {
		
		Result r = new Result();
		try{
			UserBo bo = downLoadService.getUserList(startIndex, returnSize, deptNo);
			r.setCode(0);
			r.setMessage("Success");
			r.setData(bo);
		}catch(Exception e){
			e.printStackTrace();
			r.setCode(1);			
		}
		JsonWebPrintUtils.printApiResult(request, response, r);
	}
	
	@ResponseBody
	@RequestMapping(value = "/GetResidentInfos")
	public void getResidentInfos(HttpServletRequest request, HttpServletResponse response,String accessTokenKey,String startIndex,
			String returnSize,String duns) {
		
		Result r = new Result();
		try{
			ResidentDownBo bo = downLoadService.getResidentList(startIndex, returnSize, duns);
			r.setCode(0);
			r.setMessage("Success");
			r.setData(bo);
		}catch(Exception e){
			e.printStackTrace();
			r.setCode(1);			
		}
		JsonWebPrintUtils.printApiResult(request, response, r);
	}
	
	@ResponseBody
	@RequestMapping(value = "/GetAreas")
	public void getAreas(HttpServletRequest request, HttpServletResponse response,String accessTokenKey,String startIndex,
			String returnSize,String areaId) {
		
		Result r = new Result();
		try{
			AreaBo bo = downLoadService.getAreaInfoList(startIndex, returnSize, areaId);
			r.setCode(0);
			r.setMessage("Success");
			r.setData(bo);
		}catch(Exception e){
			e.printStackTrace();
			r.setCode(1);			
		}
		
		JsonWebPrintUtils.printApiResult(request, response, r);
	}
	
	@ResponseBody
	@RequestMapping(value = "/GetAreasLevel3")
	public void getAreasLevel3(HttpServletRequest request, HttpServletResponse response,String accessTokenKey,String startIndex,
			String returnSize) {
		
		Result r = new Result();
		try{
			AreaBo bo = downLoadService.getLevel3AreaInfoList(startIndex, returnSize);
			r.setCode(0);
			r.setMessage("Success");
			r.setData(bo);
		}catch(Exception e){
			e.printStackTrace();
			r.setCode(1);			
		}
		
		JsonWebPrintUtils.printApiResult(request, response, r);
	}	
	
	@ResponseBody
	@RequestMapping(value = "/GetDictionaries")
	public void getDictionaries(HttpServletRequest request, HttpServletResponse response,String accessTokenKey,String startIndex,
			String returnSize) {
		
		Result r = new Result();
		try{
			DictBo bo = downLoadService.getDictInfoList(startIndex, returnSize);
			r.setCode(0);
			r.setMessage("Success");
			r.setData(bo);
		}catch(Exception e){
			e.printStackTrace();
			r.setCode(1);			
		}
		
		JsonWebPrintUtils.printApiResult(request, response, r);
	}	
	
	@ResponseBody
	@RequestMapping(value = "/GetAccountInfos")
	public void getAccountInfos(HttpServletRequest request, HttpServletResponse response,String accessTokenKey,String startIndex,
			String returnSize) {
		
		Result r = new Result();
		try{
			AccountInfoBo bo = downLoadService.getAccountInfos(startIndex, returnSize);
			r.setCode(0);
			r.setMessage("Success");
			r.setData(bo);
		}catch(Exception e){
			e.printStackTrace();
			r.setCode(1);			
		}
		
		JsonWebPrintUtils.printApiResult(request, response, r);
	}
	
	@ResponseBody
	@RequestMapping(value = "/QueryHasBuild")
	public void queryHasBuild(HttpServletRequest request, HttpServletResponse response,String accessTokenKey,String idCard) {
		
		Result r = new Result();
		try{
			CheckResidentBo bo = downLoadService.exitResdident(idCard);
			r.setCode(0);
			r.setMessage("Success");
			r.setData(bo);
		}catch(Exception e){
			e.printStackTrace();
			r.setCode(1);			
		}
		
		JsonWebPrintUtils.printApiResult(request, response, r);
	}

	@ResponseBody
	@RequestMapping(value = "/QueryHasBuildForBatch")
	public void queryHasBuildForBatch(HttpServletRequest request, HttpServletResponse response,String accessTokenKey,String idCards) {
		
		Result r = new Result();
		try{
			List<CheckResidentBatchBo> bo = downLoadService.exitResdidentBatch(idCards);
			r.setCode(0);
			r.setMessage("Success");
			r.setData(bo);
		}catch(Exception e){
			e.printStackTrace();
			r.setCode(1);			
		}
		
		JsonWebPrintUtils.printApiResult(request, response, r);
	}
	
	@ResponseBody
	@RequestMapping(value = "/GetAppUpdate")
	public void getAppUpdate(HttpServletRequest request, HttpServletResponse response,String accessTokenKey) {
		
		Result r = new Result();
		try{
			AppUpdateBo bo = downLoadService.getAppUpdate();
			r.setCode(0);
			r.setMessage("Success");
			r.setData(bo);
		}catch(Exception e){
			e.printStackTrace();
			r.setCode(1);			
		}
		
		JsonWebPrintUtils.printApiResult(request, response, r);
	}	
}
