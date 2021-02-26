package com.itheima.service;

import com.itheima.bean.Student;

import java.util.List;
/*
    业务层接口
 */
public interface StudentService {
    //查询全部
    List<Student> selectAll();

    //根据id查询
    Student selectById(Integer id);

    //新增数据
    Integer insert(Student stu);

    //修改数据
    Integer update(Student stu);

    //删除数据
    Integer delete(Integer id);
}
