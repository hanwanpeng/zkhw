package com.zkhw.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zkhw.code.dao.AreaConfigDao;
import com.zkhw.code.entity.AreaConfig;
import com.zkhw.common.vo.Menu1Vo;
import com.zkhw.common.vo.Menu2Vo;
import com.zkhw.framework.redis.RedisClient;
import com.zkhw.framework.utils.JsonConverter;
import com.zkhw.framework.utils.StringUtils;
import com.zkhw.sys.entity.SysMenu;

/**
 * 从缓存中获取数据的公共类
 * 
 *
 */

@Service
public class CommonUtil {

	@Resource
	private RedisClient redisClient;

	@Resource
	private AreaConfigDao areaConfigDao;

	/**
	 * 获取所有权限
	 * 
	 * @return
	 */
	public List<SysMenu> getAllMenu() {
		List<String> modules = redisClient.getList(ApiConstants.ZKHW_MODULE);
		String module = null;
		SysMenu moduleMenu = null;
		String menu1Str = null;
		Menu1Vo menu1 = null;
		List<Menu1Vo> menu1List = null;
		List<Menu2Vo> menu2List = null;
		Menu2Vo menu2 = null;
		SysMenu menu1Menu = null;
		SysMenu menu2Menu = null;
		List<SysMenu> allMenu = new ArrayList<SysMenu>();
		Map<String, String> menus = redisClient.getHashAll(ApiConstants.ZKHW_MENU);
		for (int i = 0; i < modules.size(); i++) { // 模块
			module = modules.get(i);
			moduleMenu = JsonConverter.json2Obj(module, SysMenu.class);
			allMenu.add(moduleMenu);
			menu1Str = menus.get(moduleMenu.getMenuCode());
			menu1List = JsonConverter.json2ObjList(menu1Str, Menu1Vo.class);
			if (menu1List != null && menu1List.size() != 0) { // 一级菜单
				for (int j = 0; j < menu1List.size(); j++) {
					menu1 = menu1List.get(j);
					menu1Menu = new SysMenu();
					// menu1Menu.setCompanyCode(menu1.getMenuLevel().toString());
					menu1Menu.setMenuCode(menu1.getRightCode());
					menu1Menu.setMenuParentCode(menu1.getParentCode());
					menu1Menu.setMenuLevel(menu1.getRightLevel());
					menu1Menu.setMenuName(menu1.getRightName());
					menu1Menu.setMenuUrl(menu1.getRightUrl());
					menu1Menu.setMenuImgUrl(menu1.getImageUrl());
					allMenu.add(menu1Menu);
					menu2List = menu1.getMenu2();
					if (menu2List != null && menu2List.size() != 0) { // 二级菜单
						for (int k = 0; k < menu2List.size(); k++) {
							menu2 = menu2List.get(k);
							menu2Menu = new SysMenu();
							menu2Menu.setMenuCode(menu2.getRightCode());
							menu2Menu.setMenuParentCode(menu2.getParentCode());
							menu2Menu.setMenuLevel(menu2.getRightLevel());
							menu2Menu.setMenuName(menu2.getRightName());
							menu2Menu.setMenuUrl(menu2.getRightUrl());
							menu2Menu.setMenuImgUrl(menu2.getImageUrl());
							allMenu.add(menu1Menu);
						}
					}
				}
			}
		}
		return allMenu;
	}

	/**
	 * 根据权限码获取权限
	 * 
	 * @param rightCode
	 * @return
	 */
	public SysMenu findMenuByCode(String rightCode) {
		String rightJson = redisClient.get(ApiConstants.ZKHW_RIGHT + rightCode);
		SysMenu right = JsonConverter.json2Obj(rightJson, SysMenu.class);
		return right;
	}

	/**
	 * 根据区域编号获取区域信息(省-市-区县)
	 * 
	 * @param code
	 * @return
	 */
	public AreaConfig getAreaByCode(String code) {
		if (!StringUtils.isEmpty(code)) {
			String allAreaKey = ApiConstants.AREA_ALL;
			boolean exists = redisClient.exists(allAreaKey);
			String areaJson = null;
			AreaConfig area = null;
			if (!exists) { // key
				List<AreaConfig> areaList = areaConfigDao.findAllArea();
				if (areaList != null && areaList.size() > 0) {
					for (int i = 0; i < areaList.size(); i++) {
						area = areaList.get(i);
						areaJson = JsonConverter.obj2Json(area);
						redisClient.setHash(allAreaKey, area.getCode().toString(), areaJson);
					}
				}
			}
			areaJson = redisClient.getHashValue(allAreaKey, code);
			area = JsonConverter.json2Obj(areaJson, AreaConfig.class);
			return area;
		} else {
			return null;
		}

	}

	/**
	 * 获取所有省级/直辖市
	 * 
	 * @return
	 */
	public List<AreaConfig> getAllProvince() {
		String allProvinceKey = ApiConstants.AREA_PROVINCE_CODE; // 省级key
		boolean exists = redisClient.exists(allProvinceKey);
		List<AreaConfig> proList = new ArrayList<AreaConfig>();
		if (!exists) {
			String provinceJson;
			AreaConfig province;			
			List<AreaConfig> provinceList = areaConfigDao.findAllProvince();
			if (provinceList != null && provinceList.size() > 0) {
				for (int i = 0; i < provinceList.size(); i++) {
					province = provinceList.get(i);
					proList.add(province);
					provinceJson = JsonConverter.obj2Json(province);
					redisClient.setListRPush(allProvinceKey, provinceJson);
				}
			}
		}else{
			List<String> provinceList = redisClient.getList(allProvinceKey);
			AreaConfig province = null;
			String jsonPro = null;
			for (int i = 0; i < provinceList.size(); i++) {
				jsonPro = provinceList.get(i);
				province = JsonConverter.json2Obj(jsonPro, AreaConfig.class);
				proList.add(province);
			}
		}

		return proList;
	}

	/**
	 * 根据 省级 获取相应 市级
	 */
	public List<AreaConfig> getCity(String provinceCode) {
		if (!StringUtils.isEmpty(provinceCode)) {
			String cityKeyPre = ApiConstants.AREA_CITY_CODE;
			String cityKey = cityKeyPre + provinceCode;
			String cityKeyTemp;
			boolean exists = redisClient.exists(cityKey);
			List<AreaConfig> cityList = new ArrayList<AreaConfig>();
			if (!exists) { // key过期
				AreaConfig area;
				String cityJson;
				List<AreaConfig> areaList = areaConfigDao.findCityByCode(provinceCode);
				cityKeyTemp = cityKeyPre + provinceCode;
				for (int j = 0; j < areaList.size(); j++) { // 缓存市级
					area = areaList.get(j);
					cityList.add(area);
					cityJson = JsonConverter.obj2Json(area);
					redisClient.setListRPush(cityKeyTemp, cityJson);

				}

			}else{
				List<String> cityDataList = redisClient.getList(cityKey);
				AreaConfig city = null;
				String jsonCity = null;
				for (int i = 0; i < cityDataList.size(); i++) {
					jsonCity = cityDataList.get(i);
					city = JsonConverter.json2Obj(jsonCity, AreaConfig.class);
					cityList.add(city);
				}
			}

			return cityList;
		} else {
			return null;
		}

	}

	/**
	 * 根据市级代码获取相应区县
	 * 
	 * @param cityCode
	 *            市级代码
	 * @return
	 */
	public List<AreaConfig> getCounty(String cityCode) {
		if (!StringUtils.isEmpty(cityCode)) {
			String areaKeyPre = ApiConstants.AREA_COUNTY_CODE;
			String areaKey = areaKeyPre + cityCode;
			AreaConfig area;
			String cityJson;
			List<AreaConfig> areaList = null;
			boolean exists = redisClient.exists(areaKey);
			if (!exists) {
				areaList = areaConfigDao.findCountyByCode(cityCode);
				for (int j = 0; j < areaList.size(); j++) { 
					area = areaList.get(j);
					cityJson = JsonConverter.obj2Json(area);
					redisClient.setListRPush(areaKey, cityJson);

				}
			}else{
				List<String> areaDataList = redisClient.getList(areaKey);
				areaList = new ArrayList<AreaConfig>();
				String jsonCounty = null;
				for (int i = 0; i < areaDataList.size(); i++) {
					jsonCounty = areaDataList.get(i);
					area = JsonConverter.json2Obj(jsonCounty, AreaConfig.class);
					areaList.add(area);
				}
			}

			return areaList;
		} else {
			return null;
		}
	}
	
	public List<AreaConfig> getTowns(String countyCode) {
		if (!StringUtils.isEmpty(countyCode)) {
			String areaKeyPre = ApiConstants.AREA_TOWNS_CODE;
			String areaKey = areaKeyPre + countyCode;
			AreaConfig area;
			String townsJson;
			List<AreaConfig> areaList = null;
			boolean exists = redisClient.exists(areaKey);
			if (!exists) {
				areaList = areaConfigDao.findTownsByCode(countyCode);
				for (int j = 0; j < areaList.size(); j++) { 
					area = areaList.get(j);
					townsJson = JsonConverter.obj2Json(area);
					redisClient.setListRPush(areaKey, townsJson);

				}
			}else{
				List<String> areaDataList = redisClient.getList(areaKey);
				areaList = new ArrayList<AreaConfig>();
				String jsonTowns = null;
				for (int i = 0; i < areaDataList.size(); i++) {
					jsonTowns = areaDataList.get(i);
					area = JsonConverter.json2Obj(jsonTowns, AreaConfig.class);
					areaList.add(area);
				}
			}

			return areaList;
		} else {
			return null;
		}
	}	

	
	public List<AreaConfig> getVillage(String townsCode) {
		if (!StringUtils.isEmpty(townsCode)) {
			String areaKeyPre = ApiConstants.AREA_VILLAGE_CODE;
			String areaKey = areaKeyPre + townsCode;
			AreaConfig area;
			String villageJson;
			List<AreaConfig> areaList = null;
			boolean exists = redisClient.exists(areaKey);
			if (!exists) {
				areaList = areaConfigDao.findVillageByCode(townsCode);
				for (int j = 0; j < areaList.size(); j++) { 
					area = areaList.get(j);
					villageJson = JsonConverter.obj2Json(area);
					redisClient.setListRPush(areaKey, villageJson);

				}
			}else{
				List<String> areaDataList = redisClient.getList(areaKey);
				areaList = new ArrayList<AreaConfig>();
				String jsonVillage = null;
				for (int i = 0; i < areaDataList.size(); i++) {
					jsonVillage = areaDataList.get(i);
					area = JsonConverter.json2Obj(jsonVillage, AreaConfig.class);
					areaList.add(area);
				}
			}

			return areaList;
		} else {
			return null;
		}
	}
	
	
	/**
	 * 获取所有地区
	 * 
	 * @return
	 */
	public List<AreaConfig> findAllArea() {
		String allAreaKey = ApiConstants.All_Area; // 全部地区
		boolean exists = redisClient.exists(allAreaKey);
		if (!exists) {
			String areaJson;
			AreaConfig areaConfig;
			List<AreaConfig> allAreaList = areaConfigDao.findAllArea();
			if (allAreaList != null && allAreaList.size() > 0) {
				for (int i = 0; i < allAreaList.size(); i++) {
					areaConfig = allAreaList.get(i);
					areaJson = JsonConverter.obj2Json(areaConfig);
					redisClient.setListRPush(allAreaKey, areaJson);
				}
			}
		}
		List<String> areaList = redisClient.getList(allAreaKey);
		List<AreaConfig> aList = new ArrayList<AreaConfig>();
		AreaConfig area = null;
		String areaJson = null;
		for (int i = 0; i < areaList.size(); i++) {
			areaJson = areaList.get(i);
			area = JsonConverter.json2Obj(areaJson, AreaConfig.class);
			aList.add(area);
		}
		return aList;
	}
}
