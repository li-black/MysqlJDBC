package com.itheima.controller;
//测试一对多查询

import com.itheima.bean.Classes;
import com.itheima.service.OneToManyService;
import com.itheima.service.impl.OneToManyServiceImpl;
import org.junit.Test;

import java.util.List;

public class ClassesController {
    //创建业务层对象
    private OneToManyService service = new OneToManyServiceImpl();

    @Test
    public void selectAll() {
        final List<Classes> classes = service.selectAll();
//        与下面的语句作用一致classes.forEach(classes1 -> System.out.println(classes1));
        classes.forEach(System.out::println);
    }
}
