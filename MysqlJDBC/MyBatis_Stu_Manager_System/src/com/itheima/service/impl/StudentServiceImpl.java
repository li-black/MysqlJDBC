package com.itheima.service.impl;

import com.itheima.domain.Student;
import com.itheima.mapper.StudentDao;
import com.itheima.service.StudentService;
import com.itheima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 学生的业务层实现类
 *
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> findAll() {
        List<Student> studentList = null;
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            studentList = mapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public Student findById(Integer sid) {
        Student student = null;
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            student = mapper.findById(sid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void save(Student student) {
        //保存
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            final int insert = mapper.insert(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student student) {
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            final int update = mapper.update(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer sid) {
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            final int delete = mapper.delete(sid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
