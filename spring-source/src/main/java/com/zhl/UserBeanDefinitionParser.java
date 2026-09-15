package com.zhl;

import org.springframework.aop.framework.AbstractSingletonProxyFactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.context.ApplicationContext;
import org.w3c.dom.Element;

/**
 * Description
 *
 * <p>
 *  解析自定义 标签
 * @author zhl
 * @since 2024-05-11 14:03
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    /**
     * 解析自定义标签后封装成 BeanDefinition
     * @param element the XML element being parsed
     * @param builder used to define the {@code BeanDefinition}
     */
    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String name = element.getAttribute("name");
        String password = element.getAttribute("password");

        builder.addPropertyValue("name", name);
        builder.addPropertyValue("password", password);
    }
}
