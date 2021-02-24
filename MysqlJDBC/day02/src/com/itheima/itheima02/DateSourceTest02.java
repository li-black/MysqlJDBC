package com.itheima.itheima02;
//测试数据库连接池

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DateSourceTest02 {
    public static void main(String[] args) throws SQLException {
//        创建连接池对象
        MyDateSource dateSource = new MyDateSource();
        System.out.println("使用前连接对象: " + dateSource.getSize());
//        获取连接对象并查询
        Connection connection = dateSource.getConnection();
        System.out.println(connection.getClass());
        String sql = "SELECT * FROM student";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("sid") + "\t" + resultSet.getString("NAME"));
        }
//        释放资源这里采用装饰设计模式所以能够归还到连接池中
        resultSet.close();
        preparedStatement.close();
        connection.close();
        System.out.println("使用后连接对象: " + dateSource.getSize());
    }
}
