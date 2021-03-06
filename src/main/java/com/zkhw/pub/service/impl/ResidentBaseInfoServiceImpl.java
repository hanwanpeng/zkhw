package com.zkhw.pub.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.zkhw.common.utils.ApiConstants;
import com.zkhw.common.utils.CodeUtil;
import com.zkhw.common.utils.ExcelUtil;
import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.framework.utils.JsonWebPrintUtils;
import com.zkhw.pub.dao.ElderlySelfcareEstimateDao;
import com.zkhw.pub.dao.ElderlyTcmRecordDao;
import com.zkhw.pub.dao.FamilyRecordDao;
import com.zkhw.pub.dao.MentachysisRecordDao;
import com.zkhw.pub.dao.OperationRecordDao;
import com.zkhw.pub.dao.PhysicalExaminationDao;
import com.zkhw.pub.dao.ResidentBaseInfoDao;
import com.zkhw.pub.dao.ResidentDiseasesDao;
import com.zkhw.pub.dao.TjBcDao;
import com.zkhw.pub.dao.TjNcgDao;
import com.zkhw.pub.dao.TjSgtzDao;
import com.zkhw.pub.dao.TjShDao;
import com.zkhw.pub.dao.TjXcgDao;
import com.zkhw.pub.dao.TjXdtDao;
import com.zkhw.pub.dao.TjXyDao;
import com.zkhw.pub.dao.TraumatismRecordDao;
import com.zkhw.pub.entity.ElderlySelfcareEstimate;
import com.zkhw.pub.entity.ElderlyTcmRecord;
import com.zkhw.pub.entity.FamilyRecord;
import com.zkhw.pub.entity.MetachysisRecord;
import com.zkhw.pub.entity.OperationRecord;
import com.zkhw.pub.entity.PhysicalExamination;
import com.zkhw.pub.entity.ResidentBaseInfo;
import com.zkhw.pub.entity.ResidentDiseases;
import com.zkhw.pub.entity.TjBc;
import com.zkhw.pub.entity.TjNcg;
import com.zkhw.pub.entity.TjSgtz;
import com.zkhw.pub.entity.TjSh;
import com.zkhw.pub.entity.TjXcg;
import com.zkhw.pub.entity.TjXdt;
import com.zkhw.pub.entity.TjXy;
import com.zkhw.pub.entity.TraumatismRecord;
import com.zkhw.pub.mo.ResidentMo;
import com.zkhw.pub.query.ResidentBaseInfoQuery;
import com.zkhw.pub.service.ResidentBaseInfoService;
import com.zkhw.pub.vo.ResidentVo;


@Service
public class ResidentBaseInfoServiceImpl implements ResidentBaseInfoService {

	@Autowired
	private ResidentBaseInfoDao residentBaseInfoDao;
	
	@Autowired
	private FamilyRecordDao familyRecordDao;
	
	@Autowired
	private OperationRecordDao operationRecordDao;
	
	@Autowired
	private TraumatismRecordDao traumatismRecordDao;
	
	@Autowired
	private MentachysisRecordDao mentachysisRecordDao;
	
	@Autowired
	private ResidentDiseasesDao residentDiseasesDao;
	
	@Autowired
	private TjBcDao tjBcDao;
	
	@Autowired
	private TjXdtDao tjXdtDao;
	
	@Autowired
	private TjShDao tjShDao;
	
	@Autowired
	private TjXcgDao tjXcgDao;
	
	@Autowired
	private TjNcgDao tjNcgDao;
	
	@Autowired
	private TjXyDao tjXyDao;
	
	@Autowired
	private TjSgtzDao tjSgtzDao;
	
	@Autowired
	private PhysicalExaminationDao physicalExaminationDao;
	
	@Autowired
	private ElderlySelfcareEstimateDao elderlySelfcareEstimateDao;
	
	@Autowired
	private ElderlyTcmRecordDao elderlyTcmRecordDao;
	
	
	
	
	/**
	 * 健康体检花名册
	 */
	@Override
	public void physicalForExcel(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result,
			ResidentBaseInfoQuery resident) {
		//体检人群
		List<ResidentBaseInfo> residentBaseInfoList = residentBaseInfoDao.findResidentList(resident);
		if (residentBaseInfoList.size() > 0) {
			// 表头
			ArrayList<String> headerList = new ArrayList<String>();
			String[] header = { "村名", "姓名", "身份证号", "性别", "年龄", "电话号码", "是否贫困户", "B超", "心电图", "生化", "血常规", "尿常规", "血压", "身高体重", "健康体检表", "老年人生活自理能力评估", "老年人中医体质辨识"};
			for (int i = 0; i < header.length; i++) {
				headerList.add(header[i]);
			}
			// 行内容
			ArrayList<List<String>> rowList = new ArrayList<List<String>>();
			String title = "健康体检花名册";
			String sheetName = "健康体检花名册";
			String archiveNo = null;
			for (ResidentBaseInfo residentBaseInfo : residentBaseInfoList) {
				archiveNo = residentBaseInfo.getArchiveNo();
				ArrayList<String> row = new ArrayList<String>();
				row.add(residentBaseInfo.getVillageName());//村名
				row.add(residentBaseInfo.getName());//姓名
				row.add(residentBaseInfo.getIdNumber());//身份证号
				String sex = residentBaseInfo.getSex();//性别
				if (!StringUtil.isEmpty(sex) && sex.equals("1")) {
					row.add("男");
				} else {
					row.add("女");
				}
				Integer age = residentBaseInfo.getAge();//年龄
				if(age != null) {
					row.add(age.toString());
				}
				row.add(residentBaseInfo.getPhone());//电话
				Integer isPoor = residentBaseInfo.getIsPoor();//是否贫困（1是贫困）
				if(isPoor != null) {
					row.add(residentBaseInfo.getIsPoor().toString());
				}
				List<TjBc> TjBcList = tjBcDao.findListByAichiveNo(archiveNo);
				if(TjBcList.size() > 0) {
					row.add("1");//B超(1完成)
				}else {
					row.add("0");
				}
				List<TjXdt> tjXdtList = tjXdtDao.findListByAichiveNo(archiveNo);//心电图
				if(tjXdtList.size() > 0) {
					row.add("1");//心电图(1完成)
				}else {
					row.add("0");
				}
				
				List<TjSh> tjShList = tjShDao.findListByAichiveNo(archiveNo);
				if(tjShList.size() > 0) {
					row.add("1");//生化(1完成)
				}else {
					row.add("0");
				}
				List<TjXcg> tjXcgList = tjXcgDao.findListByAichiveNo(archiveNo);
				if(tjXcgList.size() > 0) {
					row.add("1");//血常规(1完成)
				}else {
					row.add("0");
				}
			    List<TjNcg> tjNcgList = tjNcgDao.findListByAichiveNo(archiveNo);
				if(tjNcgList.size() > 0) {
					row.add("1");//尿常规(1完成)
				}else {
					row.add("0");
				}
				List<TjXy> tjXyList = tjXyDao.findListByAichiveNo(archiveNo);
				if(tjXyList.size() > 0) {
					row.add("1");//血压(1完成)
				}else {
					row.add("0");
				}
				List<TjSgtz> tjSgtzList = tjSgtzDao.findListByAichiveNo(archiveNo);
				if(tjSgtzList.size() > 0) {
					row.add("1");//身高体重(1完成)
				}else {
					row.add("0");
				}
				PhysicalExamination physicalExamination = physicalExaminationDao.getLastByArchiveNo(archiveNo);
				if(physicalExamination != null) {
					Integer uploadStatus = physicalExamination.getUploadStatus();
					if(uploadStatus != null && uploadStatus == 1) {
						row.add("1");//健康体检
					}else {
						row.add("0");//健康体检
					}
				}
				List<ElderlySelfcareEstimate> elderlySelfcareEstimateList = elderlySelfcareEstimateDao.findSelfcareListByExamid(archiveNo);
				if(elderlySelfcareEstimateList.size() > 0) {
					row.add("1");//老年人生活自理能力评估
				}else {
					row.add("0");
				}
				List<ElderlyTcmRecord> elderlyTcmRecordList = elderlyTcmRecordDao.findTcmListByExamId(archiveNo);
				if(elderlyTcmRecordList.size() > 0) {
					row.add("1");//老年人中医体质辨识
				}else {
					row.add("0");
				}
				
				rowList.add(row);
			}
			// 输出excel到浏览器
			response.setContentType("application/msexcel");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE");
			response.setHeader("Access-Control-Allow-Headers",
					"Access-Control-Allow-Origin, Access-Control-Allow-Methods, Access-Control-Max-Age, X-Auth-Token, Content-Type, Accept");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			OutputStream out = null;

			try {
				out = response.getOutputStream();// 取得输出流
				response.reset();// 清空输出流
				String filename = title + ".xls";
				filename = new String(filename.getBytes("gb2312"), "ISO8859-1");
				response.setHeader("Content-disposition", "attachment; filename=" + filename);// 设定输出文件头
				ExcelUtil excelUtil = new ExcelUtil();
				excelUtil.writeExcelWithMultiSheet(headerList, rowList, out, sheetName);
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

		} else {
			result.setCode("1");
			result.setMsg("没有查询到数据");
			JsonWebPrintUtils.printOutNullApiResult(request, response, result);
		}
		
		
	}
	
	
	/**
	 * 26-64岁花名册
	 */
	@Override
	public void minElderlyForExcel(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result,
			ResidentBaseInfoQuery resident) {
		resident.setMaxage(65);
		resident.setMinage(26);
		List<ResidentBaseInfo> residentBaseInfoList = residentBaseInfoDao.findResidentList(resident);
		if (residentBaseInfoList.size() > 0) {
			// 表头
			ArrayList<String> headerList = new ArrayList<String>();
			String[] header = { "姓名", "性别", "年龄", "身份证号码", "住址", "电话", "所患疾病" };
			for (int i = 0; i < header.length; i++) {
				headerList.add(header[i]);
			}
			// 行内容
			ArrayList<List<String>> rowList = new ArrayList<List<String>>();
			String title = "26-64岁花名册查询列表";
			String sheetName = "26-64岁花名册花名册";
			for (ResidentBaseInfo residentBaseInfo : residentBaseInfoList) {
				ArrayList<String> row = new ArrayList<String>();
				row.add(residentBaseInfo.getName());
				String sex = residentBaseInfo.getSex();
				if (!StringUtil.isEmpty(sex) && sex.equals("1")) {
					row.add("男");
				} else {
					row.add("女");
				}
				Integer age = residentBaseInfo.getAge();
				if(age != null) {
					row.add(age.toString());
				}
				row.add(residentBaseInfo.getIdNumber());
				row.add(residentBaseInfo.getResidenceAddress());
				row.add(residentBaseInfo.getPhone());
				Integer isHypertension = residentBaseInfo.getIsHypertension();
				Integer isDiabetes = residentBaseInfo.getIsDiabetes();
				Integer isTuberculosis = residentBaseInfo.getIsTuberculosis();
				Integer isPsychosis = residentBaseInfo.getIsPsychosis();
				String illness = "";
				if (isHypertension != null && isHypertension == 1) {
					illness += "高血压";
				}
				if (isDiabetes != null && isDiabetes == 1) {
					illness += "、糖尿病";
				}
				if (isTuberculosis != null && isTuberculosis == 1) {
					illness += "、肺结核";
				}
				if (isPsychosis != null && isPsychosis == 1) {
					illness += "、精神病";
				}
				row.add(illness);
				rowList.add(row);
			}
			// 输出excel到浏览器
			response.setContentType("application/msexcel");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE");
			response.setHeader("Access-Control-Allow-Headers",
					"Access-Control-Allow-Origin, Access-Control-Allow-Methods, Access-Control-Max-Age, X-Auth-Token, Content-Type, Accept");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			OutputStream out = null;

			try {
				out = response.getOutputStream();// 取得输出流
				response.reset();// 清空输出流
				String filename = title + ".xls";
				filename = new String(filename.getBytes("gb2312"), "ISO8859-1");
				response.setHeader("Content-disposition", "attachment; filename=" + filename);// 设定输出文件头
				ExcelUtil excelUtil = new ExcelUtil();
				excelUtil.writeExcelWithMultiSheet(headerList, rowList, out, sheetName);
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

		} else {
			result.setCode("1");
			result.setMsg("没有查询到数据");
			JsonWebPrintUtils.printOutNullApiResult(request, response, result);
		}

	}
	
	/**
	 * 65岁老年人花名册
	 */
	@Override
	public void elderlyForExcel(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result,
			ResidentBaseInfoQuery resident) {
		resident.setMinage(65);
		List<ResidentBaseInfo> residentBaseInfoList = residentBaseInfoDao.findResidentList(resident);
		if (residentBaseInfoList.size() > 0) {
			// 表头
			ArrayList<String> headerList = new ArrayList<String>();
			String[] header = { "姓名", "性别", "年龄", "身份证号码", "住址", "电话", "所患疾病" };
			for (int i = 0; i < header.length; i++) {
				headerList.add(header[i]);
			}
			// 行内容
			ArrayList<List<String>> rowList = new ArrayList<List<String>>();
			String title = "65岁老年人查询列表";
			String sheetName = "65岁老年人花名册";
			for (ResidentBaseInfo residentBaseInfo : residentBaseInfoList) {
				ArrayList<String> row = new ArrayList<String>();
				row.add(residentBaseInfo.getName());
				String sex = residentBaseInfo.getSex();
				if (!StringUtil.isEmpty(sex) && sex.equals("1")) {
					row.add("男");
				} else {
					row.add("女");
				}
				Integer age = residentBaseInfo.getAge();
				if(age != null) {
					row.add(age.toString());
				}
				row.add(residentBaseInfo.getIdNumber());
				row.add(residentBaseInfo.getResidenceAddress());
				row.add(residentBaseInfo.getPhone());
				Integer isHypertension = residentBaseInfo.getIsHypertension();
				Integer isDiabetes = residentBaseInfo.getIsDiabetes();
				Integer isTuberculosis = residentBaseInfo.getIsTuberculosis();
				Integer isPsychosis = residentBaseInfo.getIsPsychosis();
				String illness = "";
				if (isHypertension != null && isHypertension == 1) {
					illness += "高血压";
				}
				if (isDiabetes != null && isDiabetes == 1) {
					illness += "、糖尿病";
				}
				if (isTuberculosis != null && isTuberculosis == 1) {
					illness += "、肺结核";
				}
				if (isPsychosis != null && isPsychosis == 1) {
					illness += "、精神病";
				}
				row.add(illness);
				rowList.add(row);

			}
			// 输出excel到浏览器
			response.setContentType("application/msexcel");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE");
			response.setHeader("Access-Control-Allow-Headers",
					"Access-Control-Allow-Origin, Access-Control-Allow-Methods, Access-Control-Max-Age, X-Auth-Token, Content-Type, Accept");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			OutputStream out = null;

			try {
				out = response.getOutputStream();// 取得输出流
				response.reset();// 清空输出流
				String filename = title + ".xls";
				filename = new String(filename.getBytes("gb2312"), "ISO8859-1");
				response.setHeader("Content-disposition", "attachment; filename=" + filename);// 设定输出文件头
				ExcelUtil excelUtil = new ExcelUtil();
				excelUtil.writeExcelWithMultiSheet(headerList, rowList, out, sheetName);
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

		} else {
			result.setCode("1");
			result.setMsg("没有查询到数据");
			JsonWebPrintUtils.printOutNullApiResult(request, response, result);
		}

	}
	
	
	/**
	 * 人口花名册
	 */
	@Override
	public void residentBaseInfoForExcel(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result,
			ResidentBaseInfoQuery resident) {
		List<ResidentBaseInfo> residentBaseInfoList = residentBaseInfoDao.findResidentList(resident);
		if (residentBaseInfoList.size() > 0) {
			// 表头
			ArrayList<String> headerList = new ArrayList<String>();
			String[] header = { "姓名", "性别", "民族", "年龄", "身份证号码", "住址", "电话", "所患疾病", "贫困户" };
			for (int i = 0; i < header.length; i++) {
				headerList.add(header[i]);
			}
			// 行内容
			ArrayList<List<String>> rowList = new ArrayList<List<String>>();
			String title = "人口查询列表";
			String sheetName = "人口花名册";
			for (ResidentBaseInfo residentBaseInfo : residentBaseInfoList) {
				ArrayList<String> row = new ArrayList<String>();
				row.add(residentBaseInfo.getName());
				String sex = residentBaseInfo.getSex();
				if (!StringUtil.isEmpty(sex) && sex.equals("1")) {
					row.add("男");
				} else {
					row.add("女");
				}
				String nation = residentBaseInfo.getNation();
				if (!StringUtil.isEmpty(nation) && nation.equals("1")) {
					row.add("汉");
				} else {
					row.add("");
				}
				Integer age = residentBaseInfo.getAge();
				if(age != null) {
					row.add(age.toString());
				}
				row.add(residentBaseInfo.getIdNumber());
				row.add(residentBaseInfo.getResidenceAddress());
				row.add(residentBaseInfo.getPhone());
				Integer isHypertension = residentBaseInfo.getIsHypertension();
				Integer isDiabetes = residentBaseInfo.getIsDiabetes();
				Integer isTuberculosis = residentBaseInfo.getIsTuberculosis();
				Integer isPsychosis = residentBaseInfo.getIsPsychosis();
				String illness = "";
				if (isHypertension != null && isHypertension == 1) {
					illness += "高血压";
				}
				if (isDiabetes != null && isDiabetes == 1) {
					illness += "、糖尿病";
				}
				if (isTuberculosis != null && isTuberculosis == 1) {
					illness += "、肺结核";
				}
				if (isPsychosis != null && isPsychosis == 1) {
					illness += "、精神病";
				}
				row.add(illness);
				Integer isPoor = residentBaseInfo.getIsPoor();
				if (isPoor != null && isPoor == 1) {
					row.add("是");
				} else {
					row.add("否");
				}

				rowList.add(row);
			}

			// 输出excel到浏览器
			response.setContentType("application/msexcel");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE");
			response.setHeader("Access-Control-Allow-Headers",
					"Access-Control-Allow-Origin, Access-Control-Allow-Methods, Access-Control-Max-Age, X-Auth-Token, Content-Type, Accept");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			OutputStream out = null;

			try {
				out = response.getOutputStream();// 取得输出流
				response.reset();// 清空输出流
				String filename = title + ".xls";
				filename = new String(filename.getBytes("gb2312"), "ISO8859-1");
				response.setHeader("Content-disposition", "attachment; filename=" + filename);// 设定输出文件头
				ExcelUtil excelUtil = new ExcelUtil();
				excelUtil.writeExcelWithMultiSheet(headerList, rowList, out, sheetName);
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

		} else {
			result.setCode("1");
			result.setMsg("没有查询到数据");
			JsonWebPrintUtils.printOutNullApiResult(request, response, result);

		}

	}

	@Override
	public int saveResidentBaseInfo(ResidentBaseInfo info) {
		return residentBaseInfoDao.insertSelective(info);
	}

	
	/**
	 * 展示居民健康档案
	 */
	@Override
	public ResidentMo showResident(ResidentBaseInfoQuery query) {
		String archiveNo = query.getArchiveNo();
		
		ResidentMo residentMo = new ResidentMo();
		
		
		//居民基本信息
		List<ResidentBaseInfo> residentList = residentBaseInfoDao.findResidentList(query);
		ResidentBaseInfo residentBaseInfo = residentList.get(0);
		BeanUtils.copyProperties(residentBaseInfo,residentMo);
		
		//手术
		OperationRecord operationRecord = new OperationRecord();
		operationRecord.setArchiveNo(archiveNo);
		List<OperationRecord> operationRecordList = operationRecordDao.selectByArchiveNo(operationRecord);
		residentMo.setOperationRecord(operationRecordList);
		
		//外伤
		TraumatismRecord traumatismRecord = new TraumatismRecord();
		traumatismRecord.setArchiveNo(archiveNo);
		List<TraumatismRecord> traumatismRecordList = traumatismRecordDao.selectByArchiveNo(traumatismRecord);
		residentMo.setTraumatismRecord(traumatismRecordList);
		
		//输血
		MetachysisRecord metachysisRecord = new MetachysisRecord();
		metachysisRecord.setArchiveNo(archiveNo);
		List<MetachysisRecord> metachysisRecordList = mentachysisRecordDao.selectByArchiveNo(metachysisRecord);
		residentMo.setMetachysisRecord(metachysisRecordList);
		
		//疾病
		ResidentDiseases residentDiseases = new ResidentDiseases();
		residentDiseases.setArchiveNo(archiveNo);
		List<ResidentDiseases> residentDiseasesList = residentDiseasesDao.selectByArchiveNo(residentDiseases);
		residentMo.setResidentDiseases(residentDiseasesList);
		if(residentDiseasesList != null && residentDiseasesList.size() > 0){
			for(int i = 0; i < residentDiseasesList.size(); i++){
				ResidentDiseases d = residentDiseasesList.get(i);
				if("6".equals(d.getDiseaseType())){
					residentMo.setCancer(d.getDiseaseName());
				}else if("12".equals(d.getDiseaseType())){
					residentMo.setOccupationDisease(d.getDiseaseName());
				}
			}
		}
		
		//家族史
		FamilyRecord familyRecord = new FamilyRecord();
		familyRecord.setArchiveNo(archiveNo);
		List<FamilyRecord> familyRecordList = familyRecordDao.selectByArchiveNo(familyRecord);
		residentMo.setFamilyRecord(familyRecordList);
		
		return residentMo;
	}
	
	
	/**
	 * 展示居民健康档案
	 */
	@Override
	public PageInfos<ResidentBaseInfo> findResidentByPage(ResidentBaseInfoQuery record,
			PageInfos<ResidentBaseInfo> pageData) {
		PageHelper.startPage( (int)pageData.getPage(), (int)pageData.getPageSize());//pageNum, pageSize
		List<ResidentBaseInfo> list = residentBaseInfoDao.findResidentList(record);
		PageInfo<ResidentBaseInfo> page = new PageInfo<ResidentBaseInfo>(list);
		pageData.setPage(page.getPageNum());      //当前页码
		pageData.setPageCount(page.getPages());   //总页数
		pageData.setPageSize(page.getPageSize()); //每页记录数
		pageData.setTotal(page.getTotal());       //总记录数
		pageData.setRows(page.getList());
		return pageData;
	}

	/**
	 * 添加居民健康档案
	 */
	@Override
	public void saveResident(ResidentVo vo) {
		ResidentBaseInfo residentBaseInfo = new ResidentBaseInfo();
		BeanUtils.copyProperties(vo,residentBaseInfo);
		String archiveNo = "";
		String idNumber = vo.getIdNumber();
		String villageCode = vo.getVillageCode();
		if(StringUtil.isNotEmpty(idNumber)){
			if(idNumber.length() > 4){
				//档位编号省市区编码（6位）+ 乡镇（3位）+ 村（3位） + 0 + 身份证后四位
				String substring = idNumber.substring(idNumber.length()-4, idNumber.length());			
				archiveNo = villageCode + "0" + substring;				
			}
		}
		
		if("".equals(archiveNo)){
			if(StringUtil.isNotEmpty(vo.getPhone())){
				String phone = vo.getPhone();
				archiveNo = villageCode + "p" + phone.substring(phone.length() - 4, phone.length());
			}else{
				int ran = (int)((Math.random()*9+1)*1000);
				archiveNo = villageCode + "l" + ran;
			}
		}
		residentBaseInfo.setArchiveNo(archiveNo);
		residentBaseInfo.setStatus("1");
		residentBaseInfo.setCreateTime(new Date());
									
		//家族史
		String familyRecord = vo.getFamilyRecord();
		if(!StringUtil.isEmpty(familyRecord)) {
			FamilyRecord family = null;
			String[] familyRecordStr = familyRecord.split(",");
			for (int i = 0; i < familyRecordStr.length; i++) {
				family = new FamilyRecord();
				
				String relation = familyRecordStr[i].split(":")[0];//关系
				String diseaseCode = familyRecordStr[i].split(":")[1];//疾病编码
				String diseaseName = familyRecordStr[i].split(":")[2];//疾病名称
				
				String uuid = CodeUtil.getUUID();
				family.setId(uuid);
				family.setArchiveNo(archiveNo);
				family.setIdNumber(idNumber);
				family.setRelation(relation);
				family.setDiseaseCode(diseaseCode);
				family.setDiseaseName(diseaseName);
				//family.setCreateName(createName);
				family.setCreateTime(new Date());
				
				familyRecordDao.insertSelective(family);
				
				
			}
		}
		
		
		
		
		//既往史中的疾病
		String historyIllness = vo.getHistoryIllness();
		if(!StringUtil.isEmpty(historyIllness)) {
			ResidentDiseases residentDiseases = null;
			String[] historyIllnessStr = historyIllness.split(",");
			for (int i = 0; i < historyIllnessStr.length; i++) {
				residentDiseases = new ResidentDiseases();
				String diseaseType = historyIllnessStr[i].split(":")[0];//疾病编码
				if(diseaseType.equals("1")) {
					residentBaseInfo.setIsHypertension(0);
					residentBaseInfo.setIsDiabetes(0);
					residentBaseInfo.setIsPsychosis(0);
					residentBaseInfo.setIsTuberculosis(0);
				}else {
					String diseaseDate = historyIllnessStr[i].split(":")[1];//疾病日期
					//String diseaseName = historyIllnessStr[i].split(":")[1];//疾病名字
					
					
					String uuid = CodeUtil.getUUID();
					residentDiseases.setId(uuid);//id
					residentDiseases.setArchiveNo(archiveNo);//档案编号
					residentDiseases.setIdNumber(idNumber);//身份证号
					//residentDiseases.setCreateName(createName);//创建人
					residentDiseases.setCreateTime(new Date());//创建时间
					residentDiseases.setDiseaseType(diseaseType);//疾病编码
					if("6".equals(diseaseType)){
						residentDiseases.setDiseaseName(vo.getCancer());//恶性肿瘤
					}else if("12".equals(diseaseType)){
						residentDiseases.setDiseaseName(vo.getOccupationDisease());//职业病
					}
				
					residentDiseases.setDiseaseDate(diseaseDate);//疾病日期
					
					if("2".equals(diseaseType) ) {
						residentBaseInfo.setIsHypertension(1);
					}
					if("3".equals(diseaseType)) {
						residentBaseInfo.setIsDiabetes(1);
					}
					if("8".equals(diseaseType)) {
						residentBaseInfo.setIsPsychosis(1);
					}
					if("9".equals(diseaseType)) {
						residentBaseInfo.setIsTuberculosis(1);
					}
					
					residentDiseasesDao.insertSelective(residentDiseases);
				}
				
				
			}
		}
		
		
		
		//手术
		String operation = vo.getOperation();
		if(!StringUtil.isEmpty(operation)) {
			OperationRecord operationRecord = null;
			String[] operationStr = operation.split(",");
			for (int i = 0; i < operationStr.length; i++) {
				operationRecord = new OperationRecord();
				String operationName = operationStr[i].split(":")[0];//手术名称
				String operationTime = operationStr[i].split(":")[1];//手术时间
				
				String uuid = CodeUtil.getUUID();
				operationRecord.setId(uuid);
				operationRecord.setIdNumber(idNumber);
				operationRecord.setArchiveNo(archiveNo);
				operationRecord.setOperationName(operationName);//手术名称
				operationRecord.setOperationTime(operationTime);//手术时间
				//operationRecord.setCreateName(createName);//创建人
				operationRecord.setCreateTime(new Date());//创建时间
				
				operationRecordDao.insertSelective(operationRecord);
				
			}
			
		}
		
		
		
		//外伤
		String trauma = vo.getTrauma();
		if(!StringUtil.isEmpty(trauma)) {
			TraumatismRecord traumatismRecord = null;
			String[] traumaStr = trauma.split(",");
			for (int i = 0; i < traumaStr.length; i++) {
				traumatismRecord = new TraumatismRecord();
				
				String uuid = CodeUtil.getUUID();
				traumatismRecord.setId(uuid);
				traumatismRecord.setIdNumber(idNumber);
				traumatismRecord.setArchiveNo(archiveNo);
				String traumatismName = traumaStr[i].split(":")[0];//外伤名称
				String traumatismTime = traumaStr[i].split(":")[1];//外伤时间
				traumatismRecord.setTraumatismName(traumatismName);
				traumatismRecord.setTraumatismTime(traumatismTime);
				//traumatismRecord.setCreateName(createName);
				traumatismRecord.setCreateTime(new Date());
				traumatismRecordDao.insertSelective(traumatismRecord);
				
			}
		}
		
		
		//输血
		String transfusion = vo.getTransfusion();
		if(!StringUtil.isEmpty(transfusion)) {
			MetachysisRecord metachysisRecord = null;
			String[] transfusionStr = transfusion.split(",");
			for (int i = 0; i < transfusionStr.length; i++) {
				metachysisRecord = new MetachysisRecord();
				
				String uuid = CodeUtil.getUUID();
				metachysisRecord.setId(uuid);
				String metachysisReasonn = transfusionStr[i].split(":")[0];
				String metachysisTime = transfusionStr[i].split(":")[1];
				
				metachysisRecord.setMetachysisReasonn(metachysisReasonn);
				metachysisRecord.setMetachysisTime(metachysisTime);
				metachysisRecord.setIdNumber(idNumber);
				metachysisRecord.setArchiveNo(archiveNo);
				//metachysisRecord.setCreateName(createName);
				metachysisRecord.setCreateTime(new Date());
				
				mentachysisRecordDao.insertSelective(metachysisRecord);
				
			}
		}
		
		
		
		
		residentBaseInfoDao.insertSelective(residentBaseInfo);
		
		
	}


	@SuppressWarnings("deprecation")
	@Override
	public Map<String, String> exportPdf(String archiveNo) {
		Map<String, String> map = new HashMap<String,String>();
		List<ResidentBaseInfo> list = residentBaseInfoDao.findResidentByArchiveNo(archiveNo);
		if(list != null && list.size() > 0){
			
			ResidentBaseInfo info = list.get(0);
			Date cdate = info.getCreateTime();
			
			map.put("a1", archiveNo.substring(0,1));
			map.put("a2", archiveNo.substring(1,2));
			map.put("a3", archiveNo.substring(2,3));
			map.put("a4", archiveNo.substring(3,4));
			map.put("a5", archiveNo.substring(4,5));
			map.put("a6", archiveNo.substring(5,6));
			map.put("a7", archiveNo.substring(6,7));
			map.put("a8", archiveNo.substring(7,8));
			map.put("a9", archiveNo.substring(8,9));
			map.put("a10", archiveNo.substring(9,10));
			map.put("a11", archiveNo.substring(10,11));
			map.put("a12", archiveNo.substring(11,12));
			map.put("a13", archiveNo.substring(12,13));
			map.put("a14", archiveNo.substring(13,14));
			map.put("a15", archiveNo.substring(14,15));
			map.put("a16", archiveNo.substring(15,16));
			map.put("a17", archiveNo.substring(16,17));
			
			//姓名
			map.put("name", info.getName());
			//现住址
			map.put("address", info.getResidenceAddress());
			//户籍地址
			map.put("raddress", info.getRegisterAddress());
			
			map.put("phone", info.getPhone());
			//乡镇名称
			map.put("townsName", info.getTownsName());
			//村委会名称
			map.put("villageName", info.getVillageName());
			//建档机构
			map.put("aichiveOrg", info.getAichiveOrg());
			//建档人
			map.put("createUser", info.getCreateName());
			//责任医生
			map.put("doctorName", info.getDoctorName());
			if(cdate != null){
				map.put("cyear", String.valueOf(1900 + cdate.getYear()));
				map.put("cmonth", String.valueOf(cdate.getMonth() + 1));
				map.put("cdate", String.valueOf(cdate.getDate()));
			}
			
			map.put("sex", info.getSex());
			String birthday = info.getBirthday();
			
			if(!"".equals(birthday)){
				String[] b = birthday.split("-");
				map.put("b1", b[0].substring(0, 1));
				map.put("b2", b[0].substring(1, 2));
				map.put("b3", b[0].substring(2, 3));
				map.put("b4", b[0].substring(3, 4));
				
				map.put("b5", b[1].substring(0, 1));
				map.put("b6", b[1].substring(1, 2));
				
				map.put("b7", b[2].substring(0, 1));
				map.put("b8", b[2].substring(1, 2));
			}else{
				map.put("b1", "");
				map.put("b2", "");
				map.put("b3", "");
				map.put("b4", "");
				
				map.put("b5", "");
				map.put("b6", "");
				
				map.put("b7", "");
				map.put("b8", "");
			}
			
			map.put("idNumber", info.getIdNumber());
			
			map.put("company", info.getCompany());
			
			map.put("linkName", info.getLinkName());
			
			map.put("linkPhone", info.getLinkPhone());
			
			map.put("residentType", info.getResidentType());
			
			if(info.getNation() != null && !info.getNation().equals("")){
				if("01".equals(info.getNation()) || "1".equals(info.getNation())){
					map.put("nationCode", "01");
				}else{
					map.put("nationCode", "99");
					map.put("nation", ApiConstants.NATION.get(info.getNation()));
				}
			}
			
			map.put("blood", info.getBloodGroup());
			
			map.put("rh", info.getBloodRh());
			
			map.put("education", info.getEducation());
			
			map.put("profession", info.getProfession());
			
			map.put("mari", info.getMaritalStatus());
			
			String paytype = info.getPayType();
			if(StringUtil.isNotEmpty(paytype)){
				String[] py = paytype.split(",");
				for(int i = 1; i <= py.length; i++){
					map.put("p" + i , py[i -1]);
				}
			}
			
			map.put("payOther", info.getPayOther());

			String allergys = info.getDrugAllergy();
			if(StringUtil.isNotEmpty(allergys)){
				String[] a = allergys.split(",");
				for(int i = 1; i <= a.length; i++){
					map.put("allergy" + i , a[i -1]);
				}
			}

			map.put("allergyOther", info.getAllergyOther());
			
			String exposures = info.getExposure();
			if(StringUtil.isNotEmpty(exposures)){
				String[] e = exposures.split(",");
				for(int i = 1; i <= e.length; i++){
					map.put("exposure" + i , e[i-1]);
				}
			}
			
			ResidentDiseases dis = new ResidentDiseases();
			dis.setArchiveNo(archiveNo);
			List<ResidentDiseases> disList = residentDiseasesDao.selectByArchiveNo(dis);
			if(disList != null && disList.size() > 0){
				for(int i = 1; i <= disList.size(); i++){
					ResidentDiseases disease = disList.get(i-1);
					map.put("disease" + i, disease.getDiseaseType());
					String date = disease.getDiseaseDate();
					if(!date.equals("")){
						String[] d = date.split("-");
						map.put("diseaseY" + i, d[0]);
						map.put("diseaseM" + i, d[1]);
					}
					
					if("6".equals(disease.getDiseaseType())){
						map.put("therioma", disease.getDiseaseName());
					}else if("12".equals(disease.getDiseaseType())){
						map.put("indDisease", disease.getDiseaseName());
					}else if("13".equals(disease.getDiseaseType())){
						map.put("diseaseOther", disease.getDiseaseName());
					}
				}
			}
			
			if(map.get("diseaseOther") == null || map.get("diseaseOther").equals("")){
				map.put("diseaseOther", info.getDiseaseOther());
			}

			OperationRecord o = new OperationRecord();
			o.setArchiveNo(archiveNo);
			List<OperationRecord> operList = operationRecordDao.selectByArchiveNo(o);
			if(operList != null && operList.size() > 0){
				map.put("isOperation", "2");
				for(int i = 1; i <= operList.size(); i++){
					OperationRecord or = operList.get(i-1);
					map.put("operationName" + i, or.getOperationName());
					if(or.getOperationTime() != null && !"".equals(or.getOperationTime())){
						map.put("operationDate" + i, or.getOperationTime().substring(0, 7));
					}
					
				}
			}else{
				map.put("isOperation", "1");
			}
			
			TraumatismRecord tra = new TraumatismRecord();
			tra.setArchiveNo(archiveNo);
			List<TraumatismRecord> traList = traumatismRecordDao.selectByArchiveNo(tra);
			if(traList != null && traList.size() > 0){
				map.put("isTraumatism", "2");
				for(int i = 1; i <= traList.size(); i++){
					TraumatismRecord tr = traList.get(i-1);
					map.put("traumatismName" + i, tr.getTraumatismName());
					if(tr.getTraumatismTime() != null && !"".equals(tr.getTraumatismTime())){
						map.put("traumatismDate" + i, tr.getTraumatismTime().substring(0, 7));
					}
				}
			}else{
				map.put("isTraumatism", "1");
			}

			MetachysisRecord met = new MetachysisRecord();
			met.setArchiveNo(archiveNo);
			
			List<MetachysisRecord> metList = mentachysisRecordDao.selectByArchiveNo(met);
			if(metList != null && metList.size() > 0){
				map.put("isMetachysis", "2");
				for(int i = 1; i <= metList.size(); i++){
					MetachysisRecord mr = metList.get(i-1);
					map.put("metachysisReason" + i, mr.getMetachysisReasonn());
					if(mr.getMetachysisTime() != null && !"".equals(mr.getMetachysisTime())){
						map.put("metachysisDate" + i, mr.getMetachysisTime().substring(0, 7));
					}
				}
			}else{
				map.put("isMetachysis", "1");
			}

			FamilyRecord fam = new FamilyRecord();
			fam.setArchiveNo(archiveNo);
			List<FamilyRecord> famList = familyRecordDao.selectByArchiveNo(fam);
			if(famList != null && famList.size() > 0){
				int f = 0;
				int m = 0;
				int b = 0;
				int c = 0;
				
				for(int i = 0; i < famList.size(); i++){
					FamilyRecord fr = famList.get(i);
					if("1".equals(fr.getRelation())){
						f = f + 1;
						map.put("fat" + f, fr.getDiseaseCode());
						if("12".equals(fr.getDiseaseCode())){
							map.put("fatOther", fr.getDiseaseName());
						}
					}else if("2".equals(fr.getRelation())){
						m = m + 1;
						map.put("mot" + m, fr.getDiseaseCode());
						if("12".equals(fr.getDiseaseCode())){
							map.put("motOther", fr.getDiseaseName());
						}
					}else if("3".equals(fr.getRelation())){
						b = b + 1;
						map.put("bro" + b, fr.getDiseaseCode());
						if("12".equals(fr.getDiseaseCode())){
							map.put("broOther", fr.getDiseaseName());
						}
					}else{
						c = c + 1;
						map.put("chi" + c, fr.getDiseaseCode());
						if("12".equals(fr.getDiseaseCode())){
							map.put("chiOther", fr.getDiseaseName());
						}
					}
				}
			}
			map.put("isHeredity", String.valueOf(info.getIsHeredity()));
			
			map.put("heredityName", info.getHeredityName());
			
			String deformitys = info.getIsDeformity();
			if(StringUtil.isNotEmpty(deformitys)){
				String[] def = deformitys.split(",");
				for(int i = 1; i <= def.length; i++){
					map.put("deformity" + i , def[i-1]);
				}
			}
			
			map.put("deformityName", info.getDeformityName());
			
			map.put("kitchen", info.getKitchen());
			
			map.put("fuel", info.getFuel());
			
			map.put("drink", info.getDrink());
			
			map.put("toilet", info.getToilet());
			
			map.put("poultry", info.getPoultry());
			
		}
		return map;
	}


	@Override
	public int updateResident(ResidentVo vo) {
		ResidentBaseInfo residentBaseInfo = new ResidentBaseInfo();
		BeanUtils.copyProperties(vo,residentBaseInfo);
		String archiveNo = vo.getArchiveNo();
		//家族史
		String familyRecord = vo.getFamilyRecord();
		familyRecordDao.deleteByArchiveNo(archiveNo);
		if(!StringUtil.isEmpty(familyRecord)) {		
			String[] familyRecordStr = familyRecord.split(",");
			for (int i = 0; i < familyRecordStr.length; i++) {
				FamilyRecord family = new FamilyRecord();
				
				if(StringUtil.isNotEmpty(familyRecordStr[i])){
					String[] diss = familyRecordStr[i].split(":");
					
					String relation = "";//关系
					String diseaseCode = "";//疾病编码
					String diseaseName = "";//疾病名称
					
					if(diss.length > 0){
						relation = diss[0];
					}
					if(diss.length > 1){
						diseaseCode = diss[1];
					}
					
					if(diss.length > 2){
						diseaseName = diss[2];
					}
					String uuid = CodeUtil.getUUID();
					family.setId(uuid);
					family.setArchiveNo(archiveNo);
					family.setIdNumber(vo.getIdNumber());
					family.setRelation(relation);
					family.setDiseaseCode(diseaseCode);
					family.setDiseaseName(diseaseName);
					//family.setCreateName(createName);
					family.setCreateTime(new Date());
					
					familyRecordDao.insertSelective(family);					
				}								
			}
		}
								
		//既往史中的疾病
		String historyIllness = vo.getHistoryIllness();
		residentDiseasesDao.deleteByArchiveNo(archiveNo);
		if(!StringUtil.isEmpty(historyIllness)) {			
			String[] historyIllnessStr = historyIllness.split(",");
			for (int i = 0; i < historyIllnessStr.length; i++) {
				ResidentDiseases residentDiseases = new ResidentDiseases();
				String diseaseType = historyIllnessStr[i].split(":")[0];//疾病编码
				if(diseaseType.equals("1")) {
					residentBaseInfo.setIsHypertension(0);
					residentBaseInfo.setIsDiabetes(0);
					residentBaseInfo.setIsPsychosis(0);
					residentBaseInfo.setIsTuberculosis(0);
				}else {
					String diseaseDate = historyIllnessStr[i].split(":")[1];//疾病日期
					//String diseaseName = historyIllnessStr[i].split(":")[1];//疾病名字
					String uuid = CodeUtil.getUUID();
					residentDiseases.setId(uuid);//id
					residentDiseases.setArchiveNo(archiveNo);//档案编号
					residentDiseases.setIdNumber(vo.getIdNumber());//身份证号
					//residentDiseases.setCreateName(createName);//创建人
					residentDiseases.setCreateTime(new Date());//创建时间
					residentDiseases.setDiseaseType(diseaseType);//疾病编码
					if("6".equals(diseaseType)){
						residentDiseases.setDiseaseName(vo.getCancer());//恶性肿瘤
					}else if("12".equals(diseaseType)){
						residentDiseases.setDiseaseName(vo.getOccupationDisease());//职业病
					}else if("13".equals(diseaseType)){
						residentDiseases.setDiseaseName(vo.getDiseaseOther());
					}
					residentDiseases.setDiseaseDate(diseaseDate);//疾病日期
					
					if("2".equals(diseaseType) ) {
						residentBaseInfo.setIsHypertension(1);
					}
					if("3".equals(diseaseType)) {
						residentBaseInfo.setIsDiabetes(1);
					}
					if("8".equals(diseaseType)) {
						residentBaseInfo.setIsPsychosis(1);
					}
					if("9".equals(diseaseType)) {
						residentBaseInfo.setIsTuberculosis(1);
					}				
					residentDiseasesDao.insertSelective(residentDiseases);		
				}
						
			}
		}
		
		//手术
		operationRecordDao.deleteByArchiveNo(archiveNo);
		String operation = vo.getOperation();
		if(!StringUtil.isEmpty(operation)) {			
			String[] operationStr = operation.split(",");
			for (int i = 0; i < operationStr.length; i++) {
				OperationRecord operationRecord = new OperationRecord();
				String operationName = operationStr[i].split(":")[0];//手术名称
				String operationTime = operationStr[i].split(":")[1];//手术时间
				
				String uuid = CodeUtil.getUUID();
				operationRecord.setId(uuid);
				operationRecord.setIdNumber(vo.getIdNumber());
				operationRecord.setArchiveNo(archiveNo);
				operationRecord.setOperationName(operationName);//手术名称
				operationRecord.setOperationTime(operationTime);//手术时间
				//operationRecord.setCreateName(createName);//创建人
				operationRecord.setCreateTime(new Date());//创建时间
				
				operationRecordDao.insertSelective(operationRecord);
				
			}			
		}
						
		//外伤
		String trauma = vo.getTrauma();
		traumatismRecordDao.deleteByArchiveNo(archiveNo);
		if(!StringUtil.isEmpty(trauma)) {			
			String[] traumaStr = trauma.split(",");
			for (int i = 0; i < traumaStr.length; i++) {
				TraumatismRecord traumatismRecord = new TraumatismRecord();
				
				String uuid = CodeUtil.getUUID();
				traumatismRecord.setId(uuid);
				traumatismRecord.setIdNumber(vo.getIdNumber());
				traumatismRecord.setArchiveNo(archiveNo);
				String traumatismName = traumaStr[i].split(":")[0];//外伤名称
				String traumatismTime = traumaStr[i].split(":")[1];//外伤时间
				traumatismRecord.setTraumatismName(traumatismName);
				traumatismRecord.setTraumatismTime(traumatismTime);
				//traumatismRecord.setCreateName(createName);
				traumatismRecord.setCreateTime(new Date());
				traumatismRecordDao.insertSelective(traumatismRecord);
				
			}
		}
		
		
		//输血
		String transfusion = vo.getTransfusion();
		mentachysisRecordDao.deleteByArchiveNo(archiveNo);
		if(!StringUtil.isEmpty(transfusion)) {			
			String[] transfusionStr = transfusion.split(",");
			for (int i = 0; i < transfusionStr.length; i++) {
				MetachysisRecord metachysisRecord = new MetachysisRecord();
				
				String uuid = CodeUtil.getUUID();
				metachysisRecord.setId(uuid);
				String metachysisReasonn = transfusionStr[i].split(":")[0];
				String metachysisTime = transfusionStr[i].split(":")[1];
				
				metachysisRecord.setMetachysisReasonn(metachysisReasonn);
				metachysisRecord.setMetachysisTime(metachysisTime);
				metachysisRecord.setIdNumber(vo.getIdNumber());
				metachysisRecord.setArchiveNo(archiveNo);
				//metachysisRecord.setCreateName(createName);
				metachysisRecord.setCreateTime(new Date());				
				mentachysisRecordDao.insertSelective(metachysisRecord);
				
			}
		}
		return residentBaseInfoDao.updateByArchiveNo(residentBaseInfo);
	}



}
