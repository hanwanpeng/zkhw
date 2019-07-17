package com.zkhw.ltd.dao;

import java.util.List;

import com.zkhw.ltd.entity.RoleMenu;

public interface RoleMenuDao {
	
	/*
	 * 根据权限编码查询角色编码
	 */
	public List<String> findRoleByMenu(String menuCode);
	
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
	 * @return
	 */
    public int deleteMenuByRole(String roleCode);
}