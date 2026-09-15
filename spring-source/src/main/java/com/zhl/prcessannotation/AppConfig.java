package com.zhl.prcessannotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-05-17 9:09
 */
@Configuration
@ComponentScan(basePackages = "com.zhl.prcessannotation")
@PropertySource("classpath:app.properties")
public class AppConfig {
}
