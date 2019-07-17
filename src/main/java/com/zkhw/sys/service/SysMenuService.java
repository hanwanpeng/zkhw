package com.zkhw.sys.service;

import java.util.List;

import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.sys.entity.SysMenu;
import com.zkhw.sys.vo.SysMenuVo;

public interface SysMenuService {
	
	 /**
    * 分页查询所有权限
    * @param user
    * @param pageData
    * @return
    */
   public PageInfos<SysMenu> findAllRightByPage(PageInfos<SysMenu> pageData);
   
   /**
	 * 根据编码查询菜单
	 * @param menuCode
	 * @return
	 */
	public SysMenu findMenuByCode(String menuCode);
   
	
   /**
	 * 保存权限
	 * @param sysRight
	 */
	public void saveMenu(SysMenu sysRight);
	
	
	/**
	 * 逻辑删除菜单
	 * @param menuCode
	 */
	public void deleteMenuByLogic(String menuCode);
	
	
	/**
	  * 更新菜单
	  * @param menu
	  * @return
	  */
	public void updateMenuByCode(SysMenu menu);
	
	
	/**
	 * 菜单层级
	 * @return
	 */
	public List<SysMenuVo> findMenuVoList();
	
	/**
	 * 删除菜单
	 * @param menuCode
	 */
	public ApiJsonResult deleteMenu(ApiJsonResult result,String menuCode);
	
	/*
	 * 查询所有的权限
	 */
	public List<SysMenu> findAllMenu();
	
	
}
