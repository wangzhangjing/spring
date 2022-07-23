package com.wzj.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Myinterceptor1 implements HandlerInterceptor {
    //在目标方法执行之前执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle执行中");
        String param = request.getParameter("param");
        if ("yes".equals(param)){return true;
        }else {
            request.getRequestDispatcher("/error.jsp").forward(request,response);
            return false;
        }
       //开关true代表放行 false代表不放行
    }
    //在目标方法执行之后视图返回之前执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("name","wzj");
        System.out.println("postHandle2执行中");
    }
    //在所有流程完成之后执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion3执行中");
    }
}
