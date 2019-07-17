package com.zkhw.ltd.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zkhw.common.utils.CodeUtil;
import com.zkhw.common.utils.CommonUtil;
import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.ltd.bo.RoleBo;
import com.zkhw.ltd.dao.RoleDao;
import com.zkhw.ltd.dao.RoleMenuDao;
import com.zkhw.ltd.dao.UserRoleDao;
import com.zkhw.ltd.entity.Role;
import com.zkhw.ltd.entity.RoleMenu;
import com.zkhw.ltd.service.RoleService;
import com.zkhw.ltd.vo.RoleVo;
import com.zkhw.sys.entity.SysMenu;

@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;

	@Resource
	private RoleMenuDao roleMenuDao;
	
	@Resource
	private UserRoleDao userRoleDao;
	
	@Resource
	private CommonUtil commonUtil;

	/**
	 * 根据组织机构编码获取角色
	 * 
	 * @param companyCode
	 * @return
	 */
	public List<Role> findRoleByOrgan(String organCode) {
		return roleDao.findRoleByOrgan(organCode);
	}

	/**
	 * 角色分页查询
	 * 
	 * @param role
	 * @param pageData
	 * @return
	 */
	public PageInfos<Role> findRoleByPage(Role role, PageInfos<Role> pageData) {
		PageHelper.startPage((int) pageData.getPage(), (int) pageData.getPageSize());// pageNum, pageSize

		List<Role> list = roleDao.findRoleBySearch(role);
		// 用PageInfo对结果进行包装
		PageInfo<Role> page = new PageInfo<Role>(list);
		// 返回分页数据
		pageData.setPage(page.getPageNum()); // 当前页码
		pageData.setPageCount(page.getPages()); // 总页数
		pageData.setPageSize(page.getPageSize()); // 每页记录数
		pageData.setTotal(page.getTotal()); // 总记录数
		pageData.setRows(list);
		return pageData;
	}

	/**
	 * 根据角色编码获取角色
	 * @param roleCode
	 * @return
	 */
	public RoleVo findRoleByCode(String roleCode) {
		Role role =  roleDao.findRoleByCode(roleCode);  //角色信息
		//角色所属权限
		List<String> roleRights = roleMenuDao.findMenuByRole(roleCode);
		//公司下所有权限
		List<SysMenu> companyRights = commonUtil.getAllMenu();
		RoleVo roleVo = new RoleVo();
		roleVo.setRole(role);  //角色
		roleVo.setRoleRight(roleRights);  //角色对应的权限编码
		roleVo.setAllRight(companyRights);
		return roleVo;
	}

	/**
	 * 保存角色
	 * 
	 * @param Role
	 */
	public void saveRole(RoleBo roleBo) {
		Date now = new Date();
		String roleCode = CodeUtil.getUUID();
		Role role = new Role();
		role.setRoleCode(roleCode);
		role.setRoleName(roleBo.getRoleName());
		role.setRoleNote(roleBo.getRemark());
		role.setOrganCode(roleBo.getOrganCode());
		role.setParentOrgan(roleBo.getParentOrgan());
		role.setCreateTime(now);
		role.setUpdateTime(now);
		// 保存角色
		roleDao.saveRole(role);

		String rights = roleBo.getRights();
		String[] rightCodes = rights.split(",");
		String rightCode = null;
		RoleMenu roleRight = null;
		List<RoleMenu> roleRightList = new ArrayList<RoleMenu>();
		for (int i = 0; i < rightCodes.length; i++) {
			roleRight = new RoleMenu();
			rightCode = rightCodes[i];
			roleRight.setRoleCode(roleCode);
			roleRight.setMenuCode(rightCode);
			roleRight.setCreateTime(new Date());
			roleRightList.add(roleRight);
		}
		// 保存角色权限
		roleMenuDao.saveRoleMenuByBatch(roleRightList);
	}

	/**
	 * 根据code删除角色
	 * 
	 * @param roleCode
	 */
	public ApiJsonResult deleteRoleByCode(ApiJsonResult result,String roleCode) {
		//验证角色占用
		List<String> userCodes = userRoleDao.findUserByRole(roleCode);
		if( userCodes != null && userCodes.size() != 0 ) {
			result.setCode("r0002");
			result.setMsg("当前角色正在被用户使用");
		}else {
			//刪除角色
			roleMenuDao.deleteMenuByRole(roleCode);
			roleDao.deleteRoleByCode(roleCode);
			result.setCode("0");
			result.setMsg("");
		}
		return result;
	}

	/**
	 * 根据code修改角色
	 * 
	 * @param Role
	 */
	public void updateRoleByCode(RoleBo roleBo) {
		// 删除原角色权限
		roleMenuDao.deleteMenuByRole(roleBo.getRoleCode());
		Role role = new Role();
		role.setOrganCode(roleBo.getOrganCode());
		role.setRoleNote(roleBo.getRemark());
		role.setRoleName(roleBo.getRoleName());
		role.setRoleCode(roleBo.getRoleCode());
		// 更新角色
		roleDao.updateRoleByCode(role);

		String rights = roleBo.getRights();
		String[] rightCodes = rights.split(",");
		String rightCode = null;
		RoleMenu roleRight = null;
		List<RoleMenu> roleRightList = new ArrayList<RoleMenu>();
		for (int i = 0; i < rightCodes.length; i++) {
			roleRight = new RoleMenu();
			rightCode = rightCodes[i];
			roleRight.setRoleCode(roleBo.getRoleCode());
			roleRight.setMenuCode(rightCode);
			roleRight.setCreateTime(new Date());
			roleRightList.add(roleRight);
		}
		// 保存新角色权限
		roleMenuDao.saveRoleMenuByBatch(roleRightList);
	}

	@Override
	public List<Role> findAllRole() {
		return roleDao.findAllRole();
	}

}
