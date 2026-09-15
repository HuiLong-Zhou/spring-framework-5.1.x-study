package com.zhl.mybatis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-05-29 17:17
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void register() {
        userDAO.save();
    }

}
