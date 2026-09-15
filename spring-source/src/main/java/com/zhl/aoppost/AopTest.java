package com.zhl.aoppost;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-03 20:21
 */
public class AopTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        IUserService userService = (IUserService) ctx.getBean("userService");

        userService.showName();

        userService.showAge();
    }
}
