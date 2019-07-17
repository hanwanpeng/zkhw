package com.zkhw.ltd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zkhw.ltd.entity.UserRole;

public interface UserRoleDao {
	/**
	 * 根据用户编码查询角色列表
	 * @param userCode
	 * @return
	 */
    public List<String> findRoleByUser(@Param("userCode") String userCode);
    
    /**
     * 角色编码
     * @param roleCode
     * @return 用户编码
     */
    public List<String> findUserByRole(String roleCode);
    
    /**
     * 保存用户角色
     * @param userRole
     */
    public int saveUserRole(UserRole userRole);
    
    /**
     * 批量保存用户角色
     * @param userRoleList
     */
    public void saveRoleRightByBatch(List<UserRole> userRoleList);
    
    /**
     *  根据用户删除用户角色
     * @param userCode
     */
    public void deleteUserRole(String userCode);
    
    int deleteByUserCode(String userCode);
    
    int deleteByRoleCode(String roleCode);
}