package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义负载均衡算法
 * Created by wm on 2018/9/15.
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
//        return new RetryRule();    //重新选择的随机算法代替默认的轮询
        return new RandomRule_ZY();
    }
}