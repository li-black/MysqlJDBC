package com.itheima.mapper;

import com.itheima.bean.Student;

import java.util.List;
/*
    持久层接口
 */
public interface StudentMapper {
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
