package org.yqj.jedis.demo.springdata;

import com.google.common.base.Charsets;
import com.sun.tools.javac.util.ArrayUtils;
import org.apache.commons.codec.binary.Hex;
import redis.clients.jedis.Jedis;

import java.util.Arrays;

/**
 * Created by yaoqijun on 2016/12/6.
 */
public class SingleTest {
    public static void main(String[] args) throws Exception {
//        simple();
        testHexCompress();
    }

    /**
     * 通过 byte 字节流方式， 获取对应的数组方式
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
        while (splitpos < secondFollowValue.length){
            if (Byte.valueOf("1").equals(secondFollowValue[splitpos])){
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
