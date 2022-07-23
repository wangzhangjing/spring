package com.itheima.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//<bean id="userService" class="com.itheima.impl.UserServiceimpl">
//@Component("userService")
@Service("userService")
@Scope("singleton")
//@Scope("prototype")
public class UserServiceimpl implements UserService {
    @Value("${jdbc.url}")
    private String d;
//<property name="userDao" ref="userDao"></property>
//    @Autowired
//    @Qualifier("userDao")//按照id名称从容器中匹配的 但是主要此次@Qualifier结合@Autowired一起使用
    @Resource(name="userDao")// @Resource相当于@Qualifier结合@Autowired
    private UserDao userDao;
//注解可以不用set构造方法
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }





    public void wwzz() {
       userDao.wwzz();
       System.out.println(d);
    }
}
