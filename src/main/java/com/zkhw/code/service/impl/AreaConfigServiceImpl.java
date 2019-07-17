package com.zkhw.code.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zkhw.code.dao.AreaConfigDao;
import com.zkhw.code.entity.AreaConfig;
import com.zkhw.code.service.AreaConfigService;
import com.zkhw.code.vo.TreeVo;
import com.zkhw.common.utils.CommonUtil;
import com.zkhw.framework.utils.StringUtils;

@Service
public class AreaConfigServiceImpl implements AreaConfigService {

	@Resource
	private AreaConfigDao areaConfigDao;

	@Resource
	private CommonUtil commonUtil;

	@Override
	public List<AreaConfig> findAllArea() {
		return areaConfigDao.findAllArea();
	}

	@Override
	public List<AreaConfig> findAllProvince() {
		return areaConfigDao.findAllProvince();
	}

	@Override
	public List<AreaConfig> findCityByCode(String provinceCode) {
		return areaConfigDao.findCityByCode(provinceCode);
	}

	@Override
	public List<AreaConfig> findCountyByCode(String cityCode) {
		return areaConfigDao.findCountyByCode(cityCode);
	}

	@Override
	public List<TreeVo> findTree(String level, String areaCodes) {
		List<TreeVo> voList = new ArrayList<TreeVo>();
		TreeVo vo = null;
		AreaConfig province = null;
		AreaConfig city = null;
		AreaConfig county = null;
		List<AreaConfig> provinces = commonUtil.getAllProvince();
		// 省
		if ("1".equals(level)) {
			for (int i = 0; i < provinces.size(); i++) {
				province = provinces.get(i);
				vo = new TreeVo();
				vo.setId(province.getCode() + "");
				vo.setPId(province.getParentCode() + "");
				vo.setName(province.getName());
				vo.setLeval("1");
				voList.add(vo);
			}
		} else if ("2".equals(level)) { // 市级
			for (int i = 0; i < provinces.size(); i++) {
				province = provinces.get(i);
				vo = new TreeVo();
				vo.setId(province.getCode() + "");
				vo.setPId(province.getParentCode() + "");
				vo.setName(province.getName());
				vo.setLeval("1");
				voList.add(vo);
				List<AreaConfig> cityList = commonUtil.getCity(province.getCode());
				for (int j = 0; j < cityList.size(); j++) {
					city = cityList.get(j);
					vo = new TreeVo();
					vo.setId(city.getCode() + "");
					vo.setPId(city.getParentCode() + "");
					vo.setName(city.getName());
					vo.setLeval("2");
					voList.add(vo);
				}
			}
		} else { // 区县
			for (int i = 0; i < provinces.size(); i++) {
				province = provinces.get(i);
				vo = new TreeVo();
				vo.setId(province.getCode() + "");
				vo.setPId(province.getParentCode() + "");
				vo.setName(province.getName());
				vo.setLeval("1");
				voList.add(vo);
				List<AreaConfig> cityList = commonUtil.getCity(province.getCode());
				for (int j = 0; j < cityList.size(); j++) {
					city = cityList.get(j);
					vo = new TreeVo();
					vo.setId(city.getCode() + "");
					vo.setPId(city.getParentCode() + "");
					vo.setName(city.getName());
					vo.setLeval("2");
					voList.add(vo);
					List<AreaConfig> countyList = commonUtil.getCounty(city.getCode());
					for (int k = 0; k < countyList.size(); k++) {
						county = countyList.get(k);
						vo = new TreeVo();
						vo.setId(county.getCode() + "");
						vo.setPId(county.getParentCode() + "");
						vo.setName(county.getName());
						vo.setLeval("3");
						voList.add(vo);
					}
				}
			}
		}

		if (!StringUtils.isEmpty(areaCodes)) {
			String[] codes = areaCodes.split(",");
			String code = "";
			for (int i = 0; i < voList.size(); i++) {
				vo = voList.get(i);
				for (int j = 0; j < codes.length; j++) {
					code = codes[j];
					if (vo.getId().equals(code)) {
						vo.setChecked("true");
						break;
					}
				}
			}
		}
		return voList;
	}

	@Override
	public List<AreaConfig> findTownsByCode(String countyCode) {
		return areaConfigDao.findTownsByCode(countyCode);
	}

	@Override
	public List<AreaConfig> findVillageByCode(String townsCode) {
		return areaConfigDao.findVillageByCode(townsCode);
	}
}
