package com.zhl.aoppost;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-07 10:48
 */
//@Component
public class MyBefore implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("--------MyAOP before------");
    }
}
