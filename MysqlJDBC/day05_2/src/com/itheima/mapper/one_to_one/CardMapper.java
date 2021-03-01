package com.itheima.mapper.one_to_one;

import com.itheima.bean.Card;
import com.itheima.bean.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface CardMapper {
    //  一对一查询
//    Card中有Person类所以在查询的时候最后要调用PersonMapper中的根据id查询传入card表中查询出来的pid，
//    之后封装到Person类中赋给Card类中的p
//    查询card表
    @Select("SELECT * FROM card")
    @Results(value = {
//            给id赋值
            @Result(property = "id", column = "id"),
//            给number赋值
            @Result(property = "number", column = "number"),
//            给p赋值
            @Result(
                    // 被包含对象的变量名
//                    指定Card中的名称p
                    property = "p",
                    // 被包含对象的实际数据类型
//                    指定class
                    javaType = Person.class,
                    // 根据查询出的card表中的pid字段来查询person表
//                    根据查询出来的pid
                    column = "pid",
//                    去PersonMapper中调用根据id查询传入pid查询出Person
//                    fetchType参数传递为LAZY时启动懒加载模式，通过debugger显示不出来，能够通日志的打印信息看到懒加载的过程
//                    一般一对一查询不开启懒加载这里为了演示开启
                    one = @One(select = "com.itheima.mapper.one_to_one.PersonMapper.selectById", fetchType = FetchType.LAZY))
    })
    List<Card> seleceAll();
}
