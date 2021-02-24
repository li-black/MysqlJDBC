package com.itheima.itheima06;
//Druid连接池的基本使用

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DruidTest01 {
    public static void main(String[] args) throws Exception {
//        读取配置文件
        InputStream is = DruidTest01.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        properties.load(is);
//        通过DruidDataSourceFactory工厂类来创建数据库连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
//        获取连接执行sql语句并打印
        Connection connection = dataSource.getConnection();
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
