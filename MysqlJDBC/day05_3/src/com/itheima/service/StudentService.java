package com.itheima.service;

import com.itheima.bean.Student;

import java.util.List;

public interface StudentService {
    //查询全部
    List<Student> selectAll();

    //新增功能
    Integer insert(Student student);

    //修改操作
    Integer update(Student student);

    //删除操作
    Integer delete(Integer sid);
}
