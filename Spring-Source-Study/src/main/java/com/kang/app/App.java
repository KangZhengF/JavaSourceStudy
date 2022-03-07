package com.kang.app;

import com.kang.config.Config;
import com.kang.entity.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 康正锋
 * @date 2021-09-02 23:15:58
 */
public class App {
    public static void main(String[] args) {
        // 方式一：<bean>标签
//        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("application.xml");
//        User user = xmlContext.getBean("user", User.class);
//        System.out.println(user);

        //方式二：@Bean注解
        ApplicationContext annoContext = new AnnotationConfigApplicationContext(Config.class);
        for (String beanDefinitionName : annoContext.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        User user1 = annoContext.getBean(User.class);
        System.out.println(user1);

        //方式三：@Component注解
//        ApplicationContext annoContext = new AnnotationConfigApplicationContext(Config.class);
//        Dog dog = annoContext.getBean(Dog.class);
//        System.out.println(dog);

        //方式四：利用BeanDefinition接口
//        AnnotationConfigApplicationContext annoContext = new AnnotationConfigApplicationContext(Config.class);
//        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//        beanDefinition.setBeanClass(Dog.class);
//        annoContext.registerBeanDefinition("dog", beanDefinition);
//        Dog dog1 = annoContext.getBean(Dog.class);
//        System.out.println(dog1);

        // 方式五：利用FactoryBean接口
//        AnnotationConfigApplicationContext annoContext = new AnnotationConfigApplicationContext(Config.class);
        // 这里getBean()就不会报错，为了确定是哪一个getBean()报错，所以把这里提到前面来。
//        Cat mao1 = annoContext.getBean("mao", Cat.class);
//        System.out.println(mao1);
        // 这里就不会报错，但是没有重写toString()方法所以输出了对象信息。发现确实是CatFactoryBean.class的对象
//        CatFactoryBean catFactoryBean = annoContext.getBean("&mao", CatFactoryBean.class);
//        System.out.println(catFactoryBean);
        // 这里getBean()会报错，因为我期望得到CatFactoryBean.class的实例
        // 但实际上前面注册的时候bean返回的实例类型是Cat.class
//        CatFactoryBean mao = annoContext.getBean("mao", CatFactoryBean.class);
//        System.out.println(mao);

        //方式六：利用Supplier接口
//        AnnotationConfigApplicationContext annoContext = new AnnotationConfigApplicationContext();
//        annoContext.registerBean(User.class, new Supplier<User>() {
//            @Override
//            public User get() {
//                User user = new User();
//                user.setName("abc");
//                return user;
//            }
//        });
//        annoContext.refresh();
//        User user = annoContext.getBean("user", User.class);
//        System.out.println(user);
    }
}
