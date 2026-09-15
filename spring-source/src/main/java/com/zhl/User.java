package com.zhl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Description
 *
 * <p>
 *  在Spring容器中 BeanNameAware（获取当前bean的id值） 和 BeanFactoryAware（获取beanFactory回调） 使用了Set 注入
 *  自己的注入在前，容器的注入在后
 * @author zhl
 * @since 2024-05-11 14:09
 */
public class User implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {
    private Integer id;
    private String name;
    private String password;
    private String userBeanName;
    private BeanFactory userBeanFactoryName;

    public void myDestroy(){
        System.out.println("myDestroy()...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("User.destroy");
    }

    // 配置方法初始化
    public void myInit() {
        System.out.println("myInit()...");
    }

    // 接口初始化    属性注入后
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("User.afterPropertiesSet");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("User.setId...");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("User.setName...");
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println("User.setPassword....");
        this.password = password;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware.setBeanName()...");
        this.userBeanName = name;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware.setBeanFactory()...");
        this.userBeanFactoryName = beanFactory;
    }

    public void getUserBeanName() {
        System.out.println("userBeanName = " + userBeanName);
    }

    public void getUserBeanFactoryName() {
        System.out.println("userBeanFactoryName = " + this.userBeanFactoryName );
    }

}
