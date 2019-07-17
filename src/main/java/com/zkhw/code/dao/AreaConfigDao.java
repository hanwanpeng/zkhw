package com.zkhw.code.dao;

import java.util.List;

import com.zkhw.code.entity.AreaConfig;

public interface AreaConfigDao {

	
	/**
	 * 根据编码查询区域
	 */
	AreaConfig findAreaByCode(String code);
	
	
	/**
	 * 根据编码查询区域
	 * 
	 * @param code
	 * @return
	 */
	AreaConfig updateAreaByCode(String code);

	/**
	 * 查询所有区域
	 * 
	 * @return
	 */
	List<AreaConfig> findAllArea();

	/**
	 * 查询所有省
	 * 
	 * @return
	 */
	List<AreaConfig> findAllProvince();

	/**
	 * 根据省查询市级
	 * 
	 * @return
	 */
	List<AreaConfig> findCityByCode(String provinceCode);

	/**
	 * 查询市查询区县
	 * 
	 * @param cityCode
	 * @return
	 */
	List<AreaConfig> findCountyByCode(String cityCode);
	
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

	/**
	 * 保存区域
	 * 
	 * @param area
	 */
	void saveArea(AreaConfig area);

	/**
	 * 修改区域
	 * 
	 * @param area
	 */
	void updateAreaByCode(AreaConfig area);
	
	List<AreaConfig> findAreaByLevel(Integer level);


}