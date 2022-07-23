package com.wzj.text;
import com.wzj.daomain.User;
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
    public void text() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数是namespace
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        //打印数据
        System.out.println(userList);
        //释放资源
        sqlSession.close();
    }
    @Test
    public void text1() throws IOException {
        //获取核心配置文件
        User user = new User();
        user.setId(6);
        user.setUsername("思科耐");
        user.setPassword(134);

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数是namespace
        sqlSession.insert("userMapper.save",user);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
    @Test
    public void text2() throws IOException {
        //获取核心配置文件
        User user = new User();
        user.setId(5);
        user.setUsername("思科耐");
        user.setPassword(134);

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行操作 参数是namespace
        sqlSession.insert("userMapper.add",user);
        //提交事务

        //释放资源
        sqlSession.close();
    }
    @Test
    public void text4() throws IOException {
        //获取核心配置文件
      int id =5;

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行操作 参数是namespace
        sqlSession.delete("userMapper.sas",id);
        //提交事务

        //释放资源
        sqlSession.close();
    }
    @Test
    public void text5() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数是namespace
       User user = sqlSession.selectOne("userMapper.findid", 3);

        //打印数据
        System.out.println(user);
        //释放资源
        sqlSession.close();
    }
}
