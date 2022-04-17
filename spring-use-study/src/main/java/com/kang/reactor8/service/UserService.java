package com.kang.reactor8.service;

import com.kang.reactor8.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> getUserById(int id);

    Flux<User> getAllUser();

    Mono<Void> saveUserInfo(Mono<User> user);
}
