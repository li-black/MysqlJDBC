package com.itheima.utils;
//JDBC工具类

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    //    私有构造
    private JDBCUtils() {
    }

    //    声明配置信息变量
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;
    private static Connection connection;

    //    静态代码块执行加载配置文件和注册驱动
    static {
        try {
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("config.properties");
            Properties prop = new Properties();
            prop.load(is);
            driverClass = prop.getProperty("driverClass");
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            Class.forName(driverClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    获取数据库连接的方法并返回
    public static Connection getconnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //    释放资源的方法
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //    对释放资源的方法的重载考虑了没有rs参数的情况
    public static void close(Connection connection, Statement statement) {
        close(connection, statement, null);
    }
}
