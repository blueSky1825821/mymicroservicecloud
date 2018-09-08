package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.cfgbeans.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by wm on 2018/9/8.
 */
@Mapper
public interface DeptDao {
    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
