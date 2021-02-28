package com.itheima.service.impl;
//服务层实现类

import com.itheima.bean.Student;
import com.itheima.mapper.StudentMapper;
import com.itheima.service.StudentService;
import com.itheima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    //查询全部
    @Override
    public List<Student> selectAll() {
        List<Student> studentList = null;
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            studentList = mapper.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    //新增功能
    @Override
    public Integer insert(Student student) {
        Integer result = null;
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            result = mapper.insert(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //修改操作
    @Override
    public Integer update(Student student) {
        Integer result = null;
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            result = mapper.update(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //删除操作
    @Override
    public Integer delete(Integer sid) {
        Integer result = null;
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            result = mapper.delete(sid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
