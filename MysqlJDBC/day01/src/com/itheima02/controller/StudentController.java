package com.itheima02.controller;
//controller类

import com.itheima02.domain.Student;
import com.itheima02.service.StudentService;
import com.itheima02.service.impl.StudentServiceImpl;

import java.util.ArrayList;
import java.util.Date;

public class StudentController {
    private StudentService service = new StudentServiceImpl();

    //    定义方法调用StudentServiceImpl的findAll()方法
    public void findAll() {
        ArrayList<Student> list = service.findAll();
        for (Student stu : list) {
            System.out.println(stu);
        }
    }

    //    定义方法调用StudentServiceImpl的findById()方法
    public void findById() {
        Student stu = service.findById(3);
        System.out.println(stu);
    }

    //    定义方法调用StudentServiceImpl的insert()方法
    public void insert() {
        Student stu = new Student(5, "周七", 27, new Date());
        int result = service.insert(stu);
        if (result != 0) {
            System.out.println("新增成功");
        } else {
            System.out.println("新增失败");
        }
    }

    //    定义方法调用StudentServiceImpl的update()方法
    public void update() {
        Student stu = service.findById(5);
        if (stu != null) {
            stu.setName("周七七");
            int result = service.update(stu);
            if (result != 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
        } else {
            System.out.println("修改失败,查无此学生");
        }
    }
    //    定义方法调用StudentServiceImpl的delete()方法
    public void delete() {
        int result = service.delete(5);
        if (result != 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }
}
