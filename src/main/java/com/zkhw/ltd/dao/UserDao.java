package com.zkhw.ltd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zkhw.ltd.entity.User;

public interface UserDao {
	/**
	 * 保存用户
	 * 
	 * @param user
	 */
	public void saveUser(User user);

	/**
	 * 登录
	 * 
	 * @param loginName
	 * @param loginPass
	 * @return
	 */
	public User findLoginUser(@Param("loginName") String loginName, @Param("loginPass") String passWord);

	/**
	 * 用户搜索
	 * 
	 * @param user
	 * @return
	 */
	public List<User> findUserBySearch(User user);

	/**
	 * 根据用户编码查询用户
	 * 
	 * @param userCode
	 * @return
	 */
	public User findUserByCode(String userCode);

	/**
	 * 根据用户编码更新用户
	 * 
	 * @param user
	 */
	public void updateUserByCode(User user);

	/**
	 * app登录
	 * 
	 * @param loginName
	 * @param passWord
	 * @return
	 */
	public User findAppLoginUser(@Param("loginName") String loginName);

	/**
	 * 根据登录获取用户信息
	 * 
	 * @param loginName
	 * @return
	 */
	public User findUserByLoginName(String loginName);

	
	
	public List<User> findUserByOrgan(String organCode);

}