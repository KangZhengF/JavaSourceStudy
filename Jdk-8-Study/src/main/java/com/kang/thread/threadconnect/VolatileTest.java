package com.kang.thread.threadconnect;

/**
 * 美团面试题
 */
public class VolatileTest {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (true) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread t1 = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread t2 = new Thread(() -> {
                b = 1;
                y = a;
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            String ret = "第" + i + "次（" + x + "," + y + ")";
            if (x == 0 && y == 0) {
                break;
            }
            System.out.println(ret);
            /*
             * xy可能是什么值？
             * 1. t1先跑完，t2后跑完：x=0，y=1
             * 2. t2先跑完，t1后跑完：x=1，y=0
             * 3. t1、t2交替执行：x=1，y=1
             * 4. x=0，y=0？？会出现吗？一定会
             */
        }
    }
}
