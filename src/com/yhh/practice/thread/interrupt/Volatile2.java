package com.yhh.practice.thread.interrupt;

/**
 * @author hyh
 * 另一个常用的中断线程的方法是设置标志位。
 * 通过标志位判断需要正确使用volatile关键字；
 * volatile关键字解决了共享变量在线程间的可见性问题。
 * @date 2024/4/22
 */
public class Volatile2 {
    public static void main(String[] args) throws InterruptedException {
        Hello t = new Hello();
        t.start();
        Thread.sleep(10);
        /*
        main线程p1的代码会将running标志位修改为false，此时HelloThread线程执行的代码是p3时，
        HelloThread线程就会到Terminated状态，
        但如果正在执行 p4或p5，而main线程又并发的执行了p2的代码，那么HelloThread线程就会永远执行。
         */
        t.running = false;  //p1
//        t.join();
        t.running = true;   //p2
    }
}

class Hello extends Thread {
    //volatile修饰的变量是线程中的共享变量，当一个线程修改了共享变量的值，其他线程能够立刻看到修改后的值。
    public volatile boolean running = true;

    @Override
    public void run() {
        int n = 0;
        while (running) {  //p3
            n++;  //p4
            System.out.println(n + " hello");//p5
        }
        System.out.println("end");
    }
}
