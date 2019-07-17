package com.zkhw.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zkhw.base.dao.VehicleManageDao;
import com.zkhw.base.entity.VehicleManage;
import com.zkhw.base.service.VehicleManagerService;
import com.zkhw.common.vo.PageInfos;

@Service
public class VehicleManagerServiceImpl implements VehicleManagerService {

	@Autowired
	private VehicleManageDao vehicleManageDao;
	
	/**
	 * 保存车辆信息
	 */
	@Override
	public void saveVehicle(VehicleManage vehicleManage) {
		vehicleManageDao.insertSelective(vehicleManage);
	}

	/**
	 * 修改车辆信息
	 */
	@Override
	public void updateVehicle(VehicleManage vehicleManage) {
		vehicleManageDao.updateByPrimaryKeySelective(vehicleManage);
		
	}

	/**
	 * 分页展示
	 */
	@Override
	public PageInfos<VehicleManage> vehicleByPage(VehicleManage vehicleManage, PageInfos<VehicleManage> pageData) {
		PageHelper.startPage( (int)pageData.getPage(), (int)pageData.getPageSize());//page, pageSize
		List<VehicleManage> list = vehicleManageDao.vehicleByPage(vehicleManage);
		PageInfo<VehicleManage> page = new PageInfo<VehicleManage>(list);
		pageData.setPage(page.getPageNum());      //当前页码
		pageData.setPageCount(page.getPages());   //总页数
		pageData.setPageSize(page.getPageSize()); //每页记录数
		pageData.setTotal(page.getTotal());       //总记录数
		pageData.setRows(page.getList());
		return pageData;
		
	}

	/**
	 * 删除车辆信息
	 */
	@Override
	public void deleteVehicle(VehicleManage vehicleManage) {
		String id = vehicleManage.getId();
		vehicleManageDao.deleteByPrimaryKey(id);
		
	}

	
	@Override
	public VehicleManage vehicleByCode(VehicleManage vehicleManage) {
		String id = vehicleManage.getId();
		VehicleManage vehicle = vehicleManageDao.selectByPrimaryKey(id);
		return vehicle;
	}

	
	
}
