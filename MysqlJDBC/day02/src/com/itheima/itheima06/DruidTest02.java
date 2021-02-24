package com.itheima.itheima06;
//对自定义数据库连接池工具类的使用

import com.itheima.utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DruidTest02 {
    public static void main(String[] args) throws Exception {
//        从数据库连接工具类中获取连接执行sql语句并打印
        Connection connection = DataSourceUtils.getConnection();
        String sql = "SELECT * FROM student";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("sid") + "\t" + resultSet.getString("NAME"));
        }
//        用数据库连接工具类的close方法释放资源
        DataSourceUtils.close(connection, preparedStatement, resultSet);
    }
}
