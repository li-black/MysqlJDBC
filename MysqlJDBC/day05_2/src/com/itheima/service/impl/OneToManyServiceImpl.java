package com.itheima.service.impl;
//一对多查询实现类

import com.itheima.bean.Classes;
import com.itheima.mapper.one_to_many.ClassesMapper;
import com.itheima.service.OneToManyService;
import com.itheima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class OneToManyServiceImpl implements OneToManyService {
    @Override
    public List<Classes> selectAll() {
        List<Classes> classesList = null;
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final ClassesMapper mapper = sqlSession.getMapper(ClassesMapper.class);
            classesList = mapper.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classesList;
    }
}
