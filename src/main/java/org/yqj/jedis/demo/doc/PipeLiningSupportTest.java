package org.yqj.jedis.demo.doc;

import org.yqj.jedis.demo.doc.utils.JedisPoolTools;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.util.Set;

/**
 * Created by yaoqijun.
 * Date:2016-12-05
 * Email:yaoqijunmail@gmail.io
 * Descirbe:
 */
public class PipeLiningSupportTest {
    public static void main(String[] args) {
        System.out.println("test pipe lining support method");

        Jedis jedis = JedisPoolTools.getJedisConnection();
        Pipeline pipeline = jedis.pipelined();

        pipeline.set("fooPipe", "barPipe");
        pipeline.zadd("fooPipeSet", 1, "barowitch");
        pipeline.zadd("fooPipeSet", 0, "barinsky");
        pipeline.zadd("fooPipeSet", 0, "barikoviev");

        Response<String> stringResponse = pipeline.get("fooPipe");
        Response<Set<String>> setResponse = pipeline.zrange("fooPipeSet", 0, -1);

        pipeline.sync();

        System.out.println("pipe string response is : " + stringResponse.get());
        System.out.println("pipe set result is : " + setResponse.get());

        JedisPoolTools.close();
    }
}
