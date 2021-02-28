package com.itheima.mapper.one_to_one;

import com.itheima.bean.Person;
import org.apache.ibatis.annotations.Select;

public interface PersonMapper {
    //    根据传入的id查询
    @Select("SELECT * FROM person WHERE id = #{id}")
    Person selectById(Integer id);
}
