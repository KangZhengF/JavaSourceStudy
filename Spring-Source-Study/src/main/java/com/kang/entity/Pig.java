package com.kang.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Pig class
 *
 * @author 康正锋
 * @date 2021/09/05
 */
@Setter
@Getter
public class Pig {
    private User user;
//    private int id = 1;
//    private String name = "张三";
    public Pig(){}

    public Pig(User user) {
        this.user = user;
    }
}
