package com.zkhw.base.service;

import com.zkhw.base.entity.VehicleManage;
import com.zkhw.base.query.VehicleQuery;
import com.zkhw.base.vo.NetworkVehicleVo;
import com.zkhw.common.vo.PageInfos;

public interface VehicleManagerService {

	/*
	 * 保存车辆
	 */
	void saveVehicle(VehicleManage vehicleManage);

	/**
	 * 修改车辆
	 */
	void updateVehicle(VehicleManage vehicleManage);

	/**
	 * 分页展示
	 */
	PageInfos<VehicleManage> vehicleByPage(VehicleManage vehicleManage, PageInfos<VehicleManage> pageData);

	
	void deleteVehicle(VehicleManage vehicleManage);

	VehicleManage vehicleByCode(VehicleManage vehicleManage);

	NetworkVehicleVo isNetworkVehicle(VehicleQuery query);

}
