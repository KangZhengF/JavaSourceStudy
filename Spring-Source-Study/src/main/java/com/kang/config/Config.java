package com.kang.config;

import com.kang.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 康正锋
 */
@ComponentScan("com.kang.entity")
public class Config {
    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(1);
        threadPoolTaskExecutor.setMaxPoolSize(3);
        threadPoolTaskExecutor.setQueueCapacity(2);
        threadPoolTaskExecutor.setKeepAliveSeconds(1000);
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}
