package com.itheima.itheima05;
//c3p0连接池close测试是释放资源还是归还到池中

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class Testc3p002 {
    public static void main(String[] args) throws Exception {
        DataSource dataSource = new ComboPooledDataSource();
        for (int i = 1; i <= 11; i++) {
            Connection connection = dataSource.getConnection();
            System.out.println(i + ":" + connection);
//            释放i=5的资源如果结果中有重复地址则证明close方法为归还池中
            if (i == 5) {
                connection.close();
            }
        }
    }
}
