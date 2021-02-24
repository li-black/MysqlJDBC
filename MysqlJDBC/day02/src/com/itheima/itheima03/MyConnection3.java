package com.itheima.itheima03;
//MyConnection3类
//重写了close方法解决连接池的归还问题

import java.sql.Connection;
import java.util.List;

public class MyConnection3 extends MyAdapter {
    //声明连接对象和连接池集合对象
    private Connection connection;
    private List<Connection> pool;

    //通过构造方法给本类成员变量赋值并且通过super给父类成员变量赋值
    public MyConnection3(Connection connection, List<Connection> pool) {
        super(connection);
        this.connection = connection;
        this.pool = pool;
    }

    //重写close方法将connection归还到连接池中
    @Override
    public void close() {
        pool.add(connection);
    }
}
