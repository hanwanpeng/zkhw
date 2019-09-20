package com.zkhw.api.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aliyun.oss.model.PutObjectResult;
import com.github.pagehelper.util.StringUtil;
import com.zkhw.api.bo.Result;
import com.zkhw.common.config.Config;
import com.zkhw.common.utils.AliOssUtil;
import com.zkhw.common.utils.PdfUtils;
import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.flup.entity.GravidaInfo;
import com.zkhw.flup.service.ChildrenService;
import com.zkhw.flup.service.DiabetesService;
import com.zkhw.flup.service.GravidaService;
import com.zkhw.flup.service.HypertensionService;
import com.zkhw.flup.service.PsychosisService;
import com.zkhw.flup.service.TuberculosisService;
import com.zkhw.framework.utils.JsonWebPrintUtils;
import com.zkhw.pub.dao.ResidentBaseInfoDao;
import com.zkhw.pub.entity.ResidentBaseInfo;

@Controller
@RequestMapping("/Api/Export")
public class ApiExportController {
	
	@Autowired
	private HypertensionService hypertensionService;
	
	@Autowired
	private DiabetesService diabetesService;
	
	@Autowired
	private PsychosisService psychosisService;

	@Autowired
	private TuberculosisService tuberculosisService;
	
	@Autowired
	private ResidentBaseInfoDao residentBaseInfoDao;
	
	@Autowired
	private ChildrenService childrenService;
	
	@Autowired
	private GravidaService gravidaService;

	@RequestMapping(value = "/hypFollowPdf", method = RequestMethod.GET)
	public void hypFollowPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		Result r = new Result();
		String archiveNo = request.getParameter("archiveNo");
		String year = request.getParameter("year");
		//archiveNo = "45042110220205555";
		String path = request.getSession().getServletContext().getRealPath("template");
		String templatePath = path+ File.separator + "hypFollow.pdf";
		
		String tempPath = request.getSession().getServletContext().getRealPath("temp");
		String key = archiveNo;
		List<ResidentBaseInfo> list = residentBaseInfoDao.findResidentByArchiveNo(archiveNo);
		if(list != null && list.size() > 0){
			key = "高血压随访_" + list.get(0).getName();
		}
		String fileName =  tempPath + File.separator + key + ".pdf";

		File uploadFile = new File(tempPath,key + ".pdf");
		if (!uploadFile.exists()) {
			uploadFile.createNewFile();
		}
		
		try {	

			Map<String, String> map = hypertensionService.exportPdf(archiveNo, year);

			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			PdfUtils.pdfout(o, templatePath,fileName);
						
			PutObjectResult putresult = AliOssUtil.putFile(key, Config.bucketName, uploadFile);
			if(putresult != null){
				if (uploadFile.exists()) {
					uploadFile.delete();
				}
			}
			
			String url = AliOssUtil.presignedURL(Config.bucketName, key);
			r.setCode(0);
			r.setMessage("Success");
			r.setData(url);
			JsonWebPrintUtils.printApiResult(request, response, r);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}	
	
	@RequestMapping(value = "/diaFollowPdf", method = RequestMethod.GET)
	public void diaFollowPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		Result r = new Result();
		String archiveNo = request.getParameter("archiveNo");
		String year = request.getParameter("year");
		//archiveNo = "45042110220205555";
		String path = request.getSession().getServletContext().getRealPath("template");
		String templatePath = path+ File.separator + "diaFollow.pdf";
		
		String tempPath = request.getSession().getServletContext().getRealPath("temp");
		String key = archiveNo;
		List<ResidentBaseInfo> list = residentBaseInfoDao.findResidentByArchiveNo(archiveNo);
		if(list != null && list.size() > 0){
			key = "糖尿病随访_" + list.get(0).getName();
		}
		String fileName =  tempPath + File.separator + key + ".pdf";

		File uploadFile = new File(tempPath,key + ".pdf");
		if (!uploadFile.exists()) {
			uploadFile.createNewFile();
		}
		
		try {	

			Map<String, String> map = diabetesService.exportPdf(archiveNo, year);

			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			PdfUtils.pdfout(o, templatePath,fileName);
						
			PutObjectResult putresult = AliOssUtil.putFile(key, Config.bucketName, uploadFile);
			if(putresult != null){
				if (uploadFile.exists()) {
					uploadFile.delete();
				}
			}
			
			String url = AliOssUtil.presignedURL(Config.bucketName, key);
			r.setCode(0);
			r.setMessage("Success");
			r.setData(url);
			JsonWebPrintUtils.printApiResult(request, response, r);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
	
	@RequestMapping(value = "/psyInfoPdf", method = RequestMethod.GET)
	public void psyInfoPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		Result r = new Result();
		String archiveNo = request.getParameter("archiveNo");
		//archiveNo = "45042110220205555";
		String path = request.getSession().getServletContext().getRealPath("template");
		String templatePath = path+ File.separator + "psyInfo.pdf";
		
		String tempPath = request.getSession().getServletContext().getRealPath("temp");
		String key = archiveNo;
		List<ResidentBaseInfo> list = residentBaseInfoDao.findResidentByArchiveNo(archiveNo);
		if(list != null && list.size() > 0){
			key = "严重精神障碍补充信息_" + list.get(0).getName();
		}
		String fileName =  tempPath + File.separator + key + ".pdf";

		File uploadFile = new File(tempPath,key + ".pdf");
		if (!uploadFile.exists()) {
			uploadFile.createNewFile();
		}
		
		try {	

			Map<String, String> map = psychosisService.exportInfoPdf(archiveNo);

			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			PdfUtils.pdfout(o, templatePath,fileName);
						
			PutObjectResult putresult = AliOssUtil.putFile(key, Config.bucketName, uploadFile);
			if(putresult != null){
				if (uploadFile.exists()) {
					uploadFile.delete();
				}
			}
			
			String url = AliOssUtil.presignedURL(Config.bucketName, key);
			r.setCode(0);
			r.setMessage("Success");
			r.setData(url);
			JsonWebPrintUtils.printApiResult(request, response, r);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	@RequestMapping(value = "/psyFollowPdf", method = RequestMethod.GET)
	public void psyFollowPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		Result r = new Result();
		String archiveNo = request.getParameter("archiveNo");
		//String id = request.getParameter("id");
		//archiveNo = "45042110220205555";
		String path = request.getSession().getServletContext().getRealPath("template");
		String templatePath = path+ File.separator + "psyFollow.pdf";
		
		String tempPath = request.getSession().getServletContext().getRealPath("temp");
		String key = archiveNo;
		List<ResidentBaseInfo> list = residentBaseInfoDao.findResidentByArchiveNo(archiveNo);
		if(list != null && list.size() > 0){
			key = "严重精神障碍随访_" + list.get(0).getName();
		}
		String fileName =  tempPath + File.separator + key + ".pdf";

		File uploadFile = new File(tempPath,key + ".pdf");
		if (!uploadFile.exists()) {
			uploadFile.createNewFile();
		}
		
		try {	

			Map<String, String> map = psychosisService.exportFollowPdf(archiveNo);

			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			PdfUtils.pdfout(o, templatePath,fileName);
						
			PutObjectResult putresult = AliOssUtil.putFile(key, Config.bucketName, uploadFile);
			if(putresult != null){
				if (uploadFile.exists()) {
					uploadFile.delete();
				}
			}
			
			String url = AliOssUtil.presignedURL(Config.bucketName, key);
			r.setCode(0);
			r.setMessage("Success");
			r.setData(url);
			JsonWebPrintUtils.printApiResult(request, response, r);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
	
	@RequestMapping(value = "/tubInfoPdf", method = RequestMethod.GET)
	public void tubInfoPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		Result r = new Result();
		String archiveNo = request.getParameter("archiveNo");
		//archiveNo = "45042110220205555";
		String path = request.getSession().getServletContext().getRealPath("template");
		String templatePath = path+ File.separator + "tubInfo.pdf";
		
		String tempPath = request.getSession().getServletContext().getRealPath("temp");
		String key = archiveNo;
		List<ResidentBaseInfo> list = residentBaseInfoDao.findResidentByArchiveNo(archiveNo);
		if(list != null && list.size() > 0){
			key = "肺结核第一次随访_" + list.get(0).getName();
		}
		String fileName =  tempPath + File.separator + key + ".pdf";

		File uploadFile = new File(tempPath,key + ".pdf");
		if (!uploadFile.exists()) {
			uploadFile.createNewFile();
		}
		
		try {	

			Map<String, String> map = tuberculosisService.exportInfoPdf(archiveNo);

			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			PdfUtils.pdfout(o, templatePath,fileName);
						
			PutObjectResult putresult = AliOssUtil.putFile(key, Config.bucketName, uploadFile);
			if(putresult != null){
				if (uploadFile.exists()) {
					uploadFile.delete();
				}
			}
			
			String url = AliOssUtil.presignedURL(Config.bucketName, key);
			r.setCode(0);
			r.setMessage("Success");
			r.setData(url);
			JsonWebPrintUtils.printApiResult(request, response, r);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
	
	@RequestMapping(value = "/tubFollowPdf", method = RequestMethod.GET)
	public void tubFollowPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		Result r = new Result();
		String archiveNo = request.getParameter("archiveNo");
		String year = request.getParameter("year");
		//archiveNo = "45042110220205555";
		String path = request.getSession().getServletContext().getRealPath("template");
		String templatePath = path+ File.separator + "tubFollow.pdf";
		
		String tempPath = request.getSession().getServletContext().getRealPath("temp");
		String key = archiveNo;
		List<ResidentBaseInfo> list = residentBaseInfoDao.findResidentByArchiveNo(archiveNo);
		if(list != null && list.size() > 0){
			key = "肺结核随访_" + list.get(0).getName();
		}
		String fileName =  tempPath + File.separator + key + ".pdf";

		File uploadFile = new File(tempPath,key + ".pdf");
		if (!uploadFile.exists()) {
			uploadFile.createNewFile();
		}
		
		try {	

			Map<String, String> map = tuberculosisService.exportFollowPdf(archiveNo, year);

			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			PdfUtils.pdfout(o, templatePath,fileName);
						
			PutObjectResult putresult = AliOssUtil.putFile(key, Config.bucketName, uploadFile);
			if(putresult != null){
				if (uploadFile.exists()) {
					uploadFile.delete();
				}
			}
			
			String url = AliOssUtil.presignedURL(Config.bucketName, key);
			r.setCode(0);
			r.setMessage("Success");
			r.setData(url);
			JsonWebPrintUtils.printApiResult(request, response, r);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
	
	@RequestMapping(value = "/childrenInfoPdf", method = RequestMethod.GET)
	public void childrenInfoPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		Result r = new Result();
		String archiveNo = request.getParameter("archiveNo");
		//archiveNo = "45042110220205555";
		String path = request.getSession().getServletContext().getRealPath("template");
		String templatePath = path+ File.separator + "childrenInfo.pdf";
		
		String tempPath = request.getSession().getServletContext().getRealPath("temp");
		String key = archiveNo;
		List<ResidentBaseInfo> list = residentBaseInfoDao.findResidentByArchiveNo(archiveNo);
		if(list != null && list.size() > 0){
			key = "新生儿家庭访视记录_" + list.get(0).getName();
		}
		String fileName =  tempPath + File.separator + key + ".pdf";

		File uploadFile = new File(tempPath,key + ".pdf");
		if (!uploadFile.exists()) {
			uploadFile.createNewFile();
		}
		
		try {	

			Map<String, String> map = childrenService.exportInfoPdf(archiveNo);

			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			PdfUtils.pdfout(o, templatePath,fileName);
						
			PutObjectResult putresult = AliOssUtil.putFile(key, Config.bucketName, uploadFile);
			if(putresult != null){
				if (uploadFile.exists()) {
					uploadFile.delete();
				}
			}
			
			String url = AliOssUtil.presignedURL(Config.bucketName, key);
			r.setCode(0);
			r.setMessage("Success");
			r.setData(url);
			JsonWebPrintUtils.printApiResult(request, response, r);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
	
	@RequestMapping(value = "/childrenFollowPdf", method = RequestMethod.GET)
	public void childrenFollowPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		Result r = new Result();
		String archiveNo = request.getParameter("archiveNo");
		String type = request.getParameter("type");
		//archiveNo = "45042110220205555";
		String path = request.getSession().getServletContext().getRealPath("template");
		String f = "childrenFollow1.pdf";
		String n = "(1~8月)";
		if(StringUtil.isNotEmpty(type)){
			if("2".equals(type)){
				n = "(12~30月)";
			}else if("3".equals(type)){
				n = "(3~6岁)";
			}
		}
		if(StringUtil.isNotEmpty(type)){
			f = "childrenFollow" + type + ".pdf";
		}
		String templatePath = path+ File.separator + f;
		
		String tempPath = request.getSession().getServletContext().getRealPath("temp");
		String key = archiveNo;
		List<ResidentBaseInfo> list = residentBaseInfoDao.findResidentByArchiveNo(archiveNo);
		if(list != null && list.size() > 0){
			key = "儿童健康检查记录" + n + "_" + list.get(0).getName();
		}
		String fileName =  tempPath + File.separator + key + ".pdf";

		File uploadFile = new File(tempPath,key + ".pdf");
		if (!uploadFile.exists()) {
			uploadFile.createNewFile();
		}
		
		try {	

			Map<String, String> map = childrenService.exportFollowPdf(archiveNo, type);

			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			PdfUtils.pdfout(o, templatePath,fileName);
						
			PutObjectResult putresult = AliOssUtil.putFile(key, Config.bucketName, uploadFile);
			if(putresult != null){
				if (uploadFile.exists()) {
					uploadFile.delete();
				}
			}
			
			String url = AliOssUtil.presignedURL(Config.bucketName, key);
			r.setCode(0);
			r.setMessage("Success");
			r.setData(url);
			JsonWebPrintUtils.printApiResult(request, response, r);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
	
	@RequestMapping(value = "/gravidaInfoPdf", method = RequestMethod.GET)
	public void gravidaInfoPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		Result r = new Result();
		String archiveNo = request.getParameter("archiveNo");
		//archiveNo = "45042110220205555";
		String path = request.getSession().getServletContext().getRealPath("template");
		String templatePath = path+ File.separator + "gravidaInfo.pdf";
		
		String tempPath = request.getSession().getServletContext().getRealPath("temp");
		String key = archiveNo;
		List<ResidentBaseInfo> list = residentBaseInfoDao.findResidentByArchiveNo(archiveNo);
		if(list != null && list.size() > 0){
			key = "第一次随访产前检查记录_" + list.get(0).getName();
		}
		String fileName =  tempPath + File.separator + key + ".pdf";

		File uploadFile = new File(tempPath,key + ".pdf");
		if (!uploadFile.exists()) {
			uploadFile.createNewFile();
		}
		
		try {	

			Map<String, String> map = gravidaService.exportInfoPdf(archiveNo);

			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			PdfUtils.pdfout(o, templatePath,fileName);
						
			PutObjectResult putresult = AliOssUtil.putFile(key, Config.bucketName, uploadFile);
			if(putresult != null){
				if (uploadFile.exists()) {
					uploadFile.delete();
				}
			}
			
			String url = AliOssUtil.presignedURL(Config.bucketName, key);
			r.setCode(0);
			r.setMessage("Success");
			r.setData(url);
			JsonWebPrintUtils.printApiResult(request, response, r);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
	
	@RequestMapping(value = "/gravidaFollowPdf", method = RequestMethod.GET)
	public void gravidaFollowPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		Result r = new Result();
		String gravidaId = request.getParameter("gravidaId");
		//archiveNo = "45042110220205555";
		String path = request.getSession().getServletContext().getRealPath("template");
		String f = "gravidaFollow.pdf";
		String templatePath = path+ File.separator + f;
		
		String tempPath = request.getSession().getServletContext().getRealPath("temp");
		String key = gravidaId;
		GravidaInfo g = gravidaService.getGravidaInfoById(gravidaId);
		if(g != null){
			key = "产前随访服务记录_" + g.getName();
		}
		
		String fileName =  tempPath + File.separator + key + ".pdf";

		File uploadFile = new File(tempPath,key + ".pdf");
		if (!uploadFile.exists()) {
			uploadFile.createNewFile();
		}
		
		try {	

			Map<String, String> map = gravidaService.exportFollowPdf(gravidaId);

			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			PdfUtils.pdfout(o, templatePath,fileName);
						
			PutObjectResult putresult = AliOssUtil.putFile(key, Config.bucketName, uploadFile);
			if(putresult != null){
				if (uploadFile.exists()) {
					uploadFile.delete();
				}
			}
			
			String url = AliOssUtil.presignedURL(Config.bucketName, key);
			r.setCode(0);
			r.setMessage("Success");
			r.setData(url);
			JsonWebPrintUtils.printApiResult(request, response, r);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
	
	@RequestMapping(value = "/gravidaAfterPdf", method = RequestMethod.GET)
	public void gravidaAfterPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		Result r = new Result();
		String gravidaId = request.getParameter("gravidaId");
		String type = request.getParameter("type");
		//archiveNo = "45042110220205555";
		String path = request.getSession().getServletContext().getRealPath("template");
		String f = "gravidaAfter1.pdf";
		if(StringUtil.isNotEmpty(type)){
			f = "gravidaAfter" + type + ".pdf";
		}
		String templatePath = path+ File.separator + f;
		
		String tempPath = request.getSession().getServletContext().getRealPath("temp");
		String key = gravidaId;
		GravidaInfo g = gravidaService.getGravidaInfoById(gravidaId);
		if(g != null){
			if("1".equals(type)){
				key = "产后访视记录_" + g.getName();
			}else{
				key = "产后42天健康检查记录_" + g.getName();
			}
			
		}
		String fileName =  tempPath + File.separator + key + ".pdf";

		File uploadFile = new File(tempPath,key + ".pdf");
		if (!uploadFile.exists()) {
			uploadFile.createNewFile();
		}
		
		try {	

			Map<String, String> map = gravidaService.exportAfterPdf(gravidaId, type);

			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			PdfUtils.pdfout(o, templatePath,fileName);
						
			PutObjectResult putresult = AliOssUtil.putFile(key, Config.bucketName, uploadFile);
			if(putresult != null){
				if (uploadFile.exists()) {
					uploadFile.delete();
				}
			}
			
			String url = AliOssUtil.presignedURL(Config.bucketName, key);
			r.setCode(0);
			r.setMessage("Success");
			r.setData(url);
			JsonWebPrintUtils.printApiResult(request, response, r);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
}
