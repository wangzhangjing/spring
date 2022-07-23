package com.wzj.interceptor;

import com.wzj.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Privilegeinterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断用户是否登入，本质判断session中有没有user
        HttpSession session=request.getSession();
        User user =(User)session.getAttribute("user");
        if (user==null){
            //没有登入跳转到登入页面
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return false;
        }
        //放行访问资源
        return true;
    }
}
