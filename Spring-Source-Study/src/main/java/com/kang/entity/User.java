package com.kang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 康正锋
 * @date 2021-09-02 23:09:02
 */
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class User {

    static {
        System.out.println("静态块调用");
    }

    public User() {
        System.out.println("构造块调用");
    }

    private int age;
    private static String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        User.name = name;
    }
}
