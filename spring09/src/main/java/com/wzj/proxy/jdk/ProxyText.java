package com.wzj.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyText {
    public static void main(String[] args) {

        //创建目标对象
        final Target target =new Target();

        //获取增强对象
        final Advice advice=new Advice();

        Targetinterface proxy = (Targetinterface)Proxy.newProxyInstance(
                target.getClass().getClassLoader(),//目标对象类加载器
                target.getClass().getInterfaces(),//目标对象相同的接口字节码对象
                new InvocationHandler() {
                    //调用代理对象的使用方法，实质上都是invoke方法
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //前置增强
                        advice.before();
                        Object invoke = method.invoke(target, args);//执行目标方法
                        //后置增强
                        advice.afterReturning();
                        return invoke;
                    }
                }

        );
        proxy.save();
    }
}
