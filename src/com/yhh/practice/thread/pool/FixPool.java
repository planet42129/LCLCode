package com.yhh.practice.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author hyh
 * @date 2024/4/25
 */
public class FixPool {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        //es.submit(task1);
        for (int i = 0; i < 6; i++) {
            es.submit(new Task("-" + i));
//            Future<?> submit = es.submit(new Task("-" + i)); //其返回值是Future
        }
        es.shutdown();

    }

}

class Task implements Runnable {
    private String name;

    public Task() {
    }

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Start task" + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("End task " + name);
    }
}
