package com.itheima.itheima01;
//通过继承来解决close问题但是没用,没有形成多态
//要通过装饰设计模式解决在itheima02中

import com.mysql.jdbc.JDBC4Connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class MyConnection1 extends JDBC4Connection {
    //声明连接对象和连接池集合对象
    private Connection connection;
    private List<Connection> pool;

    //通过构造方法给成员变量赋值
    public MyConnection1(String hostToConnectTo, int portToConnectTo, Properties info, String databaseToConnectTo, String url, Connection connection, List<Connection> pool) throws SQLException {
        super(hostToConnectTo, portToConnectTo, info, databaseToConnectTo, url);
        this.connection = connection;
        this.pool = pool;
    }

    //重写close()方法，将连接归还给池中
    @Override
    public void close() {
        pool.add(connection);
    }
}
