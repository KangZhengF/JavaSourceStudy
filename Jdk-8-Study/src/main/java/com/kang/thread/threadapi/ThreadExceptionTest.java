package com.kang.thread.threadapi;

public class ThreadExceptionTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(">>> this is run method ...");
            int ret = 1 / 0;
        });
        // 处理异常，统一处理check和runtime异常
        t1.setUncaughtExceptionHandler((t, e) -> System.out.println("线程：" + t.getName() + "抛出异常：" + e.getMessage()));
        t1.start();
    }
}
