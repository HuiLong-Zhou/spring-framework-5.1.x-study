package com.zhl.aoppost;

import com.zhl.UserServiceImpl;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-07 10:06
 */
@Component
public class MyPointCut implements Pointcut {
    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> clazz) {
                if (UserService.class.isAssignableFrom(clazz)){
                    return true;
                }
                return false;
            }
        };
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return new MethodMatcher() {
            @Override
            public boolean matches(Method method, Class<?> targetClass) {
                // 匹配 showAge 方法
                if ("showAge".equals(method.getName())){
                    return true;
                }
                return false;
            }

            @Override
            public boolean isRuntime() {
                return true;
            }

            @Override
            public boolean matches(Method method, Class<?> targetClass, Object... args) {
                return matches(method, targetClass);
            }
        };
    }
}
