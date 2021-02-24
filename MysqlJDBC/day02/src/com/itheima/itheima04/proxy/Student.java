package com.itheima.itheima04.proxy;

//学生类实现StudentInterface接口
public class Student implements StudentInterface {
    @Override
    public void eat() {
        System.out.println("吃饭");
    }

    @Override
    public void study() {
        System.out.println("学习");
    }
}
