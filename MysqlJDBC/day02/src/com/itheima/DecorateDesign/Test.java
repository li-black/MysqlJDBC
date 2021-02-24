package com.itheima.DecorateDesign;

//测试装饰设计模式的结果
public class Test {
    public static void main(String[] args) {
        InterImplA implA = new InterImplA();
        implA.init();
        implA.close();
        System.out.println("------------------------");
        InterImplB implB = new InterImplB(implA);
        implB.init();
        implB.close();
    }
}
