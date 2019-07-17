package com.zkhw.stat.query;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResidentQuery {
	
	/**
	 * 年份
	 */
	private String year;

	/**
	 * 组织机构
	 */
	private String createOrg;
	
	/**
	 * 开始时间
	 */
	private String startTime;
	
	/**
	 * 结束时间
	 */
	private String endTime;
	
	/**
     * 省编码
     */
    private String provinceCode;

    /**
     * 省名称
     */
    private String provinceName;

    /**
     * 市编码
     */
    private String cityCode;

    /**
     * 市名称
     */
    private String cityName;

    /**
     * 县编码
     */
    private String countyCode;

    /**
     * 县名称
     */
    private String countyName;

    /**
     * 镇编码
     */
    private String townsCode;

    /**
     * 镇名称
     */
    private String townsName;

    /**
     * 村编码
     */
    private String villageCode;

    /**
     * 村名称
     */
    private String villageName;
	
	
}
