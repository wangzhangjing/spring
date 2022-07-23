package com.itheima.demo;

import com.itheima.dao.UserDao;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoDemo {
    public static void main(String[] args) {

        ApplicationContext app =new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao =(UserDao) app.getBean("userDao");
        userDao.sa();
    }
}
