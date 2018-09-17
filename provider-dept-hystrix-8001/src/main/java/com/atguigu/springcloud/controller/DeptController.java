package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Description: lkkl
 * Created by wm on 2018/9/6.
 */
@RestController
public class DeptController {
    private final DeptService service;

    @Autowired
    public DeptController(DeptService service) {
        this.service = service;
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    //一旦调用服务方法事变并抛出错误信息后，会调用HystrixCommand 标注好的 fallbackMethod
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = this.service.get(id);
        if (null == dept) {
            throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
        }
        return dept;
    }

    /**
     * 对应的熔断消息
     *
     * @param id
     * @return
     */
    public Dept processHystrix_Get(@PathVariable("id") Long id) {
        return new Dept().setDeptno(id)
                .setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }
}
