package com.itheima.itheima05;
//c3p0连接池基本使用

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Testc3p001 {
    public static void main(String[] args) throws Exception {
//        创建连接池
        DataSource dataSource = new ComboPooledDataSource();
//        获取连接
        Connection connection = dataSource.getConnection();
//        执行sql查询并输出结果
        String sql = "SELECT * FROM student";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("sid") + "\t" + resultSet.getString("NAME"));
        }
//        释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
