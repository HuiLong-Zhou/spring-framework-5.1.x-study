package com.zhl.mybatis;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * <p>
 *  在 MyImportRegister 中注册了 BeanDefinition 不需要额外使用 @Component 注解了
 * @author zhl
 * @since 2024-05-29 17:29
 */
public class MyFactoryBean implements FactoryBean<UserDAO> {
    @Override
    public UserDAO getObject() throws Exception {
        UserDAO userDAO = (UserDAO) Proxy.newProxyInstance(MyFactoryBean.class.getClassLoader(), new Class[]{UserDAO.class}, (proxy, method, args) -> {
            System.out.println("这是 UserDAO的实现类");
            return null;
        });
        return userDAO;
    }

    @Override
    public Class<?> getObjectType() {
        return UserDAO.class;
    }
}
