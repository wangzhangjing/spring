package com.itheima.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceimpl implements UserService {
    public void sa() {
        ApplicationContext app =new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao =(UserDao) app.getBean("userDao");
        userDao.sa();
    }
}
