package com.zhl.beanfactoryprocessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-02 16:32
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        // ctx.addBeanFactoryPostProcessor(new MyBeanDefinitionRegistryPostProcessor());
        ctx.register(AppConfig.class);
        ctx.register(A.class);
        ctx.refresh();
    }
}
