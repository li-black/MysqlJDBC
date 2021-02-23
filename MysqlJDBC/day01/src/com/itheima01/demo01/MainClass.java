package com.itheima01.demo01;
//最简单的JDBC连接数据库案例

import java.sql.*;

public class MainClass {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        1.导入jar包
//        2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
//        3.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.200.129/db9", "root", "123456");
//        4.获取执行者对象
        Statement stmt = connection.createStatement();
//        5.执行sql语句，并且接收返回的结果集
        String sql = "select * from account";
        ResultSet rs = stmt.executeQuery(sql);
//        6.遍历结果集并打印
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" + rs.getString("NAME"));
        }
//        7.释放资源
        rs.close();
        stmt.close();
        connection.close();
    }
}
