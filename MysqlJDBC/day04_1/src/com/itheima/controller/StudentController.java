package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.bean.Student;
import com.itheima.service.StudentService;
import com.itheima.service.impl.StudentServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
    控制层测试类
 */
public class StudentController {
    //创建业务层对象
    private StudentService service = new StudentServiceImpl();

    //查询全部功能测试
    @Test
    public void selectAll() {
        List<Student> students = service.selectAll();
        for (Student stu : students) {
            System.out.println(stu);
        }
    }

    //根据id查询功能测试
    @Test
    public void selectById() {
        Student stu = service.selectById(3);
        System.out.println(stu);
    }

    //新增功能测试
    @Test
    public void insert() {
        Student stu = new Student(5, "周七", 27);
        Integer result = service.insert(stu);
        System.out.println(result);
    }

    //修改功能测试
    @Test
    public void update() {
        Student stu = new Student(5, "周七", 37);
        Integer result = service.update(stu);
        System.out.println(result);
    }

    //删除功能测试
    @Test
    public void delete() {
        Integer result = service.delete(5);
        System.out.println(result);
    }

    //根据两个参数查询起别名
    @Test
    public void selectByNameOrAge() {
        List<Student> list = service.selectByNameOrAge("张三", 24);
        System.out.println(list);
    }

    //根据传入参数的不同动态查询
    @Test
    public void selectCondition() {
        Student stu = new Student(2, "李四", null);
        Student student = service.selectCondition(stu);
        System.out.println(student);
    }

    //根据传入的sid数组来查询
    @Test
    public void selectByIds() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        List<Student> studentList = service.selectByIds(list);
        System.out.println(studentList);
    }

    //根据传入的参数分页
    @Test
    public void selectPaging() {
        List<Student> studentList = service.selectPaging(1);
        //打印分页结果
        //下面这句话等同于studentList.forEach(student -> System.out.println(student));
        studentList.forEach(System.out::println);
    }

    //获取分页信息
    @Test
    public void selectPageInfo() {
        PageInfo<Student> pageInfo = service.selectPageInfo();
        System.out.println("总条数：" + pageInfo.getTotal());
        System.out.println("总页数：" + pageInfo.getPages());
        System.out.println("当前页：" + pageInfo.getPageNum());
        System.out.println("每页显示长度：" + pageInfo.getPageSize());
        System.out.println("上一页：" + pageInfo.getPrePage());
        System.out.println("下一页：" + pageInfo.getNextPage());
        System.out.println("是否第一页：" + pageInfo.isIsFirstPage());
        System.out.println("是否最后一页：" + pageInfo.isIsLastPage());
    }
}
