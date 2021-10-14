package com.kang.config;

import com.kang.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 康正锋
 */
@ComponentScan("com.kang.entity")
public class Config {
    @Bean
    public User user() {
        return new User();
    }
}
