package com.yhh.practice.basic;

/**
 * @author hyh
 * @date 2024/5/30
 */
public class CalPI {
    public static void main(String[] args) {
        double PI;
        double sum = 0.0;
        double item = 1.0;
        for (int i = 1; i < 100000000; i++) {
            sum += item;
            item = Math.pow(-1, i) * (1.0 / (2 * i + 1));
        }
        PI = sum * 4;
        System.out.println("PI = " + PI);
    }
}
