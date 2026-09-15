package com.zhl.aoppost;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-07 11:14
 */
//@Component
public class MyAfter implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("--------MyAOP after------");
    }
}
