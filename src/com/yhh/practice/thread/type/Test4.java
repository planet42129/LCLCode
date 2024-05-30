package com.yhh.practice.thread.type;

/**
 * @author hyh
 * @date 2024/4/22
 */
public class Test4 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread() + " start");
        Thread thread = new Thread(()->{
            System.out.println(Thread.currentThread() + " start");
            try {
                Thread.sleep(10);
                System.out.println(Thread.currentThread() + " end");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
        try {
            Thread.sleep(20);
            System.out.println(Thread.currentThread() + " end");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
