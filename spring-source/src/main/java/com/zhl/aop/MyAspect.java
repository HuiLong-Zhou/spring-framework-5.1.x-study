package com.zhl.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-03 14:43
 */
@Component
@Aspect
public class MyAspect {
    @Before("execution(* com.zhl.aop.UserService.*(..))")
    public void myBefore(){
        System.out.println("MyAspect.myBefore");
    }

    @After("execution(* com.zhl.aop.UserService.showName(..))")
    public void myAfter() {
        System.out.println("MyAspect.myAfter");
    }
}
