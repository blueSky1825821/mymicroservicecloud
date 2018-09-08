package com.atguigu.springcloud.cfgbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置 applicationContext.xml
 * Created by wm on 2018/9/7.
 */
@Configuration
public class ConfigBean {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
