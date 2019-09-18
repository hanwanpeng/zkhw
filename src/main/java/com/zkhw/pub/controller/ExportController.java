package com.zkhw.pub.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.util.StringUtil;
import com.zkhw.common.utils.PdfUtils;
import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.flup.service.ChildrenService;
import com.zkhw.flup.service.DiabetesService;
import com.zkhw.flup.service.GravidaService;
import com.zkhw.flup.service.HypertensionService;
import com.zkhw.flup.service.PsychosisService;
import com.zkhw.flup.service.TuberculosisService;
import com.zkhw.pub.service.PhysicalExaminationService;
import com.zkhw.pub.service.ResidentBaseInfoService;

@Controller
@RequestMapping("/pub/export")
public class ExportController {
	
	@Autowired
	private ResidentBaseInfoService residentBaseInfoService;
	
	@Autowired
	private PhysicalExaminationService physicalExaminationService;
	
	@Autowired
	private HypertensionService hypertensionService;
	
	@Autowired
	private DiabetesService diabetesService;
	
	@Autowired
	private PsychosisService psychosisService;
	
	@Autowired
	private TuberculosisService tuberculosisService;
	
	@Autowired
	private ChildrenService childrenService;
	
	@Autowired
	private GravidaService gravidaService;
	
	@RequestMapping(value = "/baseinfoPdf", method = RequestMethod.GET)
	public void dataPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		String archiveNo = request.getParameter("archiveNo");
		//archiveNo = "45042110220205555";
		String path = request.getSession().getServletContext().getRealPath("template");
		String templatePath = path+ File.separator + "baseinfo.pdf";
		OutputStream out = null;
		String filename =  "居民健康档案.pdf";
		try {	
			out = response.getOutputStream();// 取得输出流
			filename = new String(filename.getBytes("gb2312"), "ISO8859-1");
			response.setContentType("application/pdf;charset=UTF-8");
			response.setHeader("Content-Disposition","attachment;filename=\"" + filename + "\"");						
			response.reset();// 清空输出流
			PdfUtils pdf = new PdfUtils();
			Map<String, String> map = residentBaseInfoService.exportPdf(archiveNo);


			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			pdf.createPdf(out, o, templatePath);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	@RequestMapping(value = "/examPdf", method = RequestMethod.GET)
	public void examPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		String id = request.getParameter("id");
		//id = "4d9d214f879d47d2a2467b41b1ad7b96";
		String path = request.getSession().getServletContext().getRealPath("template");
		String templatePath = path+ File.separator + "exam.pdf";
		OutputStream out = null;
		String filename =  "个人体检记录.pdf";
		try {	
			out = response.getOutputStream();// 取得输出流
			filename = new String(filename.getBytes("gb2312"), "ISO8859-1");
			response.setContentType("application/pdf;charset=UTF-8");
			response.setHeader("Content-Disposition","attachment;filename=\"" + filename + "\"");						
			response.reset();// 清空输出流
			PdfUtils pdf = new PdfUtils();
			Map<String, String> map = physicalExaminationService.exportPdf(id);


			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			pdf.createPdf(out, o, templatePath);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	@RequestMapping(value = "/hypFollowPdf", method = RequestMethod.GET)
	public void hypFollowPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		String archiveNo = request.getParameter("archiveNo");
		String year = request.getParameter("year");
		//archiveNo = "45042110220205555";
		String path = request.getSession().getServletContext().getRealPath("template");
		String templatePath = path+ File.separator + "hypFollow.pdf";
		OutputStream out = null;
		String filename =  "高血压随访.pdf";
		try {	
			out = response.getOutputStream();// 取得输出流
			filename = new String(filename.getBytes("gb2312"), "ISO8859-1");
			response.setContentType("application/pdf;charset=UTF-8");
			response.setHeader("Content-Disposition","attachment;filename=\"" + filename + "\"");						
			response.reset();// 清空输出流
			PdfUtils pdf = new PdfUtils();
			Map<String, String> map = hypertensionService.exportPdf(archiveNo, year);


			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			pdf.createPdf(out, o, templatePath);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	@RequestMapping(value = "/diaFollowPdf", method = RequestMethod.GET)
	public void diaFollowPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		String archiveNo = request.getParameter("archiveNo");
		String year = request.getParameter("year");
		//archiveNo = "45042110220205555";
		String path = request.getSession().getServletContext().getRealPath("template");
		String templatePath = path+ File.separator + "diaFollow.pdf";
		OutputStream out = null;
		String filename =  "糖尿病随访.pdf";
		try {	
			out = response.getOutputStream();// 取得输出流
			filename = new String(filename.getBytes("gb2312"), "ISO8859-1");
			response.setContentType("application/pdf;charset=UTF-8");
			response.setHeader("Content-Disposition","attachment;filename=\"" + filename + "\"");						
			response.reset();// 清空输出流
			PdfUtils pdf = new PdfUtils();
			Map<String, String> map = diabetesService.exportPdf(archiveNo, year);


			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			pdf.createPdf(out, o, templatePath);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}		

	@RequestMapping(value = "/psyInfoPdf", method = RequestMethod.GET)
	public void psyInfoPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		String archiveNo = request.getParameter("archiveNo");
		//archiveNo = "45042110220205555";
		String path = request.getSession().getServletContext().getRealPath("template");
		String templatePath = path+ File.separator + "psyInfo.pdf";
		OutputStream out = null;
		String filename =  "精神病信息.pdf";
		try {	
			out = response.getOutputStream();// 取得输出流
			filename = new String(filename.getBytes("gb2312"), "ISO8859-1");
			response.setContentType("application/pdf;charset=UTF-8");
			response.setHeader("Content-Disposition","attachment;filename=\"" + filename + "\"");						
			response.reset();// 清空输出流
			PdfUtils pdf = new PdfUtils();
			Map<String, String> map = psychosisService.exportInfoPdf(archiveNo);


			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			pdf.createPdf(out, o, templatePath);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}	
	
	@RequestMapping(value = "/psyFollowPdf", method = RequestMethod.GET)
	public void psyFollowPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		String id = request.getParameter("id");
		//archiveNo = "45042110220205555";
		String path = request.getSession().getServletContext().getRealPath("template");
		String templatePath = path+ File.separator + "psyFollow.pdf";
		OutputStream out = null;
		String filename =  "精神病随访.pdf";
		try {	
			out = response.getOutputStream();// 取得输出流
			filename = new String(filename.getBytes("gb2312"), "ISO8859-1");
			response.setContentType("application/pdf;charset=UTF-8");
			response.setHeader("Content-Disposition","attachment;filename=\"" + filename + "\"");						
			response.reset();// 清空输出流
			PdfUtils pdf = new PdfUtils();
			Map<String, String> map = psychosisService.exportFollowPdf(id);


			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			pdf.createPdf(out, o, templatePath);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	@RequestMapping(value = "/tubInfoPdf", method = RequestMethod.GET)
	public void tubInfoPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		String archiveNo = request.getParameter("archiveNo");
		//archiveNo = "45042110220205555";
		String path = request.getSession().getServletContext().getRealPath("template");
		String templatePath = path+ File.separator + "tubInfo.pdf";
		OutputStream out = null;
		String filename =  "肺结核信息.pdf";
		try {	
			out = response.getOutputStream();// 取得输出流
			filename = new String(filename.getBytes("gb2312"), "ISO8859-1");
			response.setContentType("application/pdf;charset=UTF-8");
			response.setHeader("Content-Disposition","attachment;filename=\"" + filename + "\"");						
			response.reset();// 清空输出流
			PdfUtils pdf = new PdfUtils();
			Map<String, String> map = tuberculosisService.exportInfoPdf(archiveNo);


			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			pdf.createPdf(out, o, templatePath);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	@RequestMapping(value = "/tubFollowPdf", method = RequestMethod.GET)
	public void tubFollowPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		String archiveNo = request.getParameter("archiveNo");
		String year = request.getParameter("year");
		//archiveNo = "45042110220205555";
		String path = request.getSession().getServletContext().getRealPath("template");
		String templatePath = path+ File.separator + "tubFollow.pdf";
		OutputStream out = null;
		String filename =  "肺结核随访.pdf";
		try {	
			out = response.getOutputStream();// 取得输出流
			filename = new String(filename.getBytes("gb2312"), "ISO8859-1");
			response.setContentType("application/pdf;charset=UTF-8");
			response.setHeader("Content-Disposition","attachment;filename=\"" + filename + "\"");						
			response.reset();// 清空输出流
			PdfUtils pdf = new PdfUtils();
			Map<String, String> map = tuberculosisService.exportFollowPdf(archiveNo, year);


			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			pdf.createPdf(out, o, templatePath);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	@RequestMapping(value = "/childrenInfoPdf", method = RequestMethod.GET)
	public void childrenInfoPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		String archiveNo = request.getParameter("archiveNo");
		//archiveNo = "45042110220205555";
		String path = request.getSession().getServletContext().getRealPath("template");
		String templatePath = path+ File.separator + "childrenInfo.pdf";
		OutputStream out = null;
		String filename =  "新生儿家庭访视记录.pdf";
		try {	
			out = response.getOutputStream();// 取得输出流
			filename = new String(filename.getBytes("gb2312"), "ISO8859-1");
			response.setContentType("application/pdf;charset=UTF-8");
			response.setHeader("Content-Disposition","attachment;filename=\"" + filename + "\"");						
			response.reset();// 清空输出流
			PdfUtils pdf = new PdfUtils();
			Map<String, String> map = childrenService.exportInfoPdf(archiveNo);


			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			pdf.createPdf(out, o, templatePath);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	@RequestMapping(value = "/childrenFollowPdf", method = RequestMethod.GET)
	public void childrenFollowPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		String archiveNo = request.getParameter("archiveNo");
		String type = request.getParameter("type");
		//archiveNo = "45042110220205555";
		String path = request.getSession().getServletContext().getRealPath("template");
		String f = "childrenFollow1.pdf";
		if(StringUtil.isNotEmpty(type)){
			f = "childrenFollow" + type + ".pdf";
		}
		String templatePath = path+ File.separator + f;
		OutputStream out = null;
		String filename =  "儿童健康检查记录.pdf";
		try {	
			out = response.getOutputStream();// 取得输出流
			filename = new String(filename.getBytes("gb2312"), "ISO8859-1");
			response.setContentType("application/pdf;charset=UTF-8");
			response.setHeader("Content-Disposition","attachment;filename=\"" + filename + "\"");						
			response.reset();// 清空输出流
			PdfUtils pdf = new PdfUtils();
			Map<String, String> map = childrenService.exportFollowPdf(archiveNo, type);


			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			pdf.createPdf(out, o, templatePath);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	@RequestMapping(value = "/gravidaInfoPdf", method = RequestMethod.GET)
	public void gravidaInfoPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		String archiveNo = request.getParameter("archiveNo");
		//archiveNo = "45042110220205555";
		String path = request.getSession().getServletContext().getRealPath("template");
		String templatePath = path+ File.separator + "gravidaInfo.pdf";
		OutputStream out = null;
		String filename =  "第一次随访产前检查记录.pdf";
		try {	
			out = response.getOutputStream();// 取得输出流
			filename = new String(filename.getBytes("gb2312"), "ISO8859-1");
			response.setContentType("application/pdf;charset=UTF-8");
			response.setHeader("Content-Disposition","attachment;filename=\"" + filename + "\"");						
			response.reset();// 清空输出流
			PdfUtils pdf = new PdfUtils();
			Map<String, String> map = gravidaService.exportInfoPdf(archiveNo);


			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			pdf.createPdf(out, o, templatePath);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}

	@RequestMapping(value = "/gravidaFollowPdf", method = RequestMethod.GET)
	public void gravidaFollowPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		String gravidaId = request.getParameter("gravidaId");
		//archiveNo = "45042110220205555";
		String path = request.getSession().getServletContext().getRealPath("template");
		String f = "gravidaFollow.pdf";

		String templatePath = path+ File.separator + f;
		OutputStream out = null;
		String filename =  "产前随访服务记录.pdf";
		try {	
			out = response.getOutputStream();// 取得输出流
			filename = new String(filename.getBytes("gb2312"), "ISO8859-1");
			response.setContentType("application/pdf;charset=UTF-8");
			response.setHeader("Content-Disposition","attachment;filename=\"" + filename + "\"");						
			response.reset();// 清空输出流
			PdfUtils pdf = new PdfUtils();
			Map<String, String> map = gravidaService.exportFollowPdf(gravidaId);


			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			pdf.createPdf(out, o, templatePath);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	@RequestMapping(value = "/gravidaAfterPdf", method = RequestMethod.GET)
	public void gravidaAfterPdf(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result) throws Exception {
		String gravidaId = request.getParameter("gravidaId");
		String type = request.getParameter("type");
		//archiveNo = "45042110220205555";
		String path = request.getSession().getServletContext().getRealPath("template");
		String f = "gravidaAfter1.pdf";
		if(StringUtil.isNotEmpty(type)){
			f = "gravidaAfter" + type + ".pdf";
		}
		String templatePath = path+ File.separator + f;
		OutputStream out = null;
		String filename =  "产后访视记录.pdf";
		try {	
			out = response.getOutputStream();// 取得输出流
			filename = new String(filename.getBytes("gb2312"), "ISO8859-1");
			response.setContentType("application/pdf;charset=UTF-8");
			response.setHeader("Content-Disposition","attachment;filename=\"" + filename + "\"");						
			response.reset();// 清空输出流
			PdfUtils pdf = new PdfUtils();
			Map<String, String> map = gravidaService.exportAfterPdf(gravidaId, type);


			Map<String, String> map2 = new HashMap<String,String>();
			//map2.put("img", "c:/50336.jpg");

			Map<String, Object> o = new HashMap<String,Object>();
			o.put("datemap", map);
			o.put("imgmap", map2);
			pdf.createPdf(out, o, templatePath);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}	
	
}
