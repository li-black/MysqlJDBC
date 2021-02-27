package com.itheima.bean;
//Person类

public class Person {
    private Integer id;     //主键id
    private String NAME;    //人的姓名
    private Integer age;    //人的年龄

    public Person() {
    }

    public Person(Integer id, String NAME, Integer age) {
        this.id = id;
        this.NAME = NAME;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", NAME='" + NAME + '\'' +
                ", age=" + age +
                '}';
    }
}
