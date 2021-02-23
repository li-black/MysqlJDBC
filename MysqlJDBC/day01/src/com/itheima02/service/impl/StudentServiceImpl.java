package com.itheima02.service.impl;
//service类

import com.itheima02.dao.StudentDao;
import com.itheima02.dao.impl.StudentDaoImpl;
import com.itheima02.domain.Student;
import com.itheima02.service.StudentService;

import java.util.ArrayList;

public class StudentServiceImpl implements StudentService {
    //    创建StudentDaoImpl对象
    private StudentDao dao = new StudentDaoImpl();

    //    调用方法
    @Override
    public ArrayList<Student> findAll() {
        return dao.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public int insert(Student stu) {
        return dao.insert(stu);
    }

    @Override
    public int update(Student stu) {
        return dao.update(stu);
    }

    @Override
    public int delete(Integer id) {
        return dao.delete(id);
    }
}
