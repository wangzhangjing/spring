package com.wzj.proxy.cglib;

import com.wzj.proxy.jdk.Targetinterface;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyText {
    public static void main(String[] args) {

        //创建目标对象
        final Target target =new Target();

        //获取增强对象
        final Advice advice=new Advice();

     //返回值 就是动态生成代理对象，基于cglib
        //1创建增强器
        Enhancer enhancer =new Enhancer();
        //2设置父类（目标）
        enhancer.setSuperclass(Target.class);
        //3设置回调
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

                advice.before();//执行前置

                Object invoke = method.invoke(target, args); //执行目标

                advice.afterReturning(); //执行后置
                return invoke;
            }
        });
        //4生成代理对象
        Target proxy =(Target) enhancer.create();
        proxy.save();
    }
}
