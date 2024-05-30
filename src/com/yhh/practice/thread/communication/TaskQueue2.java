package com.yhh.practice.thread.communication;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.*;

/**
 * synchronized
 *
 * @author hyh
 * @date 2024/4/23
 */
public class TaskQueue2 {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue<String> que = new LinkedList<>();

    //synchronized锁住的是this对象
    public void addTask(String task) throws InterruptedException {
        lock.lock();
        try {
            System.out.println(Thread.currentThread() + " get lock...");
            que.add(task);
            condition.signalAll();
            System.out.println(Thread.currentThread() + " release lock...");
        } finally {
            lock.unlock();
        }
    }

    //synchronized锁住的是this对象
    public String getTask() throws InterruptedException {
        lock.lock();
        System.out.println(Thread.currentThread() + " get lock...");
        try {
            while (que.isEmpty()) {
                condition.await();
                System.out.println(Thread.currentThread() + "try to get lock again");
            }
        } finally {
            lock.unlock();

        }
        return que.remove();
    }

    public static void main(String[] args) {
        TaskQueue2 taskQueue = new TaskQueue2();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    String task = taskQueue.getTask();
                    System.out.println("current task: " + task);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t2 = new Thread(() -> {
            String s = "t-" + Math.random();
            try {
                taskQueue.addTask(s);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
    }
}
