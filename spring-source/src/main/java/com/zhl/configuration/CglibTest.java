package com.zhl.configuration;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-02 10:27
 */
public class CglibTest {
    public static void main(String[] args) {
        /*
            1. 原始对象
            2. 类加载器
            3. 基于接口还是基于父类
            4. 额外功能
         */
        Enhancer enhancer = new Enhancer();
        A a = new A();
        enhancer.setClassLoader(CglibTest.class.getClassLoader());
        enhancer.setSuperclass(A.class);
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("增加对于@Scope注解的支持");
                return method.invoke(a, objects);
            }
        });

        A aProxy = (A) enhancer.create();
        aProxy.m1();
    }
}
