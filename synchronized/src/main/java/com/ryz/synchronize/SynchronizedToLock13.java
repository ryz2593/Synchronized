package com.ryz.synchronize;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ryz2593
 * @date 2019/3/28
 *
 */
public class SynchronizedToLock13 {
    Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        SynchronizedToLock13 synchronizedToLock13 = new SynchronizedToLock13();
        synchronizedToLock13.method1();
        synchronizedToLock13.method2();
    }

    public synchronized void method1() {
        System.out.println("我是Synchronized形式的锁");

    }

    public void method2() {
        lock.lock();
        try{
            System.out.println("我是lock形式的锁");
        } finally {
            lock.unlock();
        }
    }
}
