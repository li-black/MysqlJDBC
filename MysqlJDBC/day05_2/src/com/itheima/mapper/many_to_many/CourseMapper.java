package com.itheima.mapper.many_to_many;

import com.itheima.bean.Course;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseMapper {
    //根据学生id查询所选课程
    @Select("SELECT c.id,c.`NAME` FROM stu_cr sc,course c WHERE sc.cid=c.id AND sc.sid=#{sid}")
    List<Course> selectBySid(Integer sid);
}
