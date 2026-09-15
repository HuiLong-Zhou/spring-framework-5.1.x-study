package com.zhl.aoppost;

import org.aopalliance.aop.Advice;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.PointcutAdvisor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-07 15:27
 */
public class MyInvocationHandler implements InvocationHandler {

    private List<PointcutAdvisor> pointcutAdvisors= new ArrayList<>();
    private Object bean;
    // 存储before
    private List<PointcutAdvisor> beforeAdvisors = new ArrayList<>();
    // 存储after
    private List<PointcutAdvisor> afterAdvisors = new ArrayList<>();


    public MyInvocationHandler() {
    }

    public MyInvocationHandler(List<PointcutAdvisor> pointcutAdvisors, Object bean) {
        this.pointcutAdvisors = pointcutAdvisors;
        this.bean = bean;
        differAdvisors(pointcutAdvisors);
    }


    /**
     * 区分代理前后的 Advisors
     * @param pointcutAdvisors
     */
    public void differAdvisors(List<PointcutAdvisor> pointcutAdvisors) {
        for (PointcutAdvisor pointcutAdvisor : pointcutAdvisors) {
            Advice advice = pointcutAdvisor.getAdvice();
            if (advice instanceof MethodBeforeAdvice){
                beforeAdvisors.add(pointcutAdvisor);
            }
            if (advice instanceof AfterReturningAdvice) {
                afterAdvisors.add(pointcutAdvisor);
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret =null;
        // 以此遍历代理前后的 advisor
        for (PointcutAdvisor beforeAdvisor : beforeAdvisors) {
            if (beforeAdvisor.getPointcut().getClassFilter().matches(bean.getClass())) {
                if (beforeAdvisor.getPointcut().getMethodMatcher().matches(method, bean.getClass())) {
                    ((MethodBeforeAdvice) beforeAdvisor.getAdvice()).before(method, args, bean);
                }
            }
        }
        // 原始方法
        ret = method.invoke(bean, args);

        for (PointcutAdvisor afterAdvisor : afterAdvisors) {
            if (afterAdvisor.getPointcut().getClassFilter().matches(bean.getClass())){
                if (afterAdvisor.getPointcut().getMethodMatcher().matches(method, bean.getClass())){
                    ((AfterReturningAdvice) afterAdvisor.getAdvice()).afterReturning(ret, method, args,bean);
                }
            }
        }

        /*for (PointcutAdvisor pointcutAdvisor : pointcutAdvisors) {
            if (pointcutAdvisor.getPointcut().getClassFilter().matches(bean.getClass())) {
                if (pointcutAdvisor.getPointcut().getMethodMatcher().matches(method, bean.getClass())) {
                    if (pointcutAdvisor.getAdvice() instanceof MethodBeforeAdvice) {
                        for (PointcutAdvisor beforeAdvisor : beforeAdvisors) {
                            ((MethodBeforeAdvice) beforeAdvisor.getAdvice()).before(method, args, bean);
                        }
                    }
                    // 原始方法
                    ret = method.invoke(bean, args);
                    if (pointcutAdvisor.getAdvice() instanceof AfterReturningAdvice) {
                        for (PointcutAdvisor afterAdvisor : afterAdvisors) {
                            ((AfterReturningAdvice) afterAdvisor.getAdvice()).afterReturning(ret, method, args,bean);
                        }
                    }
                }
            }
            *//*else {
                return method.invoke(bean,args);
            }*//*
            *//*if (pointcutAdvisor.getPointcut().getClassFilter().matches(bean.getClass())) {
                // 判断方法是否符合要求
                if (pointcutAdvisor.getPointcut().getMethodMatcher().matches(method, bean.getClass())) {
                    if (pointcutAdvisor.getAdvice() instanceof MethodBeforeAdvice) {
                        // 回调MyBefore
                        ((MethodBeforeAdvice) pointcutAdvisor.getAdvice()).before(method, args, bean);
                        ret = method.invoke(bean, args);
                    }
                    if (pointcutAdvisor.getAdvice() instanceof AfterReturningAdvice) {
                        // 回调MyAfter
                        ((AfterReturningAdvice) pointcutAdvisor.getAdvice()).afterReturning(ret, method, args, bean);
                    }
                    // return ret;
                }
            } else {
                return method.invoke(bean,args);
            }*//*
        }*/
        // 没有 advisor 直接调用原始方法
        return ret;
    }
}
