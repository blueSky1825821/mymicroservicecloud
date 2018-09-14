package com.atguigu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
    @LoadBalanced   //Spring Cloud Ribbon 是基于netflix Ribbon 负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
