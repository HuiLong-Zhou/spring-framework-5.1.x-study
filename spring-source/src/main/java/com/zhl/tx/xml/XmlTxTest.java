package com.zhl.tx.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-07 17:16
 */
public class XmlTxTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext-tx.xml");
        UserService userService = (UserService) ctx.getBean("userServiceImpl");

        User user = new User();
        user.setName("zhangsan");
        user.setVersion(1);

        userService.register(user);
    }
}
