package com.itheima.mapper;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.sql.Connection;
import java.util.List;

/**
 * 用户的持久层接口
 *
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public interface UserDao {

    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("SELECT * FROM user")
//    映射集
//    后面直接调用
    @Results(id = "User", value = {
            @Result(column = "uid", property = "uid"),
            @Result(column = "ucode", property = "ucode"),
            @Result(column = "loginname", property = "loginname"),
            @Result(property = "password", column = "PASSWORD"),
            @Result(property = "username", column = "username"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "birthday", column = "birthday", javaType = java.sql.Date.class, jdbcType = JdbcType.DATE),
            @Result(property = "dutydate", column = "dutydate", javaType = java.sql.Date.class, jdbcType = JdbcType.DATE)
    })
    List<User> findAll();

    /**
     * 根据id查询用户
     *
     * @param uid
     * @return
     */
    @Select("select * from user where uid = #{uid}")
    @ResultMap(value = "User")
    User findById(@Param("uid") String uid);

    /**
     * 添加
     *
     * @param user
     */
    @Insert("insert into user(uid,ucode,loginname,PASSWORD,username,gender,birthday,dutydate)" +
            "values(#{uid},#{ucode},#{loginname},#{password},#{username},#{gender},#{birthday},#{dutydate})")
    void save(User user);

    /**
     * 更新
     *
     * @param user
     */
    @Update("update user set ucode=#{ucode},loginname=#{loginname},password=#{password},username=#{username},gender=#{gender},birthday=#{birthday},dutydate=#{dutydate} where uid=#{uid}")
    void update(User user);

    /**
     * 根据id删除
     *
     * @param uid
     */
    @Delete("delete from user where uid=#{uid}")
    void delete(@Param("uid") String uid);

    /**
     * 使用登录名和密码查询用户
     *
     * @param loginName
     * @param password
     * @return
     */
    @Select("SELECT * FROM user WHERE loginname=#{loginName} AND PASSWORD=#{password}")
    @ResultMap(value = "User")
    User findByLoginNameAndPassword(@Param("loginName") String loginName, @Param("password") String password);
}
