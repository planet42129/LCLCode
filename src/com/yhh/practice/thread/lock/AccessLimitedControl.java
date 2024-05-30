package com.yhh.practice.thread.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore 信号量，
 * 如果要对某一受限资源进行限流访问，可以使用Semaphore，保证同一时间最多N个线程访问受限资源
 *
 * @author hyh
 * @date 2024/4/25
 */
public class AccessLimitedControl {
    final Semaphore semaphore = new Semaphore(3);

    public void access() throws InterruptedException {
       if (semaphore.tryAcquire(3, TimeUnit.SECONDS)) {
           try {
               System.out.println(Thread.currentThread().getName() + "--"+ UUID.randomUUID().toString());
               Thread.sleep(1000);
           } finally {
               semaphore.release();
           }
       }
    }
 /*   public void access() throws InterruptedException {
        semaphore.acquire();
        try {
            System.out.println(Thread.currentThread().getName() + "--"+ UUID.randomUUID().toString());
            Thread.sleep(1000);
        } finally {
            semaphore.release();
        }
    }*/

    public static void main(String[] args) throws InterruptedException {
        AccessLimitedControl accessLimitedControl = new AccessLimitedControl();
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(()->{
                try {
                    accessLimitedControl.access();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            t.start();
            list.add(t);
        }
        Thread.sleep(5000);
        for (Thread t:
             list) {
            t.interrupt();
        }
    }
}
