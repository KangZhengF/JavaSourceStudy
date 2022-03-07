package com.kang.config;

import com.kang.entity.Pig;
import com.kang.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 康正锋
 */
//@ComponentScan("com.kang.entity")
@Configuration
//@Component
public class Config {
//    @Resource
//    private User user;

    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public Pig pig() {
        Pig pig = new Pig(this.user());
        return pig;
    }
//    @Bean
//    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
//        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
//        threadPoolTaskExecutor.setCorePoolSize(1);
//        threadPoolTaskExecutor.setMaxPoolSize(3);
//        threadPoolTaskExecutor.setQueueCapacity(2);
//        threadPoolTaskExecutor.setKeepAliveSeconds(1000);
//        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
//        threadPoolTaskExecutor.initialize();
//        return threadPoolTaskExecutor;
//    }
}
