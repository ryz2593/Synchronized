package com.ryz.synchronize;

/**
 *
 * @author ryz2593
 * @date 2019/3/28
 * 对象锁示例， 代码块形式
 */
public class SynchronizedObjectCodeBlock2 implements Runnable{
    static SynchronizedObjectCodeBlock2 instance = new SynchronizedObjectCodeBlock2();
    Object lock1= new Object();
    Object lock2 = new Object();
    static int i = 0;

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("我是lock1， 我叫 " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " lock1部分运行结束");
        }

//        synchronized (lock2) {
//            System.out.println("我是lock2， 我叫 " + Thread.currentThread().getName());
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + " lock2部分运行结束");
//        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {}
        System.out.println(i);
    }
}
