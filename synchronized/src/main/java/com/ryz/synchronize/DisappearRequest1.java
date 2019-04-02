package com.ryz.synchronize;

/**
 *
 * @author ryz2593
 * @date 2019/3/28
 * 消失的请求数
 */
public class DisappearRequest1 implements Runnable{
    static DisappearRequest1 instance = new DisappearRequest1();

    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

    @Override
    //1. 在普通方法上加synchronized修饰
    //public synchronized void run(){
    public void run() {
        //2. 方法块上加synchronized
        //3. synchronized(DisappearRequest1.class)
        synchronized(DisappearRequest1.class) {
            for (int i1 = 0; i1 < 100000; i1++) {
                i++;
            }
        }
        //4. 类锁的第一种形式，static
//        method();

    }

    public static synchronized void method() {
        for (int i1 = 0; i1 < 100000; i1++) {
            i++;
        }
    }
}
