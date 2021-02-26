package com.itheima.test;
//测试MyBatis根据id删除数据

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class StudentTest05 {
    public static void main(String[] args) {
        try (
//        在try中添加资源与流的创建
//        创建的数据流和占用的资源会在try执行完毕后自动被关闭，前提是，这些可关闭的资源必须实现java.lang.AutoCloseable接口
//        读取配置文件
                InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
//        传入配置文件IO流创建出SqlSessionFactory工厂类
//        从工厂类中创建SqlSession事务默认开启如果进行修改操作要在动作后面添加sqlSession.commit(),如果想关闭传入参数true即可
                SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession()) {
//            传入id调用删除方法接受接果值并打印，结果值为受影响的行数
            int update = sqlSession.update("StudentMapper.delete", 5);
//            由于在openSession()没有设置参数事务默认开启所以要调用commit()方法,如果传入参数true则为开启自动提交这里就可以不调用commit()方法
            sqlSession.commit();
//            打印返回值受影响的行数
            System.out.println(update);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
