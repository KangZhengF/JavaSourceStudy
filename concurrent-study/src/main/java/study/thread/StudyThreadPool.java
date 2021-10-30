package study.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用线程池
 *
 * @author 康正锋
 * @date 2021/10/26
 */
public class StudyThreadPool {
    private static AtomicInteger threadCount = new AtomicInteger(0);

    static class MyTask3 implements Runnable {
        private static final int TOTAL_TICKETS = 100000;
        private static int tickets = 0;

        @Override
        public void run() {
            while (tickets < TOTAL_TICKETS) {
                System.out.println(Thread.currentThread().getName() + "卖出第" + (++tickets) + "张票");
            }
        }
    }

    public static void main(String[] args) {
        int queueCapacity = 1;
        // 参数1：核心线程数
        int corePoolSize = 2;
        // 参数2：最大线程数
        int maximumPoolSize = 5;
        // 参数3：(最大线程数-核心线程数)的线程的存活时间
        long keepAliveTime = 2L;
        // 参数4：存活时间的单位
        TimeUnit timeUnit = TimeUnit.MINUTES;
        // 参数5：工作队列
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(queueCapacity);
        // 参数6：线程工厂
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "xxx线程池-线程" + threadCount.getAndIncrement());
            }
        };
        // 参数7：拒绝策略
        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
                                                                        timeUnit, workQueue, threadFactory, handler);
        MyTask3 myTask3 = new MyTask3();
        threadPoolExecutor.execute(myTask3);
        threadPoolExecutor.execute(myTask3);
        threadPoolExecutor.execute(myTask3);
        threadPoolExecutor.execute(myTask3);
        threadPoolExecutor.execute(myTask3);
        threadPoolExecutor.execute(myTask3);
        threadPoolExecutor.execute(myTask3);
        //不关闭线程池的话程序会无法停下来
        threadPoolExecutor.shutdown();
    }
}
