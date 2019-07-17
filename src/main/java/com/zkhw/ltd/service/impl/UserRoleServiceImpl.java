package com.zkhw.ltd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkhw.ltd.dao.UserRoleDao;
import com.zkhw.ltd.entity.UserRole;
import com.zkhw.ltd.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleDao userRoleDao;
	
	@Override
	public int saveUserRole(UserRole record) {
		return this.userRoleDao.saveUserRole(record);
	}

	@Override
	public int deleteByUserCode(String userCode) {
		return this.userRoleDao.deleteByUserCode(userCode);
	}

	@Override
	public int deleteByRoleCode(String roleCode) {
		return this.userRoleDao.deleteByRoleCode(roleCode);
	}

	@Override
	public List<String> findRoleByUser(String userCode) {
		return userRoleDao.findRoleByUser(userCode);
	}

}
