package com.wzj.test;


import com.wzj.domain.User1;
import com.wzj.mapper.UserMapper1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest2 {
    private UserMapper1 mapper;
    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行操作 参数是namespace
       mapper = sqlSession.getMapper(UserMapper1.class);
    }

    @Test
    public void testfindAllll() {
        List<User1> finduserandorderall = mapper.finduserandorderall();
        for (User1 u:finduserandorderall
             ) {
            System.out.println(u);
        }
    }

}
