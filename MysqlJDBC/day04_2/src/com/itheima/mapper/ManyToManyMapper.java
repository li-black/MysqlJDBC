package com.itheima.mapper;
//多对多查询持久层接口

import com.itheima.bean.Student;

import java.util.List;

public interface ManyToManyMapper {
    List<Student> selectAll();
}
