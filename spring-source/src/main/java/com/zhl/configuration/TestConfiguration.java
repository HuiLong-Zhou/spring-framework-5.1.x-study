package com.zhl.configuration;

import com.zhl.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-01 21:52
 */
public class TestConfiguration {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//        AppConfig appConfig = (AppConfig) ctx.getBean("appConfig");
        User user = (User) ctx.getBean("user");
        User user1 = (User) ctx.getBean("user");

        System.out.println("user = " + user);
        System.out.println("user1 = " + user1);

//        System.out.println("TestConfiguration.main");
    }
}
