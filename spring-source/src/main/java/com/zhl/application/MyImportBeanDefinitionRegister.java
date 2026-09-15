package com.zhl.application;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import sun.net.www.content.text.Generic;

/**
 * <p>
 *  不存在实际的 .class
 *  需要动态字节码技术 运行创建的类型
 * @author zhl
 * @since 2024-05-29 15:28
 */
public class MyImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();

        registry.registerBeanDefinition("user", beanDefinition);
    }
}
