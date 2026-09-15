package com.zhl.configuration;


import com.zhl.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-01 21:52
 */
@Configuration
public class AppConfig {

//    @Scope(value = "prototype")
    @Bean
    public User user() {
        return new User();
    }

}
