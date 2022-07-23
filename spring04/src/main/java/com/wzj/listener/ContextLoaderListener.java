package com.wzj.listener;

import com.wzj.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext servletContext = sce.getServletContext();
        String con = servletContext.getInitParameter("contextConfigLocation");
        //监听器
//        ApplicationContext wzj = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext wzj = new ClassPathXmlApplicationContext(con);
        //将spring的应用存储到sercletContext域中
//        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("wzj",wzj);
        System.out.println("准备完成");
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
