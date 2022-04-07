package com.kang.thread.threadconnect;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 美团面试题
 */
public class VolatileTest {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static Unsafe getUnsafe() {
        Field field = null;
        try {
            field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

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
                //写屏障
                try {
                    //真正起作用的是反射底层用的cas技术，cas会在指令前加lock前缀。
                    Field field = VolatileTest.class.getDeclaredField("a");
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                VolatileTest.getUnsafe().storeFence();
                x = b;
            });
            Thread t2 = new Thread(() -> {
                b = 1;
                // 写屏障
                VolatileTest.getUnsafe().storeFence();
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
