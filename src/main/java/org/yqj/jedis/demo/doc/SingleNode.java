package org.yqj.jedis.demo.doc;

import org.yqj.jedis.demo.doc.utils.JedisConnection;
import redis.clients.jedis.Jedis;

/**
 * Created by yaoqijun.
 * Date:2016-11-28
 * Email:yaoqijunmail@gmail.io
 * Descirbe:
 */
public class SingleNode {

    public static void main(String[] args) {
        System.out.println(" single node test ");

        Jedis jedis = JedisConnection.connSingleJedis("localhost");

        String value = jedis.get("foo");

        System.out.println(value);
    }

}
