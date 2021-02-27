package com.itheima.bean;
//Student类

import java.util.List;

public class Student {
    private Integer id;     //主键id
    private String NAME;    //学生姓名
    private Integer age;    //学生年龄
    private List<Course> courses;   // 学生所选择的课程集合

    public Student() {
    }

    public Student(Integer id, String NAME, Integer age, List<Course> courses) {
        this.id = id;
        this.NAME = NAME;
        this.age = age;
        this.courses = courses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", NAME='" + NAME + '\'' +
                ", age=" + age +
                ", courses=" + courses +
                '}';
    }
}
