package com.itheima.service.impl;
//多对多查询实现类

import com.itheima.bean.Student;
import com.itheima.mapper.many_to_many.StudentMapper;
import com.itheima.service.ManyToManyService;
import com.itheima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ManyToManyServiceImpl implements ManyToManyService {
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
}
