package com.zhl;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Description
 *
 * <p>
 *  解析 自定义  <user    标签
 * @author zhl
 * @since 2024-05-11 13:59
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}
