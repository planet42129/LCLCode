package com.yhh.practice.thread.type;

/**
 * @author hyh
 * @date 2024/4/12
 */
public class TestThread {
    //main主线程
    //一共启动了4个线程
    //main myThread myThread2 垃圾回收机制（JVM）
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
    }
}
