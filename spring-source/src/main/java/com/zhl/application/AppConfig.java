package com.zhl.application;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-05-28 21:10
 */
@Configuration
@ComponentScan("com.zhl.application")
//@Import(MyImportBeanDefinitionRegister.class)
//@Import(MyImportSelector.class)
//@Import(User.class)
public class AppConfig {
}
