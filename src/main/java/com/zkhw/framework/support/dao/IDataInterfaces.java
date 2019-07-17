package com.zkhw.framework.support.dao;

import java.util.List;

@SuppressWarnings("rawtypes")
public interface IDataInterfaces {
	
	/**
	 * @MethodName  queryForList
	 * @Description 返回数据List
	 * @CreateDate  2012-4-24
	 * @Author      itd_PLE_ET
	 * @param statementName
	 * @return
	 */
	List queryForList(String statementName);
	
	/**
	 * @MethodName  queryForList
	 * @Description 返回数据List_对象参数
	 * @CreateDate  2012-4-24
	 * @Author      itd_PLE_ET
	 * @param statementName
	 * @param parameterObject
	 * @return
	 */
	List queryForList(String statementName, Object parameterObject);
	
	/**
	 * @MethodName  queryForObject
	 * @Description 返回数据对象
	 * @CreateDate  2012-4-24
	 * @Author      itd_PLE_ET
	 * @param statementName
	 * @return
	 */
	Object queryForObject(String statementName);
	
	/**
	 * @MethodName  queryForObject
	 * @Description 返回数据对象_对象参数
	 * @CreateDate  2012-4-24
	 * @Author      itd_PLE_ET
	 * @param statementName
	 * @param parameterObject
	 * @return
	 */
	Object queryForObject(String statementName, Object parameterObject);
	
	/**
	 * @MethodName  insert
	 * @Description 保存数据
	 * @CreateDate  2012-4-24
	 * @Author      itd_PLE_ET
	 * @param statementName
	 * @return
	 */
	Object insert(String statementName);
	
	/**
	 * @MethodName  insert
	 * @Description 保存数据_对象参数
	 * @CreateDate  2012-4-24
	 * @Author      itd_PLE_ET
	 * @param statementName
	 * @param parameterObject
	 * @return
	 */
	Object insert(String statementName, Object parameterObject);
	
	/**
	 * @MethodName  update
	 * @Description 更新数据
	 * @CreateDate  2012-4-24
	 * @Author      itd_PLE_ET
	 * @param statementName
	 * @return
	 */
	Object update(String statementName)throws Exception;
	
	/**
	 * @MethodName  update
	 * @Description 更新数据_对象参数
	 * @CreateDate  2012-4-24
	 * @Author      itd_PLE_ET
	 * @param statementName
	 * @param parameterObject
	 * @return
	 */
	Object update(String statementName, Object parameterObject);
	
	/**
	 * @MethodName  delete
	 * @Description 删除数据
	 * @CreateDate  2012-4-24
	 * @Author      itd_PLE_ET
	 * @param statementName
	 * @return
	 */
	Object delete(String statementName);
	
	/**
	 * @MethodName  delete
	 * @Description 删除数据_对象参数
	 * @CreateDate  2012-4-24
	 * @Author      itd_PLE_ET
	 * @param statementName
	 * @param parameterObject
	 * @return
	 */
	Object delete(String statementName, Object parameterObject);
	
}
