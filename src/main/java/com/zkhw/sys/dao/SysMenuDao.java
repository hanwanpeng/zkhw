package com.zkhw.sys.dao;

import java.util.List;

import com.zkhw.sys.entity.SysMenu;

public interface SysMenuDao {
	
	/**
	 * 保存系统菜单
	 * @param menu
	 * @return
	 */
	int saveMenu(SysMenu menu);
	
	
	/**
	 * 查询所有系统菜单
	 * @param menuCode
	 * @return
	 */
	List<SysMenu> findAllMenu();
	
	
	/**
	 * 根据条件查询系统菜单
	 * @return
	 */
	List<SysMenu> findMenuBySearch(SysMenu menu);
	
	/**
	 * 根据编码查询菜单
	 * @param menuCode
	 * @return
	 */
	SysMenu findMenuByCode(String menuCode);
	 
	 
	 /**
	  * 更新菜单
	  * @param menu
	  * @return
	  */
	int updateMenuByCode(SysMenu menu);
	
	
	/**
	 * 逻辑删除菜单
	 * @param menuCode
	 * @return
	 */
	int deleteMenuByLogic(String menuCode);
	
	
	/**
	 * 根据权限码查询子权限
	 * @param rightCode
	 * @return
	 */
	public List<SysMenu> findChildMenuByCode(String rightCode);

}