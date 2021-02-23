package com.itheima02;
//程序入口

import com.itheima02.controller.StudentController;

public class Start {
    public static void main(String[] args) {
//        创建StudentController对象
        StudentController controller = new StudentController();
//        调用方法
        controller.findAll();
        System.out.println("-----------------------------");
        controller.findById();
        System.out.println("-----------------------------");
        controller.insert();
        System.out.println("-----------------------------");
        controller.update();
        System.out.println("-----------------------------");
        controller.delete();
    }
}
