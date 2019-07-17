package com.zkhw.base.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleManage implements Serializable {
	
    /**
     * 主键
     */
    private String id;

    /**
     * 车辆的17位vin号码
     */
    private String carid;

    /**
     * 车牌号
     */
    private String vehicleNumber;

    /**
     * 车辆名称
     */
    private String vehicleName;

    /**
     * 机构编码
     */
    private String organCode;

    /**
     * 机构名称
     */
    private String organName;

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
     * 区县编码
     */
    private String countyCode;

    /**
     * 区县名称
     */
    private String countyName;

    /**
     * 乡镇编码
     */
    private String townsCode;

    /**
     * 乡镇名称
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

    /**
     * 地址
     */
    private String address;

    /**
     * 修改人
     */
    private String updateName;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String createName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * vehicle_manage
     */
    private static final long serialVersionUID = 1L;

    
}