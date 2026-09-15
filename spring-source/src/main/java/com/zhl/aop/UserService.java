package com.zhl.aop;

import org.springframework.aop.framework.AopContext;
import org.springframework.aop.target.ThreadLocalTargetSource;
import org.springframework.aop.target.ThreadLocalTargetSourceStats;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-03 14:43
 */
@Service
public class UserService implements IUserService/*, ApplicationContextAware*/ {

//    private ApplicationContext applicationContext;

//public class UserService {

    // 方式一： 使用实现 ApplicationContextAware 的方式
    /*@Override
    public  void showName(){
        System.out.println("UserService.showName");
        *//**
         * 在此方法中调用 showAge(); <=> this.showAge();   实际在AOPTest中 调用 userService.showName();  实际上只对 showName() 方法做了代理
         *
         * 因为在 此方法中实际调用的是 this.showAge(). 是原始对象的showAge()； 不是代理对象 userService.showAge();
         *
         * 这里通过ApplicationContextAware 使用 ApplicationContext  getBean("userService") 获得代理对象 userService, 以此调用 userService.showAge();
         *//*
        IUserService userService = (IUserService) applicationContext.getBean("userService");
        userService.showAge();
//        this.showAge();
    }*/

    /*@Override
    public  void showName(){
        System.out.println("UserService.showName");
        // AopContext 是从 ThreadLocal 中获取代理对象

        IUserService userService = (IUserService) AopContext.currentProxy();

        userService.showAge();
    }*/

    @Override
    public  void showName(){
        System.out.println("UserService.showName");
    }

    @Override
    public void showAge() {
        System.out.println("UserService.showAge");
    }

    // 方式一： 使用实现 ApplicationContextAware 的方式
    /*@Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }*/
}
