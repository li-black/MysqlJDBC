package com.itheima.controller;

import com.itheima.bean.Student;
import com.itheima.service.StudentService;
import com.itheima.service.impl.StudentServiceImpl;
import org.junit.Test;

import java.util.List;

/*
    控制层测试类
 */
public class StudentController {
    //创建业务层对象
    private StudentService service = new StudentServiceImpl();

    //查询全部功能测试
    @Test
    public void selectAll() {
        List<Student> students = service.selectAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    //新增功能测试
    @Test
    public void insert() {
        Student student = new Student(5, "周七", 27);
        Integer result = service.insert(student);
        System.out.println(result);
    }

    //修改功能测试
    @Test
    public void update() {
        Student student = new Student(5, "周七", 37);
        Integer result = service.update(student);
        System.out.println(result);
    }

    //删除功能测试
    @Test
    public void delete() {
        Integer result = service.delete(5);
        System.out.println(result);
    }
}
