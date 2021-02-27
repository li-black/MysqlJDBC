package com.itheima.bean;
//Course类

public class Course {
    private Integer id;     //主键id
    private String NAME;    //课程名称

    public Course() {
    }

    public Course(Integer id, String NAME) {
        this.id = id;
        this.NAME = NAME;
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

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", NAME='" + NAME + '\'' +
                '}';
    }
}
