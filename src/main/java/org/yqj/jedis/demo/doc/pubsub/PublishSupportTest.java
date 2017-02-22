package org.yqj.jedis.demo.doc.pubsub;

import org.yqj.jedis.demo.doc.utils.JedisPoolTools;
import redis.clients.jedis.Jedis;

/**
 * Created by yaoqijun.
 * Date:2016-12-05
 * Email:yaoqijunmail@gmail.io
 * Descirbe:
 */
public class PublishSupportTest {
    public static void main(String[] args) {
        Jedis jedis = JedisPoolTools.getJedisConnection();

        jedis.publish("foo", "messageContent");

        JedisPoolTools.close();
    }
}
