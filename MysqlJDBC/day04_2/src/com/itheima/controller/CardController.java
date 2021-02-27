package com.itheima.controller;
//测试一对一查询

import com.itheima.bean.Card;
import com.itheima.service.OneToOneService;
import com.itheima.service.impl.OneToOneServiceImpl;
import org.junit.Test;

import java.util.List;

public class CardController {
    //创建业务层对象
    private OneToOneService service = new OneToOneServiceImpl();

    @Test
    public void selectAll() {
        final List<Card> cardList = service.selectAll();
//        与下面的语句作用一致cardList.forEach(card -> System.out.println(card));
        cardList.forEach(System.out::println);
    }
}
