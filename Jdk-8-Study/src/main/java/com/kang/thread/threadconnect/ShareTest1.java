package com.kang.thread.threadconnect;

import java.util.ArrayList;

public class ShareTest1 {
    static int i = 0;
    // 100、100的加，看看代码能不能去内存中刷一次
    // 到600以上的时候才开始去打印i的值，但是也是随机打印
    private static int count = 600;
    // 面试题：为什么在某个阈值之前不可以打印i值，但是到了某个阈值之后可以打印？
    // 讲讲其中的过程。

    public static void main(String[] args) {
        // 消费者线程
        new Thread(() -> {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 1; j <= count; j++) {
                list.add(j);
            }

            while (true) {
                if (list.contains(i)) {
                    System.out.println("消费者线程消费, i =" + i);
                    break;
                }
            }
        }, "consumer1").start();

        // 生产者线程
        Thread t1 = new Thread(() -> {
            mySleep(1000000000);
            // 副本
            for (int x = 0; x <= count; x++) {
                i = x;
            }
        }, "t1");
        t1.start();
    }

    /**
     * 自定义休眠
     *
     * @param timout 纳秒
     */
    public static void mySleep(long timout) {
        long start = System.nanoTime();
        long end;
        do {
            end = System.nanoTime();
        } while (start + timout >= end);
    }
}
