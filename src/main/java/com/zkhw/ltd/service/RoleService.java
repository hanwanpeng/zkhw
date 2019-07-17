package com.zkhw.ltd.service;

import java.util.List;

import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.ltd.bo.RoleBo;
import com.zkhw.ltd.entity.Role;
import com.zkhw.ltd.vo.RoleVo;

public interface RoleService {

	   /**
	    * 根据组织机构编码获取角色
	    * @param companyCode
	    * @return
	    */
	   public List<Role> findRoleByOrgan(String organCode);
	   
	   
	   /**
		 * 角色分页查询
		 * @param Role
		 * @param pageData
		 * @return
		 */
	  public PageInfos<Role> findRoleByPage(Role role,PageInfos<Role> pageData);
	
	   
	   /**
	    * 根据角色编码获取角色
	    * @param roleCode
	    * @return
	    */
	   public RoleVo findRoleByCode(String roleCode);
	
	
		/**
		 * 保存角色
		 * @param Role
		 */
		public void saveRole(RoleBo roleBo);
		
		
		/**
		 * 根据code删除角色
		 * @param roleCode
		 */
		public ApiJsonResult deleteRoleByCode(ApiJsonResult result,String roleCode);
	
	
		/**
		 * 根据code修改角色
		 * @param Role
		 */
		public void updateRoleByCode(RoleBo roleBo);

		
		List<Role> findAllRole();
}
