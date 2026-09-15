package com.zhl.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-03 20:00
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        UserService userService = new UserService();

        IUserService userService1 = (IUserService) Proxy.newProxyInstance(
            JDKProxyTest.class.getClassLoader(),
            new Class[]{IUserService.class},
            new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("-------jdk before-------");
                Object ret = method.invoke(userService, args);
                return ret;
            }
        });

        userService1.showName();
    }
}
