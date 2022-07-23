package com.wzj.service;

import com.wzj.dao.UserMapper;

import com.wzj.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ServiceDemo {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行操作 参数是namespace
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> all=mapper.findAll();
//        System.out.println(all);
//        sqlSession.close();
        User findid = mapper.findid(3);
        System.out.println(findid);
        sqlSession.close();

    }
}
