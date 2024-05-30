package com.yhh.practice.thread.type;

/**
 * @author hyh
 * @date 2024/4/12
 */
public class TestRunnable {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        MyRunnable2 myRunnable2 = new MyRunnable2();
        //线程和任务解耦合：通过传不同的参数，给同一个线程传不同的任务，相当于张三既可以干打水的活也能干取快递的活
//        Thread thread = new Thread(myRunnable);
        Thread thread = new Thread(myRunnable2);
        thread.start();
    }
}
