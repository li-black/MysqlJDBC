package com.itheima.mapper.many_to_many;

import com.itheima.bean.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface StudentMapper {
    //查询参与选课的学生
    @Select("SELECT DISTINCT s.id,s.name,s.age FROM stu_cr sc,student s WHERE sc.sid = s.id")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "NAME", property = "NAME"),
            @Result(column = "age", property = "age"),
            @Result(
                    // 被包含对象的变量名
                    property = "courses",
                    // 被包含对象的实际数据类型
                    javaType = List.class,
                    // 根据查询出student表的id来作为关联条件，去查询中间表和课程表
                    column = "id",
                    /*
                       many、@Many 一对多查询的固定写法
                       select属性：指定调用哪个接口中的哪个查询方法
                    */
//                    fetchType参数传递为LAZY时启动懒加载模式，通过debugger显示不出来，能够通日志的打印信息看到懒加载的过程
                    many = @Many(select = "com.itheima.mapper.many_to_many.CourseMapper.selectBySid", fetchType = FetchType.LAZY))
    })
    List<Student> selectAll();
}
