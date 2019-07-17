package com.zkhw.code.service;

import java.util.List;

import com.zkhw.code.entity.AreaConfig;
import com.zkhw.code.vo.TreeVo;

public interface AreaConfigService {

	/**
	 * 查询所有省市区县
	 * 
	 * @return
	 */
	public List<AreaConfig> findAllArea();

	/**
	 * 查询所有省/直辖市区
	 * 
	 * @return
	 */
	public List<AreaConfig> findAllProvince();

	/**
	 * 根据市级 查询区县级
	 * 
	 * @return
	 */
	public List<AreaConfig> findCountyByCode(String cityCode);

	/**
	 * 根据省级/直辖市 查询所属市级
	 * 
	 * @return
	 */
	public List<AreaConfig> findCityByCode(String provinceCode);
	
	/**
	 * 根据区县查询乡镇街道
	 * @param countyCode
	 * @return
	 */
	
	List<AreaConfig> findTownsByCode(String countyCode);
	
	/**
	 * 根据乡镇查询村，社区
	 * @param townsCode
	 * @return
	 */
	List<AreaConfig> findVillageByCode(String townsCode);
	

	public List<TreeVo> findTree(String level, String areaCodes);
}
