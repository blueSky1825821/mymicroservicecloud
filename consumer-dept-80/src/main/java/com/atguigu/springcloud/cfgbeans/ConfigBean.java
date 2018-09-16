package com.atguigu.springcloud.cfgbeans;

import com.netflix.loadbalancer.*;
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

    /**
     * 轮询：RoundRobinRule
     * 随机：RandomRule
     * 过滤：AvailabilityFilteringRule
     * 响应时间来分配权重：WeightedResponseTimeRule
     * 重试：RetryRule
     * 选择最好的：BestAvailableRule
     * 复合：ZoneAvoidanceRule
     *
     * @return
     */
    @Bean
    public IRule myRule() {
//        return new RoundRobinRule();
        return new RetryRule();    //重新选择的随机算法代替默认的轮询
    }
}
