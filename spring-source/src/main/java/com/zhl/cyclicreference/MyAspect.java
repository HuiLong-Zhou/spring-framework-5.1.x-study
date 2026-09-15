package com.zhl.cyclicreference;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-05-28 12:40
 */
@Aspect
@Component
public class MyAspect {
    @Before("execution(* com.zhl.cyclicreference.A.*(..)) or execution(* com.zhl.cyclicreference.B.*(..))")
    public void before(){
        System.out.println("MyAspect.before");
    }
}
