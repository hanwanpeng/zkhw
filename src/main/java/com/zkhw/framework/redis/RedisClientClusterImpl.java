package com.zkhw.framework.redis;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

/**
 * redis客户端类(集群�?)
 * 
 */
public final class RedisClientClusterImpl implements RedisClient{
	private static final Logger logger = Logger.getLogger(RedisClientClusterImpl.class);
	private String serverInfo; //redis集群各节点配�?
	
	public String getServerInfo() {
		return serverInfo;
	}
	public void setServerInfo(String serverInfo) {
		this.serverInfo = serverInfo;
	}

	private static Set<HostAndPort> set = null;

	private Set<HostAndPort> getClusterInfo() {
		if (null == set) {
			set = new HashSet<HostAndPort>();

			if (serverInfo == null || "".equals(serverInfo.length())) {
				throw new RuntimeException("The serverInfo can not be empty");
			}
			String ipPort[] = serverInfo.split(",");
			int len = ipPort.length;

			for (int i = 0; i < len; i++) {
				String server[] = ipPort[i].split(":");
				set.add(new HostAndPort(server[0], Integer.parseInt(server[1])));
			}
			logger.info("Redis Cluster SET:"+serverInfo);
		}
		return set;
	}
	
	public static void main(String[] args) {
	}
	
	/**
	 * 获取数据库连�?
	 * 
	 * @return
	 */
	private JedisCluster getConnection() {
		JedisCluster jc = null;
		try {
			Set<HostAndPort> jedisClusterNodes = getClusterInfo();
			jc = new JedisCluster(jedisClusterNodes);
		} catch (Exception e) {
			logger.info(e);
		}
		return jc;
	}

	/**
	 * 关闭数据库连�?
	 * 
	 * @param jedis
	 */
	private void closeConnection(JedisCluster jc) {
		if (null != jc) {
			try {
				jc.close();
			} catch (Exception e) {
				logger.info(e);
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
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
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
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
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
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
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
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
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
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
			//jedis.select(dbIndex);
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
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
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
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
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
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
			//jedis.select(dbIndex);
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
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
			//jedis.select(dbIndex);
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
		String value = null;
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
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
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
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
	 * 按模式获取keys
	 */
	private Set<String> keysForCluster(String keyPattern){
		Set<String> set = new TreeSet<String>();  
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
			Map<String, JedisPool> clusterNodes = jedis.getClusterNodes();
			for(String k : clusterNodes.keySet()){
				JedisPool jp = clusterNodes.get(k);  
	            Jedis connection = jp.getResource();
	            try {
	            	set.addAll( connection.keys(keyPattern));
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					connection.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		return set;
	}
	
	/**
	 * 根据模式批量查询keys
	 * 
	 * @param keyPattern (示例: abc_*)
	 * @return
	 */
	public Set<String> keys(String keyPattern){
		Set<String> set = this.keysForCluster(keyPattern);
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
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
			set = this.keysForCluster(keyPattern);
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
	 * 获取集合大小
	 * 
	 * @param key
	 * @return 如果为null代表获取时出�?
	 */
	public Long llen(String key) {
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
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
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
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
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
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
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
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
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
			//jedis.select(dbIndex);
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
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
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
		boolean exists=false;
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
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
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
			jedis.hset(key, field, value);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
	}
	
	
	public String getHashValue(String key, String field){
		String value = null;
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
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
		Map<String,String> dataMap= null;
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
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
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
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
		boolean exists=false;
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
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
		Set<String> set = null;
		JedisCluster jedis = null;
		try {
			jedis = this.getConnection();
			set=jedis.hkeys(key);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}finally{
			closeConnection(jedis);
		}
		if(set==null){ //�?化外部调�?
			set= new HashSet<String>();
		}
		return set;
	}	
}
