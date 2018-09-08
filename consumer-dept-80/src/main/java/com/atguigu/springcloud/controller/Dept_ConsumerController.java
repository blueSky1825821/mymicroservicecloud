package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.cfgbeans.entities.Dept;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 微服务消费者
 * Created by wm on 2018/9/7.
 */
@RestController
public class Dept_ConsumerController {
    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add")
    public Boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }
}
