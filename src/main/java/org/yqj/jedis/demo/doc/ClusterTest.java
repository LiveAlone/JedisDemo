package org.yqj.jedis.demo.doc;

import org.yqj.jedis.demo.doc.utils.JedisConnection;
import redis.clients.jedis.JedisCluster;

/**
 * Created by yaoqijun.
 * Date:2016-11-28
 * Email:yaoqijunmail@gmail.io
 * Descirbe:
 */
public class ClusterTest {

    public static void main(String[] args) {
        JedisCluster jedisCluster = JedisConnection.clusterJedis("localhost", 6379);
        System.out.println(jedisCluster.get("foo"));
    }
}
