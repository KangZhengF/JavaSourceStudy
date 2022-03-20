package com.kang.thread.threadconnect;

public class ShareTest {
    static int i = 0;
    static Object obj = new Object();

    public static void main(String[] args) {
        // 消费者线程
        new Thread(() -> {
            while (true) {
                // 有哪些措施可以拿到这个i值呢
                // 1. 加休眠方法
                // 2. 加同步代码块
                // 3. 加打印代码
                // 4. io file = new File()也可以
                /* 总结一下：
                    synchronized：可见性，有序性，原子性。
                    volatile：可见性，防止指令重排，原子性。
                 */
                // 加上这句out就可以拿到了
//                System.out.println("sss");
                // 加上找个synchronized也可以拿到
                synchronized (obj) {
                    // 去掉这个sync块就不可以打印了，放到if块下面也可以打印
                }
                // 这里读的实际上是一个变量副本
                // 这里即使再加一个Thread.sleep(0)也能够打印出来
                if (i == 1) {
                    System.out.println("消费者线程消费, i =" + i);
                    break;
                }
            }
        }, "consumer1").start();

        // 生产者线程
        Thread t1 = new Thread(() -> {
            mySleep(1000000000);
            // 副本
            i = 1;
        }, "t1");
        t1.start();
        // 消费者线程
        Thread t2 = new Thread(() -> {
            // 这里只要在t1启动之后再启动就可以拿到i的值
            mySleep(2000000000);
            System.out.println(Thread.currentThread().getName() + "i = " + i);
        }, "consumer2");
        t2.start();
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
