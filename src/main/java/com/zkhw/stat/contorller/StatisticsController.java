package com.zkhw.stat.contorller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkhw.common.utils.ApiConstants;
import com.zkhw.common.utils.SystemParam;
import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.LoginVo;
import com.zkhw.framework.redis.RedisClient;
import com.zkhw.framework.utils.JsonConverter;
import com.zkhw.framework.utils.JsonWebPrintUtils;
import com.zkhw.framework.utils.StringUtils;
import com.zkhw.ltd.dao.OrganizationDao;
import com.zkhw.ltd.entity.User;
import com.zkhw.ltd.service.OrganizationService;
import com.zkhw.ltd.service.UserService;
import com.zkhw.pub.dao.PhysicalExaminationDao;
import com.zkhw.pub.dao.ResidentBaseInfoDao;
import com.zkhw.stat.query.ResidentQuery;
import com.zkhw.stat.service.StatisticsService;
import com.zkhw.stat.vo.ChildVo;
import com.zkhw.stat.vo.ElderlyVo;
import com.zkhw.stat.vo.FlupVo;
import com.zkhw.stat.vo.GravidaVo;
import com.zkhw.stat.vo.PersonVo;
import com.zkhw.stat.vo.ResidentAgeVo;
import com.zkhw.stat.vo.StatResidentVo;
import com.zkhw.stat.vo.StatisticsVo;

@Controller
@RequestMapping("/stat")
public class StatisticsController {
	
	
	@Autowired
	private ResidentBaseInfoDao residentBaseInfoDao;
	
	@Autowired
	private StatisticsService statisticsService;
	
	@Autowired
	private RedisClient redisClient;
	
	@Autowired
	private OrganizationService organizationService;
	
	/**
	 * 个人统计（通过身份证号查询）-小程序
	 */
	@ResponseBody
	@RequestMapping(value = "/statForIdNumber", method = RequestMethod.GET)
	public void statForIdNumber(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,ResidentQuery query){
		try {
			PersonVo personVo = statisticsService.statForIdNumber(query);
			if(personVo != null) {
				result.setData(personVo);
				result.setCode("0");
				result.setMsg("成功");
			}else {
				result.setCode("1");
				result.setMsg("未查询到结果！");
			}
		}catch (Exception e) {
			result.setCode("1");
			result.setMsg("失败");
		}
		
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}
	
	
	
	
	/**
	 * 孕产妇统计
	 */
	@ResponseBody
	@RequestMapping(value = "/statForGravida", method = RequestMethod.GET)
	public void statForGravida(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,ResidentQuery query){
		try {
			GravidaVo gravidaVo = statisticsService.statForGravida(query);
			if(gravidaVo != null) {
				result.setData(gravidaVo);
				result.setCode("0");
				result.setMsg("成功");
			}else {
				result.setCode("1");
				result.setMsg("未查询到结果！");
			}
		}catch (Exception e) {
			result.setCode("1");
			result.setMsg("失败");
		}
		
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}
	
	
	/**
	 * 0-6岁儿童统计
	 */
	@ResponseBody
	@RequestMapping(value = "/statForChild", method = RequestMethod.GET)
	public void statForChild(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,ResidentQuery query){
		try {
			ChildVo childVo = statisticsService.statForChild(query);
			if(childVo != null) {
				result.setData(childVo);
				result.setCode("0");
				result.setMsg("成功");
			}else {
				result.setCode("1");
				result.setMsg("未查询到结果！");
			}
		}catch (Exception e) {
			result.setCode("1");
			result.setMsg("失败！");
		}
		
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}
	
	
	
	/**
	 * 慢病随访统计
	 */
	@ResponseBody
	@RequestMapping(value = "/statForFlup", method = RequestMethod.GET)
	public void statForFlup(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,ResidentQuery query){
		
		try {
			FlupVo flupVo = statisticsService.statForFlup(query);
			if(flupVo != null) {
				result.setData(flupVo);
				result.setCode("0");
				result.setMsg("成功");
			}else {
				result.setCode("1");
				result.setMsg("未查询到结果！");
			}
		}catch (Exception e) {
			result.setCode("1");
			result.setMsg("失败");
		}
		
		
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}
	
	
	/**
	 * 老年人统计
	 */
	@ResponseBody
	@RequestMapping(value = "/statForElderly", method = RequestMethod.GET)
	public void statForElderly(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,ResidentQuery query){
		
			ElderlyVo elderlyVo = statisticsService.statForElderly(query);
			if(elderlyVo != null) {
				result.setData(elderlyVo);
				result.setCode("0");
				result.setMsg("成功");
			}else {
				result.setCode("1");
				result.setMsg("未查询到结果！");
			}
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}
	
	
	/**
	 * 重点人群统计
	 */
	@ResponseBody
	@RequestMapping(value = "/statForSpecialMan", method = RequestMethod.GET)
	public void statForSpecialMan(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,ResidentQuery query){
		try {
//			String loginName = SystemParam.getUserId();
//	    	String loginVoJson = redisClient.get(ApiConstants.REDIS_KEY_PREFIX_SESSION+loginName);
//	    	LoginVo loginVo = null;
//	    	User user = null;
//	    	String provinceCode = null;
//	    	String cityCode = null;
//	    	String countyCode = null;
//	    	String townsCode = null;
//	    	String villageCode = null;
//	    	if( !StringUtils.isEmpty(loginVoJson)) {
//	    		loginVo = JsonConverter.json2Obj(loginVoJson,LoginVo.class);
//	    		user = loginVo.getUser();
//	    		provinceCode = loginVo.getProvinceCode();
//	    		cityCode = loginVo.getCityCode();
//	    		countyCode = loginVo.getCountyCode();
//	    		townsCode = loginVo.getTownsCode();
//	    		villageCode = loginVo.getVillageCode();
//	    	}
//			query.setProvinceCode(provinceCode);
//			query.setCityCode(cityCode);
//			query.setCountyCode(countyCode);
//			query.setTownsCode(townsCode);
//			query.setVillageCode(villageCode);
			StatResidentVo statResidentVo = statisticsService.statForSpecialMan(query);
			result.setData(statResidentVo);
			result.setCode("0");
			result.setMsg("成功");
		} catch (Exception e) {
			result.setCode("1");
			result.setMsg("未查询到结果！");
		}
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}
	
	
	/**
	 * 年龄段分布统计(男女)
	 */
	@ResponseBody
	@RequestMapping(value = "/statForAge", method = RequestMethod.GET)
	public void statForAge(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,ResidentQuery query){
		try {
			/*String loginName = SystemParam.getUserId();
	    	String loginVoJson = redisClient.get(ApiConstants.REDIS_KEY_PREFIX_SESSION+loginName);
	    	LoginVo loginVo = null;
	    	User user = null;
	    	String provinceCode = null;
	    	String cityCode = null;
	    	String countyCode = null;
	    	String townsCode = null;
	    	String villageCode = null;
	    	if( !StringUtils.isEmpty(loginVoJson)) {
	    		loginVo = JsonConverter.json2Obj(loginVoJson,LoginVo.class);
	    		user = loginVo.getUser();
	    		provinceCode = loginVo.getProvinceCode();
	    		cityCode = loginVo.getCityCode();
	    		countyCode = loginVo.getCountyCode();
	    		townsCode = loginVo.getTownsCode();
	    		villageCode = loginVo.getVillageCode();
	    	}
	    	query.setProvinceCode(provinceCode);
			query.setCityCode(cityCode);
			query.setCountyCode(countyCode);
			query.setTownsCode(townsCode);
			query.setVillageCode(villageCode);*/
			ResidentAgeVo residentAgeVo = statisticsService.statForAge(query);
			result.setData(residentAgeVo);
			result.setCode("0");
			result.setMsg("成功");
		} catch (Exception e) {
			result.setCode("1");
			result.setMsg("未查询到结果！");
		}
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}
	
	
	
	/**
	 * 按地区统计(功能取消了)
	 * @param redident
	 * @param pageData
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/statForArea", method = RequestMethod.GET)
	public void statForArea(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,ResidentQuery query){
		try {
			/*String userId = SystemParam.getUserId();
			User user = userService.findUserByCode(userId);
			String organCode = null;
			if( user != null) {
				organCode = user.getOrganCode();
			}*/
			String loginName = SystemParam.getUserId();
	    	String loginVoJson = redisClient.get(ApiConstants.REDIS_KEY_PREFIX_SESSION+loginName);
	    	LoginVo loginVo = null;
	    	User user = null;
	    	String userName = null;
	    	String organCode = null;
	    	if( !StringUtils.isEmpty(loginVoJson)) {
	    		loginVo = JsonConverter.json2Obj(loginVoJson,LoginVo.class);
	    		user = loginVo.getUser();
	    		userName = user.getUserName();
	    		organCode = user.getOrganCode();
	    	}
			query.setCreateOrg(organCode);
		
			StatisticsVo statisticsVo = statisticsService.statForArea(query);
			
			result.setData(statisticsVo);
			result.setCode("0");
			result.setMsg("成功");
		} catch (Exception e) {
			result.setCode("1");
			result.setMsg("未查询到结果！");
		}
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}
	
	/**
	 * 档案统计-按人群统计(功能取消了)
	 * @param redident
	 * @param pageData
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/statResidentForMan", method = RequestMethod.GET)
	public void statResidentForMan(HttpServletRequest req, HttpServletResponse resp,ApiJsonResult result,ResidentQuery query){
		try {
			StatResidentVo statResident = residentBaseInfoDao.statResidentForMan(query);
			Integer diabetesNum = statResident.getDiabetesNum();
			Integer elderNum = statResident.getElderNum();
			Integer hypertensionNum = statResident.getHypertensionNum();
			Integer poorNum = statResident.getPoorNum();
			Integer psychosisNum = statResident.getPsychosisNum();
			Integer totalNum = statResident.getTotalNum();
			Integer tuberculosisNum = statResident.getTuberculosisNum();
			Integer otherNum = totalNum - poorNum - psychosisNum - tuberculosisNum - diabetesNum - hypertensionNum - elderNum;
			statResident.setOtherNum(otherNum);
			
			result.setData(statResident);
			result.setCode("0");
			result.setMsg("成功");
		} catch (Exception e) {
			result.setCode("1");
			result.setMsg("删除异常");
		}
		JsonWebPrintUtils.printApiResult(req, resp, result);
	}
	
	

	
}
