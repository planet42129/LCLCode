package com.yhh.practice.thread.communication;

import java.util.LinkedList;
import java.util.Queue;

/**
 * synchronized
 * @author hyh
 * @date 2024/4/23
 */
public class TaskQueue {
    private Queue<String> que = new LinkedList<>();

    //synchronized锁住的是this对象
    public synchronized void addTask(String task) {
        System.out.println(Thread.currentThread() + " get lock...");
        que.add(task);
        this.notify();//去唤醒等待this锁的线程
        System.out.println(Thread.currentThread() + " release lock...");

    }

    //synchronized锁住的是this对象
    public synchronized String getTask() throws InterruptedException {
        System.out.println(Thread.currentThread() + " get lock...");
        while (que.isEmpty()) {
            //wait方法必须在当前获取的锁对象上调用
            this.wait();//线程释放this锁，进入等待状态
            //线程尝试获取this锁对象
            System.out.println(Thread.currentThread() + "try to get lock again");

        }
        return que.remove();
    }

    public static void main(String[] args) {
        TaskQueue taskQueue = new TaskQueue();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    String task = taskQueue.getTask();
                    System.out.println("current tack: " + task);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t2 = new Thread(() -> {
            String s = "t-" + Math.random();
            taskQueue.addTask(s);
        });
        t1.start();
        t2.start();
    }
}
