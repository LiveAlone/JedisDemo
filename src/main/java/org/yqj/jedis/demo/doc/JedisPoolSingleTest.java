package org.yqj.jedis.demo.doc;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.yqj.jedis.demo.doc.utils.JedisPoolTools;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by yaoqijun.
 * Date:2016-12-05
 * Email:yaoqijunmail@gmail.io
 * Descirbe:
 */
public class JedisPoolSingleTest {
    public static void main(String[] args) {
        Jedis jedis = JedisPoolTools.getJedisConnection();
        jedis.set("foo", "car");
        String fooValue = jedis.get("foo");
        System.out.println("foo value is " + fooValue);

        // set execute
        jedis.zadd("sose", 0, "car");
        jedis.zadd("sose", 0, "bike");
        Set<String> sose = jedis.zrange("sose", 0, -1);
        System.out.println("sose collection is : " + sose);

        // close
        JedisPoolTools.close();
    }
}
