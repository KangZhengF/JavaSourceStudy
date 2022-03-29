package com.kang.thread.threadconnect;

public class FalseShared {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000000; i++) {
                count.a++;
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000000; i++) {
                count.a++;
            }
        });
        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        // 4400ms
        System.out.print("time is " + (System.currentTimeMillis() - start));
    }
}

class Count {
    volatile long a;
    //jdk8
//    @sun.misc.Contended
    //jdk11
//    @jdk.internal.misc.Contended
    volatile long b;
}