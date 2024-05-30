package com.yhh.practice.thread.pool;

import java.util.UUID;
import java.util.concurrent.*;

/**
 * @author hyh
 * @date 2024/4/25
 */
public class FutureAndPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(3);

        Callable<String> task2 = new Task2();
        Future<String> future = es.submit(task2);
        System.out.println(future.get());

        es.shutdown();

    }

}

class Task2 implements Callable<String> {

    @Override
    public String call() throws Exception {
        return UUID.randomUUID().toString();
    }

}

