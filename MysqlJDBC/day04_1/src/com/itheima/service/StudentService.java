package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.bean.Student;

import java.util.List;

/*
    业务层接口
 */
public interface StudentService {
    //查询全部
    List<Student> selectAll();

    //根据id查询
    Student selectById(Integer id);

    //新增数据
    Integer insert(Student stu);

    //修改数据
    Integer update(Student stu);

    //删除数据
    Integer delete(Integer id);

    //根据两个参数查询起别名
    List<Student> selectByNameOrAge(String name, Integer age);


    //根据传入参数的不同动态查询
    Student selectCondition(Student stu);

    //根据传入的sid数组来查询
    List<Student> selectByIds(List list);

    //根据传入的参数分页
    List<Student> selectPaging(Integer page);

    //获取分页信息
    PageInfo<Student> selectPageInfo();
}
