package com.itheima02.dao.impl;
//Dao类

import com.itheima02.dao.StudentDao;
import com.itheima02.domain.Student;
import com.itheima02.utils.JDBCUtils;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StudentDaoImpl implements StudentDao {
    //    重写findAll方法查询所有学生信息
    @Override
    public ArrayList<Student> findAll() {
        ArrayList<Student> list = null;
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            con = JDBCUtils.getconnection();
            stat = con.createStatement();
            String sql = "SELECT * FROM student";
            rs = stat.executeQuery(sql);
            list = new ArrayList<>();
            while (rs.next()) {
                Integer sid = rs.getInt("sid");
                String name = rs.getString("name");
                Integer age = rs.getInt("age");
                Date date = rs.getDate("birthday");
                Student stu = new Student(sid, name, age, date);
                list.add(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, stat, rs);
        }
        return list;
    }

    //    重写findById方法根据id查询学生信息
    @Override
    public Student findById(Integer id) {
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        Student stu = null;
        try {
            con = JDBCUtils.getconnection();
            stat = con.createStatement();
            String sql = "SELECT * FROM student WHERE sid=" + id;
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                Integer sid = rs.getInt("sid");
                String name = rs.getString("name");
                Integer age = rs.getInt("age");
                Date date = rs.getDate("birthday");
                stu = new Student(sid, name, age, date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, stat, rs);
        }
        return stu;
    }

    //重写insert方法添加学生
    @Override
    public int insert(Student stu) {
        Connection con = null;
        Statement stat = null;
        int result = 0;
        try {
            con = JDBCUtils.getconnection();
            stat = con.createStatement();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = sdf.format(stu.getBirthday());
            String sql = "INSERT INTO " + "student (sid,NAME,age,birthday)" + "VALUES ('" + stu.getSid() + "','" + stu.getName() + "','" + stu.getAge() + "','" + birthday + "')";
            result = stat.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, stat);
        }
        return result;
    }

    //重写update方法修改学生
    @Override
    public int update(Student stu) {
        Connection con = null;
        Statement stat = null;
        int result = 0;
        try {
            con = JDBCUtils.getconnection();
            stat = con.createStatement();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = sdf.format(stu.getBirthday());
            String sql = "UPDATE student SET sid='" + stu.getSid() + "',NAME='" + stu.getName() + "',age='" + stu.getAge() + "',birthday='" + birthday + "' WHERE sid='" + stu.getSid() + "'";
            result = stat.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, stat);
        }
        return result;
    }

    //重写delete方法修改学生
    @Override
    public int delete(Integer id) {
        Connection con = null;
        Statement stat = null;
        int result = 0;
        try {
            con = JDBCUtils.getconnection();
            stat = con.createStatement();
            String sql = "DELETE FROM student WHERE sid='" + id + "'";
            result = stat.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, stat);
        }
        return result;
    }
}
