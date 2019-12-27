//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.baissy.dao;

import com.baissy.poio.User;
import com.baissy.utils.MybatisUtils;
import java.util.Iterator;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserDaoTest {
    public UserDaoTest() {
    }

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();

        for(User user :userList){
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    //增删改需要处理事务，否则不能操作成功
    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.addUser(new User(4,"王五","123456"));
        //处理事务
        sqlSession.commit();
        if(res>0)
            System.out.println("插入成功！");

        sqlSession.close();
    }

    @Test
    public void updataUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.updataUser(new User(4,"王六","654321"));
        //处理事务
        sqlSession.commit();
        if(res>0)
            System.out.println("修改成功！");

        sqlSession.close();
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.deleteUser(4);
        //处理事务
        sqlSession.commit();
        if(res>0)
            System.out.println("删除成功！");

        sqlSession.close();
    }
}
