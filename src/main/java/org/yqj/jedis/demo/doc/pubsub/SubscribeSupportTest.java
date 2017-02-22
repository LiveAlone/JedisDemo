package org.yqj.jedis.demo.doc.pubsub;

import org.yqj.jedis.demo.doc.utils.JedisPoolTools;
import redis.clients.jedis.JedisPubSub;

/**
 * Created by yaoqijun.
 * Date:2016-12-05
 * Email:yaoqijunmail@gmail.io
 * Descirbe:
 */
public class SubscribeSupportTest {
    public static void main(String[] args) {

        MyListener myListener = new MyListener();
        JedisPoolTools.getJedisConnection().subscribe(myListener, "foo");
        JedisPoolTools.close();
    }

    public static class MyListener extends JedisPubSub{

        @Override
        public void onMessage(String channel, String message) {
            System.out.println(String.format("on message is channel :%s, message is : %s", channel, message));
        }
    }
}
