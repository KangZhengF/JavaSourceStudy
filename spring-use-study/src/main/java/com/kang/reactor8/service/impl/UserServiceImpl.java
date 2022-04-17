package com.kang.reactor8.service.impl;

import com.kang.reactor8.entity.User;
import com.kang.reactor8.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    /**
     * 创建map集合存储数据
     */
    private final Map<Integer, User> users = new HashMap<>();

    public UserServiceImpl() {
        this.users.put(1, new User("lucy", "男", 20));
        this.users.put(2, new User("mary", "女", 20));
        this.users.put(3, new User("jack", "女", 20));
    }

    @Override
    public Mono<User> getUserById(int id) {
        return Mono.just(this.users.get(id));
    }

    @Override
    public Flux<User> getAllUser() {
        return Flux.fromIterable(this.users.values());
    }

    @Override
    public Mono<Void> saveUserInfo(Mono<User> userMono) {
        return userMono.doOnNext(person -> {
            int id = users.size() + 1;
            users.put(id, person);
        }).thenEmpty(Mono.empty());
    }
}
