package com.yhh.practice.thread.lock;

import static com.yhh.practice.thread.lock.Counter.lock;

/**
 * @author hyh
 * @date 2024/4/23
 */
public class DeadLockThread extends Thread {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();
    private static int a = 10;
    private static int b = 10;

    public void add() throws InterruptedException {
        synchronized (lockA) {
            this.a++;
            Thread.sleep(10);
            synchronized (lockB) {
                this.b++;
            }
            System.out.println(Thread.currentThread() + "执行完毕");
        }
    }

    public void dec() {
        // 会造成死锁
        // 多线程持有不同的锁，各自尝试获取对方手里的锁，导致无限等待
/*        synchronized (lockA) {
            this.a-=10;
            synchronized (lockB) {
                this.b-=10;
            }
            System.out.println(Thread.currentThread() + "执行完毕");
        }*/
        //解决办法：获取锁的顺序要一致
        synchronized (lockA) {
            this.a -= 10;
            synchronized (lockB) {
                this.b -= 10;
            }
            System.out.println(Thread.currentThread() + "执行完毕");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadLockThread obj = new DeadLockThread();
        Thread t1 = new Thread(() -> {
            try {
                obj.add();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            obj.dec();
        });
        t1.start();
        t2.start();
    }
}

