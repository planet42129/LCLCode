package com.yhh.practice.thread.type;

/**
 * @author hyh
 * @date 2024/4/12
 */
public class TestLambda {
    public static void main(String[] args) {
//        Thread thread = new Thread(()->{
//            for (int i = 0; i < 100; i++) {
//                System.out.println("MyRunnable__" + i);
//            }
//        });
//        thread.start();

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("MyRunnable__" + i);
            }
        }).start();
    }
}
