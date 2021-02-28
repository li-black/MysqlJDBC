package com.itheima.service;
//一对多查询接口

import com.itheima.bean.Classes;

import java.util.List;

public interface OneToManyService {
    List<Classes> selectAll();
}
