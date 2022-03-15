package com.kang.thread.threadapi;

public class HookThreadTest {
    private static Thread thread;
    private static Throwable throwable;
    public static void main(String[] args) {
        Thread.currentThread().setUncaughtExceptionHandler((t, e) -> {
            thread = t;
            throwable = e;
        });
        Runtime.getRuntime().addShutdownHook(new Thread(() ->
                System.out.println("发邮件通知" + thread.getName() + throwable.getMessage())));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("释放资源")));
        // 将钩子线程放到最开始，即使下面报错也能被执行。
        // int k = 10 / 0;
        int i = 0;
        while (true) {
            i++;
            // 这样，即使这里报异常也会被处理到
            int k = 10 / 0;
            try {
                Thread.sleep(1000);
                System.out.println("task running...");
                if (i == 3) {
                    int j = i / 0;
                }
            } catch (Exception e) {
                // 这里可能会导致e.getMessage的时候NPE
                break;
            }
        }
    }
}