package com.itheima.service.impl;

import com.itheima.domain.User;
import com.itheima.mapper.UserDao;
import com.itheima.service.UserService;
import com.itheima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.UUID;

/**
 * 用户的业务层实现类
 *
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class UserServiceImpl implements UserService {

    @Override
    public List<User> findAll() {
        List<User> userList = null;
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final UserDao mapper = sqlSession.getMapper(UserDao.class);
            userList = mapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User findById(String uid) {
        User user = null;
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final UserDao mapper = sqlSession.getMapper(UserDao.class);
            user = mapper.findById(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void save(User user) {
        //1.创建ID,并把UUID中的-替换没
        String uid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        //2.给user的uid赋值
        user.setUid(uid);
        //3.生成员工编号
        user.setUcode(uid);
        //3.保存
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final UserDao mapper = sqlSession.getMapper(UserDao.class);
            mapper.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final UserDao mapper = sqlSession.getMapper(UserDao.class);
            mapper.update(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String uid) {
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final UserDao mapper = sqlSession.getMapper(UserDao.class);
            mapper.delete(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User login(String loginName, String password) {
        User user = null;
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final UserDao mapper = sqlSession.getMapper(UserDao.class);
            user = mapper.findByLoginNameAndPassword(loginName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /*
        事务要控制在此处
     */
    @Override
    public void batchAdd(List<User> users) {
        //获取数据库连接对象
        SqlSession sqlSession = null;
        try {
//            获取不自动提交的Session
            sqlSession = MyBatisUtils.getNoAutoSession();
            final UserDao mapper = sqlSession.getMapper(UserDao.class);
            for (User user : users) {
                //1.创建ID,并把UUID中的-替换
                String uid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
                //2.给user的uid赋值
                user.setUid(uid);
                //3.生成员工编号
                user.setUcode(uid);

//                出现异常
//                int n = 1 / 0;

                //4.保存
                mapper.save(user);
            }
//            无异常提交
            sqlSession.commit();
        } catch (Exception e) {
//            出现异常回滚
            assert sqlSession != null;
            sqlSession.rollback();
        } finally {
//            最终的释放资源
            assert sqlSession != null;
            sqlSession.close();
        }
    }
}
