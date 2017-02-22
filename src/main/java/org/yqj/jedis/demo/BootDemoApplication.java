package org.yqj.jedis.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by yaoqijun.
 * Date:2016-04-27
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
//@Import(value = {
//        MyConfiguration.class
//})
public class BootDemoApplication {
    public static void main(String[] args) {
//        SpringApplication.run(BootDemoApplication.class, args);
        new SpringApplicationBuilder()
                .banner(new DemoBanner())
                .sources(BootDemoApplication.class)
                .run(args);
    }
}
