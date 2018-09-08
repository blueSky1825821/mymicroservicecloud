package controller;

import com.atguigu.springcloud.cfgbeans.entities.Dept;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wm on 2018/9/6.
 */
@RestController
public class DeptController {
    @RequestMapping(value = "/dept/", method = RequestMethod.POST)
    public Dept add(@RequestParam(value = "dept") Dept dept) {
        return dept;
    }
}
