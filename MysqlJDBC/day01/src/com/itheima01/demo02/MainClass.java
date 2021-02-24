package com.itheima01.demo02;
//最简单的数据库事务操作

import java.sql.*;

public class MainClass {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.200.129/db9", "root", "123456");
//            开启事务
            connection.setAutoCommit(false);
            String sql1 = "UPDATE account SET money = money -? WHERE id =?";
            String sql2 = "UPDATE account SET money = money +? WHERE id =?";
            preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement2 = connection.prepareStatement(sql2);
//            设置参数
            preparedStatement1.setDouble(1, 500);
            preparedStatement1.setInt(2, 1);
            preparedStatement2.setDouble(1, 500);
            preparedStatement2.setInt(2, 2);
//            执行sql语句
            preparedStatement1.executeUpdate();
//            手动创建异常以便造成事务的回滚
//            int i = 3 / 0;
            preparedStatement2.executeUpdate();
//            提交事务
            connection.commit();
        } catch (Exception e) {
            if (connection != null) {
                try {
//                    如果有异常就回滚事务
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
//            释放资源
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement1 != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement2 != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
