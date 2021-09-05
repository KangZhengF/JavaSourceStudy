package com.kang.app;

import com.kang.entity.Pig;
import com.kang.entity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * App01 class
 *
 * @author 康正锋
 * @date 2021/09/05
 */
public class App01 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("application.xml");
        Pig pig1 = xmlContext.getBean("pig1", Pig.class);
        Pig pig11 = xmlContext.getBean("pig1", Pig.class);
        Pig pig2 = xmlContext.getBean("pig2", Pig.class);
        System.out.println(pig1.hashCode());
        System.out.println(pig11.hashCode());
        System.out.println(pig2.hashCode());
        System.out.println(pig1);
        System.out.println(pig11);
        System.out.println(pig2);
        Pig pig3 = xmlContext.getBean(Pig.class);
        System.out.println(pig3);
    }
}
