package com.zkhw.ltd.service;

import java.util.List;

import com.zkhw.ltd.entity.UserRole;

public interface UserRoleService {

	int saveUserRole(UserRole record);
	
    int deleteByUserCode(String userCode);
    
    int deleteByRoleCode(String roleCode);
    
    /**
	 * 根据用户编码查询角色列表
	 * @param userCode
	 * @return
	 */
    public List<String> findRoleByUser(String userCode);
}
