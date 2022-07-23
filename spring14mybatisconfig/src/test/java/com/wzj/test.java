package com.wzj;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzj.domain.User;
import com.wzj.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class test {
    @Test
    public void text1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行操作 参数是namespace
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user =new User();
        user.setId(6);
        user.setUsername("大富翁");
        user.setPassword(123);
        user.setBirthday(new Date());
        mapper.save(user);
}
    @Test
    public void text2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行操作 参数是namespace
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User findid = mapper.findid(6);
        System.out.println("user中的时间是："+findid.getBirthday());
        sqlSession.close();
    }
    @Test
    public void text3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行操作 参数是namespace
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //设置分页相关参数 当前每页显示条数
        PageHelper.startPage(2,3);

        List<User> all = mapper.findAll();
        for (User user:all
             ) {
            System.out.println(user);
        }
        PageInfo<User>pageInfo = new PageInfo<User>(all);
        System.out.println("当前页："+pageInfo.getPageNum());
        System.out.println("每页显示条数："+pageInfo.getPageSize());
        System.out.println("总条数："+pageInfo.getTotal());
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("上一页："+pageInfo.getPrePage());
        System.out.println("下一页："+pageInfo.getNextPage());
        System.out.println("是否是第一个："+pageInfo.isIsFirstPage());
        System.out.println("是否是最后1个："+pageInfo.isIsLastPage());
        sqlSession.close();
    }
}
