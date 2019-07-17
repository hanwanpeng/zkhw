package com.zkhw.base.dao;

import java.util.List;

import com.zkhw.base.entity.VehicleManage;

public interface VehicleManageDao {
    int deleteByPrimaryKey(String id);

    int insert(VehicleManage record);

    int insertSelective(VehicleManage record);

    VehicleManage selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(VehicleManage record);

    int updateByPrimaryKey(VehicleManage record);

    /**
     * 分页展示
     */
	List<VehicleManage> vehicleByPage(VehicleManage vehicleManage);
}