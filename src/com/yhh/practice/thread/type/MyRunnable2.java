package com.yhh.practice.thread.type;

/**
 * @author hyh
 * @date 2024/4/12
 */
public class MyRunnable2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("MyRunnable2****" + i);
        }
    }
}
