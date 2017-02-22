package org.yqj.jedis.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

/**
 * Created by yaoqijun.
 * Date:2016-11-30
 * Email:yaoqijunmail@gmail.io
 * Descirbe:
 */
//@Configuration
public class MyConfiguration {

//    @Bean
    public RedisConnectionFactory redisConnectionFactory(){

        RedisSentinelConfiguration configuration = new RedisSentinelConfiguration().master("mymaster")
                .sentinel("127.0.0.1", 6379);

        return new LettuceConnectionFactory(configuration);
    }

}
