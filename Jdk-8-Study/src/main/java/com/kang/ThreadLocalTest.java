package com.kang;

/**
 * ThreadLocalTest class
 *
 * @author 康正锋
 * @date 2022/03/15
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        // 测试InheritableThreadLocal
        ThreadLocal<String> t1ThreadLocal = new InheritableThreadLocal<>();
        t1ThreadLocal.set("main");
        new Thread(() -> {
            t1ThreadLocal.set("t1");
            System.out.println("t1>>>>" + t1ThreadLocal.get());
        }, "t1").start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1ThreadLocal.get());
    }
}
