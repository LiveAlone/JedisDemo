package org.yqj.jedis.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by yaoqijun.
 * Date:2016-04-27
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
@Component
@Slf4j
public class RunCommanLine implements CommandLineRunner{

//    @Autowired
//    private RedisConnectionFactory jedisConnectionFactory;

    public void run(String... args) throws Exception {
        log.info(" command info run");
//        System.out.println(jedisConnectionFactory == null);
//        System.out.println("now command line run ");
//        System.out.println("args content is " + Lists.newArrayList(args).toString());
//        testJedis();
    }

    /**
     * 测试 jedis 本地配置使用的方式
     */
//    private void testJedis(){
//        Jedis jedis = new Jedis("localhost");
//        jedis.set("foo", "bar");
//        String value = jedis.get("foo");
//        System.out.println(value);
//    }
}
