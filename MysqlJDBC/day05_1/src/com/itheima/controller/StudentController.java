package com.itheima.controller;

import com.itheima.bean.Student;
import com.itheima.service.StudentService;
import com.itheima.service.impl.StudentServiceImpl;
import org.junit.Test;
/*
    控制层测试类
 */
import java.util.List;

public class StudentController {
    private StudentService service = new StudentServiceImpl();

    //查询全部
    @Test
    public void selectAll() {
        final List<Student> studentList = service.selectAll();
        studentList.forEach(System.out::println);
    }

    //新增功能
    @Test
    public void insert() {
        Student student = new Student(null, "周七", 27);
        final Integer result = service.insert(student);
        System.out.println(student.getSid());
        System.out.println(result);
    }

    //新增功能能够自动返回添加之后的主键并且加入到Student类中
    @Test
    public void insertKey() {
        Student student = new Student(null, "周七", 27);
        final Integer result = service.insertKey(student);
        System.out.println(student.getSid());
        System.out.println(result);
    }

    //修改操作
    @Test
    public void update() {
        Student student = new Student(5, "周七七", 27);
        final Integer result = service.update(student);
        System.out.println(result);
    }

    //删除操作
    @Test
    public void delete() {
        final Integer result = service.delete(5);
        System.out.println(result);
    }
}
