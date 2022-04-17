package com.kang.reactor8.controller;

import com.kang.reactor8.entity.User;
import com.kang.reactor8.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/user/{id}")
    public Mono<User> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/user")
    public Flux<User> getUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/user/save")
    public Mono<Void> saveUser(@RequestBody User user) {
        Mono<User> userMono = Mono.just(user);
        return userService.saveUserInfo(userMono);
    }
}
