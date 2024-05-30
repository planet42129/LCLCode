package com.yhh.practice.thread.interrupt;

/**
 * @author hyh
 * lxf多线程-中断线程
 * 1 对目标线程调用interrupt()方法可以请求中断一个线程，目标线程通过检测isInterrupted()标志获取自身是否已中断。
 * 如果目标线程处于等待状态，该线程会捕获到InterruptedException；
 * 2 目标线程检测到isInterrupted()为true或者捕获了InterruptedException都应该立刻结束自身线程。
 * @date 2024/4/22
 */
public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new MyThread();
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        t1.join();
        System.out.println("main end");
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        HelloThread helloThread = new HelloThread();
        helloThread.start();
        try {
            helloThread.join();// t线程等待hello线程执行完毕结束
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
        helloThread.interrupt();
    }
}

class HelloThread extends Thread{
    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

