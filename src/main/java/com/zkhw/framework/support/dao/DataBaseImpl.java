package com.zkhw.framework.support.dao;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

@SuppressWarnings({"rawtypes"})
public class DataBaseImpl extends SqlSessionDaoSupport implements IDataInterfaces {
	
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	
	/**
	 * @MethodName queryForList
	 * @Description 返回数据List
	 * @CreateDate 2014-12-29
	 * @param statementName
	 * @return
	 */
	public List queryForList(String statementName) {
		List obj = null;
		try {
			obj = this.getSqlSession().selectList(statementName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{closeSession();}
		return obj;
	}

	/**
	 * @MethodName queryForList
	 * @Description 返回数据List_对象参数
	 * @CreateDate 2014-12-29
	 * @param statementName
	 * @param parameterObject
	 * @return
	 */
	public List queryForList(String statementName, Object parameterObject) {
		List obj = null;
		try {
			obj = this.getSqlSession().selectList(statementName, parameterObject);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{closeSession();}
		return obj;
	}

	/**
	 * @MethodName queryForObject
	 * @Description 返回数据对象
	 * @CreateDate 2014-12-29
	 * @param statementName
	 * @return
	 */
	public Object queryForObject(String statementName) {
		Object obj = null;
		try {
			obj = this.getSqlSession().selectOne(statementName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{closeSession();}
		return obj;
	}

	/**
	 * @MethodName queryForObject
	 * @Description 返回数据对象_对象参数
	 * @CreateDate 2014-12-29
	 * @param statementName
	 * @param parameterObject
	 * @return
	 */
	public Object queryForObject(String statementName, Object parameterObject) {
		Object obj = null;
		try {
			obj = this.getSqlSession().selectOne(statementName, parameterObject);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{closeSession();}
		return obj;
	}

	/**
	 * @MethodName insert
	 * @Description 保存数据
	 * @CreateDate 2014-12-29
	 * @param statementName
	 * @return
	 */
	public Object insert(String statementName){
		Object obj = null;
		try {
			obj = this.getSqlSession().insert(statementName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{closeSession();}
		return obj;
	}

	/**
	 * @MethodName insert
	 * @Description 保存数据_对象参数
	 * @CreateDate 2014-12-29
	 * @param statementName
	 * @param parameterObject
	 * @return
	 */
	public Object insert(String statementName, Object parameterObject) {
		Object obj = null;
		try {
			obj = this.getSqlSession().insert(statementName, parameterObject);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{closeSession();}
		return obj;
	}

	/**
	 * @MethodName update
	 * @Description 更新数据
	 * @CreateDate 2014-12-29
	 * @param statementName
	 * @return
	 */
	public Object update(String statementName) {
		Object obj = null;
		try {
			obj = this.getSqlSession().update(statementName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{closeSession();}
		return obj;
	}

	/**
	 * @MethodName update
	 * @Description 更新数据_对象参数
	 * @CreateDate 2014-12-29
	 * @param statementName
	 * @param parameterObject
	 * @return
	 */
	public Object update(String statementName, Object parameterObject) {
		Object obj = null;
		try {
			obj = this.getSqlSession().update(statementName, parameterObject);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{closeSession();}
		return obj;
	}

	/**
	 * @MethodName delete
	 * @Description 删除数据
	 * @CreateDate 2014-12-29
	 * @param statementName
	 * @return
	 * @throws Exception 
	 */
	public Object delete(String statementName)  {
		Object obj = null;
		try {
			obj = this.getSqlSession().delete(statementName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{closeSession();}
		return obj;
	}

	/**
	 * @MethodName delete
	 * @Description 删除数据_对象参数
	 * @CreateDate 2014-12-29
	 * @param statementName
	 * @param parameterObject
	 * @return
	 * @throws Exception 
	 */
	public Object delete(String statementName, Object parameterObject) {
		Object obj = null;
		try {
			obj = this.getSqlSession().delete(statementName, parameterObject);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{closeSession();}
		return obj;
	}
	
	/**
	 * @MethodName  closeSession
	 * @Description 关闭sqlSession
	 * @CreateDate  statementName
	 */
	public static void closeSession() {
		SqlSession session = threadLocal.get();
		threadLocal.set(null);
		if (session != null) {
			session.close();
		}
	}
}
