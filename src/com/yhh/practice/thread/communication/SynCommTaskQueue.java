package com.yhh.practice.thread.communication;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hyh
 * @date 2024/4/24
 */
public class SynCommTaskQueue {
    Queue<String> que = new LinkedList<>();

    // synchronized 这里修饰的是同步方法，锁住的对象是this实例
    public synchronized String getTask() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " got lock. ");
        while (que.isEmpty()) {
            this.wait();// 当前线程释放锁，进入等待状态
            // 线程被唤醒之后，重新尝试获取this锁
            System.out.println(Thread.currentThread().getName() + " wake. ");
        }

        System.out.println(Thread.currentThread().getName() + " has released lock. ");
        return que.poll();
    }

    public synchronized void addTask(String task) {
//        System.out.println(Thread.currentThread().getName() + " got lock. ");
//        System.out.println(Thread.currentThread().getName() + " add a task. ");
        que.add(task);
        this.notifyAll();//去唤醒等待这个锁对象的线程
//        System.out.println(Thread.currentThread().getName() + " has released lock. ");
        return;
    }

    public static void main(String[] args) throws InterruptedException {
        SynCommTaskQueue taskQueue = new SynCommTaskQueue();
        List<Thread> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Thread t = new Thread(()->{
                while (true) {
                    try {
                        String task1 = taskQueue.getTask();
                        System.out.println("task = " + task1);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }, "线程" + i);
            t.start();
            list.add(t);
        }

        Thread t0 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                String task = "task - " + (int)(Math.random() * 10) ;
                taskQueue.addTask(task);
                //线程0 每次添加一个任务就睡一会
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
            }
        }, "线程0");

        t0.start();
        t0.join();
        for (Thread t: list) {
            t.interrupt();
        }
    }

}
