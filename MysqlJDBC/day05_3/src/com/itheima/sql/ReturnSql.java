package com.itheima.sql;

import com.itheima.bean.Student;
import org.apache.ibatis.jdbc.SQL;

public class ReturnSql {
    //定义方法，返回查询的sql语句
    public String getSelectAll() {
        return new SQL() {
            {
                SELECT("*");
                FROM("Student");
            }
        }.toString();
    }

    //定义方法，返回新增的sql语句
    public String getInsert(Student student) {
        return new SQL() {
            {
                INSERT_INTO("Student");
                INTO_VALUES("#{sid},#{NAME},#{age}");
            }
        }.toString();
    }

    //定义方法，返回修改的sql语句
    public String getUpdate(Student student) {
        return new SQL() {
            {
                UPDATE("Student");
                if (student.getNAME() != null) {
                    SET("NAME=#{NAME}");
                }
                if (student.getAge() != null) {
                    SET("age=#{age}");
                }
                WHERE("sid=#{sid}");
            }
        }.toString();
    }

    //定义方法，返回删除的sql语句
    public String getDelete(Integer sid) {
        return new SQL() {
            {
                DELETE_FROM("Student");
                WHERE("sid=#{sid}");
            }
        }.toString();
    }
}
