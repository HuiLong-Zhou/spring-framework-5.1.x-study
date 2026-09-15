package com.zhl.aoppost;

import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-03 20:18
 */
@Component
public class UserService implements IUserService{
    @Override
    public void showName() {
        System.out.println("UserService.showName");
    }

    @Override
    public void showAge() {
        System.out.println("UserService.showAge");
    }
}
