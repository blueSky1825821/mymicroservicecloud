package com.atguigu.springcloud;

import com.atguigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Created by wm on 2018/9/7.
 */
@SpringBootApplication
@EnableEurekaClient
//自定义负载均衡规则
@RibbonClient(name = "MICROSERVICECLOUD-DEPT", configuration = MySelfRule.class)
public class DeptConsumer80_APP {
    public static void main(String[] args) {
        System.out.println("microservicecloud-dept".toUpperCase());
        SpringApplication.run(DeptConsumer80_APP.class, args);
    }
}
