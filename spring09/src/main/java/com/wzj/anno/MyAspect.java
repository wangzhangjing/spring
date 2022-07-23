package com.wzj.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect//标注MyAspect是一个切面类
public class MyAspect {
    //配置前置通知
    @Before("execution(* com.wzj.anno.*.*(..))")
    public void before(){//前置通知
        System.out.println("前置增强");
    }
    @AfterReturning("execution(* com.wzj.anno.*.*(..))")
    public void afterReturning(){//后置增强
        System.out.println("后置增强");
    }
    //ProceedingJoinPoint正在执行的连接点==切点
    @Around("execution(* com.wzj.anno.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {//环绕增强
        System.out.println("环绕前增强");
        Object proceed = pjp.proceed();
        System.out.println("环绕后增强");
        return proceed;
    }
    @AfterThrowing("MyAspect.pointcut()")
    public void afterThor(){//异常抛出增强
        System.out.println("异常抛出增强");
    }
    @After("pointcut()")
    public void after(){//最终增强
        System.out.println("最终增强........");
    }
    //定义切点表达式
    @Pointcut("execution(* com.wzj.anno.*.*(..))")
    public void pointcut(){}
}
