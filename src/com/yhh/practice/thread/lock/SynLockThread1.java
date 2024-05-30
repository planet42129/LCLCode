package com.yhh.practice.thread.lock;

import static com.yhh.practice.thread.lock.Counter.lock;

/**
 * @author hyh
 * @date 2024/4/23
 */
public class SynLockThread1 extends Thread {
    public static void main(String[] args) throws InterruptedException {
        AddThread addThread = new AddThread();
        DecThread decThread = new DecThread();
        addThread.start();
        decThread.start();
        addThread.join();
        decThread.join();
        System.out.println("main end, Counter.count = " + Counter.count);
    }
}

class Counter{
    public static int count = 0;
    public static final Object lock = new Object();
}
class AddThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (lock) {//获取锁
                Counter.count += 1;
            }//释放锁
        }
    }
}
class DecThread extends Thread{
    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            synchronized(lock) {
                Counter.count -= 1;
            }
        }
    }
}
