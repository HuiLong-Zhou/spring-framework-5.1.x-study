package com.zhl.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-05-29 17:44
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyBatisConfig.class);
        UserService userServiceImpl = (UserService) applicationContext.getBean("userServiceImpl");
        userServiceImpl.register();
    }
}
