package com.kang.app;

import com.kang.config.Config;
import com.kang.exception.MyException0;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author 康正锋
 * @date 2021-10-29 23:26:04
 */
public class App02 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ThreadPoolTaskExecutor threadPoolTaskExecutor = context.getBean(ThreadPoolTaskExecutor.class);
        System.out.println("这里也执行了");
        threadPoolTaskExecutor.execute(() -> {
            throw new MyException0("假装抛一个MyBaits异常");
        });
    }
}
