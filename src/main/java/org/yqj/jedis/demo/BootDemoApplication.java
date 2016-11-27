package org.yqj.jedis.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Controller;

/**
 * Created by yaoqijun.
 * Date:2016-04-27
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
@SpringBootApplication
@Controller
public class BootDemoApplication {
    public static void main(String[] args) {
//        SpringApplication.run(BootDemoApplication.class, args);
        new SpringApplicationBuilder()
                .banner(new DemoBanner())
                .sources(BootDemoApplication.class)
                .run(args);
    }

//    @RequestMapping(value = "/index", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public String indexPage(){
//        return "this is test index paging info";
//    }
}
