package com.zkhw.ltd.dao;

import java.util.List;

import com.zkhw.ltd.entity.Role;

public interface RoleDao {
	 /**
	    * 根据组织机构编码获取角色
	    * @param agencyCode
	    * @return
	    */
	   public List<Role> findRoleByOrgan(String organCode);

	   /**
	    * 获取全部角色
	    * @return
	    */
	   public List<Role> findAllRole();
	   /**
	    * 根据角色编码获取角色
	    * @param roleCode
	    * @return
	    */
	   public Role findRoleByCode(String roleCode);
	   
	   /**
	    * 角色搜索
	    * @param Role
	    * @return
	    */
	   public List<Role> findRoleBySearch(Role Role);
	
	
		/**
		 * 保存角色
		 * @param Role
		 */
		public void saveRole(Role Role);
		
		
		/**
		 * 根据code删除角色
		 * @param roleCode
		 */
		public void deleteRoleByCode(String roleCode);
	
	
		/**
		 * 根据code修改角色
		 * @param Role
		 */
		public void updateRoleByCode(Role Role);
    
    List<Role> findRoleList(Role record);
}