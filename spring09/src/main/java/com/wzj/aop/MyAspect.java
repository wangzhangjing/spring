package com.wzj.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
    public void before(){//前置通知
        System.out.println("前置增强");
    }
    public void afterReturning(){//后置增强
        System.out.println("后置增强");
    }
    //ProceedingJoinPoint正在执行的连接点==切点
    public Object around(ProceedingJoinPoint pjp) throws Throwable {//环绕增强
        System.out.println("环绕前增强");
        Object proceed = pjp.proceed();
        System.out.println("环绕后增强");
        return proceed;
    }
    public void afterThor(){//异常抛出增强
        System.out.println("异常抛出增强");
    }
    public void after(){//最终增强
        System.out.println("最终增强........");
    }
}
