package com.zhl.mybatis;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-05-29 17:15
 */
@Configuration
@ComponentScan("com.zhl.mybatis")
@Import(MyImportRegister.class)
public class MyBatisConfig {
}
