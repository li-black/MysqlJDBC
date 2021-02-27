package com.itheima.mapper;
//一对多查询持久层接口

import com.itheima.bean.Classes;

import java.util.List;

public interface OneToManyMapper {
    List<Classes> selectAll();
}
