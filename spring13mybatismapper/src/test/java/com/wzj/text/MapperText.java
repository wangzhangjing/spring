package com.wzj.text;

import com.wzj.domain.User;
import com.wzj.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MapperText {

    @Test
    public void text1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行操作 参数是namespace
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //模拟条件user
        User qq=new User();
//        qq.setId(2);
//        qq.setUsername("大哥");
//        qq.setPassword(234);
//        List<User> UserList = mapper.fand(qq);
//        System.out.println(UserList);
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        List<User> fac = mapper.findids(ids);
        System.out.println(fac);
        sqlSession.close();

    }

}
