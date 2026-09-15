package com.zhl.aoppost;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-03 14:49
 */
@Configuration
@ComponentScan("com.zhl.aoppost")
//@Import(MyAspectJPostProcessor.class) // Spring 底层实际上是这样注入的，后来又改成了 @EnableAspectJAutoProxy
//@EnableAspectJAutoProxy       // 实际上就是把创建 AOP 的BeanPostProcessor 引入了进来
@MyAspectJAutoProxy              // 我们自己定义的注解
public class AppConfig {
}

