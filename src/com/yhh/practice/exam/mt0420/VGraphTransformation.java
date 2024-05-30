package com.yhh.practice.exam.mt0420;

import java.util.Scanner;

public class VGraphTransformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();

        int swaps = minSwapsToVGraph(a);
        System.out.println(swaps);
    }

    private static int minSwapsToVGraph(int[] a) {
        int n = a.length;
        int[] left = a.clone();
        int[] right = a.clone();
        int maxIndex = 0;
        // 找到最大值的索引
        for (int i = 1; i < n; i++) {
            if (a[i] > a[maxIndex]) {
                maxIndex = i;
            }
        }
        int swaps = 0;
        // 将左侧变为递减序列
        for (int i = maxIndex; i > 0; i--) {
            if (left[i] < left[i - 1]) {
                swap(left, i, i - 1);
                swaps++;
            }
        }
        // 将右侧变为递增序列
        for (int i = maxIndex; i < n - 1; i++) {
            if (right[i] > right[i + 1]) {
                swap(right, i, i + 1);
                swaps++;
            }
        }
        return swaps;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
