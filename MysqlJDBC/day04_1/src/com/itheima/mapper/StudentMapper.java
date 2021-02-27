package com.itheima.mapper;

import com.itheima.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
    持久层接口
 */
public interface StudentMapper {
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
    List<Student> selectByNameOrAge(@Param("name") String name, @Param("age") Integer age);

    //根据传入参数的不同动态查询
    Student selectCondition(Student stu);

    //根据传入的sid数组来查询
    List<Student> selectByIds(List list);
}
