package com.kang.reactor8.entity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class TestReactor {
    public static void main(String[] args) throws InterruptedException {
        //just方法直接声明
        Flux.just(1, 2, 3, 4).subscribe(System.out::println);
        Mono.just(1).subscribe(System.out::println);
        //其他方法
//        Integer[] array = {1, 2, 3, 4};
//        Flux.fromArray(array);

//        List<Integer> list = Arrays.asList(array);
//        Flux.fromIterable(list);

//        Stream<Integer> stream = list.stream();
//        Flux.fromStream(stream);
    }
}
