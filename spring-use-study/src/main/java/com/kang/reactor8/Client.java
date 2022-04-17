package com.kang.reactor8;

import com.kang.reactor8.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class Client {
    public static void main(String[] args) {
        WebClient webClient = WebClient.create("http://127.0.0.1:3615");
        String id = "1";
        User user = webClient.get()
                .uri("/users/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(User.class)
                .block();
        System.out.println(user.getName());

        Flux<User> userFlux = webClient.get().uri("/users")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(User.class);
        userFlux.map(stu -> stu.getName())
                .buffer()
                .doOnNext(System.out::println)
                .blockFirst();
    }
}
