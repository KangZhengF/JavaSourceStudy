package study.thread;

/**
 * 学习Thread类的继承
 *
 * @author 康正锋
 * @date 2021/10/26
 */
public class StudyThread {
    private static final int TOTAL_TICKETS = 1000;
    private static int tickets = 0;

    static class MyThread extends Thread {
        public MyThread() {}
        public MyThread(String threadName) {
            setName(threadName);
        }

        @Override
        public void run() {
            while (tickets < TOTAL_TICKETS) {
                System.out.println(Thread.currentThread().getName() + "卖出第" + (++tickets) + "张票");
            }
        }
    }

    public static void main(String[] args) {
        //这是一段有并发问题的代码，这里只是为了描述多线程实现方式，并非为了写出正确的并发代码
        MyThread myThread1 = new MyThread("线程1");
        MyThread myThread2 = new MyThread("线程2");
        MyThread myThread3 = new MyThread("线程3");
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}
