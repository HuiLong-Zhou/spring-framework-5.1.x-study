package com.zhl.aoppost;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-03 20:20
 */
//@Component    // spring 通过 @Import 注解将 MyAspectJPostProcessor 添加进去
public class MyAspectJPostProcessor implements BeanPostProcessor, BeanFactoryAware {

    private BeanFactory beanFactory;

    /*
        针对于 BeanPostProcessor 如果需要获取 Spring 创建的一个对象，不建议使用 @Autowired    ===> AutowiredAnnotationBeanPostProcessor
        @Autowired
        private MyPointcut myPointcut;
        如果使用 ApplicationContextAware，实际上底层还是实现了 BeanPostProcessor 的ApplicationContextAwareProcessor
        可以使用 BeanFactoryAware，是在 initializeBean中的 Aware 中（PostProcessorBefore之前）调用的
     */

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        // 支持多个切面
        ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        String[] beanNamesForType = listableBeanFactory.getBeanNamesForType(PointcutAdvisor.class);
        List<PointcutAdvisor> pointcutAdvisors = new ArrayList<>();

        // 不能给 pointcutAdvisor 做代理
        if (PointcutAdvisor.class.isAssignableFrom(bean.getClass())){
            return bean;
        }

        for (String beanNameItem : beanNamesForType) {
            PointcutAdvisor pointcutAdvisor =  beanFactory.getBean(beanNameItem, PointcutAdvisor.class);
            pointcutAdvisors.add(pointcutAdvisor);
        }

        //切入点+额外功能 = 切面（Advisor）
        // 把 切入点+额外功能 包装成 PointcutAdvisor
        // 获取自己的 MyPointcutAdvisor
//        PointcutAdvisor pointcutAdvisor = beanFactory.getBean(PointcutAdvisor.class);

        // 获取 MyPointcut    ===> 切入点
        // Pointcut pointcut = beanFactory.getBean(Pointcut.class);
        // 获取 MyBefore      ===> 额外功能
        // MethodBeforeAdvice before = beanFactory.getBean(MethodBeforeAdvice.class);

        return Proxy.newProxyInstance(MyAspectJPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new MyInvocationHandler(pointcutAdvisors, bean) );
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
