package org.yqj.jedis.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * Created by yaoqijun on 2016/12/6.
 */
@Configuration
public class MyConfiguration {

    /**
     * build jedis connection factory
     * @return
     */
    @Bean
    public RedisConnectionFactory jedisConnectionFactory(){
        RedisSentinelConfiguration sentinelConfiguration = new RedisSentinelConfiguration().sentinel("localhost", 6379);
        return new JedisConnectionFactory(sentinelConfiguration);
    }

}
