package com.wsj.myo2o.cache;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 强指定redis的JedisPool接口构造函数，这样才能在centos成功创建jedispool
 * @author WangShuaiJie
 *
 */
public class JedisPoolWriper {
	//redis连接池对象
	private JedisPool jedisPool;

	/**
	 * 
	 * @param poolConfig 配置
	 * @param host 服务器地址
	 * @param port 服务器端口
	 */
	public JedisPoolWriper(final JedisPoolConfig poolConfig, final String host,final int port) {
		try {
			jedisPool = new JedisPool(poolConfig, host, port);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

}

