package com.wzj.test;

import com.wzj.domain.Order;
import com.wzj.domain.User;
import com.wzj.mapper.OrderMapper;
import com.wzj.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Mybatis {
    @Test
    public void text3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行操作 参数是namespace
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        //设置分页相关参数 当前每页显示条数


        List<Order> all = mapper.findAll();
        for (Order order:all
             ) {
            System.out.println(order);
        }
        sqlSession.close();
    }
    @Test
    public void text4() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行操作 参数是namespace
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User>userList =mapper.findAl();
        for (User user:userList
             ) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    }
