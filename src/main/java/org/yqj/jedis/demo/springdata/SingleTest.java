package org.yqj.jedis.demo.springdata;

import redis.clients.jedis.Jedis;

/**
 * Created by yaoqijun on 2016/12/6.
 */
public class SingleTest {
    public static void main(String[] args) {
        System.out.println("jedis single test");
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("foo", "fooValue");
        String fooValue = jedis.get("foo");
        System.out.println("foo redus value is " + fooValue);
    }
}
