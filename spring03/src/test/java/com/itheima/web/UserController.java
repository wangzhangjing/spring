package com.itheima.web;

import com.itheima.config.SpringConfiguration;
import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {

    public static void main(String[] args) {
       // ClassPathXmlApplicationContext w =new ClassPathXmlApplicationContext("applicationContext.xml");
      ApplicationContext w =new AnnotationConfigApplicationContext(SpringConfiguration.class);
      UserService userService = w.getBean(UserService.class);
      userService.wwzz();
    }
}
