package org.yqj.jedis.demo.doc.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by yaoqijun.
 * Date:2016-12-05
 * Email:yaoqijunmail@gmail.io
 * Descirbe:
 */
public class JedisPoolTools {

    private static final JedisPool jedisPool;

    static {
        jedisPool = new JedisPool(new JedisPoolConfig(), "localhost");
    }


    public static Jedis getJedisConnection(){
        return jedisPool.getResource();
    }

    /**
     *  close jedis connection
     */
    public static void close(){
        jedisPool.close();
        jedisPool.destroy();
    }

}
