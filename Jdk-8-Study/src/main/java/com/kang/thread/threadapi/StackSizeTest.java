package com.kang.thread.threadapi;

public class StackSizeTest {
    private static int COUNT = 0;
    public static void main(String[] args) {
        // 结论，在子线程中，貌似栈的深度更深一点
        StackSizeTest stackSizeTest = new StackSizeTest();
        try {
            // main线程压栈 ----> stack length = 21557
//            stackSizeTest.count();
        } catch (Error e) {
            e.printStackTrace();
            System.out.println(">>>>main stack length = " + COUNT);
        }

        new Thread(() -> {
            try {
                // 子线程压栈测试 >>>>子线程 stack length = 37949
                stackSizeTest.count();
            } catch (Error e) {
                e.printStackTrace();
                System.out.println(">>>>子线程 stack length = " + COUNT);
            }
        }).start();
    }

    private void count() {
        COUNT++;
        count();
    }
}
