package com.yhh.practice.sort;

import java.util.Arrays;

/**
 * @author hyh
 * @date 2024/4/30
 */
public class QuickSort6 {
    public static void main(String[] args) {
        int[] array = {6,72,113,11,23};
        quickSort(array, 0, array.length -1);
        System.out.println("排序后的结果");
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(nums, left, right);
            quickSort(nums, left, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];//选择最右边元素作为基准值
        int pointer = left;
        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, pointer);// 将小于等于基准值的元素交换到左边
                pointer++;
            }
            System.out.println(Arrays.toString(nums));
        }
        swap(nums, right, pointer);// 将基准值交换到正确的位置
        return pointer;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
