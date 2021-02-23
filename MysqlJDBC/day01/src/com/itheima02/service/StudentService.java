package com.itheima02.service;
//Service接口

import com.itheima02.domain.Student;

import java.util.ArrayList;

public interface StudentService {
    //查询所有学生信息
    ArrayList<Student> findAll();

    //根据id获取学生信息
    Student findById(Integer id);

    //增加学生信息
    int insert(Student stu);

    //修改学生信息
    int update(Student stu);

    //删除学生
    int delete(Integer id);
}
