package org.yqj.jedis.demo.doc.utils;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yaoqijun.
 * Date:2016-12-05
 * Email:yaoqijunmail@gmail.io
 * Descirbe:
 */
public class JedisConnection {

    public static Jedis connSingleJedis(String host){
        return new Jedis(host);
    }

    public static JedisCluster clusterJedis(String host, Integer port){
        Set<HostAndPort> jedisHostAndPort = new HashSet<HostAndPort>();
        jedisHostAndPort.add(new HostAndPort(host, port));
        JedisCluster jedisCluster = new JedisCluster(jedisHostAndPort);
        return jedisCluster;
    }
}
