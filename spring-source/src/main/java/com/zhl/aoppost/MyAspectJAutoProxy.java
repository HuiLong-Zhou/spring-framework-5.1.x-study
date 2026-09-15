package com.zhl.aoppost;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 *  自定义的 AOPConfig  引入自定义的 BeanPostProcessor
 * @author zhl
 * @since 2024-06-03 20:55
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MyAspectJPostProcessor.class)
public @interface MyAspectJAutoProxy {
}
