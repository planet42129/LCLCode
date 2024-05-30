package com.yhh.practice.thread.sleep;

/**
 * @author hyh
 * @date 2024/4/12
 */
public class ThreadSleep {
    public static void main(String[] args) {
        /*Thread t1 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println(1);
            }
        });
        t1.start();
        try {
            t1.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println(2);
            }
        });
        t2.start();*/
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(1);
            }

        });
        t1.start();
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println(2);
            }
        });
        t2.start();
    }
}
