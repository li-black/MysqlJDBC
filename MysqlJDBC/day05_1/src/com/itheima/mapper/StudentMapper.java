package com.itheima.mapper;
//持久层实现类

import com.itheima.bean.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {
    //查询全部
    @Select("SELECT * FROM Student")
    List<Student> selectAll();

    //新增功能
    @Insert("INSERT INTO Student (NAME,age) VALUE (#{name},#{age})")
    Integer insert(Student student);

    //新增功能能够自动返回添加之后的主键并且加入到Student类中
    @Options(useGeneratedKeys = true, keyColumn = "sid", keyProperty = "sid")
    @Insert("INSERT INTO Student (NAME,age) VALUE (#{name},#{age})")
    Integer insertKey(Student student);

    //修改操作
    @Update("UPDATE Student SET NAME=#{name},age=#{age} WHERE sid=#{sid}")
    Integer update(Student student);

    //删除操作
    @Delete("DELETE FROM Student WHERE sid=#{sid}")
    Integer delete(Integer sid);
}
