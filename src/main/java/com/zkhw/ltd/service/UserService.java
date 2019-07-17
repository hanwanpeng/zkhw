package com.zkhw.ltd.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.ltd.bo.UserBo;
import com.zkhw.ltd.entity.User;

public interface UserService {

	/**
	 * 保存用户
	 * 
	 * @param user
	 */
	public ApiJsonResult saveUser(User user, String roleCodes);

	/**
	 * 登录查询用户
	 * 
	 * @param loginName
	 * @param passWord
	 * @return
	 */
	public User findLoginUser(String loginName, String passWord);

	/**
	 * 更新用户
	 * 
	 * @param user
	 */
	public ApiJsonResult updateUserByCode(User user, String roleCodes);

	/**
	 * 根据用户编码查询用户
	 * 
	 * @param user
	 */
	public User findUserByCode(String userCode);

	/**
	 * 登录名是否存在
	 * 
	 * @param loginName
	 * @return
	 */
	public boolean existLoginName(String loginName);

	/**
	 * 根据登录名获取用户信息
	 * 
	 * @param loginName
	 * @return
	 */
	public User findUserByLoginName(String loginName);

	/**
	 * 用户分页列表
	 * 
	 * @param user
	 * @param pageData
	 * @return
	 */
	public PageInfos<UserBo> findUserByPage(User user, PageInfos<UserBo> pageData);

	/**
	 * web 登录
	 * 
	 * @param request
	 * @param response
	 * @param result
	 * @param loginName
	 * @param loginPass
	 * @return
	 * @throws Exception
	 */
	public ApiJsonResult webLogin(HttpServletRequest request, HttpServletResponse response, ApiJsonResult result,
			String loginName, String loginPass) throws Exception;

	/**
	 * 删除用户
	 * 
	 * @param userCode
	 */
	public void deleteUser(String userCode);



	void updateUserByCode(User user);
	
	
	List<User> findUserByOrgan(String organCode);

}
