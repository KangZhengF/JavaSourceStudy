package com.kang.thread.threadapi;

import java.io.IOException;

public class SafeThreadTest {
    public static void main(String[] args) {
        new Thread(new SafeRunnable() {
            @Override
            public void protectMethod() {
                System.out.println(">>>>>>this is safe method");
                // 阻止退出虚拟机
//                System.exit(0);

                try {
                    // 阻止执行Runtime时的命令
//                    Runtime.getRuntime().exec("notepad.exe");
                    Runtime.getRuntime().exec("cmd.exe /c del d:\\smart.txt /q");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        try {
            // 如果Runtime方法能够执行，则睡眠会被打断。
            // 如果不能执行，则能一直睡眠
            Thread.sleep(Integer.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
