package com.itheima.test;
//测试MyBatis根据id查询

import com.itheima.bean.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class StudentTest02 {
    public static void main(String[] args) {
        try (
//        在try中添加资源与流的创建
//        创建的数据流和占用的资源会在try执行完毕后自动被关闭，前提是，这些可关闭的资源必须实现java.lang.AutoCloseable接口
//        读取配置文件
                InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
//        传入配置文件IO流创建出SqlSessionFactory工厂类
//        从工厂类中创建SqlSession事务默认开启如果进行修改操作要在动作后面添加sqlSession.commit(),如果想关闭传入参数true即可
                SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession()) {
//            传入id调用方法查询并打印
            Student student = sqlSession.selectOne("StudentMapper.selectById", 1);
            System.out.println(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
