package study.thread;

/**
 * 测试Runnable接口
 *
 * @author 康正锋
 * @date 2021/10/26
 */
public class StudyRunnable {
    static class MyTask1 implements Runnable {
        private static final int TOTAL_TICKETS = 1000;
        private static int tickets = 0;

        @Override
        public void run() {
            while (tickets < TOTAL_TICKETS) {
                System.out.println(Thread.currentThread().getName() + "卖出第" + (++tickets) + "张票");
            }
        }
    }

    public static void main(String[] args) {
        //这是一段有并发问题的代码，这里只是为了描述多线程实现方式，并非为了写出正确的并发代码
        MyTask1 myTask1 = new MyTask1();
        Thread thread1 = new Thread(myTask1);
        Thread thread2 = new Thread(myTask1);
        Thread thread3 = new Thread(myTask1);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
