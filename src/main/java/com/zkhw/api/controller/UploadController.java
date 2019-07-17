package com.zkhw.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkhw.api.bo.ChildenFollowBo;
import com.zkhw.api.bo.DiabetesBo;
import com.zkhw.api.bo.ErrerResult;
import com.zkhw.api.bo.ErrorInfo;
import com.zkhw.api.bo.Gravida42AfterBo;
import com.zkhw.api.bo.GravidaAfterBo;
import com.zkhw.api.bo.GravidaFirstBo;
import com.zkhw.api.bo.GravidaFollowBo;
import com.zkhw.api.bo.HypertensionBo;
import com.zkhw.api.bo.NeonatusBaseInfoBo;
import com.zkhw.api.bo.NeonatusFirstBo;
import com.zkhw.api.bo.PsychosisBo;
import com.zkhw.api.bo.PsychosisInfoBo;
import com.zkhw.api.bo.ResidentUpBo;
import com.zkhw.api.bo.Result;
import com.zkhw.api.bo.TcmBo;
import com.zkhw.api.bo.TuberculosisBo;
import com.zkhw.api.bo.TuberculosisFollowBo;
import com.zkhw.api.service.UploadService;
import com.zkhw.common.utils.CodeUtil;
import com.zkhw.framework.utils.DateUtil;
import com.zkhw.framework.utils.JsonConverter;
import com.zkhw.framework.utils.JsonWebPrintUtils;
import com.zkhw.ltd.entity.Organization;
import com.zkhw.ltd.service.OrganizationService;
import com.zkhw.pub.dao.ElderlyTcmRecordDao;
import com.zkhw.pub.dao.ResidentBaseInfoDao;
import com.zkhw.pub.entity.ElderlyTcmRecord;
import com.zkhw.pub.entity.ResidentBaseInfo;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/Api")
public class UploadController {

	@Autowired
	private ResidentBaseInfoDao residentBaseInfoDao;
	
	@Autowired
	private OrganizationService organizationService;
		
	@Autowired
	private ElderlyTcmRecordDao elderlyTcmRecordDao;
	
	@Autowired
	private UploadService uploadService;
	
	@ResponseBody
	@RequestMapping(value = "/Upload/CreateOrEditAboutArchives")
	public void upload(HttpServletRequest request, HttpServletResponse response,String accessTokenKey,String Data) {
		Result r = new Result();
		ErrorInfo errInfo = new ErrorInfo();
		try{
			System.out.println("data=" + Data);
			JSONObject fromObject = JSONObject.fromObject(Data);
			if(fromObject.containsKey("TangNiaoBingVisit")){
				DiabetesBo bo = JsonConverter.json2Obj(Data, DiabetesBo.class);
				if(bo != null){
					if(bo.getTangNiaoBingVisit() != null && bo.getTangNiaoBingVisit().size() > 0){
						errInfo = uploadService.diabetesUpload(bo);
					}
				}
						
			}else if(fromObject.containsKey("JingShenBingVisit")){
				PsychosisBo bo = JsonConverter.json2Obj(Data, PsychosisBo.class);
				if(bo != null){
					if(bo.getJingShenBingVisit() != null && bo.getJingShenBingVisit().size() > 0){
						errInfo = uploadService.psychosisFollow(bo);
					}
				}
						
			}else if(fromObject.containsKey("HypertensionFollowUpLog")){
				if(!fromObject.containsKey("Archive")){
					HypertensionBo bo = JsonConverter.json2Obj(Data, HypertensionBo.class);
					if(bo != null){
						if(bo.getHypertensionFollowUpLog() != null && bo.getHypertensionFollowUpLog().size() > 0){
							errInfo = uploadService.hypertensionUpload(bo);
						}
					}	
				}else{
					ResidentUpBo bo = JsonConverter.json2Obj(Data, ResidentUpBo.class);
					if(bo != null){
						if(bo.getArchive() != null && bo.getArchive().size() > 0){
							errInfo = uploadService.residentUp(bo);
						}
					}
				}
				
			}else if(fromObject.containsKey("JingShenBingInfo")){
				PsychosisInfoBo bo = JsonConverter.json2Obj(Data, PsychosisInfoBo.class);
				if(bo != null){
					if(bo.getJingShenBingInfo() != null && bo.getJingShenBingInfo().size() > 0){
						errInfo = uploadService.psychosisFirst(bo);
					}
				}	
				
			}else if(fromObject.containsKey("FeiJieHeVisit1")){
				TuberculosisBo bo = JsonConverter.json2Obj(Data, TuberculosisBo.class);
				if(bo != null){
					if(bo.getFeiJieHeVisit1() != null && bo.getFeiJieHeVisit1().size() > 0){
						errInfo = uploadService.tuberculosisFirst(bo);
					}
				}
			}else if(fromObject.containsKey("FeiJieHeVisit")){
				TuberculosisFollowBo bo = JsonConverter.json2Obj(Data, TuberculosisFollowBo.class);
				if(bo != null){
					if(bo.getFeiJieHeVisit() != null && bo.getFeiJieHeVisit().size() > 0){
						errInfo = uploadService.tuberculosisFollow(bo);
					}
				}
			}else if(fromObject.containsKey("ChanQian2_5")){
				GravidaFollowBo bo = JsonConverter.json2Obj(Data, GravidaFollowBo.class);
				if(bo != null){
					if(bo.getChanQian2_5() != null && bo.getChanQian2_5().size() > 0){
						errInfo = uploadService.gravidaFollow(bo);
					}
				}
			}else if(fromObject.containsKey("ChanHouVisit")){
				GravidaAfterBo bo = JsonConverter.json2Obj(Data, GravidaAfterBo.class);
				if(bo != null){
					if(bo.getChanHouVisit() != null && bo.getChanHouVisit().size() > 0){
						errInfo = uploadService.gravidaAfter(bo);
					}
				}
			}else if(fromObject.containsKey("ChanHou42day")){
				Gravida42AfterBo bo = JsonConverter.json2Obj(Data, Gravida42AfterBo.class);
				if(bo != null){
					if(bo.getChanHou42day() != null && bo.getChanHou42day().size() > 0){
						errInfo = uploadService.gravida42After(bo);
					}
				}
			}else if(fromObject.containsKey("ChanQian1")){
				GravidaFirstBo bo = JsonConverter.json2Obj(Data, GravidaFirstBo.class);
				if(bo != null){
					if(bo.getChanQian1() != null && bo.getChanQian1().size() > 0){
						errInfo = uploadService.gravidaFirst(bo);
					}
				}
			}else if(fromObject.containsKey("Archive")){
				ResidentUpBo bo = JsonConverter.json2Obj(Data, ResidentUpBo.class);
				if(bo != null){
					if(bo.getArchive() != null && bo.getArchive().size() > 0){
						errInfo = uploadService.residentUp(bo);
					}
				}
			}else if(fromObject.containsKey("ChildrenBasicInfo")){
				NeonatusBaseInfoBo bo = JsonConverter.json2Obj(Data, NeonatusBaseInfoBo.class);
				if(bo != null){
					if(bo.getChildrenBasicInfo() != null && bo.getChildrenBasicInfo().size() > 0){
						errInfo = uploadService.neonatusBaseInfo(bo);
					}
				}
			}else if(fromObject.containsKey("ChildrenFamilyVisit")){
				NeonatusFirstBo bo = JsonConverter.json2Obj(Data, NeonatusFirstBo.class);
				if(bo != null){
					if(bo.getChildrenFamilyVisit() != null && bo.getChildrenFamilyVisit().size() > 0){
						errInfo = uploadService.neonatusFirst(bo);
					}
				}
			}else if(fromObject.containsKey("ChildrenHealthCheck")){
				ChildenFollowBo bo = JsonConverter.json2Obj(Data, ChildenFollowBo.class);
				if(bo != null){
					if(bo.getChildrenHealthCheck() != null && bo.getChildrenHealthCheck().size() > 0){
						errInfo = uploadService.childrenFollow(bo);
					}
				}
			}
			r.setCode(0);
			r.setMessage("Success");
		}catch(Exception e){
			e.printStackTrace();
			r.setCode(-1);
			r.setMessage("同步异常");
		}
		ErrerResult result = new ErrerResult();
		result.setErrorInfo(errInfo);
		r.setData(result);
		JsonWebPrintUtils.printApiResult(request, response, r);
	}
	@ResponseBody
	@RequestMapping(value = "/Data/save_zytz")
	public Result tcm(HttpServletRequest request, HttpServletResponse response,String accessTokenKey,String Data) {
		Result r = new Result();
		try{
			TcmBo bo = JsonConverter.json2Obj(Data, TcmBo.class);
			
			ElderlyTcmRecord record = new ElderlyTcmRecord();
			
			record.setId(CodeUtil.getUUID());
			
			record.setExamId(bo.getEXAMID());
			
			record.setTestDate(bo.getCREATED_DATE());
						
			record.setArchiveNo(bo.getARCHIVEID());
			List<ResidentBaseInfo> residents = residentBaseInfoDao.findResidentByArchiveNo(bo.getARCHIVEID());
			if(residents != null && residents.size() > 0){
				record.setName(residents.get(0).getName());	
				record.setIdNumber(residents.get(0).getIdNumber());
			}
			
			record.setAnswerResult(bo.getANSWERRESULTS());
			
			String result = bo.getIDENTIFYRESULTS();
			String[] tz = result.split("\\|");
			int pinghe = 1;
			for(int i = 0; i < tz.length; i++){
				String[] x = tz[i].split(":");
				int score = Integer.parseInt(x[1]);
				int res = 0;
				if(score >= 11){
					res = 1;
				}else if(score > 8){
					res = 2;
				}else{
					res = 3;
				}
				if(!"9".equals(x[0])){
					if(res == 1){
						pinghe = 3;
					}else if(res == 2){
						if(res != 3){
							res = 2;
						}
					}
				}else{
					if(pinghe == 1){
						if(score < 17){
							pinghe = 3;
						}
					}
				}
				switch (x[0]) {
				case "1":
					record.setQixuzhiScore(score);
					record.setQixuzhiResult(res);
					break;
				case "2":
					record.setYangxuzhiScore(score);
					record.setYangxuzhiResult(res);
					break;	
				case "3":
					record.setYinxuzhiScore(score);
					record.setYinxuzhiResult(res);
					break;
				case "4":
					record.setTanshizhiScore(score);
					record.setTanshizhiResult(res);
					break;		
				case "5":
					record.setShirezhiScore(score);
					record.setShirezhiResult(res);
					break;	
				case "6":
					record.setXueyuzhiScore(score);
					record.setXueyuzhiResult(res);
					break;	
				case "7":
					record.setQiyuzhiScore(score);
					record.setQiyuzhiResult(res);
					break;	
				case "8":
					record.setTebingzhiSorce(score);
					record.setTebingzhiResult(res);
					break;	
				case "9":
					record.setPinghezhiSorce(score);
					record.setPinghezhiResult(pinghe);
					break;						
				default:
					break;
				}
			}
			
			record.setTestDoctor(bo.getCREATED_BY());
			record.setCreateUser(bo.getCREATED_BY());
			record.setCreateTime(DateUtil.getDate(bo.getCREATED_DATE(), "yyyy-MM-dd HH:mm:ss"));
			record.setCreateOrg(bo.getDUNS());
			Organization org = organizationService.getOrganizationByCode(bo.getDUNS());
			if(org != null){
				record.setCreateOrgName(org.getOrganName());
			}
			
			record.setUpdateTime(DateUtil.getDate(bo.getUPDATED_DATE(), "yyyy-MM-dd HH:mm:ss"));
			record.setUpdateUser(bo.getUPDATED_BY());
			
			elderlyTcmRecordDao.insertSelective(record);
			r.setCode(0);
		}catch(Exception e){
			e.printStackTrace();
			r.setCode(-1);
		}
		return r;
	}
}