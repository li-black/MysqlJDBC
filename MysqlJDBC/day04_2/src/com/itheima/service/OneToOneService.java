package com.itheima.service;
//一对一查询接口

import com.itheima.bean.Card;

import java.util.List;

public interface OneToOneService {
    List<Card> selectAll();
}
