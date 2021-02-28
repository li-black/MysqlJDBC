package com.itheima.bean;
//Classes类

import java.util.List;

public class Classes {
    private Integer id;     //主键id
    private String NAME;    //班级名称
    private List<Student> students; //班级中所有学生对象

    public Classes() {
    }

    public Classes(Integer id, String NAME, List<Student> students) {
        this.id = id;
        this.NAME = NAME;
        this.students = students;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", NAME='" + NAME + '\'' +
                ", students=" + students +
                '}';
    }
}
