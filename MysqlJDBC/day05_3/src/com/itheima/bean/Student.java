package com.itheima.bean;

//Student类
public class Student {
    private Integer sid;
    private String NAME;
    private Integer age;

    public Student() {
    }

    public Student(Integer sid, String NAME, Integer age) {
        this.sid = sid;
        this.NAME = NAME;
        this.age = age;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", NAME='" + NAME + '\'' +
                ", age=" + age +
                '}';
    }
}
