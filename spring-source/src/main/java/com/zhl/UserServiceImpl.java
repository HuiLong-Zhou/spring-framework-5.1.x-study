package com.zhl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * <p>实现 BeanFactoryAware 传入 BeanFactory，通过 getBean() 获取
 *
 * @author zhl
 * @since 2024-05-11 18:23
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
//    private BeanFactory beanFactory;

    @Override
    public void register() {
        userDAO.save();
        System.out.println("userDAO = " + userDAO);
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /*@Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }*/
}
