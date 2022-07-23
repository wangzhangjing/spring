package com.wzj.test;


import com.wzj.domain.Order1;
import com.wzj.mapper.OrderMapper1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest1 {
    private OrderMapper1 mapper;
    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行操作 参数是namespace
       mapper = sqlSession.getMapper(OrderMapper1.class);
    }

    @Test
    public void testfindAllll(){

        List<Order1> all = mapper.findAlll();
        for (Order1 o:all
             ) {
            System.out.println(o);
        }

    }
    @Test
    public void testfindAllllqq(){

        List<Order1> s = mapper.findbyuid(2);
        System.out.println(s);

    }
}
