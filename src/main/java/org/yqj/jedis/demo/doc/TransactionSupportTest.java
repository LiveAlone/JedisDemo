package org.yqj.jedis.demo.doc;

import org.yqj.jedis.demo.doc.utils.JedisPoolTools;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.Set;

/**
 * Created by yaoqijun.
 * Date:2016-12-05
 * Email:yaoqijunmail@gmail.io
 * Descirbe:
 */
public class TransactionSupportTest {
    public static void main(String[] args) {
        System.out.println("test jedis transaction test");

        Jedis jedis = JedisPoolTools.getJedisConnection();
        Transaction t = jedis.multi();

        t.set("foo", "bar");
        Response<String> stringResponse = t.get("foo");

//        System.out.println("test no exec result is : "+stringResponse.get());  // exception not execute

        t.zadd("fooSet", 1, "barowitch");
        t.zadd("fooSet", 0, "barinsky");
        t.zadd("fooSet", 0, "barikoviev");
        Response<Set<String>> setResponse = t.zrange("fooSet", 0, -1);

        // to execute
//        t.exec();
//        System.out.println("String response is : " + stringResponse.get());
//        System.out.println("set response is : "+setResponse.get());

        List<Object> testTransactionExecute = t.exec();
        System.out.println(testTransactionExecute);

        JedisPoolTools.close();
    }
}
