package com.zhl.tx.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-07 16:59
 */
@Service
public class UserServiceImpl implements UserService, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public void register(User user) {
        System.out.println("-------register invoke-------");
        userDAO.save(user);
        // 测试多重事务嵌套情况
        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
        userService.modify(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void modify(User user) {
        userDAO.update(user);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
