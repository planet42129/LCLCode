package com.yhh.practice.thread.pool;

import java.util.concurrent.*;

/**
 * @author hyh
 * @date 2024/4/14
 */
public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(3, 5,
                1L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 9; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "===>在办理业务");
            });
        }
    }
}
