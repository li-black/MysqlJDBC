package com.itheima.test;
//测试MyBatis查询全表

import com.itheima.bean.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class StudentTest01 {
    public static void main(String[] args) throws Exception {
//        读取配置文件
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
//        传入配置文件IO流创建出SqlSessionFactory工厂类
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//        从工厂类中创建SqlSession事务默认开启如果进行修改操作要在动作后面添加sqlSession.commit(),如果想关闭传入参数true即可
        SqlSession sqlSession = factory.openSession();
//        用SqlSession执行配置文件中的sql语句返回集合,方法自动将数据转换成Student对象集合返回
        List<Student> list = sqlSession.selectList("StudentMapper.selectAll");
//        遍历集合打印student
        for (Student student : list) {
            System.out.println(student);
        }
//        函数式编程遍历
//        list.forEach(System.out::println);
//        释放资源
        sqlSession.close();
        is.close();
    }
}
