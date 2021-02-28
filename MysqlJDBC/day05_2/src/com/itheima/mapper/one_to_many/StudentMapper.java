package com.itheima.mapper.one_to_many;

import com.itheima.bean.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    //根据cid查询student表
    @Select("SELECT * FROM student WHERE cid=#{cid}")
    List<Student> selectByCid(Integer cid);
}
