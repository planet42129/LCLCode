package com.yhh.practice.basic;

import java.util.Scanner;

/**
 * @author hyh
 * @date 2024/5/30
 */
public class InAndOut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        float percent = (float) (n2 - n1) / n1;
        System.out.printf("percent = %.2f%%", percent * 100);

    }
}
