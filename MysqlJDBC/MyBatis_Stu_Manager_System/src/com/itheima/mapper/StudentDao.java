package com.itheima.mapper;

import com.itheima.domain.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.ArrayList;

/*
    Dao层接口
 */
public interface StudentDao {
    //查询所有学生信息
    @Select("SELECT * FROM student")
//    引用Map映射集
    @ResultMap(value = "Student")
    ArrayList<Student> findAll();

    //条件查询，根据id获取学生信息
    @Select("SELECT * FROM student WHERE sid=#{sid}")
//    映射集
    @Results(id = "Student", value = {
            @Result(column = "sid", property = "sid"),
            @Result(column = "NAME", property = "name"),
            @Result(column = "age", property = "age"),
//            javaType需要传入class文件
            @Result(property = "birthday", column = "birthday", javaType = java.sql.Date.class, jdbcType = JdbcType.DATE)
    })
    Student findById(@Param("sid") Integer id);

    //新增学生信息
    @Insert("INSERT INTO student (NAME,age,birthday) VALUE (#{name},#{age},#{birthday})")
    int insert(Student stu);

    //修改学生信息
    @Update("UPDATE student SET NAME=#{name},age=#{age},birthday=#{birthday} WHERE sid=#{sid}")
    int update(Student stu);

    //删除学生信息
    @Delete("DELETE FROM student WHERE sid=#{sid}")
    int delete(Integer id);
}
