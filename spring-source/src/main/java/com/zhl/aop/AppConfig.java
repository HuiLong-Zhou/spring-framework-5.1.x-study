package com.zhl.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-03 14:49
 */
@Configuration
@ComponentScan("com.zhl.aop")
// exposeProxy = true ===》Spring 会把当前的代理对象放到 ThreadLocal 中
//@EnableAspectJAutoProxy(exposeProxy = true)
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAspectJAutoProxy
public class AppConfig {
}