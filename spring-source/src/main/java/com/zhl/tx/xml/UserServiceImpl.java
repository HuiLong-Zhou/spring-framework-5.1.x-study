package com.zhl.tx.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-07 16:59
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    @Override
    public void register(User user) {
        userDAO.save(user);
    }
}
