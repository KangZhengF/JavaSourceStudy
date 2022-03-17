package com.kang.thread.threadapi;

public class ThreadExceptionTest {
    public static void main(String[] args) {
        ThreadGroup group1 = new ThreadGroup("group1");
        ThreadGroup group2 = new ThreadGroup(group1, "group2");
        Thread thread3 = new Thread(group2, "优先级3的线程异常处理器") {
            @Override
            public void run() {
                int i = 1 / 0;
                System.out.println("优先级3的异常处理器");
            }
        };


        MyThread myThread = new MyThread();
        myThread.start();

        // 默认的异常处理方法（所有的线程如果没有设置异常处理逻辑，则调用该方法）
        // 优先级第4的异常处理器,如果没有这个，就在控制台打印出来
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            System.out.println("线程：" + t.getName() + "抛出异常：" + e.getMessage());
        });
        Thread t1 = new Thread(() -> {
            System.out.println(">>> this is run method ...");
            int ret = 1 / 0;
        });
        // 处理异常，统一处理check和runtime异常
        // 优先级第2的异常处理器
        t1.setUncaughtExceptionHandler((t, e) -> System.out.println("线程：" + t.getName() + "抛出异常：" + e.getMessage()));
        t1.start();
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("mythread run()...");
            int i = 1 / 0;
        }

        @Override
        public UncaughtExceptionHandler getUncaughtExceptionHandler() {
            System.out.println("优先级1的异常处理器");
            return super.getUncaughtExceptionHandler();
        }
    }
}
