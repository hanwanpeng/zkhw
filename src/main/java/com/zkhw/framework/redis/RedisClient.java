package com.zkhw.framework.redis;


import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * redis客户端类
 */
public interface RedisClient {
	/**
	 * 设置key，value，过期时�?
	 * 
	 * @param key
	 * @param value
	 * @param seconds
	 * @return
	 */
	public boolean setEx(String key, String value, int seconds);

	/**
	 * 设置key，value
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean set(String key, String value);
	
	/**
	 * 设置key，value
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean setList(String key, String value);

	/**
	 * 设置key，value
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean setListRPush(String key, String value);
	
	/**
	 * 设置key，value
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean setListByDbIndex(String key, String value,int dbIndex );
	
	/**
	 * 根据key删除
	 * 
	 * @param key
	 * @return
	 */
	public boolean del(String key);

	/**
	 * key更名 (newkey已存在时�? RENAME会覆盖旧 newkey)
	 * @param key
	 * @return
	 */
	public boolean renameKey(String oldkey,String newkey);	
	
	/**
	 * 从指定的数据库中删除key
	 * 
	 * @param key
	 * @return
	 */
	public boolean delByDbIndex(String key,int dbIndex,long deleteSize);
	
	/**
	 * 从指定的数据库中删除key
	 * 
	 * @param key
	 * @return
	 */
	public boolean delByDbIndex(String key,int dbIndex);
	
	/**
	 * 获取数据
	 * 
	 * @param key
	 * @return
	 */
	public String get(String key);

	/**
	 * 设置过期
	 * 
	 * @param key
	 * @param seconds
	 * @return
	 */
	public boolean expire(String key, int seconds);

	/**
	 * 根据模式批量查询keys
	 * 
	 * @param keyPattern (示例: abc_*)
	 * @return
	 */
	public Set<String> keys(String keyPattern);
	
	/**
	 * 根据模式批量删除keys
	 * 
	 * @param keyPattern (示例: abc_*)
	 * @return
	 */
	public Set<String> delKeys(String keyPattern);
	
	/**
	 * 获取集合大小
	 * 
	 * @param key
	 * @return 如果为null代表获取时出�?
	 */
	public Long llen(String key);
	
	/**
	 * 删除List元素
	 * 
	 * @param key
	 * @param deleteSize 要删除几�? 
	 * @return
	 */
	public void delListElements(String key,long deleteSize);
	
	/**
	 * 获取数据
	 * 
	 * @param key
	 * @return
	 */
	public List<String> getList(String key);
	
	/**
	 * 获取数据
	 * 
	 * @param key
	 * @return
	 */
	public String rpop(String key);
	
	/**
	 * 从指定的数据库中获取List数据
	 * 
	 * @param key
	 * @param dbIndex 数据库号(0-15)
	 * @return
	 */
	public List<String> getListByDbIndex(String key,int dbIndex);
	
	/**
	 * 获取数据
	 * 
	 * @param key 集合key
	 * @param maxSize �?多取多少�?
	 * @return
	 */
	public List<String> getList(String key,long maxSize);
	
	/**
	 * 判断key是否存在
	 * @param key
	 * @return
	 */
	public boolean exists(String key);
	
	/**
	 * 设置Hash类型
	 * @param key
	 * @param field  存储key
	 * @param value
	 */
	public void setHash(String key, String field,String value);
	
	
	public String getHashValue(String key, String field);
	
	/**
	 * 获取名称为key的map�?有�??
	 * @param key
	 * @return
	 */
	public Map<String,String> getHashAll(String key);
	
	public void delHash(String key,String field);
	
	
	/**
	 * 名称为key的hash中是否存在键为field的域
	 * @param key
	 * @return
	 */
	public boolean HashKeyExists(String key,String field);

	/**
	 * 获取指定map的全部key
	 * @param key
	 * @return
	 */
	public Set<String> hkeys(String key);
}
