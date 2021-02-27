package com.itheima.mapper;
//一对一查询持久层接口

import com.itheima.bean.Card;

import java.util.List;

public interface OneToOneMapper {
    List<Card> selectAll();
}
