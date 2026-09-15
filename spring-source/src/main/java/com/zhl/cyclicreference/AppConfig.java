package com.zhl.cyclicreference;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-05-28 12:34
 */
@Configuration
@ComponentScan("com.zhl.cyclicreference")
@EnableAspectJAutoProxy
public class AppConfig {
}
