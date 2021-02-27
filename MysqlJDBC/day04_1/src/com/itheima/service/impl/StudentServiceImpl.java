package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.bean.Student;
import com.itheima.mapper.StudentMapper;
import com.itheima.service.StudentService;
import com.itheima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/*
    业务层实现类
 */
public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> selectAll() {
        List<Student> list = null;
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            list = mapper.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Student selectById(Integer id) {
        Student student = null;
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            student = mapper.selectById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public Integer insert(Student stu) {
        Integer result = null;
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            result = mapper.insert(stu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer update(Student stu) {
        Integer result = null;
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            result = mapper.update(stu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer delete(Integer id) {
        Integer result = null;
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            result = mapper.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Student> selectByNameOrAge(String name, Integer age) {
        List<Student> list = null;
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            list = mapper.selectByNameOrAge(name, age);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Student selectCondition(Student stu) {
        Student student = null;
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            student = mapper.selectCondition(stu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> selectByIds(List list) {
        List<Student> studentList = null;
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            studentList = mapper.selectByIds(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public List<Student> selectPaging(Integer page) {
        List<Student> studentList = null;
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            PageHelper.startPage(page, 3);
            studentList = mapper.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public PageInfo<Student> selectPageInfo() {
        PageInfo<Student> pageInfo = null;
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            PageHelper.startPage(1, 3);
            final List<Student> studentList = mapper.selectAll();
            pageInfo = new PageInfo<>(studentList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
}