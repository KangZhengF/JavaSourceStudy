package com.kang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author 康正锋
 * @date 2021-09-02 23:20:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Dog {
    private int age;
    private String name;
}
