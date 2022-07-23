package com.wzj.web;

import com.wzj.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ApplicationContext wzj = new ClassPathXmlApplicationContext("applicationContext.xml");
        ServletContext servletContext = this.getServletContext();
//        ApplicationContext wzj = (ApplicationContext) servletContext.getAttribute("wzj");
//        ApplicationContext wzj = WebApplicationContextUtils.getWebApplicationContext(servletContext);
//       前面加web的是ApplicationContext的子方法
//        WebApplicationContext wzj = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        WebApplicationContext wzj = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserService userService = wzj.getBean(UserService.class);
        userService.qq();
    }
}
