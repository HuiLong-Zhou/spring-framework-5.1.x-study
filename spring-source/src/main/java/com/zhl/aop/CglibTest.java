package com.zhl.aop;

import com.zhl.User;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-03 20:11
 */
public class CglibTest {
    public static void main(String[] args) {
        UserService userService = new UserService();

        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(CglibTest.class.getClassLoader());
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("-----cglib before----");
                Object ret = method.invoke(userService, args);
                return ret;
            }
        });

        UserService userService1 = (UserService) enhancer.create();
        userService1.showName();
    }
}
