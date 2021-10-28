package org.yqj.jedis.demo.springdata;

import org.apache.commons.codec.binary.Hex;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by yaoqijun on 2016/12/6.
 */
public class SingleTest {
    public static void main(String[] args) throws Exception {
//        simple();
//        testHexCompress();
        zsetTest();
    }

    private static void zsetTest() {
//        Jedis jedis = new Jedis("localhost", 6379);
//        IntStream.range(1, 10).forEach(index -> {
//            jedis.zadd("testSet", System.currentTimeMillis(), String.valueOf(index));
//        });
//        System.out.println(jedis.zrevrange("testSet", 0, -1));
//        System.out.println(jedis.zrem("testSet", String.valueOf(1)));
//        System.out.println(jedis.zrem("testSet", String.valueOf(100)));

//        Pipeline pip = jedis.pipelined();
//        pip.zrem("testSet", String.valueOf(5));
//        pip.zrem("testSet", String.valueOf(6));
//        pip.zrem("testSet", String.valueOf(4));
//        System.out.println(pip.syncAndReturnAll());
//        System.out.println(jedis.zrem("testSet", String.valueOf(7), String.valueOf(8), String.valueOf(9), String.valueOf(6)));
    }

    /**
     * 通过 byte 字节流方式， 获取对应的数组方式
     *
     * @throws Exception
     */
    private static void testHexCompress() throws Exception {
        String keyContent = "596634a66a6a695fa9deb37f";
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set(Hex.decodeHex(keyContent.toCharArray()), "66".getBytes());

//        byte[] bytes = jedis.get(Hex.decodeHex(keyContent.toCharArray()));
//        System.out.println(bytes.length);
//        System.out.println(new String(bytes, Charsets.UTF_8));

//        String test = "string:pre_";
//        byte[] bytes = Hex.decodeHex(keyContent.toCharArray());
//        System.out.println(bytes.length);
//        System.out.println(test.getBytes().length);
//        byte[] totalByte = new byte[23];
//        int i = 0;
//        for (byte aByte : test.getBytes()) {
//            totalByte[i++] = aByte;
//        }
//        for (byte aByte : bytes) {
//            totalByte[i++] = aByte;
//        }
////
        byte[] secondFollowValue = jedis.get("test3".getBytes());
        int splitpos = 0;
        while (splitpos < secondFollowValue.length) {
            if (Byte.valueOf("1").equals(secondFollowValue[splitpos])) {
                break;
            }
            splitpos += 1;
        }

        Integer followers = Integer.valueOf(new String(Arrays.copyOfRange(secondFollowValue, 0, splitpos)));
        String showUserId = Hex.encodeHexString(Arrays.copyOfRange(secondFollowValue, splitpos + 1, secondFollowValue.length));
        System.out.println(followers);
        System.out.println(showUserId);

    }

    private static void simple() {
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println(jedis.get("1"));
    }
}
