package com.kang.entity;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author 康正锋
 * @date 2021-09-03 00:08:33
 */
@Component("mao")
public class CatFactoryBean implements FactoryBean<Cat> {
    @Override
    public Cat getObject() throws Exception {
        return new Cat();
    }

    @Override
    public Class<?> getObjectType() {
        //上面方法的返回的对象的类型
        return Cat.class;
    }
}
