package com.zhl.aoppost;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-07 10:54
 */
@Component
public class MyPointcutAdvisor implements PointcutAdvisor, BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public Pointcut getPointcut() {
        return new MyPointCut();
    }

    @Override
    public Advice getAdvice() {
//        return beanFactory.getBean(Advice.class);
        return new MyBefore();
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory=beanFactory;
    }
}
