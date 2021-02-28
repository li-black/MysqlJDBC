package com.itheima.service;
//服务层接口

import com.itheima.bean.Student;

import java.util.List;

public interface StudentService {
    //查询全部
    List<Student> selectAll();

    //新增功能
    Integer insert(Student student);

    //新增功能能够自动返回添加之后的主键并且加入到Student类中
    Integer insertKey(Student student);

    //修改操作
    Integer update(Student student);

    //删除操作
    Integer delete(Integer sid);
}
