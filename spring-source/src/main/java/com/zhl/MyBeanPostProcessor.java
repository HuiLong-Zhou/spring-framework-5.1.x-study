package com.zhl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author zhl
 * @since 2024-05-13 9:23
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof User){
            User user = (User) bean;
            user.setId(100);
        }
        System.out.println("MyBeanPostProcessor.postProcessAfterInitialization");
        return bean;
    }
}
