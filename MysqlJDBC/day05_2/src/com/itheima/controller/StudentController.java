package com.itheima.controller;
//测试多对多查询

import com.itheima.bean.Student;
import com.itheima.service.ManyToManyService;
import com.itheima.service.impl.ManyToManyServiceImpl;
import org.junit.Test;

import java.util.List;

public class StudentController {
    //创建业务层对象
    private ManyToManyService service = new ManyToManyServiceImpl();

    @Test
    public void selectAll() {
        final List<Student> studentList = service.selectAll();
//        与下面的语句作用一致studentList.forEach(student -> System.out.println(student));
        studentList.forEach(System.out::println);
    }
}
