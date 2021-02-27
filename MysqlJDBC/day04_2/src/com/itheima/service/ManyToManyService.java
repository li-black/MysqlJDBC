package com.itheima.service;
//多对多查询接口

import com.itheima.bean.Student;

import java.util.List;

public interface ManyToManyService {
    List<Student> selectAll();
}
