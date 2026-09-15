package com.zhl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-01 22:23
 */
public class BeanDefinitionRegistryPostProcessorTest implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
        GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();

//        registry.registerBeanDefinition();

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
