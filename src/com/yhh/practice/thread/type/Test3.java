package com.yhh.practice.thread.type;

/**
 * @author hyh
 * @date 2024/4/12
 */
public class Test3 {
    public static void main(String[] args) {
       /* Runnable runnable = new Runnable() {
          @Override
          public void run() {
            for (int i = 0; i < 100; i++) {
              System.out.println("MyRunnable__" + i);
            }
          }
        };
        Thread thread = new Thread(runnable);
        thread.start();*/
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("MyRunnable__" + i);
                }
            }
        });
        thread.start();
    }
}
