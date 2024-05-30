package com.yhh.practice.thread.lock;

/**
 * @author hyh
 * @date 2024/4/24
 */
public class DeadLockTest {
    private static int a = 0;
    private static int b = 0;
    private final Object lockA = new Object();
    private final Object lockB = new Object();

    public void add(int m) {
        System.out.println(Thread.currentThread().getName() + " try to get lockA...");
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + " got lockA...");
            a += m;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " try to get lockB...");
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + " got lockB...");
                b += m;
            }
        }
    }
    public void dec(int m) {
        System.out.println(Thread.currentThread().getName() + " try to get lockB...");
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + " got lockB...");
            a -= m;
            System.out.println(Thread.currentThread().getName() + " try to get lockA...");
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + " got lockA...");
                b -= m;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadLockTest obj = new DeadLockTest();
        Thread t1 = new Thread(()->{
            obj.add(1);
        }, "线程1");
        Thread t2 = new Thread(()->{
            obj.dec(10);
        }, "线程2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}

class Calculater {

}