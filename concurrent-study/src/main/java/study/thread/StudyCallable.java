package study.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Callable接口的使用
 *
 * @author 康正锋
 * @date 2021/10/26
 */
public class StudyCallable {
    static class MyTask2 implements Callable<Integer> {
        private static int TOTAL_TICKETS = 100;
        private static final int LIMIT_TICKETS = 0;

        @Override
        public Integer call() throws Exception {
            while (LIMIT_TICKETS < TOTAL_TICKETS) {
                System.out.println(Thread.currentThread().getName() + "还剩" + (--TOTAL_TICKETS) + "张票");
            }
            return TOTAL_TICKETS;
        }
    }

    public static void main(String[] args) throws Exception{
        //这是一段有并发问题的代码，这里只是为了描述多线程实现方式，并非为了写出正确的并发代码
        MyTask2 myTask2 = new MyTask2();
        FutureTask<Integer> futureTask1 = new FutureTask<>(myTask2);
        FutureTask<Integer> futureTask2 = new FutureTask<>(myTask2);
        FutureTask<Integer> futureTask3 = new FutureTask<>(myTask2);
        Thread thread1 = new Thread(futureTask1, "线程1");
        Thread thread2 = new Thread(futureTask2, "线程2");
        Thread thread3 = new Thread(futureTask3, "线程3");
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println(futureTask1.get());
        System.out.println(futureTask1.get());
        System.out.println(futureTask1.get());
    }
}
