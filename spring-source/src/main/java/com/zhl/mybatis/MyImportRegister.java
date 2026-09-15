package com.zhl.mybatis;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;


/**
 * <p>
 *
 * @author zhl
 * @since 2024-05-29 17:19
 */
public class MyImportRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 创建 BD
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MyFactoryBean.class);
        GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();

        // 注册 BD
        registry.registerBeanDefinition("userDAO", beanDefinition);
    }
}
