package com.itheima.mapper.one_to_many;

import com.itheima.bean.Classes;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface ClassesMapper {
    //查询全部
    @Select("SELECT * FROM classes")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "NAME", property = "NAME"),
            @Result(
                    property = "students",  // 被包含对象的变量名
                    javaType = List.class,  // 被包含对象的实际数据类型
                    column = "id",          // 根据查询出的classes表的id字段来查询student表
                    /*
                        many、@Many 一对多查询的固定写法
                        select属性：指定调用哪个接口中的哪个查询方法
                     */
//                    fetchType参数传递为LAZY时启动懒加载模式，通过debugger显示不出来，能够通日志的打印信息看到懒加载的过程
                    many = @Many(select = "com.itheima.mapper.one_to_many.StudentMapper.selectByCid", fetchType = FetchType.LAZY)
            )
    })
    List<Classes> selectAll();
}
