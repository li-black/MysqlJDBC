package com.itheima.mapper;

import com.itheima.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.Date;

/*
    Dao层接口
 */
public interface StudentDao {
    //查询所有学生信息
//    @Select("SELECT * FROM student")
    ArrayList<Student> findAll();

    //条件查询，根据id获取学生信息
//    @Select("SELECT * FROM student WHERE sid=#{sid}")
    Student findById(Integer id);

    //新增学生信息
//    @Insert("INSERT INTO student (NAME,age,birthday) VALUE (#{name},#{age},#{birthday})")
    int insert(Student stu);

    //修改学生信息
//    @Update("UPDATE student SET NAME=#{name},age=#{age},birthday=#{birthday} WHERE sid=#{sid}")
    int update(Student stu);

    //删除学生信息
//    @Delete("DELETE FROM student WHERE sid=#{sid}")
    int delete(Integer id);
}
