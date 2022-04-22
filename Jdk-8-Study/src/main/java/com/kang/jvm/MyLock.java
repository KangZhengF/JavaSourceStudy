package com.kang.jvm;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * MyLock class
 *
 * @author 康正锋
 * @date 2022/04/22
 */
public class MyLock extends AbstractQueuedSynchronizer {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Condition condition = lock.newCondition();
        condition.await();
        condition.signal();
        lock.lock();
    }
}
