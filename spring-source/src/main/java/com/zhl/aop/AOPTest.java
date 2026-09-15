package com.zhl.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-03 14:49
 */
public class AOPTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx  = new AnnotationConfigApplicationContext(AppConfig.class);
        IUserService userService = (IUserService) ctx.getBean("userService");
//        UserService userService = (UserService) ctx.getBean("userService");
//        userService.showAge();

        userService.showName();
    }
}
