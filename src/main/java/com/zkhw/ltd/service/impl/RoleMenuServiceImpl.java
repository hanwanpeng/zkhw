package com.zkhw.ltd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zkhw.ltd.dao.RoleMenuDao;
import com.zkhw.ltd.entity.RoleMenu;
import com.zkhw.ltd.service.RoleMenuService;

@Service
public class RoleMenuServiceImpl implements RoleMenuService{

	@Resource
	private RoleMenuDao roleMenuDao;
	
	/*
	 * 根据权限编码查询角色编码
	 */
	@Override
	public List<String> findRoleByMenu(String rightCode) {
		return roleMenuDao.findRoleByMenu(rightCode);
	}
	
	/*
	 * 根据角色编号查询权限编码
	 */
	@Override
	public List<String> findMenuByRole(String roleCode) {
		return roleMenuDao.findMenuByRole(roleCode);
	}

	/**
	 * 批量保存角色权限 
	 * @param list
	 */
	@Override
	public void saveRoleMenuByBatch(List<RoleMenu> list) {
		roleMenuDao.saveRoleMenuByBatch(list);
	}

	/**
	 * 删除角色权限
	 * @param roleCode
	 */
	@Override
	public void deleteMenuByRoleCode(String roleCode) {
		roleMenuDao.deleteMenuByRole(roleCode);
	}

}
