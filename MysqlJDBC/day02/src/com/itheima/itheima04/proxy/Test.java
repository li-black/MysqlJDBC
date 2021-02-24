package com.itheima.itheima04.proxy;
//动态代理测试类
//如果是方法重载有多个相同名的方法，应该是根据参数的不同来选择相同方法名的不同方法

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
//        创建student类对象
        Student student = new Student();
//        动态代理参数一必须是被代理对象的加载器，参数二为被代理对象实现的接口的字节码，参数三是代理规则
        StudentInterface studentInterface = (StudentInterface) Proxy.newProxyInstance(student.getClass().getClassLoader(), new Class[]{StudentInterface.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                判断方法如果是查找的方法执行代理的代码
                if (method.getName().equalsIgnoreCase("study")) {
                    System.out.println("敲代码");
                    return null;
                } else {
//                    如果不是就执行原来的代码
                    return method.invoke(student, args);
                }
            }
        });
//        调用方法
        studentInterface.eat();
        studentInterface.study();
    }
}
