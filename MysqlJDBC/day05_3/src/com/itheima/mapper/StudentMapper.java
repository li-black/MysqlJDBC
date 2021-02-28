package com.itheima.mapper;

import com.itheima.bean.Student;
import com.itheima.sql.ReturnSql;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

public interface StudentMapper {
    //传入sql语句的class文件
    //查询全部
    //@Select("SELECT * FROM Student")
    @SelectProvider(type = ReturnSql.class, method = "getSelectAll")
    List<Student> selectAll();

    //新增功能
    //@Insert("INSERT INTO Student VALUES (#{sid},#{NAME},#{age})")
    @InsertProvider(type = ReturnSql.class, method = "getInsert")
    Integer insert(Student student);

    //修改功能
    //@Update("UPDATE student SET NAME=#{NAME},age=#{age} WHERE sid=#{sid}")
    @UpdateProvider(type = ReturnSql.class, method = "getUpdate")
    Integer update(Student student);

    //删除功能
    //@Delete("DELETE FROM student WHERE sid=#{sid}")
    @DeleteProvider(type = ReturnSql.class, method = "getDelete")
    Integer delete(Integer sid);
}
