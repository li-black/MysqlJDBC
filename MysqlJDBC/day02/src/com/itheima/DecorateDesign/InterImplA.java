package com.itheima.DecorateDesign;

//实现接口的类
public class InterImplA implements Inter {
    @Override
    public void init() {
        System.out.println("初始化");
    }

    @Override
    public void close() {
        System.out.println("关闭连接");
    }
}
