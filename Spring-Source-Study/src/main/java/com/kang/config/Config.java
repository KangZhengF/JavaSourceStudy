package com.kang.config;

import com.kang.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

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
        threadPoolTaskExecutor.setCorePoolSize(2);
        threadPoolTaskExecutor.setMaxPoolSize(4);
        threadPoolTaskExecutor.setKeepAliveSeconds(1000);
        threadPoolTaskExecutor.setQueueCapacity(10);
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}
