package com.itheima.DecorateDesign;

//装饰设计模式重写了close
public class InterImplB implements Inter {
    private Inter inter;

    public InterImplB(Inter inter) {
        this.inter = inter;
    }

    @Override
    public void init() {
        inter.init();
    }

    @Override
    public void close() {
        System.out.println("归还连接");
    }
}
