package com.zkhw.framework.redis;


import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redis客户端类
 */
public final class RedisClientImpl implements RedisClient{
	private static final Logger logger = Logger.getLogger(RedisClientImpl.class);
	
	/**
	 * 数据�?
	 */
	private JedisPool jedisPool;

	/**
	 * 获取数据库连�?
	 * 
	 * @return
	 */
	public Jedis getConnection() {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return jedis;

	}

	/**
	 * 关闭数据库连�?
	 * 
	 * @param jedis
	 */
	public void closeConnection(Jedis jedis) {
		if (null != jedis) {
			try {
				//jedisPool.returnResource(jedis);
				jedis.close();
			} catch (Exception e) {
				logger.info(e);
				e.printStackTrace();
			}
		}

	}

	/**
	 * 设置key，value，过期时�?
	 * 
	 * @param key
	 * @param value
	 * @param seconds
	 * @return
	 */
	public boolean setEx(String key, String value, int seconds) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.setex(key, seconds, value);
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return false;
	}

	/**
	 * 设置key，value
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean set(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set(key, value);
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return false;
	}
	
	/**
	 * 设置key，value
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean setList(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.lpush(key, value);
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return false;
	}

	/**
	 * 设置key，value
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean setListRPush(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.rpush(key, value);
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return false;
	}
	
	/**
	 * 设置key，value
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean setListByDbIndex(String key, String value,int dbIndex ) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.select(dbIndex);
			jedis.lpush(key, value);
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return false;
	}
	
	/**
	 * 根据key删除
	 * 
	 * @param key
	 * @return
	 */
	public boolean del(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.del(key);
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return false;
	}

	/**
	 * key更名 (newkey已存在时�? RENAME会覆盖旧 newkey)
	 * @param key
	 * @return
	 */
	public boolean renameKey(String oldkey,String newkey) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			if(jedis.exists(oldkey)){
				jedis.rename(oldkey, newkey);
			}
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return false;
	}	
	
	/**
	 * 从指定的数据库中删除key
	 * 
	 * @param key
	 * @return
	 */
	public boolean delByDbIndex(String key,int dbIndex,long deleteSize) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.select(dbIndex);
			//jedis.del(key);
			
			long len = jedis.llen(key);
			if( len<= deleteSize ){
				jedis.del(key);
			}else{
				jedis.ltrim(key, 0,(len-deleteSize)-1);
			}
			
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return false;
	}
	
	/**
	 * 从指定的数据库中删除key
	 * 
	 * @param key
	 * @return
	 */
	public boolean delByDbIndex(String key,int dbIndex) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.select(dbIndex);
			jedis.del(key);
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return false;
	}
	
	/**
	 * 获取数据
	 * 
	 * @param key
	 * @return
	 */
	public String get(String key) {
		Jedis jedis = null;
		String value = null;
		try {
			jedis = jedisPool.getResource();
			value = jedis.get(key);
			return value;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return null;
	}

	/**
	 * 设置过期
	 * 
	 * @param key
	 * @param seconds
	 * @return
	 */
	public boolean expire(String key, int seconds) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.expire(key, seconds);
			return true;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return false;
	}

	/**
	 * 根据模式批量查询keys
	 * 
	 * @param keyPattern (示例: abc_*)
	 * @return
	 */
	public Set<String> keys(String keyPattern){
		Set<String> set = null;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			set = jedis.keys(keyPattern);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return set;
	}
	
	/**
	 * 根据模式批量删除keys
	 * 
	 * @param keyPattern (示例: abc_*)
	 * @return
	 */
	public Set<String> delKeys(String keyPattern){
		Set<String> set = null;
		Jedis jedis = null;			
		try {
			jedis = jedisPool.getResource();
			set = jedis.keys(keyPattern);
			for(String key : set){
				jedis.del(key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return set;
	}
	
	/**
	 * 普�?�redis pool
	 * @return
	 */
	public JedisPool getJedisPool() {
		return jedisPool;
	}
	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}
	
	/**
	 * 获取集合大小
	 * 
	 * @param key
	 * @return 如果为null代表获取时出�?
	 */
	public Long llen(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.llen(key);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return null;
	}
	
	/**
	 * 删除List元素
	 * 
	 * @param key
	 * @param deleteSize 要删除几�? 
	 * @return
	 */
	public void delListElements(String key,long deleteSize) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			long len = jedis.llen(key);
			if( len<= deleteSize ){
				jedis.del(key);
			}else{
				//jedis.ltrim(key, 0,(len-deleteSize)-1);
				jedis.ltrim(key, deleteSize,-1);
			}
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
	}
	
	/**
	 * 获取数据
	 * 
	 * @param key
	 * @return
	 */
	public List<String> getList(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			long len= jedis.llen(key);
			List<String> data=jedis.lrange(key, 0, len);
			return data;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return null;
	}
	
	/**
	 * 获取数据
	 * 
	 * @param key
	 * @return
	 */
	public String rpop(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.rpop(key);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return null;
	}
	
	/**
	 * 从指定的数据库中获取List数据
	 * 
	 * @param key
	 * @param dbIndex 数据库号(0-15)
	 * @return
	 */
	public List<String> getListByDbIndex(String key,int dbIndex) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.select(dbIndex);
			List<String> data=jedis.lrange(key, 0, -1);
			return data;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return null;
	}
	
	/**
	 * 获取数据
	 * 
	 * @param key 集合key
	 * @param maxSize �?多取多少�?
	 * @return
	 */
	public List<String> getList(String key,long maxSize) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			long len= jedis.llen(key);
			if(len<maxSize){
				maxSize = len;
			}
			List<String> data=jedis.lrange(key, 0, maxSize);
			return data;
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return null;
	}
	
	/**
	 * 判断key是否存在
	 * @param key
	 * @return
	 */
	public boolean exists(String key){
		Jedis jedis = null;
		boolean exists=false;
		try {
			jedis = jedisPool.getResource();
			exists=jedis.exists(key);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return exists;
	}
	
	/**
	 * 设置Hash类型
	 * @param key
	 * @param field  存储key
	 * @param value
	 */
	public void setHash(String key, String field,String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.hset(key, field, value);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
	}
	
	
	public String getHashValue(String key, String field){
		Jedis jedis = null;
		String value = null;
		try {
			jedis = jedisPool.getResource();
			value=jedis.hget(key, field);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return value;
	}
	
	/**
	 * 获取名称为key的map�?有�??
	 * @param key
	 * @return
	 */
	public Map<String,String> getHashAll(String key){
		Jedis jedis = null;
		Map<String,String> dataMap= null;
		try {
			jedis = jedisPool.getResource();
			dataMap=jedis.hgetAll(key);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return dataMap;
	}
	
	public void delHash(String key,String field){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.hdel(key, field);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
	
	}
	
	
	/**
	 * 名称为key的hash中是否存在键为field的域
	 * @param key
	 * @return
	 */
	public boolean HashKeyExists(String key,String field){
		Jedis jedis = null;
		boolean exists=false;
		try {
			jedis = jedisPool.getResource();
			exists=jedis.hexists(key, field);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return exists;
	}

	/**
	 * 获取指定map的全部key
	 * @param key
	 * @return
	 */
	public Set<String> hkeys(String key){
		Jedis jedis = null;
		Set<String> set = null;
		try {
			jedis = jedisPool.getResource();
			set=jedis.hkeys(key);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return set;
	}	
}
