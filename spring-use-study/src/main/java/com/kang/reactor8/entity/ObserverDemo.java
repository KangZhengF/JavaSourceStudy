package com.kang.reactor8.entity;

import java.util.Observable;

public class ObserverDemo extends Observable {
    public static void main(String[] args) {
        // Java8提供观察者模式的两个类Observer和Observable
        ObserverDemo observer = new ObserverDemo();
        // 添加观察者
        observer.addObserver((o, arg) -> System.out.println("发生变化"));
        observer.addObserver((o, arg) -> System.out.println("手动通知被观察者，准备改变"));
        // 数据发生变化
        observer.setChanged();
        // 通知
        observer.notifyObservers();
    }
}
