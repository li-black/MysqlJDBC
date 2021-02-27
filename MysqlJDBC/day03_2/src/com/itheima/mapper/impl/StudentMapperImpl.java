package com.itheima.mapper.impl;

import com.itheima.bean.Student;
import com.itheima.mapper.StudentMapper;
import com.itheima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/*
    持久层实现类
 */
public class StudentMapperImpl implements StudentMapper {

    /*
        查询全部
     */
    @Override
    public List<Student> selectAll() {
        List<Student> list = null;
//        通过工具类直接获取session
        try (SqlSession session = MyBatisUtils.getSession()) {
//            执行映射配置文件中的sql语句，并接收结果
            list = session.selectList("StudentMapper.selectAll");
        } catch (Exception e) {
            e.printStackTrace();
        }
//        返回结果
        return list;
    }

    /*
        根据id查询
     */
    @Override
    public Student selectById(Integer sid) {
        Student stu = null;
//        通过工具类直接获取session
        try (SqlSession session = MyBatisUtils.getSession()) {
//            执行映射配置文件中的sql语句，并接收结果
            stu = session.selectOne("StudentMapper.selectById", sid);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        返回结果
        return stu;
    }

    /*
        新增功能
     */
    @Override
    public Integer insert(Student stu) {
        Integer result = null;
//        通过工具类直接获取session
        try (SqlSession session = MyBatisUtils.getSession()) {
//            执行映射配置文件中的sql语句，并接收结果
            result = session.insert("StudentMapper.insert", stu);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        返回结果
        return result;
    }

    /*
        修改功能
     */
    @Override
    public Integer update(Student stu) {
        Integer result = null;
//        通过工具类直接获取session
        try (SqlSession session = MyBatisUtils.getSession()) {
//            执行映射配置文件中的sql语句，并接收结果
            result = session.update("StudentMapper.update", stu);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        返回结果
        return result;
    }

    /*
        删除功能
     */
    @Override
    public Integer delete(Integer sid) {
        Integer result = null;
//        通过工具类直接获取session
        try (SqlSession session = MyBatisUtils.getSession()) {
//            执行映射配置文件中的sql语句，并接收结果
            result = session.delete("StudentMapper.delete", sid);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        返回结果
        return result;
    }
}
