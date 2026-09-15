package com.zhl.cyclicreference;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-05-27 20:48
 */
@Component
public class B {
    @Autowired
    private A a;

    public void showA() {
//        System.out.println("B.showA");
        System.out.println(a);
    }
}
