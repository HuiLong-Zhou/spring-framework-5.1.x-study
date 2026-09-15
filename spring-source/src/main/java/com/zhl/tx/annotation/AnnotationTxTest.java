package com.zhl.tx.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-07 17:48
 */
public class AnnotationTxTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService) ctx.getBean("userServiceImpl");

        User user = new User();
        user.setName("wangwu");
        user.setVersion(3);

        userService.register(user);

        /*User user = new User();
        user.setName("zhl");
        user.setVersion(2);
        user.setId(6);
        userService.modify(user);*/
    }
}
