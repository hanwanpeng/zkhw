package com.zkhw.ltd.service;

import java.util.List;

import com.zkhw.ltd.entity.RoleMenu;

public interface RoleMenuService {
	
	/*
	 * 根据权限编码查询角色编码
	 */
	public List<String> findRoleByMenu(String rightCode);
	
	/*
	 * 根据角色编号查询权限编码
	 */
	public List<String> findMenuByRole(String roleCode);
	
	/**
	 * 批量保存角色权限 
	 * @param list
	 */
	public void saveRoleMenuByBatch(List<RoleMenu> list);
	
	/**
	 * 删除角色权限
	 * @param roleCode
	 */
	public void deleteMenuByRoleCode(String roleCode);
	
	
}
